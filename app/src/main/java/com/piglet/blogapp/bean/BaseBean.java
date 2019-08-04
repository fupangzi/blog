package com.piglet.blogapp.bean;

public class BaseBean {

    /**
     * data : 用户信息
     * success : true
     */

    private String errmsg;
    private String data;
    private boolean success;

    public String getData() {
        return data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
