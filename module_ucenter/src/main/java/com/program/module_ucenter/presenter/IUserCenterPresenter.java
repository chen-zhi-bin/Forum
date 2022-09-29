package com.program.module_ucenter.presenter;

import com.program.module_ucenter.callback.IUserCenterCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IUserCenterPresenter extends IBasePresenter<IUserCenterCallback> {

    /**
     * 个人信息
     * @param userId    id
     */
    void getUserInfo(String userId);

    /**
     * 成就之类
     * @param userId    id
     */
    void getUserAchievement(String userId);

    /**
     * 得到与目标用户之间的关系
     * @param userId    id
     */
    void getUserFollowState(String userId);

    /**
     * 添加关注
     * @param userId    id
     */
    void addFollow(String userId);

    /**
     * 取消关注
     * @param userId    id
     */
    void unFollow(String userId);
}
