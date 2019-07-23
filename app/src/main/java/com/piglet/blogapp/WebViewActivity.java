package com.piglet.blogapp;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.piglet.blogapp.base.BaseActivity;
import com.piglet.blogapp.utils.StatusBarUtil;
import com.piglet.blogapp.view.NewWebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.KeyEvent.KEYCODE_BACK;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.gd)
    ImageView gd;
    @BindView(R.id.rl_t)
    RelativeLayout rlT;
    @BindView(R.id.rl_title_padding)
    RelativeLayout rlTitlePadding;
    @BindView(R.id.web_view)
    NewWebView webView;
    String loadUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        loadUrl = getIntent().getStringExtra("url") == null ? "" : getIntent().getStringExtra("url");
        //设置跟状态栏一样的高
        rlTitlePadding.setPadding(0, StatusBarUtil.getStatusBarHeight(this), 0, 0);
        WebSettings webSettings = webView.getSettings();
        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(loadUrl);
    }

    @OnClick({R.id.gd, R.id.rl_t})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gd:
                finish();
                break;
            case R.id.rl_t:
                break;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
