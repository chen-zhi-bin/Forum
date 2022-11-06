package com.program.module_ucenter.adapter;

import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.program.module_ucenter.R;
import com.program.module_ucenter.model.domain.FollowListBean;
import com.program.moudle_base.utils.CommonViewUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FollowAdapter extends BaseQuickAdapter<FollowListBean.DataBean.ListBean, BaseViewHolder> {


    {
        addChildClickViewIds(R.id.tv_follow_state);
    }

    public FollowAdapter(@Nullable List<FollowListBean.DataBean.ListBean> data) {
        super(R.layout.moduleucenter_adapter_follow, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, FollowListBean.DataBean.ListBean listBean) {
        if (listBean != null) {
            RoundedImageView ivAvatar = viewHolder.getView(R.id.iv_avatar);
            Glide.with(ivAvatar.getContext())
                    .load(listBean.getAvatar())
                    .placeholder(R.mipmap.ic_default_avatar)
                    .circleCrop()
                    .into(ivAvatar);
            viewHolder.setText(R.id.et_nickname,listBean.getNickname());
            viewHolder.setText(R.id.tv_sign,listBean.getSign());
//            relative对应的值:
//            0表示没有关注对方，可以显示为：关注
//            1表示对方关注自己，可以显示为：回粉
//            2表示已经关注对方，可以显示为：已关注
//            3表示相互关注，可以显示为：相互关注
            TextView tvFollow = viewHolder.getView(R.id.tv_follow_state);
            CommonViewUtils.setFollowState(tvFollow,listBean.getRelative());
        }
    }
}
