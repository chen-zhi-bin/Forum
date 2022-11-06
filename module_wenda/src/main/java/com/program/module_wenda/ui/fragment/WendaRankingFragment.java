package com.program.module_wenda.ui.fragment;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_base.LogUtils;
import com.program.lib_common.UIUtils;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_wenda.R;
import com.program.module_wenda.adapter.WendaRankingAdapter;
import com.program.module_wenda.callback.IWendaRankingFragmentCallback;
import com.program.module_wenda.model.bean.WendaRankingBean;
import com.program.module_wenda.presenter.IWendaRankingFragmentPresenter;
import com.program.module_wenda.utils.PresenterManager;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.model.AddOrUnFollowBean;
import com.program.moudle_base.model.FollowBean;
import com.program.moudle_base.utils.CommonViewUtils;
import com.program.moudle_base.utils.ViewUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import java.util.List;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class WendaRankingFragment extends BaseFragment implements IWendaRankingFragmentCallback {

    private int w60 = UIUtils.dp2px(60f);
    private int w40 = UIUtils.dp2px(40f);
    private int w5 = UIUtils.dp2px(5f);
    private WendaRankingAdapter mAdapter;
    private SmartRefreshLayout mRefreshLayout;
    private IWendaRankingFragmentPresenter mWendaRankingFragmentPresenter;
    private View mInflate;
    private LinearLayout mLinearlayout;
    private List<WendaRankingBean.DataBean> mList;

    @Override
    protected int getRootViewResId() {
        return R.layout.modulewenda_fragment_list;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.LOADING);
        super.initView(rootView);
        mAdapter = new WendaRankingAdapter();
        LayoutInflater from = LayoutInflater.from(getContext());
        mInflate = from.inflate(R.layout.modulewenda_fragment_ranking_header, null);
        mLinearlayout = mInflate.findViewById(R.id.linearlayout);
        mAdapter.addHeaderView(mInflate);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);
        mRefreshLayout.setEnableRefresh(false);
        RecyclerView rvList = rootView.findViewById(R.id.rv_list);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvList.setAdapter(mAdapter);
        rvList.setHasFixedSize(true);

    }

    @Override
    protected void initPresenter() {
        mWendaRankingFragmentPresenter = PresenterManager.getInstance().getWendaRankingFragmentPresenter();
        mWendaRankingFragmentPresenter.registerViewCallback(this);
        mWendaRankingFragmentPresenter.getRankingList();
    }

    private int indexGetFollow = -1;

    @Override
    protected void initListener() {
        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                WendaRankingBean.DataBean item = (WendaRankingBean.DataBean) adapter.getItem(position);
                if (view.getId() == R.id.tv_follow) {
                    if (indexGetFollow==-1){
                        follow(item.getUserId(),1);
                        indexGetFollow = position;
                    }else {
                        ToastUtils.showToast("网络繁忙，请稍后点击");
                    }
                }else if (view.getId() == R.id.iv_avatar){
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(item.getUserId());
                }
            }
        });
    }

    private TextView mLinearlayoutIndexAddFollow = null;

    @SuppressLint("SetTextI18n")
    private void initHeaderView(WendaRankingBean.DataBean dataBean, int num) {
        LayoutInflater from = LayoutInflater.from(getContext());
        View item = from.inflate(R.layout.modulewenda_ranking_header_item, null);
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        params.setMargins(w5, 0, w5, 0);
        item.setLayoutParams(params);

        RoundedImageView ivAvatar = item.findViewById(R.id.iv_avatar);
        ImageView ivRanking = item.findViewById(R.id.iv_ranking);
        if (num == 1) {
            ViewUtils.setViewWidth(ivAvatar, w40);
            ViewUtils.setViewHeight(ivAvatar, w60);
            item.setBackgroundResource(R.drawable.wenda_shape_gold_background);
            ivRanking.setImageResource(R.mipmap.ic_gold);
        } else {
            ViewUtils.setViewWidth(ivAvatar, w40);
            ViewUtils.setViewHeight(ivAvatar, w60);
            item.setBackgroundResource(num == 2 ? R.drawable.wenda_shape_silver_background : R.drawable.wenda_shape_copper_background);
            ivRanking.setImageResource(num == 2 ? R.mipmap.ic_silver : R.mipmap.ic_copper);
        }

        Glide.with(ivAvatar.getContext())
                .load(dataBean.getAvatar())
                .placeholder(R.mipmap.ic_default_avatar)
                .error(R.mipmap.ic_default_avatar)
                .circleCrop()
                .into(ivAvatar);
        ViewUtils.setViewWidth(item, (UIUtils.getScreenWidth() - w40) / 3);

        TextView tvNickname = item.findViewById(R.id.et_nickname);
        TextView tvCount = item.findViewById(R.id.tv_count);
        tvNickname.setText(dataBean.getNickname());
        tvCount.setText(dataBean.getCount() + " 个回答");
        item.setOnClickListener(view -> UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(dataBean.getUserId()));
        TextView tvFollow = item.findViewById(R.id.tv_follow);
        tvFollow.setTag("-1");
        LogUtils.d("test", "data  =  " + tvFollow.getTag());
        tvFollow.setOnClickListener(view -> {
            if (mLinearlayoutIndexAddFollow == null){
                follow(dataBean.getUserId(),0);
                mLinearlayoutIndexAddFollow = (TextView) view;
            }else {
                ToastUtils.showToast("网络繁忙，请稍后点击");
            }

        });
        mWendaRankingFragmentPresenter.getUserFollowState(dataBean.getUserId(), 0);
        mLinearlayout.addView(item);
    }

    private void follow(String userId,int path) {
        mWendaRankingFragmentPresenter.addFollow(userId,path);
    }

    private int mAdapterSize = -1;
    private int userlistIndex =-1;
    @Override
    public void setRankingList(WendaRankingBean data) {
        setupState(State.SUCCESS);
        mList = data.getData();
        if (mList != null) {
            if (mList.size() > 3) {
                initHeaderView(mList.get(1), 2);

                mAdapter.setNewData(mList.subList(3, mList.size()));
                mAdapterSize = mList.size();
                userlistIndex = 3;
                mWendaRankingFragmentPresenter.getUserFollowState(mList.get(userlistIndex).getUserId(), 1);

            } else {
                mAdapter.setNewData(mList);
            }
        }
    }

    @Override
    public void setErrorMsg(String msg) {
        onError();
        ToastUtils.showToast(msg);
    }

    @Override
    public LifecycleTransformer<Object> TobindToLifecycle() {
        BehaviorSubject<Object> objectBehaviorSubject = BehaviorSubject.create();
        return RxLifecycle.bind(objectBehaviorSubject);
    }

    private int headerViewIndex = 1;
    @Override
    public void setFollowStateHeader(FollowBean data) {
        int childCount = mLinearlayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            TextView childAt = mLinearlayout.getChildAt(i).findViewById(R.id.tv_follow);
            TextView child = mLinearlayout.getChildAt(i).findViewById(R.id.et_nickname);
            if (childAt.getTag().equals("-1")) {
                LogUtils.d("test", "tag =====" + childAt.getTag() + ">>data===" + data.getData()+"  = child"+child.getText().toString());
                CommonViewUtils.setFollowState(childAt, data.getData());
//                childAt.setTag(0);
                break;
            }/*else {
                childAt.setTag("-1");
            }*/
        }

        switch (headerViewIndex){
            case 1:
                initHeaderView(mList.get(0), 1);
                break;
            case 2:
                initHeaderView(mList.get(2), 3);
                break;
        }
       headerViewIndex++;

    }

    @Override
    public void setFollowState(FollowBean data) {
        if (userlistIndex - 3<mAdapter.getItemCount()){
            TextView view = (TextView) mAdapter.getViewByPosition(userlistIndex - 2, R.id.tv_follow);
            CommonViewUtils.setFollowState(view, data.getData());
            userlistIndex++;
            if (userlistIndex<mList.size()){
                mWendaRankingFragmentPresenter.getUserFollowState(mList.get(userlistIndex).getUserId(),1);
            }

        }
//        if (mAdapterSize > 3) {
//            for (int i = 1; i < mAdapterSize; i++) {//从1开始，以为0时Header
//                TextView view = (TextView) mAdapter.getViewByPosition(i, R.id.tv_follow);
//                if (view != null && view.getTag().equals("-1")) {
//                    CommonViewUtils.setFollowState(view, data.getData());
//                    view.setTag(data.getData());
//                }
//            }
//        }
    }

    @Override
    public void setFollowStateError(FollowBean data) {

    }

    @Override
    public void setAddFollowMsg(AddOrUnFollowBean data) {
        ToastUtils.showToast(data.getMessage());
        TextView view =(TextView) mAdapter.getViewByPosition(indexGetFollow+1, R.id.tv_follow);
        CommonViewUtils.setFollowState(view,2);
        indexGetFollow = -1;
    }

    @Override
    public void setAddFollowMsgHeader(AddOrUnFollowBean data) {
        ToastUtils.showToast(data.getMessage());
        CommonViewUtils.setFollowState(mLinearlayoutIndexAddFollow,2);
        mLinearlayoutIndexAddFollow = null;
    }

    @Override
    public void setAddFollowMsgError(String message) {
        ToastUtils.showToast(message);
    }

    @Override
    public void setUnFollowMsg(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void setUnFollowMsgError(String msg) {
        ToastUtils.showToast(msg);
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
