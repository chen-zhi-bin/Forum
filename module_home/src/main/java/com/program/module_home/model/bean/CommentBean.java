package com.program.module_home.model.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;
import com.program.lib_common.Constants;
import com.program.moudle_base.model.SubCommentBean;

import java.io.Serializable;
import java.util.List;

public class CommentBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 查询成功.
     * data : {"content":[{"_id":"1029445731850649600","articleId":"1579661926751801346","commentContent":"拉大锯责任有限公司","userId":"1256120724666454016","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989093103333801984.png","nickname":"夙夜星辰叹","publishTime":"2022-10-11 17:29","parentId":"0","role":"ROLE_VIP","isTop":"0","subComments":[{"_id":"1029715120537731072","parentId":"1029445731850649600","beUid":"1256120724666454016","beNickname":"夙夜星辰叹","yourAvatar":"https://images.sunofbeaches.com/content/2022_02_23/946075681748418560.jpg","yourRole":null,"yourNickname":"包租公","yourUid":"1438863588197507073","content":"无责任阿","publishTime":"2022-10-12 11:20","articleId":"1579661926751801346","vip":false}],"vip":true},{"_id":"1029423169875738624","articleId":"1579661926751801346","commentContent":"来广州收租[滑稽][滑稽]","userId":"1438863588197507073","avatar":"https://images.sunofbeaches.com/content/2022_02_23/946075681748418560.jpg","nickname":"包租公","publishTime":"2022-10-11 16:00","parentId":"0","role":null,"isTop":"0","subComments":[{"_id":"1029434284907167744","parentId":"1029423169875738624","beUid":"1438863588197507073","beNickname":"包租公","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"那也得有栋房子呀。","publishTime":"2022-10-11 16:44","articleId":"1579661926751801346","vip":false},{"_id":"1029715229468000256","parentId":"1029423169875738624","beUid":"1153952789488054272","beNickname":"拉大锯","yourAvatar":"https://images.sunofbeaches.com/content/2022_02_23/946075681748418560.jpg","yourRole":null,"yourNickname":"包租公","yourUid":"1438863588197507073","content":"[doge][doge]","publishTime":"2022-10-12 11:20","articleId":"1579661926751801346","vip":false}],"vip":false},{"_id":"1029413919430541312","articleId":"1579661926751801346","commentContent":"为啥合并事业部就要辞职啊，太忙吗还是那个部门不喜欢","userId":"1314408005793603584","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","nickname":"ccTyL","publishTime":"2022-10-11 15:23","parentId":"0","role":null,"isTop":"0","subComments":[{"_id":"1029422461789143040","parentId":"1029413919430541312","beUid":"1314408005793603584","beNickname":"ccTyL","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"不是我喜欢的工作方式","publishTime":"2022-10-11 15:57","articleId":"1579661926751801346","vip":false}],"vip":false},{"_id":"1029407992702828544","articleId":"1579661926751801346","commentContent":"换一个城市卷~","userId":"1274165387499433984","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/2A/rBsADV80qt6ASPajAABRTM8wiqs313.png","nickname":"南城阿宇","publishTime":"2022-10-11 14:59","parentId":"0","role":"ROLE_VIP","isTop":"0","subComments":[{"_id":"1029422590877237248","parentId":"1029407992702828544","beUid":"1274165387499433984","beNickname":"南城阿宇","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"是的，哈哈。","publishTime":"2022-10-11 15:57","articleId":"1579661926751801346","vip":false}],"vip":true},{"_id":"1029367258926809088","articleId":"1579661926751801346","commentContent":"有些人离职了找工作，有人离职了自己开公司，我不说是谁","userId":"1139423796017500160","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","nickname":"断点","publishTime":"2022-10-11 12:17","parentId":"0","role":"ROLE_VIP","isTop":"0","subComments":[{"_id":"1029396887511236608","parentId":"1029367258926809088","beUid":"1139423796017500160","beNickname":"断点","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"我应该会在海珠区，你在越秀，哈哈。","publishTime":"2022-10-11 14:15","articleId":"1579661926751801346","vip":false},{"_id":"1029397454967013376","parentId":"1029367258926809088","beUid":"1153952789488054272","beNickname":"拉大锯","yourAvatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","yourRole":"ROLE_VIP","yourNickname":"断点","yourUid":"1139423796017500160","content":"大佬🐂，来广州开公司嘛","publishTime":"2022-10-11 14:17","articleId":"1579661926751801346","vip":true},{"_id":"1029422290355355648","parentId":"1029367258926809088","beUid":"1139423796017500160","beNickname":"断点","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"玩起来再说吧，玩不起来就不说了。","publishTime":"2022-10-11 15:56","articleId":"1579661926751801346","vip":false},{"_id":"1029424627098583040","parentId":"1029367258926809088","beUid":"1153952789488054272","beNickname":"拉大锯","yourAvatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","yourRole":"ROLE_VIP","yourNickname":"断点","yourUid":"1139423796017500160","content":"必须搞起来，以后做老板了就可以收购别的公司。","publishTime":"2022-10-11 16:05","articleId":"1579661926751801346","vip":true},{"_id":"1029434213188763648","parentId":"1029367258926809088","beUid":"1139423796017500160","beNickname":"断点","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"得看业务有没有，方向是做纯软件的了，没有啥竞争力。靠关系搞业务，必要时还需要你的支援呀。","publishTime":"2022-10-11 16:44","articleId":"1579661926751801346","vip":false},{"_id":"1029511550706122752","parentId":"1029367258926809088","beUid":"1153952789488054272","beNickname":"拉大锯","yourAvatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","yourRole":"ROLE_VIP","yourNickname":"断点","yourUid":"1139423796017500160","content":"😂原来是抱大腿","publishTime":"2022-10-11 21:51","articleId":"1579661926751801346","vip":true}],"vip":true},{"_id":"1029356540882059264","articleId":"1579661926751801346","commentContent":"下一步准备干啥去？","userId":"1272797637732495360","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/36/rBsADV-b1tyAd8VRAABY6RLCx9o219.png","nickname":"xujun20200616","publishTime":"2022-10-11 11:35","parentId":"0","role":null,"isTop":"0","subComments":[{"_id":"1029359484171976704","parentId":"1029356540882059264","beUid":"1272797637732495360","beNickname":"xujun20200616","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"改变世界","publishTime":"2022-10-11 11:47","articleId":"1579661926751801346","vip":false},{"_id":"1029375471332098048","parentId":"1029356540882059264","beUid":"1153952789488054272","beNickname":"拉大锯","yourAvatar":"https://imgs.sunofbeaches.com/group1/M00/00/36/rBsADV-b1tyAd8VRAABY6RLCx9o219.png","yourRole":null,"yourNickname":"xujun20200616","yourUid":"1272797637732495360","content":"Great IDEA","publishTime":"2022-10-11 12:50","articleId":"1579661926751801346","vip":false}],"vip":false}],"pageable":{"sort":{"sorted":true,"unsorted":false},"pageSize":30,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"totalPages":1,"totalElements":6,"last":true,"number":0,"size":30,"numberOfElements":6,"sort":{"sorted":true,"unsorted":false},"first":true}
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
        return "CommentBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * content : [{"_id":"1029445731850649600","articleId":"1579661926751801346","commentContent":"拉大锯责任有限公司","userId":"1256120724666454016","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989093103333801984.png","nickname":"夙夜星辰叹","publishTime":"2022-10-11 17:29","parentId":"0","role":"ROLE_VIP","isTop":"0","subComments":[{"_id":"1029715120537731072","parentId":"1029445731850649600","beUid":"1256120724666454016","beNickname":"夙夜星辰叹","yourAvatar":"https://images.sunofbeaches.com/content/2022_02_23/946075681748418560.jpg","yourRole":null,"yourNickname":"包租公","yourUid":"1438863588197507073","content":"无责任阿","publishTime":"2022-10-12 11:20","articleId":"1579661926751801346","vip":false}],"vip":true},{"_id":"1029423169875738624","articleId":"1579661926751801346","commentContent":"来广州收租[滑稽][滑稽]","userId":"1438863588197507073","avatar":"https://images.sunofbeaches.com/content/2022_02_23/946075681748418560.jpg","nickname":"包租公","publishTime":"2022-10-11 16:00","parentId":"0","role":null,"isTop":"0","subComments":[{"_id":"1029434284907167744","parentId":"1029423169875738624","beUid":"1438863588197507073","beNickname":"包租公","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"那也得有栋房子呀。","publishTime":"2022-10-11 16:44","articleId":"1579661926751801346","vip":false},{"_id":"1029715229468000256","parentId":"1029423169875738624","beUid":"1153952789488054272","beNickname":"拉大锯","yourAvatar":"https://images.sunofbeaches.com/content/2022_02_23/946075681748418560.jpg","yourRole":null,"yourNickname":"包租公","yourUid":"1438863588197507073","content":"[doge][doge]","publishTime":"2022-10-12 11:20","articleId":"1579661926751801346","vip":false}],"vip":false},{"_id":"1029413919430541312","articleId":"1579661926751801346","commentContent":"为啥合并事业部就要辞职啊，太忙吗还是那个部门不喜欢","userId":"1314408005793603584","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","nickname":"ccTyL","publishTime":"2022-10-11 15:23","parentId":"0","role":null,"isTop":"0","subComments":[{"_id":"1029422461789143040","parentId":"1029413919430541312","beUid":"1314408005793603584","beNickname":"ccTyL","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"不是我喜欢的工作方式","publishTime":"2022-10-11 15:57","articleId":"1579661926751801346","vip":false}],"vip":false},{"_id":"1029407992702828544","articleId":"1579661926751801346","commentContent":"换一个城市卷~","userId":"1274165387499433984","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/2A/rBsADV80qt6ASPajAABRTM8wiqs313.png","nickname":"南城阿宇","publishTime":"2022-10-11 14:59","parentId":"0","role":"ROLE_VIP","isTop":"0","subComments":[{"_id":"1029422590877237248","parentId":"1029407992702828544","beUid":"1274165387499433984","beNickname":"南城阿宇","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"是的，哈哈。","publishTime":"2022-10-11 15:57","articleId":"1579661926751801346","vip":false}],"vip":true},{"_id":"1029367258926809088","articleId":"1579661926751801346","commentContent":"有些人离职了找工作，有人离职了自己开公司，我不说是谁","userId":"1139423796017500160","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","nickname":"断点","publishTime":"2022-10-11 12:17","parentId":"0","role":"ROLE_VIP","isTop":"0","subComments":[{"_id":"1029396887511236608","parentId":"1029367258926809088","beUid":"1139423796017500160","beNickname":"断点","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"我应该会在海珠区，你在越秀，哈哈。","publishTime":"2022-10-11 14:15","articleId":"1579661926751801346","vip":false},{"_id":"1029397454967013376","parentId":"1029367258926809088","beUid":"1153952789488054272","beNickname":"拉大锯","yourAvatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","yourRole":"ROLE_VIP","yourNickname":"断点","yourUid":"1139423796017500160","content":"大佬🐂，来广州开公司嘛","publishTime":"2022-10-11 14:17","articleId":"1579661926751801346","vip":true},{"_id":"1029422290355355648","parentId":"1029367258926809088","beUid":"1139423796017500160","beNickname":"断点","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"玩起来再说吧，玩不起来就不说了。","publishTime":"2022-10-11 15:56","articleId":"1579661926751801346","vip":false},{"_id":"1029424627098583040","parentId":"1029367258926809088","beUid":"1153952789488054272","beNickname":"拉大锯","yourAvatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","yourRole":"ROLE_VIP","yourNickname":"断点","yourUid":"1139423796017500160","content":"必须搞起来，以后做老板了就可以收购别的公司。","publishTime":"2022-10-11 16:05","articleId":"1579661926751801346","vip":true},{"_id":"1029434213188763648","parentId":"1029367258926809088","beUid":"1139423796017500160","beNickname":"断点","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"得看业务有没有，方向是做纯软件的了，没有啥竞争力。靠关系搞业务，必要时还需要你的支援呀。","publishTime":"2022-10-11 16:44","articleId":"1579661926751801346","vip":false},{"_id":"1029511550706122752","parentId":"1029367258926809088","beUid":"1153952789488054272","beNickname":"拉大锯","yourAvatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","yourRole":"ROLE_VIP","yourNickname":"断点","yourUid":"1139423796017500160","content":"😂原来是抱大腿","publishTime":"2022-10-11 21:51","articleId":"1579661926751801346","vip":true}],"vip":true},{"_id":"1029356540882059264","articleId":"1579661926751801346","commentContent":"下一步准备干啥去？","userId":"1272797637732495360","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/36/rBsADV-b1tyAd8VRAABY6RLCx9o219.png","nickname":"xujun20200616","publishTime":"2022-10-11 11:35","parentId":"0","role":null,"isTop":"0","subComments":[{"_id":"1029359484171976704","parentId":"1029356540882059264","beUid":"1272797637732495360","beNickname":"xujun20200616","yourAvatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","yourRole":"ROLE_SUPER_ADMIN,ROLE_TEACHER","yourNickname":"拉大锯","yourUid":"1153952789488054272","content":"改变世界","publishTime":"2022-10-11 11:47","articleId":"1579661926751801346","vip":false},{"_id":"1029375471332098048","parentId":"1029356540882059264","beUid":"1153952789488054272","beNickname":"拉大锯","yourAvatar":"https://imgs.sunofbeaches.com/group1/M00/00/36/rBsADV-b1tyAd8VRAABY6RLCx9o219.png","yourRole":null,"yourNickname":"xujun20200616","yourUid":"1272797637732495360","content":"Great IDEA","publishTime":"2022-10-11 12:50","articleId":"1579661926751801346","vip":false}],"vip":false}]
         * pageable : {"sort":{"sorted":true,"unsorted":false},"pageSize":30,"pageNumber":0,"offset":0,"paged":true,"unpaged":false}
         * totalPages : 1
         * totalElements : 6
         * last : true
         * number : 0
         * size : 30
         * numberOfElements : 6
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


        public static class ContentBean implements Serializable , MultiItemEntity {
            /**
             * _id : 1029445731850649600
             * articleId : 1579661926751801346
             * commentContent : 拉大锯责任有限公司
             * userId : 1256120724666454016
             * avatar : https://images.sunofbeaches.com/content/2022_06_22/989093103333801984.png
             * nickname : 夙夜星辰叹
             * publishTime : 2022-10-11 17:29
             * parentId : 0
             * role : ROLE_VIP
             * isTop : 0
             * subComments : [{"_id":"1029715120537731072","parentId":"1029445731850649600","beUid":"1256120724666454016","beNickname":"夙夜星辰叹","yourAvatar":"https://images.sunofbeaches.com/content/2022_02_23/946075681748418560.jpg","yourRole":null,"yourNickname":"包租公","yourUid":"1438863588197507073","content":"无责任阿","publishTime":"2022-10-12 11:20","articleId":"1579661926751801346","vip":false}]
             * vip : true
             */

            @SerializedName("_id")
            private String id;
            @SerializedName("articleId")
            private String articleId;
            @SerializedName("commentContent")
            private String commentContent;
            @SerializedName("userId")
            private String userId;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("publishTime")
            private String publishTime;
            @SerializedName("parentId")
            private String parentId;
            @SerializedName("role")
            private String role;
            @SerializedName("isTop")
            private String isTop;
            @SerializedName("vip")
            private Boolean vip;
            @SerializedName("subComments")
            private List<SubCommentBean> subComments;

            public String getId() {
                return id;
            }

            public String getArticleId() {
                return articleId;
            }

            public String getCommentContent() {
                return commentContent;
            }

            public String getUserId() {
                return userId;
            }

            public String getAvatar() {
                return avatar;
            }

            public String getNickname() {
                return nickname;
            }

            public String getPublishTime() {
                return publishTime;
            }

            public String getParentId() {
                return parentId;
            }

            public String getRole() {
                return role;
            }

            public String getIsTop() {
                return isTop;
            }

            public Boolean getVip() {
                return vip;
            }

            public List<SubCommentBean> getSubComments() {
                return subComments;
            }

            @Override
            public String toString() {
                return "ContentBean{" +
                        "id='" + id + '\'' +
                        ", articleId='" + articleId + '\'' +
                        ", commentContent='" + commentContent + '\'' +
                        ", userId='" + userId + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", publishTime='" + publishTime + '\'' +
                        ", parentId='" + parentId + '\'' +
                        ", role='" + role + '\'' +
                        ", isTop='" + isTop + '\'' +
                        ", vip=" + vip +
                        ", subComments=" + subComments +
                        '}';
            }

            @Override
            public int getItemType() {
                return Constants.MultiItemType.TYPE_COMMENT;
            }
        }
    }
}
