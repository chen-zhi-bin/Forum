package com.program.module_ucenter.callback;

import com.program.module_ucenter.model.domain.RankingSobBean;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IUserRankingFragmentCallback extends IBaseCallback {

    void setRankingSob(RankingSobBean data);

    void onMsgError(String error);

    LifecycleTransformer<Object> getBindLifecycle();

}
