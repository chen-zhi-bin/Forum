package com.program.module_home.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class ArticleDetailBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取成功
     * data : {"id":"1579661926751801346","title":"水一篇文章，AOSP的，按键控制拍照","userId":"1153952789488054272","categoryId":"1161256637437153280","categoryName":"安卓/iOS","contentType":"0","content":"<h1>最近忙得很<\/h1>\n<p>公司裁员，然后合并事业部，最近忙得很。最终还是没有把我裁掉，没能如愿，只能辞职了。辞职的话就不有赔偿了。<\/p>\n<p>合并以后，已经打乱了我的节奏了。同学们应该也发现，我很少有发动态有更新内容了，实在是忙呀。<\/p>\n<p>计划是15号辞职，一个月后走人。什么年假呀，13薪就不要了。<\/p>\n<h1>正题<\/h1>\n<p>客户需要一个功能，在相机界面的时候，按下power按键，进行拍照，而不是熄屏。<\/p>\n<p>同样的，另外一个客户是需要在拍照界面按power按键不能熄屏，因为熄屏录制是违法行为嗷。<\/p>\n<p>怎么实现呢？<\/p>\n<h1>思路<\/h1>\n<p>首先，按键处理，我们在PhoneWindowManager里修改。<\/p>\n<p>思路就是，当我们知道相机现在是活跃的，那么我们就把这个power按键转成音量减按键。<\/p>\n<p>同学们都知道吧，android原生相机按音量减按键是会拍照的<\/p>\n<p>问题点来了，怎么知道相机的状态呢 ？<\/p>\n<p>这里就涉及到一个通讯的问题了，我们可以用广播，用AIDL，可以用内容提供者，也可以用属性值。<\/p>\n<p>这里面我使用属性值比较方便。但是，属性值的写入，有权限限制，因此我不在应用层的调用去修改状态。<\/p>\n<p>而是在frameworks层去更新相机的状态。<\/p>\n<h1>实现<\/h1>\n<ul>\n<li>相机状态变更<\/li>\n<li>按键转换<\/li>\n<\/ul>\n<h2>相机状态变更<\/h2>\n<p>我打算在<code>frameworks/base/services/core/java/com/android/server/camera<\/code>目录下的<code>CameraServiceProxy.java<\/code><\/p>\n<pre><code class=\"language-java\">private final ICameraServiceProxy.Stub mCameraServiceProxy = new ICameraServiceProxy.Stub() {\n\t@Override\n\tpublic void pingForUserUpdate() {\n\t\tnotifySwitchWithRetries(30);\n\t}\n\n\t@Override\n\tpublic void notifyCameraState(String cameraId, int newCameraState, int facing,\n\t\t\tString clientName) {\n\t\tString state = cameraStateToString(newCameraState);\n\t\tString facingStr = cameraFacingToString(facing);\n\t\tSlog.v(TAG, &quot;Camera &quot; + cameraId + &quot; facing &quot; + facingStr + &quot; state now &quot; +\n\t\t\t\tstate + &quot; for client &quot; + clientName);\n\t\t//对状态进行判断，然后修改状态即可\n\t\tif(&quot;CAMERA_STATE_OPEN&quot;.equals(state)){\n\t\t\tSystemProperties.set(&quot;persist.sys.camera_state&quot;,&quot;1&quot;);\n\t\t}else if(&quot;CAMERA_STATE_CLOSED&quot;.equals(state)){\n\t\t\tSystemProperties.set(&quot;persist.sys.camera_state&quot;,&quot;0&quot;);\n\t\t}\n\t\tupdateActivityCount(cameraId, newCameraState, facing, clientName);\n\t}\n};\n<\/code><\/pre>\n<p>我修改了这个属性值<code>persist.sys.camera_state<\/code><\/p>\n<p>如果相机打开了，那么就修改为1，否则就为0<\/p>\n<h2>处理按键<\/h2>\n<p>状态有变化了，那么我们在<code>PhoneWindowManager.java<\/code>里处理按键事件<\/p>\n<p><code>frameworks/base/services/core/java/com/android/server/policy/PhoneWindowManager.java<\/code><\/p>\n<p>低版本的可能在其他目录，自己搜索一下就能找到。<\/p>\n<pre><code class=\"language-java\">private void powerPress(long eventTime, boolean interactive, int count) {\n\tif (mScreenOnEarly &amp;&amp; !mScreenOnFully) {\n\t\tSlog.i(TAG, &quot;Suppressed redundant power key press while &quot;\n\t\t\t\t+ &quot;already in the process of turning the screen on.&quot;);\n\t\treturn;\n\t}\n\t\n\tBackToLaunchFactoryTest=false;\n\tif (count == 2) {\n\t\tpowerMultiPressAction(eventTime, interactive, mDoublePressOnPowerBehavior);\n\t} else if (count == 3) {\n\t\tpowerMultiPressAction(eventTime, interactive, mTriplePressOnPowerBehavior);\n\t} else if (count == 6) {\n\t\tBackToLaunchFactoryTest=true;\n\t\tBackToLaunchFactoryTest_time=eventTime;\n\t\t//launchFactoryTest(0);\n\t} else if (interactive &amp;&amp; !mBeganFromNonInteractive) {\n\t\tString topActivity = getTopActivity();\n\t\tString isCameraOpen = SystemProperties.get(&quot;persist.sys.camera_state&quot;,&quot;idel&quot;);\n\t\tSlog.d(TAG,&quot;isCameraOpen ==&gt; &quot; + isCameraOpen);\n\t\t//如果当前是相机界面，打开相机\n\t\tSlog.d(TAG,&quot;topActivity ====&gt; &quot; + topActivity);\n\t\tif(&quot;com.android.camera.CameraActivity&quot;.equals(topActivity)||\n\t\t&quot;com.android.camera.CameraLauncher&quot;.equals(topActivity)||\n\t\t\t&quot;com.boll.wrongquescard.ui.TakePhotoActivity&quot;.equals(topActivity)||\n\t\t&quot;1&quot;.equals(isCameraOpen)){\n\t\t\t//拍照\n\t\t\tSlog.d(TAG,&quot;拍照吧，皮卡丘....&quot;);\n\t\t\t//转成25号按键，就可以拍照\n\t\t\ttry{\n\t\t\t\tInstrumentation inst = new Instrumentation();\n\t\t\t\tinst.sendKeyDownUpSync(KeyEvent.KEYCODE_VOLUME_DOWN);\n\t\t\t}catch (Exception e) {\n\t\t\t\t Log.e(&quot;Exception when onBack&quot;, e.toString());\n\t\t\t }\n\t\t\treturn;\n\t\t}\n\t\tswitch (mShortPressOnPowerBehavior) {\n\t\t\tcase SHORT_PRESS_POWER_NOTHING:\n\t\t\t\tbreak;\n\t\t\tcase SHORT_PRESS_POWER_GO_TO_SLEEP:\n\t\t\t\tgoToSleep(eventTime, PowerManager.GO_TO_SLEEP_REASON_POWER_BUTTON, 0);\n\t\t\t\tbreak;\n\t\t\tcase SHORT_PRESS_POWER_REALLY_GO_TO_SLEEP:\n\t\t\t\tgoToSleep(eventTime, PowerManager.GO_TO_SLEEP_REASON_POWER_BUTTON,\n\t\t\t\t\t\tPowerManager.GO_TO_SLEEP_FLAG_NO_DOZE);\n\t\t\t\tbreak;\n\t\t\tcase SHORT_PRESS_POWER_REALLY_GO_TO_SLEEP_AND_GO_HOME:\n\t\t\t\tgoToSleep(eventTime, PowerManager.GO_TO_SLEEP_REASON_POWER_BUTTON,\n\t\t\t\t\t\tPowerManager.GO_TO_SLEEP_FLAG_NO_DOZE);\n\t\t\t\tlaunchHomeFromHotKey();\n\t\t\t\tbreak;\n\t\t\tcase SHORT_PRESS_POWER_GO_HOME:\n\t\t\t\tshortPressPowerGoHome();\n\t\t\t\tbreak;\n\t\t\tcase SHORT_PRESS_POWER_CLOSE_IME_OR_GO_HOME: {\n\t\t\t\tif (mDismissImeOnBackKeyPressed) {\n\t\t\t\t\tif (mInputMethodManagerInternal == null) {\n\t\t\t\t\t\tmInputMethodManagerInternal =\n\t\t\t\t\t\t\t\tLocalServices.getService(InputMethodManagerInternal.class);\n\t\t\t\t\t}\n\t\t\t\t\tif (mInputMethodManagerInternal != null) {\n\t\t\t\t\t\tmInputMethodManagerInternal.hideCurrentInputMethod();\n\t\t\t\t\t}\n\t\t\t\t} else {\n\t\t\t\t\tshortPressPowerGoHome();\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t}\n\t\t}\n\t}\n\n\tSlog.i(TAG, &quot;powerkey BackToLaunchFactoryTest &quot;+BackToLaunchFactoryTest);\n}\n<\/code><\/pre>\n<p>看我注释就知道了，如果是相机打开了，直接把按键转成<code>KeyEvent.KEYCODE_VOLUME_DOWN<\/code><\/p>\n<p><code>Instrumentation<\/code>注意导包<\/p>\n<pre><code class=\"language-java\">import android.app.Instrumentation;\n<\/code><\/pre>\n<p>okay，到这里就可以完成这个功能了。<\/p>\n<p>重点是思路，避开权限，通讯选择简单的属性值。<\/p>\n<p>一边是写入状态，一边是读取状态。<\/p>\n<p>还有就是按键转换。<\/p>\n<h1>拍照输出<\/h1>\n<pre><code class=\"language-shell\">keycode is == &gt; 26\nis down == &gt; false\nReceive Input KeyEvent of Powerkey up, interactive=true\nisCameraOpen ==&gt; 1\ntopActivity ====&gt; com.android.camera.CameraActivity\n拍照吧，皮卡丘....\nkeycode is == &gt; 25\nis down == &gt; true\nkeycode is == &gt; 25\nis down == &gt; false\n<\/code><\/pre>\n<p>状态是对的<\/p>\n<p>当我退出拍照界面时的日志输出<\/p>\n<pre><code class=\"language-shell\">keycode is == &gt; 26\nis down == &gt; false\nReceive Input KeyEvent of Powerkey up, interactive=true\nisCameraOpen ==&gt; 0\ntopActivity ====&gt; com.android.launcher3.Launcher\nStarted going to sleep... (why=2)\n<\/code><\/pre>\n<p>到此，拍照也是成功的。<\/p>\n","createTime":"2022-10-11 11:29","labels":["拍照","按键","power","安卓","AOSP"],"viewCount":178,"thumbUp":9,"recommend":0,"covers":["https://images.sunofbeaches.com/content/2022_10_11/1029355071311183872.png"],"articleType":"0","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","isVip":"0","nickname":"拉大锯","isTop":"0","isComment":"0","state":"0"}
     */

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataBean data;

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DataBean getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ArticleDetailBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * id : 1579661926751801346
         * title : 水一篇文章，AOSP的，按键控制拍照
         * userId : 1153952789488054272
         * categoryId : 1161256637437153280
         * categoryName : 安卓/iOS
         * contentType : 0
         * content : <h1>最近忙得很</h1>
         <p>公司裁员，然后合并事业部，最近忙得很。最终还是没有把我裁掉，没能如愿，只能辞职了。辞职的话就不有赔偿了。</p>
         <p>合并以后，已经打乱了我的节奏了。同学们应该也发现，我很少有发动态有更新内容了，实在是忙呀。</p>
         <p>计划是15号辞职，一个月后走人。什么年假呀，13薪就不要了。</p>
         <h1>正题</h1>
         <p>客户需要一个功能，在相机界面的时候，按下power按键，进行拍照，而不是熄屏。</p>
         <p>同样的，另外一个客户是需要在拍照界面按power按键不能熄屏，因为熄屏录制是违法行为嗷。</p>
         <p>怎么实现呢？</p>
         <h1>思路</h1>
         <p>首先，按键处理，我们在PhoneWindowManager里修改。</p>
         <p>思路就是，当我们知道相机现在是活跃的，那么我们就把这个power按键转成音量减按键。</p>
         <p>同学们都知道吧，android原生相机按音量减按键是会拍照的</p>
         <p>问题点来了，怎么知道相机的状态呢 ？</p>
         <p>这里就涉及到一个通讯的问题了，我们可以用广播，用AIDL，可以用内容提供者，也可以用属性值。</p>
         <p>这里面我使用属性值比较方便。但是，属性值的写入，有权限限制，因此我不在应用层的调用去修改状态。</p>
         <p>而是在frameworks层去更新相机的状态。</p>
         <h1>实现</h1>
         <ul>
         <li>相机状态变更</li>
         <li>按键转换</li>
         </ul>
         <h2>相机状态变更</h2>
         <p>我打算在<code>frameworks/base/services/core/java/com/android/server/camera</code>目录下的<code>CameraServiceProxy.java</code></p>
         <pre><code class="language-java">private final ICameraServiceProxy.Stub mCameraServiceProxy = new ICameraServiceProxy.Stub() {
        @Override public void pingForUserUpdate() {
        notifySwitchWithRetries(30);
        }

        @Override public void notifyCameraState(String cameraId, int newCameraState, int facing,
        String clientName) {
        String state = cameraStateToString(newCameraState);
        String facingStr = cameraFacingToString(facing);
        Slog.v(TAG, &quot;Camera &quot; + cameraId + &quot; facing &quot; + facingStr + &quot; state now &quot; +
        state + &quot; for client &quot; + clientName);
        //对状态进行判断，然后修改状态即可
        if(&quot;CAMERA_STATE_OPEN&quot;.equals(state)){
        SystemProperties.set(&quot;persist.sys.camera_state&quot;,&quot;1&quot;);
        }else if(&quot;CAMERA_STATE_CLOSED&quot;.equals(state)){
        SystemProperties.set(&quot;persist.sys.camera_state&quot;,&quot;0&quot;);
        }
        updateActivityCount(cameraId, newCameraState, facing, clientName);
        }
        };
         </code></pre>
         <p>我修改了这个属性值<code>persist.sys.camera_state</code></p>
         <p>如果相机打开了，那么就修改为1，否则就为0</p>
         <h2>处理按键</h2>
         <p>状态有变化了，那么我们在<code>PhoneWindowManager.java</code>里处理按键事件</p>
         <p><code>frameworks/base/services/core/java/com/android/server/policy/PhoneWindowManager.java</code></p>
         <p>低版本的可能在其他目录，自己搜索一下就能找到。</p>
         <pre><code class="language-java">private void powerPress(long eventTime, boolean interactive, int count) {
         if (mScreenOnEarly &amp;&amp; !mScreenOnFully) {
         Slog.i(TAG, &quot;Suppressed redundant power key press while &quot;
         + &quot;already in the process of turning the screen on.&quot;);
         return;
         }

         BackToLaunchFactoryTest=false;
         if (count == 2) {
         powerMultiPressAction(eventTime, interactive, mDoublePressOnPowerBehavior);
         } else if (count == 3) {
         powerMultiPressAction(eventTime, interactive, mTriplePressOnPowerBehavior);
         } else if (count == 6) {
         BackToLaunchFactoryTest=true;
         BackToLaunchFactoryTest_time=eventTime;
         //launchFactoryTest(0);
         } else if (interactive &amp;&amp; !mBeganFromNonInteractive) {
         String topActivity = getTopActivity();
         String isCameraOpen = SystemProperties.get(&quot;persist.sys.camera_state&quot;,&quot;idel&quot;);
         Slog.d(TAG,&quot;isCameraOpen ==&gt; &quot; + isCameraOpen);
         //如果当前是相机界面，打开相机
         Slog.d(TAG,&quot;topActivity ====&gt; &quot; + topActivity);
         if(&quot;com.android.camera.CameraActivity&quot;.equals(topActivity)||
         &quot;com.android.camera.CameraLauncher&quot;.equals(topActivity)||
         &quot;com.boll.wrongquescard.ui.TakePhotoActivity&quot;.equals(topActivity)||
         &quot;1&quot;.equals(isCameraOpen)){
         //拍照
         Slog.d(TAG,&quot;拍照吧，皮卡丘....&quot;);
         //转成25号按键，就可以拍照
         try{
         Instrumentation inst = new Instrumentation();
         inst.sendKeyDownUpSync(KeyEvent.KEYCODE_VOLUME_DOWN);
         }catch (Exception e) {
         Log.e(&quot;Exception when onBack&quot;, e.toString());
         }
         return;
         }
         switch (mShortPressOnPowerBehavior) {
         case SHORT_PRESS_POWER_NOTHING:
         break;
         case SHORT_PRESS_POWER_GO_TO_SLEEP:
         goToSleep(eventTime, PowerManager.GO_TO_SLEEP_REASON_POWER_BUTTON, 0);
         break;
         case SHORT_PRESS_POWER_REALLY_GO_TO_SLEEP:
         goToSleep(eventTime, PowerManager.GO_TO_SLEEP_REASON_POWER_BUTTON,
         PowerManager.GO_TO_SLEEP_FLAG_NO_DOZE);
         break;
         case SHORT_PRESS_POWER_REALLY_GO_TO_SLEEP_AND_GO_HOME:
         goToSleep(eventTime, PowerManager.GO_TO_SLEEP_REASON_POWER_BUTTON,
         PowerManager.GO_TO_SLEEP_FLAG_NO_DOZE);
         launchHomeFromHotKey();
         break;
         case SHORT_PRESS_POWER_GO_HOME:
         shortPressPowerGoHome();
         break;
         case SHORT_PRESS_POWER_CLOSE_IME_OR_GO_HOME: {
         if (mDismissImeOnBackKeyPressed) {
         if (mInputMethodManagerInternal == null) {
         mInputMethodManagerInternal =
         LocalServices.getService(InputMethodManagerInternal.class);
         }
         if (mInputMethodManagerInternal != null) {
         mInputMethodManagerInternal.hideCurrentInputMethod();
         }
         } else {
         shortPressPowerGoHome();
         }
         break;
         }
         }
         }

         Slog.i(TAG, &quot;powerkey BackToLaunchFactoryTest &quot;+BackToLaunchFactoryTest);
         }
         </code></pre>
         <p>看我注释就知道了，如果是相机打开了，直接把按键转成<code>KeyEvent.KEYCODE_VOLUME_DOWN</code></p>
         <p><code>Instrumentation</code>注意导包</p>
         <pre><code class="language-java">import android.app.Instrumentation;
         </code></pre>
         <p>okay，到这里就可以完成这个功能了。</p>
         <p>重点是思路，避开权限，通讯选择简单的属性值。</p>
         <p>一边是写入状态，一边是读取状态。</p>
         <p>还有就是按键转换。</p>
         <h1>拍照输出</h1>
         <pre><code class="language-shell">keycode is == &gt; 26
         is down == &gt; false
         Receive Input KeyEvent of Powerkey up, interactive=true
         isCameraOpen ==&gt; 1
         topActivity ====&gt; com.android.camera.CameraActivity
         拍照吧，皮卡丘....
         keycode is == &gt; 25
         is down == &gt; true
         keycode is == &gt; 25
         is down == &gt; false
         </code></pre>
         <p>状态是对的</p>
         <p>当我退出拍照界面时的日志输出</p>
         <pre><code class="language-shell">keycode is == &gt; 26
         is down == &gt; false
         Receive Input KeyEvent of Powerkey up, interactive=true
         isCameraOpen ==&gt; 0
         topActivity ====&gt; com.android.launcher3.Launcher
         Started going to sleep... (why=2)
         </code></pre>
         <p>到此，拍照也是成功的。</p>
         * createTime : 2022-10-11 11:29
         * labels : ["拍照","按键","power","安卓","AOSP"]
         * viewCount : 178
         * thumbUp : 9
         * recommend : 0
         * covers : ["https://images.sunofbeaches.com/content/2022_10_11/1029355071311183872.png"]
         * articleType : 0
         * avatar : https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png
         * isVip : 0
         * nickname : 拉大锯
         * isTop : 0
         * isComment : 0
         * state : 0
         */

        @SerializedName("id")
        private String id;
        @SerializedName("title")
        private String title;
        @SerializedName("userId")
        private String userId;
        @SerializedName("categoryId")
        private String categoryId;
        @SerializedName("categoryName")
        private String categoryName;
        @SerializedName("contentType")
        private String contentType;
        @SerializedName("content")
        private String content;
        @SerializedName("createTime")
        private String createTime;
        @SerializedName("viewCount")
        private Integer viewCount;
        @SerializedName("thumbUp")
        private Integer thumbUp;
        @SerializedName("recommend")
        private Integer recommend;
        @SerializedName("articleType")
        private String articleType;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("isVip")
        private String isVip;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("isTop")
        private String isTop;
        @SerializedName("isComment")
        private String isComment;
        @SerializedName("state")
        private String state;
        @SerializedName("labels")
        private List<String> labels;
        @SerializedName("covers")
        private List<String> covers;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getUserId() {
            return userId;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public String getContentType() {
            return contentType;
        }

        public String getContent() {
            return content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public Integer getViewCount() {
            return viewCount;
        }

        public Integer getThumbUp() {
            return thumbUp;
        }

        public Integer getRecommend() {
            return recommend;
        }

        public String getArticleType() {
            return articleType;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getIsVip() {
            return isVip;
        }

        public String getNickname() {
            return nickname;
        }

        public String getIsTop() {
            return isTop;
        }

        public String getIsComment() {
            return isComment;
        }

        public String getState() {
            return state;
        }

        public List<String> getLabels() {
            return labels;
        }

        public List<String> getCovers() {
            return covers;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", userId='" + userId + '\'' +
                    ", categoryId='" + categoryId + '\'' +
                    ", categoryName='" + categoryName + '\'' +
                    ", contentType='" + contentType + '\'' +
                    ", content='" + content + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", viewCount=" + viewCount +
                    ", thumbUp=" + thumbUp +
                    ", recommend=" + recommend +
                    ", articleType='" + articleType + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", isVip='" + isVip + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", isTop='" + isTop + '\'' +
                    ", isComment='" + isComment + '\'' +
                    ", state='" + state + '\'' +
                    ", labels=" + labels +
                    ", covers=" + covers +
                    '}';
        }
    }
}
