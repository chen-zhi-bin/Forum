package com.program.module_moyu.presenter;

import com.program.module_moyu.callback.IMoyuDetailCallback;
import com.program.module_moyu.model.bean.MomentComment;
import com.program.module_moyu.model.bean.MomentSubComment;
import com.program.moudle_base.base.IBasePresenter;

public interface IMoyuDetailPresenter extends IBasePresenter<IMoyuDetailCallback> {

    /**
     * 得到动态详情
     * @param id    动态id
     */
    void getMoyuDetail(String id);


    void getMoyuComment(String id);

    void getMoyuCommentLoadMore(String  id);

    /**
     * 点赞
     * @param id    动态id
     */
    void getThumbUp(String id);

    void getFollowState(String uid);

    void addFollow(String uid);

    void unFollow(String uid);

    void toIssueComment(MomentComment momentComment);

    void toIssueSubComment(MomentSubComment momentSubComment);

}
