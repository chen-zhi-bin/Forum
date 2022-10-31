package com.program.module_wenda.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.program.lib_base.StatusBarUtil;
import com.program.lib_common.Constants;
import com.program.module_wenda.R;
import com.program.module_wenda.WendaApplication;
import com.program.moudle_base.base.BaseApplication;
import com.program.moudle_base.base.BaseFragment;

import java.util.List;

import kotlin.collections.CollectionsKt;

public class WendaMainFragment extends BaseFragment {

    private List<String> titles = CollectionsKt.mutableListOf();
    private List<Class> fragments = CollectionsKt.mutableListOf();
    private FragmentStateAdapter mAdapter;

    @Override
    protected int getRootViewResId() {
        return R.layout.modulewenda_fragment_main;
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        setupState(State.SUCCESS);
        TabLayout tabLayout = rootView.findViewById(R.id.tab_layout);
        ViewPager2 vpContent = rootView.findViewById(R.id.vp_content);
        StatusBarUtil.immersive(requireActivity());
        StatusBarUtil.darkMode(requireActivity(),true);
        StatusBarUtil.setPaddingSmart(requireContext(),tabLayout);
        titles.add("最新提问");
        titles.add("热门推荐");
        titles.add("周•排行榜");
        fragments.add(WendaListFragment.class);
        fragments.add(WendaListFragment.class);
        fragments.add(WendaRankingFragment.class);
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
                    switch (position){
                        case 0:
                            bundle.putString(Constants.Wenda.WENDA_TYPE,Constants.Wenda.WENDA_LASTEST);
                            break;
                        case 1:
                            bundle.putString(Constants.Wenda.WENDA_HOT,Constants.Wenda.WENDA_HOT);
                            break;
                    }
                    fragment.setArguments(bundle);
                    return fragment;
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Fragment();
                }
            }
        };

        vpContent.setAdapter(mAdapter);
        new TabLayoutMediator(tabLayout, vpContent, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titles.get(position));
            }
        }).attach();

    }
}
