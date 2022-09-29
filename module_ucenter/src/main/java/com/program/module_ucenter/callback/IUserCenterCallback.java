package com.program.module_ucenter.callback;

import com.program.module_ucenter.model.domain.AchievementBean;
import com.program.module_ucenter.model.domain.FollowBean;
import com.program.module_ucenter.model.domain.UserInfoBean;
import com.program.moudle_base.base.IBaseCallback;

public interface IUserCenterCallback extends IBaseCallback {

    void initUserInfo(UserInfoBean data);

    void setAchievement(AchievementBean data);

    void returnError(String msg);

    void setFollowState(FollowBean data);

    void setFollowStateError(FollowBean data);

    void setAddFollowMsg(String msg);

    void setAddFollowMsgError(String message);

    void setUnFollowMsg(String msg);

    void setUnFollowMsgError(String msg);

}
