package com.program.module_moyu.callback;

import com.program.module_moyu.model.bean.MomentCommentBean;
import com.program.module_moyu.model.bean.MoyuRequestBean;
import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.model.BaseResponseBean;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IMoyuDetailCallback extends IBaseCallback {

    LifecycleTransformer<Object> TobindToLifecycle();

    void setMoyuDetailData(MoyuRequestBean moyuDetailData);

    void setRequestError(String msg);

    void setMoyuCommentData(MomentCommentBean momentCommentBean);

    void setMoyuCommentDataMore(MomentCommentBean momentCommentBean);

    void setMoyuUserFollowState(int i);

    void returnAddFollowData(BaseResponseBean data);

    void returnUnFollowData(BaseResponseBean data);

    void setThumb();

    void returnComment(BaseResponseBean data);

    void returnSubComment(BaseResponseBean data);
}
