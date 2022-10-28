package com.program.module_home.callback;

import android.content.Context;

import com.program.module_home.model.bean.CategoryDB;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle4.LifecycleTransformer;

import java.util.List;

public interface IHomeMainFragmentCallback extends IBaseCallback {

    void setCategoryList(List<CategoryDB> data);

    LifecycleTransformer<Object> TobindToLifecycle();

    Context getContext();

    void setRequestError(String msg);

}
