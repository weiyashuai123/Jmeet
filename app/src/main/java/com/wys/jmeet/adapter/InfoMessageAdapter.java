package com.wys.jmeet.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.wys.jmeet.R;
import com.wys.jmeet.dto.InfoMessage;

import java.util.List;

public class InfoMessageAdapter extends RecyclerView.Adapter<InfoMessageAdapter.ViewHolder> {

    private List<InfoMessage> infoMessageList;
    private Context mContext;

    public InfoMessageAdapter(List<InfoMessage> infoMessageList) {
        this.infoMessageList = infoMessageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mainrecy, parent, false);
        mContext = parent.getContext();
        final ViewHolder holder = new ViewHolder(view);
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        InfoMessage infoMessage = infoMessageList.get(position);
        holder.tv_time.setText(infoMessage.getCreateTime());

        RequestOptions avatarOptions = new RequestOptions()
                .placeholder(R.mipmap.m)
                .error(R.mipmap.m);
        //加载头像
        Glide.with(mContext)
                .load(infoMessage.getAvatarUrl())
                .apply(avatarOptions)
                .into(holder.avatar);
        RequestOptions picOptions = new RequestOptions()
                .placeholder(R.mipmap.photo)
                .error(R.mipmap.pic_load_error);
//        .getLoader().loadAvator(holder.avatar, dongTai.getAvatar(), R.mipmap.head);

//        if (dongTai.isHasImage()) {
//            holder.image.setVisibility(View.VISIBLE);
//            ImageLoaderFactory.getLoader().load(holder.image, dongTai.getImage(), R.mipmap.head, null);
//        }

//        holder.avatar;
//        holder.img_img;
        holder.tv_username.setText(infoMessage.getUsername());
        holder.tv_description.setText(infoMessage.getDescription());
        if (infoMessage.getAgreeNumber() > 1000) {
            holder.tv_agreeNumber.setText("" + infoMessage.getAgreeNumber() / 1000 + "K");
        } else {
            holder.tv_agreeNumber.setText("" + infoMessage.getAgreeNumber());
        }
        if (infoMessage.getCommentNumber() > 1000) {
            holder.tv_commentNumber.setText("" + infoMessage.getCommentNumber() / 1000 + "K");
        } else {
            holder.tv_commentNumber.setText("" + infoMessage.getCommentNumber());
        }

    }

    @Override
    public int getItemCount() {
        return infoMessageList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View thisView;
        ImageView avatar;
        ImageView img_img;
        TextView tv_username;
        TextView tv_description;
        TextView tv_time;
        TextView tv_agreeNumber;
        TextView tv_commentNumber;


        public ViewHolder(View view) {

            super(view);
            thisView = view;
            avatar = view.findViewById(R.id.img_Info_avatar);
            img_img = view.findViewById(R.id.img_Info_picture);
            tv_username = view.findViewById(R.id.tv_Info_username);
            tv_description = view.findViewById(R.id.tv_Info_info);
            tv_time = view.findViewById(R.id.tv_Info_time);
            tv_agreeNumber = view.findViewById(R.id.tv_Info_agreeNumber);
            tv_commentNumber = view.findViewById(R.id.tv_Info_commentNumber);

        }
    }
}
