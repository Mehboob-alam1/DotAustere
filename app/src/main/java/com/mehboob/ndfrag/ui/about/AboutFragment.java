package com.mehboob.ndfrag.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.mehboob.ndfrag.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    ViewPager pager;
    VPAdapter adapter;
    List<AboutModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new AboutModel(R.drawable.appdevelopmentcourse, "App Development", "App development is fundf dsuifghisdugudgsudfgu gds ufidsudbf"));
        list.add(new AboutModel(R.drawable.webdevelopmentcourse, "Web Development", "App development is fundf dsuifghisdugudgsudfgu gds ufidsudbf"));
        list.add(new AboutModel(R.drawable.digitalmarketingcourse, "Digital Marketing", "App development is fundf dsuifghisdugudgsudfgu gds ufidsudbf"));
        list.add(new AboutModel(R.drawable.amazoncourse, "Amazon Virtual Assistant ", "App development is fundf dsuifghisdugudgsudfgu gds ufidsudbf"));
        list.add(new AboutModel(R.drawable.graphicdesigncourse, "Graphic Design", "App development is fundf dsuifghisdugudgsudfgu gds ufidsudbf"));

        adapter = new VPAdapter(getContext(), list);
        pager = view.findViewById(R.id.viewPager);
        pager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.dotaustereImage);
        imageView.setImageResource(R.drawable.dotlogo);

        return view;
    }
}