package com.program.module_home.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.program.lib_base.LogUtils;
import com.program.lib_base.StatusBarUtil;
import com.program.lib_common.RoutePath;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_home.R;
import com.program.module_home.callback.IPriseListActivityCallback;
import com.program.module_home.model.bean.PriseArticleBean;
import com.program.module_home.presenter.IPriseListActivityPresenter;
import com.program.module_home.ui.adapter.PriseAdapter;
import com.program.module_home.utils.PresenterManager;
import com.program.moudle_base.utils.ToastUtils;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import io.reactivex.rxjava3.subjects.BehaviorSubject;
import retrofit2.http.Path;

@Route(path = RoutePath.Home.PAGE_PRISE_LIST)
public class PriseListActivity extends AppCompatActivity implements IPriseListActivityCallback {

    @Autowired(name = RoutePath.Home.ARTICLE_ID)
    public String mArticleId;
    private RelativeLayout mIncludeBar;
    private RecyclerView mRvPrise;
    private PriseAdapter mAdapter;
    private IPriseListActivityPresenter mPriseListActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulehome_activity_prise_list);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        LogUtils.d("test","PriseListActivity + article id ="+mArticleId);
        initView();
        initStatusBar();
        initPresenter();
        initListener();
    }

    private void initStatusBar() {
        StatusBarUtil.immersive(this);
        StatusBarUtil.darkMode(this,true);
        StatusBarUtil.setPaddingSmart(this,mIncludeBar);
    }

    private void initListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                PriseArticleBean.DataBean item = (PriseArticleBean.DataBean) adapter.getItem(position);
                UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(item.getUserId());
            }
        });
    }

    private void initPresenter() {
        mPriseListActivityPresenter = PresenterManager.getInstance().getPriseListActivityPresenter();
        mPriseListActivityPresenter.registerViewCallback(this);
        mPriseListActivityPresenter.getPriseList(mArticleId);
    }

    private void initView() {
        mIncludeBar = this.findViewById(R.id.include_bar);
        mIncludeBar.findViewById(R.id.layout_right).setVisibility(View.GONE);
        mIncludeBar.findViewById(R.id.ivBack).setOnClickListener(view -> finish());
        TextView tvTitle = mIncludeBar.findViewById(R.id.tv_title);
        tvTitle.setText("打赏列表");

        mRvPrise = this.findViewById(R.id.rv_prise);
        mRvPrise.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new PriseAdapter();
        mRvPrise.setAdapter(mAdapter);
    }

    @Override
    public void setPriseList(PriseArticleBean data) {
        if (data.getSuccess()){
            mAdapter.setNewData(data.getData());
        }else {
            ToastUtils.showToast(data.getMessage());
        }
    }

    @Override
    public void serErrorMsg(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public LifecycleTransformer<Object> TobindToLifecycle() {
        BehaviorSubject<Object> objectBehaviorSubject = BehaviorSubject.create();
        return  RxLifecycle.bind(objectBehaviorSubject);
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