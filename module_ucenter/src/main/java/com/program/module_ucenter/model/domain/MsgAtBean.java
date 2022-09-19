package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MsgAtBean extends MsgBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取消息列表成功.
     * data : {"content":[{"_id":"1001055310942568448","beUid":"1499922423573647361","beNickname":"希望程序能按我想的那样运行","uid":"1382711465131241472","nickname":"阿肥","url":"/qa/1550152616061702146#1000069570150531072","content":"感觉是的 相对布局计算后出不来 这是我之前写代码测出来的结果","type":"wenda","hasRead":"1","publishTime":"2022-07-25 09:16","timeText":null,"avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","exId":"1550152616061702146"},{"_id":"1529402146619920386","beUid":"1499922423573647361","beNickname":null,"uid":"1139423796017500160","nickname":"工头断点","url":"/m/1529271836540407809#1529402146619920386","content":"好的，最好中午的时间用，因为早晚会被打","type":"moment","hasRead":"1","publishTime":"2022-05-25 18:01","timeText":null,"avatar":"https://imgs.sunofbeaches.com/group1/M00/00/04/rBsADV2YuTKABc4DAABfJHgYqP8031.png","exId":"1529271836540407809"},{"_id":"965684156044410880","beUid":"1499922423573647361","beNickname":"头发和BUG只能没有一个","uid":"1438863588197507073","nickname":"魏无羡","url":"/qa/1510193205515186177#960187358274125824","content":"就是因为字段有变化，重新生成一次就好","type":"wenda","hasRead":"1","publishTime":"2022-04-18 18:44","timeText":null,"avatar":"https://images.sunofbeaches.com/content/2021_09_17/888544615043432448.png","exId":"1510193205515186177"},{"_id":"1514195648578121729","beUid":"1499922423573647361","beNickname":null,"uid":"1204736502274318336","nickname":"A lonely cat","url":"/m/1495960612599033858#1514195648578121729","content":"哈哈哈   之前我同学给我推荐过一个   后来。。。  我毕业了 ","type":"moment","hasRead":"1","publishTime":"2022-04-13 18:55","timeText":null,"avatar":"https://imgs.sunofbeaches.com/group1/M00/00/0C/rBsADV3w3l6ATs8KAAA8tUB7EHo702.png","exId":"1495960612599033858"},{"_id":"1514154751723368449","beUid":"1499922423573647361","beNickname":null,"uid":"1204736502274318336","nickname":"A lonely cat","url":"/m/1513442206020595713#1514154751723368449","content":"最新的代码在 dev 分支  记得切换分支哦","type":"moment","hasRead":"1","publishTime":"2022-04-13 16:13","timeText":null,"avatar":"https://imgs.sunofbeaches.com/group1/M00/00/0C/rBsADV3w3l6ATs8KAAA8tUB7EHo702.png","exId":"1513442206020595713"},{"_id":"963036777503784960","beUid":"1499922423573647361","beNickname":"头发和BUG只能没有一个","uid":"1302969105866940416","nickname":"RUOQ","url":"/qa/1513107843181506562#962792509430300672","content":"好，感谢反馈，不过建议还是改一下这个单例，这种单例线程不太安全","type":"wenda","hasRead":"1","publishTime":"2022-04-11 11:24","timeText":null,"avatar":"https://images.sunofbeaches.com/content/2022_04_03/960254152636628992.png","exId":"1513107843181506562"},{"_id":"962985440330121216","beUid":"1499922423573647361","beNickname":"头发和BUG只能没有一个","uid":"1302969105866940416","nickname":"RUOQ","url":"/qa/1513107843181506562#962792509430300672","content":"有没有一种可能，你那个mRetrofit没创建好就返回出去了，导致后面这个创建成功也没有用了，\n","type":"wenda","hasRead":"1","publishTime":"2022-04-11 08:00","timeText":null,"avatar":"https://images.sunofbeaches.com/content/2022_04_03/960254152636628992.png","exId":"1513107843181506562"}],"pageable":{"sort":{"sorted":true,"unsorted":false},"pageSize":10,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"totalPages":1,"totalElements":7,"last":true,"number":0,"size":10,"numberOfElements":7,"sort":{"sorted":true,"unsorted":false},"first":true}
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
        return "MsgAtBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * content : [{"_id":"1001055310942568448","beUid":"1499922423573647361","beNickname":"希望程序能按我想的那样运行","uid":"1382711465131241472","nickname":"阿肥","url":"/qa/1550152616061702146#1000069570150531072","content":"感觉是的 相对布局计算后出不来 这是我之前写代码测出来的结果","type":"wenda","hasRead":"1","publishTime":"2022-07-25 09:16","timeText":null,"avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","exId":"1550152616061702146"},{"_id":"1529402146619920386","beUid":"1499922423573647361","beNickname":null,"uid":"1139423796017500160","nickname":"工头断点","url":"/m/1529271836540407809#1529402146619920386","content":"好的，最好中午的时间用，因为早晚会被打","type":"moment","hasRead":"1","publishTime":"2022-05-25 18:01","timeText":null,"avatar":"https://imgs.sunofbeaches.com/group1/M00/00/04/rBsADV2YuTKABc4DAABfJHgYqP8031.png","exId":"1529271836540407809"},{"_id":"965684156044410880","beUid":"1499922423573647361","beNickname":"头发和BUG只能没有一个","uid":"1438863588197507073","nickname":"魏无羡","url":"/qa/1510193205515186177#960187358274125824","content":"就是因为字段有变化，重新生成一次就好","type":"wenda","hasRead":"1","publishTime":"2022-04-18 18:44","timeText":null,"avatar":"https://images.sunofbeaches.com/content/2021_09_17/888544615043432448.png","exId":"1510193205515186177"},{"_id":"1514195648578121729","beUid":"1499922423573647361","beNickname":null,"uid":"1204736502274318336","nickname":"A lonely cat","url":"/m/1495960612599033858#1514195648578121729","content":"哈哈哈   之前我同学给我推荐过一个   后来。。。  我毕业了 ","type":"moment","hasRead":"1","publishTime":"2022-04-13 18:55","timeText":null,"avatar":"https://imgs.sunofbeaches.com/group1/M00/00/0C/rBsADV3w3l6ATs8KAAA8tUB7EHo702.png","exId":"1495960612599033858"},{"_id":"1514154751723368449","beUid":"1499922423573647361","beNickname":null,"uid":"1204736502274318336","nickname":"A lonely cat","url":"/m/1513442206020595713#1514154751723368449","content":"最新的代码在 dev 分支  记得切换分支哦","type":"moment","hasRead":"1","publishTime":"2022-04-13 16:13","timeText":null,"avatar":"https://imgs.sunofbeaches.com/group1/M00/00/0C/rBsADV3w3l6ATs8KAAA8tUB7EHo702.png","exId":"1513442206020595713"},{"_id":"963036777503784960","beUid":"1499922423573647361","beNickname":"头发和BUG只能没有一个","uid":"1302969105866940416","nickname":"RUOQ","url":"/qa/1513107843181506562#962792509430300672","content":"好，感谢反馈，不过建议还是改一下这个单例，这种单例线程不太安全","type":"wenda","hasRead":"1","publishTime":"2022-04-11 11:24","timeText":null,"avatar":"https://images.sunofbeaches.com/content/2022_04_03/960254152636628992.png","exId":"1513107843181506562"},{"_id":"962985440330121216","beUid":"1499922423573647361","beNickname":"头发和BUG只能没有一个","uid":"1302969105866940416","nickname":"RUOQ","url":"/qa/1513107843181506562#962792509430300672","content":"有没有一种可能，你那个mRetrofit没创建好就返回出去了，导致后面这个创建成功也没有用了，\n","type":"wenda","hasRead":"1","publishTime":"2022-04-11 08:00","timeText":null,"avatar":"https://images.sunofbeaches.com/content/2022_04_03/960254152636628992.png","exId":"1513107843181506562"}]
         * pageable : {"sort":{"sorted":true,"unsorted":false},"pageSize":10,"pageNumber":0,"offset":0,"paged":true,"unpaged":false}
         * totalPages : 1
         * totalElements : 7
         * last : true
         * number : 0
         * size : 10
         * numberOfElements : 7
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


        public static class ContentBean extends MsgBean implements Serializable {
            /**
             * _id : 1001055310942568448
             * beUid : 1499922423573647361
             * beNickname : 希望程序能按我想的那样运行
             * uid : 1382711465131241472
             * nickname : 阿肥
             * url : /qa/1550152616061702146#1000069570150531072
             * content : 感觉是的 相对布局计算后出不来 这是我之前写代码测出来的结果
             * type : wenda
             * hasRead : 1
             * publishTime : 2022-07-25 09:16
             * timeText : null
             * avatar : https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png
             * exId : 1550152616061702146
             */

            @SerializedName("_id")
            private String id;
            @SerializedName("beUid")
            private String beUid;
            @SerializedName("beNickname")
            private String beNickname;
            @SerializedName("uid")
            private String uid;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("url")
            private String url;
            @SerializedName("content")
            private String content;
            @SerializedName("type")
            private String type;
            @SerializedName("hasRead")
            private String hasRead;
            @SerializedName("publishTime")
            private String publishTime;
            @SerializedName("timeText")
            private Object timeText;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("exId")
            private String exId;

            public String getId() {
                return id;
            }

            public String getBeUid() {
                return beUid;
            }

            public String getBeNickname() {
                return beNickname;
            }

            public String getUid() {
                return uid;
            }

            public String getNickname() {
                return nickname;
            }

            public String getUrl() {
                return url;
            }

            public String getContent() {
                return content;
            }

            public String getType() {
                return type;
            }

            public String getHasRead() {
                return hasRead;
            }

            public String getPublishTime() {
                return publishTime;
            }

            public Object getTimeText() {
                return timeText;
            }

            public String getAvatar() {
                return avatar;
            }

            public String getExId() {
                return exId;
            }

            @Override
            public String toString() {
                return "ContentBean{" +
                        "id='" + id + '\'' +
                        ", beUid='" + beUid + '\'' +
                        ", beNickname='" + beNickname + '\'' +
                        ", uid='" + uid + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", url='" + url + '\'' +
                        ", content='" + content + '\'' +
                        ", type='" + type + '\'' +
                        ", hasRead='" + hasRead + '\'' +
                        ", publishTime='" + publishTime + '\'' +
                        ", timeText=" + timeText +
                        ", avatar='" + avatar + '\'' +
                        ", exId='" + exId + '\'' +
                        '}';
            }
        }
    }
}
