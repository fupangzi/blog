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

public class FileRVAdapter extends RecyclerView.Adapter<FileRVAdapter.ViewHolder> {
    private Context mContext;
    private List<String> lists;
    private  int index=0;
    private OnClickLinsten onClickLinsten;
    public FileRVAdapter(Context mContext, List<String> lists) {
        this.mContext = mContext;
        this.lists = lists;
    }

    public void setOnClickLinsten(OnClickLinsten onClickLinsten) {
        this.onClickLinsten = onClickLinsten;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_rv_file,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        if(index==i){
            viewHolder.tvDate.setTextColor(mContext.getResources().getColor(R.color.colorPrimary1));
            viewHolder.itemView.setBackgroundColor(mContext.getResources().getColor(R.color.yelloTitle));
        }else{
            viewHolder.itemView.setBackgroundColor(mContext.getResources().getColor(R.color.white));
            viewHolder.tvDate.setTextColor(mContext.getResources().getColor(R.color.textBaseColor));
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index=i;
                notifyDataSetChanged();
                if(onClickLinsten!=null){
                    onClickLinsten.OnClick(lists.get(i));
                }
            }
        });
        viewHolder.tvDate.setText(String.valueOf(lists.get(i)));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate=itemView.findViewById(R.id.tv_date);
        }
    }

    public interface OnClickLinsten{
        void OnClick(String date);
    }
}
