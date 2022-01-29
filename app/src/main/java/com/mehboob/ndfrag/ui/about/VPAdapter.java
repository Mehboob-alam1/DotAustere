package com.mehboob.ndfrag.ui.about;

import android.content.Context;
import android.hardware.lights.LightState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.mehboob.ndfrag.R;

import java.util.List;

public class VPAdapter extends PagerAdapter {
    private Context context;
    private List<AboutModel>  list;

    public VPAdapter(Context context, List<AboutModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.courses_layout,container,false);
        ImageView image;
        TextView title,desc;
        image=view.findViewById(R.id.viewpagerImage);
        title=view.findViewById(R.id.viewpagerTitle);
        desc=view.findViewById(R.id.viewpagerDesc);

        image.setImageResource(list.get(position).getImage());
        title.setText(list.get(position).getTitle());
        desc.setText(list.get(position).getDesc());

        container.addView(view,0);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
