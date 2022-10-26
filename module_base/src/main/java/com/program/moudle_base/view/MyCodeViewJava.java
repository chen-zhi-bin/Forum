package com.program.moudle_base.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.program.moudle_base.model.ArticleTitleBean;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeFilter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import thereisnospon.codeview.CodeView;

public class MyCodeViewJava extends CodeView {

    private float oldY=0f;
    private float oldX=0f;
    private float newY=0f;
    private float newX=0f;

    public MyCodeViewJava(Context context) {
        this(context,null);
    }

    public MyCodeViewJava(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        getParent().getParent().requestDisallowInterceptTouchEvent(true);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                newX = event.getX();
                newY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //手指滑动同时判断滑动方向，一旦滑动方向大于+-60便调用
                //getParent().getParent().requestDisallowInterceptTouchEvent(false);
                //将滑动事件交给RecyclerView来处理
                oldX = newX;
                oldY = newY;
                newX = event.getX();
                newY = event.getY();
                float moveX = Math.abs(oldX - newX);
                float moveY = Math.abs(oldY - newY);
                //moveX * 1.73 < moveY  ,判断左右滑动范围为+-60度
                if (moveX * 1.73<moveY){
                    getParent().getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void showCode(String code) {
        showCodeHtmlByClass(getNewContent(code), "code");
    }

    private List<ArticleTitleBean> titleList = CollectionsKt.mutableListOf();

    public List<ArticleTitleBean> getTitleList(){
        return titleList;
    }

    private List<String> imageList = CollectionsKt.mutableListOf();

    public List<String> getImageList() {
        return imageList;
    }

    private void pareTitle(Elements all){
//        new Element().tag().getName().toLowerCase()

        List<Element> allHTag = CollectionsKt.filter(all, new Function1<Element, Boolean>() {
            @Override
            public Boolean invoke(Element element) {
                String s = element.tag().getName().toLowerCase();
                if (s.contains("h1")||s.contains("h2")||s.contains("h3")||s.contains("h4")){
                    return true;
                }else {
                    return false;
                }
//                ArrayList<String> strings = CollectionsKt.arrayListOf(new String[]{"h1", "h2", "h3", "h4"});
            }
        });

        for (Element element : allHTag) {
            Random random = new Random();
            String id = element.tag().getName() + random.nextInt();
            id = id.replace("-","");
            element.attr("id",id);
            switch (element.tag().getName().toLowerCase()){
                case "h1":
                    titleList.add(new ArticleTitleBean(id,element.text(),1));
                    break;
                case "h2":
                    titleList.add(new ArticleTitleBean(id,element.text(),2));
                    break;
                case "h3":
                    titleList.add(new ArticleTitleBean(id,element.text(),3));
                    break;
                case "h4":
                    titleList.add(new ArticleTitleBean(id,element.text(),4));
                    break;
            }
        }
    }

    private void paresImages(Elements imgs){
        int index = 0;
        for(Iterator var4 = ((Iterable)imgs).iterator(); var4.hasNext(); ++index) {
            Element element = (Element)var4.next();
            element.attr("style", "max-width:100%;height:auto;-webkit-backface-visibility: hidden;");
            element.attr("onclick", "javascript:native.showBigImage(" + index + ")");
            List list = this.imageList;
            String s = element.attr("src");
            Intrinsics.checkNotNullExpressionValue(s, "element.attr(\"src\")");
            list.add(s);
        }
    }

    /**
     * 修改html的样式
     */
    private String getNewContent(String htmlText) {

        try {
            String newHtml = htmlText.replace("<pre><code", "<my-block-code")
                    .replace("</code></pre>", "</my-block-code>")
                    .replace("<code", "<my-inline-code")
                    .replace("</code>", "</my-inline-code>")
                    .replace("<my-block-code", "<pre><code")
                    .replace("</my-block-code>", "</code></pre>")
                    .replace("language-language", "language-java")
                    .replace("language-shell", "language-java")
                    .replace("language-yaml", "language-java")
                    .replace("language-yml", "language-java");
            newHtml =  "<div style=\"line-height:2;font-size:14px;word-break:break-all;margin-bottom: 20px;\">"+newHtml+"</div>";
            Document doc = Jsoup.parse(newHtml);
            doc.head().append("\n<script src=\"file:///android_asset/scrollhelper.js\"></script>\n");
            pareTitle(doc.getAllElements());
            paresImages(doc.getElementsByTag("img"));

            Elements h1s = doc.getElementsByTag("h1");
            Iterator<Element> iteratorh1 = h1s.iterator();
            while (iteratorh1.hasNext()) {
                Element element = iteratorh1.next();
                element.attr("style", "font-size:18px");
            }
            Elements h2s = doc.getElementsByTag("h2");
            Iterator<Element> iteratorh2 = h2s.iterator();
            while (iteratorh2.hasNext()) {
                Element element = iteratorh2.next();
                element.attr("style", "font-size:17px");
            }
            Elements h3s = doc.getElementsByTag("h3");
            Iterator<Element> iteratorh3 = h3s.iterator();
            while (iteratorh3.hasNext()) {
                Element element = iteratorh3.next();
                element.attr("style", "font-size:16px");
            }
            Elements h4s = doc.getElementsByTag("h4");
            Iterator<Element> iteratorh4 = h4s.iterator();
            while (iteratorh4.hasNext()) {
                Element element = iteratorh4.next();
                element.attr("style", "font-size:15px");
            }
            Elements h5s = doc.getElementsByTag("h5");
            Iterator<Element> iteratorh5 = h5s.iterator();
            while (iteratorh5.hasNext()) {
                Element element = iteratorh5.next();
                element.attr("style", "font-size:15px");
            }
            Elements uls = doc.getElementsByTag("ul");
            Iterator<Element> iteratorUls = uls.iterator();
            while (iteratorUls.hasNext()) {
                Element element = iteratorUls.next();
                element.attr("style", "margin: 10px;border: 0;padding: 0;");
            }
            Elements ps = doc.getElementsByTag("p");
            Iterator<Element> iteratorPs = ps.iterator();
            while (iteratorPs.hasNext()) {
                Element element = iteratorPs.next();
                element.attr(
                        "style",
                        "padding:0;margin: 0;-webkit-margin-before: 0;-webkit-margin-after: 0;"
                );
            }
            Elements a = doc.getElementsByTag("a");
            Iterator<Element> iteratorA = a.iterator();
            while (iteratorA.hasNext()) {
                Element element = iteratorA.next();
                element.attr("style", "color:#0071E0");
            }
            Elements pres = doc.getElementsByTag("pre");
            Iterator<Element> iteratorPres = pres.iterator();
            while (iteratorPres.hasNext()) {
                Element element = iteratorPres.next();
                if (element.children().isEmpty()){
                    String text = element.text();
                    element.empty();
                    element.append("code").text(text);
                }
            }
            Elements codes = doc.getElementsByTag("code");
            Iterator<Element> iteratorCode = codes.iterator();
            while (iteratorCode.hasNext()) {
                Element element = iteratorCode.next();
                element.attr("style", "line-height:2;font-size:12px;");
            }
            Elements inlineCodes = doc.getElementsByTag("my-inline-code");
            Iterator<Element> iteratorInlineCodes = inlineCodes.iterator();
            while (iteratorInlineCodes.hasNext()) {
                Element element = iteratorInlineCodes.next();
                element.attr(
                        "style",
                        "background: #F7F7F7;font-size:12px;color:#FF502C;border-radius: 5px;padding:2px"
                );
            }
            //引用
            Elements blockquotes = doc.getElementsByTag("blockquote");
            Iterator<Element> iteratorBlockquotes = blockquotes.iterator();
            while (iteratorBlockquotes.hasNext()) {
                Element element = iteratorBlockquotes.next();
                element.attr(
                        "style",
                        "margin:0px 2px;border-left: 3px solid #0084ff;color: #7f828b;padding-left: 10px;background: #FCFAFA;"
                );
            }

            return doc.toString();
        }catch (Exception e){
            return htmlText;
        }
    }
}
