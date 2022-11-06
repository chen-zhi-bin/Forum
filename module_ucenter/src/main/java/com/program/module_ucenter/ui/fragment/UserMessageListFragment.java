package com.program.module_ucenter.ui.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.lib_common.service.home.wrap.HomeServiceWrap;
import com.program.lib_common.service.moyu.wrap.MoyuServiceWrap;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.lib_common.service.wenda.wrap.WendaServiceWrap;
import com.program.module_ucenter.R;
import com.program.module_ucenter.adapter.MsgListAdapter;
import com.program.module_ucenter.callback.IMsgListCallback;
import com.program.module_ucenter.model.domain.MsgArticleBean;
import com.program.module_ucenter.model.domain.MsgAtBean;
import com.program.module_ucenter.model.domain.MsgBean;
import com.program.module_ucenter.model.domain.MsgMomentBean;
import com.program.module_ucenter.model.domain.MsgThumbBean;
import com.program.module_ucenter.model.domain.MsgWendaBean;
import com.program.module_ucenter.presenter.IMsgListPresenter;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle4.LifecycleTransformer;

import java.util.ArrayList;
import java.util.List;

public class UserMessageListFragment extends BaseFragment implements IMsgListCallback {

    private int pageType = 0;
    private RecyclerView mRvList;
    private SmartRefreshLayout mRefreshLayout;
    private MsgListAdapter mAdapter;
    private IMsgListPresenter mMsgListPresenter;
    private List<MsgBean> mMsgAtList = new ArrayList<>();

    @Override
    protected int getRootViewResId() {
        return R.layout.moduleucenter_fragment_ucenter_list;
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        setupState(State.SUCCESS);
        pageType = requireArguments().getInt("pageType");
        mRvList = rootView.findViewById(R.id.rv_list);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);
        mAdapter = new MsgListAdapter(R.layout.moduleucenter_adapter_msg_list, mMsgAtList);
        mRvList.setLayoutManager(new LinearLayoutManager(BaseApplication.getAppContext()));
        mRvList.setAdapter(mAdapter);

    }

    @Override
    protected void initListener() {
        super.initListener();
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                switch (pageType) {
                    case Constants.Ucenter.PAGE_MSG_AT:
                        mMsgListPresenter.getMsgListAt();
                        break;
                    case Constants.Ucenter.PAGE_MSG_STAR:
                        mMsgListPresenter.getMsgThumbList();
                        break;
                    case Constants.Ucenter.PAGE_MSG_DYNAMIC:
                        mMsgListPresenter.getMsgMomentList();
                        break;
                    case Constants.Ucenter.PAGE_MSG_ARTICLE:
                        mMsgListPresenter.getMsgArticleList();
                        break;
                    case Constants.Ucenter.PAGE_MSG_WENDA:
                        mMsgListPresenter.getMsgWendaList();
                        break;
                }
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                switch (pageType) {
                    case Constants.Ucenter.PAGE_MSG_AT:
                        mMsgListPresenter.getMoreMsgListAt();
                        break;
                    case Constants.Ucenter.PAGE_MSG_STAR:
                        mMsgListPresenter.getMoreMsgThumbList();
                        break;
                    case Constants.Ucenter.PAGE_MSG_DYNAMIC:
                        mMsgListPresenter.getMoreMsgMomentList();
                        break;
                    case Constants.Ucenter.PAGE_MSG_ARTICLE:
                        mMsgListPresenter.getMoreMsgArticleList();
                        break;
                    case Constants.Ucenter.PAGE_MSG_WENDA:
                        mMsgListPresenter.getMoreMsgWendaList();
                        break;
                }
            }
        });

        mAdapter.addChildClickViewIds(R.id.iv_avatar);
        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                int id = view.getId();
                Object item = adapter.getItem(position);
                if (id == R.id.iv_avatar || id == R.id.et_nickname) {
                    String uId;
                    if (item instanceof MsgAtBean.DataBean.ContentBean) {
                        uId = ((MsgAtBean.DataBean.ContentBean) item).getUid();
                        UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(uId);
                    } else if (item instanceof MsgThumbBean.DataBean.ContentBean) {
                        UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(((MsgThumbBean.DataBean.ContentBean) item).getUid());
                    } else if (item instanceof MsgMomentBean.DataBean.ContentBean) {
                        UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(((MsgMomentBean.DataBean.ContentBean) item).getUid());
                    } else if (item instanceof MsgArticleBean.DataBean.ContentBean) {
                        UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(((MsgArticleBean.DataBean.ContentBean) item).getUid());
                    } else if (item instanceof MsgWendaBean.DataBean.ContentBean) {
                        UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(((MsgWendaBean.DataBean.ContentBean) item).getUid());
                    }
                } else if (id == R.id.tv_reply_value) {
                    toDetail(item);
                }
            }
        });
    }

    private void toDetail(Object item) {
        if (item instanceof MsgAtBean.DataBean.ContentBean) {
            MsgAtBean.DataBean.ContentBean itemAt = (MsgAtBean.DataBean.ContentBean) item;
            String type = itemAt.getType();
            switch (type) {
                case "moment":
                    MoyuServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(itemAt.getExId());
                    break;
                case "article":
                    HomeServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(itemAt.getExId(), "");
                    break;
                case "wenda":
                    WendaServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(itemAt.getExId());
                    break;
            }
        } else if (item instanceof MsgThumbBean.DataBean.ContentBean) {
            String[] split = ((MsgThumbBean.DataBean.ContentBean) item).getUrl().split("/");
            String[] split1 = split[2].split("#");
            if (split[1].equals("m") && split.length == 3) {
                MoyuServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(split[2]);
            } else if (split[1].equals("qa") && split.length == 3&&split1.length==1){
                WendaServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(split[2]);
            }
        }else if (item instanceof MsgMomentBean.DataBean.ContentBean){
            MoyuServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(((MsgMomentBean.DataBean.ContentBean)item).getMomentId());
        }else if (item instanceof MsgArticleBean.DataBean.ContentBean){
            HomeServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(((MsgArticleBean.DataBean.ContentBean)item).getArticleId(),((MsgArticleBean.DataBean.ContentBean)item).getTitle());
        }else if (item instanceof MsgWendaBean.DataBean.ContentBean){
            WendaServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(((MsgWendaBean.DataBean.ContentBean)item).getWendaId());
        }
    }

    @Override
    protected void initPresenter() {
        mMsgListPresenter = PresenterManager.getInstance().getMsgListPresenter();
        mMsgListPresenter.registerViewCallback(this);
        switch (pageType) {
            case Constants.Ucenter.PAGE_MSG_AT:
                mMsgListPresenter.getMsgListAt();
                break;
            case Constants.Ucenter.PAGE_MSG_STAR:
                mMsgListPresenter.getMsgThumbList();
                break;
            case Constants.Ucenter.PAGE_MSG_DYNAMIC:
                mMsgListPresenter.getMsgMomentList();
                break;
            case Constants.Ucenter.PAGE_MSG_ARTICLE:
                mMsgListPresenter.getMsgArticleList();
                break;
            case Constants.Ucenter.PAGE_MSG_WENDA:
                mMsgListPresenter.getMsgWendaList();
                break;
        }
    }

    @Override
    public void setMsgAtList(MsgAtBean data) {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        }
        mMsgAtList.clear();
        mMsgAtList.addAll(data.getData().getContent());
        mAdapter.addData(mMsgAtList);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void setMoreMsgAtList(MsgAtBean data) {
        List<MsgBean> msgBeanList = new ArrayList<>();
        msgBeanList.addAll(data.getData().getContent());
        mAdapter.addData(msgBeanList);
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        }
    }

    @Override
    public void setNotMore(String msg) {
        ToastUtils.showToast(msg);
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
    }

    private void finishRefresh() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        }
    }

    private void finishLoadMore() {
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public void setMsgThumbList(MsgThumbBean data) {
        finishRefresh();
        List<MsgThumbBean.DataBean.ContentBean> content = data.getData().getContent();
        if (content.size() == 0 || content == null) {
            setupState(State.EMPTY);
//            ToastUtils.showToast(data.getMessage());
            return;
        }
        mAdapter.getData().clear();
        mAdapter.addData(content);
    }

    @Override
    public void setMoreMsgThumbList(MsgThumbBean data) {
        finishLoadMore();
        List<MsgThumbBean.DataBean.ContentBean> content = data.getData().getContent();
        if (content.size() == 0 || content == null) {
            ToastUtils.showToast("暂无更多");
            return;
        }
        mAdapter.addData(content);
    }

    @Override
    public void setMsgMomentList(MsgMomentBean data) {
        finishRefresh();
        List<MsgMomentBean.DataBean.ContentBean> content = data.getData().getContent();
        LogUtils.d("test", "content dat = " + content.toString());
        if (content.size() == 0 || content == null) {
            setupState(State.EMPTY);
//            ToastUtils.showToast(data.getMessage());
            return;
        }
        mAdapter.getData().clear();
        mAdapter.addData(content);
    }

    @Override
    public void setMoreMsgMomentList(MsgMomentBean data) {
        finishLoadMore();
        List<MsgMomentBean.DataBean.ContentBean> content = data.getData().getContent();
        if (content.size() == 0 || content == null) {
            ToastUtils.showToast("暂无更多");
            return;
        }
        mAdapter.addData(content);
    }

    @Override
    public void setMsgArticleList(MsgArticleBean data) {
        finishRefresh();
        List<MsgArticleBean.DataBean.ContentBean> content = data.getData().getContent();
        if (content.size() == 0 || content == null) {
            setupState(State.EMPTY);
//            ToastUtils.showToast(data.getMessage());
            return;
        }
        mAdapter.getData().clear();
        mAdapter.addData(content);
    }

    @Override
    public void setMoreMsgArticleList(MsgArticleBean data) {
        finishLoadMore();
        List<MsgArticleBean.DataBean.ContentBean> content = data.getData().getContent();
        if (content.size() == 0 || content == null) {
            ToastUtils.showToast("暂无更多");
            return;
        }
        mAdapter.addData(content);
    }

    @Override
    public void setMsgWendaList(MsgWendaBean data) {
        finishRefresh();
        List<MsgWendaBean.DataBean.ContentBean> content = data.getData().getContent();
        if (content.size() == 0 || content == null) {
            setupState(State.EMPTY);
//            ToastUtils.showToast(data.getMessage());
            return;
        }
        mAdapter.getData().clear();
        mAdapter.addData(content);
    }

    @Override
    public void setMoreMsgWendaList(MsgWendaBean data) {
        LogUtils.d("test", "data = " + data.toString());
        finishLoadMore();
        List<MsgWendaBean.DataBean.ContentBean> content = data.getData().getContent();
        if (content.size() == 0 || content == null) {
            ToastUtils.showToast("暂无更多");
            return;
        }
        mAdapter.addData(content);
    }

    @Override
    public LifecycleTransformer<Object> getBindLifecycle() {
        return null;
    }

    @Override
    public void setError(String s) {
        ToastUtils.showToast(s);
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        }
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

    public interface onMessageListListener {
        LifecycleTransformer<Object> getBindLifecycle();
    }
}
