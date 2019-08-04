package com.piglet.blogapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.piglet.blogapp.MainActivity;
import com.piglet.blogapp.R;
import com.piglet.blogapp.base.BaseActivity;
import com.piglet.blogapp.bean.FileBean;
import com.piglet.blogapp.net.Call;
import com.piglet.blogapp.net.RequestUtils;
import com.piglet.blogapp.utils.KeyBoardUtil;
import com.piglet.blogapp.utils.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.civ_photo)
    ImageView civPhoto;
    @BindView(R.id.actv_tel)
    AutoCompleteTextView actvTel;
    @BindView(R.id.rl_tel)
    RelativeLayout rlTel;
    @BindView(R.id.actv_psw)
    AutoCompleteTextView actvPsw;
    @BindView(R.id.rl_psw)
    RelativeLayout rlPsw;
    @BindView(R.id.tv_ok)
    TextView tvOk;
    @BindView(R.id.tv_registered)
    TextView tvRegistered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null) {
            actvTel.setText(intent.getStringExtra("name") == null ? "" : intent.getStringExtra("name"));
            actvPsw.setText(intent.getStringExtra("pwd") == null ? "" : intent.getStringExtra("pwd"));
        }

    }

    @OnClick({R.id.civ_photo, R.id.tv_registered,R.id.tv_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_ok:
                KeyBoardUtil.hideKeyboard(LoginActivity.this);
                String name = actvTel.getText().toString().trim();
                if ("".equals(name)) {
                    ToastUtils.showCenterToast("请输入用户名");
                    return;
                }
                String pwd = actvPsw.getText().toString().trim();
                if ("".equals(pwd)) {
                    ToastUtils.showCenterToast("请输入密码");
                    return;
                }
                login(name, pwd);
                break;
            case R.id.civ_photo:
                break;
            case R.id.tv_registered:
                KeyBoardUtil.hideKeyboard(LoginActivity.this);
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }


    /**
     * 登录
     *
     * @param name 用户名
     * @param pwd  密码
     */
    public void login(String name, String pwd) {
        Map<String, String> map = new HashMap<>();
        map.put("account", name);
        map.put("password", pwd);
        RequestUtils.login(map, new Call<FileBean>(LoginActivity.this, true) {
            @Override
            public void onSuccess(FileBean result) {
                if (result.getSuccess()) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    ToastUtils.showCenterToast("登录成功");
                } else {
                    ToastUtils.showCenterToast("登录失败");
                }
            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {
                ToastUtils.showCenterToast("请求异常");
            }
        });
    }
}
