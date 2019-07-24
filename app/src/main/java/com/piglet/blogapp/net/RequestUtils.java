package com.piglet.blogapp.net;



import android.content.SharedPreferences;


import com.piglet.blogapp.bean.ArticleListBean;
import com.piglet.blogapp.bean.FileBean;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * RequestUtils
 * 创建请求的方法
 * @author Administrator
 * @date 2019/1/16 0016
 */
public class RequestUtils {
    public static  void getData(Call<String> observer){
        RetrofitManager.getNetService(NetService.class)
                .getDate()
                .compose(Transformer.<String>switchSchedulers())
                .subscribe(observer);
    }


    public static  void upLoadFile(Call<String> observer){
        List<MultipartBody.Part> list = new ArrayList<>();
            MultipartBody.Builder builder = new MultipartBody.Builder().addFormDataPart("", "");
                File file1 = new File("path");
                RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
                builder.addFormDataPart("file", file1.getName(), requestBody);
             list = builder.build().parts();

        RetrofitManager.getNetService(NetService.class)
                .postDate(new HashMap<String, String>(),list)
                .compose(Transformer.<String>switchSchedulers())
                .subscribe(observer);
    }


    public static  void upLoadFile1(Call<String> observer){

        File file1 = new File("path");
        RequestBody  responseBody=RequestBody.create(MediaType.parse("application/otcet-stream"),file1);
        MultipartBody.Part body=MultipartBody.Part.createFormData("aaa","aaa",responseBody);
        RetrofitManager.getNetService(NetService.class)
                .postDate1(new HashMap<String, String>(),body)
                .compose(Transformer.<String>switchSchedulers())
                .subscribe(observer);
    }

    public static  void articles(Map<String,String> map,Call<ArticleListBean> observer){
        RetrofitManager.getNetService(NetService.class)
                .articles(map.get("current"),map.get("size"),map.get("date"),map.get("tag"))
                .compose(Transformer.<ArticleListBean>switchSchedulers())
                .subscribe(observer);
    }

    /**
     * 获取归档列表
     * @param observer
     */
    public static  void file(Call<FileBean> observer){
        RetrofitManager.getNetService(NetService.class)
                .file()
                .compose(Transformer.<FileBean>switchSchedulers())
                .subscribe(observer);
    }

}
