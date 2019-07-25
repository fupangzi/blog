package com.piglet.blogapp.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.piglet.blogapp.R;

public class GlideUtils {
    public static void loadImage(Context activity, String url, ImageView imageView) {
        if (activity != null) {
            DrawableCrossFadeFactory drawableCrossFadeFactory = new DrawableCrossFadeFactory.Builder(300).setCrossFadeEnabled(true).build();
            Glide.with(activity)
                    .load(url)
                    .apply(new RequestOptions().placeholder(R.drawable.ic_launcher))
                    .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
                    .into(imageView);
        }

    }
}
