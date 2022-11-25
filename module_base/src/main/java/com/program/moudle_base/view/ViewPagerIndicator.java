package com.program.moudle_base.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.program.lib_base.LogUtils;
import com.program.lib_common.UIUtils;
import com.program.moudle_base.R;


/**
 * ViewPager2的指示器
 */
public class ViewPagerIndicator extends View {

    private Context mContext;
    private ViewPager2 mViewPager2 = null;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private int largerWidth = 10;
    private int smallerWidth = 10;
    private int rectHeight = 4;
    private int interval = 10;
    private int dotsCount = 0;

    private int selectColor ;
    private int normalColor = Color.parseColor("#afdddddd");

    {
        mPaint.setStyle(Paint.Style.FILL);
        largerWidth = UIUtils.dp2px(7f);
        smallerWidth = UIUtils.dp2px(7f);
        rectHeight = UIUtils.dp2px(7f);
        interval = UIUtils.dp2px(10f);

    }

    public ViewPagerIndicator(Context context) {
        super(context,null);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        selectColor = ContextCompat.getColor(context, R.color.colorPrimary);
        TypedArray attr = context.getTheme().obtainStyledAttributes(attrs, R.styleable.indicator, defStyleAttr, 0);
        normalColor = attr.getColor(R.styleable.indicator_normalColor, normalColor);
        selectColor = attr.getColor(R.styleable.indicator_selectedColor, selectColor);
        attr.recycle();
    }


    public void setViewPager2(ViewPager2 viewPager2,int realCount) {
        mViewPager2 = viewPager2;
        dotsCount = realCount;
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                invalidate();
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (dotsCount>1){
            int width = (smallerWidth + interval) * (dotsCount - 1) + largerWidth;
            int height = rectHeight + 1;
            setMeasuredDimension(width,height);
        }else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RecyclerView.Adapter adapter = mViewPager2.getAdapter();
        if (adapter!=null){
            float startX = 0f;
            for (int i = 0; i < dotsCount; i++) {
                int realIndex = mViewPager2.getCurrentItem() % dotsCount;
                float thisWith;
                if (i == realIndex){
                    mPaint.setColor(R.color.colorAccent);
                    thisWith = largerWidth;
                }else {
                    mPaint.setColor(normalColor);
                    thisWith = smallerWidth;
                }

                float fromX = startX;
                float fromY = 0f;
                float toX = startX + thisWith;
                float toY = rectHeight;

                canvas.drawRoundRect(fromX,fromY,toX,toY,
                        (float) (rectHeight/2),(float)(rectHeight/2),mPaint);
                startX = toX+interval;

            }
        }
    }
}
