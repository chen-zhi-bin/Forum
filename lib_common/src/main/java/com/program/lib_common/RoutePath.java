package com.program.lib_common;

public class RoutePath {
    public static final String PATH="path";

    public static class Login{
        public static final String PATH_lOGIN="/login/login";
    }

    public static class Home{
        public static final String SERVICE_HOME="/home/SERVICE_HOME";
    }

    public static class Moyu{
        public static final String SERVICE_MOYU="/moyu/moyu_service";
        public static final String PAGE_DETAIL="/moyu/MoyuDetailActivity";
        public static final String MOYU_ID="/moyu/moyu_id";

    }

    public static class Wenda{
        public static final String SERVICE_WENDA="/wenda/wenda_service";
        public static final String PAGE_DETAIL="/wenda/WendaDetailActivity";
        public static final String WENDA_ID="/wenda/wenda_id";

    }

    public static class Ucenter{
        public static final String PARAMS_USER_ID="userId";

        public static final String FRAGMENT_UCENTER="/ucenter/FRAGMENT_UCENTER";
        public static final String SERVICE_UCENTER="/ucenter/SERVICE_UCENTER";
        public static final String PAGE_MESSAGE="/ucenter/MsgCenterActivity";
        public static final String PAGE_MSG_LIST="/ucenter/MessageListActivity";
        public static final String PAGE_UCENTER="/ucenter/UserCenterActivity";
    }
}
