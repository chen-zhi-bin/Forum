package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.IUserCollectionListFragmentCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IUserCollectionListFragmentPresenter extends IBasePresenter<IUserCollectionListFragmentCallback> {

    void getCollectionList();

    void getMoreCollectionList();
}
