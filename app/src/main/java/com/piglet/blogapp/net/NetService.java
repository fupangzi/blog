package com.piglet.blogapp.net;




import com.piglet.blogapp.bean.ArticleListBean;
import com.piglet.blogapp.bean.BaseBean;
import com.piglet.blogapp.bean.FileBean;
import com.piglet.blogapp.bean.TagBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * NetService
 * retrofit注解请求方法
 * @author Administrator
 * @date 2019/1/16 0016
 */
public interface NetService {
    @GET(NetApi.articles)
    Observable<String> getDate();


    @POST(NetApi.articles)
    Observable<String> postDate();
    //map传值
    @POST(NetApi.articles)
    @FormUrlEncoded
    Observable<String> postDate(@FieldMap Map<String, String> map);

    //上传多文件和参数
    @POST(NetApi.articles)
    @Multipart
    Observable<String> postDate(@Part Map<String, String> map, @Part List<MultipartBody.Part> files);

    //上传文件和参数
    @POST(NetApi.articles)
    @Multipart
    Observable<String> postDate1(@Part Map<String, String> map, @Part MultipartBody.Part files);


    /**
     * 获取文章列表
     * @return
     */
    @GET(NetApi.articles)
    Observable<ArticleListBean> articles(@Query("current")String current,@Query("size")String size,@Query("date")String date,@Query("tag")String tag);
    /**
     * 获取归档
     * @return
     */
    @GET(NetApi.file)
    Observable<FileBean> file();
    /**
     * 获取标签列表
     * @return
     */
    @GET(NetApi.tags)
    Observable<TagBean> tags();

    /**
     * 登录
     * @return
     */
    @POST(NetApi.login)
    @FormUrlEncoded
    Observable<FileBean> login(@FieldMap Map<String,String> map);

    /**
     * 登录body
     * @return
     */
    @POST(NetApi.login)
    @Headers({"Content-Type: application/json","Accept: application/json"})
    Observable<BaseBean> loginBody(@Body RequestBody body);

    /**
     * 注册
     * @return
     */
    @POST(NetApi.register)
    @Headers({"Content-Type: application/json","Accept: application/json"})
    Observable<BaseBean> register(@Body  RequestBody body);
}
