package com.program.module_home.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.program.lib_base.LogUtils;
import com.program.lib_base.StatusBarUtil;
import com.program.lib_common.service.home.wrap.HomeServiceWrap;
import com.program.module_home.R;
import com.program.module_home.callback.IHomeMainFragmentCallback;
import com.program.module_home.model.bean.CategoryDB;
import com.program.module_home.presenter.IHomeMainFragmentPresenter;
import com.program.module_home.utils.PresenterManager;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.ToastUtils;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import java.util.List;

import io.reactivex.rxjava3.subjects.BehaviorSubject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.markers.KMutableList;

public class HomeMainFragment extends BaseFragment implements IHomeMainFragmentCallback {

    private List<CategoryDB> titles = CollectionsKt.mutableListOf();
    private List<Class> fragments = CollectionsKt.mutableListOf();
    private FragmentStateAdapter mAdapter;
    private IHomeMainFragmentPresenter mHomeMainFragmentPresenter;

    @Override
    protected int getRootViewResId() {
        return R.layout.modulehome_fragment_home_main;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.SUCCESS);
        RelativeLayout relativeLayout = rootView.findViewById(R.id.relativeLayout);
        StatusBarUtil.immersive(requireActivity());
        StatusBarUtil.darkMode(requireActivity(),true);
        StatusBarUtil.setPaddingSmart(requireContext(),relativeLayout);
        titles.add(new CategoryDB("1","推荐",0));
        fragments.add(HomeListFragment.class);
        mAdapter = new FragmentStateAdapter(this) {
            @Override
            public int getItemCount() {
                return fragments.size();
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                try {
                    Fragment fragment = (Fragment) fragments.get(position).newInstance();
                    Bundle bundle = new Bundle();
                    bundle.putString("categoryId",titles.get(position).getId());
                    fragment.setArguments(bundle);
                    return fragment;
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Fragment();
                }
            }
        };

        ViewPager2 vpContent = rootView.findViewById(R.id.vp_content);
        vpContent.setAdapter(mAdapter);
        TabLayout tabLayout = rootView.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout,vpContent,((tab, position) -> tab.setText(titles.get(position).getCategoryName()))).attach();
//        rootView.findViewById(R.id.iv_more).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                HomeServiceWrap.Singletion.INSTANCE.getHolder().
//            }
//        });
    }

    @Override
    protected void initPresenter() {
        mHomeMainFragmentPresenter = PresenterManager.getInstance().getHomeMainFragmentPresenter();
        mHomeMainFragmentPresenter.registerViewCallback(this);
        mHomeMainFragmentPresenter.getCategoryList();
    }

    @Override
    public void setCategoryList(List<CategoryDB> data) {
        for (CategoryDB datum : data) {
            titles.add(datum);
            fragments.add(HomeListFragment.class);
        }
        mAdapter.notifyDataSetChanged();
        LogUtils.d(HomeMainFragment.class,"adapter data size="+mAdapter.getItemCount());
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
