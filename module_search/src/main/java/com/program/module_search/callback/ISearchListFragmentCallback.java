package com.program.module_search.callback;

import com.program.module_search.model.bean.SearchListBean;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface ISearchListFragmentCallback extends IBaseCallback {

    String getType();

    void setSearchResults(SearchListBean data);

    void setSearchMoreResults(SearchListBean data);

    void serErrorMsg(String msg);

    LifecycleTransformer<Object> TobindToLifecycle();
}
