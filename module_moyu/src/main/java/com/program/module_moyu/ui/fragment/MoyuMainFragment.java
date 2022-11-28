package com.program.module_moyu.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.program.lib_base.StatusBarUtil;
import com.program.module_moyu.MoyuApplication;
import com.program.module_moyu.R;
import com.program.module_moyu.callback.IMoyuMainFragmentCallback;
import com.program.module_moyu.model.bean.TopicIndexBean;
import com.program.module_moyu.model.bean.TopicIndexReturnBean;
import com.program.module_moyu.presenter.IMoyuMainFragmentPresenter;
import com.program.module_moyu.utils.PresenterManager;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.base.BaseFragment;
import com.program.moudle_base.utils.ToastUtils;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import java.util.List;

import io.reactivex.rxjava3.subjects.BehaviorSubject;
import kotlin.collections.CollectionsKt;

public class MoyuMainFragment extends BaseFragment implements IMoyuMainFragmentCallback {

    private RelativeLayout mRelativeLayout;
    private List<TopicIndexBean> titles = CollectionsKt.mutableListOf();
    private List<Class> fragments = CollectionsKt.mutableListOf();
    private FragmentStateAdapter mAdapter;
    private IMoyuMainFragmentPresenter mMoyuMainFragmentPresenter;

    @Override
    protected int getRootViewResId() {
        return R.layout.modulemoyu_fragment_main;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.LOADING);
        mRelativeLayout = rootView.findViewById(R.id.relativeLayout);
        StatusBarUtil.immersive(requireActivity());
        StatusBarUtil.darkMode(requireActivity(),true);
        StatusBarUtil.setPaddingSmart(requireContext(),mRelativeLayout);

        titles.add(new TopicIndexBean("1","推荐"));
        titles.add(new TopicIndexBean("2","关注"));

        fragments.add(MoyuListFragment.class);
        fragments.add(MoyuListFragment.class);

        mAdapter = new FragmentStateAdapter(this) {
            @Override
            public int getItemCount() {
                return fragments.size();
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                try {
                    Fragment fragment = (Fragment)fragments.get(position).newInstance();
                    Bundle bundle = new Bundle();
                    bundle.putString("topicId",titles.get(position).getCategoryId());
                    fragment.setArguments(bundle);
                    return fragment;
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Fragment();
                }
            }
        };
        TabLayout tabLayout = rootView.findViewById(R.id.tab_layout);
        ViewPager2 vpContent = rootView.findViewById(R.id.vp_content);
        vpContent.setAdapter(mAdapter);
        new TabLayoutMediator(tabLayout, vpContent, (tab, position) -> {
            tab.setText(titles.get(position).getName());
        }).attach();
    }

    @Override
    protected void initPresenter() {
        mMoyuMainFragmentPresenter = PresenterManager.getInstance().getMoyuMainFragmentPresenter();
        mMoyuMainFragmentPresenter.registerViewCallback(this);
        mMoyuMainFragmentPresenter.getTopicIndex();
    }

    @Override
    public void setTopicIndex(List<TopicIndexBean> data) {
        setupState(State.SUCCESS);
        for (TopicIndexBean datum : data) {
            fragments.add(MoyuListFragment.class);
            titles.add(datum);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setErrorMsg(String msg) {
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

    @Override
    protected void relese() {
        super.relese();
        mMoyuMainFragmentPresenter.unregisterViewCallback(this);
    }
}
