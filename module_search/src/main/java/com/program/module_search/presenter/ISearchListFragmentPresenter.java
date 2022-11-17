package com.program.module_search.presenter;

import com.program.module_search.callback.ISearchListFragmentCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface ISearchListFragmentPresenter extends IBasePresenter<ISearchListFragmentCallback> {

    void getSearchList(String keyword,String type);

}
