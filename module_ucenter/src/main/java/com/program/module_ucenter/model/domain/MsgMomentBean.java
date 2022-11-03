package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MsgMomentBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取成功.
     * data : {"content":[{"_id":"1587687810300829698","bUid":"1499922423573647361","momentId":"1587633183589064705","nickname":"CH-Android","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1290102301154942976","hasRead":"0","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一份暑期实习去锻炼一下，我应该去准备什么，还希望各位不吝赐教（我想...","content":"还是做web前端吧，要不就后端，纯android不太建议","createTime":"2022-11-02 14:07","timeText":null},{"_id":"1587651349442650113","bUid":"1499922423573647361","momentId":"1587633183589064705","nickname":"资质平平","avatar":"https://images.sunofbeaches.com/content/2021_06_28/859039567162900480.png","uid":"1371290811857235968","hasRead":"0","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一份暑期实习去锻炼一下，我应该去准备什么，还希望各位不吝赐教（我想...","content":"建议打基础+1，Java基础过一遍，第一行代码过一遍，然后康师傅的项目练习","createTime":"2022-11-02 11:42","timeText":null},{"_id":"1587649758803189762","bUid":"1499922423573647361","momentId":"1587633183589064705","nickname":"温油的老舅","avatar":"https://images.sunofbeaches.com/content/2022_03_23/956117482517561344.png","uid":"1231137268748521472","hasRead":"0","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一份暑期实习去锻炼一下，我应该去准备什么，还希望各位不吝赐教（我想...","content":"康师傅教程看完  那几个案例搞出来  能搞个沙滩app最好了 然后就看命了","createTime":"2022-11-02 11:36","timeText":null},{"_id":"1587647831063322626","bUid":"1499922423573647361","momentId":"1587633183589064705","nickname":"纠结轮","avatar":"https://images.sunofbeaches.com/content/2022_07_04/993567554951708672.png","uid":"1250988207093321728","hasRead":"0","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一份暑期实习去锻炼一下，我应该去准备什么，还希望各位不吝赐教（我想...","content":"安卓开发不好找哦，我也是学安卓的、后面转后端了","createTime":"2022-11-02 11:28","timeText":null},{"_id":"1587640088294252545","bUid":"1499922423573647361","momentId":"1587633183589064705","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","uid":"1139423796017500160","hasRead":"0","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一份暑期实习去锻炼一下，我应该去准备什么，还希望各位不吝赐教（我想...","content":"你安卓基础如何，好好打基础吧","createTime":"2022-11-02 10:57","timeText":null},{"_id":"1513828129153544194","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"阿桥","avatar":"https://images.sunofbeaches.com/content/2022_02_25/946875328612007936.png","uid":"1497193244834926593","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"官方有","createTime":"2022-04-12 18:35","timeText":null},{"_id":"1513466043357523970","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"ALEX","avatar":"https://images.sunofbeaches.com/content/2022_03_29/958358748433219584.png","uid":"1268774545783795712","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"之前学过了喜马拉雅和领券联盟的话，可以自己搞一个，想怎么造就怎么造","createTime":"2022-04-11 18:36","timeText":null},{"_id":"1513458930774241282","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"工头断点","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/04/rBsADV2YuTKABc4DAABfJHgYqP8031.png","uid":"1139423796017500160","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"康师傅已经出了交互图，剩下的让我们自由发挥","createTime":"2022-04-11 18:08","timeText":null},{"_id":"1513457831329722370","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"A lonely cat","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/0C/rBsADV3w3l6ATs8KAAA8tUB7EHo702.png","uid":"1204736502274318336","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"代码在这里  https://github.com/anjiemo/SunnyBeach","createTime":"2022-04-11 18:04","timeText":null},{"_id":"1513457513044963330","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"有意思的少年","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","uid":"1433361655298891777","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"我就是参照小默的来写的，摸鱼模块接口基本都弄完了","createTime":"2022-04-11 18:02","timeText":null},{"_id":"1513449502679298050","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"阿肥","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927947264050069504.png","uid":"1382711465131241472","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"小默的源码都共享出来了 学开发思路之前那些不就够啦 你就是想\u201c白嫖\u201d个新app哈哈哈","createTime":"2022-04-11 17:30","timeText":null},{"_id":"1513442799099375617","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","uid":"1153952789488054272","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"考虑过，暂时不出[龇牙]，可以参考断点，小默写的代码。你自己下载来看看，侧栏扫码就可以下载。","createTime":"2022-04-11 17:04","timeText":null}],"pageable":{"sort":{"sorted":true,"unsorted":false},"pageSize":30,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"totalPages":1,"totalElements":12,"last":true,"number":0,"size":30,"numberOfElements":12,"sort":{"sorted":true,"unsorted":false},"first":true}
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
        return "MsgMomentBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * content : [{"_id":"1587687810300829698","bUid":"1499922423573647361","momentId":"1587633183589064705","nickname":"CH-Android","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","uid":"1290102301154942976","hasRead":"0","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一份暑期实习去锻炼一下，我应该去准备什么，还希望各位不吝赐教（我想...","content":"还是做web前端吧，要不就后端，纯android不太建议","createTime":"2022-11-02 14:07","timeText":null},{"_id":"1587651349442650113","bUid":"1499922423573647361","momentId":"1587633183589064705","nickname":"资质平平","avatar":"https://images.sunofbeaches.com/content/2021_06_28/859039567162900480.png","uid":"1371290811857235968","hasRead":"0","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一份暑期实习去锻炼一下，我应该去准备什么，还希望各位不吝赐教（我想...","content":"建议打基础+1，Java基础过一遍，第一行代码过一遍，然后康师傅的项目练习","createTime":"2022-11-02 11:42","timeText":null},{"_id":"1587649758803189762","bUid":"1499922423573647361","momentId":"1587633183589064705","nickname":"温油的老舅","avatar":"https://images.sunofbeaches.com/content/2022_03_23/956117482517561344.png","uid":"1231137268748521472","hasRead":"0","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一份暑期实习去锻炼一下，我应该去准备什么，还希望各位不吝赐教（我想...","content":"康师傅教程看完  那几个案例搞出来  能搞个沙滩app最好了 然后就看命了","createTime":"2022-11-02 11:36","timeText":null},{"_id":"1587647831063322626","bUid":"1499922423573647361","momentId":"1587633183589064705","nickname":"纠结轮","avatar":"https://images.sunofbeaches.com/content/2022_07_04/993567554951708672.png","uid":"1250988207093321728","hasRead":"0","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一份暑期实习去锻炼一下，我应该去准备什么，还希望各位不吝赐教（我想...","content":"安卓开发不好找哦，我也是学安卓的、后面转后端了","createTime":"2022-11-02 11:28","timeText":null},{"_id":"1587640088294252545","bUid":"1499922423573647361","momentId":"1587633183589064705","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","uid":"1139423796017500160","hasRead":"0","title":"有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一份暑期实习去锻炼一下，我应该去准备什么，还希望各位不吝赐教（我想...","content":"你安卓基础如何，好好打基础吧","createTime":"2022-11-02 10:57","timeText":null},{"_id":"1513828129153544194","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"阿桥","avatar":"https://images.sunofbeaches.com/content/2022_02_25/946875328612007936.png","uid":"1497193244834926593","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"官方有","createTime":"2022-04-12 18:35","timeText":null},{"_id":"1513466043357523970","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"ALEX","avatar":"https://images.sunofbeaches.com/content/2022_03_29/958358748433219584.png","uid":"1268774545783795712","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"之前学过了喜马拉雅和领券联盟的话，可以自己搞一个，想怎么造就怎么造","createTime":"2022-04-11 18:36","timeText":null},{"_id":"1513458930774241282","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"工头断点","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/04/rBsADV2YuTKABc4DAABfJHgYqP8031.png","uid":"1139423796017500160","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"康师傅已经出了交互图，剩下的让我们自由发挥","createTime":"2022-04-11 18:08","timeText":null},{"_id":"1513457831329722370","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"A lonely cat","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/0C/rBsADV3w3l6ATs8KAAA8tUB7EHo702.png","uid":"1204736502274318336","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"代码在这里  https://github.com/anjiemo/SunnyBeach","createTime":"2022-04-11 18:04","timeText":null},{"_id":"1513457513044963330","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"有意思的少年","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","uid":"1433361655298891777","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"我就是参照小默的来写的，摸鱼模块接口基本都弄完了","createTime":"2022-04-11 18:02","timeText":null},{"_id":"1513449502679298050","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"阿肥","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927947264050069504.png","uid":"1382711465131241472","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"小默的源码都共享出来了 学开发思路之前那些不就够啦 你就是想\u201c白嫖\u201d个新app哈哈哈","createTime":"2022-04-11 17:30","timeText":null},{"_id":"1513442799099375617","bUid":"1499922423573647361","momentId":"1513442206020595713","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","uid":"1153952789488054272","hasRead":"1","title":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn...","content":"考虑过，暂时不出[龇牙]，可以参考断点，小默写的代码。你自己下载来看看，侧栏扫码就可以下载。","createTime":"2022-04-11 17:04","timeText":null}]
         * pageable : {"sort":{"sorted":true,"unsorted":false},"pageSize":30,"pageNumber":0,"offset":0,"paged":true,"unpaged":false}
         * totalPages : 1
         * totalElements : 12
         * last : true
         * number : 0
         * size : 30
         * numberOfElements : 12
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


        public static class ContentBean extends MsgBean implements Serializable {
            /**
             * _id : 1587687810300829698
             * bUid : 1499922423573647361
             * momentId : 1587633183589064705
             * nickname : CH-Android
             * avatar : https://cdn.sunofbeaches.com/images/default_avatar.png
             * uid : 1290102301154942976
             * hasRead : 0
             * title : 有没有同学做过暑期实习的，我现在大三学历没优势，我想在明年去找一份暑期实习去锻炼一下，我应该去准备什么，还希望各位不吝赐教（我想...
             * content : 还是做web前端吧，要不就后端，纯android不太建议
             * createTime : 2022-11-02 14:07
             * timeText : null
             */

            @SerializedName("_id")
            private String id;
            @SerializedName("bUid")
            private String bUid;
            @SerializedName("momentId")
            private String momentId;
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
            @SerializedName("content")
            private String content;
            @SerializedName("createTime")
            private String createTime;
            @SerializedName("timeText")
            private Object timeText;

            public String getId() {
                return id;
            }

            public String getbUid() {
                return bUid;
            }

            public String getMomentId() {
                return momentId;
            }

            public String getNickname() {
                return nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public String getUid() {
                return uid;
            }

            public String getHasRead() {
                return hasRead;
            }

            public String getTitle() {
                return title;
            }

            public String getContent() {
                return content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public Object getTimeText() {
                return timeText;
            }

            @Override
            public String toString() {
                return "ContentBean{" +
                        "id='" + id + '\'' +
                        ", bUid='" + bUid + '\'' +
                        ", momentId='" + momentId + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", uid='" + uid + '\'' +
                        ", hasRead='" + hasRead + '\'' +
                        ", title='" + title + '\'' +
                        ", content='" + content + '\'' +
                        ", createTime='" + createTime + '\'' +
                        ", timeText=" + timeText +
                        '}';
            }
        }
    }
}
