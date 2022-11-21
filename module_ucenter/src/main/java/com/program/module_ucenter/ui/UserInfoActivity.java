package com.program.module_ucenter.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.program.lib_common.RoutePath;
import com.program.module_ucenter.R;
import com.program.module_ucenter.callback.IUserInfoActivityCallback;
import com.program.module_ucenter.model.domain.UcenterInfo;
import com.program.module_ucenter.model.domain.UserMessageBean;
import com.program.module_ucenter.presenter.IUserInfoActivityPresenter;
import com.program.module_ucenter.utils.PresenterManager;
import com.program.moudle_base.base.BaseActivity;
import com.program.moudle_base.utils.ToastUtils;
import com.program.moudle_base.view.EditDialog;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

@Route(path = RoutePath.Ucenter.PAGE_USER_INFO)
public class UserInfoActivity extends BaseActivity implements IUserInfoActivityCallback {

    private TextView mTvUserCompany;
    private TextView mTvCompany;
    private TextView mTvTo;
    private TextView mTvToPosition;
    private TextView mTvUserPosition;
    private TextView mTvPosition;
    private TextView mTvSkill;
    private TextView mTvUserSkill;
    private TextView mTvToSkill;
    private TextView mTvSign;
    private TextView mTvUserSign;
    private TextView mTvToSign;
    private EditDialog mEditDialog;

    private String mCompany = "";
    private String mPosition = "";
    private String mSkill = "";
    private String mSign = "";
    private static final int mCompanyInt = 1;
    private static final int mPositionInt = 2;
    private static final int mSkillInt = 3;
    private static final int mSignInt = 4;
    private TitleBar mTitleBar;
    private IUserInfoActivityPresenter mUserInfoActivityPresenter;

    @Override
    protected void initPresenter() {
        mUserInfoActivityPresenter = PresenterManager.getInstance().getUserInfoActivityPresenter();
        mUserInfoActivityPresenter.registerViewCallback(this);
        mUserInfoActivityPresenter.getUserInfo();
    }

    @Override
    protected void initView() {
        mTitleBar = this.findViewById(R.id.title_bar);

        mTvCompany = this.findViewById(R.id.tv_company);
        mTvUserCompany = this.findViewById(R.id.tv_company_user);
        mTvTo = this.findViewById(R.id.tv_to);
        mCompany = mTvUserCompany.getText().toString();

        mTvPosition = this.findViewById(R.id.tv_position);
        mTvUserPosition = this.findViewById(R.id.tv_position_user);
        mTvToPosition = this.findViewById(R.id.tv_to_tv_position);
        mPosition = mTvUserPosition.getText().toString();

        mTvSkill = this.findViewById(R.id.tv_skill);
        mTvUserSkill = this.findViewById(R.id.tv_skill_user);
        mTvToSkill = this.findViewById(R.id.tv_to_tv_skill);
        mSkill = mTvUserSkill.getText().toString();

        mTvSign = this.findViewById(R.id.tv_sign);
        mTvUserSign = this.findViewById(R.id.tv_sign_user);
        mTvToSign = this.findViewById(R.id.tv_to_tv_sign);
        mSign = mTvUserSign.getText().toString();

        mEditDialog = new EditDialog(this);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.moduleucenter_activity_user_info;
    }

    @Override
    protected void initEvent() {
        mEditDialog.setNoOnclickListener("取消", new EditDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
                mEditDialog.dismiss();
            }
        });
        initListener();
    }

    private void initListener() {
        mTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(TitleBar titleBar) {
                finish();
            }

            @Override
            public void onRightClick(TitleBar titleBar) {
                ToastUtils.showToast("a = "+mCompany+"" +
                        "b= "+mPosition+"" +
                        "c = "+mSkill+"" +
                        "d = "+mSign);
            }
        });
        mTvTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditDialog.setHint("");
                mEditDialog.setTitle("请输入公司名");
                mEditDialog.setEditText(mCompany);
                mEditDialog.show();
                mEditDialog.setYesOnclickListener("确认", new EditDialog.onYesOnclickListener() {
                    @Override
                    public void onYesClick(String phone) {
                        toMessage(mCompanyInt,phone);
                    }
                });
            }
        });

        mTvToPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditDialog.setHint("");
                mEditDialog.setTitle("请输入职位");
                mEditDialog.setEditText(mPosition);
                mEditDialog.show();
                mEditDialog.setYesOnclickListener("确认", new EditDialog.onYesOnclickListener() {
                    @Override
                    public void onYesClick(String phone) {
                        toMessage(mPositionInt,phone);
                    }
                });
            }
        });
        mTvToSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditDialog.setHint("");
                mEditDialog.setTitle("请输入技能");
                mEditDialog.setEditText(mSkill);
                mEditDialog.show();
                mEditDialog.setYesOnclickListener("确认", new EditDialog.onYesOnclickListener() {
                    @Override
                    public void onYesClick(String phone) {
                        toMessage(mSkillInt,phone);
                    }
                });
            }
        });
        mTvToSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditDialog.setHint("");
                mEditDialog.setTitle("请输入技能");
                mEditDialog.setEditText(mSign);
                mEditDialog.show();
                mEditDialog.setYesOnclickListener("确认", new EditDialog.onYesOnclickListener() {
                    @Override
                    public void onYesClick(String phone) {
                        toMessage(mSignInt,phone);
                    }
                });
            }
        });
    }

    private void toMessage(int type,String msg){
        if (msg.equals("")){
            return;
        }
        switch (type){
            case mCompanyInt:
                mCompany =msg;
                mTvUserCompany.setText(msg);
                break;
            case mPositionInt:
                mTvUserPosition.setText(msg);
                mPosition = msg;
                break;
            case mSkillInt:
                mTvUserSkill.setText(msg);
                mSkill = msg;
                break;
            case mSignInt:
                mSign = msg;
                mTvUserSign.setText(msg);
                break;

        }
        mEditDialog.dismiss();
    }

    @Override
    public void setUserInfo(UcenterInfo data) {
        UcenterInfo.DataBean bean = data.getData();
        if (bean.getCompany()!=null&&!bean.getCompany().equals("")){
            mTvUserCompany.setText(bean.getCompany());
        }
        if (bean.getPosition()!=null&&!bean.getPosition().equals("")){
            mTvUserPosition.setText(bean.getPosition());
        }
        if (bean.getGoodAt()!=null&&!bean.getGoodAt().equals("")){
            mTvUserSkill.setText(bean.getGoodAt());
        }
        if (bean.getSign()!=null&&!bean.getSign().equals("")){
            mTvUserSign.setText(bean.getSign());
        }
    }

    @Override
    public void setErrorMsg(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public LifecycleTransformer<Object> TobindToLifecycle() {
        BehaviorSubject<Object> objectBehaviorSubject = BehaviorSubject.create();
        return RxLifecycle.bind(objectBehaviorSubject);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUserInfoActivityPresenter.unregisterViewCallback();
    }
}