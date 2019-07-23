package com.piglet.blogapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.piglet.blogapp.R;
import com.piglet.blogapp.bean.ArticleListBean;

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
    private List<ArticleListBean.DataBean.RecordsBean> mList;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public BlogRvAdapter(Context mContext, List<ArticleListBean.DataBean.RecordsBean> mList) {
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
    public void onBindViewHolder(@NonNull ViewHolder viewHolde, final int i) {
        ArticleListBean.DataBean.RecordsBean bean = mList.get(i);
        if(bean!=null){
            viewHolde.tvDate.setText(String.valueOf(bean.getCreateTime()));
            viewHolde.tvContent.setText(String.valueOf(bean.getSummary()));
            viewHolde.tvTitle.setText(String.valueOf(bean.getTitle()));
            viewHolde.tvMessageCount.setText(String.valueOf(" "+bean.getCommentNum()));
            viewHolde.tvSeeCount.setText(" "+String.valueOf(bean.getViewNum()));
        }
        viewHolde.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickListener!=null){
                    onClickListener.onClick(i);
                }
            }
        });
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

    public interface OnClickListener{
        void onClick(int i);
    }
}
