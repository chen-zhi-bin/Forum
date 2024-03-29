package com.program.module_home.ui.activity;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.lib_base.LogUtils;
import com.program.lib_base.StatusBarUtil;
import com.program.lib_common.Constants;
import com.program.lib_common.DateUtils;
import com.program.lib_common.RoutePath;
import com.program.lib_common.UIUtils;
import com.program.lib_common.event.UpdateItemEvent;
import com.program.lib_common.service.home.wrap.HomeServiceWrap;
import com.program.lib_common.service.ucenter.wrap.UcenterServiceWrap;
import com.program.module_home.R;
import com.program.module_home.callback.IArticleDetailCallback;
import com.program.module_home.model.bean.ArticleDetailBean;
import com.program.module_home.model.bean.ArticleRecommendBean;
import com.program.module_home.model.bean.CommentBean;
import com.program.module_home.model.bean.CommentInputBean;
import com.program.module_home.model.bean.PriseArticleInputBean;
import com.program.module_home.model.bean.SubCommentInputBean;
import com.program.module_home.presenter.IArticleDetailPresenter;
import com.program.module_home.ui.adapter.CollectFolderAdapter;
import com.program.module_home.ui.adapter.HomeDetailAdapter;
import com.program.module_home.utils.PresenterManager;
import com.program.moudle_base.adapter.CommonPriseAdapter;
import com.program.moudle_base.model.ArticleTitleBean;
import com.program.moudle_base.model.BaseResponseBean;
import com.program.moudle_base.model.CollectInputBean;
import com.program.moudle_base.model.CollectionBean;
import com.program.moudle_base.model.FollowBean;
import com.program.moudle_base.model.ImageItem;
import com.program.moudle_base.model.NewCollection;
import com.program.moudle_base.model.PriseQrCodeBean;
import com.program.moudle_base.model.PriseSobBean;
import com.program.moudle_base.model.TitleMultiBean;
import com.program.moudle_base.utils.CommonViewUtils;
import com.program.moudle_base.utils.EventBusUtils;
import com.program.moudle_base.utils.ImagePickerConfig;
import com.program.moudle_base.utils.SharedPreferencesUtils;
import com.program.moudle_base.utils.ToastUtils;
import com.program.moudle_base.view.FixedHeightBottomSheetDialog;
import com.program.moudle_base.view.MyCodeViewJava;
import com.program.moudle_base.view.ReplyBottomSheetDialog;
import com.program.moudle_base.view.WaitDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

import net.mikaelzero.mojito.Mojito;
import net.mikaelzero.mojito.loader.glide.GlideImageLoader;
import net.mikaelzero.mojito.view.sketch.SketchImageLoadFactory;

import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import kotlin.collections.CollectionsKt;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;

@Route(path = RoutePath.Home.PAGE_ARTICLE)
public class ArticleDetailActivity extends RxAppCompatActivity implements IArticleDetailCallback {

    private static final int MAX_SELECTED_COUNT = 1;
    @Autowired(name = "articleId")
    public String mArticleId;

    @Autowired(name = "articleTitle")
    public String mArticleTitle;

    //记录当前RecycleView 滚动的距离
    private int scrollY = 0;
    private int switchScrollY = 0;

    private ImageView mIvSwitch;
    private TextView mTvReplyNum;
    private TextView mTvStarNum;
    private HomeDetailAdapter mAdapter;
    private FixedHeightBottomSheetDialog mBottomSheetDialog;
    private FixedHeightBottomSheetDialog mBottomNewFolderSheetDialog = null;
    private ReplyBottomSheetDialog mReplyDialog;
    private MyCodeViewJava mCodeView;
    private RoundedImageView mIvHeaderAvatar;
    private IArticleDetailPresenter mArticleDetailPresenter;
    private ArticleDetailBean.DataBean mArticle;
    private TextView mTvTitle;
    private RoundedImageView mIvAvatar;
    private TextView mTvNickname;
    private TextView mTvPublishTime;
    private TextView mTvViewCount;
    private TextView mTvLabels;
    private TextView mTvPriseList;
    private TextView mTvHeaderNickname;
    private ImageView mIvQrUrl;
    private TextView mTvPriseTips;
    private RecyclerView mRvContent;
    private View mContentBinding;
    private ConstraintLayout mLayoutHeaderAvatar;
    private ConstraintLayout mLayoutHeader;
    private ArticleDetailActivity thisActivity = null;
    private TextView mTvHeaderFollow;
    private TextView mTvFollow;

    private  List<MultiItemEntity> mCommentList = CollectionsKt.mutableListOf();
    private TextView mTvReply;
    private String mToken;
    private ImageView mIvStar;
    private ImageView mIvList;
    private TextView mTvReward;
    private ImageView mIvCollection;
    private CollectFolderAdapter mCollectFolderAdapter = null;

    private int mNewFolderstate = 0;
    private ImageView mIvSwitchCover;
    private List<ImageItem> mSelectImage = new ArrayList<>();
    private RelativeLayout mIncludeBar;
    private WaitDialog mWaitDialog = null;
    private String mNewcollectionName;
    private String mNewCollectiondescription;
    private SmartRefreshLayout mRefreshCollection;

    @Subscribe
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulehome_activity_article_detail);
        ARouter.getInstance().inject(this);         //不添加会收不到信息
        Mojito.initialize(GlideImageLoader.Companion.with(this), new SketchImageLoadFactory()); //没有这个图片不会显示
        if (!EventBusUtils.INSTANCE.isRegistered(this)){
            EventBusUtils.INSTANCE.register(this);
        }
        LogUtils.d(ArticleDetailActivity.class, "id =" + mArticleId);
        LogUtils.d(ArticleDetailActivity.class, "title =" + mArticleTitle);
        mToken = SharedPreferencesUtils.getInstance(this).getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        thisActivity = this;
        initView();
        initStatusBar();
        initPresenter();
        initListener();
        initPickerConfig();
    }

    private void initStatusBar() {
        StatusBarUtil.immersive(this);
        StatusBarUtil.darkMode(this,true);
        StatusBarUtil.setPaddingSmart(this,mIncludeBar);
        StatusBarUtil.setPaddingSmart(this,mLayoutHeaderAvatar);
    }

    private void initPickerConfig() {
        ImagePickerConfig pickerConfig = ImagePickerConfig.getInstance();
        pickerConfig.setMaxSelectCount(MAX_SELECTED_COUNT);
        pickerConfig.setOnImageSelectFinishedListener(new ImagePickerConfig.OnImageSelectFinishedListener() {
            @Override
            public void onSelectedFinished(List<ImageItem> result) {
                mSelectImage.clear();
                mSelectImage.addAll(result);
                //显示选中的图片
                Glide.with(mIvSwitchCover.getContext())
                        .load(result.get(0).getPath())
                        .into(mIvSwitchCover);
            }
        });
    }

    private void initPresenter() {
        mArticleDetailPresenter = PresenterManager.getInstance().getArticleDetailPresenter();
        mArticleDetailPresenter.registerViewCallback(this);
        mArticleDetailPresenter.getArticleDetail(mArticleId);
        mArticleDetailPresenter.getArticleThumbUpState(mArticleId);
        mArticleDetailPresenter.getCheckCollectionState(mArticleId);
    }

    private void initListener() {
        mIvCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mArticleId) || TextUtils.isEmpty(mArticleTitle)){
                    return;
                }
                Object tag = mIvCollection.getTag();
                if (tag instanceof String &&(!TextUtils.isEmpty(tag.toString()))){
                    unFavorite(tag.toString());
                    return;
                }
                getCollectFolder();
            }
        });
        mTvPriseList.setOnClickListener(view -> HomeServiceWrap.Singletion.INSTANCE.getHolder().launchPriseActivityList(mArticleId));
        mTvReward.setOnClickListener(view -> showPriseDialog());
        mIvSwitch.setOnClickListener(view -> {
            int tag = (int) mIvSwitch.getTag();
            if (tag == 1){
                mIvSwitch.setImageResource(R.mipmap.ic_detail_reply);
                mRvContent.scrollToPosition(0);
                mTvReplyNum.setVisibility(View.VISIBLE);
                mIvSwitch.setTag(0);
            }else {
                switchScrollY = scrollY;
                mIvSwitch.setImageResource(R.mipmap.ic_detail_back);
                mRvContent.scrollToPosition(2);
                mTvReplyNum.setVisibility(View.GONE);
                mIvSwitch.setTag(1);
            }
        });
        mIvList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showContentList();
            }
        });

        mIvStar.setOnClickListener(view -> {
//            Object tag = mTvStarNum.getTag();
//            if (tag.equals("yes")){
//                return;
//            }
            thumbUp();
        });
//        EventBusUtils.INSTANCE.postEvent(new UpdateItemEvent(UpdateItemEvent.Event.UPDATE_ARTICLE,mArticleId));
        mIvHeaderAvatar.setOnClickListener(view -> {
            if (mArticle != null) {
                UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(mArticle.getUserId());
            }
        });

        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                int id = view.getId();
                if (id == R.id.tv_related_nickname || id == R.id.iv_related_avatar) {
                    ArticleRecommendBean.DataBean recommend = (ArticleRecommendBean.DataBean) adapter.getItem(position);
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(recommend.getUserId());
                }else if (id==R.id.tv_comment_nickname||id==R.id.iv_comment_avatar){
                    CommentBean.DataBean.ContentBean comment = (CommentBean.DataBean.ContentBean) adapter.getItem(position);
                    UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(comment.getUserId());
                }else if (id==R.id.iv_comment_reply){
                    CommentBean.DataBean.ContentBean comment = (CommentBean.DataBean.ContentBean) adapter.getItem(position);
                    showReplyDialog(comment);
                }
            }
        });

        mTvReply.setOnClickListener(view -> {
            showReplyDialog(null);
        });

        mTvFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0) || view.getTag().equals(1)) {
                    follow(mArticle.getUserId());
                } else {
                    unfollow(mArticle.getUserId());
                }
            }
        });

        mTvHeaderFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0) || view.getTag().equals(1)) {
                    follow(mArticle.getUserId());
                } else {
                    unfollow(mArticle.getUserId());
                }
            }
        });

        mRvContent.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                scrollY += dy;
                // 标题栏显示头像，隐藏标题
                if (scrollY >= mLayoutHeader.getHeight()) {
                    mLayoutHeaderAvatar.setVisibility(View.VISIBLE);
                    mTvTitle.setVisibility(View.GONE);
                    mLayoutHeaderAvatar.setAlpha(
                            1f * (scrollY - mLayoutHeader.getHeight()) / mLayoutHeader.getHeight()
                    );
                } else {
                    mLayoutHeaderAvatar.setVisibility(View.GONE);
                    mTvTitle.setVisibility(View.VISIBLE);
                    mTvTitle.setAlpha(
                            1f * (mLayoutHeader.getHeight() - scrollY) / mLayoutHeader.getHeight()
                    );
                }
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        //处于静止状态时，继续加载图片
                        if (!((thisActivity.isDestroyed())) && !(thisActivity.isFinishing())) {
                            Glide.with(getApplicationContext()).resumeRequests();
                        }
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        //处于滑动状态时，停止加载图片，保证操作界面流畅
                        if (!(thisActivity.isDestroyed()) && !(thisActivity).isFinishing()) {
                            Glide.with(getApplicationContext()).pauseRequests();
                        }
                        break;
                }
                super.onScrollStateChanged(recyclerView, newState);

            }
        });
    }

    /**
     * 获取收藏夹
     */
    private void getCollectFolder() {
        showCollectionFolder();
        mCollectFolderAdapter = showCollectionFolder();
        mArticleDetailPresenter.getCollectionList();
    }

    private CollectFolderAdapter showCollectionFolder() {
        if (mToken == null||mToken.equals("")) {
            ARouter.getInstance()
                    .build(RoutePath.Login.PATH_lOGIN)
                    .navigation();
            return null;
        }
        initNewFolderSheetDialog();
        LayoutInflater from = LayoutInflater.from(this);
        View inflate = from.inflate(R.layout.modulehome_home_dialog_collection_folder, null);
        TextView tvAdd = inflate.findViewById(R.id.tv_add);
        mRefreshCollection = inflate.findViewById(R.id.refresh_collection);
        RecyclerView rvFolder = inflate.findViewById(R.id.rv_folder);
        rvFolder.setLayoutManager(new LinearLayoutManager(this));
        CollectFolderAdapter adapter = new CollectFolderAdapter();
        rvFolder.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                int id = view.getId();
                if (id == R.id.tv_collect) {
                    Object item = adapter.getItem(position);
                    if (item instanceof CollectionBean.DataBean.ContentBean) {
                        favorite(
                                new CollectInputBean(
                                        ((CollectionBean.DataBean.ContentBean) item).getId(),
                                        mArticleTitle,
                                        Constants.WEBSITE_URL + mArticleId
                                )
                        );
                    }
                    mBottomSheetDialog.dismiss();
                }
            }
        });
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomNewFolderSheetDialog.show();
            }
        });
        mRefreshCollection.setEnableRefresh(false);
        mRefreshCollection.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mArticleDetailPresenter.getCollectionListMore();
            }
        });
        mBottomSheetDialog.setContentView(inflate);
        mBottomSheetDialog.show();
        return adapter;
    }

    //新建收藏集
    private void initNewFolderSheetDialog() {
        mBottomNewFolderSheetDialog = new FixedHeightBottomSheetDialog(
                this,
                R.style.BottomSheetDialog,
                UIUtils.getScreenHeeight() * 2 / 3);
        LayoutInflater from = LayoutInflater.from(this);
        View inflate = from.inflate(R.layout.modulehome_dialog_new_collection_folder, null);
        EditText etNickName = inflate.findViewById(R.id.et_nickname);
        EditText etDesc = inflate.findViewById(R.id.ed_desc);
//        TextView tvSwitchCover = inflate.findViewById(R.id.tv_switch_cover);
        mIvSwitchCover = inflate.findViewById(R.id.iv_switch_cover);
        RadioGroup radioGroup = inflate.findViewById(R.id.radio_btn_switch);
        TextView tvPut = inflate.findViewById(R.id.tv_put);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mNewFolderstate =( i==R.id.radio_button_public?0:1);
            }
        });
        mIvSwitchCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchImageSwitch(MAX_SELECTED_COUNT);
            }
        });
        tvPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //新建收藏夹

                mNewcollectionName = etNickName.getText().toString();
                mNewCollectiondescription = etDesc.getText().toString();

                if (mNewcollectionName.equals("")||mNewCollectiondescription.equals("")){
                    ToastUtils.showToast("收藏夹的名字或描述为空");
                    return;
                }
                //上传图片
                mArticleDetailPresenter.postCollectionImage(createPartByPathAndKet(mSelectImage.get(0).getPath(),"image"));

            }
        });
        mBottomNewFolderSheetDialog.setContentView(inflate);
    }

    private MultipartBody.Part createPartByPathAndKet(String path, String key) {
//        File file = new File(path);
//        RequestBody body = RequestBody.create(MediaType.parse("image/*"), file);
//        MultipartBody.Part part = MultipartBody.Part.createFormData(key, file.getName(), body);
//        return part;

        File file = new File(path);
        String[] split = path.split("\\.");
        RequestBody body = RequestBody.create(MediaType.parse("image/"+split[split.length-1]), file);
        MultipartBody.Part formData = MultipartBody.Part.createFormData(key, file.getName(), body);
        return formData;
    }

    /**
     * 收藏
     */
    private void favorite(CollectInputBean data) {
        mArticleDetailPresenter.favorite(data);
    }

    /**
     * 取消收藏
     */
    private void unFavorite(String favoriteId) {
        mArticleDetailPresenter.unFavorite(favoriteId);
    }

    private void showPriseDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View inflate = inflater.inflate(R.layout.modulebase_common_prise_dialog, null);
        mBottomSheetDialog.setContentView(inflate);
        mBottomSheetDialog.show();

        ImageView ivAvatar = inflate.findViewById(R.id.iv_avatar);
        Button btnPrise = inflate.findViewById(R.id.btn_prise);
        Glide.with(ivAvatar.getContext())
                .load(mArticle.getAvatar())
                .placeholder(com.program.moudle_base.R.drawable.shape_grey_background)
                .circleCrop()
                .into(ivAvatar);
        TextView tvNickname = inflate.findViewById(R.id.et_nickname);
        tvNickname.setText(mArticle.getNickname());
        inflate.findViewById(R.id.iv_close).setOnClickListener(view -> mBottomSheetDialog.dismiss());
        RecyclerView rvSob = inflate.findViewById(R.id.rv_sob);
        rvSob.setLayoutManager(new GridLayoutManager(this,3));
        CommonPriseAdapter priseAdapter = new CommonPriseAdapter();
        rvSob.setAdapter(priseAdapter);
        PriseSobBean selectItem = new PriseSobBean("",20,true);
        priseAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Object item = adapter.getItem(position);
                PriseSobBean data = (PriseSobBean) item;
                selectItem.setLabel(data.getLabel());
                selectItem.setValue(data.getValue());
                selectItem.setChecked(data.isChecked());
                List<PriseSobBean> beanList = priseAdapter.getData();
                Iterator<PriseSobBean> iterator = beanList.iterator();
                while (iterator.hasNext()) {
                    PriseSobBean next = iterator.next();
                    next.setChecked(selectItem.getValue()==next.getValue());
                }
                priseAdapter.notifyDataSetChanged();
            }
        });
        btnPrise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mArticleDetailPresenter.priseArticle(new PriseArticleInputBean(mArticleId,selectItem.getValue()));
                mBottomSheetDialog.dismiss();
            }
        });
    }

    /**
     * 显示目录
     */
    @SuppressLint("SetJavaScriptEnabled")
    private void showContentList() {
        mCodeView.getSettings().setJavaScriptEnabled(true);
        List<ArticleTitleBean> titleList = mCodeView.getTitleList();
        LogUtils.d("ArticleDetailActivity","titleList = "+titleList.toString());
        LayoutInflater inflater = LayoutInflater.from(this);
        View inflate = inflater.inflate(R.layout.modulehome_dialog_content_list, null);
        inflate.findViewById(R.id.iv_close).setOnClickListener(view -> finish());
        RecyclerView rvList = inflate.findViewById(R.id.rv_list);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        BaseQuickAdapter<ArticleTitleBean, BaseViewHolder> adapter = new BaseQuickAdapter<ArticleTitleBean, BaseViewHolder>(
                R.layout.modulehome_dialog_adapter_content,titleList
        ) {
            @Override
            protected void convert(@NotNull BaseViewHolder viewHolder, ArticleTitleBean articleTitleBean) {
                if (articleTitleBean != null) {
                    TextView tvTitle = viewHolder.getView(R.id.tv_title);
                    tvTitle.setText(articleTitleBean.getTitle());
                    switch (articleTitleBean.getLevel()) {
                        case 2:
                            tvTitle.setPadding(UIUtils.dp2px(8f),0,0,0);
                            break;
                        case 3:
                            tvTitle.setPadding(UIUtils.dp2px(28f),0,0,0);
                            tvTitle.setTextSize(13f);
                            break;
                        case 4:
                            tvTitle.setPadding(UIUtils.dp2px(48f),0,0,0);
                            tvTitle.setTextSize(12f);
                            break;
                    }
                }
            }
        };
        rvList.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
               ArticleTitleBean item = (ArticleTitleBean) adapter.getItem(position);
                String id = item.getElementId() + "";
                String js = "javascript:getElementTop("+"'"+id+"'"+")";
                LogUtils.d("test","js == "+js);
                mCodeView.evaluateJavascript(js, (ValueCallback<String>) s -> {
                    if (s!=null&&!s.equals("null")) {
                        // 从js中获取到offsetTop 要dp2px转一下，不知道为啥？？？
                        mRvContent.scrollBy(0, UIUtils.dp2px(Float.parseFloat(s)) - scrollY);
                    }
                });
                mBottomSheetDialog.dismiss();
            }
        });
        mBottomSheetDialog.setContentView(inflate);
        mBottomSheetDialog.show();
    }

    private void thumbUp() {
        if (mToken!=null&& !mToken.equals("")){
            mArticleDetailPresenter.addArticleThumbUp(mArticleId);
        }
    }

    private void showReplyDialog(CommentBean.DataBean.ContentBean comment) {
        mReplyDialog.show();
        if (comment!=null){
            mReplyDialog.setReplyTitle("回复"+comment.getNickname());
        }
        mReplyDialog.sendListener(v -> {
           if (comment ==null){
               //评论文章
               commentArticle(v);
           }else {
               //评论回复
               replyComment(comment,v);
           }
        });
    }

    private void replyComment(CommentBean.DataBean.ContentBean comment, String v) {
        ToastUtils.showToast("v ="+v);
        mArticleDetailPresenter.replyComment(
                new SubCommentInputBean(
                       mArticleId,
                        comment.getId(),
                        comment.getUserId(),
                        comment.getNickname(),
                        v
                )
        );
    }

    private void commentArticle(String str) {
        CommentInputBean commentInputBean = new CommentInputBean(mArticleId, str);
        mArticleDetailPresenter.commentArticle(commentInputBean);
    }

    private void unfollow(String userId) {
        mArticleDetailPresenter.unFollow(userId);
    }

    private void follow(String userId) {
        mArticleDetailPresenter.addFollow(userId);
    }

    private void initView() {
        mIncludeBar = this.findViewById(R.id.include_bar);
        mIncludeBar.findViewById(R.id.tvSearch).setVisibility(View.GONE);
        mIncludeBar.findViewById(R.id.ivBack).setOnClickListener(view -> finish());
        mTvTitle = mIncludeBar.findViewById(R.id.tv_title);

        mIvSwitch = this.findViewById(R.id.iv_switch);
        mIvSwitch.setTag(0);
        mTvReplyNum = this.findViewById(R.id.tv_reply_num);
        mTvStarNum = this.findViewById(R.id.tv_star_num);
        mTvReplyNum.setVisibility(View.GONE);
        mTvStarNum.setVisibility(View.GONE);
        mIvCollection = this.findViewById(R.id.iv_collection);

        mIvHeaderAvatar = this.findViewById(R.id.iv_header_avatar);
        mTvHeaderNickname = this.findViewById(R.id.tv_header_nickname);
        mLayoutHeaderAvatar = this.findViewById(R.id.layout_header_avatar);
        mTvReply = this.findViewById(R.id.tv_reply);
        mIvStar = this.findViewById(R.id.iv_star);
        mIvList = this.findViewById(R.id.iv_list);
        mTvReward = this.findViewById(R.id.tv_reward);

        LayoutInflater inflater = LayoutInflater.from(this);
        mContentBinding = inflater.inflate(R.layout.modulehome_home_detail_content_layout, null);
        mCodeView = mContentBinding.findViewById(R.id.codeView);
        mIvAvatar = mContentBinding.findViewById(R.id.iv_avatar);
        mTvNickname = mContentBinding.findViewById(R.id.et_nickname);
        mTvPublishTime = mContentBinding.findViewById(R.id.tv_publishTime);
        mTvViewCount = mContentBinding.findViewById(R.id.tv_viewCount);
        mTvLabels = mContentBinding.findViewById(R.id.tv_labels);
        mTvPriseList = mContentBinding.findViewById(R.id.tv_prise_list);
        mIvQrUrl = mContentBinding.findViewById(R.id.iv_qrcUrl);
        mTvPriseTips = mContentBinding.findViewById(R.id.tv_prise_tips);
        mLayoutHeader = mContentBinding.findViewById(R.id.layout_header);
        mTvFollow = mContentBinding.findViewById(R.id.tv_follow);

        mAdapter = new HomeDetailAdapter();
        mRvContent = this.findViewById(R.id.rv_content);
        mTvHeaderFollow = this.findViewById(R.id.tv_header_follow);
        mRvContent.setHasFixedSize(true);
        mRvContent.setAdapter(mAdapter);
        mRvContent.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.addHeaderView(mContentBinding);
        mBottomSheetDialog = new FixedHeightBottomSheetDialog(
                this,
                R.style.BottomSheetDialog,
                UIUtils.getScreenHeeight() * 2 / 3
        );
        mReplyDialog = new ReplyBottomSheetDialog(
                this,
                R.style.BottomSheetDialog
        );
        initWebView();
        mWaitDialog = new WaitDialog(this);
        mWaitDialog.setText("上传中...");
        mWaitDialog.setCancelable(false);
    }

    @SuppressLint("JavascriptInterface")
    private void initWebView() {
        mCodeView.addJavascriptInterface(this, "native");
        mCodeView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                CommonViewUtils.toWebView(request.getUrl().toString());
                LogUtils.d("test","url ="+request.getUrl());
                return true;
            }
        });
    }

//    @SuppressLint("JavascriptInterface")
    @JavascriptInterface
    public void showBigImage(int index) {
        LogUtils.d("test","123");
        CommonViewUtils.showBigImage(this, mCodeView.getImageList(), index);
    }

    @Override
    public void returnNewCollectionMsg(BaseResponseBean data) {
        if (data.getSuccess()){
            mArticleDetailPresenter.getCollectionList();
            mBottomNewFolderSheetDialog.dismiss();
        }else {
            if (mWaitDialog.isShowing()) {
                mWaitDialog.isShowing();
            }
        }
        ToastUtils.showToast(data.getMessage());
    }

    @Override
    public void returnCollectionImageMsg(BaseResponseBean data) {
        if (data.getSuccess()){
            NewCollection newCollection = new NewCollection(
                    mNewcollectionName,
                    mNewCollectiondescription,
//                        new File(mSelectImage.get(0).getPath()),
                    data.getData().toString(),
                    mNewFolderstate + ""
            );

            mArticleDetailPresenter.postNewCollection(newCollection);
        }else {
            ToastUtils.showToast(data.getMessage());
            if (mWaitDialog.isShowing()) {
                mWaitDialog.dismiss();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setArticleDetail(ArticleDetailBean.DataBean data) {
        mArticle = data;
        mArticleTitle = mArticle.getTitle();
        mTvTitle.setText(mArticleTitle);
        //这里的CODE 为需要显示的代码，类型为String，使用的时候替换。
        mCodeView.showCode(data.getContent());

        Glide.with(mIvAvatar.getContext())
                .load(data.getAvatar())
                .placeholder(com.program.moudle_base.R.drawable.shape_grey_background)
                .circleCrop()
                .into(mIvAvatar);

        mTvNickname.setText(data.getNickname());
        mIvAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UcenterServiceWrap.Singletion.INSTANCE.getHolder().launchDetail(data.getUserId());
            }
        });
        mTvPublishTime.setText("发表于" + DateUtils.timeFormat(data.getCreateTime()));
        mTvViewCount.setText("热度" + data.getViewCount());
        mTvLabels.setText(data.getLabels().toString());

        mTvPriseList.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        mTvHeaderNickname.setText(data.getNickname());

        Glide.with(mIvHeaderAvatar.getContext())
                .load(data.getAvatar())
                .placeholder(com.program.moudle_base.R.drawable.shape_grey_background)
                .circleCrop()
                .into(mIvHeaderAvatar);
        if (data.getThumbUp() > 0) {
            mTvStarNum.setVisibility(View.VISIBLE);
            mTvStarNum.setText(data.getThumbUp().toString());
        }
        mArticleDetailPresenter.getPriseQrCode(data.getUserId());
        mArticleDetailPresenter.getUserFollowState(data.getUserId());
        mArticleDetailPresenter.getArticleComment(data.getId());
    }

    @Override
    public void setRequestError(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void setPriseQrCode(PriseQrCodeBean data) {
        if (data.getData() != null) {
            mIvQrUrl.setVisibility(View.VISIBLE);
            PriseQrCodeBean.DataBean dataBean = data.getData();
            Glide.with(this)
                    .load(dataBean.getQrcUrl())
                    .placeholder(R.drawable.shape_grey_background)
                    .override(UIUtils.dp2px(100f), UIUtils.dp2px(100f))
                    .thumbnail(0.1f)
                    .into(mIvQrUrl);
            mTvPriseTips.setText(dataBean.getTips());
        } else {
            mIvQrUrl.setVisibility(View.GONE);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setArticleComment(CommentBean data) {
        mAdapter.getData().clear();
        mCommentList.clear();
        mCommentList.add(new TitleMultiBean("文章评论"));
        List<CommentBean.DataBean.ContentBean> content = data.getData().getContent();
        for (CommentBean.DataBean.ContentBean contentBean : content) {
            mCommentList.add(contentBean);
            mCommentList.addAll(contentBean.getSubComments());
        }
        mAdapter.addData(0,mCommentList);
        if (mAdapter.getData().size()>mCommentList.size()){
            mAdapter.notifyItemChanged(mCommentList.size()+1);
        }
        mTvReplyNum.setVisibility(View.VISIBLE);
        mTvReplyNum.setText(data.getData().getContent().size()+"");
        mArticleDetailPresenter.getArticleRecommend(mArticleId);
    }

    @Override
    public void setArticleRecommend(ArticleRecommendBean data) {
        List<ArticleRecommendBean.DataBean> list = data.getData();
        mAdapter.addData(new TitleMultiBean("相关推荐"));
        mAdapter.addData(list);
    }

    @Override
    public void setReturnCommentArticle(BaseResponseBean data) {
        if (data.getSuccess()) {
            ToastUtils.showToast("评论成功");
            mArticleDetailPresenter.getArticleComment(mArticleId);
        }else {
            ToastUtils.showToast(data.getMessage());
        }
        mReplyDialog.dismiss();
    }

    @Override
    public void setReturnSubCommentArticle(BaseResponseBean data) {
        if (data.getSuccess()) {
            ToastUtils.showToast("评论成功");
            mArticleDetailPresenter.getArticleComment(mArticleId);
        }else {
            ToastUtils.showToast(data.getMessage());
        }
        mReplyDialog.dismiss();
    }

    @Override
    public void setArticleThumbUpState(BaseResponseBean data) {
        if (data.getSuccess()) {
            setStarStyle();
        }
    }

    private void setStarStyle() {
        mTvStarNum.setTextColor(ContextCompat.getColor(this,R.color.colorAccent));
        mTvStarNum.setVisibility(View.VISIBLE);
        mTvStarNum.setTag("yes");
        mIvStar.setImageResource(R.mipmap.ic_detail_likes_checked);
    }

    @Override
    public void setArticleThumbUp(BaseResponseBean data) {
        EventBusUtils.INSTANCE.postEvent(new UpdateItemEvent(UpdateItemEvent.Event.UPDATE_ARTICLE,mArticleId));
        if (data.getSuccess()) {
            mTvStarNum.setVisibility(View.VISIBLE);
            mTvStarNum.setText(data.getData().toString());
            setStarStyle();
        }else {
            ToastUtils.showToast(data.getMessage());
        }
    }

    @Override
    public void setReturnPriseArticle(BaseResponseBean data) {
        if (data.getSuccess()){
            ToastUtils.showToast("谢谢老板打赏!!!!!");
        }else {
            ToastUtils.showToast(data.getMessage());
        }
    }

    @Override
    public void setCheckCollectionState(BaseResponseBean data) {
        if (data.getSuccess()&&(!TextUtils.isEmpty(data.getData().toString()))&&(!data.getData().equals("0"))) {
            setCollectStyle(true,data.getData().toString());
        }else {
            setCollectStyle(false,"");
        }
    }

    private void setCollectStyle(boolean isCollect, String favoriteId) {
        mIvCollection.setTag(favoriteId);
        mIvCollection.setImageResource(isCollect?R.mipmap.ic_detail_collect_checked:R.mipmap.ic_detail_collect);
    }

    @Override
    public LifecycleTransformer<Object> TobindToLifecycle() {
        //        BehaviorSubject<Object> objectBehaviorSubject = BehaviorSubject.create();
//        return  RxLifecycle.bind(objectBehaviorSubject);
        return this.bindToLifecycle();
    }

    @Override
    public void setFollowState(FollowBean data) {
        LogUtils.d("test","data data = "+data.toString());
        mTvHeaderFollow.setVisibility(View.VISIBLE);
        if (data.isSuccess()){
            CommonViewUtils.setFollowState(mTvFollow,data.getData());
            CommonViewUtils.setFollowState(mTvHeaderFollow,data.getData());
        }
    }

    @Override
    public void setFollowStateError(FollowBean data) {
        ToastUtils.showToast(data.getMessage());
    }

    @Override
    public void setAddFollowMsg(String msg) {
//        mTvHeaderFollow.setTag(2);
//        mTvHeaderFollow.setText("已关注");
        CommonViewUtils.setFollowState(mTvHeaderFollow,2);
//        mTvFollow.setTag(2);
//        mTvFollow.setText("已关注");
        CommonViewUtils.setFollowState(mTvFollow,2);
        ToastUtils.showToast(msg);
        mArticleDetailPresenter.getUserFollowState(mArticle.getUserId());
    }

    @Override
    public void setAddFollowMsgError(String message) {
        ToastUtils.showToast(message);
    }

    @Override
    public void setUnFollowMsg(String msg) {
//        mTvHeaderFollow.setTag(0);
//        mTvHeaderFollow.setText("+关注");
//        mTvFollow.setTag(0);
//        mTvFollow.setText("+关注");
        CommonViewUtils.setFollowState(mTvHeaderFollow,0);
        CommonViewUtils.setFollowState(mTvFollow,0);
        ToastUtils.showToast(msg);
        mArticleDetailPresenter.getUserFollowState(mArticle.getUserId());
    }

    @Override
    public void setUnFollowMsgError(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void setCollectionList(CollectionBean data) {
        if (mCollectFolderAdapter != null) {
            mCollectFolderAdapter.getData().clear();
            mCollectFolderAdapter.setNewData(data.getData().getContent());
            if (data.getData().getLast()){
                mRefreshCollection.setEnableLoadMore(false);
            }
        }
    }

    @Override
    public void setCollectionListMore(CollectionBean data) {
        mCollectFolderAdapter.addData(data.getData().getContent());
        if (mRefreshCollection.isLoading()) {
            mRefreshCollection.finishLoadMore();
        }
        if (!data.getSuccess()){
            ToastUtils.showToast(data.getMessage());
        }
    }

    @Override
    public void setFavorite(BaseResponseBean data) {
        ToastUtils.showToast(data.getMessage());
        mArticleDetailPresenter.getCheckCollectionState(mArticleId);
    }

    @Override
    public void setUnFavorite(BaseResponseBean data) {
        ToastUtils.showToast(data.getMessage());
        mArticleDetailPresenter.getCheckCollectionState(mArticleId);
    }

    @Override
    protected void onDestroy() {
        if (EventBusUtils.INSTANCE.isRegistered(this)){
            EventBusUtils.INSTANCE.unRegister(this);
        }
        mArticleDetailPresenter.unregisterViewCallback(this);
        super.onDestroy();
    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }
}