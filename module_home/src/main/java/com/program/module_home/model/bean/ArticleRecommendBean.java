package com.program.module_home.model.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;
import com.program.lib_common.Constants;

import java.io.Serializable;
import java.util.List;

public class ArticleRecommendBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取推荐文章成功.
     * data : [{"id":"1575398812757790721","title":"Android 实现沉浸式状态","nickname":"dearmml","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","userId":"1511613756247904258","createTime":"2022-09-29 08:15:23.0","labels":["android","安卓","沉浸式状态栏"],"viewCount":"117","covers":["https://images.sunofbeaches.com/content/2022_09_29/1025078150066864128.png"],"vip":false,"thumbUp":2},{"id":"1569499961886773250","title":"AndroidStudio导入系统源码","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-09-13 01:57:58.0","labels":["aosp","源码","系统","安卓开发","系统编译"],"viewCount":"298","covers":["https://images.sunofbeaches.com/content/2022_09_13/1019184027820621824.png"],"vip":false,"thumbUp":6},{"id":"1559556991213375490","title":"Android 开发过程中截图分享功能实现","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","userId":"1204736502274318336","createTime":"2022-08-16 15:08:14.0","labels":["Android","安卓","Kotlin","截图分享卡片"],"viewCount":"397","covers":["https://images.sunofbeaches.com/content/2021_05_23/845998757471322112.jpg","https://images.sunofbeaches.com/content/2021_09_04/883683622597427200.png","https://images.sunofbeaches.com/content/2022_07_08/995016167674347520.png"],"vip":true,"thumbUp":5},{"id":"1559122496165253122","title":"Android开发文本转图片字体的控件","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-16 02:09:58.0","labels":["自定义控件","安卓开发","毕业涉及","毕业设计","安卓","控件"],"viewCount":"246","covers":["https://images.sunofbeaches.com/content/2022_08_16/1009041027178168320.png"],"vip":false,"thumbUp":6},{"id":"1552106395422167042","title":"Android开发-锁屏状态下显示自定义UI","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-27 02:37:33.0","labels":["锁屏","安卓开发","亮屏","解锁","自定义"],"viewCount":"342","covers":["https://images.sunofbeaches.com/content/2022_07_27/1001788394004545536.png"],"vip":false,"thumbUp":2},{"id":"1549301712764801026","title":"【Android】tabLayout改变标签文字大小时发生的跳闪问题解决方法","nickname":"墨客","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","userId":"1223846971966492672","createTime":"2022-07-19 07:57:29.0","labels":["安卓","anroid"],"viewCount":"271","covers":["https://images.sunofbeaches.com/content/2022_07_19/998981776019816448.png"],"vip":false,"thumbUp":2},{"id":"1541243792651194370","title":"（Android）写个小控件吧：长按结束运动","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-27 03:21:57.0","labels":["自定义控件","安卓开发","UI","progress","倒计时"],"viewCount":"414","covers":["https://images.sunofbeaches.com/content/2022_06_27/990923372714000384.png"],"vip":false,"thumbUp":6},{"id":"1537719198141124609","title":"Launcher第二集，今天没代码，写一下交互吧","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-17 09:24:39.0","labels":["交互","Launcher","安卓开发","没有代码","水文章"],"viewCount":"329","covers":["https://images.sunofbeaches.com/content/2022_06_17/987405104090972160.png","https://images.sunofbeaches.com/content/2022_06_17/987401521933058048.png","https://images.sunofbeaches.com/content/2022_06_17/987403268214751232.png"],"vip":false,"thumbUp":4},{"id":"1525711636801785858","title":"如何降低 ViewPager2 小部件的滚动敏感度","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","userId":"1204736502274318336","createTime":"2022-05-15 06:25:47.0","labels":["Android","安卓","Kotlin","ViewPager2","Jetpack"],"viewCount":"817","covers":["https://images.sunofbeaches.com/content/2021_05_23/845998757471322112.jpg","https://images.sunofbeaches.com/content/2021_09_04/883683622597427200.png","https://images.sunofbeaches.com/content/2021_12_21/922822731257348096.png"],"vip":true,"thumbUp":3},{"id":"1510085424304943106","title":"自定义头像装饰View实现","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","userId":"1204736502274318336","createTime":"2022-04-02 02:44:36.0","labels":["安卓","Android","阳光沙滩","B站","自定义View"],"viewCount":"846","covers":["https://images.sunofbeaches.com/content/2021_05_23/845998757471322112.jpg","https://images.sunofbeaches.com/content/2021_09_04/883683622597427200.png","https://images.sunofbeaches.com/content/2022_03_31/959136775438073856.png"],"vip":true,"thumbUp":9},{"id":"1501037306351513601","title":"Android开发如何知道电话有没有接通呢？","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-03-08 03:43:31.0","labels":["安卓","android","开发","拨号","电话"],"viewCount":"904","covers":["https://images.sunofbeaches.com/content/2022_03_08/950720346636419072.png"],"vip":false,"thumbUp":6},{"id":"1499584441581891585","title":"Rejecting re-init on previously-failed class java.lang.Class 解决","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","userId":"1204736502274318336","createTime":"2022-03-04 03:22:03.0","labels":["安卓","Android","疑难杂症","解BUG"],"viewCount":"1072","covers":["https://images.sunofbeaches.com/content/2021_05_23/845998757471322112.jpg","https://images.sunofbeaches.com/content/2022_03_04/949264707959652352.png"],"vip":true,"thumbUp":2},{"id":"1494122556523839490","title":"Paint 画笔高级应用","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","userId":"1204736502274318336","createTime":"2022-02-17 09:33:56.0","labels":["安卓","Android","Paint","画笔"],"viewCount":"871","covers":["https://images.sunofbeaches.com/content/2021_05_23/845998757471322112.jpg"],"vip":true,"thumbUp":7},{"id":"1493405804760432641","title":"Android Threading - All You Need to Know","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","userId":"1204736502274318336","createTime":"2022-02-15 10:06:26.0","labels":["安卓","Android","Thread"],"viewCount":"912","covers":["https://images.sunofbeaches.com/content/2021_05_23/845998757471322112.jpg"],"vip":true,"thumbUp":6},{"id":"1491683021944815618","title":"UI 绘制流程（测量、布局、绘制）","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","userId":"1204736502274318336","createTime":"2022-02-10 15:59:16.0","labels":["Android","安卓"],"viewCount":"726","covers":["https://images.sunofbeaches.com/content/2021_05_23/845998757471322112.jpg"],"vip":true,"thumbUp":2},{"id":"1491682436491280385","title":"UI 绘制流程及原理","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","userId":"1204736502274318336","createTime":"2022-02-10 15:57:56.0","labels":["Android","安卓"],"viewCount":"945","covers":["https://images.sunofbeaches.com/content/2021_05_23/845998757471322112.jpg"],"vip":true,"thumbUp":3},{"id":"1480458089017671681","title":"OkHttp中ResponseBody无法第二次调用string方法","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","userId":"1204736502274318336","createTime":"2022-01-10 19:29:44.0","labels":["安卓","Android","OkHttp","BUG"],"viewCount":"1070","covers":["https://images.sunofbeaches.com/content/2021_05_23/845998757471322112.jpg"],"vip":true,"thumbUp":5},{"id":"1480423866630176769","title":"App内实现免登录访问网站","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","userId":"1204736502274318336","createTime":"2022-01-10 14:19:48.0","labels":["安卓","Android","阳光沙滩","免登录","WebView","账号免登录"],"viewCount":"839","covers":["https://images.sunofbeaches.com/content/2021_05_23/845998757471322112.jpg"],"vip":true,"thumbUp":6},{"id":"1478549683306528769","title":"Android开发之阳光沙滩App最新登录教程带Demo","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","userId":"1204736502274318336","createTime":"2022-01-05 10:12:47.0","labels":["安卓","Android","阳光沙滩"],"viewCount":"1186","covers":["https://images.sunofbeaches.com/content/2021_05_23/845998757471322112.jpg"],"vip":true,"thumbUp":4},{"id":"1468976488949768193","title":"AOSP-开机动画","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2021-12-10 00:11:50.0","labels":["开机动画","bootanimation.zip","安卓开发","系统开发","系统定制"],"viewCount":"1203","covers":["https://images.sunofbeaches.com/content/2021_12_07/917805195474239488.jpg"],"vip":false,"thumbUp":5},{"id":"1468953560992473089","title":"AOSP-品牌创建","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2021-12-09 22:41:18.0","labels":["AOSP","品牌创建","安卓开发","系统移植","系统开发"],"viewCount":"1326","covers":["https://images.sunofbeaches.com/content/2021_12_07/917804878699429888.png"],"vip":false,"thumbUp":0},{"id":"1468401117674102785","title":"我看到别人的代码怎么Intent的setPackage是写自己的呢？我一直错了？","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2021-12-08 10:13:52.0","labels":["安卓开发","意图","包名","android","基础"],"viewCount":"1050","covers":["https://images.sunofbeaches.com/content/2021_12_07/917805073403215872.png"],"vip":false,"thumbUp":5},{"id":"1468125258505543682","title":"AOSP-Android开机动画素材","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2021-12-07 15:51:24.0","labels":["开机动画","安卓开发","AOSP","系统研发","系统移植"],"viewCount":"903","covers":["https://images.sunofbeaches.com/content/2021_12_07/917805195474239488.jpg","https://images.sunofbeaches.com/content/2021_12_07/917805122896003072.jpg","https://images.sunofbeaches.com/content/2021_12_07/917805004767625216.png"],"vip":false,"thumbUp":3},{"id":"1466946118301540353","title":"AOSP-编译系统是如何编译我们所选择的产品的？","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2021-12-04 10:41:18.0","labels":["AOSP","安卓系统编译","安卓开发","系统","android"],"viewCount":"1476","covers":["https://images.sunofbeaches.com/content/2021_11_19/911355214957641728.png"],"vip":false,"thumbUp":2},{"id":"1464572420835794946","title":"AOSP-envsetup.sh里的lunch到底干了啥事情呢？","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2021-11-27 20:35:09.0","labels":["安卓","AOSP","android","系统编译","lunch"],"viewCount":"1253","covers":["https://images.sunofbeaches.com/content/2021_11_19/911355214957641728.png"],"vip":false,"thumbUp":1},{"id":"1461734891350679553","title":"安卓APP应用内实现插件式换肤","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","userId":"1204736502274318336","createTime":"2021-11-20 00:44:33.0","labels":["Android","安卓","Kotlin","插件式换肤","app换肤"],"viewCount":"1316","covers":["https://images.sunofbeaches.com/content/2021_05_23/845998757471322112.jpg","https://images.sunofbeaches.com/content/2021_09_04/883683622597427200.png","https://images.sunofbeaches.com/content/2021_11_20/911416189685596160.gif"],"vip":true,"thumbUp":7},{"id":"1460990212149633026","title":"AOSP-编译C/C++可执行程序/库","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2021-11-17 23:17:31.0","labels":["安卓","android\\","android","C++","lib库","so库"],"viewCount":"937","covers":["https://images.sunofbeaches.com/content/2021_11_19/911350430095638528.png"],"vip":false,"thumbUp":2},{"id":"1446301425360453633","title":"IllegalStateException: You need to use a Theme.AppCompat Theme..","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2021-10-10 18:59:25.0","labels":["android开发","安卓开发","主题","theme","appTheme"],"viewCount":"1233","covers":["https://images.sunofbeaches.com/content/2021_10_10/896833909281521664.png"],"vip":false,"thumbUp":4},{"id":"1446063960125095937","title":"AOSP-电话监听","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2021-10-07 19:25:28.0","labels":["电话监听","安卓开发","AOSP","系统移植","系统修改"],"viewCount":"948","covers":["https://images.sunofbeaches.com/content/2021_09_15/887491337203482624.png"],"vip":false,"thumbUp":5},{"id":"1442670764879785986","title":"我就抛个异常Exception","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2021-09-28 15:25:38.0","labels":["exception","安卓开发","异常处理","抛异常","异常"],"viewCount":"1391","covers":["https://images.sunofbeaches.com/content/2021_09_28/892431717980176384.png"],"vip":false,"thumbUp":2}]
     */

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<DataBean> data;

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<DataBean> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ArticleRecommendBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable , MultiItemEntity {
        /**
         * id : 1575398812757790721
         * title : Android 实现沉浸式状态
         * nickname : dearmml
         * avatar : https://cdn.sunofbeaches.com/images/default_avatar.png
         * userId : 1511613756247904258
         * createTime : 2022-09-29 08:15:23.0
         * labels : ["android","安卓","沉浸式状态栏"]
         * viewCount : 117
         * covers : ["https://images.sunofbeaches.com/content/2022_09_29/1025078150066864128.png"]
         * vip : false
         * thumbUp : 2.0
         */

        @SerializedName("id")
        private String id;
        @SerializedName("title")
        private String title;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("userId")
        private String userId;
        @SerializedName("createTime")
        private String createTime;
        @SerializedName("viewCount")
        private String viewCount;
        @SerializedName("vip")
        private Boolean vip;
        @SerializedName("thumbUp")
        private Double thumbUp;
        @SerializedName("labels")
        private List<String> labels;
        @SerializedName("covers")
        private List<String> covers;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getNickname() {
            return nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getUserId() {
            return userId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getViewCount() {
            return viewCount;
        }

        public Boolean getVip() {
            return vip;
        }

        public Double getThumbUp() {
            return thumbUp;
        }

        public List<String> getLabels() {
            return labels;
        }

        public List<String> getCovers() {
            return covers;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", userId='" + userId + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", viewCount='" + viewCount + '\'' +
                    ", vip=" + vip +
                    ", thumbUp=" + thumbUp +
                    ", labels=" + labels +
                    ", covers=" + covers +
                    '}';
        }

        @Override
        public int getItemType() {
            return Constants.MultiItemType.TYPE_RECOMMEND;
        }
    }
}
