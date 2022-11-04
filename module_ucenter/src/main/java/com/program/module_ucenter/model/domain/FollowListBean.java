package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//FollowBean
public class FollowListBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取关注列表成功.
     * data : {"list":[{"userId":"1511613756247904258","nickname":"dearmml","sign":"有时间会多些一点的。","avatar":"https://images.sunofbeaches.com/content/2022_10_24/1034064694509305856.png","relative":0,"vip":false},{"userId":"1549198056233111553","nickname":"春风不识路","sign":null,"avatar":"https://images.sunofbeaches.com/content/2022_07_27/1001776060259368960.png","relative":0,"vip":false},{"userId":"1442674183392829441","nickname":"呆瓜小董","sign":null,"avatar":"https://images.sunofbeaches.com/content/2022_08_11/1007290180953964544.png","relative":0,"vip":true},{"userId":"1545316498409525250","nickname":"乌拉","sign":"专业的Bug攻城狮","avatar":"https://images.sunofbeaches.com/content/2022_07_08/995030133570011136.png","relative":0,"vip":false},{"userId":"1438863588197507073","nickname":"包租公","sign":"学习摸鱼技术","avatar":"https://images.sunofbeaches.com/content/2022_02_23/946075681748418560.jpg","relative":0,"vip":false},{"userId":"1268774545783795712","nickname":"ALEX","sign":null,"avatar":"https://images.sunofbeaches.com/content/2022_03_29/958358748433219584.png","relative":0,"vip":true},{"userId":"1377559590329249792","nickname":"红蜘蛛的芒果布丁","sign":null,"avatar":"https://imgs.sunofbeaches.com/group1/M00/00/46/rBsADWBlmMyAOtJzAABf2hymrM0058.png","relative":0,"vip":false},{"userId":"1501111184194015234","nickname":"wefang3","sign":null,"avatar":"https://images.sunofbeaches.com/content/2022_05_11/973886455866720256.png","relative":0,"vip":true},{"userId":"1510944023190179842","nickname":"cubica","sign":null,"avatar":"https://images.sunofbeaches.com/content/2022_04_08/962013700544266240.png","relative":0,"vip":true},{"userId":"1527479930114281473","nickname":"黄桃罐头","sign":null,"avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","relative":0,"vip":true},{"userId":"1520570267082952706","nickname":"gs_wenbing","sign":null,"avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","relative":0,"vip":false},{"userId":"1267392066044825600","nickname":"小鲁班biubiubiu","sign":null,"avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","relative":0,"vip":true},{"userId":"1202767676435456000","nickname":"技术上无法实现","sign":"没有做不了的需求，只是技术上无法实现。","avatar":"https://images.sunofbeaches.com/content/2022_02_28/947997915148713984.png","relative":0,"vip":false},{"userId":"1433361655298891777","nickname":"有意思的少年","sign":"我刚睡醒","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","relative":0,"vip":false},{"userId":"1314408005793603584","nickname":"ccTyL","sign":"专业写bug20年","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","relative":0,"vip":false}],"total":109,"pageSize":15,"currentPage":1,"hasNext":true,"hasPre":false,"totalPage":7}
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
        return "FollowBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * list : [{"userId":"1511613756247904258","nickname":"dearmml","sign":"有时间会多些一点的。","avatar":"https://images.sunofbeaches.com/content/2022_10_24/1034064694509305856.png","relative":0,"vip":false},{"userId":"1549198056233111553","nickname":"春风不识路","sign":null,"avatar":"https://images.sunofbeaches.com/content/2022_07_27/1001776060259368960.png","relative":0,"vip":false},{"userId":"1442674183392829441","nickname":"呆瓜小董","sign":null,"avatar":"https://images.sunofbeaches.com/content/2022_08_11/1007290180953964544.png","relative":0,"vip":true},{"userId":"1545316498409525250","nickname":"乌拉","sign":"专业的Bug攻城狮","avatar":"https://images.sunofbeaches.com/content/2022_07_08/995030133570011136.png","relative":0,"vip":false},{"userId":"1438863588197507073","nickname":"包租公","sign":"学习摸鱼技术","avatar":"https://images.sunofbeaches.com/content/2022_02_23/946075681748418560.jpg","relative":0,"vip":false},{"userId":"1268774545783795712","nickname":"ALEX","sign":null,"avatar":"https://images.sunofbeaches.com/content/2022_03_29/958358748433219584.png","relative":0,"vip":true},{"userId":"1377559590329249792","nickname":"红蜘蛛的芒果布丁","sign":null,"avatar":"https://imgs.sunofbeaches.com/group1/M00/00/46/rBsADWBlmMyAOtJzAABf2hymrM0058.png","relative":0,"vip":false},{"userId":"1501111184194015234","nickname":"wefang3","sign":null,"avatar":"https://images.sunofbeaches.com/content/2022_05_11/973886455866720256.png","relative":0,"vip":true},{"userId":"1510944023190179842","nickname":"cubica","sign":null,"avatar":"https://images.sunofbeaches.com/content/2022_04_08/962013700544266240.png","relative":0,"vip":true},{"userId":"1527479930114281473","nickname":"黄桃罐头","sign":null,"avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","relative":0,"vip":true},{"userId":"1520570267082952706","nickname":"gs_wenbing","sign":null,"avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","relative":0,"vip":false},{"userId":"1267392066044825600","nickname":"小鲁班biubiubiu","sign":null,"avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","relative":0,"vip":true},{"userId":"1202767676435456000","nickname":"技术上无法实现","sign":"没有做不了的需求，只是技术上无法实现。","avatar":"https://images.sunofbeaches.com/content/2022_02_28/947997915148713984.png","relative":0,"vip":false},{"userId":"1433361655298891777","nickname":"有意思的少年","sign":"我刚睡醒","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","relative":0,"vip":false},{"userId":"1314408005793603584","nickname":"ccTyL","sign":"专业写bug20年","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","relative":0,"vip":false}]
         * total : 109
         * pageSize : 15
         * currentPage : 1
         * hasNext : true
         * hasPre : false
         * totalPage : 7
         */

        @SerializedName("total")
        private Integer total;
        @SerializedName("pageSize")
        private Integer pageSize;
        @SerializedName("currentPage")
        private Integer currentPage;
        @SerializedName("hasNext")
        private Boolean hasNext;
        @SerializedName("hasPre")
        private Boolean hasPre;
        @SerializedName("totalPage")
        private Integer totalPage;
        @SerializedName("list")
        private List<ListBean> list;

        public Integer getTotal() {
            return total;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public Integer getCurrentPage() {
            return currentPage;
        }

        public Boolean getHasNext() {
            return hasNext;
        }

        public Boolean getHasPre() {
            return hasPre;
        }

        public Integer getTotalPage() {
            return totalPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "total=" + total +
                    ", pageSize=" + pageSize +
                    ", currentPage=" + currentPage +
                    ", hasNext=" + hasNext +
                    ", hasPre=" + hasPre +
                    ", totalPage=" + totalPage +
                    ", list=" + list +
                    '}';
        }

        public static class ListBean implements Serializable {
            /**
             * userId : 1511613756247904258
             * nickname : dearmml
             * sign : 有时间会多些一点的。
             * avatar : https://images.sunofbeaches.com/content/2022_10_24/1034064694509305856.png
             * relative : 0
             * vip : false
             */

            @SerializedName("userId")
            private String userId;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("sign")
            private String sign;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("relative")
            private Integer relative;
            @SerializedName("vip")
            private Boolean vip;

            public String getUserId() {
                return userId;
            }

            public String getNickname() {
                return nickname;
            }

            public String getSign() {
                return sign;
            }

            public String getAvatar() {
                return avatar;
            }

            public Integer getRelative() {
                return relative;
            }

            public Boolean getVip() {
                return vip;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "userId='" + userId + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", sign='" + sign + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", relative=" + relative +
                        ", vip=" + vip +
                        '}';
            }
        }
    }
}
