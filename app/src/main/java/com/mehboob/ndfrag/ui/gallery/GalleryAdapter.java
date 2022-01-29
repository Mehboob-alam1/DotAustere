package com.mehboob.ndfrag.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mehboob.ndfrag.FullImageActivity;
import com.mehboob.ndfrag.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    private Context context;
    private List<String> listGallery;

    public GalleryAdapter(Context context, List<String> listGallery) {
        this.context = context;
        this.listGallery = listGallery;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_sample, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        String data = listGallery.get(position);
        try {
            Glide.with(context).load(listGallery.get(position)).into(holder.galleryImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.galleryImage.setOnClickListener(view -> {
            Intent intent = new Intent(context, FullImageActivity.class);
            intent.putExtra("image", data);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listGallery.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView galleryImage;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            galleryImage = itemView.findViewById(R.id.galleryImage);
        }
    }
}
