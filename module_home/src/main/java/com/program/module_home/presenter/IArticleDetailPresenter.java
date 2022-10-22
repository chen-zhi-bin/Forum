package com.program.module_home.presenter;

import com.program.module_home.callback.IArticleDetailCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IArticleDetailPresenter extends IBasePresenter<IArticleDetailCallback> {

    void getArticleDetail(String articleId);

    void getPriseQrCode(String userId);
}
