package com.program.module_wenda.presenter;

import android.widget.Button;

import com.program.module_wenda.callback.IWendaRankingFragmentCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IWendaRankingFragmentPresenter extends IBasePresenter<IWendaRankingFragmentCallback> {

    void getRankingList();

    /**
     * 得到与目标用户之间的关系
     * @param userId    id
     *                       * @param path    0为header,其他就是其他位置
     */
    void getUserFollowState(String userId,int path);

    /**
     * 添加关注
     * @param userId    id
     */
    void addFollow(String userId,int path);

    /**
     * 取消关注
     * @param userId    id
     */
    void unFollow(String userId);

}
