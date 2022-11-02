package com.program.module_wenda.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WendaListBean implements Serializable {
    /**
     * success : true
     * code : 10000
     * message : 获取问答列表成功.
     * data : {"list":[{"id":"1586988693287264257","title":"使用Glide展示图片，放大页面后便无法展示对应图片了","userId":"1427933493035376641","avatar":"https://images.sunofbeaches.com/content/2022_01_19/933423282235899904.png","nickname":"tophuang","answerCount":3,"label":null,"createTime":"2022-10-31 15:49","isResolve":"1","viewCount":12,"thumbUp":0,"sob":16,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["android","glide"]},{"id":"1586729740963864578","title":"横向布局的RecyclerView中怎么给每个item做平移动画","userId":"1436177379159547906","avatar":"https://images.sunofbeaches.com/content/2022_03_02/948699466842505216.png","nickname":"尖沙咀-段坤","answerCount":1,"label":null,"createTime":"2022-10-30 22:40","isResolve":"0","viewCount":9,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["动画"]},{"id":"1586347891242491906","title":"无从下手，脑子好乱啊","userId":"1586347262981890049","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"啊啊啊安卓爱上我","answerCount":5,"label":null,"createTime":"2022-10-29 21:23","isResolve":"0","viewCount":11,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["安卓"]},{"id":"1586201435617550337","title":"关于vue学习遇到的问题","userId":"1463783870984896513","avatar":"https://images.sunofbeaches.com/content/2022_10_29/1035875960588599296.jpg","nickname":"BaGa","answerCount":2,"label":null,"createTime":"2022-10-29 11:41","isResolve":"1","viewCount":18,"thumbUp":0,"sob":2,"categoryId":"1160629004139606016","categoryName":"前端/Flutter","isVip":"1","state":null,"labels":["vue"]},{"id":"1585870298688970753","title":"往媒体库插入数据携带位置信息","userId":"1427933493035376641","avatar":"https://images.sunofbeaches.com/content/2022_01_19/933423282235899904.png","nickname":"tophuang","answerCount":1,"label":null,"createTime":"2022-10-28 13:45","isResolve":"1","viewCount":5,"thumbUp":0,"sob":12,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["android","android媒体库"]},{"id":"1585297870485118978","title":"如何监听StickyHeader的点击事件？","userId":"1527848511679238146","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"安卓练习生","answerCount":2,"label":null,"createTime":"2022-10-26 23:50","isResolve":"1","viewCount":11,"thumbUp":0,"sob":6,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["自定义View","RecyclerView"]},{"id":"1584588318630404098","title":"aosp怎样只下载单仓代码，比如launcher3，能否指定下载t或者s。","userId":"1533490475221127169","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"cry","answerCount":3,"label":null,"createTime":"2022-10-25 00:51","isResolve":"1","viewCount":14,"thumbUp":0,"sob":6,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["aosp"]},{"id":"1584461912495808513","title":"android使用exoplayer播放媒体库视频开头快进","userId":"1427933493035376641","avatar":"https://images.sunofbeaches.com/content/2022_01_19/933423282235899904.png","nickname":"tophuang","answerCount":2,"label":null,"createTime":"2022-10-24 16:28","isResolve":"0","viewCount":9,"thumbUp":0,"sob":8,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["android车机","媒体库","exoplayer"]},{"id":"1584412836173635586","title":"有什么好用的RV 或者 适配器框架吗？","userId":"1346006481350291456","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"Aka安卓菜鸟","answerCount":2,"label":null,"createTime":"2022-10-24 13:13","isResolve":"1","viewCount":9,"thumbUp":0,"sob":15,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["Android","RV","适配器"]},{"id":"1584366013983678466","title":"如何触发想要的FileObserver监听事件","userId":"1268774545783795712","avatar":"https://images.sunofbeaches.com/content/2022_03_29/958358748433219584.png","nickname":"ALEX","answerCount":1,"label":null,"createTime":"2022-10-24 10:07","isResolve":"0","viewCount":8,"thumbUp":1,"sob":50,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["Android","adb","java"]},{"id":"1584193094062104578","title":"SQLite加入数据无效","userId":"1584190500313763841","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"jmjmjmjmjm","answerCount":1,"label":null,"createTime":"2022-10-23 22:40","isResolve":"0","viewCount":4,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["SQLite","Android"]},{"id":"1583302749997629442","title":"轮播图，图片自动轮播","userId":"1583301821424734210","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"罗师粉","answerCount":2,"label":null,"createTime":"2022-10-21 11:42","isResolve":"0","viewCount":12,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["android轮播图"]},{"id":"1583300364051021825","title":"关于Android GPS定位的疑问","userId":"1139423796017500160","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","nickname":"断点","answerCount":1,"label":null,"createTime":"2022-10-21 11:33","isResolve":"0","viewCount":9,"thumbUp":0,"sob":20,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["GPS","Android"]},{"id":"1583136788019544066","title":"Linux环境下编译第三方内核问题","userId":"1216830916760965120","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/0E/rBsADV4c3lOAe3XQAAARPTB-zes803.png","nickname":"π大星","answerCount":2,"label":null,"createTime":"2022-10-21 00:43","isResolve":"1","viewCount":33,"thumbUp":0,"sob":24,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["安卓内核","ubuntu","linux"]},{"id":"1582736458681286657","title":"求助：关于sqlite数据查询","userId":"1575086981463937025","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"San","answerCount":2,"label":null,"createTime":"2022-10-19 22:12","isResolve":"0","viewCount":7,"thumbUp":0,"sob":5,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["Android","sqlite"]},{"id":"1582646209347190786","title":"大佬们，获取到某个人发表的全部动态或文章应该用阳光沙滩api里的哪个接口啊？","userId":"1439224908176531457","avatar":"https://images.sunofbeaches.com/content/2022_09_17/1020665323814125568.jpg","nickname":"什本先生","answerCount":1,"label":null,"createTime":"2022-10-19 16:13","isResolve":"1","viewCount":17,"thumbUp":0,"sob":52,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["阳光沙滩api"]},{"id":"1582554718985650178","title":"Compose 预览问题 preview","userId":"1382711465131241472","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","nickname":"阿肥","answerCount":1,"label":null,"createTime":"2022-10-19 10:10","isResolve":"1","viewCount":10,"thumbUp":0,"sob":10,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["compose","preview"]},{"id":"1582354083057106945","title":"Android修改AOSP中的framework某些代码之后如何快速编译刷机","userId":"1139423796017500160","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","nickname":"断点","answerCount":2,"label":null,"createTime":"2022-10-18 20:53","isResolve":"1","viewCount":19,"thumbUp":0,"sob":20,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["AOSP","framework","Android"]},{"id":"1582000931837317122","title":"如何在应用自动开启自定义无障碍服务","userId":"1459787886420312066","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"GE","answerCount":1,"label":null,"createTime":"2022-10-17 21:29","isResolve":"0","viewCount":20,"thumbUp":0,"sob":4,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["Android"]},{"id":"1581549148006518786","title":"求大锯哥请维护领券联盟api","userId":"1516039525208428545","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"tzs","answerCount":1,"label":null,"createTime":"2022-10-16 15:34","isResolve":"0","viewCount":37,"thumbUp":0,"sob":10,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["api失效"]},{"id":"1580599545304190977","title":"notifyDataSetInvalidated()无法更新adapter","userId":"1542927957012516865","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"吴昕铭","answerCount":2,"label":null,"createTime":"2022-10-14 00:41","isResolve":"0","viewCount":10,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["安卓","listView","adapter"]},{"id":"1579645728232312834","title":"部署网站成功后，网页上的图片无法访问","userId":"1302969105866940416","avatar":"https://images.sunofbeaches.com/content/2022_04_03/960254152636628992.png","nickname":"波鲁萨利诺.黄猿","answerCount":3,"label":null,"createTime":"2022-10-11 09:31","isResolve":"1","viewCount":43,"thumbUp":0,"sob":10,"categoryId":"1160629004139606016","categoryName":"前端/Flutter","isVip":"0","state":null,"labels":["项目部署"]},{"id":"1579409032580435969","title":"网站交互模块的App素材大锯老师能提供吗","userId":"1308197751560986624","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"MMA","answerCount":3,"label":null,"createTime":"2022-10-10 17:50","isResolve":"1","viewCount":13,"thumbUp":1,"sob":5,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["阳光沙滩","素材"]},{"id":"1579020060989591554","title":"关于监控android的内存dump","userId":"1268774545783795712","avatar":"https://images.sunofbeaches.com/content/2022_03_29/958358748433219584.png","nickname":"ALEX","answerCount":2,"label":null,"createTime":"2022-10-09 16:04","isResolve":"0","viewCount":22,"thumbUp":0,"sob":50,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["Android","C","JNI"]},{"id":"1578950414387122178","title":"领卷联盟数据拿不到","userId":"1425634667024982018","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"代码战士","answerCount":1,"label":null,"createTime":"2022-10-09 11:28","isResolve":"0","viewCount":32,"thumbUp":1,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["安卓"]},{"id":"1578652519297454081","title":"java请求参数如何不携带转译字符","userId":"1382711465131241472","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","nickname":"阿肥","answerCount":2,"label":null,"createTime":"2022-10-08 15:44","isResolve":"1","viewCount":12,"thumbUp":0,"sob":20,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["json","jsonarray"]},{"id":"1578574793198800897","title":"内容提供者P17(图片媒体库),获取表结构报错","userId":"1572585254856691714","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"philohao","answerCount":1,"label":null,"createTime":"2022-10-08 10:35","isResolve":"0","viewCount":9,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["求助","内容提供者"]},{"id":"1577262320692760577","title":"compose界面卡顿","userId":"1342082010843308032","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"Cstri","answerCount":1,"label":null,"createTime":"2022-10-04 19:40","isResolve":"1","viewCount":10,"thumbUp":0,"sob":5,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["compose"]},{"id":"1575690487010955266","title":"admob 广告 可以嵌入到一个布局里面吗？","userId":"1342082010843308032","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"Cstri","answerCount":2,"label":null,"createTime":"2022-09-30 11:34","isResolve":"1","viewCount":24,"thumbUp":0,"sob":5,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["admob"]},{"id":"1574946580711084034","title":"Horizo\u200b\u200bntalGridView设置FOCUS_SCROLL_PAGE翻页崩溃","userId":"1491235681811423234","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"z.","answerCount":1,"label":null,"createTime":"2022-09-28 10:18","isResolve":"0","viewCount":25,"thumbUp":1,"sob":16,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["androidTv","leanback","HorizontalGridView"]}],"total":2690,"pageSize":30,"currentPage":1,"hasNext":true,"hasPre":false,"totalPage":90}
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
        return "WendaListBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * list : [{"id":"1586988693287264257","title":"使用Glide展示图片，放大页面后便无法展示对应图片了","userId":"1427933493035376641","avatar":"https://images.sunofbeaches.com/content/2022_01_19/933423282235899904.png","nickname":"tophuang","answerCount":3,"label":null,"createTime":"2022-10-31 15:49","isResolve":"1","viewCount":12,"thumbUp":0,"sob":16,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["android","glide"]},{"id":"1586729740963864578","title":"横向布局的RecyclerView中怎么给每个item做平移动画","userId":"1436177379159547906","avatar":"https://images.sunofbeaches.com/content/2022_03_02/948699466842505216.png","nickname":"尖沙咀-段坤","answerCount":1,"label":null,"createTime":"2022-10-30 22:40","isResolve":"0","viewCount":9,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["动画"]},{"id":"1586347891242491906","title":"无从下手，脑子好乱啊","userId":"1586347262981890049","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"啊啊啊安卓爱上我","answerCount":5,"label":null,"createTime":"2022-10-29 21:23","isResolve":"0","viewCount":11,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["安卓"]},{"id":"1586201435617550337","title":"关于vue学习遇到的问题","userId":"1463783870984896513","avatar":"https://images.sunofbeaches.com/content/2022_10_29/1035875960588599296.jpg","nickname":"BaGa","answerCount":2,"label":null,"createTime":"2022-10-29 11:41","isResolve":"1","viewCount":18,"thumbUp":0,"sob":2,"categoryId":"1160629004139606016","categoryName":"前端/Flutter","isVip":"1","state":null,"labels":["vue"]},{"id":"1585870298688970753","title":"往媒体库插入数据携带位置信息","userId":"1427933493035376641","avatar":"https://images.sunofbeaches.com/content/2022_01_19/933423282235899904.png","nickname":"tophuang","answerCount":1,"label":null,"createTime":"2022-10-28 13:45","isResolve":"1","viewCount":5,"thumbUp":0,"sob":12,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["android","android媒体库"]},{"id":"1585297870485118978","title":"如何监听StickyHeader的点击事件？","userId":"1527848511679238146","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"安卓练习生","answerCount":2,"label":null,"createTime":"2022-10-26 23:50","isResolve":"1","viewCount":11,"thumbUp":0,"sob":6,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["自定义View","RecyclerView"]},{"id":"1584588318630404098","title":"aosp怎样只下载单仓代码，比如launcher3，能否指定下载t或者s。","userId":"1533490475221127169","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"cry","answerCount":3,"label":null,"createTime":"2022-10-25 00:51","isResolve":"1","viewCount":14,"thumbUp":0,"sob":6,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["aosp"]},{"id":"1584461912495808513","title":"android使用exoplayer播放媒体库视频开头快进","userId":"1427933493035376641","avatar":"https://images.sunofbeaches.com/content/2022_01_19/933423282235899904.png","nickname":"tophuang","answerCount":2,"label":null,"createTime":"2022-10-24 16:28","isResolve":"0","viewCount":9,"thumbUp":0,"sob":8,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["android车机","媒体库","exoplayer"]},{"id":"1584412836173635586","title":"有什么好用的RV 或者 适配器框架吗？","userId":"1346006481350291456","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"Aka安卓菜鸟","answerCount":2,"label":null,"createTime":"2022-10-24 13:13","isResolve":"1","viewCount":9,"thumbUp":0,"sob":15,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["Android","RV","适配器"]},{"id":"1584366013983678466","title":"如何触发想要的FileObserver监听事件","userId":"1268774545783795712","avatar":"https://images.sunofbeaches.com/content/2022_03_29/958358748433219584.png","nickname":"ALEX","answerCount":1,"label":null,"createTime":"2022-10-24 10:07","isResolve":"0","viewCount":8,"thumbUp":1,"sob":50,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["Android","adb","java"]},{"id":"1584193094062104578","title":"SQLite加入数据无效","userId":"1584190500313763841","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"jmjmjmjmjm","answerCount":1,"label":null,"createTime":"2022-10-23 22:40","isResolve":"0","viewCount":4,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["SQLite","Android"]},{"id":"1583302749997629442","title":"轮播图，图片自动轮播","userId":"1583301821424734210","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"罗师粉","answerCount":2,"label":null,"createTime":"2022-10-21 11:42","isResolve":"0","viewCount":12,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["android轮播图"]},{"id":"1583300364051021825","title":"关于Android GPS定位的疑问","userId":"1139423796017500160","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","nickname":"断点","answerCount":1,"label":null,"createTime":"2022-10-21 11:33","isResolve":"0","viewCount":9,"thumbUp":0,"sob":20,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["GPS","Android"]},{"id":"1583136788019544066","title":"Linux环境下编译第三方内核问题","userId":"1216830916760965120","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/0E/rBsADV4c3lOAe3XQAAARPTB-zes803.png","nickname":"π大星","answerCount":2,"label":null,"createTime":"2022-10-21 00:43","isResolve":"1","viewCount":33,"thumbUp":0,"sob":24,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["安卓内核","ubuntu","linux"]},{"id":"1582736458681286657","title":"求助：关于sqlite数据查询","userId":"1575086981463937025","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"San","answerCount":2,"label":null,"createTime":"2022-10-19 22:12","isResolve":"0","viewCount":7,"thumbUp":0,"sob":5,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["Android","sqlite"]},{"id":"1582646209347190786","title":"大佬们，获取到某个人发表的全部动态或文章应该用阳光沙滩api里的哪个接口啊？","userId":"1439224908176531457","avatar":"https://images.sunofbeaches.com/content/2022_09_17/1020665323814125568.jpg","nickname":"什本先生","answerCount":1,"label":null,"createTime":"2022-10-19 16:13","isResolve":"1","viewCount":17,"thumbUp":0,"sob":52,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["阳光沙滩api"]},{"id":"1582554718985650178","title":"Compose 预览问题 preview","userId":"1382711465131241472","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","nickname":"阿肥","answerCount":1,"label":null,"createTime":"2022-10-19 10:10","isResolve":"1","viewCount":10,"thumbUp":0,"sob":10,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["compose","preview"]},{"id":"1582354083057106945","title":"Android修改AOSP中的framework某些代码之后如何快速编译刷机","userId":"1139423796017500160","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","nickname":"断点","answerCount":2,"label":null,"createTime":"2022-10-18 20:53","isResolve":"1","viewCount":19,"thumbUp":0,"sob":20,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["AOSP","framework","Android"]},{"id":"1582000931837317122","title":"如何在应用自动开启自定义无障碍服务","userId":"1459787886420312066","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"GE","answerCount":1,"label":null,"createTime":"2022-10-17 21:29","isResolve":"0","viewCount":20,"thumbUp":0,"sob":4,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["Android"]},{"id":"1581549148006518786","title":"求大锯哥请维护领券联盟api","userId":"1516039525208428545","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"tzs","answerCount":1,"label":null,"createTime":"2022-10-16 15:34","isResolve":"0","viewCount":37,"thumbUp":0,"sob":10,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["api失效"]},{"id":"1580599545304190977","title":"notifyDataSetInvalidated()无法更新adapter","userId":"1542927957012516865","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"吴昕铭","answerCount":2,"label":null,"createTime":"2022-10-14 00:41","isResolve":"0","viewCount":10,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["安卓","listView","adapter"]},{"id":"1579645728232312834","title":"部署网站成功后，网页上的图片无法访问","userId":"1302969105866940416","avatar":"https://images.sunofbeaches.com/content/2022_04_03/960254152636628992.png","nickname":"波鲁萨利诺.黄猿","answerCount":3,"label":null,"createTime":"2022-10-11 09:31","isResolve":"1","viewCount":43,"thumbUp":0,"sob":10,"categoryId":"1160629004139606016","categoryName":"前端/Flutter","isVip":"0","state":null,"labels":["项目部署"]},{"id":"1579409032580435969","title":"网站交互模块的App素材大锯老师能提供吗","userId":"1308197751560986624","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"MMA","answerCount":3,"label":null,"createTime":"2022-10-10 17:50","isResolve":"1","viewCount":13,"thumbUp":1,"sob":5,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["阳光沙滩","素材"]},{"id":"1579020060989591554","title":"关于监控android的内存dump","userId":"1268774545783795712","avatar":"https://images.sunofbeaches.com/content/2022_03_29/958358748433219584.png","nickname":"ALEX","answerCount":2,"label":null,"createTime":"2022-10-09 16:04","isResolve":"0","viewCount":22,"thumbUp":0,"sob":50,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["Android","C","JNI"]},{"id":"1578950414387122178","title":"领卷联盟数据拿不到","userId":"1425634667024982018","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"代码战士","answerCount":1,"label":null,"createTime":"2022-10-09 11:28","isResolve":"0","viewCount":32,"thumbUp":1,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["安卓"]},{"id":"1578652519297454081","title":"java请求参数如何不携带转译字符","userId":"1382711465131241472","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","nickname":"阿肥","answerCount":2,"label":null,"createTime":"2022-10-08 15:44","isResolve":"1","viewCount":12,"thumbUp":0,"sob":20,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["json","jsonarray"]},{"id":"1578574793198800897","title":"内容提供者P17(图片媒体库),获取表结构报错","userId":"1572585254856691714","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"philohao","answerCount":1,"label":null,"createTime":"2022-10-08 10:35","isResolve":"0","viewCount":9,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["求助","内容提供者"]},{"id":"1577262320692760577","title":"compose界面卡顿","userId":"1342082010843308032","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"Cstri","answerCount":1,"label":null,"createTime":"2022-10-04 19:40","isResolve":"1","viewCount":10,"thumbUp":0,"sob":5,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["compose"]},{"id":"1575690487010955266","title":"admob 广告 可以嵌入到一个布局里面吗？","userId":"1342082010843308032","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"Cstri","answerCount":2,"label":null,"createTime":"2022-09-30 11:34","isResolve":"1","viewCount":24,"thumbUp":0,"sob":5,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["admob"]},{"id":"1574946580711084034","title":"Horizo\u200b\u200bntalGridView设置FOCUS_SCROLL_PAGE翻页崩溃","userId":"1491235681811423234","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"z.","answerCount":1,"label":null,"createTime":"2022-09-28 10:18","isResolve":"0","viewCount":25,"thumbUp":1,"sob":16,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["androidTv","leanback","HorizontalGridView"]}]
         * total : 2690
         * pageSize : 30
         * currentPage : 1
         * hasNext : true
         * hasPre : false
         * totalPage : 90
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
             * id : 1586988693287264257
             * title : 使用Glide展示图片，放大页面后便无法展示对应图片了
             * userId : 1427933493035376641
             * avatar : https://images.sunofbeaches.com/content/2022_01_19/933423282235899904.png
             * nickname : tophuang
             * answerCount : 3
             * label : null
             * createTime : 2022-10-31 15:49
             * isResolve : 1
             * viewCount : 12
             * thumbUp : 0
             * sob : 16
             * categoryId : 1161256637437153280
             * categoryName : 安卓/iOS
             * isVip : 1
             * state : null
             * labels : ["android","glide"]
             */

            @SerializedName("id")
            private String id;
            @SerializedName("title")
            private String title;
            @SerializedName("userId")
            private String userId;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("answerCount")
            private Integer answerCount;
            @SerializedName("label")
            private Object label;
            @SerializedName("createTime")
            private String createTime;
            @SerializedName("isResolve")
            private String isResolve;
            @SerializedName("viewCount")
            private Integer viewCount;
            @SerializedName("thumbUp")
            private Integer thumbUp;
            @SerializedName("sob")
            private Integer sob;
            @SerializedName("categoryId")
            private String categoryId;
            @SerializedName("categoryName")
            private String categoryName;
            @SerializedName("isVip")
            private String isVip;
            @SerializedName("state")
            private Object state;
            @SerializedName("labels")
            private List<String> labels;

            public String getId() {
                return id;
            }

            public String getTitle() {
                return title;
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

            public Integer getAnswerCount() {
                return answerCount;
            }

            public Object getLabel() {
                return label;
            }

            public String getCreateTime() {
                return createTime;
            }

            public String getIsResolve() {
                return isResolve;
            }

            public Integer getViewCount() {
                return viewCount;
            }

            public Integer getThumbUp() {
                return thumbUp;
            }

            public Integer getSob() {
                return sob;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public String getIsVip() {
                return isVip;
            }

            public Object getState() {
                return state;
            }

            public List<String> getLabels() {
                return labels;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", userId='" + userId + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", answerCount=" + answerCount +
                        ", label=" + label +
                        ", createTime='" + createTime + '\'' +
                        ", isResolve='" + isResolve + '\'' +
                        ", viewCount=" + viewCount +
                        ", thumbUp=" + thumbUp +
                        ", sob=" + sob +
                        ", categoryId='" + categoryId + '\'' +
                        ", categoryName='" + categoryName + '\'' +
                        ", isVip='" + isVip + '\'' +
                        ", state=" + state +
                        ", labels=" + labels +
                        '}';
            }
        }
    }
}
