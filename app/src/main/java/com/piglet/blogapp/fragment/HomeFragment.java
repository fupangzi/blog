package com.piglet.blogapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piglet.blogapp.R;
import com.piglet.blogapp.WebViewActivity;
import com.piglet.blogapp.adapter.BlogRvAdapter;
import com.piglet.blogapp.base.BaseFragment;
import com.piglet.blogapp.bean.ArticleListBean;
import com.piglet.blogapp.net.Call;
import com.piglet.blogapp.net.RequestUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xm.emptylayout.EmptyLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * HomeFragment
 *
 * @author Administrator
 * @date 2019/7/23 0023
 */
public class HomeFragment extends BaseFragment {
    Context context;
    @BindView(R.id.rv_blogs)
    RecyclerView rvBlogs;
    Unbinder unbinder;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    @BindView(R.id.empty)
    EmptyLayout empty;
    private int page;
    List<ArticleListBean.DataBean.RecordsBean> dataList = new ArrayList<>();
    private BlogRvAdapter blogRvAdapter;
    private  boolean isLoading;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_homt, container, false);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        blogRvAdapter = new BlogRvAdapter(context, dataList);
        blogRvAdapter.setOnClickListener(new BlogRvAdapter.OnClickListener() {
            @Override
            public void onClick(int i) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("url", "https://github.com/He-Polaris/vblog-web");
                startActivity(intent);
            }
        });
        rvBlogs.setLayoutManager(new LinearLayoutManager(context));
        rvBlogs.setAdapter(blogRvAdapter);
        //设置null页面刷新监听事件
        empty.setAllButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDate(true);
            }
        });

        //设置下拉监听事件
        srl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                getDate(false);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                getDate(true);
            }
        });
        getDate(true);
        empty.showLoading();



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    /**
     * 获取首页数据
     */
    public void getDate(final boolean isClear) {
        if(!isLoading){
            if (isClear) {
                page = 1;

            } else {
                page++;
            }
            Map<String, String> map = new HashMap<>();
            map.put("current", page + "");
            map.put("size", "10");
            // map.put("date","10");
            isLoading=true;
            RequestUtils.articles(map, new Call<ArticleListBean>(context) {
                @Override
                public void onSuccess(ArticleListBean result) {
                    isLoading=false;
                    if (result.getSuccess()) {
                        List<ArticleListBean.DataBean.RecordsBean> records = result.getData().getRecords();
                        hideLodingLayout(empty,srl,records,isClear,dataList);
                        dataList.addAll(records);
                        blogRvAdapter.notifyDataSetChanged();
                    }else{
                        showErrLayout(empty,srl,isClear);
                    }

                }

                @Override
                public void onFailure(Throwable e, String errorMsg) {
                    showErrLayout(empty,srl,isClear);
                    isLoading=false;
                }
            });
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
