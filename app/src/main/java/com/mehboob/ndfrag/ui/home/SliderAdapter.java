package com.mehboob.ndfrag.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mehboob.ndfrag.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder> {
    private ArrayList<ModelSlider> sliderArrayList;
    private Context context;

    public SliderAdapter(ArrayList<ModelSlider> sliderArrayList, Context context) {
        this.sliderArrayList = sliderArrayList;
        this.context = context;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup viewGroup) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_sliderimage, null);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder sliderViewHolder, int i) {
        ModelSlider model = sliderArrayList.get(i);
        Glide.with(sliderViewHolder.imageView)
                .load(model.getImageurl())
                .fitCenter()
                .into(sliderViewHolder.imageView);
    }

    @Override
    public int getCount() {
        return sliderArrayList.size();
    }

    public class SliderViewHolder extends SliderViewAdapter.ViewHolder {
        ImageView imageView;

        public SliderViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.myimage);

        }
    }
}
