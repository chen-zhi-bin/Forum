package com.program.moudle_base.utils;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.program.lib_common.Constants;
import com.program.lib_common.HtmlImageGetter;
import com.program.lib_common.service.home.wrap.HomeServiceWrap;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.lib_common.service.wenda.wrap.WendaServiceWrap;
import com.program.moudle_base.R;
import com.program.moudle_base.base.BaseApplication;

import net.mikaelzero.mojito.Mojito;
import net.mikaelzero.mojito.MojitoBuilder;
import net.mikaelzero.mojito.MojitoView;
import net.mikaelzero.mojito.ext.MojitoViewExtKt;
import net.mikaelzero.mojito.impl.DefaultPercentProgress;
import net.mikaelzero.mojito.impl.NumIndicator;
import net.mikaelzero.mojito.interfaces.OnMojitoListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class CommonViewUtils {

    public static void setHtml(TextView tvContent,String content){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N){
            Spanned spanned = Html.fromHtml(content, Html.FROM_HTML_MODE_LEGACY, new HtmlImageGetter(tvContent), null);
            tvContent.setText(spanned);
        }else {
            tvContent.setText(Html.fromHtml(content));
        }
    }

    public static void showBigImage(RecyclerView recyclerView,@IdRes int viewId,List<String> pics,int position){

        MojitoViewExtKt.mojito(recyclerView, viewId, new Function1<MojitoBuilder, Unit>() {
            @Override
            public Unit invoke(MojitoBuilder mojitoBuilder) {
                mojitoBuilder.urls(pics);
                mojitoBuilder.position(position);
                Log.d("test","  MojitoViewExtKt.mojito() invoke");
                OnMojitoListener onMojitoListener = new OnMojitoListener() {
                    @Override
                    public void onStartAnim(int i) {
                        Log.d("test","setOnMojitoListener onStartAnim");
                    }

                    @Override
                    public void onClick(@NotNull View view, float v, float v1, int i) {
                        Log.d("CommonViewUtils","setOnMojitoListener onClick , view="+
                                view+"," +
                                "v="+v+
                                "v1="+v1+
                                "i="+i);
                    }

                    @Override
                    public void onLongClick(@Nullable FragmentActivity fragmentActivity, @NotNull View view, float v, float v1, int i) {
                        Log.d("test","setOnMojitoListener onLongClick");
                    }

                    @Override
                    public void onShowFinish(@NotNull MojitoView mojitoView, boolean b) {
                        Log.d("test","setOnMojitoListener onShowFinish");
                    }

                    @Override
                    public void onMojitoViewFinish(int i) {
                        Log.d("test","setOnMojitoListener onMojitoViewFinish");
                    }

                    @Override
                    public void onDrag(@NotNull MojitoView mojitoView, float v, float v1) {
                        Log.d("test","setOnMojitoListener onDrag");
                    }

                    @Override
                    public void onLongImageMove(float v) {
                        Log.d("test","setOnMojitoListener onLongImageMove");
                    }

                    @Override
                    public void onViewPageSelected(int i) {
                        Log.d("test","setOnMojitoListener onViewPageSelected");
                    }
                };
                mojitoBuilder.setOnMojitoListener(onMojitoListener);
                mojitoBuilder.progressLoader(DefaultPercentProgress::new);
                mojitoBuilder.setIndicator(new NumIndicator());
                return null;
            }
        });
    }

    public static void showBigImage(View view,String url){
        MojitoViewExtKt.mojito(view, url, new Function1<MojitoBuilder, Unit>() {
            @Override
            public Unit invoke(MojitoBuilder mojitoBuilder) {
                mojitoBuilder.setOnMojitoListener(new OnMojitoListener() {
                    @Override
                    public void onStartAnim(int i) {

                    }

                    @Override
                    public void onClick(@NotNull View view, float v, float v1, int i) {

                    }

                    @Override
                    public void onLongClick(@Nullable FragmentActivity fragmentActivity, @NotNull View view, float v, float v1, int i) {

                    }

                    @Override
                    public void onShowFinish(@NotNull MojitoView mojitoView, boolean b) {

                    }

                    @Override
                    public void onMojitoViewFinish(int i) {

                    }

                    @Override
                    public void onDrag(@NotNull MojitoView mojitoView, float v, float v1) {

                    }

                    @Override
                    public void onLongImageMove(float v) {

                    }

                    @Override
                    public void onViewPageSelected(int i) {

                    }
                });
                mojitoBuilder.progressLoader(DefaultPercentProgress::new);
                return null;
            }
        });
    }


    public static void setThumbStyle(TextView view,Boolean isThumb){
        if (isThumb){
            view.setTextColor(ContextCompat.getColor(view.getContext(), com.program.lib_common.R.color.colorPrimary));
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), com.program.lib_common.R.mipmap.ic_likes_checked);
            if (drawable != null) {
                drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
            }
            view.setCompoundDrawables(drawable,null,null,null);
        }else {
            view.setTextColor(ContextCompat.getColor(view.getContext(), com.program.lib_common.R.color.icon_color));
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), com.program.lib_common.R.mipmap.ic_likes);
            if (drawable != null) {
                if (drawable != null) {
                    drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
                }
                view.setCompoundDrawables(drawable,null,null,null);
            }
        }
    }




    /**
     *  关注信息
     * @param btn   控件
     * @param data  状态
     */
    //0表示没有关注对方，可以显示为：关注
    //1表示对方关注自己，可以显示为：回粉
    //2表示已经关注对方，可以显示为：已关注
    //3表示相互关注，可以显示为：相互关注
    public static void setFollowState(Button btn, Integer data) {
        switch (data){
            case 0:
                btn.setText("+ 关注");
                btn.setTag(0);
                btn.setTextColor(ContextCompat.getColor(btn.getContext(), R.color.white));
                btn.setBackgroundResource(R.drawable.blue_hollow_btn_selector);
                break;
            case 1:
                btn.setText("回粉");
                btn.setTag(1);
                btn.setTextColor(ContextCompat.getColor(btn.getContext(), R.color.white));
                btn.setBackgroundResource(R.drawable.red_solid_btn_selector);
                break;
            case 2:
                btn.setText("已关注");
                btn.setTag(2);
                btn.setTextColor(ContextCompat.getColor(btn.getContext(), R.color.white));
                btn.setBackgroundResource(R.drawable.green_solid_btn_selector);
                break;
            case 3:
                btn.setText("相互关注");
                btn.setTag(3);
                btn.setTextColor(ContextCompat.getColor(btn.getContext(), R.color.white));
                btn.setBackgroundResource(R.drawable.blue_solid_btn_selector);
                break;
        }
    }

    public static void toWebView(String url){
//        if (url.startsWith(Constants.WEBSITE_URL)){
//            String[] split = url.split("/");
//        }
        if (url.startsWith(Constants.UCENTER_URL)){
            String[] split = url.split("/");
            UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(split[split.length-1]);
        }else if (url.startsWith(Constants.WENDA_URL)){
            String[] split = url.split("/");
            WendaServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(split[split.length-1]);
        }else {

        }
    }
}
