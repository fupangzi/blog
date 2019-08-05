package com.piglet.blogapp.net;


/**
 * NetApi
 * 所有的请求路径
 * @author Administrator
 * @date 2019/1/16 0016
 */
public interface NetApi {
    /**
     * 线上
     */
    String BASEURL = "http://39.105.103.124:8080/";
   // String BASEURL = "http://192.168.10.224:8080/";
   // String BASEURL = "http://39.105.103.124:8080";
   //   String BASEURL = "http://192.168.10.224:8080/";
    String articles = "/articles"; //获取文章列表
    String file = "/articles/file"; //获取文章归档试图
    String login = "/login"; //用户登录
    String register="/register";
    String tags = "/tags"; //获取标签列表


}

