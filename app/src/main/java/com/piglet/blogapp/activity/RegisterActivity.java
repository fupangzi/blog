package com.piglet.blogapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.piglet.blogapp.MainActivity;
import com.piglet.blogapp.R;
import com.piglet.blogapp.base.BaseActivity;
import com.piglet.blogapp.bean.BaseBean;
import com.piglet.blogapp.bean.FileBean;
import com.piglet.blogapp.net.Call;
import com.piglet.blogapp.net.RequestUtils;
import com.piglet.blogapp.utils.KeyBoardUtil;
import com.piglet.blogapp.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        //123
    }

    @OnClick({R.id.rl_psw, R.id.tv_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_psw:
                break;
            case R.id.tv_ok:

                KeyBoardUtil.hideKeyboard(RegisterActivity.this);
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
                register(name, pwd);
                break;
        }
    }

    /**
     * 注册
     *
     * @param name 用户名
     * @param pwd  密码
     */
    public void register(final String name, final String pwd) {
        Map<String, String> map = new HashMap<>();
        map.put("account", name);
        map.put("password", pwd);
        RequestUtils.register(map, new Call<BaseBean>(RegisterActivity.this, true) {
            @Override
            public void onSuccess(BaseBean result) {
                if (result.getSuccess()) {
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("pwd", pwd);
                    startActivity(intent);
                    ToastUtils.showCenterToast("注册成功");
                } else {
                    ToastUtils.showCenterToast(String.valueOf(result.getErrmsg()));
                }
            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {
                ToastUtils.showCenterToast("请求异常");
            }
        });
    }
}
