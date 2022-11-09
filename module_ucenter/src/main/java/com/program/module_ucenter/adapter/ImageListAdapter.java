package com.program.module_ucenter.adapter;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.program.lib_base.LogUtils;
import com.program.lib_common.UIUtils;
import com.program.module_ucenter.R;
import com.program.moudle_base.model.ImageItem;
import com.program.moudle_base.utils.ToastUtils;
import com.program.moudle_base.utils.ViewUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.InnerHolder> {

    private List<ImageItem> mImageItemList = new ArrayList<>();

    private List<ImageItem> mSelectItem = new ArrayList<>();
    private OnItemSelectedChangeListener mItemSelectedItemListener = null;
    private static final int MAX_SELECTED_COUNT = 9;
    private int maxSelectedCount = MAX_SELECTED_COUNT;

    public List<ImageItem> getSelectItem() {
        return mSelectItem;
    }

    public int getMaxSelectedCount() {
        return maxSelectedCount;
    }

    public void setMaxSelectedCount(int maxSelectedCount) {
        this.maxSelectedCount = maxSelectedCount;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载itemView
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.moduleucenter_adapter_image_list_item, parent, false);
        Point point = UIUtils.getScreenSize(inflate.getContext());

//        inflate.getContext().getSystemService(Context.AAA);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(point.x / 3, point.x / 3);
        inflate.setLayoutParams(layoutParams);
        return new InnerHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //绑定数据
        Log.d("test", "onBindViewHolder: mImageItemList.get(position).getPath() = "+mImageItemList.get(position).getPath());
        View itemView = holder.itemView;
        final ImageView imageView = itemView.findViewById(R.id.image_id);
        final CheckBox checkBox = itemView.findViewById(R.id.image_check_box);
//        Glide.with(imageView.getContext()).load("https://cn.bing.com/images/search?view=detailV2&ccid=kmyzz5TL&id=E0DDFA2BAB712C29487FE479C9AC9BE68AF0D5A0&thid=OIP.kmyzz5TLJBpV7SW8nwVT1AHaE8&mediaurl=https%3a%2f%2fupload-images.jianshu.io%2fupload_images%2f411304-4134eca06d86f137.jpg&exph=800&expw=1200&q=%e7%8c%ab%e5%92%aa%e6%91%84%e5%bd%b1&simid=608044426198133911&FORM=IRPRST&ck=FF527FE18A8AF36A88BBBDF32A1EA5AE&selectedIndex=0&ajaxhist=0&ajaxserp=0").into(imageView);
        ImageItem imageItem = mImageItemList.get(position);
        final View cover = itemView.findViewById(R.id.image_cover);
        checkBox.setClickable(false);
        Glide.with(imageView.getContext()).load(imageItem.getPath()).into(imageView);

        //根据数据状态显示内容
        if (mSelectItem.contains(imageItem)){
            //没选择
            mSelectItem.add(imageItem);
            checkBox.setChecked(true);
            checkBox.setButtonDrawable(imageView.getContext().getDrawable(R.mipmap.ic_select));
            cover.setVisibility(View.VISIBLE);
        }else {
            //已经选择上了
            mSelectItem.remove(imageItem);
            checkBox.setChecked(false);
            checkBox.setButtonDrawable(imageView.getContext().getDrawable(R.mipmap.select_un));
            cover.setVisibility(View.GONE);
        }

        itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                //是否选择上
                //如果选择上就变成取消，没选择上的化就选上
                if (mSelectItem.contains(imageItem)){
                    //已经选择上了，应该取消选择
                    mSelectItem.remove(imageItem);
                    checkBox.setChecked(false);
                    checkBox.setButtonDrawable(imageView.getContext().getDrawable(R.mipmap.select_un));
                    cover.setVisibility(View.GONE);
                }else {
                    if (mSelectItem.size()>=maxSelectedCount){
                        Toast.makeText(itemView.getContext(),"最多可以选择"+maxSelectedCount+"张图",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //没选择，应该选择
                    mSelectItem.add(imageItem);
                    checkBox.setChecked(true);
                    checkBox.setButtonDrawable(imageView.getContext().getDrawable(R.mipmap.ic_select));
                    cover.setVisibility(View.VISIBLE);
                }
                if (mItemSelectedItemListener != null) {
                    mItemSelectedItemListener.onItemSelectedChange(mSelectItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageItemList.size();
    }

    public void setData(List<ImageItem> imageItems) {
        mImageItemList.clear();
        mImageItemList.addAll(imageItems);
        notifyDataSetChanged();
        Log.d("TAG", "setData: "+mImageItemList.toString());
        Log.d("TAG", "setData: "+mImageItemList.size());
    }

    public void setOnItemSelectedChangeListener(OnItemSelectedChangeListener listener){
        this.mItemSelectedItemListener = listener;
    }

    public void release() {
        mSelectItem.clear();
    }

    public interface OnItemSelectedChangeListener{
        void onItemSelectedChange(List<ImageItem> selectedItems);
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
