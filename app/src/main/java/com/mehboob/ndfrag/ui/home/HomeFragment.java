package com.mehboob.ndfrag.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mehboob.ndfrag.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

ArrayList<ModelSlider> sliderArrayList;
SliderAdapter adapter;
SliderView sliderView;
ImageView map;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        map=view.findViewById(R.id.googleImage);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        sliderArrayList=new ArrayList<>();
        sliderArrayList.add(new ModelSlider(R.drawable.bg_overlay));
        sliderArrayList.add(new ModelSlider(R.drawable.bg_overlay));
        sliderArrayList.add(new ModelSlider(R.drawable.bg_overlay));
        sliderArrayList.add(new ModelSlider(R.drawable.bg_overlay));
        adapter=new SliderAdapter(sliderArrayList,getContext());
        sliderView=view.findViewById(R.id.imageSlider);
         sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        return view;
    }

    private void openMap() {
        Uri uri=Uri.parse("geo:0, 0q?=Dot Austere Software technology park Gilgit");
        Intent intent =new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}