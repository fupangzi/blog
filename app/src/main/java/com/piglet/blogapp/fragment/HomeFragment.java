package com.piglet.blogapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piglet.blogapp.R;
import com.piglet.blogapp.adapter.BlogRvAdapter;
import com.piglet.blogapp.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

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

    List<String> dataList = new ArrayList<>();
    private BlogRvAdapter blogRvAdapter;
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
        dataList.add("");
        dataList.add("");
        blogRvAdapter = new BlogRvAdapter(context, dataList);
        rvBlogs.setLayoutManager(new LinearLayoutManager(context));
        rvBlogs.setAdapter(blogRvAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
