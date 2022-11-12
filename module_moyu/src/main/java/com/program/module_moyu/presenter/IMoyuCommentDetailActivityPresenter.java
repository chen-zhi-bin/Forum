package com.program.module_moyu.presenter;

import com.program.module_moyu.callback.IMoyuCommentDetailActivityCallback;
import com.program.module_moyu.model.bean.MomentComment;
import com.program.module_moyu.model.bean.MomentSubComment;
import com.program.moudle_base.base.IBasePresenter;

public interface IMoyuCommentDetailActivityPresenter extends IBasePresenter<IMoyuCommentDetailActivityCallback> {

    /**
     * 评论子评论
     */
    void toIssueComment(MomentSubComment momentSubComment);

}
