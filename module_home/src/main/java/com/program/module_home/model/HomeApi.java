package com.program.module_home.model;

import com.program.module_home.model.bean.ArticleDetailBean;
import com.program.moudle_base.model.PriseQrCodeBean;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HomeApi {

    @GET("/ct/article/detail/{articleId}")
    Observable<ArticleDetailBean> geetArticleDetail(@Path("articleId")String articleId);

    /**
     * 得到打赏二维码
     */
    @GET("ast/prise-qr-code/{userId}")
    Observable<PriseQrCodeBean> getPriseQrCode(@Path("userId")String userId);
}
