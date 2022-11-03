package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MsgThumbBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取成功.
     * data : {"content":[{"_id":"1037367162261471232","beUid":"1499922423573647361","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一...","url":"/m/1587633183589064705","nickname":"CH-Android","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1290102301154942976","thumbTime":"2022-11-02 14:06","timeText":"2小时前","hasRead":"1"},{"_id":"1037367145224208384","beUid":"1499922423573647361","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一...","url":"/m/1587633183589064705","nickname":"搬砖侠","avatar":"https://images.sunofbeaches.com/content/2022_04_14/964124335407104000.png","uid":"1504452765877800961","thumbTime":"2022-11-02 14:06","timeText":"2小时前","hasRead":"1"},{"_id":"1037327360233308160","beUid":"1499922423573647361","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一...","url":"/m/1587633183589064705","nickname":"纠结轮","avatar":"https://images.sunofbeaches.com/content/2022_07_04/993567554951708672.png","uid":"1250988207093321728","thumbTime":"2022-11-02 11:28","timeText":"4小时前","hasRead":"1"},{"_id":"1037319506357125120","beUid":"1499922423573647361","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一...","url":"/m/1587633183589064705","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","uid":"1139423796017500160","thumbTime":"2022-11-02 10:57","timeText":"5小时前","hasRead":"1"},{"_id":"1031655229503832064","beUid":"1499922423573647361","title":"🙂","url":"/qa/1510193205515186177#1031292957199695872","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","thumbTime":"2022-10-17 19:49","timeText":"15天前","hasRead":"1"},{"_id":"1031655175468613632","beUid":"1499922423573647361","title":"测试发送","url":"/qa/1510193205515186177#1031293678443823104","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","thumbTime":"2022-10-17 19:49","timeText":"15天前","hasRead":"1"},{"_id":"1031655115930468352","beUid":"1499922423573647361","title":"测试测试","url":"/qa/1510193205515186177#1031294543414165504","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","thumbTime":"2022-10-17 19:49","timeText":"15天前","hasRead":"1"},{"_id":"1031616993318404096","beUid":"1499922423573647361","title":"领券联盟生成淘口令失败","url":"/qa/1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","thumbTime":"2022-10-17 17:17","timeText":"15天前","hasRead":"1"},{"_id":"1021082391038394368","beUid":"1499922423573647361","title":"Retrofit初始化问题","url":"/qa/1513107843181506562","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","thumbTime":"2022-09-18 15:36","timeText":"2022-09-18","hasRead":"1"},{"_id":"963397938795511808","beUid":"1499922423573647361","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<im...","url":"/m/1513442206020595713","nickname":"年年","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/3B/rBsADV_eE-OAC--fAABO7gT-pcY862.png","uid":"1339887900006932480","thumbTime":"2022-04-12 11:19","timeText":"2022-04-12","hasRead":"1"}],"pageable":{"sort":{"sorted":false,"unsorted":true},"pageSize":10,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"totalPages":2,"totalElements":13,"last":false,"number":0,"size":10,"numberOfElements":10,"sort":{"sorted":false,"unsorted":true},"first":true}
     */

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataBean data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MsgThumbBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * content : [{"_id":"1037367162261471232","beUid":"1499922423573647361","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一...","url":"/m/1587633183589064705","nickname":"CH-Android","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1290102301154942976","thumbTime":"2022-11-02 14:06","timeText":"2小时前","hasRead":"1"},{"_id":"1037367145224208384","beUid":"1499922423573647361","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一...","url":"/m/1587633183589064705","nickname":"搬砖侠","avatar":"https://images.sunofbeaches.com/content/2022_04_14/964124335407104000.png","uid":"1504452765877800961","thumbTime":"2022-11-02 14:06","timeText":"2小时前","hasRead":"1"},{"_id":"1037327360233308160","beUid":"1499922423573647361","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一...","url":"/m/1587633183589064705","nickname":"纠结轮","avatar":"https://images.sunofbeaches.com/content/2022_07_04/993567554951708672.png","uid":"1250988207093321728","thumbTime":"2022-11-02 11:28","timeText":"4小时前","hasRead":"1"},{"_id":"1037319506357125120","beUid":"1499922423573647361","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一...","url":"/m/1587633183589064705","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","uid":"1139423796017500160","thumbTime":"2022-11-02 10:57","timeText":"5小时前","hasRead":"1"},{"_id":"1031655229503832064","beUid":"1499922423573647361","title":"🙂","url":"/qa/1510193205515186177#1031292957199695872","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","thumbTime":"2022-10-17 19:49","timeText":"15天前","hasRead":"1"},{"_id":"1031655175468613632","beUid":"1499922423573647361","title":"测试发送","url":"/qa/1510193205515186177#1031293678443823104","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","thumbTime":"2022-10-17 19:49","timeText":"15天前","hasRead":"1"},{"_id":"1031655115930468352","beUid":"1499922423573647361","title":"测试测试","url":"/qa/1510193205515186177#1031294543414165504","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","thumbTime":"2022-10-17 19:49","timeText":"15天前","hasRead":"1"},{"_id":"1031616993318404096","beUid":"1499922423573647361","title":"领券联盟生成淘口令失败","url":"/qa/1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","thumbTime":"2022-10-17 17:17","timeText":"15天前","hasRead":"1"},{"_id":"1021082391038394368","beUid":"1499922423573647361","title":"Retrofit初始化问题","url":"/qa/1513107843181506562","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","thumbTime":"2022-09-18 15:36","timeText":"2022-09-18","hasRead":"1"},{"_id":"963397938795511808","beUid":"1499922423573647361","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<im...","url":"/m/1513442206020595713","nickname":"年年","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/3B/rBsADV_eE-OAC--fAABO7gT-pcY862.png","uid":"1339887900006932480","thumbTime":"2022-04-12 11:19","timeText":"2022-04-12","hasRead":"1"}]
         * pageable : {"sort":{"sorted":false,"unsorted":true},"pageSize":10,"pageNumber":0,"offset":0,"paged":true,"unpaged":false}
         * totalPages : 2
         * totalElements : 13
         * last : false
         * number : 0
         * size : 10
         * numberOfElements : 10
         * sort : {"sorted":false,"unsorted":true}
         * first : true
         */

        @SerializedName("pageable")
        private PageableBean pageable;
        @SerializedName("totalPages")
        private Integer totalPages;
        @SerializedName("totalElements")
        private Integer totalElements;
        @SerializedName("last")
        private Boolean last;
        @SerializedName("number")
        private Integer number;
        @SerializedName("size")
        private Integer size;
        @SerializedName("numberOfElements")
        private Integer numberOfElements;
        @SerializedName("sort")
        private SortBeanX sort;
        @SerializedName("first")
        private Boolean first;
        @SerializedName("content")
        private List<ContentBean> content;

        public PageableBean getPageable() {
            return pageable;
        }

        public void setPageable(PageableBean pageable) {
            this.pageable = pageable;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        public Integer getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(Integer totalElements) {
            this.totalElements = totalElements;
        }

        public Boolean getLast() {
            return last;
        }

        public void setLast(Boolean last) {
            this.last = last;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(Integer numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public SortBeanX getSort() {
            return sort;
        }

        public void setSort(SortBeanX sort) {
            this.sort = sort;
        }

        public Boolean getFirst() {
            return first;
        }

        public void setFirst(Boolean first) {
            this.first = first;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        public void setContent(List<ContentBean> content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "pageable=" + pageable +
                    ", totalPages=" + totalPages +
                    ", totalElements=" + totalElements +
                    ", last=" + last +
                    ", number=" + number +
                    ", size=" + size +
                    ", numberOfElements=" + numberOfElements +
                    ", sort=" + sort +
                    ", first=" + first +
                    ", content=" + content +
                    '}';
        }

        public static class PageableBean implements Serializable {
            /**
             * sort : {"sorted":false,"unsorted":true}
             * pageSize : 10
             * pageNumber : 0
             * offset : 0
             * paged : true
             * unpaged : false
             */

            @SerializedName("sort")
            private SortBean sort;
            @SerializedName("pageSize")
            private Integer pageSize;
            @SerializedName("pageNumber")
            private Integer pageNumber;
            @SerializedName("offset")
            private Integer offset;
            @SerializedName("paged")
            private Boolean paged;
            @SerializedName("unpaged")
            private Boolean unpaged;

            public SortBean getSort() {
                return sort;
            }

            public void setSort(SortBean sort) {
                this.sort = sort;
            }

            public Integer getPageSize() {
                return pageSize;
            }

            public void setPageSize(Integer pageSize) {
                this.pageSize = pageSize;
            }

            public Integer getPageNumber() {
                return pageNumber;
            }

            public void setPageNumber(Integer pageNumber) {
                this.pageNumber = pageNumber;
            }

            public Integer getOffset() {
                return offset;
            }

            public void setOffset(Integer offset) {
                this.offset = offset;
            }

            public Boolean getPaged() {
                return paged;
            }

            public void setPaged(Boolean paged) {
                this.paged = paged;
            }

            public Boolean getUnpaged() {
                return unpaged;
            }

            public void setUnpaged(Boolean unpaged) {
                this.unpaged = unpaged;
            }

            @Override
            public String toString() {
                return "PageableBean{" +
                        "sort=" + sort +
                        ", pageSize=" + pageSize +
                        ", pageNumber=" + pageNumber +
                        ", offset=" + offset +
                        ", paged=" + paged +
                        ", unpaged=" + unpaged +
                        '}';
            }

            public static class SortBean implements Serializable {
                /**
                 * sorted : false
                 * unsorted : true
                 */

                @SerializedName("sorted")
                private Boolean sorted;
                @SerializedName("unsorted")
                private Boolean unsorted;

                public Boolean getSorted() {
                    return sorted;
                }

                public void setSorted(Boolean sorted) {
                    this.sorted = sorted;
                }

                public Boolean getUnsorted() {
                    return unsorted;
                }

                public void setUnsorted(Boolean unsorted) {
                    this.unsorted = unsorted;
                }

                @Override
                public String toString() {
                    return "SortBean{" +
                            "sorted=" + sorted +
                            ", unsorted=" + unsorted +
                            '}';
                }
            }
        }


        public static class SortBeanX implements Serializable {
            /**
             * sorted : false
             * unsorted : true
             */

            @SerializedName("sorted")
            private Boolean sorted;
            @SerializedName("unsorted")
            private Boolean unsorted;

            public Boolean getSorted() {
                return sorted;
            }

            public void setSorted(Boolean sorted) {
                this.sorted = sorted;
            }

            public Boolean getUnsorted() {
                return unsorted;
            }

            public void setUnsorted(Boolean unsorted) {
                this.unsorted = unsorted;
            }

            @Override
            public String toString() {
                return "SortBeanX{" +
                        "sorted=" + sorted +
                        ", unsorted=" + unsorted +
                        '}';
            }
        }


        public static class ContentBean  extends MsgBean implements Serializable {
            /**
             * _id : 1037367162261471232
             * beUid : 1499922423573647361
             * title : 有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一...
             * url : /m/1587633183589064705
             * nickname : CH-Android
             * avatar : https://cdn.sunofbeaches.com/images/default_avatar.png
             * uid : 1290102301154942976
             * thumbTime : 2022-11-02 14:06
             * timeText : 2小时前
             * hasRead : 1
             */

            @SerializedName("_id")
            private String id;
            @SerializedName("beUid")
            private String beUid;
            @SerializedName("title")
            private String title;
            @SerializedName("url")
            private String url;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("uid")
            private String uid;
            @SerializedName("thumbTime")
            private String thumbTime;
            @SerializedName("timeText")
            private String timeText;
            @SerializedName("hasRead")
            private String hasRead;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getBeUid() {
                return beUid;
            }

            public void setBeUid(String beUid) {
                this.beUid = beUid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getThumbTime() {
                return thumbTime;
            }

            public void setThumbTime(String thumbTime) {
                this.thumbTime = thumbTime;
            }

            public String getTimeText() {
                return timeText;
            }

            public void setTimeText(String timeText) {
                this.timeText = timeText;
            }

            public String getHasRead() {
                return hasRead;
            }

            public void setHasRead(String hasRead) {
                this.hasRead = hasRead;
            }

            @Override
            public String toString() {
                return "ContentBean{" +
                        "id='" + id + '\'' +
                        ", beUid='" + beUid + '\'' +
                        ", title='" + title + '\'' +
                        ", url='" + url + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", uid='" + uid + '\'' +
                        ", thumbTime='" + thumbTime + '\'' +
                        ", timeText='" + timeText + '\'' +
                        ", hasRead='" + hasRead + '\'' +
                        '}';
            }
        }
    }
}
