package com.program.module_home.presenter;

import com.program.module_home.callback.IArticleDetailCallback;
import com.program.module_home.callback.IHomeMainFragmentCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IHomeMainFragmentPresenter extends IBasePresenter<IHomeMainFragmentCallback> {

    void getCategoryList();

}
