package com.program.module_ucenter.model.domain;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ShareBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取用户分享成功.
     * data : {"list":[{"id":"1011202010088734720","title":"国内访问Android开发者官网","url":"https://developer.android.google.cn/","labels":["Android","开发者","developer","google","文档"],"thumbUp":0,"createTime":"2022-08-22 09:15","viewCount":82,"cover":"https://images.sunofbeaches.com/content/2022_08_22/1011201886050582528.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1011199570870272000","title":"Gityuan","url":"http://gityuan.com/","labels":["aosp","android","系统","flutter","源码"],"thumbUp":0,"createTime":"2022-08-22 09:06","viewCount":80,"cover":"https://images.sunofbeaches.com/content/2022_08_22/1011199465316417536.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1011051495073775616","title":"吴小龙同学","url":"http://wuxiaolong.me/","labels":["aosp","系统","博文","安卓系统","安卓开发"],"thumbUp":0,"createTime":"2022-08-21 23:17","viewCount":60,"cover":"https://images.sunofbeaches.com/content/2022_08_21/1011051395161260032.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1010153610970923008","title":"Ubuntu手册","url":"https://wiki.ubuntu.org.cn/UbuntuManual","labels":["Ubuntu","操作系统","参考手册","book","命令"],"thumbUp":0,"createTime":"2022-08-19 11:49","viewCount":58,"cover":"https://images.sunofbeaches.com/content/2022_08_19/1010153507799433216.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"998534568216625152","title":"Jmeter 压测工具","url":"https://github.com/apache/jmeter","labels":["压力测试","jmeter","测试","压力","工具"],"thumbUp":0,"createTime":"2022-07-18 10:19","viewCount":118,"cover":"https://images.sunofbeaches.com/content/2022_07_18/998534492958228480.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"995650152943321088","title":"王爽汇编语言论坛推荐","url":"http://www.asmedu.net/bbs/forum.jsp","labels":["汇编语言","论坛","推荐","编程语言"],"thumbUp":0,"createTime":"2022-07-10 11:18","viewCount":161,"cover":"https://images.sunofbeaches.com/content/2022_07_10/995649977403310080.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"987117323133386752","title":"不知道写啥，写Launcher吧[今天没有代码]","url":"https://mp.weixin.qq.com/s?__biz=MzI3MTU5MTA4OA==&mid=2247484825&idx=1&sn=a59dc233ab48773ce447366eaafd6e49&chksm=eb3e3646dc49bf50d97068ed3f2b35342f72c9daa9bc40037f93c38bf746e70de6cd19d8447d&token=822051009&lang=zh_CN#rd","labels":["Launcher","Android开发","AOSP","定制"],"thumbUp":0,"createTime":"2022-06-16 22:11","viewCount":97,"cover":"https://images.sunofbeaches.com/content/2022_06_16/987117190022955008.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"987084013808123904","title":"今天推广阳光沙滩客户端【还望转发】","url":"https://mp.weixin.qq.com/s?__biz=MzI3MTU5MTA4OA==&mid=2247484801&idx=1&sn=16f579ba266d529fce68fbced601ee2a&chksm=eb3e365edc49bf48261d9767c6b786dd6a2aca3d113d4de40a7fa19b4e58a8304e122d578fe7&token=665973101&lang=zh_CN#rd","labels":["客户端","Android","阳光沙滩","App","应用下载"],"thumbUp":0,"createTime":"2022-06-16 19:59","viewCount":114,"cover":"https://images.sunofbeaches.com/content/2022_06_16/987083932560261120.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"987012698271121408","title":"easyexcel库在docker镜像上跑报的错","url":"https://github.com/alibaba/easyexcel/issues/1533","labels":["bug","easyexcel","错误"],"thumbUp":0,"createTime":"2022-06-16 15:16","viewCount":100,"cover":"https://images.sunofbeaches.com/content/2022_06_16/987012655363391488.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"986929662670143488","title":"程序员喝啥？总不能上班干几瓶酒吧！","url":"https://mp.weixin.qq.com/s?__biz=MzI3MTU5MTA4OA==&mid=2247484815&idx=1&sn=c96329f28aa6324bd0e5e0a8d4e582a4&chksm=eb3e3650dc49bf46b37c3184b1168a3e1d8236faab5907fb6ce2e852d9c5329e3146413cab23&token=665973101&lang=zh_CN#rd","labels":["日常","枸杞","饮料","程序员","上班"],"thumbUp":0,"createTime":"2022-06-16 09:46","viewCount":86,"cover":"https://images.sunofbeaches.com/content/2022_06_16/986929596983148544.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"973174643173097472","title":"WebStorm历史版本","url":"https://www.jetbrains.com/webstorm/download/other.html","labels":["工具","webstorm","效率","下载","IDE"],"thumbUp":0,"createTime":"2022-05-09 10:48","viewCount":156,"cover":"https://images.sunofbeaches.com/content/2022_05_09/973174546246926336.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"966643802200604672","title":"SpringMobile获取到请求来源","url":"https://docs.spring.io/spring-mobile/docs/current/reference/html/device.html","labels":["web","spring","mobile"],"thumbUp":0,"createTime":"2022-04-21 10:17","viewCount":154,"cover":"https://images.sunofbeaches.com/content/2022_04_21/966643744382124032.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"964652920005984256","title":"Java爬虫工具","url":"https://github.com/jhy/jsoup","labels":["jsoup","爬虫","Web开发","java","工具"],"thumbUp":0,"createTime":"2022-04-15 22:26","viewCount":192,"cover":"https://images.sunofbeaches.com/content/2022_04_15/964652826355564544.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"954721378706128896","title":"阳光沙滩Android客户端源码-Power by 小烽","url":"https://github.com/anjiemo/SunnyBeach","labels":["阳光沙滩","客户端","APP","毕业设计","前端开发"],"thumbUp":0,"createTime":"2022-03-19 12:41","viewCount":261,"cover":"https://images.sunofbeaches.com/content/2022_03_19/954721299928711168.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"949698810030850048","title":"管理中心后台脚手架web-admin-vue","url":"https://github.com/TrillGates/web-admin-vue","labels":["vue","admin","管理中心","前端","脚手架"],"thumbUp":0,"createTime":"2022-03-05 16:04","viewCount":223,"cover":"https://images.sunofbeaches.com/content/2022_03_05/949698729638625280.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"949685859215474688","title":"node.js下载地址","url":"https://nodejs.org/zh-cn/","labels":["node","js","javascript","前端","开发"],"thumbUp":0,"createTime":"2022-03-05 15:12","viewCount":173,"cover":"https://images.sunofbeaches.com/content/2022_03_05/949685725241016320.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"949102919343407104","title":"文件对比工具推荐","url":"https://www.beyondcomparepro.com/product","labels":["Beyon","Compare","对比工具","经验","推荐"],"thumbUp":0,"createTime":"2022-03-04 00:36","viewCount":191,"cover":"https://images.sunofbeaches.com/content/2022_03_03/949102798018969600.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"948902068498726912","title":"KubeSphere3.0 常见问题与解决方法合集","url":"https://blog.csdn.net/weixin_44476161/article/details/114788608","labels":["分享","经验","kubephere","后台","部署"],"thumbUp":0,"createTime":"2022-03-03 11:18","viewCount":161,"cover":"https://images.sunofbeaches.com/content/2022_03_03/948901998722285568.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"948900863357747200","title":"网易行为式验证码","url":"https://dun.163.com/product/captcha","labels":["网易","验证码","行为验证码"],"thumbUp":0,"createTime":"2022-03-03 11:13","viewCount":212,"cover":"https://images.sunofbeaches.com/content/2022_03_03/948900811096719360.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"948898608202121216","title":"T-Sec 天御 验证码","url":"https://cloud.tencent.com/product/captcha","labels":["验证码","腾讯云","行验证码","分享","动态"],"thumbUp":0,"createTime":"2022-03-03 11:04","viewCount":212,"cover":"https://images.sunofbeaches.com/content/2022_03_03/948890027381751808.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"845328014064484352","title":"Ninja编辑的优势和弊端在哪里呢？","url":"http://blog.hanschen.site/2019/11/20/ninja_compile/","labels":["分享","测试内容","得优化","自动抓取内容","再来一个吧"],"thumbUp":0,"createTime":"2021-05-21 23:51","viewCount":403,"cover":"https://images.sunofbeaches.com/content/2021_05_06/839910209756332032.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1387348108173725696","title":"一个插件支持在IconFont直接复制图标到Axure上","url":"https://chrome.google.com/webstore/detail/axhub/cndglokmgjecikflojjieeeajbljgfae/related","labels":["工具","axure"],"thumbUp":0,"createTime":"2021-04-29 02:08","viewCount":365,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/48/rBsADWCJNDKAFMOQAAAtoT4DYT8188.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1367654325735739392","title":"侧滑要确定的删除见得多了，这个侧滑直接激活删除","url":"https://github.com/luckybilly/SmartSwipe","labels":["RecyclerView","侧滑删除","无需确定"],"thumbUp":0,"createTime":"2021-03-05 17:52","viewCount":590,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/42/rBsADWBBjuCARwf3AACemEENAHU481.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1319924150537568256","title":"阳光沙滩博客系统API接口","url":"https://www.sunofbeaches.com/article/752908774263488512","labels":["博客系统","api接口","前端接口","阳光沙滩","api"],"thumbUp":0,"createTime":"2020-10-25 00:50","viewCount":780,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/35/rBsADV-T6rSADOz4AAECEVuHFuo905.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1318853265449828352","title":"AOSP系列文章(一)-Android系统源码下载和编译","url":"https://mp.weixin.qq.com/s?__biz=MzI3MTU5MTA4OA==&mid=2247484712&idx=1&sn=e0efb072093ff2d74d7a6706526d9c2e&chksm=eb3e36f7dc49bfe14f632dc76064e31f2c5329964e78f67c050e0bd3d4158b99c94fa4b8b050&token=1812138225&lang=zh_CN#rd","labels":["Android系统","aosp"],"thumbUp":4,"createTime":"2020-10-22 01:54","viewCount":702,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/35/rBsADV-QBWaACytIAABFJkmDZtE587.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1256064157090918400","title":"程序员有哪些口头禅？工作了肯定深有体会","url":"https://mp.weixin.qq.com/s?__biz=MzI3MTU5MTA4OA==&mid=2247484348&idx=1&sn=091a0c07e3ed3f9210574282d1b51db1&chksm=eb3e3063dc49b9759064eb41720a3a647501d98995b630cab4cb8d824a7b3ad4a3b507f3b527&token=50164746&lang=zh_CN#rd","labels":["程序员","程序猿","程序媛","日常"],"thumbUp":1,"createTime":"2020-05-01 19:34","viewCount":587,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/1C/rBsADV6rmKKAGWU4AAFCExnaDac476.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1255677245712838656","title":"互联网企业一般有哪些职位？","url":"https://mp.weixin.qq.com/s?__biz=MzI3MTU5MTA4OA==&mid=2247484340&idx=1&sn=be2159d9a529a65f27811dd3a28abdd3&chksm=eb3e306bdc49b97d49c9896ed529835b035219211208c544db3846efe5192e0079be03df8dc5&token=869480496&lang=zh_CN#rd","labels":["职业","程序员","日常","面试","找工作"],"thumbUp":0,"createTime":"2020-04-30 17:57","viewCount":704,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/1B/rBsADV6qMGeAGgfLAAM5zJNm9lo807.jpg","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1253890099125497856","title":"Java Language and Virtual Machine Specifications","url":"https://docs.oracle.com/javase/specs/index.html","labels":["Java","JVM","虚拟机","规范","编程语言"],"thumbUp":0,"createTime":"2020-04-25 19:36","viewCount":430,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/1B/rBsADV6jsCiAJjU-AAmYwt2kTIQ278.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1241944577888333824","title":"Android 操作系统架构","url":"http://gityuan.com/android/","labels":["AOSP","famework","android","系统架构","安卓系统"],"thumbUp":0,"createTime":"2020-03-23 20:29","viewCount":964,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/16/rBsADV54OvSALQymAAXGOoW6ytQ758.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1240546087236907008","title":"JavaScript工具函数大全","url":"https://segmentfault.com/a/1190000021937948","labels":["javaScript","js","库","工具函数","大全"],"thumbUp":0,"createTime":"2020-03-19 23:51","viewCount":552,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/16/rBsADV5zJGeAIXK6AAJNaTyFySY564.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false}],"total":86,"pageSize":30,"currentPage":1,"hasNext":true,"hasPre":false,"totalPage":3}
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
        return "ShareBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * list : [{"id":"1011202010088734720","title":"国内访问Android开发者官网","url":"https://developer.android.google.cn/","labels":["Android","开发者","developer","google","文档"],"thumbUp":0,"createTime":"2022-08-22 09:15","viewCount":82,"cover":"https://images.sunofbeaches.com/content/2022_08_22/1011201886050582528.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1011199570870272000","title":"Gityuan","url":"http://gityuan.com/","labels":["aosp","android","系统","flutter","源码"],"thumbUp":0,"createTime":"2022-08-22 09:06","viewCount":80,"cover":"https://images.sunofbeaches.com/content/2022_08_22/1011199465316417536.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1011051495073775616","title":"吴小龙同学","url":"http://wuxiaolong.me/","labels":["aosp","系统","博文","安卓系统","安卓开发"],"thumbUp":0,"createTime":"2022-08-21 23:17","viewCount":60,"cover":"https://images.sunofbeaches.com/content/2022_08_21/1011051395161260032.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1010153610970923008","title":"Ubuntu手册","url":"https://wiki.ubuntu.org.cn/UbuntuManual","labels":["Ubuntu","操作系统","参考手册","book","命令"],"thumbUp":0,"createTime":"2022-08-19 11:49","viewCount":58,"cover":"https://images.sunofbeaches.com/content/2022_08_19/1010153507799433216.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"998534568216625152","title":"Jmeter 压测工具","url":"https://github.com/apache/jmeter","labels":["压力测试","jmeter","测试","压力","工具"],"thumbUp":0,"createTime":"2022-07-18 10:19","viewCount":118,"cover":"https://images.sunofbeaches.com/content/2022_07_18/998534492958228480.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"995650152943321088","title":"王爽汇编语言论坛推荐","url":"http://www.asmedu.net/bbs/forum.jsp","labels":["汇编语言","论坛","推荐","编程语言"],"thumbUp":0,"createTime":"2022-07-10 11:18","viewCount":161,"cover":"https://images.sunofbeaches.com/content/2022_07_10/995649977403310080.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"987117323133386752","title":"不知道写啥，写Launcher吧[今天没有代码]","url":"https://mp.weixin.qq.com/s?__biz=MzI3MTU5MTA4OA==&mid=2247484825&idx=1&sn=a59dc233ab48773ce447366eaafd6e49&chksm=eb3e3646dc49bf50d97068ed3f2b35342f72c9daa9bc40037f93c38bf746e70de6cd19d8447d&token=822051009&lang=zh_CN#rd","labels":["Launcher","Android开发","AOSP","定制"],"thumbUp":0,"createTime":"2022-06-16 22:11","viewCount":97,"cover":"https://images.sunofbeaches.com/content/2022_06_16/987117190022955008.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"987084013808123904","title":"今天推广阳光沙滩客户端【还望转发】","url":"https://mp.weixin.qq.com/s?__biz=MzI3MTU5MTA4OA==&mid=2247484801&idx=1&sn=16f579ba266d529fce68fbced601ee2a&chksm=eb3e365edc49bf48261d9767c6b786dd6a2aca3d113d4de40a7fa19b4e58a8304e122d578fe7&token=665973101&lang=zh_CN#rd","labels":["客户端","Android","阳光沙滩","App","应用下载"],"thumbUp":0,"createTime":"2022-06-16 19:59","viewCount":114,"cover":"https://images.sunofbeaches.com/content/2022_06_16/987083932560261120.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"987012698271121408","title":"easyexcel库在docker镜像上跑报的错","url":"https://github.com/alibaba/easyexcel/issues/1533","labels":["bug","easyexcel","错误"],"thumbUp":0,"createTime":"2022-06-16 15:16","viewCount":100,"cover":"https://images.sunofbeaches.com/content/2022_06_16/987012655363391488.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"986929662670143488","title":"程序员喝啥？总不能上班干几瓶酒吧！","url":"https://mp.weixin.qq.com/s?__biz=MzI3MTU5MTA4OA==&mid=2247484815&idx=1&sn=c96329f28aa6324bd0e5e0a8d4e582a4&chksm=eb3e3650dc49bf46b37c3184b1168a3e1d8236faab5907fb6ce2e852d9c5329e3146413cab23&token=665973101&lang=zh_CN#rd","labels":["日常","枸杞","饮料","程序员","上班"],"thumbUp":0,"createTime":"2022-06-16 09:46","viewCount":86,"cover":"https://images.sunofbeaches.com/content/2022_06_16/986929596983148544.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"973174643173097472","title":"WebStorm历史版本","url":"https://www.jetbrains.com/webstorm/download/other.html","labels":["工具","webstorm","效率","下载","IDE"],"thumbUp":0,"createTime":"2022-05-09 10:48","viewCount":156,"cover":"https://images.sunofbeaches.com/content/2022_05_09/973174546246926336.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"966643802200604672","title":"SpringMobile获取到请求来源","url":"https://docs.spring.io/spring-mobile/docs/current/reference/html/device.html","labels":["web","spring","mobile"],"thumbUp":0,"createTime":"2022-04-21 10:17","viewCount":154,"cover":"https://images.sunofbeaches.com/content/2022_04_21/966643744382124032.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"964652920005984256","title":"Java爬虫工具","url":"https://github.com/jhy/jsoup","labels":["jsoup","爬虫","Web开发","java","工具"],"thumbUp":0,"createTime":"2022-04-15 22:26","viewCount":192,"cover":"https://images.sunofbeaches.com/content/2022_04_15/964652826355564544.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"954721378706128896","title":"阳光沙滩Android客户端源码-Power by 小烽","url":"https://github.com/anjiemo/SunnyBeach","labels":["阳光沙滩","客户端","APP","毕业设计","前端开发"],"thumbUp":0,"createTime":"2022-03-19 12:41","viewCount":261,"cover":"https://images.sunofbeaches.com/content/2022_03_19/954721299928711168.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"949698810030850048","title":"管理中心后台脚手架web-admin-vue","url":"https://github.com/TrillGates/web-admin-vue","labels":["vue","admin","管理中心","前端","脚手架"],"thumbUp":0,"createTime":"2022-03-05 16:04","viewCount":223,"cover":"https://images.sunofbeaches.com/content/2022_03_05/949698729638625280.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"949685859215474688","title":"node.js下载地址","url":"https://nodejs.org/zh-cn/","labels":["node","js","javascript","前端","开发"],"thumbUp":0,"createTime":"2022-03-05 15:12","viewCount":173,"cover":"https://images.sunofbeaches.com/content/2022_03_05/949685725241016320.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"949102919343407104","title":"文件对比工具推荐","url":"https://www.beyondcomparepro.com/product","labels":["Beyon","Compare","对比工具","经验","推荐"],"thumbUp":0,"createTime":"2022-03-04 00:36","viewCount":191,"cover":"https://images.sunofbeaches.com/content/2022_03_03/949102798018969600.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"948902068498726912","title":"KubeSphere3.0 常见问题与解决方法合集","url":"https://blog.csdn.net/weixin_44476161/article/details/114788608","labels":["分享","经验","kubephere","后台","部署"],"thumbUp":0,"createTime":"2022-03-03 11:18","viewCount":161,"cover":"https://images.sunofbeaches.com/content/2022_03_03/948901998722285568.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"948900863357747200","title":"网易行为式验证码","url":"https://dun.163.com/product/captcha","labels":["网易","验证码","行为验证码"],"thumbUp":0,"createTime":"2022-03-03 11:13","viewCount":212,"cover":"https://images.sunofbeaches.com/content/2022_03_03/948900811096719360.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"948898608202121216","title":"T-Sec 天御 验证码","url":"https://cloud.tencent.com/product/captcha","labels":["验证码","腾讯云","行验证码","分享","动态"],"thumbUp":0,"createTime":"2022-03-03 11:04","viewCount":212,"cover":"https://images.sunofbeaches.com/content/2022_03_03/948890027381751808.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"845328014064484352","title":"Ninja编辑的优势和弊端在哪里呢？","url":"http://blog.hanschen.site/2019/11/20/ninja_compile/","labels":["分享","测试内容","得优化","自动抓取内容","再来一个吧"],"thumbUp":0,"createTime":"2021-05-21 23:51","viewCount":403,"cover":"https://images.sunofbeaches.com/content/2021_05_06/839910209756332032.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1387348108173725696","title":"一个插件支持在IconFont直接复制图标到Axure上","url":"https://chrome.google.com/webstore/detail/axhub/cndglokmgjecikflojjieeeajbljgfae/related","labels":["工具","axure"],"thumbUp":0,"createTime":"2021-04-29 02:08","viewCount":365,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/48/rBsADWCJNDKAFMOQAAAtoT4DYT8188.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1367654325735739392","title":"侧滑要确定的删除见得多了，这个侧滑直接激活删除","url":"https://github.com/luckybilly/SmartSwipe","labels":["RecyclerView","侧滑删除","无需确定"],"thumbUp":0,"createTime":"2021-03-05 17:52","viewCount":590,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/42/rBsADWBBjuCARwf3AACemEENAHU481.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1319924150537568256","title":"阳光沙滩博客系统API接口","url":"https://www.sunofbeaches.com/article/752908774263488512","labels":["博客系统","api接口","前端接口","阳光沙滩","api"],"thumbUp":0,"createTime":"2020-10-25 00:50","viewCount":780,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/35/rBsADV-T6rSADOz4AAECEVuHFuo905.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1318853265449828352","title":"AOSP系列文章(一)-Android系统源码下载和编译","url":"https://mp.weixin.qq.com/s?__biz=MzI3MTU5MTA4OA==&mid=2247484712&idx=1&sn=e0efb072093ff2d74d7a6706526d9c2e&chksm=eb3e36f7dc49bfe14f632dc76064e31f2c5329964e78f67c050e0bd3d4158b99c94fa4b8b050&token=1812138225&lang=zh_CN#rd","labels":["Android系统","aosp"],"thumbUp":4,"createTime":"2020-10-22 01:54","viewCount":702,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/35/rBsADV-QBWaACytIAABFJkmDZtE587.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1256064157090918400","title":"程序员有哪些口头禅？工作了肯定深有体会","url":"https://mp.weixin.qq.com/s?__biz=MzI3MTU5MTA4OA==&mid=2247484348&idx=1&sn=091a0c07e3ed3f9210574282d1b51db1&chksm=eb3e3063dc49b9759064eb41720a3a647501d98995b630cab4cb8d824a7b3ad4a3b507f3b527&token=50164746&lang=zh_CN#rd","labels":["程序员","程序猿","程序媛","日常"],"thumbUp":1,"createTime":"2020-05-01 19:34","viewCount":587,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/1C/rBsADV6rmKKAGWU4AAFCExnaDac476.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1255677245712838656","title":"互联网企业一般有哪些职位？","url":"https://mp.weixin.qq.com/s?__biz=MzI3MTU5MTA4OA==&mid=2247484340&idx=1&sn=be2159d9a529a65f27811dd3a28abdd3&chksm=eb3e306bdc49b97d49c9896ed529835b035219211208c544db3846efe5192e0079be03df8dc5&token=869480496&lang=zh_CN#rd","labels":["职业","程序员","日常","面试","找工作"],"thumbUp":0,"createTime":"2020-04-30 17:57","viewCount":704,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/1B/rBsADV6qMGeAGgfLAAM5zJNm9lo807.jpg","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1253890099125497856","title":"Java Language and Virtual Machine Specifications","url":"https://docs.oracle.com/javase/specs/index.html","labels":["Java","JVM","虚拟机","规范","编程语言"],"thumbUp":0,"createTime":"2020-04-25 19:36","viewCount":430,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/1B/rBsADV6jsCiAJjU-AAmYwt2kTIQ278.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1241944577888333824","title":"Android 操作系统架构","url":"http://gityuan.com/android/","labels":["AOSP","famework","android","系统架构","安卓系统"],"thumbUp":0,"createTime":"2020-03-23 20:29","viewCount":964,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/16/rBsADV54OvSALQymAAXGOoW6ytQ758.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false},{"id":"1240546087236907008","title":"JavaScript工具函数大全","url":"https://segmentfault.com/a/1190000021937948","labels":["javaScript","js","库","工具函数","大全"],"thumbUp":0,"createTime":"2020-03-19 23:51","viewCount":552,"cover":"https://imgs.sunofbeaches.com/group1/M00/00/16/rBsADV5zJGeAIXK6AAJNaTyFySY564.png","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","userId":null,"categoryName":null,"state":null,"description":null,"vip":false}]
         * total : 86
         * pageSize : 30
         * currentPage : 1
         * hasNext : true
         * hasPre : false
         * totalPage : 3
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
             * id : 1011202010088734720
             * title : 国内访问Android开发者官网
             * url : https://developer.android.google.cn/
             * labels : ["Android","开发者","developer","google","文档"]
             * thumbUp : 0
             * createTime : 2022-08-22 09:15
             * viewCount : 82
             * cover : https://images.sunofbeaches.com/content/2022_08_22/1011201886050582528.png
             * nickname : 拉大锯
             * avatar : https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png
             * userId : null
             * categoryName : null
             * state : null
             * description : null
             * vip : false
             */

            @SerializedName("id")
            private String id;
            @SerializedName("title")
            private String title;
            @SerializedName("url")
            private String url;
            @SerializedName("thumbUp")
            private Integer thumbUp;
            @SerializedName("createTime")
            private String createTime;
            @SerializedName("viewCount")
            private Integer viewCount;
            @SerializedName("cover")
            private String cover;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("userId")
            private Object userId;
            @SerializedName("categoryName")
            private Object categoryName;
            @SerializedName("state")
            private Object state;
            @SerializedName("description")
            private Object description;
            @SerializedName("vip")
            private Boolean vip;
            @SerializedName("labels")
            private List<String> labels;

            public String getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }

            public String getUrl() {
                return url;
            }

            public Integer getThumbUp() {
                return thumbUp;
            }

            public String getCreateTime() {
                return createTime;
            }

            public Integer getViewCount() {
                return viewCount;
            }

            public String getCover() {
                return cover;
            }

            public String getNickname() {
                return nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public Object getUserId() {
                return userId;
            }

            public Object getCategoryName() {
                return categoryName;
            }

            public Object getState() {
                return state;
            }

            public Object getDescription() {
                return description;
            }

            public Boolean getVip() {
                return vip;
            }

            public List<String> getLabels() {
                return labels;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", url='" + url + '\'' +
                        ", thumbUp=" + thumbUp +
                        ", createTime='" + createTime + '\'' +
                        ", viewCount=" + viewCount +
                        ", cover='" + cover + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", userId=" + userId +
                        ", categoryName=" + categoryName +
                        ", state=" + state +
                        ", description=" + description +
                        ", vip=" + vip +
                        ", labels=" + labels +
                        '}';
            }

            @Override
            public int getItemType() {
                return 2;
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
