package com.piglet.blogapp.net;


/**
 * NetApi
 * 网络的方法
 * @author Administrator
 * @date 2019/1/16 0016
 */
public interface NetApi {
    String BASEURL = "http://v.juhe.cn/todayOnhistory/";
    String getData = "queryEvent.php";
    String getDetails = "queryDetail.php";
    String getBaidutoken = "https://aip.baidubce.com/oauth/2.0/token";
    String animal = " https://aip.baidubce.com/rest/2.0/image-classify/v1/animal";
    String advanced_general="https://aip.baidubce.com/rest/2.0/image-classify/v2/advanced_general";
    String car="https://aip.baidubce.com/rest/2.0/image-classify/v1/car";
    String plant="https://aip.baidubce.com/rest/2.0/image-classify/v1/plant";
}

