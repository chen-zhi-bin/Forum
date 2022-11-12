package com.program.module_moyu.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.program.lib_common.RoutePath;
import com.program.module_moyu.R;
import com.program.module_moyu.adapter.ImagePreviewAdapter;

@Route(path = RoutePath.Moyu.PAGE_PUT_FISH)
public class PutFishActivity extends AppCompatActivity {

    private static final int  INPUT_MAX_LENGTH = 1024;
    private TextView mTvInputLength;
    private EditText mEtInputContent;
    private RecyclerView mRvPreviewImage;
    private ImageView mIvImage;
    private ImagePreviewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulemoyu_activity_put_fish);
        initView();
        initPresenter();
        initEvent();
    }

    private void initEvent() {

    }

    private void initPresenter() {

    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        mTvInputLength = this.findViewById(R.id.tv_input_length);
        mTvInputLength.setText(0+"/"+INPUT_MAX_LENGTH);
        mEtInputContent = this.findViewById(R.id.et_input_content);
        mRvPreviewImage = this.findViewById(R.id.rv_preview_image);
        mRvPreviewImage.setLayoutManager(new GridLayoutManager(this,4));
        mAdapter = new ImagePreviewAdapter();
        mRvPreviewImage.setAdapter(mAdapter);
        mIvImage = this.findViewById(R.id.iv_image);

    }

}