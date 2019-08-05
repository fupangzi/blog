package com.piglet.blogapp.net;

import android.util.Log;

import org.json.JSONException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.HttpException;


/**
 * RxExceptionUtil
 * 错误检测app
 * @author Administrator
 * @date 2019/1/16 0016
 */
public class RxExceptionUtil {
    public static String exceptionHandler(Throwable e){
        Log.e("exmessage",e.getMessage());
        String errorMsg = "未知错误";
        if (e instanceof UnknownHostException) {
            errorMsg = "网络不可用";
        } else if (e instanceof SocketTimeoutException) {
            errorMsg = "请求网络超时";
        } else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            errorMsg = convertStatusCode(httpException);
        } else if (e instanceof ParseException || e instanceof JSONException
                || e instanceof JSONException) {
            errorMsg = "数据解析错误";
        }else{
            errorMsg=e.getMessage();
        }
        return errorMsg;
    }

    private static String convertStatusCode(HttpException httpException) {
        String msg;
        if (httpException.code() >= 500 && httpException.code() < 600) {
            msg = "服务器处理请求出错";
        } else if (httpException.code() >= 400 && httpException.code() < 500) {
            msg = "服务器无法处理请求";
        } else if (httpException.code() >= 300 && httpException.code() < 400) {
            msg = "请求被重定向到其他页面";
        } else {
            msg = httpException.message();
        }
        return msg;
    }

    /**
     * 把map参数放到requestbody
     * @param hashMap
     * @return
     */
    public static RequestBody getRequestBody(Map<String, String> hashMap) {
        StringBuffer data = new StringBuffer("{");
        if (hashMap != null && hashMap.size() > 0) {
            Iterator iter = hashMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                Object val = entry.getValue();
                data.append(key).append("=").append(val).append(",");
            }
        }
        String jso = data.substring(0, data.length() - 1);
        Log.e("aaaa",jso);
        RequestBody requestBody =
                RequestBody.create(MediaType.parse("application/json; charset=utf-8"),jso+"}");

        return requestBody;
    }
}
