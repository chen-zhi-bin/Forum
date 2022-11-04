package com.program.module_ucenter.callback;

import com.program.module_ucenter.model.domain.FollowListBean;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IUserFollowFragmentCallback extends IBaseCallback {

    void setFollowList(FollowListBean data);

    void setMoreFollowList(FollowListBean data);

    void setFansList(FollowListBean data);

    void setMoreFansList(FollowListBean data);

    void onMsgError(String error);

    LifecycleTransformer<Object> getBindLifecycle();
}
