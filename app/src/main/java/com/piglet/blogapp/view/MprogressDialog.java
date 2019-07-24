package com.piglet.blogapp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.piglet.blogapp.R;

/**
 * MprogressDialog
 *
 * @author Administrator
 * @date 2019/3/18 0018
 */
public class MprogressDialog extends AlertDialog {
    ImageView imageView;
    Context context;
    public MprogressDialog(@NonNull Context context) {
        super(context);
        this.context=context;
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_view);
        imageView=findViewById(R.id.image);
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(context).load(R.drawable.timg).apply(options).into(imageView);
    }
}
