package com.piglet.blogapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.piglet.blogapp.Myapplication;

/**
 * SpUtils
 *
 * @author Administrator
 * @date 2019/8/5 0005
 */
public class SpUtils {
    private static SharedPreferences sharedPreferences;


    public static String getToken(){
        if(sharedPreferences==null){
            sharedPreferences= Myapplication.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
        }
        return  sharedPreferences.getString("accesstoken","");
    }
}
