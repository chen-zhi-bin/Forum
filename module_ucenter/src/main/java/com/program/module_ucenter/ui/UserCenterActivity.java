 package com.program.module_ucenter.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.lib_common.RoutePath;
import com.program.lib_common.UIUtils;
import com.program.module_ucenter.R;
import com.program.module_ucenter.callback.IUserCenterCallback;
import com.program.module_ucenter.model.domain.AchievementBean;
import com.program.moudle_base.model.FollowBean;
import com.program.module_ucenter.model.domain.UserInfoBean;
import com.program.module_ucenter.presenter.IUserCenterPresenter;
import com.program.module_ucenter.ui.fragment.UserCenterArticleFragment;
import com.program.module_ucenter.ui.fragment.UserCenterMoyuFragment;
import com.program.module_ucenter.ui.view.MyCoordingnatorLayout;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.utils.CommonViewUtils;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;

import net.mikaelzero.mojito.Mojito;
import net.mikaelzero.mojito.loader.glide.GlideImageLoader;
import net.mikaelzero.mojito.view.sketch.SketchImageLoadFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

@Route(path = RoutePath.Ucenter.PAGE_UCENTER)
public class UserCenterActivity extends AppCompatActivity implements IUserCenterCallback {

    @Autowired(name = RoutePath.Ucenter.PARAMS_USER_ID)
    public String userId;
    private SharedPreferencesUtils mSharedPreferencesUtils;
    private List<String> mTitles = new ArrayList<>();
    private List mFragments = (List) (new ArrayList());
    private Button mBtnToolbarFollow;
    private Button mBtnFollow;
    private FragmentStateAdapter mAdapter;
    private ViewPager2 mVpContent;
    private Toolbar mToobar;
    private ConstraintLayout mToolbarLayout;
    private RoundedImageView mIvBigAvatar;
    private ImageView mIvTopBg;
    private MyCoordingnatorLayout mCoordintor;
    private TextView mTvBigNickName;
    private TextView mTvPosition;
    private ImageView mIvBack;
    private ImageView mIvMore;
    private TabLayout mTabLayout;
    private ArrayList<ImageView> mIvList;
    private ImageView mIvRewardCode;
    private IUserCenterPresenter mUserCenterPresenter;
    private RoundedImageView mIvToolbarAvatar;
    private TextView mTvTitle;
    private TextView mTvDesc;
    private TextView mTvAchievement;
    private boolean needFollowState = true;

    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.transparent, R.color.colorPrimary);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moduleucenter_activity_user_center);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        LogUtils.d("test", "userId = " + userId);
        userId = "1153952789488054272";
        Mojito.initialize(GlideImageLoader.Companion.with(this), new SketchImageLoadFactory());

        initView();
        initPreseenter();
    }

    private void initPreseenter() {
        mUserCenterPresenter = PresenterManager.getInstance().getUserCenterPresenter();
        mUserCenterPresenter.registerViewCallback(this);
//        mUserCenterPresenter.geetUserInfo(userId);
        mUserCenterPresenter.getUserInfo(userId);
        mUserCenterPresenter.getUserAchievement(userId);
        if (needFollowState){
            mUserCenterPresenter.getUserFollowState(userId);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initView() {
//        LogUtils.d("test","initView");
        mBtnToolbarFollow = findViewById(R.id.btn_toolbar_follow);
        mBtnToolbarFollow.setTag(-1);
        mBtnFollow = findViewById(R.id.btn_follow);
        mBtnFollow.setTag(-1);
        mVpContent = findViewById(R.id.vp_content);
        mToobar = this.findViewById(R.id.toolbar);
        mToolbarLayout = findViewById(R.id.toolbar_layout);
        mIvBigAvatar = findViewById(R.id.iv_big_avatar);
        mIvTopBg = findViewById(R.id.iv_top_bg);
        mCoordintor = findViewById(R.id.coordinator);
        mTvBigNickName = findViewById(R.id.tv_big_nickName);
        mTvPosition = findViewById(R.id.tv_position);
        mIvBack = findViewById(R.id.iv_back);
        mIvMore = findViewById(R.id.iv_more);
        mTabLayout = this.findViewById(R.id.tab_layout);
        mIvRewardCode = findViewById(R.id.iv_reward_code);
        mIvToolbarAvatar = findViewById(R.id.iv_toolbar_avatar);
        mTvTitle = findViewById(R.id.tv_title);
        mTvDesc = findViewById(R.id.tv_desc);
        mTvAchievement = findViewById(R.id.tv_achievement);

        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(this);
        String uId = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_ID);
        LogUtils.d("test", "===========================init uid =" + uId);

        if (userId.equals(uId)) {
            LogUtils.d("test", "===========================");
            mBtnToolbarFollow.setVisibility(View.GONE);
            mBtnFollow.setText("编辑");
            needFollowState = false;
        }
        mTitles.add("动态");
        mTitles.add("分享");
        mTitles.add("文章");
        mTitles.add("问答");
//        mFragments.add(new Fragment());
//        mFragments.add(new Fragment());
//        mFragments.add(new Fragment());
//        mFragments.add(new Fragment());

        mFragments.add(UserCenterMoyuFragment.class);
        mFragments.add(UserCenterArticleFragment.class);
        mFragments.add(UserCenterArticleFragment.class);
        mFragments.add(UserCenterArticleFragment.class);

        mAdapter = (FragmentStateAdapter) (new FragmentStateAdapter((FragmentActivity) this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                Fragment fragment;
                try {
                    Object o = ((Class) mFragments.get(position)).newInstance();
                    if (o != null) {
                        fragment = (Fragment) o;
                        Bundle bundle = new Bundle();
                        bundle.putString("userId", userId);
                        switch (position) {
                            case 2:
                                bundle.putString(Constants.DATA_TYPE, Constants.DATA_TPTE_ARTICLE);
                                break;
                            case 1:
                                bundle.putString(Constants.DATA_TYPE, Constants.DATA_TPTE_SHARA);
                                break;
                            case 3:
                                bundle.putString(Constants.DATA_TYPE, Constants.DATA_TPTE_WENDA);
                                break;
                        }
                        fragment.setArguments(bundle);
                    } else {
                        fragment = new Fragment();
                    }
                    return fragment;
                } catch (Exception e) {
                    e.printStackTrace();
                    fragment = new Fragment();
                    return fragment;
                }
            }

            @Override
            public int getItemCount() {
                return mFragments.size();
            }
        });

        mVpContent.setAdapter(mAdapter);
        new TabLayoutMediator(mTabLayout, mVpContent, (tab, position) -> tab.setText(mTitles.get(position))).attach();

        initScroll();

        initListener();

    }

    private void initListener() {
        mIvBack.setOnClickListener(view -> finish());
        mIvMore.setOnClickListener(view -> ToastUtils.showToast("更多"));
        mIvRewardCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showToast("打赏码");
            }
        });
        mBtnToolbarFollow.setOnClickListener(view -> {
            if (view.getTag().equals(0) || view.getTag().equals(1)) {
                follow(userId);
            } else {
                unfollow(userId);
            }
        });

        mBtnFollow.setOnClickListener(view -> {
            if (view.getTag().equals(0) || view.getTag().equals(1)) {
                follow(userId);
            } else {
                unfollow(userId);
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initScroll() {
        mIvList = new ArrayList<>();
        mIvList.add(mIvBack);
        mIvList.add(mIvMore);
        mToobar.setBackgroundColor(0);
        mToolbarLayout.setAlpha(0);
        int color = ContextCompat.getColor(this, R.color.white);
        mIvBigAvatar.post(new Runnable() {
            @Override
            public void run() {
                mCoordintor.setOnScrollListListener(scrollY -> {
                    int h = mIvTopBg.getHeight();
//                        LogUtils.d("test","scrollY = "+scrollY);
                    // 设置标题栏的这一行的 alpha由 0-> 1
                    mToolbarLayout.setAlpha(1f * Math.abs(scrollY) / h);

                    // 设置大头像这一行的 alpha由 1-> 0
                    float alpha = 1f * (mToobar.getHeight() - abs(scrollY)) / mToobar.getHeight();
                    mIvBigAvatar.setAlpha(alpha);
                    mBtnFollow.setAlpha(alpha);
                    mTvBigNickName.setAlpha(alpha);
                    mTvPosition.setAlpha(alpha);
                    int min = Math.min(abs(scrollY), h);
//                        LogUtils.d("test","h =="+h);
                    mToobar.setAlpha(1f * Math.abs(scrollY) / h);
                    mToobar.setBackgroundColor((255 * min / h << 24) | color);
//                        LogUtils.d("test","onScroll   alpha  =="+alpha+",color =="+((255*min/h << 24) | color));
                    // 滚到到一定值后 改变标题栏的图标的颜色
                    if (Math.abs(scrollY) < mToobar.getHeight()) {
                        setIconStyle(true);
                    } else {
                        setIconStyle(false);
                    }
                });
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setIconStyle(boolean b) {
        int color;
        if (b) {
            color = R.color.colorAccent;
        } else {
            color = R.color.icon_color;
        }
        mIvList.forEach(view -> view.setImageDrawable(
                UIUtils.tintDrawable(
                        view.getDrawable(),
                        ColorStateList.valueOf(
                                ContextCompat.getColor(
                                        UserCenterActivity.this, color
                                )
                        )
                )

        ));
    }

    /**
     * 关注
     *
     * @param userId id
     */
    private void follow(String userId) {
        mUserCenterPresenter.addFollow(userId);
    }

    /**
     * 取消关注
     *
     * @param userId id
     */
    private void unfollow(String userId) {
        mUserCenterPresenter.unFollow(userId);
    }

    @Override
    public void initUserInfo(UserInfoBean data) {
        UserInfoBean.DataBean user = data.getData();
        Glide.with(this).load(user.getAvatar()).circleCrop().into(mIvBigAvatar);
        mIvBigAvatar.setOnClickListener(view -> CommonViewUtils.showBigImage(mIvBigAvatar, user.getAvatar()));
        Glide.with(this).load(user.getAvatar()).circleCrop().into(mIvToolbarAvatar);
        String position = TextUtils.isEmpty(user.getPosition()) ? "" : user.getPosition();
        position = TextUtils.isEmpty(user.getCompany()) ? position : position + '@' + user.getCompany();
        mTvPosition.setText(position);
        mTvTitle.setText(user.getNickname());
        mTvBigNickName.setText(user.getNickname());
        if (TextUtils.isEmpty(user.getSign())) {
            mTvDesc.setVisibility(View.GONE);
        } else {
            mTvDesc.setVisibility(View.VISIBLE);
            mTvDesc.setText(user.getSign());
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setAchievement(AchievementBean data) {
        AchievementBean.DataBean bean = data.getData();
        mTvAchievement.setText("动态 " + bean.getMomentCount() + "    阅读量 " + bean.getAtotalView() + "    文章 " + bean.getArticleTotal());
    }

    @Override
    public void returnError(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void setFollowState(FollowBean data) {
        LogUtils.d(UserCenterActivity.class,"follow data = "+data);
        mBtnFollow.setVisibility(View.VISIBLE);
        mBtnToolbarFollow.setVisibility(View.VISIBLE);
        CommonViewUtils.setFollowState(mBtnFollow, data.getData());
        CommonViewUtils.setFollowState(mBtnToolbarFollow, data.getData());
    }

    @Override
    public void setFollowStateError(FollowBean data) {

    }

    @Override
    public void setAddFollowMsg(String msg) {
        mBtnFollow.setTag(2);
        mBtnToolbarFollow.setTag(2);
        mBtnFollow.setText("已关注");
        mBtnToolbarFollow.setText("已关注");
        ToastUtils.showToast(msg);
        mUserCenterPresenter.getUserFollowState(userId);
    }

    @Override
    public void setAddFollowMsgError(String message) {
        ToastUtils.showToast(message);
    }

    @Override
    public void setUnFollowMsg(String msg) {
        mBtnFollow.setTag(0);
        mBtnToolbarFollow.setTag(0);
        mBtnFollow.setText("+关注");
        mBtnToolbarFollow.setText("+关注");
        ToastUtils.showToast(msg);
        mUserCenterPresenter.getUserFollowState(userId);
    }

    @Override
    public void setUnFollowMsgError(String msg) {

    }

    @Override
    public void onError() {
        ToastUtils.showToast("网络错误");
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }
}