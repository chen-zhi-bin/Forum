package com.program.module_home.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.program.lib_base.LogUtils;
import com.program.module_home.R;
import com.program.module_home.callback.IHomeListFragmentCallback;
import com.program.module_home.model.bean.BannerBean;
import com.program.module_home.model.bean.HomeItemBean;
import com.program.module_home.presenter.Impl.HomeListFragmentPresenterImpl;
import com.program.module_home.ui.adapter.HomeAdapter;
import com.program.module_home.ui.adapter.HomeBannerAdapter;
import com.program.module_home.utils.PresenterManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.ToastUtils;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;

import java.util.List;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class HomeListFragment extends BaseFragment implements IHomeListFragmentCallback {

    private HomeAdapter mAdapter;
    private String mCategoryId;
    private RecyclerView mRvList;
    private HomeListFragmentPresenterImpl mHomeListFragmentPresenter;

    @Override
    protected int getRootViewResId() {
        return R.layout.modulehome_fragment_home_list;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.LOADING);
        mCategoryId = requireArguments().getString("categoryId", "1");
        LogUtils.d(HomeListFragment.class,"categoryId = "+ mCategoryId);
        mAdapter = new HomeAdapter();
        mRvList = rootView.findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(BaseApplication.getAppContext()));
        mRvList.setAdapter(mAdapter);

    }

    @Override
    protected void initPresenter() {
        mHomeListFragmentPresenter = PresenterManager.getInstance().getHomeListFragmentPresenter();
        mHomeListFragmentPresenter.registerViewCallback(this);
        mHomeListFragmentPresenter.getRecommend(mCategoryId);
    }

    @Override
    public void setBanner(BannerBean data) {
        LayoutInflater from = LayoutInflater.from(BaseApplication.getAppContext());
        View inflate = from.inflate(R.layout.modulehome_home_banner_layout, null);
        mAdapter.addHeaderView(inflate);
        Banner banner = inflate.findViewById(R.id.banner);
        if (data != null) {
            HomeBannerAdapter bannerAdapter = new HomeBannerAdapter(data.getData());
            banner.setAdapter(bannerAdapter);
            banner.addBannerLifecycleObserver(this);
            //画廊效果
            banner.setBannerGalleryEffect(16,6,0.8f);

            banner.setIndicator(new CircleIndicator(requireContext()));
            banner.setIndicatorSelectedColor(
                    ContextCompat.getColor(
                            getContext(),
                            R.color.colorPrimary
                    )
            );
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(Object data, int position) {
                    //点击事件，目前没有
                }
            });
        }
    }

    @Override
    public void setHomeItem(HomeItemBean data) {
        setupState(State.SUCCESS);
        List<HomeItemBean.DataBean.ListBean> list = data.getData().getList();
        mAdapter.getData().clear();
        mAdapter.addData(list);
    }

    @Override
    public void setRequestError(String msg) {
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

    }
}
