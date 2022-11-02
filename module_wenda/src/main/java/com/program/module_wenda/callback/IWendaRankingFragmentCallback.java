package com.program.module_wenda.callback;

import com.program.module_wenda.model.bean.WendaRankingBean;
import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.model.AddOrUnFollowBean;
import com.program.moudle_base.model.FollowBean;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IWendaRankingFragmentCallback extends IBaseCallback {

    void setRankingList(WendaRankingBean data);

    void setErrorMsg(String msg);

    LifecycleTransformer<Object> TobindToLifecycle();

    void setFollowStateHeader(FollowBean data);

    void setFollowState(FollowBean data);

    void setFollowStateError(FollowBean data);

    void setAddFollowMsg(AddOrUnFollowBean msg);

    void setAddFollowMsgHeader(AddOrUnFollowBean msg);

    void setAddFollowMsgError(String message);

    void setUnFollowMsg(String msg);

    void setUnFollowMsgError(String msg);

}
