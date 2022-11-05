package com.program.module_ucenter.callback;

import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.model.CollectionBean;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IUserCollectionListFragmentCallback extends IBaseCallback {

    void setCollectionList(CollectionBean data);

    void setMoreCollectionList(CollectionBean data);

    void onMsgError(String error);

    LifecycleTransformer<Object> getBindLifecycle();

}
