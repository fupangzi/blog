package com.piglet.blogapp.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.piglet.blogapp.Myapplication;

/**
 * MyToast
 *
 * @author Administrator
 * @date 2019/7/10 0010
 */
public class ToastUtils {
    private   static Toast toast;

    public static void showCenterToast(String message){
        if(toast==null){
            toast = Toast.makeText(Myapplication.getContext(), message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
        }else{
            toast.setText(message);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
