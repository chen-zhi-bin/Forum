package com.program.module_wenda.presenter;

import com.program.module_wenda.callback.IWendaDetailCallback;
import com.program.module_wenda.model.bean.Answer;
import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.base.IBasePresenter;

public interface IWendaDetailPresenter extends IBasePresenter<IWendaDetailCallback> {
        void getWendaDetail(String wendaId);
        void getWendaAnswerList(String wendaId);
        void getRelatedQuestion(String wendaId);
        void sendComment(Answer answer);
        void isWendaThumbClick(String wendaId);
        void toWendaThumb(String wendaId);              //点赞
//        void isThumb(String wendaId);
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
