package com.program.module_wenda.callback;

import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.model.FollowBean;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IWendaAnswerCallback extends IBaseCallback {

    void replyAnswerReturn(BaseResponseBean data);

    LifecycleTransformer<Object> TobindToLifecycle();

    void setRequestError(String msg);

    void setPriseResult(BaseResponseBean data);

    /**
     * 是否点赞
     */
    void setReturnThumbClick(BaseResponseBean data);

    /**
     * 点赞返回
     */
    void setReturnClickThumb(BaseResponseBean data);

    void setFollowState(FollowBean data);

    void setFollowStateError(FollowBean data);

    void setAddFollowMsg(String msg);

    void setAddFollowMsgError(String message);

    void setUnFollowMsg(String msg);

    void setUnFollowMsgError(String msg);
}
