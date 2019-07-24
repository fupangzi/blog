package com.piglet.blogapp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xm.emptylayout.EmptyLayout;

import java.util.List;


public abstract class BaseFragment extends android.support.v4.app.Fragment {
   /* public Context mContext;
    public BaseFragment(Context context){
        mContext = context;

    }
*/

   public Context mContext;

   //页面是否加载完成
   private boolean isCreate;
   //是否加载过
   private boolean isLasyLoaded;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return initView(inflater,container,savedInstanceState);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isCreate=true;
        initData(savedInstanceState);
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad();
    }

    /*
    * 在此进行View的初始化操作
    * **/
    public abstract View initView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState);

    /*
    * 在Activity创建完成后进行数据的初始化
    * @param:savedInstanceState
    * **/
    public abstract void initData(Bundle savedInstanceState);



    public void lazyLoad(){
        if(getUserVisibleHint()&&isCreate&&!isLasyLoaded){
            onLazyLoad();
            isLasyLoaded=true;
        }
    }

    public  void onLazyLoad(){

    };


    /**
     * 刷新请求加载隐藏控件
     *
     * @param emptyLayout        nullview
     * @param smartRefreshLayout 下拉view
     * @param isDropDown          是否下拉
     * @param isNull             数据是否为null
     */
    public void hideLodingLayout(EmptyLayout emptyLayout, SmartRefreshLayout smartRefreshLayout, boolean isNull, boolean isDropDown) {
        if(isDropDown){
            if (isNull) {
                //请求成功但没有数据
                emptyLayout.showEmpty();
                smartRefreshLayout.finishRefresh(true);
            } else {
                //请求成功但没有数据
                showchildview(emptyLayout);
                smartRefreshLayout.finishRefresh(true);
            }
        }else{
            if (isNull) {
                smartRefreshLayout.finishLoadMoreWithNoMoreData();
            }
            smartRefreshLayout.finishLoadMore(true);
        }
    }

    /**
     * 刷新请求加载隐藏控件并清除list
     *
     * @param emptyLayout        nullview
     * @param smartRefreshLayout 下拉view
     * @param isDropDown          是否下拉
     * @param isNull             数据是否为null
     */
    public void hideLodingLayout(EmptyLayout emptyLayout, SmartRefreshLayout smartRefreshLayout, boolean isNull, boolean isDropDown, List<?> list) {
        if(isDropDown){
            list.clear();
            if (isNull) {
                //请求成功但没有数据
                emptyLayout.showEmpty();
                smartRefreshLayout.finishRefresh(true);
            } else {
                //请求成功但有数据
                showchildview(emptyLayout);
                smartRefreshLayout.finishRefresh(true);
            }
        }else{
            if (isNull) {
                smartRefreshLayout.finishLoadMoreWithNoMoreData();
            }
            smartRefreshLayout.finishLoadMore(true);
        }
    }


    /**
     * 刷新请求加载隐藏控件并清除list
     *
     * @param emptyLayout        nullview
     * @param smartRefreshLayout 下拉view
     * @param isDropDown          是否下拉
     * @param size                列表数据为几条
     */
    public void hideLodingLayout(EmptyLayout emptyLayout, SmartRefreshLayout smartRefreshLayout, int size, boolean isDropDown, List<?> list) {
        if(isDropDown){
            list.clear();
            if (size==0) {
                //请求成功但没有数据
                emptyLayout.showEmpty();
                smartRefreshLayout.finishRefresh(true);
            } else {
                //恢复没有更多数据
                smartRefreshLayout.setNoMoreData(false);
                //请求成功但有数据
                showchildview(emptyLayout);
                smartRefreshLayout.finishRefresh(true);
            }
        }else{
            if (size==0) {
                smartRefreshLayout.finishLoadMoreWithNoMoreData();
            }
            smartRefreshLayout.finishLoadMore(true);
        }
    }

    /**
     * 刷新请求加载隐藏控件并清除list
     *
     * @param emptyLayout        nullview
     * @param smartRefreshLayout 下拉view
     * @param isDropDown          是否下拉
     * @param dataList             返回的数据列表
     */
    public void hideLodingLayout(EmptyLayout emptyLayout, SmartRefreshLayout smartRefreshLayout, List<?> dataList, boolean isDropDown, List<?> list) {
        if(isDropDown){
            list.clear();
            if (dataList.size()==0) {
                //请求成功但没有数据
                emptyLayout.showEmpty();
                smartRefreshLayout.finishRefresh(true);
            } else {
                //恢复没有更多数据
                smartRefreshLayout.setNoMoreData(false);
                //请求成功但有数据
                showchildview(emptyLayout);
                smartRefreshLayout.finishRefresh(true);
            }
        }else{
            if (dataList.size()==0) {
                smartRefreshLayout.finishLoadMoreWithNoMoreData();
            }
            smartRefreshLayout.finishLoadMore(true);
        }
    }
    /**
     * 加载失败
     *
     * @param emptyLayout        nullview
     * @param smartRefreshLayout 下拉view
     * @param isDropDown          是否下拉
     */
    public void showErrLayout(EmptyLayout emptyLayout, SmartRefreshLayout smartRefreshLayout, boolean isDropDown) {
        if(emptyLayout!=null&&smartRefreshLayout!=null){
            if(isDropDown){
                emptyLayout.showError();
                smartRefreshLayout.finishRefresh(false);
            }else{
                smartRefreshLayout.finishLoadMore(false);
            }
        }



    }
    /**
     * 隐藏smartRefreshLayout
     *
     * @param smartRefreshLayout 下拉加载view
     * @param isSuccess          是否加载成功
     */
    public void hideSrl(SmartRefreshLayout smartRefreshLayout, boolean isSuccess) {
        if (smartRefreshLayout != null) {
            smartRefreshLayout.finishLoadMore(isSuccess);
        }
    }

    /**
     *  上拉加载更多隐藏加载控件
     * @param smartRefreshLayout 下拉加载view
     * @param isSuccess 是否加载成功
     * @param size 成功返回的数据条数
     */
    public void hideSrl(SmartRefreshLayout smartRefreshLayout, boolean isSuccess, int size) {
        if (smartRefreshLayout != null) {
            smartRefreshLayout.finishLoadMore(isSuccess);
            if (size==0) {
                smartRefreshLayout.finishLoadMoreWithNoMoreData();
            }

        }
    }

    /**
     * 第一次加载
     * @param view
     */
    public static  void showLoad(EmptyLayout view) {
        if (view != null && view.getIS_SHOW_CHILID() == 0) {
            view.showLoading();
        }
    }
    /**
     * 判断是否显示了子view
     * @param view
     */
    public static  void showchildview(EmptyLayout view) {
        if (view != null && view.getIS_SHOW_CHILID() == 0) {
            view.hide();
        }
    }



    public void setRv(RecyclerView rv){
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
