package com.program.module_home.ui.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.program.lib_base.LogUtils;
import com.program.lib_common.event.UpdateItemEvent;
import com.program.lib_common.service.home.wrap.HomeServiceWrap;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_home.R;
import com.program.module_home.callback.IHomeListFragmentCallback;
import com.program.module_home.model.bean.ArticleDetailBean;
import com.program.module_home.model.bean.BannerBean;
import com.program.module_home.model.bean.HomeItemBean;
import com.program.module_home.presenter.Impl.HomeListFragmentPresenterImpl;
import com.program.module_home.ui.adapter.HomeAdapter;
import com.program.module_home.ui.adapter.HomeBannerAdapter;
import com.program.module_home.utils.PresenterManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.CommonViewUtils;
import com.program.moudle_base.utils.EventBusUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;

import net.mikaelzero.mojito.Mojito;
import net.mikaelzero.mojito.loader.glide.GlideImageLoader;
import net.mikaelzero.mojito.view.sketch.SketchImageLoadFactory;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class HomeListFragment extends BaseFragment implements IHomeListFragmentCallback {

    private HomeAdapter mAdapter;
    private String mCategoryId;
    private RecyclerView mRvList;
    private HomeListFragmentPresenterImpl mHomeListFragmentPresenter;
    private SmartRefreshLayout mRefreshLayout;

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

    private Banner mBanner;

    @Override
    protected int getRootViewResId() {
        return R.layout.modulehome_fragment_home_list;
    }

    @Subscribe
    @Override
    protected void initView(View rootView) {
        setupState(State.LOADING);
        if (!EventBusUtils.INSTANCE.isRegistered(this)){
            EventBusUtils.INSTANCE.register(this);
        }
        mCategoryId = requireArguments().getString("categoryId", "1");
        LogUtils.d(HomeListFragment.class,"categoryId = "+ mCategoryId);
        Mojito.initialize(GlideImageLoader.Companion.with(BaseApplication.getAppContext()), new SketchImageLoadFactory()); //初始化
        mAdapter = new HomeAdapter();
        mRvList = rootView.findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(BaseApplication.getAppContext()));
        mRvList.setAdapter(mAdapter);
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);
        if (mCategoryId.equals("1")){
            LayoutInflater from = LayoutInflater.from(BaseApplication.getAppContext());
            View inflate = from.inflate(R.layout.modulehome_home_banner_layout, null);
            mAdapter.addHeaderView(inflate);
            mBanner = inflate.findViewById(R.id.banner);
        }
    }

    @Override
    protected void initPresenter() {
        mHomeListFragmentPresenter = PresenterManager.getInstance().getHomeListFragmentPresenter();
        mHomeListFragmentPresenter.registerViewCallback(this);
        mHomeListFragmentPresenter.getRecommend(mCategoryId);
    }

    @Override
    protected void initListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                HomeItemBean.DataBean.ListBean item = (HomeItemBean.DataBean.ListBean) adapter.getItem(position);
                HomeServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(item.getId(),item.getTitle());
            }
        });
        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                HomeItemBean.DataBean.ListBean item = (HomeItemBean.DataBean.ListBean) adapter.getItem(position);
                int id = view.getId();
                if (id == R.id.tv_content) {
                    HomeServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(item.getId(),item.getTitle());
                }else if (id==R.id.iv_avatar||id==R.id.tv_nickName){
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(item.getUserId());
                }else if (id==R.id.iv_cover){
                    CommonViewUtils.showBigImage(view,item.getCovers().get(0));
                }
            }
        });
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mHomeListFragmentPresenter.getRecommend(mCategoryId);
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mHomeListFragmentPresenter.getRecommendMore(mCategoryId);
            }
        });
    }

    @Override
    public void setBanner(BannerBean data) {
        finishRefresh();
        if (data != null) {
            HomeBannerAdapter bannerAdapter = new HomeBannerAdapter(data.getData());
            mBanner.setAdapter(bannerAdapter);
            mBanner.addBannerLifecycleObserver(this);
            //画廊效果
            mBanner.setBannerGalleryEffect(16,6,0.8f);

            mBanner.setIndicator(new CircleIndicator(requireContext()));
            mBanner.setIndicatorSelectedColor(
                    ContextCompat.getColor(
                            getContext(),
                            R.color.colorPrimary
                    )
            );
            mBanner.setOnBannerListener(new OnBannerListener() {
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
        finishRefresh();
        List<HomeItemBean.DataBean.ListBean> list = data.getData().getList();
        mAdapter.getData().clear();
        mAdapter.addData(list);
    }

    @Override
    public void setHomeItemMore(HomeItemBean data) {
        finishLoadMore();
        List<HomeItemBean.DataBean.ListBean> list = data.getData().getList();
        mAdapter.addData(list);
    }

    @Override
    public void setArticleUpdateInfo(ArticleDetailBean data) {
        if (mAdapter==null||mAdapter.getData().size()==0){
            return;
        }
        ArticleDetailBean.DataBean bean = data.getData();
        if (bean != null) {
            List<MultiItemEntity> data1 = mAdapter.getData();
            HomeItemBean.DataBean.ListBean item = null;
            int index = -1;
            for (MultiItemEntity multiItemEntity : data1) {
                if (multiItemEntity != null) {
                    HomeItemBean.DataBean.ListBean itemEntity = (HomeItemBean.DataBean.ListBean) multiItemEntity;
                    if (bean.getId().equals(itemEntity.getId())){
                        index = data1.indexOf(multiItemEntity);
                        item = itemEntity;
                    }
                }
            }
            LogUtils.d("test","index = "+index);
            if (index==-1){
                return;
            }
            MultiItemEntity itemEntity = mAdapter.getData().get(index);
            HomeItemBean.DataBean.ListBean articleItem = (HomeItemBean.DataBean.ListBean) itemEntity;
            LogUtils.d("test","3333 title = "+bean.getTitle());
            LogUtils.d("test","3333 title = "+bean.getThumbUp());
            articleItem.setThumbUp(bean.getThumbUp());
            articleItem.setViewCount(bean.getViewCount());
            mAdapter.notifyItemChanged(index+1);        //+1是因为这个adapter有个HeaderView(下标为0的位置被占用)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventUpdateItem(UpdateItemEvent event){
        String event1 = event.getEvent();
        LogUtils.d("test","event = "+event1.toString());

        if (event1.equals(UpdateItemEvent.Event.UPDATE_ARTICLE)){
            updateItem(event.getId());
        }
    }

    private void updateItem(String id) {
        LogUtils.d("test","event id = "+id);
        mHomeListFragmentPresenter.getUpdateArticleInfo(id);
    }

    private void finishLoadMore() {
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadMore();
        }
    }

    private void finishRefresh() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        }
    }

    @Override
    public void setRequestError(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void onDestroy() {
        if (EventBusUtils.INSTANCE.isRegistered(this)){
            EventBusUtils.INSTANCE.unRegister(this);
        }
        super.onDestroy();
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
