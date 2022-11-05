package com.program.module_ucenter.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.program.lib_base.LogUtils;
import com.program.lib_common.RoutePath;
import com.program.module_ucenter.R;
import com.program.module_ucenter.adapter.FavoriteAdapter;
import com.program.module_ucenter.callback.IFavoriteListCallback;
import com.program.module_ucenter.presenter.IFavoriteListPresenter;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.model.CollectionBean;
import com.program.moudle_base.model.FavoriteBean;
import com.program.moudle_base.utils.CommonViewUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

@Route(path = RoutePath.Ucenter.PAGE_FAVORITE_LIST)
public class FavoriteListActivity extends AppCompatActivity implements IFavoriteListCallback {

    @Autowired(name = "collection")
    public CollectionBean.DataBean.ContentBean mCollectionBean = null;
    private IFavoriteListPresenter mFavoriteListPresenter;
    private FavoriteAdapter mAdapter;
    private SmartRefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moduleucenter_activity_favorite_list);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        initView();
        initListener();
        initPresenter();
    }

    private void initPresenter() {
        mFavoriteListPresenter = PresenterManager.getInstance().getFavoriteListPresenter();
        mFavoriteListPresenter.registerViewCallback(this);
        mFavoriteListPresenter.getFavoriteList(mCollectionBean.getId());
    }

    private void initListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Object item = adapter.getItem(position);
                if (item instanceof FavoriteBean.DataBean.ContentBean) {
                    CommonViewUtils.toWebView(((FavoriteBean.DataBean.ContentBean) item).getUrl());
                }
            }
        });
    }

    private void initView() {
        RelativeLayout includerBar = this.findViewById(R.id.include_bar);
        mRefreshLayout = this.findViewById(R.id.refreshLayout);
        TextView tvTitle = includerBar.findViewById(R.id.tv_title);
        includerBar.findViewById(R.id.ivBack).setOnClickListener(view -> finish());
        if (mCollectionBean != null) {
            tvTitle.setText(mCollectionBean.getName());
            tvTitle.setGravity(Gravity.FILL);
        }

        mAdapter = new FavoriteAdapter();
        RecyclerView rvList = this.findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(mAdapter);

    }

    @Override
    public void setFavoriteList(FavoriteBean data) {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        }
        if (data.getData().getContent() != null) {
            mAdapter.getData().clear();
            mAdapter.addData(data.getData().getContent());
        }
        if (data.getData().getLast()){
            mRefreshLayout.setEnableLoadMore(false);
        }
    }

    @Override
    public void setMoreFavoriteList(FavoriteBean data) {
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
        if (data.getData().getContent() != null) {
            mAdapter.addData(data.getData().getContent());
        }
    }

    @Override
    public void onMsgError(String error) {
        ToastUtils.showToast(error);
    }

    @Override
    public LifecycleTransformer<Object> getBindLifecycle() {
        BehaviorSubject<Object> objectBehaviorSubject = BehaviorSubject.create();
        return  RxLifecycle.bind(objectBehaviorSubject);
    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }
}