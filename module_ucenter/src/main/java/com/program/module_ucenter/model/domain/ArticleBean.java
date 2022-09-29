package com.program.module_ucenter.model.domain;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import kotlin.collections.CollectionsKt;

public class ArticleBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 查询成功.
     * data : {"list":[{"id":"1574783467713990658","title":"好久没有水文章了，今天水一篇前端的，主要是思路吧。","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-09-27 15:51:45.0","labels":["js","前端","开发","技巧","思想"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_09_27/1024468369765564416.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null},{"id":"1569499961886773250","title":"AndroidStudio导入系统源码","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-09-13 01:57:58.0","labels":["aosp","源码","系统","安卓开发","系统编译"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_09_13/1019184027820621824.png"],"vip":false,"state":null,"thumbUp":6,"articleType":null},{"id":"1566966759720751105","title":"禅道账号/密码错误？那可不一定！","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-09-06 08:54:24.0","labels":["禅道","清理磁盘","硬盘清理","日志清理","docker"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_09_06/1016750903606116352.png"],"vip":false,"state":null,"thumbUp":2,"articleType":null},{"id":"1562257549770625025","title":"vue.js国际化处理","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-24 02:57:21.0","labels":["vue.js","i18n","国际化","多语言","本地化"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_24/1011952223212535808.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null},{"id":"1561259740040794114","title":"js操作cookie","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-21 07:55:07.0","labels":["js","cookie","前端","web","crud"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_16/1009040985004441600.png"],"vip":false,"state":null,"thumbUp":1,"articleType":null},{"id":"1560555614579462145","title":"摸鱼君的登录和token校验流程","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-19 14:06:55.0","labels":["登录","流程","摸鱼君","后台","JavaWeb"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_19/1010235431771439104.png"],"vip":false,"state":null,"thumbUp":4,"articleType":null},{"id":"1560536445729378305","title":"2022-8-19水一篇文章吧，跟AOSP有关的","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-19 08:46:20.0","labels":["AOSP","水文章","android开发","系统开发","编译"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_19/1010216922848952320.png"],"vip":false,"state":null,"thumbUp":6,"articleType":null},{"id":"1559122496165253122","title":"Android开发文本转图片字体的控件","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-16 02:09:58.0","labels":["自定义控件","安卓开发","毕业涉及","毕业设计","安卓","控件"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_16/1009041027178168320.png"],"vip":false,"state":null,"thumbUp":6,"articleType":null},{"id":"1558798016033329153","title":"ClassNotFoundException: MongoDriverInformation","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-14 13:09:51.0","labels":["mongodb","冲突","版本","库","javaweb"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_14/1008482131367690240.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null},{"id":"1558256049490759681","title":"各在平台的热门数据 扒拉接口","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-13 08:33:17.0","labels":["干货","链接","友情链接","摸鱼君","热门"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_13/1007966471428505600.png"],"vip":false,"state":null,"thumbUp":5,"articleType":null},{"id":"1557004340126814210","title":"蓝牙版的手表与App通讯身份验证","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-11 09:21:30.0","labels":["加密","算法","通讯","协议","蓝牙"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_11/1007336458479992832.png"],"vip":false,"state":null,"thumbUp":2,"articleType":null},{"id":"1554295448309600258","title":"Android开发TextView阴影设置","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-02 02:46:58.0","labels":["TextView","阴影","Shadow","android开发","文本阴影"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_02/1003975171335258112.png"],"vip":false,"state":null,"thumbUp":7,"articleType":null},{"id":"1554290536607649794","title":"CSS样式Display:flex","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-02 02:36:48.0","labels":["前端","css","样式","style","flex"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_02/1003974152765308928.png"],"vip":false,"state":null,"thumbUp":1,"articleType":null},{"id":"1552296170083061762","title":"Mysql时间范围的查询","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-27 14:38:25.0","labels":["mysql","sql","查询","日期","范围"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_27/1001977414571524096.png"],"vip":false,"state":null,"thumbUp":5,"articleType":null},{"id":"1552106395422167042","title":"Android开发-锁屏状态下显示自定义UI","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-27 02:37:33.0","labels":["锁屏","安卓开发","亮屏","解锁","自定义"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_27/1001788394004545536.png"],"vip":false,"state":null,"thumbUp":2,"articleType":null},{"id":"1550849716009308161","title":"mac电脑安装上Idea开发工具后修改Maven仓库地址","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-23 14:30:58.0","labels":["idea","maven","仓库","源","依赖"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_23/1000529796632936448.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null},{"id":"1550416116638027778","title":"8086CPU寄存器名称和简称","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-22 09:45:56.0","labels":["8086","汇编","指令","寄存器","CPU"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_22/1000096259249274880.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null},{"id":"1550112586471575553","title":"摸鱼君-滑动到底部时去加载更多内容","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-21 13:57:32.0","labels":["loading","加载更多","前端","分页","more"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_21/999797109899132928.png"],"vip":false,"state":null,"thumbUp":2,"articleType":null},{"id":"1548945182689333249","title":"Android开发TextView如何显示html链接，a标签的跳转","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-18 08:21:59.0","labels":["textView","html","a标签","url","协议"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_18/998624823200448512.png"],"vip":false,"state":null,"thumbUp":6,"articleType":null},{"id":"1546483107417296898","title":"摸鱼君-点赞功能思考","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-15 15:48:41.0","labels":["点赞","摸鱼君","后台","javaWeb","点赞实现"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_15/997650622503190528.png"],"vip":false,"state":null,"thumbUp":5,"articleType":null},{"id":"1547171972297789442","title":"2022年苹果教育商店各种商品优惠多少呢？","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-13 12:50:33.0","labels":["mac","apple","苹果电脑","教育优惠","价格"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_13/996854360988188672.png","https://images.sunofbeaches.com/content/2022_07_08/995044063684067328.png","https://images.sunofbeaches.com/content/2022_07_13/996852366173011968.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null},{"id":"1543588865414008833","title":"阳光沙滩Api新增加接口2022-7-3","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-04 12:19:57.0","labels":["api文档","积分","sob","阳光沙滩","api"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_02/992890179507191808.jpg"],"vip":false,"state":null,"thumbUp":2,"articleType":null},{"id":"1543090945359089665","title":"我写的bug是如何让测试人员损失8.7元的？","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-02 12:31:54.0","labels":["日常","bug","工作","弹射下班","程序员"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_02/992890179507191808.jpg","https://images.sunofbeaches.com/content/2022_07_02/992890088599846912.jpg","https://images.sunofbeaches.com/content/2022_07_02/992886911179685888.png"],"vip":false,"state":null,"thumbUp":4,"articleType":null},{"id":"1541418733308743682","title":"（Vue.js）有空吗？来写一个评论组件？","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-30 13:25:37.0","labels":["评论","组件","vue.js","nuxt.js","前端"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_06_28/991466654103764992.png","https://images.sunofbeaches.com/content/2022_06_27/991100119136862208.png","https://images.sunofbeaches.com/content/2022_06_28/991467887220752384.png"],"vip":false,"state":null,"thumbUp":4,"articleType":null},{"id":"1541243792651194370","title":"（Android）写个小控件吧：长按结束运动","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-27 03:21:57.0","labels":["自定义控件","安卓开发","UI","progress","倒计时"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_06_27/990923372714000384.png"],"vip":false,"state":null,"thumbUp":6,"articleType":null},{"id":"1537719198141124609","title":"Launcher第二集，今天没代码，写一下交互吧","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-17 09:24:39.0","labels":["交互","Launcher","安卓开发","没有代码","水文章"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_06_17/987405104090972160.png","https://images.sunofbeaches.com/content/2022_06_17/987401521933058048.png","https://images.sunofbeaches.com/content/2022_06_17/987403268214751232.png"],"vip":false,"state":null,"thumbUp":4,"articleType":null},{"id":"985536669849485312","title":"有空来撸一只图片浏览器？power by vue.js","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-12 05:30:52.0","labels":["组件","vue.js","nuxt.js","图片预览","摸鱼君"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_06_12/985540027670855680.png","https://images.sunofbeaches.com/content/2022_06_12/985532063715164160.png","https://images.sunofbeaches.com/content/2022_06_12/985531051096932352.png"],"vip":false,"state":null,"thumbUp":6,"articleType":null},{"id":"1533810692451209217","title":"阳光沙滩API补充黑名单，帐户注销","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-06 14:09:32.0","labels":["黑名单","API","接口文档","阳光沙滩","APP"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_06_06/983492703754911744.png"],"vip":false,"state":null,"thumbUp":4,"articleType":null},{"id":"1533715983192035329","title":"Android-弹个窗（水一篇文章）","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-06 08:04:07.0","labels":["水文章","Android","弹窗","dialog","仿苹果"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_06_06/983397582552170496.png"],"vip":false,"state":null,"thumbUp":4,"articleType":null},{"id":"1529830581574045698","title":"《易经》是如何算命的呢？","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-05-26 15:39:30.0","labels":["周易","八卦","原理","算命","卦象"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_05_26/979525577675374592.png","https://images.sunofbeaches.com/content/2022_05_26/979529120931119104.png","https://images.sunofbeaches.com/content/2022_05_26/979515033463554048.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null}],"total":531,"pageSize":30,"currentPage":1,"hasNext":true,"hasPre":false,"totalPage":18}
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
        return "ArticleBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * list : [{"id":"1574783467713990658","title":"好久没有水文章了，今天水一篇前端的，主要是思路吧。","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-09-27 15:51:45.0","labels":["js","前端","开发","技巧","思想"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_09_27/1024468369765564416.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null},{"id":"1569499961886773250","title":"AndroidStudio导入系统源码","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-09-13 01:57:58.0","labels":["aosp","源码","系统","安卓开发","系统编译"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_09_13/1019184027820621824.png"],"vip":false,"state":null,"thumbUp":6,"articleType":null},{"id":"1566966759720751105","title":"禅道账号/密码错误？那可不一定！","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-09-06 08:54:24.0","labels":["禅道","清理磁盘","硬盘清理","日志清理","docker"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_09_06/1016750903606116352.png"],"vip":false,"state":null,"thumbUp":2,"articleType":null},{"id":"1562257549770625025","title":"vue.js国际化处理","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-24 02:57:21.0","labels":["vue.js","i18n","国际化","多语言","本地化"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_24/1011952223212535808.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null},{"id":"1561259740040794114","title":"js操作cookie","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-21 07:55:07.0","labels":["js","cookie","前端","web","crud"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_16/1009040985004441600.png"],"vip":false,"state":null,"thumbUp":1,"articleType":null},{"id":"1560555614579462145","title":"摸鱼君的登录和token校验流程","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-19 14:06:55.0","labels":["登录","流程","摸鱼君","后台","JavaWeb"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_19/1010235431771439104.png"],"vip":false,"state":null,"thumbUp":4,"articleType":null},{"id":"1560536445729378305","title":"2022-8-19水一篇文章吧，跟AOSP有关的","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-19 08:46:20.0","labels":["AOSP","水文章","android开发","系统开发","编译"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_19/1010216922848952320.png"],"vip":false,"state":null,"thumbUp":6,"articleType":null},{"id":"1559122496165253122","title":"Android开发文本转图片字体的控件","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-16 02:09:58.0","labels":["自定义控件","安卓开发","毕业涉及","毕业设计","安卓","控件"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_16/1009041027178168320.png"],"vip":false,"state":null,"thumbUp":6,"articleType":null},{"id":"1558798016033329153","title":"ClassNotFoundException: MongoDriverInformation","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-14 13:09:51.0","labels":["mongodb","冲突","版本","库","javaweb"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_14/1008482131367690240.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null},{"id":"1558256049490759681","title":"各在平台的热门数据 扒拉接口","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-13 08:33:17.0","labels":["干货","链接","友情链接","摸鱼君","热门"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_13/1007966471428505600.png"],"vip":false,"state":null,"thumbUp":5,"articleType":null},{"id":"1557004340126814210","title":"蓝牙版的手表与App通讯身份验证","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-11 09:21:30.0","labels":["加密","算法","通讯","协议","蓝牙"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_11/1007336458479992832.png"],"vip":false,"state":null,"thumbUp":2,"articleType":null},{"id":"1554295448309600258","title":"Android开发TextView阴影设置","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-02 02:46:58.0","labels":["TextView","阴影","Shadow","android开发","文本阴影"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_02/1003975171335258112.png"],"vip":false,"state":null,"thumbUp":7,"articleType":null},{"id":"1554290536607649794","title":"CSS样式Display:flex","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-08-02 02:36:48.0","labels":["前端","css","样式","style","flex"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_08_02/1003974152765308928.png"],"vip":false,"state":null,"thumbUp":1,"articleType":null},{"id":"1552296170083061762","title":"Mysql时间范围的查询","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-27 14:38:25.0","labels":["mysql","sql","查询","日期","范围"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_27/1001977414571524096.png"],"vip":false,"state":null,"thumbUp":5,"articleType":null},{"id":"1552106395422167042","title":"Android开发-锁屏状态下显示自定义UI","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-27 02:37:33.0","labels":["锁屏","安卓开发","亮屏","解锁","自定义"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_27/1001788394004545536.png"],"vip":false,"state":null,"thumbUp":2,"articleType":null},{"id":"1550849716009308161","title":"mac电脑安装上Idea开发工具后修改Maven仓库地址","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-23 14:30:58.0","labels":["idea","maven","仓库","源","依赖"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_23/1000529796632936448.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null},{"id":"1550416116638027778","title":"8086CPU寄存器名称和简称","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-22 09:45:56.0","labels":["8086","汇编","指令","寄存器","CPU"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_22/1000096259249274880.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null},{"id":"1550112586471575553","title":"摸鱼君-滑动到底部时去加载更多内容","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-21 13:57:32.0","labels":["loading","加载更多","前端","分页","more"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_21/999797109899132928.png"],"vip":false,"state":null,"thumbUp":2,"articleType":null},{"id":"1548945182689333249","title":"Android开发TextView如何显示html链接，a标签的跳转","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-18 08:21:59.0","labels":["textView","html","a标签","url","协议"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_18/998624823200448512.png"],"vip":false,"state":null,"thumbUp":6,"articleType":null},{"id":"1546483107417296898","title":"摸鱼君-点赞功能思考","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-15 15:48:41.0","labels":["点赞","摸鱼君","后台","javaWeb","点赞实现"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_15/997650622503190528.png"],"vip":false,"state":null,"thumbUp":5,"articleType":null},{"id":"1547171972297789442","title":"2022年苹果教育商店各种商品优惠多少呢？","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-13 12:50:33.0","labels":["mac","apple","苹果电脑","教育优惠","价格"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_13/996854360988188672.png","https://images.sunofbeaches.com/content/2022_07_08/995044063684067328.png","https://images.sunofbeaches.com/content/2022_07_13/996852366173011968.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null},{"id":"1543588865414008833","title":"阳光沙滩Api新增加接口2022-7-3","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-04 12:19:57.0","labels":["api文档","积分","sob","阳光沙滩","api"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_02/992890179507191808.jpg"],"vip":false,"state":null,"thumbUp":2,"articleType":null},{"id":"1543090945359089665","title":"我写的bug是如何让测试人员损失8.7元的？","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-07-02 12:31:54.0","labels":["日常","bug","工作","弹射下班","程序员"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_07_02/992890179507191808.jpg","https://images.sunofbeaches.com/content/2022_07_02/992890088599846912.jpg","https://images.sunofbeaches.com/content/2022_07_02/992886911179685888.png"],"vip":false,"state":null,"thumbUp":4,"articleType":null},{"id":"1541418733308743682","title":"（Vue.js）有空吗？来写一个评论组件？","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-30 13:25:37.0","labels":["评论","组件","vue.js","nuxt.js","前端"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_06_28/991466654103764992.png","https://images.sunofbeaches.com/content/2022_06_27/991100119136862208.png","https://images.sunofbeaches.com/content/2022_06_28/991467887220752384.png"],"vip":false,"state":null,"thumbUp":4,"articleType":null},{"id":"1541243792651194370","title":"（Android）写个小控件吧：长按结束运动","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-27 03:21:57.0","labels":["自定义控件","安卓开发","UI","progress","倒计时"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_06_27/990923372714000384.png"],"vip":false,"state":null,"thumbUp":6,"articleType":null},{"id":"1537719198141124609","title":"Launcher第二集，今天没代码，写一下交互吧","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-17 09:24:39.0","labels":["交互","Launcher","安卓开发","没有代码","水文章"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_06_17/987405104090972160.png","https://images.sunofbeaches.com/content/2022_06_17/987401521933058048.png","https://images.sunofbeaches.com/content/2022_06_17/987403268214751232.png"],"vip":false,"state":null,"thumbUp":4,"articleType":null},{"id":"985536669849485312","title":"有空来撸一只图片浏览器？power by vue.js","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-12 05:30:52.0","labels":["组件","vue.js","nuxt.js","图片预览","摸鱼君"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_06_12/985540027670855680.png","https://images.sunofbeaches.com/content/2022_06_12/985532063715164160.png","https://images.sunofbeaches.com/content/2022_06_12/985531051096932352.png"],"vip":false,"state":null,"thumbUp":6,"articleType":null},{"id":"1533810692451209217","title":"阳光沙滩API补充黑名单，帐户注销","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-06 14:09:32.0","labels":["黑名单","API","接口文档","阳光沙滩","APP"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_06_06/983492703754911744.png"],"vip":false,"state":null,"thumbUp":4,"articleType":null},{"id":"1533715983192035329","title":"Android-弹个窗（水一篇文章）","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-06-06 08:04:07.0","labels":["水文章","Android","弹窗","dialog","仿苹果"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_06_06/983397582552170496.png"],"vip":false,"state":null,"thumbUp":4,"articleType":null},{"id":"1529830581574045698","title":"《易经》是如何算命的呢？","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":"1153952789488054272","createTime":"2022-05-26 15:39:30.0","labels":["周易","八卦","原理","算命","卦象"],"viewCount":null,"covers":["https://images.sunofbeaches.com/content/2022_05_26/979525577675374592.png","https://images.sunofbeaches.com/content/2022_05_26/979529120931119104.png","https://images.sunofbeaches.com/content/2022_05_26/979515033463554048.png"],"vip":false,"state":null,"thumbUp":3,"articleType":null}]
         * total : 531
         * pageSize : 30
         * currentPage : 1
         * hasNext : true
         * hasPre : false
         * totalPage : 18
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

        public static class ListBean implements Serializable, MultiItemEntity {
            /**
             * id : 1574783467713990658
             * title : 好久没有水文章了，今天水一篇前端的，主要是思路吧。
             * nickname : 拉大锯
             * avatar : https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png
             * userId : 1153952789488054272
             * createTime : 2022-09-27 15:51:45.0
             * labels : ["js","前端","开发","技巧","思想"]
             * viewCount : null
             * covers : ["https://images.sunofbeaches.com/content/2022_09_27/1024468369765564416.png"]
             * vip : false
             * state : null
             * thumbUp : 3
             * articleType : null
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
            private Object viewCount;
            @SerializedName("vip")
            private Boolean vip;
            @SerializedName("state")
            private Object state;
            @SerializedName("thumbUp")
            private Integer thumbUp;
            @SerializedName("articleType")
            private Object articleType;
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

            public Object getViewCount() {
                return viewCount;
            }

            public Boolean getVip() {
                return vip;
            }

            public Object getState() {
                return state;
            }

            public Integer getThumbUp() {
                return thumbUp;
            }

            public Object getArticleType() {
                return articleType;
            }

            public List<String> getLabels() {
                return labels;
            }

            public List<String> getCovers() {
                return covers;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", userId='" + userId + '\'' +
                        ", createTime='" + createTime + '\'' +
                        ", viewCount=" + viewCount +
                        ", vip=" + vip +
                        ", state=" + state +
                        ", thumbUp=" + thumbUp +
                        ", articleType=" + articleType +
                        ", labels=" + labels +
                        ", covers=" + covers +
                        '}';
            }

            @Override
            public int getItemType() {
                return 1;
            }

            public String labels(boolean isSub){
                String temp;
                if (isSub){
                    if (this.labels.size()>3){
                        temp =((this.labels.subList(0, 3).toString().replace("[", "").replace("]", "") + " ...").toString());
                    }else{
                        temp = this.labels.toString().replace("[","").replace("]","").toString();
                    }
                }else {
                    temp = this.labels.toString().replace("[","").replace("]","");
                }
                return temp;

            }
        }
    }
}
