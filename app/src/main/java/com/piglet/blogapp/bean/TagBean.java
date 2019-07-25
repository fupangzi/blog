package com.piglet.blogapp.bean;

import java.util.List;

public class TagBean {

    /**
     * data : [{"articleCount":0,"avatar":"https://shaohua-blog.oss-cn-beijing.aliyuncs.com/tag-html.png","id":5,"tagName":"Html"},{"articleCount":0,"avatar":"https://shaohua-blog.oss-cn-beijing.aliyuncs.com/tag-js.jpg","id":6,"tagName":"JavaScript"},{"articleCount":0,"avatar":"https://shaohua-blog.oss-cn-beijing.aliyuncs.com/tag-vue.png","id":7,"tagName":"Vue"},{"articleCount":0,"avatar":"https://shaohua-blog.oss-cn-beijing.aliyuncs.com/tag-css.jpg","id":8,"tagName":"Css"},{"articleCount":2,"avatar":"https://shaohua-blog.oss-cn-beijing.aliyuncs.com/tag-spring.png","id":2,"tagName":"Spring"},{"articleCount":2,"avatar":"https://shaohua-blog.oss-cn-beijing.aliyuncs.com/tag-hibernate.jpg","id":3,"tagName":"Hibernate"},{"articleCount":2,"avatar":"https://shaohua-blog.oss-cn-beijing.aliyuncs.com/tag-maven.jpeg","id":4,"tagName":"Maven"},{"articleCount":4,"avatar":"https://shaohua-blog.oss-cn-beijing.aliyuncs.com/tag-java.jpg","id":1,"tagName":"Java"}]
     * success : true
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * articleCount : 0
         * avatar : https://shaohua-blog.oss-cn-beijing.aliyuncs.com/tag-html.png
         * id : 5
         * tagName : Html
         */

        private int articleCount;
        private String avatar;
        private int id;
        private String tagName;

        public int getArticleCount() {
            return articleCount;
        }

        public void setArticleCount(int articleCount) {
            this.articleCount = articleCount;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }
    }
}
