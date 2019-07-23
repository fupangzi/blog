package com.piglet.blogapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.piglet.blogapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * BlogRvAdapter
 *
 * @author Administrator
 * @date 2019/7/23 0023
 */
public class BlogRvAdapter extends RecyclerView.Adapter<BlogRvAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mList;


    public BlogRvAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_blog_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolde, int i) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


     static  class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_message_count)
        TextView tvMessageCount;
        @BindView(R.id.tv_see_count)
        TextView tvSeeCount;
         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             ButterKnife.bind(this, itemView);
         }
    }
}
