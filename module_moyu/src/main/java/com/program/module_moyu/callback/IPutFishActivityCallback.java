package com.program.module_moyu.callback;

import com.program.moudle_base.base.IBaseCallback;
import com.program.moudle_base.model.BaseResponseBean;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IPutFishActivityCallback extends IBaseCallback {

    void setPutFishReturn(BaseResponseBean data);

    void setImageReturn(BaseResponseBean data);

    LifecycleTransformer<Object> TobindToLifecycle();

    void setRequestError(String msg);
}
