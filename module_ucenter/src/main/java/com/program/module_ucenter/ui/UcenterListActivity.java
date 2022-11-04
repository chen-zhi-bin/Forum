package com.program.module_ucenter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.program.lib_common.Constants;
import com.program.lib_common.RoutePath;
import com.program.module_ucenter.R;
import com.program.module_ucenter.ui.fragment.UserFollowFragment;
import com.program.module_ucenter.ui.fragment.UserRankingFragment;
import com.program.moudle_base.utils.ToastUtils;

@Route(path = RoutePath.Ucenter.PAGE_UCENTER_LIST)
public class UcenterListActivity extends AppCompatActivity {

    @Autowired(name = Constants.Ucenter.PAGE_TYPE)
    public int pageType = 0;

    @Autowired(name = "userId")
    public String userId;

    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moduleucenter_activity_ucenter_list);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        initView();
    }

    private void initView() {
        RelativeLayout includeBar = this.findViewById(R.id.include_bar);
        TextView tvTitle = includeBar.findViewById(R.id.tv_title);
        includeBar.findViewById(R.id.ivBack).setOnClickListener(view -> finish());

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (pageType) {
            case Constants.Ucenter.PAGE_FOLLOW:
            case Constants.Ucenter.PAGE_FANS:
                tvTitle.setText(pageType == Constants.Ucenter.PAGE_FOLLOW ? "关注列表" : "粉丝列表");
                mFragment = new UserFollowFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(Constants.Ucenter.PAGE_TYPE,pageType);
                bundle.putString("userId",userId);
                mFragment.setArguments(bundle);
                transaction.add(R.id.fl_content,mFragment).commit();
                break;
            case Constants.Ucenter.PAGE_RANKING:
                tvTitle.setText("富豪榜");
                mFragment = new UserRankingFragment();
                transaction.add(R.id.fl_content,mFragment).commit();
                break;
        }
    }
}