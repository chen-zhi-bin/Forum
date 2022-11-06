package com.program.module_ucenter.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import com.allen.library.SuperTextView;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_base.LogUtils;
import com.program.lib_common.UIUtils;
import com.program.lib_common.Constants;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_ucenter.R;

import com.program.module_ucenter.callback.IUserFragmentCallback;
import com.program.module_ucenter.model.domain.AchievementBean;
import com.program.module_ucenter.model.domain.UserMessageBean;
import com.program.module_ucenter.presenter.IUserFragmentPresenter;
import com.program.module_ucenter.ui.SettingActivity;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle3.LifecycleProvider;


public class UserFragment extends BaseFragment implements IUserFragmentCallback {


    private IUserFragmentPresenter mUserFragmentPresenter;
    private RoundedImageView mAvatarIv;
    private TextView mNameTv;
    private SuperTextView mTvStars;
    private SuperTextView mTvFollow;
    private SuperTextView mTvCollection;
    private SuperTextView mTvFans;
    private TextView mTvViewNum;
    private TextView mTvViewDx;
    private TextView mTvGetStarNum;
    private TextView mTvGetStarDx;
    private TextView mTvSobNum;
    private TextView mTvSobDx;
    private SmartRefreshLayout mRefreshLayout;
    private ImageView mIvSetting;

      static {
          //设置全局的Header构建器
          SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
              @Override
              public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                  layout.setPrimaryColorsId(R.color.transparent, R.color.colorPrimary);//全局设置主题颜色
                  return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
              }
          });
      }

    private TextView mTvNotifyNum;
    private ImageView mIvNotify;
    private AchievementBean data;
    private SuperTextView mTvRanking;

    @Override
    protected int getRootViewResId() {
        return R.layout.moduleucenter_fragment_user;

    }

    @Override
    protected void initView(View rootView) {
        setupState(State.SUCCESS);
        mAvatarIv = rootView.findViewById(R.id.iv_avatar);
        mNameTv = rootView.findViewById(R.id.et_nickname);
        mTvStars = rootView.findViewById(R.id.tv_stars);
        mTvFollow = rootView.findViewById(R.id.tv_follow);
        mTvCollection = rootView.findViewById(R.id.tv_collection);
        mTvFans = rootView.findViewById(R.id.tv_fans);
        mTvRanking = rootView.findViewById(R.id.tv_ranking);

        mTvViewNum = rootView.findViewById(R.id.tv_view_num);
        mTvViewDx = rootView.findViewById(R.id.tv_view_dx);

        mTvGetStarNum = rootView.findViewById(R.id.tv_get_star_num);
        mTvGetStarDx = rootView.findViewById(R.id.tv_get_star_dx);

        mTvSobNum = rootView.findViewById(R.id.tv_sob_num);
        mTvSobDx = rootView.findViewById(R.id.tv_sob_dx);

        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);

        mIvSetting = rootView.findViewById(R.id.iv_setting);

        mTvNotifyNum = rootView.findViewById(R.id.tv_notify_num);
        mIvNotify = rootView.findViewById(R.id.iv_notify);
    }

    @Override
    protected void initListener() {
        mRefreshLayout.setOnRefreshListener(refreshLayout -> getData());

        mIvSetting.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), SettingActivity.class);
            startActivityForResult(intent, Constants.NEED_RESULT);
        });

        mIvNotify.setOnClickListener(view -> UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchMassage());

        mAvatarIv.setOnClickListener(view -> {
            UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(data.getData().getUserId());
//                UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail("1382711465131241472");
        });
        mTvFollow.setOnClickListener(view ->
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchUcenterList(
                            Constants.Ucenter.PAGE_FOLLOW,data.getData().getUserId()
                    )
        );
        mTvFans.setOnClickListener(view -> {
            if (data != null) {
                UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchUcenterList(
                    Constants.Ucenter.PAGE_FANS,data.getData().getUserId()
                );
            }
        });
        mTvRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getData() != null) {
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchUcenterList(Constants.Ucenter.PAGE_RANKING,data.getData().getUserId());
                }
            }
        });
        mTvCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getData()!=null){
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchUcenterList(
                            Constants.Ucenter.PAGE_COLLOCATION,
                            data.getData().getUserId()
                    );
                }
            }
        });
    }

    @Override
    protected void initPresenter() {
        mUserFragmentPresenter = PresenterManager.getInstance().getUserFragmentPresenter();
        mUserFragmentPresenter.registerViewCallback(this);
        getData();
    }

    private void getData() {
        mUserFragmentPresenter.getAvatar();
        mUserFragmentPresenter.getUserMsg();
        mUserFragmentPresenter.getUserAchievement();
        mUserFragmentPresenter.getUnreadMsg();
        if (mRefreshLayout.isRefreshing()){
            mRefreshLayout.finishRefresh();
        }
    }

    @Override
    public void setAvatar(String path) {
        Glide.with(BaseApplication.getAppContext())
                .load(path)
                .placeholder(R.mipmap.ic_default_avatar)        //加载中显示的图片（加载成功前）
                .circleCrop()       //圆角
                .into(mAvatarIv);
//        mAvatarIv.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override
    public void setMsg(UserMessageBean data) {
        mNameTv.setText(data.getData().getNickname());
    }

    @Override
    public void setUserAchievement(AchievementBean data) {
        this.data=data;
        AchievementBean.DataBean achieve = data.getData();
        mTvStars.setCenterTopString(achieve.getThumbUpTotal().toString());
        mTvStars.setCenterTopTextIsBold(true);

        mTvFollow.setCenterTopString(achieve.getFollowCount().toString());
        mTvFollow.setCenterTopTextIsBold(true);

        mTvCollection.setCenterTopString(achieve.getFavorites().toString());
        mTvCollection.setCenterTopTextIsBold(true);

        mTvFans.setCenterTopString(achieve.getFansCount().toString());
        mTvFans.setCenterTopTextIsBold(true);


        mTvViewNum.setText(achieve.getAtotalView().toString());
        String dxView = "昨日新增" + achieve.getAtotalView().toString();
        mTvViewDx.setText(
                UIUtils.setTextViewContentStyle(
                        dxView,
                        new AbsoluteSizeSpan(UIUtils.dp2px(14f)),
                        new ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.colorPrimary)),
                        5,dxView.length()
                )
        );

        mTvGetStarNum.setText(achieve.getThumbUpTotal().toString());
        String thumbUpDx = "昨日新增" + achieve.getThumbUpDx().toString();
        mTvGetStarDx.setText(
                UIUtils.setTextViewContentStyle(
                        thumbUpDx,
                        new AbsoluteSizeSpan(UIUtils.dp2px(14f)),
                        new ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.colorPrimary)),
                        5,thumbUpDx.length()
                )
        );

        mTvSobNum.setText(achieve.getSob().toString());
        String sobDx = "昨日新增" + achieve.getSobDx().toString();
        mTvSobDx.setText(
                UIUtils.setTextViewContentStyle(
                        sobDx,
                        new AbsoluteSizeSpan(UIUtils.dp2px(14f)),
                        new ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.colorPrimary)),
                        5,sobDx.length()
                )
        );
    }

    @Override
    public void onErrorMessage(String message) {
        ToastUtils.showToast(message);
    }

    @Override
    public void setUnreadMsgCount(String num) {
        LogUtils.d("test","Unread ="+num);
        if (!num.equals("0")){
            mTvNotifyNum.setText(num);
            mTvNotifyNum.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public LifecycleProvider<Lifecycle.Event> getBindToLifecycle() {
        LifecycleProvider<Lifecycle.Event> lifecycleProvider = AndroidLifecycle.createLifecycleProvider((LifecycleOwner) this);
        return lifecycleProvider;
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
