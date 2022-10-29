package com.program.module_moyu.ui.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.program.lib_base.LogUtils;
import com.program.module_moyu.R;
import com.program.module_moyu.callback.IMoyuListFragmentCallback;
import com.program.module_moyu.model.bean.MoyuListBean;
import com.program.module_moyu.presenter.IMoyuListFragmentPresenter;
import com.program.module_moyu.utils.PresenterManager;
import com.program.moudle_base.adapter.MoyuAdapter;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.model.MoyuItemBean;
import com.program.moudle_base.utils.ToastUtils;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import java.util.List;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class MoyuListFragment extends BaseFragment implements IMoyuListFragmentCallback {

    private String mTopicId;
    private IMoyuListFragmentPresenter mMoyuListPresenter;
    private MoyuAdapter mAdapter;

    @Override
    protected int getRootViewResId() {
        return R.layout.modulemoyu_fragment_list;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.LOADING);
        mTopicId = requireArguments().getString("topicId", "1");
        LogUtils.d(MoyuListFragment.class,"topicId = "+mTopicId);
        mAdapter = new MoyuAdapter(0);
        RecyclerView rvList = rootView.findViewById(R.id.rv_list);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvList.setAdapter(mAdapter);

    }

    @Override
    protected void initPresenter() {
        mMoyuListPresenter = PresenterManager.getInstance().getMoyuListPresenter();
        mMoyuListPresenter.registerViewCallback(this);
        if (mTopicId.equals("1")){
            mMoyuListPresenter.getRecommendList();
        }else if (mTopicId.equals("2")){
            mMoyuListPresenter.getFollowList();
        }else {
            mMoyuListPresenter.getList(mTopicId);
        }
    }


    @Override
    public void setList(List<MoyuItemBean> data) {
        setupState(State.SUCCESS);
        if (data != null) {
            mAdapter.addData(data);
        }
    }

    @Override
    public void setErrorMsg(String msg) {
        setupState(State.SUCCESS);
        ToastUtils.showToast(msg);
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
