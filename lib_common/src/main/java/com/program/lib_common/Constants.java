package com.program.lib_common;

public class Constants {
    public static final String BASE_URL="https://api.sunofbeaches.com";

   public static final String WEBSITE_URL = "https://www.sunofbeach.net/a/";
   public static final String UCENTER_URL = "https://www.sunofbeach.net/u/";
   public static final String WENDA_URL = "https://www.sunofbeach.net/qa/";

    public static final int NAVIGATION_VIEW_MENU_RECOMMEND_ITEM_ID_INDEX = 0;
    public static final int NAVIGATION_VIEW_MENU_USER_ITEM_ID_INDEX = 2;

    public static final int RETURN_TO_HMOE = 1;
    public static final int RETURN_TO_USER = 3;
    public static final int NEED_RESULT = 0;

    public static final int SUCCESS=10000;

    public static final String DATA_TYPE = "data_type";
    public static final String DATA_TPTE_ARTICLE = "article";
    public static final String DATA_TPTE_SHARA = "share";
    public static final String DATA_TPTE_WENDA = "wenda";

    public class Search{
        public static final String SEARCH_TYPE="search_type";
        public static final String SEARCH_ARTICLE = "a";    //文章
        public static final String SEARCH_WENDA = "w";      //问答
        public static final String SEARCH_SHAPE ="s";       //分享
    }

    public class Moyu{
        public static final String MOYU_NAME = "moyu_name";   //分类名字
        public static final String MOYU_ID = "moyu_id";   //分类id
    }

    public class Wenda{
        public static final String WENDA_TYPE = "wenda_type";   //类型

        public static final String WENDA_LASTEST = "lastest";   //新推荐

        public static final String WENDA_HOT = "hot";           //热门推荐

    }

    public class Ucenter{

        public static final String PAGE_TYPE = "page_type";

        //收藏集
        public static final int PAGE_COLLOCATION = 1;

        //关注列表
        public static final int PAGE_FOLLOW = 2;

        //粉丝列表
        public static final int PAGE_FANS = 3;

        //富豪榜
        public static final int PAGE_RANKING = 5;

        //消息-问答
        public static final int PAGE_MSG_WENDA = 7;

        //消息-文章
        public static final int PAGE_MSG_ARTICLE = 8;

        //消息-动态
        public static final int PAGE_MSG_DYNAMIC = 9;

        //消息-给朕点赞
        public static final int PAGE_MSG_STAR = 10;

        //消息-@我
        public static final int PAGE_MSG_AT =11;
        //消息-系统消息
        public static final int PAGE_MSG_SYSTEM =12;
    }

    public  class MultiItemType{
        //标题
        public static final int TYPE_TITLE = 1;

        //内容
        public static final int TYPE_CONTENT = 2;

        //评论
        public static final int TYPE_COMMENT = 3;

        //评论的评论
        public static final int TYPE_SUB_COMMENT = 4;

        //推荐
        public static final int TYPE_RECOMMEND = 5;
    }


}
