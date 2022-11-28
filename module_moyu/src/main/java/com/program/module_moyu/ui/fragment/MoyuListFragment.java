package com.program.module_moyu.ui.fragment;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.program.lib_base.LogUtils;
import com.program.lib_common.event.UpdateItemEvent;
import com.program.lib_common.service.moyu.wrap.MoyuServiceWrap;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_moyu.R;
import com.program.module_moyu.callback.IMoyuListFragmentCallback;
import com.program.moudle_base.model.MoyuRequestBean;
import com.program.module_moyu.presenter.IMoyuListFragmentPresenter;
import com.program.module_moyu.utils.PresenterManager;
import com.program.moudle_base.adapter.MoyuAdapter;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.model.MoyuItemBean;
import com.program.moudle_base.utils.CommonViewUtils;
import com.program.moudle_base.utils.EventBusUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.program.moudle_base.widget.FloatActionButton;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class MoyuListFragment extends BaseFragment implements IMoyuListFragmentCallback {

    private String mTopicId;
    private IMoyuListFragmentPresenter mMoyuListPresenter;
    private MoyuAdapter mAdapter;
    private SmartRefreshLayout mRefreshLayout;

    @Override
    protected int getRootViewResId() {
        return R.layout.modulemoyu_fragment_list;
    }

    @Subscribe
    @Override
    public void initView(View rootView) {
        setupState(State.LOADING);
        if (!EventBusUtils.INSTANCE.isRegistered(this)){
            EventBusUtils.INSTANCE.register(this);
        }
        mTopicId = requireArguments().getString("topicId", "1");
        FloatActionButton floatActionButton = rootView.findViewById(R.id.iv_publish_content);
        if (mTopicId.equals("1")) {
            floatActionButton.setOnClickListener(view -> MoyuServiceWrap.Singletion.INSTANCE.getHolder().launchPutFish());
        }else {
            floatActionButton.setVisibility(View.GONE);
        }
        LogUtils.d(MoyuListFragment.class,"topicId = "+mTopicId);
        mAdapter = new MoyuAdapter(0);
        RecyclerView rvList = rootView.findViewById(R.id.rv_list);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvList.setAdapter(mAdapter);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);
    }

    @Override
    public void onDestroy() {
        if (EventBusUtils.INSTANCE.isRegistered(this)){
            EventBusUtils.INSTANCE.unRegister(this);
        }
        super.onDestroy();
    }

    @Override
    protected void initPresenter() {
        mMoyuListPresenter = PresenterManager.getInstance().getMoyuListPresenter();
        mMoyuListPresenter.registerViewCallback(this);
        if (mTopicId.equals("1")){
            mMoyuListPresenter.getRecommendList(mTopicId);
        }else if (mTopicId.equals("2")){
            mMoyuListPresenter.getFollowList(mTopicId);
        }else {
            mMoyuListPresenter.getList(mTopicId);
        }
    }

    @Override
    protected void initListener() {
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (mTopicId.equals("1")){
                    mMoyuListPresenter.getRecommendList(mTopicId);
                }else if (mTopicId.equals("2")){
                    mMoyuListPresenter.getFollowList(mTopicId);
                }else {
                    mMoyuListPresenter.getList(mTopicId);
                }
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (mTopicId.equals("1")){
                    mMoyuListPresenter.getRecommendListMore(mTopicId);
                }else if (mTopicId.equals("2")){
                    mMoyuListPresenter.getFollowListMore(mTopicId);
                }else {
                    mMoyuListPresenter.getListMore(mTopicId);
                }
            }
        });
        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                MoyuItemBean item = (MoyuItemBean) adapter.getItem(position);
                int id = view.getId();
                if (id==R.id.iv_avatar||id==R.id.et_nickname){
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(item.getUserId());
                }else if (id==R.id.tv_link){
                    if (item.getLinkUrl() != null) {
                        CommonViewUtils.toWebView(item.getLinkUrl());
                    }
                }
            }
        });
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Object item = adapter.getItem(position);
                if (item instanceof MoyuItemBean){
                    MoyuServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(((MoyuItemBean)item).getId());
                }
            }
        });
    }

    /**
     * 更新单个item
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventUpdateItem(UpdateItemEvent event){
        String event1 = event.getEvent();
        LogUtils.d("test","event = "+event1.toString());

        if (event1.equals(UpdateItemEvent.Event.UPDATE_MOYU)){
            updateItem(event.getId());
        }
    }

    private void updateItem(String id) {
        LogUtils.d(MoyuListFragment.class,"event ,moyuId = "+id);
        mMoyuListPresenter.getUpdateMoyuInfo(mTopicId,id);
    }

    @Override
    public String getKey() {
        return mTopicId;
    }

    @Override
    public void setMoyuUpdate(MoyuRequestBean.DataBean moyu) {
        LogUtils.d("test","moyu +++data = "+moyu.toString());
        if (moyu != null) {
//            int index = mAdapter.getData().indexOf(moyu);
//            MoyuItemBean item = mAdapter.getItem(index);
            MoyuItemBean item = null;
            int index=-1;
            for (MoyuItemBean datum : mAdapter.getData()) {
                if (moyu.getId().equals(datum.getId())){
                    LogUtils.d("test","================");
                    item = datum;
                    index=mAdapter.getData().indexOf(datum);
                    LogUtils.d("test","index = "+index);
                    break;
                }
            }
            if (index!=-1){

                MoyuItemBean moyuItemBean = mAdapter.getData().get(index);
                moyuItemBean.setCommentCount(moyu.getCommentCount());
                moyuItemBean.setThumbUpCount(moyu.getThumbUpCount());
                moyuItemBean.setHasThumbUp(moyu.getHasThumbUp());
                mAdapter.notifyItemChanged(index);
            }
//            mAdapter.notifyItemChanged(index);
        }
    }

    @Override
    public void setList(List<MoyuItemBean> data) {
        setupState(State.SUCCESS);
        finishRefresh();
        mAdapter.getData().clear();
        if (data != null) {
            mAdapter.addData(data);
        }
    }
    private void finishRefresh(){
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        }
    }

    private void finishLoadMore(){
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public void setListMore(List<MoyuItemBean> data) {
        LogUtils.d("test","data 123123= "+data.toString());
        finishLoadMore();
        mAdapter.addData(data);
    }

    @Override
    public void setErrorMsg(String msg) {
        onError();
        ToastUtils.showToast(msg);
    }

    @Override
    protected void onRetryClick() {
        if (mTopicId.equals("1")){
            mMoyuListPresenter.getRecommendList(mTopicId);
        }else if (mTopicId.equals("2")){
            mMoyuListPresenter.getFollowList(mTopicId);
        }else {
            mMoyuListPresenter.getList(mTopicId);
        }
    }

    @Override
    protected void relese() {
        super.relese();
        mMoyuListPresenter.unregisterViewCallback(this);
    }

    @Override
    public LifecycleTransformer<Object> TobindToLifecycle() {
        BehaviorSubject<Object> objectBehaviorSubject = BehaviorSubject.create();
        return  RxLifecycle.bind(objectBehaviorSubject);
    }

    @Override
    public void onError() {
        setupState(State.ERROR);
    }

    @Override
    public void onLoading() {
        setupState(State.LOADING);
    }

    @Override
    public void onEmpty() {
        setupState(State.EMPTY);
    }
}
