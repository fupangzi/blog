package com.piglet.blogapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.piglet.blogapp.GlideApp;
import com.piglet.blogapp.R;
import com.piglet.blogapp.bean.TagBean;
import com.piglet.blogapp.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TagsRvAdapter extends RecyclerView.Adapter<TagsRvAdapter.ViewHolder> {
    private Context mContext;
    private List<TagBean.DataBean> mList;

    public TagsRvAdapter(Context mContext, List<TagBean.DataBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_tag, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        GlideUtils.loadImage(mContext,mList.get(i).getAvatar(),viewHolder.ivLogo);
        viewHolder.tvTagValue.setText(String.valueOf(mList.get(i).getTagName()));;
        viewHolder.tvCount.setText(String.valueOf(mList.get(i).getArticleCount()+" 文章"));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_logo)
        ImageView ivLogo;
        @BindView(R.id.tv_tag_value)
        TextView tvTagValue;
        @BindView(R.id.tv_count)
        TextView tvCount;

        ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
