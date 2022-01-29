package com.mehboob.ndfrag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class FullImageActivity extends AppCompatActivity {
   String url;

   PhotoView photoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ful_image);
        url=getIntent().getStringExtra("image");
        photoView=(PhotoView)findViewById(R.id.photo_view);
        try {
            Glide.with(this).load(url).into(photoView);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}