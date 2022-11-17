package com.program.module_search.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.program.lib_common.Constants;
import com.program.lib_common.RoutePath;
import com.program.module_search.R;
import com.program.module_search.ui.fragment.SearchListFragment;

import java.util.ArrayList;
import java.util.List;

@Route(path = RoutePath.Search.PAGE_SEARCH)
public class SearchActivity extends AppCompatActivity {

    private List<String> mTitles = new ArrayList<>();
    private List mFragments = (List) (new ArrayList());
    private FragmentStateAdapter mAdapter;
    private ViewPager2 mVpConent;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulesearch_activity_search);
        initView();
    }

    private void initView() {

        mVpConent = this.findViewById(R.id.vp_content);
        mTabLayout = this.findViewById(R.id.tab_layout);

        mTitles.add("文章");
        mTitles.add("问答");
        mTitles.add("分享");

        mFragments.add(SearchListFragment.class);
        mFragments.add(SearchListFragment.class);
        mFragments.add(SearchListFragment.class);

        mVpConent.setOffscreenPageLimit(3);
        mAdapter = (FragmentStateAdapter) (new FragmentStateAdapter((FragmentActivity) this) {
            @Override
            public int getItemCount() {
                return mTitles.size();
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                Fragment fragment;
                try {
                    Object o = ((Class) mFragments.get(position)).newInstance();
                    if (o!=null){
                        fragment = (Fragment)o;
                        Bundle bundle = new Bundle();
                        switch (position){
                            case 0:
                                bundle.putInt(Constants.Search.SEARCH_TYPE,Constants.Search.SEARCH_ARTICLE);
                                break;
                            case 1:
                                bundle.putInt(Constants.Search.SEARCH_TYPE,Constants.Search.SEARCH_WENDA);
                                break;
                            case 2:
                                bundle.putInt(Constants.Search.SEARCH_TYPE,Constants.Search.SEARCH_SHAPE);
                                break;
                        }
                        fragment.setArguments(bundle);
                    }else {
                        fragment = new Fragment();
                    }
                    return fragment;
                } catch (Exception e) {
                    e.printStackTrace();
                    fragment = new Fragment();
                    return fragment;
                }
            }
        });

        mVpConent.setAdapter(mAdapter);
        new TabLayoutMediator(mTabLayout, mVpConent, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                 tab.setText(mTitles.get(position));
            }
        }).attach();

    }
}