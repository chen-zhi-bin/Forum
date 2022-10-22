package com.program.module_home.callback;

import com.program.module_home.model.bean.ArticleDetailBean;
import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.model.FollowBean;
import com.program.moudle_base.model.PriseQrCodeBean;
import com.program.moudle_base.model.PriseSobBean;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IArticleDetailCallback extends IBaseCallback {
    void setArticleDetail(ArticleDetailBean.DataBean data);

    void setRequestError(String msg);

    void setPriseQrCode(PriseQrCodeBean data);

    LifecycleTransformer<Object> TobindToLifecycle();

    void setFollowState(FollowBean data);

    void setFollowStateError(FollowBean data);

    void setAddFollowMsg(String msg);

    void setAddFollowMsgError(String message);

    void setUnFollowMsg(String msg);

    void setUnFollowMsgError(String msg);
}