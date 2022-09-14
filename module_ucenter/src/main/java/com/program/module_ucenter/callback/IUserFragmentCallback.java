package com.program.module_ucenter.callback;

import androidx.lifecycle.Lifecycle;

import com.program.module_ucenter.model.domain.AchievementBean;
import com.program.module_ucenter.model.domain.UserMessageBean;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle3.LifecycleProvider;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IUserFragmentCallback extends IBaseCallback {

    void setAvatar(String path);

    void setMsg(UserMessageBean data);

    void setUserAchievement(AchievementBean data);

    void onErrorMessage(String message);

    /**
     * 暂时无用 ， 起初的计划是绑定rxjava的生命周期使用
     * @return
     */
    LifecycleProvider<Lifecycle.Event> getBindToLifecycle();


}
