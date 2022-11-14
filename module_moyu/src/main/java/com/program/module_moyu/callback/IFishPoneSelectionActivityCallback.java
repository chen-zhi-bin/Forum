package com.program.module_moyu.callback;

import com.program.module_moyu.model.bean.TopicIndexReturnBean;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IFishPoneSelectionActivityCallback extends IBaseCallback {
    void setFishPone(TopicIndexReturnBean data);

    LifecycleTransformer<Object> TobindToLifecycle();

    void setRequestError(String msg);
}
