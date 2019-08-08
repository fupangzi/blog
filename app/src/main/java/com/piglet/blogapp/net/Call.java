package com.piglet.blogapp.net;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;


import com.google.gson.Gson;
import com.piglet.blogapp.view.MprogressDialog;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * BaseObserver
 * 请求重写 加入判断有无网络等功能
 * @author Administrator
 * @date 2019/1/16 0016
 */
public abstract class Call<T> implements Observer<T> {
    private static final String TAG = "Call";
    private boolean mShowDialog;
    private MprogressDialog progressDialog;
    private Context context;
    private Disposable disposable;
    public Call(Context context) {
        // this.context = context;
        this(context, false);
    }
    public Call() {
    }
    public Call(Context context, boolean mShowDialog) {
        this.mShowDialog = mShowDialog;
        this.context = context;

    }


    /**
     * 取消请求
     */
    public void cancelRequest(){
        Log.e(TAG,"切断请求");
        if(disposable!=null&&disposable.isDisposed()){
            disposable.dispose();
        }
    }

    @Override
    public void onError(Throwable e) {
        //出错隐藏弹框和切断连接
        if (disposable.isDisposed()) {
            disposable.dispose();
        }
        hidDialog();
        onFailure(e, RxExceptionUtil.exceptionHandler(e));
    }

    @Override
    public void onComplete() {
        //加载完成隐藏dialog和切断rxjava的连接
        if (disposable.isDisposed()) {
            disposable.dispose();
        }
        hidDialog();
    }

    @Override
    public void onSubscribe(Disposable d) {
        //rxjava初始化方法用来初始化一些值
        //用来切断rxjava的连接
        this.disposable = d;
        if (!isConnected(context)) {
            //没有联网
            if (d.isDisposed()) {
                d.dispose();
            }
        } else {
            //联网判断需不需要显示加载框
            if (progressDialog == null && mShowDialog == true) {
                progressDialog = new MprogressDialog(context);
                progressDialog.show();
            }
        }
    }

    @Override
    public void onNext(T t) {
        //跟后台约定好了可以在这封装一下
        onSuccess(t);
    }


    public abstract void onSuccess(T result);

    public abstract void onFailure(Throwable e, String errorMsg);

    public void hidDialog() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ( (Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (progressDialog != null && mShowDialog == true) {
                            progressDialog.dismiss();
                        }
                        progressDialog=null;
                    }
                });


            }
        }).start();


    }


    /**
     * 是否有网络连接，不管是wifi还是数据流量
     *
     * @param context
     * @return
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return false;
        }
        boolean available = info.isAvailable();
        return available;
    }

}
