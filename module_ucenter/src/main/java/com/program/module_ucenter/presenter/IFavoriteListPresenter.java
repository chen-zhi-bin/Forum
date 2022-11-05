package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.IFavoriteListCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IFavoriteListPresenter extends IBasePresenter<IFavoriteListCallback> {

    void getFavoriteList(String collectionId);

}
