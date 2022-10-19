package com.program.module_wenda.presenter;

import com.program.module_wenda.callback.IWendaAnswerCallback;
import com.program.module_wenda.model.bean.WendaSubCommentInputBean;
import com.program.moudle_base.base.IBasePresenter;

public interface IWendaAnswerPresenter extends IBasePresenter<IWendaAnswerCallback> {

    void replyAnswer(WendaSubCommentInputBean data);

    void isThumbCheck(String commentId);

    void toWendaCommentThumb(String wendaCommentId);

    void toCommentPrise(String commentId,int value);

    void setBestAsAnswer(String wendaId,String wendaCommentId);

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
