package com.program.moudle_base.view;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class FixedHeightBottomSheetDialog extends BottomSheetDialog {

    private int fixedHeight;

    public FixedHeightBottomSheetDialog(@NonNull Context context, int theme,int fixedHeight) {
        super(context, theme);
        this.fixedHeight = fixedHeight;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPeekHeight(fixedHeight);
        setMaxHeight(fixedHeight);
    }

    private void setPeekHeight(int peekHeight) {
        if (peekHeight<0){
            return;
        }
        BottomSheetBehavior<View> bottomSheetBehavior = getBottomSheetBehavior();
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setPeekHeight(peekHeight);
        }
    }

    private void setMaxHeight(int maxHeight) {
        if (maxHeight<=0){
            return;
        }
        Window window = getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,maxHeight);
            window.setGravity(Gravity.BOTTOM);
            window.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        }
    }

    private BottomSheetBehavior<View> getBottomSheetBehavior(){
        Window window = getWindow();
        View view;
        view = window!=null?window.findViewById(com.google.android.material.R.id.design_bottom_sheet):null;
        BottomSheetBehavior bottomSheetBehavior;
        if (view != null) {
            bottomSheetBehavior = BottomSheetBehavior.from(view);
        }else {
            bottomSheetBehavior = null;
        }
        return bottomSheetBehavior;
    }
}
