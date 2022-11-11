package com.program.module_moyu.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;
import com.program.lib_common.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MomentCommentBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取评论列表成功.
     * data : {"list":[{"id":"1513828129153544194","userId":"1497193244834926593","company":"","position":"","avatar":"https://images.sunofbeaches.com/content/2022_07_08/995062207253315584.jpeg","nickname":"黄大官","createTime":"2022-04-12 18:35","content":"官方有","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[],"vip":false},{"id":"1513466043357523970","userId":"1268774545783795712","company":null,"position":null,"avatar":"https://images.sunofbeaches.com/content/2022_03_29/958358748433219584.png","nickname":"ALEX","createTime":"2022-04-11 18:36","content":"之前学过了喜马拉雅和领券联盟的话，可以自己搞一个，想怎么造就怎么造","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[],"vip":true},{"id":"1513458930774241282","userId":"1139423796017500160","company":"阳光沙滩","position":"资深摸鱼技术专家","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","nickname":"断点","createTime":"2022-04-11 18:08","content":"康师傅已经出了交互图，剩下的让我们自由发挥","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[],"vip":true},{"id":"1513457831329722370","userId":"1204736502274318336","company":"求内推呀","position":"Android 开发工程师","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","nickname":"A lonely cat","createTime":"2022-04-11 18:04","content":"代码在这里  https://github.com/anjiemo/SunnyBeach","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[{"id":"1514144712749019137","userId":"1499922423573647361","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","position":null,"company":null,"nickname":"希望程序能按我想的那样运行","targetUserId":"1204736502274318336","targetUserNickname":"A lonely cat","targetUserIsVip":true,"createTime":"2022-04-13 15:33","content":"谢谢大佬的代码可以让我参考一下","thumbUpList":[],"commentId":"1513457831329722370","vip":false},{"id":"1514154751723368449","userId":"1204736502274318336","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","position":"Android 开发工程师","company":"求内推呀","nickname":"A lonely cat","targetUserId":"1499922423573647361","targetUserNickname":"希望程序能按我想的那样运行","targetUserIsVip":false,"createTime":"2022-04-13 16:13","content":"最新的代码在 dev 分支  记得切换分支哦","thumbUpList":[],"commentId":"1513457831329722370","vip":true}],"vip":true},{"id":"1513457513044963330","userId":"1433361655298891777","company":"人生有限公司","position":"砖块开发","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","nickname":"有意思的少年","createTime":"2022-04-11 18:02","content":"我就是参照小默的来写的，摸鱼模块接口基本都弄完了","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[],"vip":false},{"id":"1513449502679298050","userId":"1382711465131241472","company":"广州摸鱼无责任有限公司","position":"首席划水工程师","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","nickname":"阿肥","createTime":"2022-04-11 17:30","content":"小默的源码都共享出来了 学开发思路之前那些不就够啦 你就是想\u201c白嫖\u201d个新app哈哈哈","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[{"id":"1514144964910575617","userId":"1499922423573647361","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","position":null,"company":null,"nickname":"希望程序能按我想的那样运行","targetUserId":"1382711465131241472","targetUserNickname":"阿肥","targetUserIsVip":false,"createTime":"2022-04-13 15:34","content":"也可以这么说吧，主要是我是初学者做得又丑又简陋，所有想看看师傅们的","thumbUpList":[],"commentId":"1513449502679298050","vip":false}],"vip":false},{"id":"1513442799099375617","userId":"1153952789488054272","company":"阳光沙滩","position":"首席打杂工程师","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","nickname":"拉大锯","createTime":"2022-04-11 17:04","content":"考虑过，暂时不出[龇牙]，可以参考断点，小默写的代码。你自己下载来看看，侧栏扫码就可以下载。","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[{"id":"1513467022773645313","userId":"1204736502274318336","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","position":"Android 开发工程师","company":"求内推呀","nickname":"A lonely cat","targetUserId":"1153952789488054272","targetUserNickname":"拉大锯","targetUserIsVip":false,"createTime":"2022-04-11 18:40","content":"再改一个头像的装饰部分就可以上线了   不过出了点问题  得缓一缓了","thumbUpList":[],"commentId":"1513442799099375617","vip":true}],"vip":false}],"total":7,"pageSize":30,"currentPage":1,"hasNext":false,"hasPre":false,"totalPage":1}
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
        return "MomentCommentBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }


    public static class DataBean implements Serializable {
        /**
         * list : [{"id":"1513828129153544194","userId":"1497193244834926593","company":"","position":"","avatar":"https://images.sunofbeaches.com/content/2022_07_08/995062207253315584.jpeg","nickname":"黄大官","createTime":"2022-04-12 18:35","content":"官方有","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[],"vip":false},{"id":"1513466043357523970","userId":"1268774545783795712","company":null,"position":null,"avatar":"https://images.sunofbeaches.com/content/2022_03_29/958358748433219584.png","nickname":"ALEX","createTime":"2022-04-11 18:36","content":"之前学过了喜马拉雅和领券联盟的话，可以自己搞一个，想怎么造就怎么造","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[],"vip":true},{"id":"1513458930774241282","userId":"1139423796017500160","company":"阳光沙滩","position":"资深摸鱼技术专家","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","nickname":"断点","createTime":"2022-04-11 18:08","content":"康师傅已经出了交互图，剩下的让我们自由发挥","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[],"vip":true},{"id":"1513457831329722370","userId":"1204736502274318336","company":"求内推呀","position":"Android 开发工程师","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","nickname":"A lonely cat","createTime":"2022-04-11 18:04","content":"代码在这里  https://github.com/anjiemo/SunnyBeach","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[{"id":"1514144712749019137","userId":"1499922423573647361","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","position":null,"company":null,"nickname":"希望程序能按我想的那样运行","targetUserId":"1204736502274318336","targetUserNickname":"A lonely cat","targetUserIsVip":true,"createTime":"2022-04-13 15:33","content":"谢谢大佬的代码可以让我参考一下","thumbUpList":[],"commentId":"1513457831329722370","vip":false},{"id":"1514154751723368449","userId":"1204736502274318336","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","position":"Android 开发工程师","company":"求内推呀","nickname":"A lonely cat","targetUserId":"1499922423573647361","targetUserNickname":"希望程序能按我想的那样运行","targetUserIsVip":false,"createTime":"2022-04-13 16:13","content":"最新的代码在 dev 分支  记得切换分支哦","thumbUpList":[],"commentId":"1513457831329722370","vip":true}],"vip":true},{"id":"1513457513044963330","userId":"1433361655298891777","company":"人生有限公司","position":"砖块开发","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","nickname":"有意思的少年","createTime":"2022-04-11 18:02","content":"我就是参照小默的来写的，摸鱼模块接口基本都弄完了","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[],"vip":false},{"id":"1513449502679298050","userId":"1382711465131241472","company":"广州摸鱼无责任有限公司","position":"首席划水工程师","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","nickname":"阿肥","createTime":"2022-04-11 17:30","content":"小默的源码都共享出来了 学开发思路之前那些不就够啦 你就是想\u201c白嫖\u201d个新app哈哈哈","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[{"id":"1514144964910575617","userId":"1499922423573647361","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","position":null,"company":null,"nickname":"希望程序能按我想的那样运行","targetUserId":"1382711465131241472","targetUserNickname":"阿肥","targetUserIsVip":false,"createTime":"2022-04-13 15:34","content":"也可以这么说吧，主要是我是初学者做得又丑又简陋，所有想看看师傅们的","thumbUpList":[],"commentId":"1513449502679298050","vip":false}],"vip":false},{"id":"1513442799099375617","userId":"1153952789488054272","company":"阳光沙滩","position":"首席打杂工程师","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","nickname":"拉大锯","createTime":"2022-04-11 17:04","content":"考虑过，暂时不出[龇牙]，可以参考断点，小默写的代码。你自己下载来看看，侧栏扫码就可以下载。","thumbUpList":[],"thumbUp":0,"momentId":"1513442206020595713","subComments":[{"id":"1513467022773645313","userId":"1204736502274318336","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","position":"Android 开发工程师","company":"求内推呀","nickname":"A lonely cat","targetUserId":"1153952789488054272","targetUserNickname":"拉大锯","targetUserIsVip":false,"createTime":"2022-04-11 18:40","content":"再改一个头像的装饰部分就可以上线了   不过出了点问题  得缓一缓了","thumbUpList":[],"commentId":"1513442799099375617","vip":true}],"vip":false}]
         * total : 7
         * pageSize : 30
         * currentPage : 1
         * hasNext : false
         * hasPre : false
         * totalPage : 1
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

        public static class ListBean implements Serializable , MultiItemEntity, Parcelable {
            /**
             * id : 1513828129153544194
             * userId : 1497193244834926593
             * company :
             * position :
             * avatar : https://images.sunofbeaches.com/content/2022_07_08/995062207253315584.jpeg
             * nickname : 黄大官
             * createTime : 2022-04-12 18:35
             * content : 官方有
             * thumbUpList : []
             * thumbUp : 0
             * momentId : 1513442206020595713
             * subComments : []
             * vip : false
             */

            @SerializedName("id")
            private String id;
            @SerializedName("userId")
            private String userId;
            @SerializedName("company")
            private String company;
            @SerializedName("position")
            private String position;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("createTime")
            private String createTime;
            @SerializedName("content")
            private String content;
            @SerializedName("thumbUp")
            private Integer thumbUp;
            @SerializedName("momentId")
            private String momentId;
            @SerializedName("vip")
            private Boolean vip;
            @SerializedName("thumbUpList")
            private List<String> thumbUpList;
            @SerializedName("subComments")
            private List<MomentSubCommentBean> subComments;

            public String getId() {
                return id;
            }

            public String getUserId() {
                return userId;
            }

            public String getCompany() {
                return company;
            }

            public String getPosition() {
                return position;
            }

            public String getAvatar() {
                return avatar;
            }

            public String getNickname() {
                return nickname;
            }

            public String getCreateTime() {
                return createTime;
            }

            public String getContent() {
                return content;
            }

            public Integer getThumbUp() {
                return thumbUp;
            }

            public String getMomentId() {
                return momentId;
            }

            public Boolean getVip() {
                return vip;
            }

            public List<?> getThumbUpList() {
                return thumbUpList;
            }

            public List<MomentSubCommentBean> getSubComments() {
                return subComments;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id='" + id + '\'' +
                        ", userId='" + userId + '\'' +
                        ", company='" + company + '\'' +
                        ", position='" + position + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", createTime='" + createTime + '\'' +
                        ", content='" + content + '\'' +
                        ", thumbUp=" + thumbUp +
                        ", momentId='" + momentId + '\'' +
                        ", vip=" + vip +
                        ", thumbUpList=" + thumbUpList +
                        ", subComments=" + subComments +
                        '}';
            }

            @Override
            public int getItemType() {
                return Constants.MultiItemType.TYPE_COMMENT;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.userId);
                dest.writeString(this.company);
                dest.writeString(this.position);
                dest.writeString(this.avatar);
                dest.writeString(this.nickname);
                dest.writeString(this.createTime);
                dest.writeString(this.content);
                dest.writeValue(this.thumbUp);
                dest.writeString(this.momentId);
                dest.writeValue(this.vip);
                dest.writeStringList(this.thumbUpList);
                dest.writeList(this.subComments);
            }

            public void readFromParcel(Parcel source) {
                this.id = source.readString();
                this.userId = source.readString();
                this.company = source.readString();
                this.position = source.readString();
                this.avatar = source.readString();
                this.nickname = source.readString();
                this.createTime = source.readString();
                this.content = source.readString();
                this.thumbUp = (Integer) source.readValue(Integer.class.getClassLoader());
                this.momentId = source.readString();
                this.vip = (Boolean) source.readValue(Boolean.class.getClassLoader());
                this.thumbUpList = source.createStringArrayList();
                this.subComments = new ArrayList<MomentSubCommentBean>();
                source.readList(this.subComments, MomentSubCommentBean.class.getClassLoader());
            }

            public ListBean() {
            }

            protected ListBean(Parcel in) {
                this.id = in.readString();
                this.userId = in.readString();
                this.company = in.readString();
                this.position = in.readString();
                this.avatar = in.readString();
                this.nickname = in.readString();
                this.createTime = in.readString();
                this.content = in.readString();
                this.thumbUp = (Integer) in.readValue(Integer.class.getClassLoader());
                this.momentId = in.readString();
                this.vip = (Boolean) in.readValue(Boolean.class.getClassLoader());
                this.thumbUpList = in.createStringArrayList();
                this.subComments = new ArrayList<MomentSubCommentBean>();
                in.readList(this.subComments, MomentSubCommentBean.class.getClassLoader());
            }

            public static final Creator<ListBean> CREATOR = new Creator<ListBean>() {
                @Override
                public ListBean createFromParcel(Parcel source) {
                    return new ListBean(source);
                }

                @Override
                public ListBean[] newArray(int size) {
                    return new ListBean[size];
                }
            };
        }
    }
}
