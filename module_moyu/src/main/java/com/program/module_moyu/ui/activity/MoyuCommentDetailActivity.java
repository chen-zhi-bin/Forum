package com.program.module_moyu.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.program.lib_base.LogUtils;
import com.program.lib_common.RoutePath;
import com.program.module_moyu.R;
import com.program.module_moyu.model.bean.MomentCommentBean;

@Route(path = RoutePath.Moyu.PAGE_DETAIL_COMMENT)
public class MoyuCommentDetailActivity extends AppCompatActivity {

    @Autowired(name = RoutePath.Moyu.MOYU_DETAIL_ID)
    public String mId;

    @Autowired(name = RoutePath.Moyu.COMMENT)
    public MomentCommentBean.DataBean.ListBean mComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulemoyu_activity_moyu_comment_detail);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
    }
}