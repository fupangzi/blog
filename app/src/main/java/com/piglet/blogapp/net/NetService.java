package com.piglet.blogapp.net;




import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * NetService
 *
 * @author Administrator
 * @date 2019/1/16 0016
 */
public interface NetService {
    @GET(NetApi.getData)
    Observable<String> getDate();


    @POST(NetApi.getData)
    Observable<String> postDate();
    //map传值
    @POST(NetApi.getData)
    @FormUrlEncoded
    Observable<String> postDate(@FieldMap Map<String, String> map);

    //上传多文件和参数
    @POST(NetApi.getData)
    @Multipart
    Observable<String> postDate(@Part Map<String, String> map, @Part List<MultipartBody.Part> files);

    //上传文件和参数
    @POST(NetApi.getData)
    @Multipart
    Observable<String> postDate1(@Part Map<String, String> map, @Part MultipartBody.Part files);


}
