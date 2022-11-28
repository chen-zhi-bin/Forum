package com.program.module_ucenter.callback;

import com.program.module_ucenter.model.domain.ArticleBean;
import com.program.module_ucenter.model.domain.ShareBean;
import com.program.module_ucenter.model.domain.UserWendaBean;
import com.program.moudle_base.base.IBaseCallback;

public interface IUserCenterArticleCallback extends IBaseCallback {

    String getType();

    void setArticleData(ArticleBean data);

    void setShareData(ShareBean data);

    void setWendaData(UserWendaBean data);

    void setArticleDataMore(ArticleBean data);

    void setShareDataMore(ShareBean data);

    void setWendaDataMore(UserWendaBean data);


    void ToastErrorMsg(String msg);
}
