package com.program.module_moyu.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.hjq.bar.TitleBar;
import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.module_moyu.R;
import com.program.module_moyu.adapter.FishPoneSelectAdapter;
import com.program.module_moyu.callback.IFishPoneSelectionActivityCallback;
import com.program.module_moyu.model.bean.TopicIndexReturnBean;
import com.program.module_moyu.presenter.IFishPoneSelectionActivityPresenter;
import com.program.module_moyu.utils.PresenterManager;
import com.program.moudle_base.base.BaseActivity;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class FishPoneSelectionActivity extends BaseActivity implements IFishPoneSelectionActivityCallback {


    private SmartRefreshLayout mRefreshLayout;
    private TitleBar mTitleBar;
    private RecyclerView mRvFishPoneList;
    private IFishPoneSelectionActivityPresenter mFishPoneSelectionActivityPresenter;
    private FishPoneSelectAdapter mAdapter;

    @Override
    protected void initPresenter() {
        mFishPoneSelectionActivityPresenter = PresenterManager.getInstance().getFishPoneSelectionActivityPresenter();
        mFishPoneSelectionActivityPresenter.registerViewCallback(this);
        mFishPoneSelectionActivityPresenter.getFishPone();
    }

    @Override
    protected void initEvent() {


    }

    @Override
    protected void initView() {
        mTitleBar = this.findViewById(R.id.title_bar);
        mRefreshLayout = this.findViewById(R.id.refresh_layout);
        mRvFishPoneList = this.findViewById(R.id.rv_fish_pond_labels_list);
        mRvFishPoneList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FishPoneSelectAdapter();
        mRvFishPoneList.setAdapter(mAdapter);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.modulemoyu_activity_fish_pone_selection;
    }

    @Override
    public void setFishPone(TopicIndexReturnBean data) {
        if (data.getSuccess()) {
            mAdapter.addData(data.getData());
        }else {
            ToastUtils.showToast(data.getMessage());
        }
    }

    @Override
    public LifecycleTransformer<Object> TobindToLifecycle() {
        BehaviorSubject<Object> objectBehaviorSubject = BehaviorSubject.create();
        return  RxLifecycle.bind(objectBehaviorSubject);
    }

    @Override
    public void setRequestError(String msg) {
        ToastUtils.showToast(msg);
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