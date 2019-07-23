package com.piglet.blogapp.net;

import com.piglet.blogapp.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitManager
 *
 * @author Administrator
 * @date 2019/1/16 0016
 */
public class RetrofitManager {
    //baseur
    private static final int DEFAULT_TIME=10;
    private static RetrofitManager retrofitManager;



    private  RetrofitManager(){

    }
    //单例模式
    public static  RetrofitManager getRetrofitManager(){
        if(retrofitManager==null){
            synchronized (RetrofitManager.class){
                if(retrofitManager==null){
                    retrofitManager=new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }


    //初始化值
    public  Retrofit initRetrofit(){
        //初始化okhttp
        OkHttpClient.Builder builder=new OkHttpClient().newBuilder()
                .readTimeout(DEFAULT_TIME,TimeUnit.SECONDS)//设置读取时间
                .connectTimeout(DEFAULT_TIME,TimeUnit.SECONDS)//设置请求时间
                .writeTimeout(DEFAULT_TIME,TimeUnit.SECONDS)//设置写入时间
                .addInterceptor(new LogInterceptor())//增加输出log
                .retryOnConnectionFailure(true);//出现问题是否重新链接
        if(BuildConfig.DEBUG){
            builder.addInterceptor(new HttpLoggingInterceptor());
        }
        OkHttpClient client = builder.build();
        return new Retrofit.Builder()
                .baseUrl(NetApi.BASEURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())//增加gson解析
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//增加rxjava回调
                .build();
    }

    //返回一个泛型
    public static <T>T getNetService(Class<T> netApi){
        return getRetrofitManager().initRetrofit().create(netApi);
    }
    //针对这个项目的api返回
    public static NetService getNetService(){
        return getRetrofitManager().initRetrofit().create(NetService.class);
    }


}
