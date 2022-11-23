package com.program.module_ucenter.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.program.lib_base.StatusBarUtil;
import com.program.lib_common.RoutePath;
import com.program.module_ucenter.R;
import com.program.module_ucenter.adapter.ImageListAdapter;
import com.program.moudle_base.model.ImageItem;
import com.program.moudle_base.utils.ImagePickerConfig;
import com.program.moudle_base.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

@Route(path = RoutePath.Ucenter.PAGE_IMAGE_SWITCH)
public class ImageSwitchActivity extends AppCompatActivity implements ImageListAdapter.OnItemSelectedChangeListener {

    @Autowired(name = "maxCount")
    public int maxCount;

    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int LOADER_ID=1;
    private ImageListAdapter mAdapter;
    private List<ImageItem> mImageItems = new ArrayList<>();
    private TextView mTvFinish;
    private ImagePickerConfig mPickerConfig;
    private RelativeLayout mLayout;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moduleucenter_activity_image_switch);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        checkPermission();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void checkPermission() {
        XXPermissions.with(this)
                .permission(Permission.READ_EXTERNAL_STORAGE)
                .request(new OnPermissionCallback() {
                    @Override
                    public void onGranted(List<String> permissions, boolean all) {
                        if (all){
                            initLoaderManager();
                            initView();

                        }else {
                            ToastUtils.showToast("获取权限失败");
                        }
                    }

                    @Override
                    public void onDenied(List<String> permissions, boolean never) {
                        if (never){
                            ToastUtils.showToast("权限已被永久拒绝，如想允许权限则手动去打开");
//                            XXPermissions.startPermissionActivity(ImageSwitchActivity.this,permissions);
                        }else {
                            ToastUtils.showToast("获取失败");
                        }
                        finish();
                    }
                });
//        int readExStoragePermissResi = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
//        if (readExStoragePermissResi!= PackageManager.PERMISSION_GRANTED){
//            //没有权限
//            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSION_REQUEST_CODE);
//        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == PERMISSION_REQUEST_CODE){
//            boolean hasPermissions = false;
//            for (int grantResult : grantResults) {
//                hasPermissions = grantResult==PackageManager.PERMISSION_GRANTED;
//            }
////            if (grantResults.length==0&&grantResults[0]== PackageManager.PERMISSION_GRANTED) {
//            if (hasPermissions){
//                //有权限
//                initLoaderManager();
//                intiView();
//            }else {
//                //无权限
//                //根据交互处理
//                ToastUtils.showToast("没有储存权限就选择不了收藏集封面");
//                finish();
//            }
//        }
//    }

    private void initLoaderManager() {
        LoaderManager loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(LOADER_ID, null, new LoaderManager.LoaderCallbacks<Cursor>() {
            @NonNull
            @Override
            public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
                if (id==LOADER_ID){
                    return new CursorLoader(ImageSwitchActivity.this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            new String[]{"_data","_display_name","date_added"},
                            null,null,"date_added DESC");//时间添加的 逆序
                }
                return null;
            }

            @Override
            public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
                if (cursor != null) {
                    String[] columnNames = cursor.getColumnNames();
                    while (cursor.moveToNext()) {
//                        Log.d("test", "===========================");
//                        for (String columnName : columnNames) {
//                            Log.d("test", columnName + "==" + cursor.getString(cursor.getColumnIndex(columnName)));
//                        }
                        String path = cursor.getString(0);
                        String title = cursor.getString(1);
                        long date = cursor.getLong(2);

                        ImageItem imageItem = new ImageItem(path,title,date);
                        mImageItems.add(imageItem);
                    }
                    cursor.close();
                }
                mAdapter.setData(mImageItems);
                Log.d("test", "onLoadFinished: arraylist = "+mImageItems.toString());
            }

            @Override
            public void onLoaderReset(@NonNull Loader<Cursor> loader) {

            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        mTvFinish = this.findViewById(R.id.tv_finish);
        mLayout = this.findViewById(R.id.layout);
        mTvFinish.setText("(0/"+maxCount+")   完成");
        RecyclerView list = this.findViewById(R.id.image_list);
        list.setLayoutManager(new GridLayoutManager(this,3));
        mAdapter = new ImageListAdapter();
        mAdapter.setMaxSelectedCount(maxCount);
        list.setAdapter(mAdapter);
        initEvent();
        initImageSwitchConfig();

        initStatusBar();
    }

    private void initStatusBar() {
        StatusBarUtil.immersive(this);
        StatusBarUtil.darkMode(this,true);
        StatusBarUtil.setPaddingSmart(this,mLayout);
    }

    private void initImageSwitchConfig() {
        mPickerConfig = ImagePickerConfig.getInstance();
        int maxSelectCount = mPickerConfig.getMaxSelectCount();
        mAdapter.setMaxSelectedCount(maxSelectCount);
    }

    private void initEvent() {
        mAdapter.setOnItemSelectedChangeListener(this);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelectedChange(List<ImageItem> selectedItems) {
        //所选择的数据发生变化
        mTvFinish.setText("("+selectedItems.size()+"/"+mAdapter.getMaxSelectedCount()+")完成");
        mTvFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取选择的数据
                List<ImageItem> result = new ArrayList<>();
                result.addAll(mAdapter.getSelectItem());
                mAdapter.release();
                //通知其他地方
                ImagePickerConfig.OnImageSelectFinishedListener onImageSelectFinishedListener = mPickerConfig.getOnImageSelectFinishedListener();
                if (onImageSelectFinishedListener != null) {
                    onImageSelectFinishedListener.onSelectedFinished(result);
                }

                finish();

            }
        });
    }

}