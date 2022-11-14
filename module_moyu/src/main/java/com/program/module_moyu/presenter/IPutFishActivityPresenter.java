package com.program.module_moyu.presenter;

import com.program.module_moyu.callback.IPutFishActivityCallback;
import com.program.module_moyu.model.bean.Moment;
import com.program.moudle_base.base.IBasePresenter;

import okhttp3.MultipartBody;

public interface IPutFishActivityPresenter extends IBasePresenter<IPutFishActivityCallback> {
    void postImage(MultipartBody.Part part);

    void postMoment(Moment moment);
}
