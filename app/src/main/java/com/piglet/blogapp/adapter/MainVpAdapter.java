package com.piglet.blogapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * MainVpAdapter
 *
 * @author Administrator
 * @date 2019/7/23 0023
 */
public class MainVpAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;
    public MainVpAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
