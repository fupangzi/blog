package com.piglet.blogapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.piglet.blogapp.adapter.MainVpAdapter;
import com.piglet.blogapp.base.BaseActivity;
import com.piglet.blogapp.fragment.Home2Fragment;
import com.piglet.blogapp.fragment.Home3Fragment;
import com.piglet.blogapp.fragment.Home4Fragment;
import com.piglet.blogapp.fragment.HomeFragment;
import com.piglet.blogapp.utils.StatusBarUtil;
import com.piglet.blogapp.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rl_title_padding)
    RelativeLayout rlTitlePadding;
    @BindView(R.id.gd)
    ImageView gd;
    @BindView(R.id.rl_t)
    RelativeLayout rlT;
    @BindView(R.id.civ_img)
    CircleImageView civImg;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_signature)
    TextView tvSignature;
    @BindView(R.id.minefrgment_head)
    RelativeLayout minefrgmentHead;
    @BindView(R.id.drwaerlayout)
    DrawerLayout drwaerlayout;
    @BindView(R.id.view_page)
    NoScrollViewPager viewPage;
    @BindView(R.id.bnv)
    BottomNavigationView bnv;
    //存储碎片页面
    private MainVpAdapter mainVpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //初始化控件
        initView();
    }

    /**
     * 初始化view控件
     */
    public void initView() {
        //设置跟状态栏一样的高
        rlTitlePadding.setPadding(0, StatusBarUtil.getStatusBarHeight(this), 0, 0);
        mainVpAdapter = new MainVpAdapter(getSupportFragmentManager(), initFragments());
        viewPage.setAdapter(mainVpAdapter);
        viewPage.setOffscreenPageLimit(4);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.meun_home:
                        viewPage.setCurrentItem(0);
                        break;
                    case R.id.meun_home2:
                        viewPage.setCurrentItem(1);
                        break;
                    case R.id.meun_home3:
                        viewPage.setCurrentItem(2);
                        break;
                    case R.id.meun_home4:
                        viewPage.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }


    /**
     * 初始化所有的碎片页面
     *
     * @return 返回初始化好的list
     */
    private List<Fragment> initFragments() {
        List<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new Home2Fragment());
        list.add(new Home3Fragment());
        list.add(new Home4Fragment());
        return list;
    }

    @OnClick({R.id.gd, R.id.civ_img, R.id.tv_name})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gd:
                drwaerlayout.openDrawer(Gravity.START);
                break;
            case R.id.civ_img:
                break;
            case R.id.tv_name:
                break;
        }
    }


}
