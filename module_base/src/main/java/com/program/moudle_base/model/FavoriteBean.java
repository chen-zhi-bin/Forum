package com.program.moudle_base.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FavoriteBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 查询成功.
     * data : {"content":[{"_id":"1019644078045790208","userId":"1499922423573647361","avatar":null,"userName":null,"collectionId":"1019644039198146560","title":"阳光沙滩API文档","url":"https://www.sunofbeach.net/a/1403262826952323074","type":"0","addTime":"2022-09-14 16:21","cover":""}],"pageable":{"sort":{"sorted":true,"unsorted":false},"pageSize":30,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"totalPages":1,"totalElements":1,"last":true,"number":0,"size":30,"numberOfElements":1,"sort":{"sorted":true,"unsorted":false},"first":true}
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
        return "FavoriteBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * content : [{"_id":"1019644078045790208","userId":"1499922423573647361","avatar":null,"userName":null,"collectionId":"1019644039198146560","title":"阳光沙滩API文档","url":"https://www.sunofbeach.net/a/1403262826952323074","type":"0","addTime":"2022-09-14 16:21","cover":""}]
         * pageable : {"sort":{"sorted":true,"unsorted":false},"pageSize":30,"pageNumber":0,"offset":0,"paged":true,"unpaged":false}
         * totalPages : 1
         * totalElements : 1
         * last : true
         * number : 0
         * size : 30
         * numberOfElements : 1
         * sort : {"sorted":true,"unsorted":false}
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

        public static class PageableBean implements Serializable {
            /**
             * sort : {"sorted":true,"unsorted":false}
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
                 * sorted : true
                 * unsorted : false
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
             * sorted : true
             * unsorted : false
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

        public static class ContentBean implements Serializable {
            /**
             * _id : 1019644078045790208
             * userId : 1499922423573647361
             * avatar : null
             * userName : null
             * collectionId : 1019644039198146560
             * title : 阳光沙滩API文档
             * url : https://www.sunofbeach.net/a/1403262826952323074
             * type : 0
             * addTime : 2022-09-14 16:21
             * cover :
             */

            @SerializedName("_id")
            private String id;
            @SerializedName("userId")
            private String userId;
            @SerializedName("avatar")
            private Object avatar;
            @SerializedName("userName")
            private Object userName;
            @SerializedName("collectionId")
            private String collectionId;
            @SerializedName("title")
            private String title;
            @SerializedName("url")
            private String url;
            @SerializedName("type")
            private String type;
            @SerializedName("addTime")
            private String addTime;
            @SerializedName("cover")
            private String cover;

            public String getId() {
                return id;
            }

            public String getUserId() {
                return userId;
            }

            public Object getAvatar() {
                return avatar;
            }

            public Object getUserName() {
                return userName;
            }

            public String getCollectionId() {
                return collectionId;
            }

            public String getTitle() {
                return title;
            }

            public String getUrl() {
                return url;
            }

            public String getType() {
                return type;
            }

            public String getAddTime() {
                return addTime;
            }

            public String getCover() {
                return cover;
            }

            @Override
            public String toString() {
                return "ContentBean{" +
                        "id='" + id + '\'' +
                        ", userId='" + userId + '\'' +
                        ", avatar=" + avatar +
                        ", userName=" + userName +
                        ", collectionId='" + collectionId + '\'' +
                        ", title='" + title + '\'' +
                        ", url='" + url + '\'' +
                        ", type='" + type + '\'' +
                        ", addTime='" + addTime + '\'' +
                        ", cover='" + cover + '\'' +
                        '}';
            }
        }
    }
}
