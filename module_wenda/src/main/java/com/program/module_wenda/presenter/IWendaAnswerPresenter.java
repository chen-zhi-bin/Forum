package com.program.module_wenda.presenter;

import com.program.module_wenda.callback.IWendaAnswerCallback;
import com.program.module_wenda.model.bean.WendaSubCommentInputBean;
import com.program.moudle_base.base.IBasePresenter;

public interface IWendaAnswerPresenter extends IBasePresenter<IWendaAnswerCallback> {

    void replyAnswer(WendaSubCommentInputBean data);


}
