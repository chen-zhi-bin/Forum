package com.program.module_ucenter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.program.lib_base.LogUtils;
import com.program.lib_common.RoutePath;
import com.program.module_ucenter.R;
import com.program.moudle_base.model.CollectionBean;

@Route(path = RoutePath.Ucenter.PAGE_FAVORITE_LIST)
public class FavoriteListActivity extends AppCompatActivity {

    @Autowired(name = "collection")
    public CollectionBean.DataBean.ContentBean mCollectionBean = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moduleucenter_activity_favorite_list);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        LogUtils.d("test","data = agqoegqoo = "+mCollectionBean.toString());
        initView();
        initListener();
    }

    private void initListener() {

    }

    private void initView() {
        RelativeLayout includerBar = this.findViewById(R.id.include_bar);
        TextView tvTitle = includerBar.findViewById(R.id.tv_title);
        if (mCollectionBean != null) {
            tvTitle.setText(mCollectionBean.getName());
            tvTitle.setGravity(Gravity.FILL);
        }

        RecyclerView rvList = this.findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(this));

    }

}