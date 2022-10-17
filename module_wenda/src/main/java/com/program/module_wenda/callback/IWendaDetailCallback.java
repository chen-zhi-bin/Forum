package com.program.module_wenda.callback;

import com.program.module_wenda.model.bean.AnswerBean;
import com.program.module_wenda.model.bean.RelatedQuestionBean;
import com.program.module_wenda.model.bean.WendaBean;
import com.program.module_wenda.model.bean.WendaContentBean;
import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.model.FollowBean;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IWendaDetailCallback extends IBaseCallback {

    LifecycleTransformer<Object> TobindToLifecycle();

    void setRequestError(String msg);

    void setWendaDetail(WendaContentBean data);

    void setAnswerList(AnswerBean data);

    void setRelatedQuestionList(WendaBean data);

    void setSendCommentReturn(BaseResponseBean data);




    void setThumbState(BaseResponseBean data);

    void setFollowState(FollowBean data);

    void setFollowStateError(FollowBean data);

    void setAddFollowMsg(String msg);

    void setAddFollowMsgError(String message);

    void setUnFollowMsg(String msg);

    void setUnFollowMsgError(String msg);
}
