package com.program.lib_common;

import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class CommonViewUtils {

    public static void setHtml(TextView tvContent,String content){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N){
            Spanned spanned = Html.fromHtml(content, Html.FROM_HTML_MODE_LEGACY, new HtmlImageGetter(tvContent), null);
            tvContent.setText(spanned);
        }else {
            tvContent.setText(Html.fromHtml(content));
        }
    }
}
