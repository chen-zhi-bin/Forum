package com.program.module_ucenter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.lib_common.RoutePath;
import com.program.module_ucenter.R;
import com.program.module_ucenter.ui.fragment.UserMessageListFragment;
import com.program.module_ucenter.ui.fragment.UserMessageSystemFragment;

@Route(path = RoutePath.Ucenter.PAGE_MSG_LIST)
public class MessageListActivity extends AppCompatActivity {

    private RelativeLayout mRelativeLayout;
    private ImageView mIvBack;
    private TextView mTvTitle;

    @Autowired(name = Constants.Ucenter.PAGE_TYPE)
    public int pageType = -1;

    @Autowired(name = "title")
    public String title = "标题";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moduleucenter_activity_message_list);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        initView();
        initListener();
    }

    private void initListener() {
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initView() {
        mRelativeLayout = this.findViewById(R.id.include_bar);
        mIvBack = mRelativeLayout.findViewById(R.id.ivBack);
        mTvTitle = mRelativeLayout.findViewById(R.id.tv_title);

        mTvTitle.setText(title);
        LogUtils.d("test","title = "+title + "===pageType ="+pageType);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (pageType){
            case Constants.Ucenter.PAGE_MSG_SYSTEM:
                //系统消息
                transaction.add(R.id.fl_content, new UserMessageSystemFragment()).commit();
                break;
            default:
                UserMessageListFragment fragment = new UserMessageListFragment();
                Bundle bundle = new Bundle();
                fragment.setArguments(bundle);
                transaction.add(R.id.fl_content,fragment).commit();
                break;
        }
    }


}