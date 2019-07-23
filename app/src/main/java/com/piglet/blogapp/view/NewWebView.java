package com.piglet.blogapp.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.piglet.blogapp.R;

/**
 * NewWebView
 *
 * @author Administrator
 * @date 2019/7/23 0023
 */
public class NewWebView extends WebView {
    private ProgressBar mProgressBar;

    public NewWebView(Context context) {
        super(context);
    }


    public NewWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NewWebView(Context context, AttributeSet attrs) {

        super(context, attrs);

        mProgressBar = new ProgressBar(context, null,

                android.R.attr.progressBarStyleHorizontal);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(

                LinearLayout.LayoutParams.MATCH_PARENT, 8);

        mProgressBar.setLayoutParams(layoutParams);


        Drawable drawable = context.getResources().getDrawable(

                R.drawable.web_progress_bar_states);

        mProgressBar.setProgressDrawable(drawable);

        addView(mProgressBar);

        setWebChromeClient(new WebChromeClient());

    }


    public class WebChromeClient extends android.webkit.WebChromeClient {

        @Override

        public void onProgressChanged(WebView view, int newProgress) {

            if (newProgress == 100) {

                mProgressBar.setVisibility(GONE);

            } else {

                if (mProgressBar.getVisibility() == GONE)

                    mProgressBar.setVisibility(VISIBLE);

                mProgressBar.setProgress(newProgress);

            }

            super.onProgressChanged(view, newProgress);

        }

    }


    @Override

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {

        LayoutParams lp = (LayoutParams) mProgressBar.getLayoutParams();

        lp.x = l;

        lp.y = t;

        mProgressBar.setLayoutParams(lp);

        super.onScrollChanged(l, t, oldl, oldt);

    }

}
