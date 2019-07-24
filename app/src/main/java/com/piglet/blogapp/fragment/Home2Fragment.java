package com.piglet.blogapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piglet.blogapp.R;
import com.piglet.blogapp.adapter.BlogRvAdapter;
import com.piglet.blogapp.adapter.FileRVAdapter;
import com.piglet.blogapp.base.BaseFragment;
import com.piglet.blogapp.bean.ArticleListBean;
import com.piglet.blogapp.bean.FileBean;
import com.piglet.blogapp.net.Call;
import com.piglet.blogapp.net.RequestUtils;
import com.piglet.blogapp.view.MprogressDialog;
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
public class Home2Fragment extends BaseFragment {
    Context context;
    Unbinder unbinder;
    @BindView(R.id.rv_date)
    RecyclerView rvDate;
    @BindView(R.id.rv_blogs)
    RecyclerView rvBlogs;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    @BindView(R.id.empty)
    EmptyLayout empty;
    List<String> fileList = new ArrayList<>();
    boolean isLoading;
    int page;
    List<ArticleListBean.DataBean.RecordsBean> dataList = new ArrayList<>();
    private BlogRvAdapter blogRvAdapter;
    //文章归档adapter
    FileRVAdapter fileRVAdapter;
    String selectDate = "";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_homt2, container, false);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        rvDate.setLayoutManager(new LinearLayoutManager(context));
        rvDate.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        blogRvAdapter = new BlogRvAdapter(context, dataList);
        rvBlogs.setLayoutManager(new LinearLayoutManager(context));
        rvBlogs.setAdapter(blogRvAdapter);
        fileRVAdapter = new FileRVAdapter(context, fileList);
        fileRVAdapter.setOnClickLinsten(new FileRVAdapter.OnClickLinsten() {
            @Override
            public void OnClick(String date) {
                selectDate = date;
                getDate(true,true);
            }
        });
        srl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                getDate(false,false);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                getDate(true,false);
            }
        });
        rvDate.setAdapter(fileRVAdapter);
        empty.setAllButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFileList();
            }
        });
        getFileList();
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
     * 获取归档列表
     */
    private void getFileList() {
        fileList.clear();
        RequestUtils.file(new Call<FileBean>(context) {
            @Override
            public void onSuccess(FileBean result) {

                if (result.getSuccess()) {
                    if (result.getData().size() == 0) {
                        empty.showEmpty();
                    } else {
                        fileList.addAll(result.getData());
                        selectDate = fileList.get(0);
                        getDate(true,false);
                        fileRVAdapter.notifyDataSetChanged();
                    }
                } else {
                    empty.showError();
                }
            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {
                empty.showError();
            }
        });
    }


    /**
     * 获取文章列表
     */
    public void getDate(final boolean isClear,boolean isShowDialog) {
        if (!isLoading) {
            if (isClear) {
                page = 1;
            } else {
                page++;
            }
            Map<String, String> map = new HashMap<>();
            map.put("current", page + "");
            map.put("size", "10");
            map.put("date", selectDate);
            map.put("tag", "");
            isLoading = true;
            RequestUtils.articles(map, new Call<ArticleListBean>(context,isShowDialog) {
                @Override

                public void onSuccess(ArticleListBean result) {

                    isLoading = false;
                    if (result.getSuccess()) {
                        List<ArticleListBean.DataBean.RecordsBean> records = result.getData().getRecords();
                        hideLodingLayout(empty, srl, records, isClear, dataList);
                        dataList.addAll(records);
                        blogRvAdapter.notifyDataSetChanged();
                    } else {
                        showErrLayout(empty, srl, isClear);
                    }

                }

                @Override
                public void onFailure(Throwable e, String errorMsg) {

                    hidDialog();
                    showErrLayout(empty, srl, isClear);
                    isLoading = false;
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
