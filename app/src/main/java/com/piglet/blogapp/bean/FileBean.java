package com.piglet.blogapp.bean;

import java.util.List;

public class FileBean {

    /**
     * data : ["2019-03","2019-01","2019-02","2018-07","2018-08","2018-09","2018-10","2018-11"]
     * success : true
     */

    private boolean success;
    private List<String> data;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
