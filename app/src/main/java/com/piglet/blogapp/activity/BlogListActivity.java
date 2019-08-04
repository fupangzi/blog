package com.piglet.blogapp.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.piglet.blogapp.R;
import com.piglet.blogapp.base.BaseActivity;
import com.piglet.blogapp.utils.StatusBarUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xm.emptylayout.EmptyLayout;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_list);
        ButterKnife.bind(this);
        initView();
    }

    /**
     * 初始化view
     */
    public void initView(){
        //设置跟状态栏一样的高
        rlT.setPadding(0, StatusBarUtil.getStatusBarHeight(this), 0, 0);
        rvBlogs.setLayoutManager(new LinearLayoutManager(this));

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
}
