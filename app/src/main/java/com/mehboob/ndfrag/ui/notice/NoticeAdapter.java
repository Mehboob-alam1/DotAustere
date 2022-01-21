package com.mehboob.ndfrag.ui.notice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mehboob.ndfrag.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {

    private ArrayList<NoticeModel> noticeModelArrayList;
    private Context context;

    public NoticeAdapter(ArrayList<NoticeModel> noticeModelArrayList, Context context) {
        this.noticeModelArrayList = noticeModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.motice_sample, parent, false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
        NoticeModel model = noticeModelArrayList.get(position);

        holder.noticeTime.setText(model.getTime());
        holder.noticeDate.setText(model.getDate());
        holder.noticeTitle.setText(model.getTitle());
        try {

//                 Glide.with(context).load(model.getIamge()).placeholder(R.drawable.profile).into(holder.noticeImage);
            Picasso.get().load(model.getImage()).placeholder(R.drawable.profile).into(holder.noticeImage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

//    // Apnay methods
//
//    @SuppressLint("NotifyDataSetChanged")
//    public void updateData(ArrayList<NoticeModel> model) {
//        noticeModelArrayList.clear();
//        noticeModelArrayList.addAll(model);
//        notifyDataSetChanged();
//    }
//    public void addItem(int position, NoticeModel model) {
//        noticeModelArrayList.add(position, model);
//        notifyItemInserted(position);
//    }
//
//    public void removeItem(int position) {
//        noticeModelArrayList.remove(position);
//        notifyItemRemoved(position);
//    }

    @Override
    public int getItemCount() {
        return noticeModelArrayList.size();
    }

    public static class NoticeViewHolder extends RecyclerView.ViewHolder {
        TextView noticeTitle, noticeDate, noticeTime;
        ImageView noticeImage;

        public NoticeViewHolder(@NonNull View itemView) {
            super(itemView);
            noticeTitle = itemView.findViewById(R.id.noticetitle);
            noticeDate = itemView.findViewById(R.id.dateofNotice);
            noticeTime = itemView.findViewById(R.id.timeofNotice);
            noticeImage = itemView.findViewById(R.id.imageofNotice);
        }
    }
}
