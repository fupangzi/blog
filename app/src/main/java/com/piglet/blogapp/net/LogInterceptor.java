package com.piglet.blogapp.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.piglet.blogapp.Myapplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * LogInterceptor
 * okhttp拦截器
 * @author Administrator
 * @date 2019/1/16 0016
 */
public class LogInterceptor implements Interceptor {
    private static final String TAG = "okhttp";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request result=chain.request();
        Response response = chain.proceed(result);
        MediaType mediaType=response.body().contentType();
        String content=response.body().string();
        //打印请求头
        if(response.headers().get("accesstoken")!=null){
            Log.e("accesstoken",response.headers().get("accesstoken"));
            SharedPreferences sharedPreferences= Myapplication.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
            sharedPreferences.edit().putString("accesstoken",response.headers().get("accesstoken")).apply();
        }
        Log.e(TAG,"responsebody"+content);
        return response.newBuilder()
                .body(ResponseBody.create(mediaType,content))
                .build();
    }
}
