package com.program.lib_common;

public class Constants {
    public static final String BASE_URL="https://api.sunofbeaches.com";

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

    public class Ucenter{

        public static final String PAGE_TYPE = "page_type";

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
