package com.program.module_home.callback;

import com.program.module_home.model.bean.ArticleDetailBean;
import com.program.module_home.model.bean.BannerBean;
import com.program.module_home.model.bean.HomeItemBean;
import com.program.moudle_base.base.IBaseCallback;
import com.trello.rxlifecycle4.LifecycleTransformer;

public interface IHomeListFragmentCallback extends IBaseCallback {

    void setBanner(BannerBean data);

    void setHomeItem(HomeItemBean data);

    void setHomeItemMore(HomeItemBean data);

    void setArticleUpdateInfo(ArticleDetailBean data);

    void setRequestError(String msg);

    LifecycleTransformer<Object> TobindToLifecycle();

}
