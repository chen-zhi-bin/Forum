package com.program.lib_common;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.text.Html;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

/**
 * TextView显示HTML的图片
 */
public class HtmlImageGetter implements Html.ImageGetter {
    private final TextView mTextView;

    public HtmlImageGetter(TextView textView) {
        this.mTextView = textView;
    }

    @Override
    public Drawable getDrawable(String s) {
        //在getDrawable中的source就是 img标签里src的值也就是图片的路径
        LevelListDrawable drawable = new LevelListDrawable();
        CustomTarget<Bitmap> target = new CustomTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(mTextView.getResources(), resource);
                drawable.addLevel(1,1,bitmapDrawable);
                drawable.setBounds(0,0,resource.getWidth(),resource.getHeight());
                drawable.setLevel(1);
                mTextView.invalidate();
                mTextView.setText(mTextView.getText());//解决图文重叠
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {

            }
        };

        Glide.with(mTextView.getContext())
                .asBitmap()
                .load(s)
                .into(target);
        return drawable;
    }

}
