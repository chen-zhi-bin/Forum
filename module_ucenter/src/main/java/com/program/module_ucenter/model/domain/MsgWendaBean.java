package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MsgWendaBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取消息成功.
     * data : {"content":[{"_id":"1031294543414165504","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:56","timeText":"17天前"},{"_id":"1031294098192990208","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:54","timeText":"17天前"},{"_id":"1031293678443823104","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:52","timeText":"17天前"},{"_id":"1031292957199695872","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:50","timeText":"17天前"},{"_id":"1031292656375824384","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:48","timeText":"17天前"},{"_id":"1031285790333730816","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:21","timeText":"18天前"},{"_id":"1031284049240391680","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:14","timeText":"18天前"},{"_id":"1000188478543101952","bUid":"1499922423573647361","wendaId":"1550152616061702146","nickname":"阿淳言出必行","avatar":"https://images.sunofbeaches.com/content/2022_02_18/944289236310294528.png","uid":"1494238633526419458","hasRead":"1","title":"fragment不显示","createTime":"2022-07-22 23:51","timeText":"2022-07-22"},{"_id":"1000069570150531072","bUid":"1499922423573647361","wendaId":"1550152616061702146","nickname":"阿肥","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","uid":"1382711465131241472","hasRead":"1","title":"fragment不显示","createTime":"2022-07-22 15:59","timeText":"2022-07-22"},{"_id":"1000044372361740288","bUid":"1499922423573647361","wendaId":"1550152616061702146","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","uid":"1139423796017500160","hasRead":"1","title":"fragment不显示","createTime":"2022-07-22 14:19","timeText":"2022-07-22"}],"pageable":{"sort":{"sorted":false,"unsorted":true},"pageSize":10,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"totalPages":3,"totalElements":27,"last":false,"number":0,"size":10,"numberOfElements":10,"sort":{"sorted":false,"unsorted":true},"first":true}
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
        return "MsgWendaBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * content : [{"_id":"1031294543414165504","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:56","timeText":"17天前"},{"_id":"1031294098192990208","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:54","timeText":"17天前"},{"_id":"1031293678443823104","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:52","timeText":"17天前"},{"_id":"1031292957199695872","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:50","timeText":"17天前"},{"_id":"1031292656375824384","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:48","timeText":"17天前"},{"_id":"1031285790333730816","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:21","timeText":"18天前"},{"_id":"1031284049240391680","bUid":"1499922423573647361","wendaId":"1510193205515186177","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1499922423573647361","hasRead":"0","title":"领券联盟生成淘口令失败","createTime":"2022-10-16 19:14","timeText":"18天前"},{"_id":"1000188478543101952","bUid":"1499922423573647361","wendaId":"1550152616061702146","nickname":"阿淳言出必行","avatar":"https://images.sunofbeaches.com/content/2022_02_18/944289236310294528.png","uid":"1494238633526419458","hasRead":"1","title":"fragment不显示","createTime":"2022-07-22 23:51","timeText":"2022-07-22"},{"_id":"1000069570150531072","bUid":"1499922423573647361","wendaId":"1550152616061702146","nickname":"阿肥","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","uid":"1382711465131241472","hasRead":"1","title":"fragment不显示","createTime":"2022-07-22 15:59","timeText":"2022-07-22"},{"_id":"1000044372361740288","bUid":"1499922423573647361","wendaId":"1550152616061702146","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","uid":"1139423796017500160","hasRead":"1","title":"fragment不显示","createTime":"2022-07-22 14:19","timeText":"2022-07-22"}]
         * pageable : {"sort":{"sorted":false,"unsorted":true},"pageSize":10,"pageNumber":0,"offset":0,"paged":true,"unpaged":false}
         * totalPages : 3
         * totalElements : 27
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

        public static class ContentBean extends MsgBean implements Serializable {
            /**
             * _id : 1031294543414165504
             * bUid : 1499922423573647361
             * wendaId : 1510193205515186177
             * nickname : 希望程序能按我想的那样运行
             * avatar : https://cdn.sunofbeaches.com/images/default_avatar.png
             * uid : 1499922423573647361
             * hasRead : 0
             * title : 领券联盟生成淘口令失败
             * createTime : 2022-10-16 19:56
             * timeText : 17天前
             */

            @SerializedName("_id")
            private String id;
            @SerializedName("bUid")
            private String bUid;
            @SerializedName("wendaId")
            private String wendaId;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("uid")
            private String uid;
            @SerializedName("hasRead")
            private String hasRead;
            @SerializedName("title")
            private String title;
            @SerializedName("createTime")
            private String createTime;
            @SerializedName("timeText")
            private String timeText;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getbUid() {
                return bUid;
            }

            public void setbUid(String bUid) {
                this.bUid = bUid;
            }

            public String getWendaId() {
                return wendaId;
            }

            public void setWendaId(String wendaId) {
                this.wendaId = wendaId;
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

            public String getHasRead() {
                return hasRead;
            }

            public void setHasRead(String hasRead) {
                this.hasRead = hasRead;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getTimeText() {
                return timeText;
            }

            public void setTimeText(String timeText) {
                this.timeText = timeText;
            }

            @Override
            public String toString() {
                return "ContentBean{" +
                        "id='" + id + '\'' +
                        ", bUid='" + bUid + '\'' +
                        ", wendaId='" + wendaId + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", uid='" + uid + '\'' +
                        ", hasRead='" + hasRead + '\'' +
                        ", title='" + title + '\'' +
                        ", createTime='" + createTime + '\'' +
                        ", timeText='" + timeText + '\'' +
                        '}';
            }
        }
    }
}
