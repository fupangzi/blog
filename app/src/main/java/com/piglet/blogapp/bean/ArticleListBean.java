package com.piglet.blogapp.bean;

import java.util.List;

public class ArticleListBean {

    /**
     * data : {"current":1,"pages":0,"records":[{"categoryId":1,"commentNum":76,"createTime":"2019-03-05 15:21:06","id":"1","nickname":"liangfeihu","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程","tags":[{"id":5,"tagName":"Html"},{"id":8,"tagName":"Css"},{"id":6,"tagName":"JavaScript"},{"id":7,"tagName":"Vue"}],"title":"Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1000,"viewNum":3,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2019-02-01 15:21:06","id":"3","nickname":"liangfeihu","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[{"id":7,"tagName":"Vue"},{"id":6,"tagName":"JavaScript"}],"title":"Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1000,"viewNum":0,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2019-01-01 15:21:08","id":"2","nickname":"liangweijie","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[{"id":5,"tagName":"Html"},{"id":7,"tagName":"Vue"}],"title":"1001Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1001,"viewNum":0,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2018-11-01 15:21:06","id":"8","nickname":"liangweijie2","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[],"title":"1002Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1002,"viewNum":0,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2018-10-05 15:21:06","id":"7","nickname":"liangfeihu","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[],"title":"Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1000,"viewNum":0,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2018-09-01 15:21:08","id":"6","nickname":"liangweijie","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[],"title":"1001Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1001,"viewNum":0,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2018-08-01 15:21:06","id":"5","nickname":"liangfeihu","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[],"title":"Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1000,"viewNum":0,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2018-07-06 15:21:06","id":"4","nickname":"liangweijie2","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[{"id":7,"tagName":"Vue"},{"id":6,"tagName":"JavaScript"}],"title":"1002Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1002,"viewNum":0,"weight":0}],"searchCount":true,"size":10,"total":0}
     * success : true
     */

    private DataBean data;
    private boolean success;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * current : 1
         * pages : 0
         * records : [{"categoryId":1,"commentNum":76,"createTime":"2019-03-05 15:21:06","id":"1","nickname":"liangfeihu","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程","tags":[{"id":5,"tagName":"Html"},{"id":8,"tagName":"Css"},{"id":6,"tagName":"JavaScript"},{"id":7,"tagName":"Vue"}],"title":"Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1000,"viewNum":3,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2019-02-01 15:21:06","id":"3","nickname":"liangfeihu","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[{"id":7,"tagName":"Vue"},{"id":6,"tagName":"JavaScript"}],"title":"Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1000,"viewNum":0,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2019-01-01 15:21:08","id":"2","nickname":"liangweijie","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[{"id":5,"tagName":"Html"},{"id":7,"tagName":"Vue"}],"title":"1001Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1001,"viewNum":0,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2018-11-01 15:21:06","id":"8","nickname":"liangweijie2","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[],"title":"1002Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1002,"viewNum":0,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2018-10-05 15:21:06","id":"7","nickname":"liangfeihu","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[],"title":"Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1000,"viewNum":0,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2018-09-01 15:21:08","id":"6","nickname":"liangweijie","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[],"title":"1001Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1001,"viewNum":0,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2018-08-01 15:21:06","id":"5","nickname":"liangfeihu","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[],"title":"Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1000,"viewNum":0,"weight":0},{"categoryId":1,"commentNum":0,"createTime":"2018-07-06 15:21:06","id":"4","nickname":"liangweijie2","summary":"Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程8","tags":[{"id":7,"tagName":"Vue"},{"id":6,"tagName":"JavaScript"}],"title":"1002Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面","updateTime":"2018-07-06T15:21:08","userId":1002,"viewNum":0,"weight":0}]
         * searchCount : true
         * size : 10
         * total : 0
         */

        private int current;
        private int pages;
        private boolean searchCount;
        private int size;
        private int total;
        private List<RecordsBean> records;

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public boolean isSearchCount() {
            return searchCount;
        }

        public void setSearchCount(boolean searchCount) {
            this.searchCount = searchCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public static class RecordsBean {
            /**
             * categoryId : 1
             * commentNum : 76
             * createTime : 2019-03-05 15:21:06
             * id : 1
             * nickname : liangfeihu
             * summary : Vue构建前台页面过程1Vue构建前台页面过程2Vue构建前台页面过程3Vue构建前台页面过程4Vue构建前台页面过程5Vue构建前台页面过程6Vue构建前台页面过程7Vue构建前台页面过程
             * tags : [{"id":5,"tagName":"Html"},{"id":8,"tagName":"Css"},{"id":6,"tagName":"JavaScript"},{"id":7,"tagName":"Vue"}]
             * title : Vue构建前台页面Vue构建前台页面Vue构建前台页面Vue构建前台页面
             * updateTime : 2018-07-06T15:21:08
             * userId : 1000
             * viewNum : 3
             * weight : 0
             */

            private int categoryId;
            private int commentNum;
            private String createTime;
            private String id;
            private String nickname;
            private String summary;
            private String title;
            private String updateTime;
            private int userId;
            private int viewNum;
            private int weight;
            private List<TagsBean> tags;

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public int getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(int commentNum) {
                this.commentNum = commentNum;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getViewNum() {
                return viewNum;
            }

            public void setViewNum(int viewNum) {
                this.viewNum = viewNum;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class TagsBean {
                /**
                 * id : 5
                 * tagName : Html
                 */

                private int id;
                private String tagName;

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
    }
}
