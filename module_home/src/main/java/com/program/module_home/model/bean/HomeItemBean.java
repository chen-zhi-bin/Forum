package com.program.module_home.model.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class HomeItemBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取推荐成功.
     * data : {"list":[{"covers":["https://images.sunofbeaches.com/content/2022_10_28/1035558124586532864.png"],"title":"Ubuntu 18.04编译AOSP 6.0.1","createTime":"2022-10-28 06:18:44.0","thumbUp":0,"viewCount":4,"type":0,"nickName":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","id":"1585878505108987905","userId":"1139423796017500160","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2022_10_27/1035192141275463680.jpg"],"title":"MMKV 使用简介  GitHub 转载","createTime":"2022-10-27 06:05:01.0","thumbUp":1,"viewCount":25,"type":0,"nickName":"lyq","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/40/rBsADWAs7x-ACX4eAABWd1wcLa4239.png","id":"1585512380315656194","userId":"1200362719631499264","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2022_10_26/1034864615554547712.png"],"title":"C# 使用MD5加密工具类（MD5CryptoServiceProvider）","createTime":"2022-10-26 08:22:41.0","thumbUp":2,"viewCount":21,"type":0,"nickName":"dearmml","avatar":"https://images.sunofbeaches.com/content/2022_10_24/1034064694509305856.png","id":"1585184052312465409","userId":"1511613756247904258","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_10_24/1034142976361627648.png"],"title":"关于昨天Mongodb 不工作的问题记录","createTime":"2022-10-24 08:35:15.0","thumbUp":3,"viewCount":63,"type":0,"nickName":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","id":"1584456750398103553","userId":"1153952789488054272","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_05/1016375874032762880.jpg","https://images.sunofbeaches.com/content/2022_03_28/957947261017391104.jpg"],"title":"Git 命令姿势说明","createTime":"2022-10-21 07:14:12.0","thumbUp":2,"viewCount":75,"type":0,"nickName":"阿肥","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","id":"1583352745031761921","userId":"1382711465131241472","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_10_21/1033027199982108672.png"],"title":"AndroidStudio+系统源码如何调试呢？","createTime":"2022-10-21 06:42:13.0","thumbUp":6,"viewCount":177,"type":0,"nickName":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","id":"1569525032986611714","userId":"1153952789488054272","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png"],"title":"游戏SDK应用内悬浮窗的实现（四）","createTime":"2022-10-19 10:49:51.0","thumbUp":3,"viewCount":63,"type":0,"nickName":"有意思的少年","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","id":"1582685304685461505","userId":"1433361655298891777","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_06_22/989136215414407168.jpg"],"title":"git命令个人备忘录","createTime":"2022-10-18 13:59:21.0","thumbUp":5,"viewCount":91,"type":0,"nickName":"Atago","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","id":"1582368251298578433","userId":"1283676283397545984","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png"],"title":"游戏SDK应用内悬浮窗的实现（三）","createTime":"2022-10-18 12:43:41.0","thumbUp":5,"viewCount":80,"type":0,"nickName":"有意思的少年","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","id":"1582351528507867137","userId":"1433361655298891777","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png"],"title":"游戏SDK应用内悬浮窗的实现（二）","createTime":"2022-10-18 10:18:04.0","thumbUp":3,"viewCount":62,"type":0,"nickName":"有意思的少年","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","id":"1582314944542670849","userId":"1433361655298891777","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png"],"title":"游戏SDK应用内悬浮窗的实现（一）","createTime":"2022-10-18 10:14:43.0","thumbUp":2,"viewCount":70,"type":0,"nickName":"有意思的少年","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","id":"1582313849141460993","userId":"1433361655298891777","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_10_13/1030142268087992320.png"],"title":"Android项目环境切换案例","createTime":"2022-10-13 07:38:02.0","thumbUp":8,"viewCount":171,"type":0,"nickName":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","id":"1580461941464240130","userId":"1139423796017500160","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2021_10_08/896171343865708544.png"],"title":"38.摸鱼页面查看评论、nginx刷新404问题.md","createTime":"2022-10-13 07:30:12.0","thumbUp":1,"viewCount":68,"type":0,"nickName":"ccTyL","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","id":"1580460576461557762","userId":"1314408005793603584","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_10_11/1029355071311183872.png"],"title":"水一篇文章，AOSP的，按键控制拍照","createTime":"2022-10-11 03:29:39.0","thumbUp":9,"viewCount":210,"type":0,"nickName":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","id":"1579661926751801346","userId":"1153952789488054272","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_10_06/1027549147256848384.png"],"title":"SpringBoot常用配置项","createTime":"2022-10-06 03:53:33.0","thumbUp":4,"viewCount":113,"type":0,"nickName":"竭风","avatar":"https://images.sunofbeaches.com/content/2021_09_29/892718450277875712.png","id":"1577869363212455937","userId":"1171041086097883136","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2022_10_02/1026205657075810304.png"],"title":"将jar包发布到maven仓库","createTime":"2022-10-02 10:55:09.0","thumbUp":4,"viewCount":134,"type":0,"nickName":"ccTyL","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","id":"1576524298401615873","userId":"1314408005793603584","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_30/1025357486707703808.jpg"],"title":"android gradle的日常使用","createTime":"2022-09-30 02:44:42.0","thumbUp":5,"viewCount":162,"type":0,"nickName":"波鲁萨利诺.黄猿","avatar":"https://images.sunofbeaches.com/content/2022_04_03/960254152636628992.png","id":"1575448528359002114","userId":"1302969105866940416","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_29/1025078150066864128.png"],"title":"Android 实现沉浸式状态","createTime":"2022-09-29 08:15:23.0","thumbUp":2,"viewCount":147,"type":0,"nickName":"dearmml","avatar":"https://images.sunofbeaches.com/content/2022_10_24/1034064694509305856.png","id":"1575398812757790721","userId":"1511613756247904258","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_29/1025067009194328064.jpg"],"title":"《30天自制操作系统》读书笔记1","createTime":"2022-09-29 07:56:52.0","thumbUp":3,"viewCount":149,"type":0,"nickName":"xujun20200616","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/36/rBsADV-b1tyAd8VRAABY6RLCx9o219.png","id":"1575381681282486273","userId":"1272797637732495360","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_27/1024468369765564416.png"],"title":"好久没有水文章了，今天水一篇前端的，主要是思路吧。","createTime":"2022-09-27 15:51:45.0","thumbUp":4,"viewCount":200,"type":0,"nickName":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","id":"1574783467713990658","userId":"1153952789488054272","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_27/1024355640186765312.png"],"title":"macOS提高效率的命令或者工具推荐","createTime":"2022-09-27 08:23:58.0","thumbUp":3,"viewCount":133,"type":0,"nickName":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","id":"1574673231388872706","userId":"1139423796017500160","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2022_09_27/1024276577443119104.webp"],"title":"jdbcTemplate 与 JPA 混合事务的尝试","createTime":"2022-09-27 03:09:40.0","thumbUp":1,"viewCount":104,"type":0,"nickName":"ccTyL","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","id":"1574596789019873281","userId":"1314408005793603584","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2021_08_30/881920635238875136.jpeg"],"title":"分享极客时间svip课程 （正在更新 请及时关注）","createTime":"2022-09-26 09:55:42.0","thumbUp":7,"viewCount":208,"type":0,"nickName":"林深不知处","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","id":"1574336837818781698","userId":"1432238344913395714","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_22/1022459919896412160.png"],"title":"第一个Flutter 项目 以及环境搭建","createTime":"2022-09-22 02:51:05.0","thumbUp":5,"viewCount":165,"type":0,"nickName":"lyq","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/40/rBsADWAs7x-ACX4eAABWd1wcLa4239.png","id":"1572780249794482177","userId":"1200362719631499264","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2022_09_21/1022263587248275456.png"],"title":"Android APP 在线更新功能实现分享","createTime":"2022-09-21 14:13:08.0","thumbUp":2,"viewCount":212,"type":0,"nickName":"lyq","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/40/rBsADWAs7x-ACX4eAABWd1wcLa4239.png","id":"1571332829269200898","userId":"1200362719631499264","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2021_06_03/849993984393609216.png"],"title":"UE开发数字人-心得","createTime":"2022-09-15 11:17:02.0","thumbUp":7,"viewCount":182,"type":0,"nickName":"dajiba009","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","id":"1570369760997150721","userId":"1298536191469150208","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2021_11_16/910205469912465408.jpg"],"title":"flutter---未来物联网ui框架","createTime":"2022-09-15 05:32:08.0","thumbUp":4,"viewCount":204,"type":0,"nickName":"kingKing","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","id":"1570280591352401921","userId":"1460523302899433474","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_13/1019184027820621824.png"],"title":"AndroidStudio导入系统源码","createTime":"2022-09-13 01:57:58.0","thumbUp":6,"viewCount":342,"type":0,"nickName":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","id":"1569499961886773250","userId":"1153952789488054272","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_11/1018591177353461760.gif","https://images.sunofbeaches.com/content/2022_09_11/1018590379605229568.png","https://images.sunofbeaches.com/content/2022_09_11/1018598101453111296.jpg"],"title":"安卓字体描边效果","createTime":"2022-09-11 11:08:15.0","thumbUp":4,"viewCount":193,"type":0,"nickName":"有效信息","avatar":"https://images.sunofbeaches.com/content/2021_11_11/908422195649183744.png","id":"1568908167826378753","userId":"1254287380538462208","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2022_09_09/1017810615814586368.png"],"title":"Android-SearchFlowLayout v1.1版本他来了","createTime":"2022-09-09 06:57:04.0","thumbUp":4,"viewCount":229,"type":0,"nickName":"CH-Android","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","id":"1568130557106196481","userId":"1290102301154942976","isVip":false}],"total":1580,"pageSize":30,"currentPage":1,"hasNext":true,"hasPre":false,"totalPage":53}
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
        return "HomeItemBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }


    public static class DataBean implements Serializable {
        /**
         * list : [{"covers":["https://images.sunofbeaches.com/content/2022_10_28/1035558124586532864.png"],"title":"Ubuntu 18.04编译AOSP 6.0.1","createTime":"2022-10-28 06:18:44.0","thumbUp":0,"viewCount":4,"type":0,"nickName":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","id":"1585878505108987905","userId":"1139423796017500160","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2022_10_27/1035192141275463680.jpg"],"title":"MMKV 使用简介  GitHub 转载","createTime":"2022-10-27 06:05:01.0","thumbUp":1,"viewCount":25,"type":0,"nickName":"lyq","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/40/rBsADWAs7x-ACX4eAABWd1wcLa4239.png","id":"1585512380315656194","userId":"1200362719631499264","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2022_10_26/1034864615554547712.png"],"title":"C# 使用MD5加密工具类（MD5CryptoServiceProvider）","createTime":"2022-10-26 08:22:41.0","thumbUp":2,"viewCount":21,"type":0,"nickName":"dearmml","avatar":"https://images.sunofbeaches.com/content/2022_10_24/1034064694509305856.png","id":"1585184052312465409","userId":"1511613756247904258","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_10_24/1034142976361627648.png"],"title":"关于昨天Mongodb 不工作的问题记录","createTime":"2022-10-24 08:35:15.0","thumbUp":3,"viewCount":63,"type":0,"nickName":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","id":"1584456750398103553","userId":"1153952789488054272","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_05/1016375874032762880.jpg","https://images.sunofbeaches.com/content/2022_03_28/957947261017391104.jpg"],"title":"Git 命令姿势说明","createTime":"2022-10-21 07:14:12.0","thumbUp":2,"viewCount":75,"type":0,"nickName":"阿肥","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","id":"1583352745031761921","userId":"1382711465131241472","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_10_21/1033027199982108672.png"],"title":"AndroidStudio+系统源码如何调试呢？","createTime":"2022-10-21 06:42:13.0","thumbUp":6,"viewCount":177,"type":0,"nickName":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","id":"1569525032986611714","userId":"1153952789488054272","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png"],"title":"游戏SDK应用内悬浮窗的实现（四）","createTime":"2022-10-19 10:49:51.0","thumbUp":3,"viewCount":63,"type":0,"nickName":"有意思的少年","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","id":"1582685304685461505","userId":"1433361655298891777","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_06_22/989136215414407168.jpg"],"title":"git命令个人备忘录","createTime":"2022-10-18 13:59:21.0","thumbUp":5,"viewCount":91,"type":0,"nickName":"Atago","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","id":"1582368251298578433","userId":"1283676283397545984","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png"],"title":"游戏SDK应用内悬浮窗的实现（三）","createTime":"2022-10-18 12:43:41.0","thumbUp":5,"viewCount":80,"type":0,"nickName":"有意思的少年","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","id":"1582351528507867137","userId":"1433361655298891777","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png"],"title":"游戏SDK应用内悬浮窗的实现（二）","createTime":"2022-10-18 10:18:04.0","thumbUp":3,"viewCount":62,"type":0,"nickName":"有意思的少年","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","id":"1582314944542670849","userId":"1433361655298891777","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png"],"title":"游戏SDK应用内悬浮窗的实现（一）","createTime":"2022-10-18 10:14:43.0","thumbUp":2,"viewCount":70,"type":0,"nickName":"有意思的少年","avatar":"https://images.sunofbeaches.com/content/2021_12_02/915973725776510976.png","id":"1582313849141460993","userId":"1433361655298891777","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_10_13/1030142268087992320.png"],"title":"Android项目环境切换案例","createTime":"2022-10-13 07:38:02.0","thumbUp":8,"viewCount":171,"type":0,"nickName":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","id":"1580461941464240130","userId":"1139423796017500160","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2021_10_08/896171343865708544.png"],"title":"38.摸鱼页面查看评论、nginx刷新404问题.md","createTime":"2022-10-13 07:30:12.0","thumbUp":1,"viewCount":68,"type":0,"nickName":"ccTyL","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","id":"1580460576461557762","userId":"1314408005793603584","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_10_11/1029355071311183872.png"],"title":"水一篇文章，AOSP的，按键控制拍照","createTime":"2022-10-11 03:29:39.0","thumbUp":9,"viewCount":210,"type":0,"nickName":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","id":"1579661926751801346","userId":"1153952789488054272","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_10_06/1027549147256848384.png"],"title":"SpringBoot常用配置项","createTime":"2022-10-06 03:53:33.0","thumbUp":4,"viewCount":113,"type":0,"nickName":"竭风","avatar":"https://images.sunofbeaches.com/content/2021_09_29/892718450277875712.png","id":"1577869363212455937","userId":"1171041086097883136","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2022_10_02/1026205657075810304.png"],"title":"将jar包发布到maven仓库","createTime":"2022-10-02 10:55:09.0","thumbUp":4,"viewCount":134,"type":0,"nickName":"ccTyL","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","id":"1576524298401615873","userId":"1314408005793603584","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_30/1025357486707703808.jpg"],"title":"android gradle的日常使用","createTime":"2022-09-30 02:44:42.0","thumbUp":5,"viewCount":162,"type":0,"nickName":"波鲁萨利诺.黄猿","avatar":"https://images.sunofbeaches.com/content/2022_04_03/960254152636628992.png","id":"1575448528359002114","userId":"1302969105866940416","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_29/1025078150066864128.png"],"title":"Android 实现沉浸式状态","createTime":"2022-09-29 08:15:23.0","thumbUp":2,"viewCount":147,"type":0,"nickName":"dearmml","avatar":"https://images.sunofbeaches.com/content/2022_10_24/1034064694509305856.png","id":"1575398812757790721","userId":"1511613756247904258","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_29/1025067009194328064.jpg"],"title":"《30天自制操作系统》读书笔记1","createTime":"2022-09-29 07:56:52.0","thumbUp":3,"viewCount":149,"type":0,"nickName":"xujun20200616","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/36/rBsADV-b1tyAd8VRAABY6RLCx9o219.png","id":"1575381681282486273","userId":"1272797637732495360","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_27/1024468369765564416.png"],"title":"好久没有水文章了，今天水一篇前端的，主要是思路吧。","createTime":"2022-09-27 15:51:45.0","thumbUp":4,"viewCount":200,"type":0,"nickName":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","id":"1574783467713990658","userId":"1153952789488054272","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_27/1024355640186765312.png"],"title":"macOS提高效率的命令或者工具推荐","createTime":"2022-09-27 08:23:58.0","thumbUp":3,"viewCount":133,"type":0,"nickName":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","id":"1574673231388872706","userId":"1139423796017500160","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2022_09_27/1024276577443119104.webp"],"title":"jdbcTemplate 与 JPA 混合事务的尝试","createTime":"2022-09-27 03:09:40.0","thumbUp":1,"viewCount":104,"type":0,"nickName":"ccTyL","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","id":"1574596789019873281","userId":"1314408005793603584","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2021_08_30/881920635238875136.jpeg"],"title":"分享极客时间svip课程 （正在更新 请及时关注）","createTime":"2022-09-26 09:55:42.0","thumbUp":7,"viewCount":208,"type":0,"nickName":"林深不知处","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","id":"1574336837818781698","userId":"1432238344913395714","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_22/1022459919896412160.png"],"title":"第一个Flutter 项目 以及环境搭建","createTime":"2022-09-22 02:51:05.0","thumbUp":5,"viewCount":165,"type":0,"nickName":"lyq","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/40/rBsADWAs7x-ACX4eAABWd1wcLa4239.png","id":"1572780249794482177","userId":"1200362719631499264","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2022_09_21/1022263587248275456.png"],"title":"Android APP 在线更新功能实现分享","createTime":"2022-09-21 14:13:08.0","thumbUp":2,"viewCount":212,"type":0,"nickName":"lyq","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/40/rBsADWAs7x-ACX4eAABWd1wcLa4239.png","id":"1571332829269200898","userId":"1200362719631499264","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2021_06_03/849993984393609216.png"],"title":"UE开发数字人-心得","createTime":"2022-09-15 11:17:02.0","thumbUp":7,"viewCount":182,"type":0,"nickName":"dajiba009","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","id":"1570369760997150721","userId":"1298536191469150208","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2021_11_16/910205469912465408.jpg"],"title":"flutter---未来物联网ui框架","createTime":"2022-09-15 05:32:08.0","thumbUp":4,"viewCount":204,"type":0,"nickName":"kingKing","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","id":"1570280591352401921","userId":"1460523302899433474","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_13/1019184027820621824.png"],"title":"AndroidStudio导入系统源码","createTime":"2022-09-13 01:57:58.0","thumbUp":6,"viewCount":342,"type":0,"nickName":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","id":"1569499961886773250","userId":"1153952789488054272","isVip":false},{"covers":["https://images.sunofbeaches.com/content/2022_09_11/1018591177353461760.gif","https://images.sunofbeaches.com/content/2022_09_11/1018590379605229568.png","https://images.sunofbeaches.com/content/2022_09_11/1018598101453111296.jpg"],"title":"安卓字体描边效果","createTime":"2022-09-11 11:08:15.0","thumbUp":4,"viewCount":193,"type":0,"nickName":"有效信息","avatar":"https://images.sunofbeaches.com/content/2021_11_11/908422195649183744.png","id":"1568908167826378753","userId":"1254287380538462208","isVip":true},{"covers":["https://images.sunofbeaches.com/content/2022_09_09/1017810615814586368.png"],"title":"Android-SearchFlowLayout v1.1版本他来了","createTime":"2022-09-09 06:57:04.0","thumbUp":4,"viewCount":229,"type":0,"nickName":"CH-Android","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","id":"1568130557106196481","userId":"1290102301154942976","isVip":false}]
         * total : 1580.0
         * pageSize : 30.0
         * currentPage : 1.0
         * hasNext : true
         * hasPre : false
         * totalPage : 53.0
         */

        @SerializedName("total")
        private Double total;
        @SerializedName("pageSize")
        private Double pageSize;
        @SerializedName("currentPage")
        private Double currentPage;
        @SerializedName("hasNext")
        private Boolean hasNext;
        @SerializedName("hasPre")
        private Boolean hasPre;
        @SerializedName("totalPage")
        private Double totalPage;
        @SerializedName("list")
        private List<ListBean> list;

        public Double getTotal() {
            return total;
        }

        public Double getPageSize() {
            return pageSize;
        }

        public Double getCurrentPage() {
            return currentPage;
        }

        public Boolean getHasNext() {
            return hasNext;
        }

        public Boolean getHasPre() {
            return hasPre;
        }

        public Double getTotalPage() {
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

        public static class ListBean implements Serializable , MultiItemEntity {
            /**
             * covers : ["https://images.sunofbeaches.com/content/2022_10_28/1035558124586532864.png"]
             * title : Ubuntu 18.04编译AOSP 6.0.1
             * createTime : 2022-10-28 06:18:44.0
             * thumbUp : 0.0
             * viewCount : 4.0
             * type : 0.0
             * nickName : 断点
             * avatar : https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png
             * id : 1585878505108987905
             * userId : 1139423796017500160
             * isVip : true
             */

            @SerializedName("title")
            private String title;
            @SerializedName("createTime")
            private String createTime;
            @SerializedName("thumbUp")
            private Integer thumbUp;
            @SerializedName("viewCount")
            private Integer viewCount;
            @SerializedName("type")
            private Double type;
            @SerializedName("nickName")
            private String nickName;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("id")
            private String id;
            @SerializedName("userId")
            private String userId;
            @SerializedName("isVip")
            private Boolean isVip;
            @SerializedName("covers")
            private List<String> covers;

            public String getTitle() {
                return title;
            }

            public String getCreateTime() {
                return createTime;
            }

            public Integer getThumbUp() {
                return thumbUp;
            }

            public Integer getViewCount() {
                return viewCount;
            }

            public Double getType() {
                return type;
            }

            public String getNickName() {
                return nickName;
            }

            public String getAvatar() {
                return avatar;
            }

            public String getId() {
                return id;
            }

            public String getUserId() {
                return userId;
            }

            public Boolean getVip() {
                return isVip;
            }

            public List<String> getCovers() {
                return covers;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "title='" + title + '\'' +
                        ", createTime='" + createTime + '\'' +
                        ", thumbUp=" + thumbUp +
                        ", viewCount=" + viewCount +
                        ", type=" + type +
                        ", nickName='" + nickName + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", id='" + id + '\'' +
                        ", userId='" + userId + '\'' +
                        ", isVip=" + isVip +
                        ", covers=" + covers +
                        '}';
            }

            @Override
            public int getItemType() {
                return this.covers.size()>1?2:1;
            }
        }
    }
}
