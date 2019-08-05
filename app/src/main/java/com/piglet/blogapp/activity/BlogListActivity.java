package com.piglet.blogapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.piglet.blogapp.R;
import com.piglet.blogapp.WebViewActivity;
import com.piglet.blogapp.adapter.BlogRvAdapter;
import com.piglet.blogapp.base.BaseActivity;
import com.piglet.blogapp.bean.ArticleListBean;
import com.piglet.blogapp.net.Call;
import com.piglet.blogapp.net.RequestUtils;
import com.piglet.blogapp.utils.StatusBarUtil;
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
import butterknife.OnClick;

public class BlogListActivity extends BaseActivity {

    @BindView(R.id.gd)
    ImageView gd;
    @BindView(R.id.rl_t)
    RelativeLayout rlT;
    @BindView(R.id.rv_blogs)
    RecyclerView rvBlogs;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    @BindView(R.id.empty)
    EmptyLayout empty;

    private int page;
    List<ArticleListBean.DataBean.RecordsBean> dataList = new ArrayList<>();
    private BlogRvAdapter blogRvAdapter;
    private  boolean isLoading;

    //上一个页面选中的tag标签
    private String tag="";
    //上一个页面选中的date时间
    private String selectDate="";


    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_list);
        ButterKnife.bind(this);
        intent=getIntent();
        if( intent.getStringExtra("tag")!=null){
            tag=intent.getStringExtra("tag");
        }
        if(intent.getStringExtra("date")!=null){
            selectDate=intent.getStringExtra("date");
        }
        initView();
    }

    /**
     * 初始化view
     */
    public void initView(){
        //设置跟状态栏一样的高
        rlT.setPadding(0, StatusBarUtil.getStatusBarHeight(this), 0, 0);
        blogRvAdapter = new BlogRvAdapter(this, dataList);
        blogRvAdapter.setOnClickListener(new BlogRvAdapter.OnClickListener() {
            @Override
            public void onClick(int i) {
                Intent intent = new Intent(BlogListActivity.this, WebViewActivity.class);
                intent.putExtra("url", "https://github.com/He-Polaris/vblog-web");
                startActivity(intent);
            }
        });
        rvBlogs.setLayoutManager(new LinearLayoutManager(this));
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

    @OnClick({R.id.gd, R.id.rl_t})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gd:
                finish();
                break;
            case R.id.rl_t:
                break;
        }
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
            map.put("date",selectDate);
            map.put("tag",tag);
            isLoading=true;
            RequestUtils.articles(map, new Call<ArticleListBean>(BlogListActivity.this) {
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
}
