package com.piglet.blogapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piglet.blogapp.R;
import com.piglet.blogapp.adapter.TagsRvAdapter;
import com.piglet.blogapp.base.BaseFragment;
import com.piglet.blogapp.bean.TagBean;
import com.piglet.blogapp.net.Call;
import com.piglet.blogapp.net.RequestUtils;
import com.xm.emptylayout.EmptyLayout;

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
public class Home3Fragment extends BaseFragment {
    Context context;
    Unbinder unbinder;
    @BindView(R.id.rv_tags)
    RecyclerView rvTags;
    @BindView(R.id.empty)
    EmptyLayout empty;
    private TagsRvAdapter tagsRvAdapter;
    private List<TagBean.DataBean> list = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_homt3, container, false);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        DividerItemDecoration decorationWidth = new DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL);
        decorationWidth.setDrawable(context.getResources().getDrawable(R.drawable.item_rv_decoration));
        DividerItemDecoration decorationHeight = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        decorationHeight.setDrawable(context.getResources().getDrawable(R.drawable.item_rv_decoration_height));
        rvTags.addItemDecoration(decorationWidth);
        rvTags.addItemDecoration(decorationHeight);
        rvTags.setLayoutManager(new GridLayoutManager(context, 3));
        tagsRvAdapter = new TagsRvAdapter(context, list);
        rvTags.setAdapter(tagsRvAdapter);
        empty.setAllButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
        getData();
        empty.showLoading();
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


    //获取tag数据
    public void getData() {
        list.clear();
        RequestUtils.tags(new Call<TagBean>(context) {
            @Override
            public void onSuccess(TagBean result) {
                if (result.isSuccess()) {
                    if (result.getData().size() == 0) {
                        empty.showEmpty();
                        return;
                    }
                    list.addAll(result.getData());
                    empty.hide();
                    tagsRvAdapter.notifyDataSetChanged();
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
}
