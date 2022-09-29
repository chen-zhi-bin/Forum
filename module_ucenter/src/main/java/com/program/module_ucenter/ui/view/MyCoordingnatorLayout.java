package com.program.module_ucenter.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.program.lib_base.LogUtils;

public class MyCoordingnatorLayout extends CoordinatorLayout {
    private OnScrollListListener mListener = null;

    public MyCoordingnatorLayout(@NonNull Context context) {
        this(context,null);
    }

    public MyCoordingnatorLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyCoordingnatorLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        super.onNestedPreScroll(target, dx, dy, consumed, type);
//        LogUtils.d("scrollY","onNestedPreScroll");
        //第一个子view到顶的距离
        int currentTop = getChildAt(0).getTop();
        // currentTop 最大值是0
        // 向上滚动  值变小
        // 向下滚动  值变大直到0
        if (mListener != null) {
            mListener.onScroll(currentTop);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    @Override
    protected int computeVerticalScrollOffset() {
        int i = super.computeVerticalScrollOffset();
        LogUtils.d("scrollY2222","===="+i);
        return i;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        float y = ev.getY();
//        LogUtils.d("test","y=="+y);
//        if (action==MotionEvent.ACTION_DOWN){
//            return false;
//        }else {
//            return true;
//        }
//        return false;
        return super.onInterceptTouchEvent(ev);
    }

    public void setOnScrollListListener(OnScrollListListener listListener){
        this.mListener = listListener;
    }


    public interface OnScrollListListener{
        void onScroll(int scrollY);
    }

}
