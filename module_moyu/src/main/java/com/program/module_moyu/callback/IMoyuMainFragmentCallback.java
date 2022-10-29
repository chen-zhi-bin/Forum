package com.program.module_moyu.callback;

import com.program.module_moyu.model.bean.TopicIndexBean;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle4.LifecycleTransformer;

import java.util.List;

public interface IMoyuMainFragmentCallback extends IBaseCallback {

    void setTopicIndex(List<TopicIndexBean> data);

    void setErrorMsg(String msg);

    LifecycleTransformer<Object> TobindToLifecycle();
}
