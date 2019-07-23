package com.piglet.blogapp.base;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.piglet.blogapp.R;
import com.piglet.blogapp.utils.StatusBarUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xm.emptylayout.EmptyLayout;

import java.util.List;

import butterknife.ButterKnife;

/**
 * BaseActivity
 *
 * @author Administrator
 * @date 2019/6/18 0018
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
      //  setStatusBar(Color.WHITE);
        StatusBarUtil.setStatusBarFullTransparent(this);
        super.onCreate(savedInstanceState);
        StatusBarUtil.addStatusViewWithColor(this,getResources().getColor(R.color.yelloTitle));

    }



    /**
     * 更改状态栏颜色
     *
     * @param color rgb颜色
     */
    protected void setStatusBar(@ColorInt int color) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isLightColor(color)) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }
        }
    }

    /**
     * 判断状态栏颜色
     *
     * @param color rgb颜色
     * @return
     */
    private boolean isLightColor(@ColorInt int color) {
        return ColorUtils.calculateLuminance(color) >= 0.5;
    }



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



}
