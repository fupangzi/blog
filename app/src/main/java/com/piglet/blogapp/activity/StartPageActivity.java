package com.piglet.blogapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.eftimoff.androipathview.PathView;
import com.piglet.blogapp.MainActivity;
import com.piglet.blogapp.R;
import com.piglet.blogapp.base.BaseActivity;
import com.piglet.blogapp.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartPageActivity extends BaseActivity {


    @BindView(R.id.gd)
    ImageView gd;
    @BindView(R.id.rl_t)
    RelativeLayout rlT;
    @BindView(R.id.rl_title_padding)
    RelativeLayout rlTitlePadding;
    @BindView(R.id.pathView)
    PathView pathView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        ButterKnife.bind(this);

        rlTitlePadding.setPadding(0, StatusBarUtil.getStatusBarHeight(this), 0, 0);
        pathView.setFillAfter(true);
        pathView.useNaturalColors();
        pathView.getPathAnimator().
                delay(100).
                duration(1500).
                interpolator(new AccelerateDecelerateInterpolator()).
                start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        startActivity(new Intent(StartPageActivity.this, MainActivity.class));
                        finish();
                    }
                });
            }
        }, 1800);
    }
}
