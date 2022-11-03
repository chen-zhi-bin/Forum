package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class MsgArticleBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取评论成功
     * data : {"content":[],"pageable":{"sort":{"sorted":false,"unsorted":true},"pageSize":30,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"totalPages":0,"totalElements":0,"last":true,"number":0,"size":30,"numberOfElements":0,"sort":{"sorted":false,"unsorted":true},"first":true}
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

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DataBean getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MsgArticleBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }


    public static class DataBean implements Serializable {
        /**
         * content : []
         * pageable : {"sort":{"sorted":false,"unsorted":true},"pageSize":30,"pageNumber":0,"offset":0,"paged":true,"unpaged":false}
         * totalPages : 0
         * totalElements : 0
         * last : true
         * number : 0
         * size : 30
         * numberOfElements : 0
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

        public Integer getTotalPages() {
            return totalPages;
        }

        public Integer getTotalElements() {
            return totalElements;
        }

        public Boolean getLast() {
            return last;
        }

        public Integer getNumber() {
            return number;
        }

        public Integer getSize() {
            return size;
        }

        public Integer getNumberOfElements() {
            return numberOfElements;
        }

        public SortBeanX getSort() {
            return sort;
        }

        public Boolean getFirst() {
            return first;
        }

        public List<ContentBean> getContent() {
            return content;
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

        public static class  ContentBean extends MsgBean implements Serializable{
            @SerializedName("_id")
            private String id;
            @SerializedName("articleId")
            private String articleId;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("bUid")
            private String bUid;
            @SerializedName("title")
            private String title;
            @SerializedName("content")
            private String content;
            @SerializedName("createTime")
            private String createTime;
            @SerializedName("hasRead")
            private String hasRead;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("timeText")
            private Object timeText;
            @SerializedName("uid")
            private String uid;

            public String getId() {
                return id;
            }

            public String getArticleId() {
                return articleId;
            }

            public String getAvatar() {
                return avatar;
            }

            public String getbUid() {
                return bUid;
            }

            public String getContent() {
                return content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public String getHasRead() {
                return hasRead;
            }

            public String getNickname() {
                return nickname;
            }

            public Object getTimeText() {
                return timeText;
            }

            public String getUid() {
                return uid;
            }

            public String getTitle() {
                return title;
            }

            @Override
            public String toString() {
                return "ContentBean{" +
                        "id='" + id + '\'' +
                        ", articleId='" + articleId + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", bUid='" + bUid + '\'' +
                        ", title='" + title + '\'' +
                        ", content='" + content + '\'' +
                        ", createTime='" + createTime + '\'' +
                        ", hasRead='" + hasRead + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", timeText=" + timeText +
                        ", uid='" + uid + '\'' +
                        '}';
            }
        }

        public static class PageableBean implements Serializable {
            /**
             * sort : {"sorted":false,"unsorted":true}
             * pageSize : 30
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

            public Integer getPageSize() {
                return pageSize;
            }

            public Integer getPageNumber() {
                return pageNumber;
            }

            public Integer getOffset() {
                return offset;
            }

            public Boolean getPaged() {
                return paged;
            }

            public Boolean getUnpaged() {
                return unpaged;
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

                public Boolean getUnsorted() {
                    return unsorted;
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

            public Boolean getUnsorted() {
                return unsorted;
            }

            @Override
            public String toString() {
                return "SortBeanX{" +
                        "sorted=" + sorted +
                        ", unsorted=" + unsorted +
                        '}';
            }
        }
    }
}
