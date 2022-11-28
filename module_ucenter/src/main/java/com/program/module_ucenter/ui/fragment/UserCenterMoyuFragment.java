package com.program.module_ucenter.ui.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.program.lib_base.LogUtils;
import com.program.lib_common.event.UpdateItemEvent;
import com.program.lib_common.service.moyu.wrap.MoyuServiceWrap;
import com.program.module_ucenter.R;
import com.program.module_ucenter.callback.IMoyuCallback;
import com.program.module_ucenter.presenter.IMoyuPresentere;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.adapter.MoyuAdapter;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.model.MoyuItemBean;
import com.program.moudle_base.model.MoyuRequestBean;
import com.program.moudle_base.utils.EventBusUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle3.LifecycleProvider;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class UserCenterMoyuFragment extends BaseFragment implements IMoyuCallback{

    private RecyclerView mRvList;
    private String mUserId;
    private IMoyuPresentere mMoyuPreseenter;
    private MoyuAdapter mMoyuAdapter;
    private SmartRefreshLayout mRefreshLayout;

    @Override
    protected int getRootViewResId() {
        return R.layout.moduleucenter_fragment_ucenter_list;
    }

    @Subscribe
    @Override
    public void onDestroy() {
        if (EventBusUtils.INSTANCE.isRegistered(this)){
            EventBusUtils.INSTANCE.unRegister(this);
        }
        super.onDestroy();
    }

    @Override
    public void initView(View rootView) {
        setupState(State.LOADING);

        if (!EventBusUtils.INSTANCE.isRegistered(this)) {
            EventBusUtils.INSTANCE.register(this);
        }

        mUserId = requireArguments().getString("userId");

//        mUserId = "1153952789488054272";
//        mUserId = "1382711465131241472";
        mRvList = rootView.findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(BaseApplication.getAppContext()));
        mMoyuAdapter = new MoyuAdapter(1);
//        mMoyuAdapter.setOnItemChildClickListener();
        mRvList.setAdapter(mMoyuAdapter);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mMoyuPreseenter.getMoyuList(mUserId);
            }
        });
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mMoyuPreseenter.getMoyuListMore();
        });

        mMoyuAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                if (adapter.getItem(position) instanceof MoyuItemBean){
                    MoyuServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(((MoyuItemBean)adapter.getItem(position)).getId());
                }
            }
        });
    }

    @Override
    protected void initPresenter() {

        mMoyuPreseenter = PresenterManager.getInstance().getMoyuPreseenter();
        mMoyuPreseenter.registerViewCallback(this);
        mMoyuPreseenter.getMoyuList(mUserId);

    }

    /**
     * 更新单个item
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventUpdateItem(UpdateItemEvent event){
        LogUtils.d("test","event = "+event.getEvent()+" id = "+event.getId());
        mMoyuPreseenter.getMoyuYpdateInfo(event.getId());
    }


    @Override
    public void setMoyuUpdate(MoyuRequestBean.DataBean data) {
        LogUtils.d(UserCenterMoyuFragment.class,"data = "+data.toString());
        if (data!=null){
            MoyuItemBean item =null;
            int index = -1;
            for (MoyuItemBean datum : mMoyuAdapter.getData()) {
                if (data.getId().equals(datum.getId())){
                    item = datum;
                    index = mMoyuAdapter.getData().indexOf(datum);
                    break;
                }
            }
            MoyuItemBean moyuItemBean = mMoyuAdapter.getData().get(index);
            moyuItemBean.setCommentCount(data.getCommentCount()!=null?data.getCommentCount():moyuItemBean.getCommentCount());
            moyuItemBean.setThumbUpCount(data.getThumbUpCount()!=null?data.getThumbUpCount():moyuItemBean.getThumbUpCount());
            moyuItemBean.setHasThumbUp(data.getHasThumbUp()!=null?data.getHasThumbUp():moyuItemBean.getHasThumbUp());
            mMoyuAdapter.notifyItemChanged(index);
        }
    }

    @Override
    public void setMoyuList(List<MoyuItemBean> data) {

//        mMoyuAdapter.addData(data);
        if (data.size()==0){
            onEmpty();
        }
        mMoyuAdapter.setNewInstance(data);
        if (mRefreshLayout.isRefreshing()){
            mRefreshLayout.finishRefresh();
        }
        setupState(State.SUCCESS);
    }

    //摸鱼更多返回
    @Override
    public void setMoyuListMore(List<MoyuItemBean> data) {
        mMoyuAdapter.addData(data);
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public void setErrorMsg(String msg) {
        onError();
        ToastUtils.showToast(msg);
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public LifecycleTransformer<Object> TobindToLifecycle() {
        BehaviorSubject<Object> objectBehaviorSubject = BehaviorSubject.create();
        return  RxLifecycle.bind(objectBehaviorSubject);
    }

    @Override
    protected void onRetryClick() {
        mMoyuPreseenter.getMoyuList(mUserId);
    }

    @Override
    protected void relese() {
        super.relese();
        mMoyuPreseenter.unregisterViewCallback(this);
    }

    @Override
    public void onError() {
        setupState(State.ERROR);
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {
        setupState(State.EMPTY);
    }


}
