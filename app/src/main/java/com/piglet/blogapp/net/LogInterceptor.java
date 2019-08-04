package com.piglet.blogapp.net;

import android.util.Log;

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
    private static final String TAG = "okhtt3p";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request result=chain.request();
        Log.e(TAG,result.toString());
        //获取请求的时间
        long t1=System.nanoTime();
        Response response = chain.proceed(result);
        //获取请求成功的时间
        long t2=System.nanoTime();
        MediaType mediaType=response.body().contentType();
        String content=response.body().string();
        //打印请求头
        if(response.headers().get("accesstoken")!=null){
            Log.e("accesstoken",response.headers().get("accesstoken"));
        }
        Log.e(TAG,"responsebody"+content);
        return response.newBuilder()
                .body(ResponseBody.create(mediaType,content))
                .build();
    }
}
