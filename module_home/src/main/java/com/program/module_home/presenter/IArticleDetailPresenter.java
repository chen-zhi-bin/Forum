package com.program.module_home.presenter;

import com.program.module_home.callback.IArticleDetailCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IArticleDetailPresenter extends IBasePresenter<IArticleDetailCallback> {

    void getArticleDetail(String articleId);

    void getPriseQrCode(String userId);

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
