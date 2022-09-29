package com.program.moudle_base.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageUtils {

    /**
     * 设置View的高度
     */
    public static View setViewWidth(ImageView view,int width){
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams==null){
            layoutParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                    );
        }
        layoutParams.width=width;
        view.setLayoutParams(layoutParams);
        return view;
    }

    /**
     * 设置View的宽度
     */
    public static View setViewHeight(ImageView view, int width) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams==null){
            layoutParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
        }
        layoutParams.height=width;
        view.setLayoutParams(layoutParams);
        return view;
    }
}
