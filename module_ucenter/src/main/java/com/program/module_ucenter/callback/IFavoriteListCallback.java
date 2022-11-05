package com.program.module_ucenter.callback;

import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.model.FavoriteBean;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IFavoriteListCallback extends IBaseCallback {

    void setFavoriteList(FavoriteBean data);

    void setMoreFavoriteList(FavoriteBean data);

    void onMsgError(String error);

    LifecycleTransformer<Object> getBindLifecycle();
}
