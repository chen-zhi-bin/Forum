package com.program.module_moyu.ui.activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.program.lib_base.LogUtils;
import com.program.lib_common.Constants;
import com.program.lib_common.RoutePath;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_moyu.R;
import com.program.module_moyu.adapter.ImagePreviewAdapter;
import com.program.moudle_base.model.ImageItem;
import com.program.moudle_base.utils.ImagePickerConfig;
import com.program.moudle_base.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

@Route(path = RoutePath.Moyu.PAGE_PUT_FISH)
public class PutFishActivity extends AppCompatActivity {

    private static final int  INPUT_MAX_LENGTH = 1024;
    private static final int  MAX_SELECTED_COUNT = 4;
    private TextView mTvInputLength;
    private EditText mEtInputContent;
    private RecyclerView mRvPreviewImage;
    private ImageView mIvImage;
    private ImagePreviewAdapter mAdapter;
    private List<ImageItem> mSelectImage = new ArrayList<>();
    private ImagePickerConfig mPickerConfig;
    private TitleBar mTitleBar;
    private RelativeLayout mRlChooseFishPone;
    private String mMoyuName =null;
    private String mMoyuId =null;
    private ActivityResultLauncher<Intent> mIntentActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulemoyu_activity_put_fish);
        mIntentActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode()==RESULT_OK) {
                    mMoyuName = result.getData().getStringExtra(Constants.Moyu.MOYU_NAME);
                    mMoyuId = result.getData().getStringExtra(Constants.Moyu.MOYU_ID);

                }
                LogUtils.d("test","name = "+mMoyuName);
                LogUtils.d("test","id = "+mMoyuId);
            }
        });
        initView();
        initPresenter();
        initEvent();
        initPickerConfig();
    }

    private void initEvent() {
        mRlChooseFishPone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PutFishActivity.this, FishPoneSelectionActivity.class);
                mIntentActivityResultLauncher.launch(intent);
            }
        });
        mEtInputContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void afterTextChanged(Editable editable) {
                mTvInputLength.setText(editable.length()+"/"+INPUT_MAX_LENGTH);
            }
        });
        mTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(TitleBar titleBar) {
                finish();
            }
        });
        mIvImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectImage.size()<MAX_SELECTED_COUNT){
                    //控制图片的总数
                    mPickerConfig.setMaxSelectCount(MAX_SELECTED_COUNT-mSelectImage.size());
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchImageSwitch(MAX_SELECTED_COUNT-mSelectImage.size());
                }else {
                    ToastUtils.showToast("图片只能选"+MAX_SELECTED_COUNT+"张");
                }
            }
        });
        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                int id = view.getId();
                Object item = adapter.getItem(position);
                if (id==R.id.iv_clear){
                    if (item instanceof ImageItem){
                        mSelectImage.remove(item);
                        mAdapter.getData().remove(item);
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    //得到所选图片
    private void initPickerConfig() {
        mPickerConfig = ImagePickerConfig.getInstance();
        mPickerConfig.setMaxSelectCount(MAX_SELECTED_COUNT);
        mPickerConfig.setOnImageSelectFinishedListener(new ImagePickerConfig.OnImageSelectFinishedListener() {
            @Override
            public void onSelectedFinished(List<ImageItem> result) {
                for (ImageItem imageItem : result) {
//                    if (!mSelectImage.contains(imageItem)) {
//                        mSelectImage.add(imageItem);
//                    }
                    boolean isExist = false;
                    for (ImageItem item : mSelectImage) {
                        if (item.getPath().equals(imageItem.getPath())){
                            isExist=true;
                            ToastUtils.showToast("重复的图片不会添加");
                            break;
                        }
                    }
                    if (!isExist){
                        mSelectImage.add(imageItem);
                    }

                }
                mAdapter.getData().clear();
                mAdapter.addData(mSelectImage);
            }
        });
    }

    private void initPresenter() {

    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        mTvInputLength = this.findViewById(R.id.tv_input_length);
        mTvInputLength.setText(0+"/"+INPUT_MAX_LENGTH);
        mEtInputContent = this.findViewById(R.id.et_input_content);
        mEtInputContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1024)});
        mRvPreviewImage = this.findViewById(R.id.rv_preview_image);
        mRvPreviewImage.setLayoutManager(new GridLayoutManager(this,4));
        mAdapter = new ImagePreviewAdapter();
        mRvPreviewImage.setAdapter(mAdapter);
        mIvImage = this.findViewById(R.id.iv_image);
        mTitleBar = this.findViewById(R.id.title_bar);
        mRlChooseFishPone = this.findViewById(R.id.rl_choose_fish_pond);
    }

}