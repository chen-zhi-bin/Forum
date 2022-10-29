package com.program.module_moyu.model.bean;

import com.google.gson.annotations.SerializedName;
import com.program.moudle_base.model.MoyuItemBean;

import java.io.Serializable;
import java.util.List;

public class MoyuListBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取摸鱼列表成功.
     * data : {"list":[{"id":"1586318062094835713","userId":"1139423796017500160","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","company":"阳光沙滩","position":"资深摸鱼技术专家","content":"今天一天就这么过了。。。。。","linkCover":"","linkTitle":"","linkUrl":"https://mp.weixin.qq.com/s/MOF_bLX7tPjKKzkWDLSxkA","commentCount":1,"thumbUpCount":0,"images":[],"topicName":"养生之道","topicId":"1384190025620533249","createTime":"2022-10-29 19:24","hasThumbUp":false,"thumbUpList":[],"vip":true},{"id":"1586198927297929218","userId":"1463783870984896513","nickname":"BaGa","avatar":"https://images.sunofbeaches.com/content/2022_10_29/1035875960588599296.jpg","company":"","position":"学生","content":"信息系统设计，这作业是一点思路没有啊","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":1,"thumbUpCount":0,"images":[],"topicName":null,"topicId":null,"createTime":"2022-10-29 11:31","hasThumbUp":false,"thumbUpList":[],"vip":true},{"id":"1585867813517713410","userId":"1139423796017500160","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","company":"阳光沙滩","position":"资深摸鱼技术专家","content":"编译5.1的时间怎么比6长呢，6编译一个半小时，难度是因为硬盘不一样........","linkCover":"","linkTitle":"","linkUrl":"","commentCount":2,"thumbUpCount":2,"images":["https://images.sunofbeaches.com/content/2022_10_28/1035547187758497792.png"],"topicName":"猿(媛)装备","topicId":"1384518640040153089","createTime":"2022-10-28 13:35","hasThumbUp":false,"thumbUpList":["1247069679944470528","1274165387499433984"],"vip":true},{"id":"1585845422414553090","userId":"1504452765877800961","nickname":"搬砖侠","avatar":"https://images.sunofbeaches.com/content/2022_04_14/964124335407104000.png","company":"咖喱巴巴","position":"资深摸鱼开发攻城狮","content":"服务器活过来打个卡！","linkCover":"","linkTitle":"","linkUrl":"","commentCount":1,"thumbUpCount":5,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-28 12:06","hasThumbUp":false,"thumbUpList":["1504452765877800961","1139423796017500160","1382711465131241472","1153952789488054272","1247069679944470528"],"vip":false},{"id":"1585836674904154113","userId":"1153952789488054272","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","company":"阳光沙滩","position":"首席打杂工程师","content":"服务器又莫名其妙地不行了，过些时间有空了还是再购买一台吧，搞不上高可用也得搞个主从。","linkCover":"","linkTitle":"","linkUrl":"","commentCount":1,"thumbUpCount":10,"images":[],"topicName":"小目标","topicId":"1384518863412006914","createTime":"2022-10-28 11:31","hasThumbUp":false,"thumbUpList":["1382711465131241472","1314408005793603584","1302969105866940416","1504452765877800961","1139423796017500160","1238780348930818048","1247069679944470528","1226864425491763200","1231137268748521472","1274165387499433984"],"vip":false},{"id":"1585833870256955393","userId":"1302969105866940416","nickname":"波鲁萨利诺.黄猿","avatar":"https://images.sunofbeaches.com/content/2022_04_03/960254152636628992.png","company":"广州无限摸鱼公司","position":"android开发","content":"妈蛋，键盘坏了，又是摸鱼的一天","linkCover":"","linkTitle":"","linkUrl":"","commentCount":4,"thumbUpCount":0,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-28 11:20","hasThumbUp":false,"thumbUpList":["1302969105866940416","1231137268748521472","1382711465131241472","1504452765877800961","1139423796017500160"],"vip":false},{"id":"1585526771660546049","userId":"1382711465131241472","nickname":"阿肥","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","company":"广州摸鱼无责任有限公司","position":"首席划水工程师","content":"记得以前qq有个简约版的 少了点内容 包体小很多 现在在米商店竟然找不到 \n难不成只有华为的商店才有么\n需要的功能不用多 可以聊天就好 现在qq塞太多东西了 don·t like","linkCover":null,"linkTitle":null,"linkUrl":"","commentCount":6,"thumbUpCount":0,"images":[],"topicName":"一语惊人","topicId":"1384518439661473794","createTime":"2022-10-27 15:00","hasThumbUp":false,"thumbUpList":["1274165387499433984","1139423796017500160","1439224908176531457","1231137268748521472"],"vip":false},{"id":"1585521421242785793","userId":"1250988207093321728","nickname":"纠结轮","avatar":"https://images.sunofbeaches.com/content/2022_07_04/993567554951708672.png","company":"浑水摸鱼有限公司","position":"糕鸡 cv 攻城狮","content":"给一些非常规的字段取名的时候好烦，能想半天而且我还是强迫症，我记得看过有给字段取名的网站的，没保存... 大概是输入关键词后给个 字段名 出来，大伙有吗有吗？","linkCover":"","linkTitle":"","linkUrl":"","commentCount":2,"thumbUpCount":6,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-27 14:38","hasThumbUp":false,"thumbUpList":["1250988207093321728","1252579468782866432","1231137268748521472","1274165387499433984","1139423796017500160","1247069679944470528"],"vip":false},{"id":"1585506771595878402","userId":"1290102301154942976","nickname":"CH-Android","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","company":null,"position":null,"content":"今天薅了拼多多50羊毛 有兴趣试试","linkCover":"","linkTitle":"","linkUrl":"","commentCount":4,"thumbUpCount":0,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-27 13:40","hasThumbUp":false,"thumbUpList":["1153952789488054272","1274165387499433984","1139423796017500160","1504452765877800961","1404813466421735425"],"vip":false},{"id":"1585471847169974274","userId":"1153952789488054272","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","company":"阳光沙滩","position":"首席打杂工程师","content":"我同事说，没有疯狂星期四了！","linkCover":"","linkTitle":"","linkUrl":"","commentCount":4,"thumbUpCount":6,"images":[],"topicName":"划水摸鱼","topicId":"1384518752720130050","createTime":"2022-10-27 11:22","hasThumbUp":false,"thumbUpList":["1314408005793603584","1139423796017500160","1339887900006932480","1274165387499433984","1504452765877800961","1247069679944470528"],"vip":false},{"id":"1585470278777102337","userId":"1339887900006932480","nickname":"星期八","avatar":"https://images.sunofbeaches.com/content/2022_07_06/994205825054539776.png","company":"翻斗花园","position":"国家一级退堂鼓选手","content":"今天吃劳饭","linkCover":"","linkTitle":"","linkUrl":"","commentCount":3,"thumbUpCount":4,"images":["https://images.sunofbeaches.com/content/2022_10_27/1035149484511723520.jpg"],"topicName":null,"topicId":"","createTime":"2022-10-27 11:15","hasThumbUp":false,"thumbUpList":["1252579468782866432","1153952789488054272","1139423796017500160","1274165387499433984"],"vip":true},{"id":"1585467868134432769","userId":"1139423796017500160","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","company":"阳光沙滩","position":"资深摸鱼技术专家","content":"最近沙滩Android客户端用户活跃有了新高度","linkCover":"","linkTitle":"","linkUrl":"","commentCount":0,"thumbUpCount":10,"images":["https://images.sunofbeaches.com/content/2022_10_27/1035147198066589696.png"],"topicName":"小目标","topicId":"1384518863412006914","createTime":"2022-10-27 11:06","hasThumbUp":false,"thumbUpList":["1153952789488054272","1382711465131241472","1252579468782866432","1231137268748521472","1274165387499433984","1247069679944470528","1439224908176531457","1504452765877800961","1238780348930818048","1173631787251826688"],"vip":true},{"id":"1585450934164709378","userId":"1549198056233111553","nickname":"春风不识路","avatar":"https://images.sunofbeaches.com/content/2022_07_27/1001776060259368960.png","company":"摸鱼免责有限公司","position":"摸鱼工程师","content":"我觉得今天的麦当劳就是这个表情[doge]","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":1,"thumbUpCount":8,"images":["https://images.sunofbeaches.com/content/2022_10_27/1035130458200866816.png"],"topicName":"划水摸鱼","topicId":"1384518752720130050","createTime":"2022-10-27 09:58","hasThumbUp":false,"thumbUpList":["1382711465131241472","1252579468782866432","1511613756247904258","1153952789488054272","1139423796017500160","1404813466421735425","1274165387499433984","1504452765877800961"],"vip":false},{"id":"1585441279837396993","userId":"1382711465131241472","nickname":"阿肥","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","company":"广州摸鱼无责任有限公司","position":"首席划水工程师","content":"感觉你们好有趣啊，不像我，连句话都搭不上，还要被当成破坏氛围的傻狗，我现实生活中自闭没朋友，每次组织半天的语言都如鲠在喉，最后还默默删掉看你们互动，你有说有笑的样子不知道为什么在我眼里这么刺眼，融入不了群体的我，躲在屏幕后面默默哭出声，所以今天是肯德基疯狂星期四有好心人请我吃吗？","linkCover":null,"linkTitle":null,"linkUrl":"","commentCount":1,"thumbUpCount":0,"images":[],"topicName":"今天周四","topicId":"1537374698193555458","createTime":"2022-10-27 09:20","hasThumbUp":false,"thumbUpList":["1153952789488054272","1252579468782866432","1314408005793603584","1139423796017500160"],"vip":false},{"id":"1585439453914259458","userId":"1153952789488054272","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","company":"阳光沙滩","position":"首席打杂工程师","content":"我看看谁！","linkCover":"","linkTitle":"","linkUrl":"","commentCount":1,"thumbUpCount":4,"images":[],"topicName":"今天周四","topicId":"1537374698193555458","createTime":"2022-10-27 09:13","hasThumbUp":false,"thumbUpList":["1314408005793603584","1290102301154942976","1139423796017500160","1274165387499433984"],"vip":false},{"id":"1585437815082246146","userId":"1204736502274318336","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","company":"求内推呀","position":"Android 开发工程师","content":"大家好，我是野菜公主王宝钏，如今我孤生一人已经挖 了18年的野菜，身上的衣服也好久没换，实在是穷的没 钱。前几日薛平贵给我发短信说他当了西凉王，要封我 做皇后，叫我等他。可是我哪有力气再等下去。我不知 道什么疯狂星期四，V我50吃顿饭补充体力，来日待我 找到夫君，我送宫殿给你。","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":2,"thumbUpCount":7,"images":["https://images.sunofbeaches.com/content/2022_10_27/1035117340758376448.png"],"topicName":"今天周四","topicId":"1537374698193555458","createTime":"2022-10-27 09:06","hasThumbUp":false,"thumbUpList":["1252579468782866432","1382711465131241472","1153952789488054272","1314408005793603584","1511613756247904258","1139423796017500160","1274165387499433984"],"vip":true},{"id":"1585434548788977666","userId":"1139423796017500160","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","company":"阳光沙滩","position":"资深摸鱼技术专家","content":"程序员的大千世界~","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":2,"thumbUpCount":5,"images":["https://images.sunofbeaches.com/content/2022_10_27/1035114071403266048.jpg","https://images.sunofbeaches.com/content/2022_10_27/1035114073118736384.jpg","https://images.sunofbeaches.com/content/2022_10_27/1035114074716766208.png"],"topicName":"代码之美","topicId":"1384189862646657025","createTime":"2022-10-27 08:53","hasThumbUp":false,"thumbUpList":["1252579468782866432","1153952789488054272","1382711465131241472","1314408005793603584","1247069679944470528"],"vip":true},{"id":"1585267935389343745","userId":"1314408005793603584","nickname":"ccTyL","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","company":null,"position":null,"content":"<div>立即推：吸加加永远滴神。<\/div><div>感觉还是很吃香的，可以回去复习一波吸加加以备不时之需<img class=\"emoji\" src=\"https://cdn.sunofbeaches.com/emoji/7.png\" width=\"20\" height=\"20\"><\/div><div>另外sob薛定谔的图片上传，发动态时永远不知道能不能成功发出去<br><\/div>","linkCover":"","linkTitle":"","linkUrl":"","commentCount":1,"thumbUpCount":4,"images":["https://images.sunofbeaches.com/content/2022_10_26/1034946981182570496.jpg"],"topicName":null,"topicId":"","createTime":"2022-10-26 21:51","hasThumbUp":false,"thumbUpList":["1284274686481473536","1274165387499433984","1139423796017500160","1314408005793603584"],"vip":false},{"id":"1585248791184990209","userId":"1204736502274318336","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","company":"求内推呀","position":"Android 开发工程师","content":"世界上现在有77亿人，有253亿只鸡，是人的数量的3倍，如果鸡决定与人类开战那每个人平均要打三只鸡，明天是疯狂星期四，v我50我帮你去杀敌\u200b[doge][doge]","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":1,"thumbUpCount":0,"images":[],"topicName":"今天周三","topicId":"1537374636885413889","createTime":"2022-10-26 20:35","hasThumbUp":false,"thumbUpList":["1314408005793603584","1284274686481473536","1274165387499433984","1139423796017500160","1252579468782866432","1153952789488054272"],"vip":true},{"id":"1585222034633449473","userId":"1204736502274318336","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","company":"求内推呀","position":"Android 开发工程师","content":"今天不加班[doge]","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":1,"thumbUpCount":2,"images":[],"topicName":"下班打卡","topicId":"1458039707895095298","createTime":"2022-10-26 18:49","hasThumbUp":false,"thumbUpList":["1284274686481473536","1274165387499433984"],"vip":true},{"id":"1585202074485972993","userId":"1231137268748521472","nickname":"码划云","avatar":"https://images.sunofbeaches.com/content/2022_03_23/956117482517561344.png","company":"Android孤儿数码科技有限公司","position":"Android划水工程师","content":"兄弟们，你们在小时候没有手机的时候，都是用什么打法时间的呢？<div>我先来，随便一个地方（床上，饭桌地，客厅地板，屋后凉阴处..）一双小手，可以演绎一个好莱坞电影，小时候贼中二。<\/div>","linkCover":"","linkTitle":"","linkUrl":"","commentCount":7,"thumbUpCount":0,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-26 17:30","hasThumbUp":false,"thumbUpList":["1139423796017500160","1274165387499433984"],"vip":true},{"id":"1585162820393295874","userId":"1139423796017500160","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","company":"阳光沙滩","position":"资深摸鱼技术专家","content":"我今天发现打字的时候用左手按空格键，大伙们呢","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":7,"thumbUpCount":3,"images":[],"topicName":"猿(媛)装备","topicId":"1384518640040153089","createTime":"2022-10-26 14:54","hasThumbUp":false,"thumbUpList":["1153952789488054272","1382711465131241472","1284274686481473536"],"vip":true},{"id":"1585118967481163778","userId":"1231137268748521472","nickname":"码划云","avatar":"https://images.sunofbeaches.com/content/2022_03_23/956117482517561344.png","company":"Android孤儿数码科技有限公司","position":"Android划水工程师","content":"今天去买个彩票<img class=\"emoji\" src=\"https://cdn.sunofbeaches.com/emoji/105.png\" width=\"20\" height=\"20\">","linkCover":"","linkTitle":"","linkUrl":"","commentCount":2,"thumbUpCount":7,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-26 11:59","hasThumbUp":false,"thumbUpList":["1250988207093321728","1382711465131241472","1153952789488054272","1226864425491763200","1139423796017500160","1284274686481473536","1274165387499433984"],"vip":true},{"id":"1585087748806729730","userId":"1314408005793603584","nickname":"ccTyL","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","company":null,"position":null,"content":"过半<br>","linkCover":"","linkTitle":"","linkUrl":"","commentCount":1,"thumbUpCount":2,"images":["null"],"topicName":null,"topicId":"","createTime":"2022-10-26 09:55","hasThumbUp":false,"thumbUpList":["1284274686481473536","1314408005793603584"],"vip":false},{"id":"1585076502296453121","userId":"1139423796017500160","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","company":"阳光沙滩","position":"资深摸鱼技术专家","content":"突然就周三了，舒服！","linkCover":"","linkTitle":"","linkUrl":"","commentCount":2,"thumbUpCount":4,"images":[],"topicName":"养生之道","topicId":"1384190025620533249","createTime":"2022-10-26 09:11","hasThumbUp":false,"thumbUpList":["1504452765877800961","1382711465131241472","1284274686481473536","1226864425491763200"],"vip":true},{"id":"1585071388227723265","userId":"1290102301154942976","nickname":"CH-Android","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","company":null,"position":null,"content":"家人们中奖了，感谢大锯哥<img class=\"emoji\" src=\"https://cdn.sunofbeaches.com/emoji/48.png\" width=\"20\" height=\"20\">","linkCover":"","linkTitle":"","linkUrl":"","commentCount":1,"thumbUpCount":4,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-26 08:50","hasThumbUp":false,"thumbUpList":["1382711465131241472","1139423796017500160","1504452765877800961","1284274686481473536"],"vip":false},{"id":"1584891434907131906","userId":"1382711465131241472","nickname":"阿肥","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","company":"广州摸鱼无责任有限公司","position":"首席划水工程师","content":"中奖啦家人们 嘿嘿嘿[菜狗][菜狗][菜狗]","linkCover":null,"linkTitle":null,"linkUrl":"","commentCount":4,"thumbUpCount":4,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-25 20:55","hasThumbUp":false,"thumbUpList":["1139423796017500160","1153952789488054272","1290102301154942976","1284274686481473536"],"vip":false},{"id":"1584880724533764098","userId":"1153952789488054272","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","company":"阳光沙滩","position":"首席打杂工程师","content":"结果如下，三天内发放，如果没有二维码的，转到对应注册手机号的支付宝。","linkCover":"","linkTitle":"2022-10-25 8点随机抽样结果_哔哩哔哩_bilibili","linkUrl":"https://www.bilibili.com/video/BV15e4y127bq/?vd_source=c98cc423612cbdc90be94566ac4846f4","commentCount":5,"thumbUpCount":8,"images":["https://images.sunofbeaches.com/content/2022_10_25/1034559293413654528.png"],"topicName":null,"topicId":"","createTime":"2022-10-25 20:13","hasThumbUp":false,"thumbUpList":["1284274686481473536","1382711465131241472","1139423796017500160","1290102301154942976","1231137268748521472","1256120724666454016","1247069679944470528","1226864425491763200"],"vip":false},{"id":"1584792652928442370","userId":"1153952789488054272","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","company":"阳光沙滩","position":"首席打杂工程师","content":"以下是抽奖参与名单，可以检查一下自己符合条件的是否有在里面，只要昨天发了动态的。<div>另外10个10.24元，就100块钱，别直播了吧，录播证明公平性就好。哈哈！！！下次抽Mac再直播吧。<\/div>","linkCover":"","linkTitle":"","linkUrl":"","commentCount":9,"thumbUpCount":10,"images":["https://images.sunofbeaches.com/content/2022_10_25/1034472138351837184.png"],"topicName":"掐指一算","topicId":"1388133893743370241","createTime":"2022-10-25 14:23","hasThumbUp":false,"thumbUpList":["1139423796017500160","1339887900006932480","1231137268748521472","1252579468782866432","1347474750661849088","1284274686481473536","1226864425491763200","1406870956571394050","1314408005793603584","1504452765877800961"],"vip":false},{"id":"1584714590924759042","userId":"1153952789488054272","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","company":"阳光沙滩","position":"首席打杂工程师","content":"昨天抽奖的，应该超过10个人了，哈哈。为了公平性，晚上北京时间8点准时抽奖，也就是会录一个2022/10/25日20点的抽奖视频，抽奖工具我都不写了，直接用Excel。","linkCover":"","linkTitle":"","linkUrl":"","commentCount":5,"thumbUpCount":15,"images":[],"topicName":"划水摸鱼","topicId":"1384518752720130050","createTime":"2022-10-25 09:12","hasThumbUp":false,"thumbUpList":["1200362719631499264","1231137268748521472","1252579468782866432","1549198056233111553","1274165387499433984","1433361655298891777","1139423796017500160","1284274686481473536","1382711465131241472","1288722845765017600","1206836916729733120","1347474750661849088","1226864425491763200","1504452765877800961","1247069679944470528"],"vip":false}],"total":4643,"pageSize":30,"currentPage":1,"hasNext":true,"hasPre":false,"totalPage":155}
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
        return "MoyuListBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * list : [{"id":"1586318062094835713","userId":"1139423796017500160","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","company":"阳光沙滩","position":"资深摸鱼技术专家","content":"今天一天就这么过了。。。。。","linkCover":"","linkTitle":"","linkUrl":"https://mp.weixin.qq.com/s/MOF_bLX7tPjKKzkWDLSxkA","commentCount":1,"thumbUpCount":0,"images":[],"topicName":"养生之道","topicId":"1384190025620533249","createTime":"2022-10-29 19:24","hasThumbUp":false,"thumbUpList":[],"vip":true},{"id":"1586198927297929218","userId":"1463783870984896513","nickname":"BaGa","avatar":"https://images.sunofbeaches.com/content/2022_10_29/1035875960588599296.jpg","company":"","position":"学生","content":"信息系统设计，这作业是一点思路没有啊","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":1,"thumbUpCount":0,"images":[],"topicName":null,"topicId":null,"createTime":"2022-10-29 11:31","hasThumbUp":false,"thumbUpList":[],"vip":true},{"id":"1585867813517713410","userId":"1139423796017500160","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","company":"阳光沙滩","position":"资深摸鱼技术专家","content":"编译5.1的时间怎么比6长呢，6编译一个半小时，难度是因为硬盘不一样........","linkCover":"","linkTitle":"","linkUrl":"","commentCount":2,"thumbUpCount":2,"images":["https://images.sunofbeaches.com/content/2022_10_28/1035547187758497792.png"],"topicName":"猿(媛)装备","topicId":"1384518640040153089","createTime":"2022-10-28 13:35","hasThumbUp":false,"thumbUpList":["1247069679944470528","1274165387499433984"],"vip":true},{"id":"1585845422414553090","userId":"1504452765877800961","nickname":"搬砖侠","avatar":"https://images.sunofbeaches.com/content/2022_04_14/964124335407104000.png","company":"咖喱巴巴","position":"资深摸鱼开发攻城狮","content":"服务器活过来打个卡！","linkCover":"","linkTitle":"","linkUrl":"","commentCount":1,"thumbUpCount":5,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-28 12:06","hasThumbUp":false,"thumbUpList":["1504452765877800961","1139423796017500160","1382711465131241472","1153952789488054272","1247069679944470528"],"vip":false},{"id":"1585836674904154113","userId":"1153952789488054272","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","company":"阳光沙滩","position":"首席打杂工程师","content":"服务器又莫名其妙地不行了，过些时间有空了还是再购买一台吧，搞不上高可用也得搞个主从。","linkCover":"","linkTitle":"","linkUrl":"","commentCount":1,"thumbUpCount":10,"images":[],"topicName":"小目标","topicId":"1384518863412006914","createTime":"2022-10-28 11:31","hasThumbUp":false,"thumbUpList":["1382711465131241472","1314408005793603584","1302969105866940416","1504452765877800961","1139423796017500160","1238780348930818048","1247069679944470528","1226864425491763200","1231137268748521472","1274165387499433984"],"vip":false},{"id":"1585833870256955393","userId":"1302969105866940416","nickname":"波鲁萨利诺.黄猿","avatar":"https://images.sunofbeaches.com/content/2022_04_03/960254152636628992.png","company":"广州无限摸鱼公司","position":"android开发","content":"妈蛋，键盘坏了，又是摸鱼的一天","linkCover":"","linkTitle":"","linkUrl":"","commentCount":4,"thumbUpCount":0,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-28 11:20","hasThumbUp":false,"thumbUpList":["1302969105866940416","1231137268748521472","1382711465131241472","1504452765877800961","1139423796017500160"],"vip":false},{"id":"1585526771660546049","userId":"1382711465131241472","nickname":"阿肥","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","company":"广州摸鱼无责任有限公司","position":"首席划水工程师","content":"记得以前qq有个简约版的 少了点内容 包体小很多 现在在米商店竟然找不到 \n难不成只有华为的商店才有么\n需要的功能不用多 可以聊天就好 现在qq塞太多东西了 don·t like","linkCover":null,"linkTitle":null,"linkUrl":"","commentCount":6,"thumbUpCount":0,"images":[],"topicName":"一语惊人","topicId":"1384518439661473794","createTime":"2022-10-27 15:00","hasThumbUp":false,"thumbUpList":["1274165387499433984","1139423796017500160","1439224908176531457","1231137268748521472"],"vip":false},{"id":"1585521421242785793","userId":"1250988207093321728","nickname":"纠结轮","avatar":"https://images.sunofbeaches.com/content/2022_07_04/993567554951708672.png","company":"浑水摸鱼有限公司","position":"糕鸡 cv 攻城狮","content":"给一些非常规的字段取名的时候好烦，能想半天而且我还是强迫症，我记得看过有给字段取名的网站的，没保存... 大概是输入关键词后给个 字段名 出来，大伙有吗有吗？","linkCover":"","linkTitle":"","linkUrl":"","commentCount":2,"thumbUpCount":6,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-27 14:38","hasThumbUp":false,"thumbUpList":["1250988207093321728","1252579468782866432","1231137268748521472","1274165387499433984","1139423796017500160","1247069679944470528"],"vip":false},{"id":"1585506771595878402","userId":"1290102301154942976","nickname":"CH-Android","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","company":null,"position":null,"content":"今天薅了拼多多50羊毛 有兴趣试试","linkCover":"","linkTitle":"","linkUrl":"","commentCount":4,"thumbUpCount":0,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-27 13:40","hasThumbUp":false,"thumbUpList":["1153952789488054272","1274165387499433984","1139423796017500160","1504452765877800961","1404813466421735425"],"vip":false},{"id":"1585471847169974274","userId":"1153952789488054272","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","company":"阳光沙滩","position":"首席打杂工程师","content":"我同事说，没有疯狂星期四了！","linkCover":"","linkTitle":"","linkUrl":"","commentCount":4,"thumbUpCount":6,"images":[],"topicName":"划水摸鱼","topicId":"1384518752720130050","createTime":"2022-10-27 11:22","hasThumbUp":false,"thumbUpList":["1314408005793603584","1139423796017500160","1339887900006932480","1274165387499433984","1504452765877800961","1247069679944470528"],"vip":false},{"id":"1585470278777102337","userId":"1339887900006932480","nickname":"星期八","avatar":"https://images.sunofbeaches.com/content/2022_07_06/994205825054539776.png","company":"翻斗花园","position":"国家一级退堂鼓选手","content":"今天吃劳饭","linkCover":"","linkTitle":"","linkUrl":"","commentCount":3,"thumbUpCount":4,"images":["https://images.sunofbeaches.com/content/2022_10_27/1035149484511723520.jpg"],"topicName":null,"topicId":"","createTime":"2022-10-27 11:15","hasThumbUp":false,"thumbUpList":["1252579468782866432","1153952789488054272","1139423796017500160","1274165387499433984"],"vip":true},{"id":"1585467868134432769","userId":"1139423796017500160","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","company":"阳光沙滩","position":"资深摸鱼技术专家","content":"最近沙滩Android客户端用户活跃有了新高度","linkCover":"","linkTitle":"","linkUrl":"","commentCount":0,"thumbUpCount":10,"images":["https://images.sunofbeaches.com/content/2022_10_27/1035147198066589696.png"],"topicName":"小目标","topicId":"1384518863412006914","createTime":"2022-10-27 11:06","hasThumbUp":false,"thumbUpList":["1153952789488054272","1382711465131241472","1252579468782866432","1231137268748521472","1274165387499433984","1247069679944470528","1439224908176531457","1504452765877800961","1238780348930818048","1173631787251826688"],"vip":true},{"id":"1585450934164709378","userId":"1549198056233111553","nickname":"春风不识路","avatar":"https://images.sunofbeaches.com/content/2022_07_27/1001776060259368960.png","company":"摸鱼免责有限公司","position":"摸鱼工程师","content":"我觉得今天的麦当劳就是这个表情[doge]","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":1,"thumbUpCount":8,"images":["https://images.sunofbeaches.com/content/2022_10_27/1035130458200866816.png"],"topicName":"划水摸鱼","topicId":"1384518752720130050","createTime":"2022-10-27 09:58","hasThumbUp":false,"thumbUpList":["1382711465131241472","1252579468782866432","1511613756247904258","1153952789488054272","1139423796017500160","1404813466421735425","1274165387499433984","1504452765877800961"],"vip":false},{"id":"1585441279837396993","userId":"1382711465131241472","nickname":"阿肥","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","company":"广州摸鱼无责任有限公司","position":"首席划水工程师","content":"感觉你们好有趣啊，不像我，连句话都搭不上，还要被当成破坏氛围的傻狗，我现实生活中自闭没朋友，每次组织半天的语言都如鲠在喉，最后还默默删掉看你们互动，你有说有笑的样子不知道为什么在我眼里这么刺眼，融入不了群体的我，躲在屏幕后面默默哭出声，所以今天是肯德基疯狂星期四有好心人请我吃吗？","linkCover":null,"linkTitle":null,"linkUrl":"","commentCount":1,"thumbUpCount":0,"images":[],"topicName":"今天周四","topicId":"1537374698193555458","createTime":"2022-10-27 09:20","hasThumbUp":false,"thumbUpList":["1153952789488054272","1252579468782866432","1314408005793603584","1139423796017500160"],"vip":false},{"id":"1585439453914259458","userId":"1153952789488054272","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","company":"阳光沙滩","position":"首席打杂工程师","content":"我看看谁！","linkCover":"","linkTitle":"","linkUrl":"","commentCount":1,"thumbUpCount":4,"images":[],"topicName":"今天周四","topicId":"1537374698193555458","createTime":"2022-10-27 09:13","hasThumbUp":false,"thumbUpList":["1314408005793603584","1290102301154942976","1139423796017500160","1274165387499433984"],"vip":false},{"id":"1585437815082246146","userId":"1204736502274318336","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","company":"求内推呀","position":"Android 开发工程师","content":"大家好，我是野菜公主王宝钏，如今我孤生一人已经挖 了18年的野菜，身上的衣服也好久没换，实在是穷的没 钱。前几日薛平贵给我发短信说他当了西凉王，要封我 做皇后，叫我等他。可是我哪有力气再等下去。我不知 道什么疯狂星期四，V我50吃顿饭补充体力，来日待我 找到夫君，我送宫殿给你。","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":2,"thumbUpCount":7,"images":["https://images.sunofbeaches.com/content/2022_10_27/1035117340758376448.png"],"topicName":"今天周四","topicId":"1537374698193555458","createTime":"2022-10-27 09:06","hasThumbUp":false,"thumbUpList":["1252579468782866432","1382711465131241472","1153952789488054272","1314408005793603584","1511613756247904258","1139423796017500160","1274165387499433984"],"vip":true},{"id":"1585434548788977666","userId":"1139423796017500160","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","company":"阳光沙滩","position":"资深摸鱼技术专家","content":"程序员的大千世界~","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":2,"thumbUpCount":5,"images":["https://images.sunofbeaches.com/content/2022_10_27/1035114071403266048.jpg","https://images.sunofbeaches.com/content/2022_10_27/1035114073118736384.jpg","https://images.sunofbeaches.com/content/2022_10_27/1035114074716766208.png"],"topicName":"代码之美","topicId":"1384189862646657025","createTime":"2022-10-27 08:53","hasThumbUp":false,"thumbUpList":["1252579468782866432","1153952789488054272","1382711465131241472","1314408005793603584","1247069679944470528"],"vip":true},{"id":"1585267935389343745","userId":"1314408005793603584","nickname":"ccTyL","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","company":null,"position":null,"content":"<div>立即推：吸加加永远滴神。<\/div><div>感觉还是很吃香的，可以回去复习一波吸加加以备不时之需<img class=\"emoji\" src=\"https://cdn.sunofbeaches.com/emoji/7.png\" width=\"20\" height=\"20\"><\/div><div>另外sob薛定谔的图片上传，发动态时永远不知道能不能成功发出去<br><\/div>","linkCover":"","linkTitle":"","linkUrl":"","commentCount":1,"thumbUpCount":4,"images":["https://images.sunofbeaches.com/content/2022_10_26/1034946981182570496.jpg"],"topicName":null,"topicId":"","createTime":"2022-10-26 21:51","hasThumbUp":false,"thumbUpList":["1284274686481473536","1274165387499433984","1139423796017500160","1314408005793603584"],"vip":false},{"id":"1585248791184990209","userId":"1204736502274318336","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","company":"求内推呀","position":"Android 开发工程师","content":"世界上现在有77亿人，有253亿只鸡，是人的数量的3倍，如果鸡决定与人类开战那每个人平均要打三只鸡，明天是疯狂星期四，v我50我帮你去杀敌\u200b[doge][doge]","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":1,"thumbUpCount":0,"images":[],"topicName":"今天周三","topicId":"1537374636885413889","createTime":"2022-10-26 20:35","hasThumbUp":false,"thumbUpList":["1314408005793603584","1284274686481473536","1274165387499433984","1139423796017500160","1252579468782866432","1153952789488054272"],"vip":true},{"id":"1585222034633449473","userId":"1204736502274318336","nickname":"A lonely cat","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","company":"求内推呀","position":"Android 开发工程师","content":"今天不加班[doge]","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":1,"thumbUpCount":2,"images":[],"topicName":"下班打卡","topicId":"1458039707895095298","createTime":"2022-10-26 18:49","hasThumbUp":false,"thumbUpList":["1284274686481473536","1274165387499433984"],"vip":true},{"id":"1585202074485972993","userId":"1231137268748521472","nickname":"码划云","avatar":"https://images.sunofbeaches.com/content/2022_03_23/956117482517561344.png","company":"Android孤儿数码科技有限公司","position":"Android划水工程师","content":"兄弟们，你们在小时候没有手机的时候，都是用什么打法时间的呢？<div>我先来，随便一个地方（床上，饭桌地，客厅地板，屋后凉阴处..）一双小手，可以演绎一个好莱坞电影，小时候贼中二。<\/div>","linkCover":"","linkTitle":"","linkUrl":"","commentCount":7,"thumbUpCount":0,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-26 17:30","hasThumbUp":false,"thumbUpList":["1139423796017500160","1274165387499433984"],"vip":true},{"id":"1585162820393295874","userId":"1139423796017500160","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","company":"阳光沙滩","position":"资深摸鱼技术专家","content":"我今天发现打字的时候用左手按空格键，大伙们呢","linkCover":null,"linkTitle":null,"linkUrl":null,"commentCount":7,"thumbUpCount":3,"images":[],"topicName":"猿(媛)装备","topicId":"1384518640040153089","createTime":"2022-10-26 14:54","hasThumbUp":false,"thumbUpList":["1153952789488054272","1382711465131241472","1284274686481473536"],"vip":true},{"id":"1585118967481163778","userId":"1231137268748521472","nickname":"码划云","avatar":"https://images.sunofbeaches.com/content/2022_03_23/956117482517561344.png","company":"Android孤儿数码科技有限公司","position":"Android划水工程师","content":"今天去买个彩票<img class=\"emoji\" src=\"https://cdn.sunofbeaches.com/emoji/105.png\" width=\"20\" height=\"20\">","linkCover":"","linkTitle":"","linkUrl":"","commentCount":2,"thumbUpCount":7,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-26 11:59","hasThumbUp":false,"thumbUpList":["1250988207093321728","1382711465131241472","1153952789488054272","1226864425491763200","1139423796017500160","1284274686481473536","1274165387499433984"],"vip":true},{"id":"1585087748806729730","userId":"1314408005793603584","nickname":"ccTyL","avatar":"https://images.sunofbeaches.com/content/2021_10_09/896340281694093312.png","company":null,"position":null,"content":"过半<br>","linkCover":"","linkTitle":"","linkUrl":"","commentCount":1,"thumbUpCount":2,"images":["null"],"topicName":null,"topicId":"","createTime":"2022-10-26 09:55","hasThumbUp":false,"thumbUpList":["1284274686481473536","1314408005793603584"],"vip":false},{"id":"1585076502296453121","userId":"1139423796017500160","nickname":"断点","avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","company":"阳光沙滩","position":"资深摸鱼技术专家","content":"突然就周三了，舒服！","linkCover":"","linkTitle":"","linkUrl":"","commentCount":2,"thumbUpCount":4,"images":[],"topicName":"养生之道","topicId":"1384190025620533249","createTime":"2022-10-26 09:11","hasThumbUp":false,"thumbUpList":["1504452765877800961","1382711465131241472","1284274686481473536","1226864425491763200"],"vip":true},{"id":"1585071388227723265","userId":"1290102301154942976","nickname":"CH-Android","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","company":null,"position":null,"content":"家人们中奖了，感谢大锯哥<img class=\"emoji\" src=\"https://cdn.sunofbeaches.com/emoji/48.png\" width=\"20\" height=\"20\">","linkCover":"","linkTitle":"","linkUrl":"","commentCount":1,"thumbUpCount":4,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-26 08:50","hasThumbUp":false,"thumbUpList":["1382711465131241472","1139423796017500160","1504452765877800961","1284274686481473536"],"vip":false},{"id":"1584891434907131906","userId":"1382711465131241472","nickname":"阿肥","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","company":"广州摸鱼无责任有限公司","position":"首席划水工程师","content":"中奖啦家人们 嘿嘿嘿[菜狗][菜狗][菜狗]","linkCover":null,"linkTitle":null,"linkUrl":"","commentCount":4,"thumbUpCount":4,"images":[],"topicName":null,"topicId":"","createTime":"2022-10-25 20:55","hasThumbUp":false,"thumbUpList":["1139423796017500160","1153952789488054272","1290102301154942976","1284274686481473536"],"vip":false},{"id":"1584880724533764098","userId":"1153952789488054272","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","company":"阳光沙滩","position":"首席打杂工程师","content":"结果如下，三天内发放，如果没有二维码的，转到对应注册手机号的支付宝。","linkCover":"","linkTitle":"2022-10-25 8点随机抽样结果_哔哩哔哩_bilibili","linkUrl":"https://www.bilibili.com/video/BV15e4y127bq/?vd_source=c98cc423612cbdc90be94566ac4846f4","commentCount":5,"thumbUpCount":8,"images":["https://images.sunofbeaches.com/content/2022_10_25/1034559293413654528.png"],"topicName":null,"topicId":"","createTime":"2022-10-25 20:13","hasThumbUp":false,"thumbUpList":["1284274686481473536","1382711465131241472","1139423796017500160","1290102301154942976","1231137268748521472","1256120724666454016","1247069679944470528","1226864425491763200"],"vip":false},{"id":"1584792652928442370","userId":"1153952789488054272","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","company":"阳光沙滩","position":"首席打杂工程师","content":"以下是抽奖参与名单，可以检查一下自己符合条件的是否有在里面，只要昨天发了动态的。<div>另外10个10.24元，就100块钱，别直播了吧，录播证明公平性就好。哈哈！！！下次抽Mac再直播吧。<\/div>","linkCover":"","linkTitle":"","linkUrl":"","commentCount":9,"thumbUpCount":10,"images":["https://images.sunofbeaches.com/content/2022_10_25/1034472138351837184.png"],"topicName":"掐指一算","topicId":"1388133893743370241","createTime":"2022-10-25 14:23","hasThumbUp":false,"thumbUpList":["1139423796017500160","1339887900006932480","1231137268748521472","1252579468782866432","1347474750661849088","1284274686481473536","1226864425491763200","1406870956571394050","1314408005793603584","1504452765877800961"],"vip":false},{"id":"1584714590924759042","userId":"1153952789488054272","nickname":"拉大锯","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","company":"阳光沙滩","position":"首席打杂工程师","content":"昨天抽奖的，应该超过10个人了，哈哈。为了公平性，晚上北京时间8点准时抽奖，也就是会录一个2022/10/25日20点的抽奖视频，抽奖工具我都不写了，直接用Excel。","linkCover":"","linkTitle":"","linkUrl":"","commentCount":5,"thumbUpCount":15,"images":[],"topicName":"划水摸鱼","topicId":"1384518752720130050","createTime":"2022-10-25 09:12","hasThumbUp":false,"thumbUpList":["1200362719631499264","1231137268748521472","1252579468782866432","1549198056233111553","1274165387499433984","1433361655298891777","1139423796017500160","1284274686481473536","1382711465131241472","1288722845765017600","1206836916729733120","1347474750661849088","1226864425491763200","1504452765877800961","1247069679944470528"],"vip":false}]
         * total : 4643
         * pageSize : 30
         * currentPage : 1
         * hasNext : true
         * hasPre : false
         * totalPage : 155
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
        private List<MoyuItemBean> list;

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

        public List<MoyuItemBean> getList() {
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

        public static class ListBean extends MoyuItemBean implements Serializable {
            /**
             * id : 1586318062094835713
             * userId : 1139423796017500160
             * nickname : 断点
             * avatar : https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png
             * company : 阳光沙滩
             * position : 资深摸鱼技术专家
             * content : 今天一天就这么过了。。。。。
             * linkCover :
             * linkTitle :
             * linkUrl : https://mp.weixin.qq.com/s/MOF_bLX7tPjKKzkWDLSxkA
             * commentCount : 1
             * thumbUpCount : 0
             * images : []
             * topicName : 养生之道
             * topicId : 1384190025620533249
             * createTime : 2022-10-29 19:24
             * hasThumbUp : false
             * thumbUpList : []
             * vip : true
             */

            @SerializedName("id")
            private String id;
            @SerializedName("userId")
            private String userId;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("company")
            private String company;
            @SerializedName("position")
            private String position;
            @SerializedName("content")
            private String content;
            @SerializedName("linkCover")
            private String linkCover;
            @SerializedName("linkTitle")
            private String linkTitle;
            @SerializedName("linkUrl")
            private String linkUrl;
            @SerializedName("commentCount")
            private Integer commentCount;
            @SerializedName("thumbUpCount")
            private Integer thumbUpCount;
            @SerializedName("topicName")
            private String topicName;
            @SerializedName("topicId")
            private String topicId;
            @SerializedName("createTime")
            private String createTime;
            @SerializedName("hasThumbUp")
            private Boolean hasThumbUp;
            @SerializedName("vip")
            private Boolean vip;
            @SerializedName("images")
            private List<String> images;
            @SerializedName("thumbUpList")
            private List<String> thumbUpList;

            public String getId() {
                return id;
            }

            public String getUserId() {
                return userId;
            }

            public String getNickname() {
                return nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public String getCompany() {
                return company;
            }

            public String getPosition() {
                return position;
            }

            public String getContent() {
                return content;
            }

            public String getLinkCover() {
                return linkCover;
            }

            public String getLinkTitle() {
                return linkTitle;
            }

            public String getLinkUrl() {
                return linkUrl;
            }

            public Integer getCommentCount() {
                return commentCount;
            }

            public Integer getThumbUpCount() {
                return thumbUpCount;
            }

            public String getTopicName() {
                return topicName;
            }

            public String getTopicId() {
                return topicId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public Boolean getHasThumbUp() {
                return hasThumbUp;
            }

            public Boolean getVip() {
                return vip;
            }

            public List<String> getImages() {
                return images;
            }

            public List<String> getThumbUpList() {
                return thumbUpList;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id='" + id + '\'' +
                        ", userId='" + userId + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", company='" + company + '\'' +
                        ", position='" + position + '\'' +
                        ", content='" + content + '\'' +
                        ", linkCover='" + linkCover + '\'' +
                        ", linkTitle='" + linkTitle + '\'' +
                        ", linkUrl='" + linkUrl + '\'' +
                        ", commentCount=" + commentCount +
                        ", thumbUpCount=" + thumbUpCount +
                        ", topicName='" + topicName + '\'' +
                        ", topicId='" + topicId + '\'' +
                        ", createTime='" + createTime + '\'' +
                        ", hasThumbUp=" + hasThumbUp +
                        ", vip=" + vip +
                        ", images=" + images +
                        ", thumbUpList=" + thumbUpList +
                        '}';
            }
        }
    }
}
