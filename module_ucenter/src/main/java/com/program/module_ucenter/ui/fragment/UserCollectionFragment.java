package com.program.module_ucenter.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.program.module_ucenter.R;
import com.program.moudle_base.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.CollectionsKt;

public class UserCollectionFragment extends BaseFragment {

    private List<Class> mFragments = CollectionsKt.mutableListOf();
    private List<String> mTitles = CollectionsKt.mutableListOf();
    private String mUserId;

    @Override
    protected int getRootViewResId() {
        return R.layout.moduleucenter_fragment_colloection;
    }

    @Override
    protected void initView(View rootView) {
        setupState(State.SUCCESS);
        mUserId = requireArguments().getString("userId");
        ViewPager2 vpContent = rootView.findViewById(R.id.vp_content);
        TabLayout tabLayout = rootView.findViewById(R.id.tab_layout);
        mTitles.add("创建的");
        mTitles.add("关注的");

        mFragments.add(UserCollectionListFragment.class);
        mFragments.add(UserCollectionListFragment.class);

        FragmentStateAdapter adapter = new FragmentStateAdapter(this) {
            @Override
            public int getItemCount() {
                return mFragments.size();
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                try {
                    Fragment fragment =  (Fragment) mFragments.get(position).newInstance();
                    Bundle bundle = new Bundle();
                    bundle.putString("userId",mUserId);
                    fragment.setArguments(bundle);
                    return fragment;
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Fragment();
                }
            }
        };
        vpContent.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, vpContent, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(mTitles.get(position));
            }
        }).attach();
    }
}
