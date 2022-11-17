package com.program.module_search.model;

import com.program.module_search.model.bean.SearchListBean;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchApi {

    @GET("/ct/search")
    Observable<SearchListBean> search(
            @Query("keyword")String keyword,
            @Query("type")String type,
            @Query("page")int page,
            @Query("sort")Integer sort
    );
}
