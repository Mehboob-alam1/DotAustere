package com.mehboob.ndfrag.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mehboob.ndfrag.R;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    RecyclerView androidDevelopment, backendDevelopment, frontendDevelopment, flutter, reactnativeDevelopment, graphicDesign, digitalMarketing;
    LinearLayout androiNodata, backendNoData, frontendNodata, flutterNodata, reactnativeNodata, graphicNodata, digiMarkNodata;
    private ArrayList<Teachers> listAndroid, listbackEnd, listfronEnd, listFlutter, listreactNative, listGraphic, listdigitalMarketing;
    private DatabaseReference databaseReference, mRef;
    private TeacherAdapter adapter;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_faculty, container, false);

        initViews();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("faculty");
        androidDevelopment();
        backendDevelopment();
        frontendDevelopment();
        flutter();
        reactnativeDevelopment();
        graphicDesign();
        digitalMarketing();
        // Inflate the layout for this fragment
        return view;
    }
    private void androidDevelopment() {
        mRef = databaseReference.child("Android development");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listAndroid = new ArrayList<>();
                if (!snapshot.exists()) {
                    androiNodata.setVisibility(View.VISIBLE);
                    androidDevelopment.setVisibility(View.GONE);
                } else {
                    androiNodata.setVisibility(View.GONE);
                    androidDevelopment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snap : snapshot.getChildren()) {
                        Teachers data = snap.getValue(Teachers.class);
                        listAndroid.add(data);
                    }
                    androidDevelopment.setHasFixedSize(true);
                    androidDevelopment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(listAndroid,getContext());
                    androidDevelopment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void backendDevelopment() {
        mRef = databaseReference.child("Backend Development");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listbackEnd = new ArrayList<>();
                if (!snapshot.exists()) {
                    backendNoData.setVisibility(View.VISIBLE);
                    backendDevelopment.setVisibility(View.GONE);
                } else {
                    backendNoData.setVisibility(View.GONE);
                    backendDevelopment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snap : snapshot.getChildren()) {
                        Teachers data = snap.getValue(Teachers.class);
                        listbackEnd.add(data);
                    }
                    backendDevelopment.setHasFixedSize(true);
                    backendDevelopment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(listbackEnd,getContext());
                    backendDevelopment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void frontendDevelopment() {
        mRef = databaseReference.child("Frontend Development");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listfronEnd = new ArrayList<>();
                if (!snapshot.exists()) {
                    frontendNodata.setVisibility(View.VISIBLE);
                    frontendDevelopment.setVisibility(View.GONE);
                } else {
                    frontendNodata.setVisibility(View.GONE);
                    frontendDevelopment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snap : snapshot.getChildren()) {
                        Teachers data = snap.getValue(Teachers.class);
                        listfronEnd.add(data);
                    }
                    frontendDevelopment.setHasFixedSize(true);
                    frontendDevelopment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(listfronEnd,getContext());
                    frontendDevelopment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void flutter() {
        mRef = databaseReference.child("Flutter");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listFlutter = new ArrayList<>();
                if (!snapshot.exists()) {
                    flutterNodata.setVisibility(View.VISIBLE);
                    flutter.setVisibility(View.GONE);
                } else {
                    flutterNodata.setVisibility(View.GONE);
                    flutter.setVisibility(View.VISIBLE);
                    for (DataSnapshot snap : snapshot.getChildren()) {
                        Teachers data = snap.getValue(Teachers.class);
                        listFlutter.add(data);
                    }
                    flutter.setHasFixedSize(true);
                    flutter.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(listFlutter,getContext());
                    flutter.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void reactnativeDevelopment() {
        mRef = databaseReference.child("React Native");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listreactNative = new ArrayList<>();
                if (!snapshot.exists()) {
                    reactnativeNodata.setVisibility(View.VISIBLE);
                    reactnativeDevelopment.setVisibility(View.GONE);
                } else {
                    reactnativeNodata.setVisibility(View.GONE);
                    reactnativeDevelopment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snap : snapshot.getChildren()) {
                        Teachers data = snap.getValue(Teachers.class);
                        listreactNative.add(data);
                    }
                    reactnativeDevelopment.setHasFixedSize(true);
                    reactnativeDevelopment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(listreactNative,getContext());
                    reactnativeDevelopment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void graphicDesign() {
        mRef = databaseReference.child("UI/UX Designing");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listGraphic = new ArrayList<>();
                if (!snapshot.exists()) {
                    graphicNodata.setVisibility(View.VISIBLE);
                    graphicDesign.setVisibility(View.GONE);
                } else {
                    graphicNodata.setVisibility(View.GONE);
                    graphicDesign.setVisibility(View.VISIBLE);
                    for (DataSnapshot snap : snapshot.getChildren()) {
                        Teachers data = snap.getValue(Teachers.class);
                        listGraphic.add(data);
                    }
                    graphicDesign.setHasFixedSize(true);
                    graphicDesign.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(listGraphic,getContext());
                    graphicDesign.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void digitalMarketing() {
        mRef = databaseReference.child("Digital Marketing");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listdigitalMarketing = new ArrayList<>();
                if (!snapshot.exists()) {
                    digiMarkNodata.setVisibility(View.VISIBLE);
                    digitalMarketing.setVisibility(View.GONE);
                } else {
                    digiMarkNodata.setVisibility(View.GONE);
                    digitalMarketing.setVisibility(View.VISIBLE);
                    for (DataSnapshot snap : snapshot.getChildren()) {
                        Teachers data = snap.getValue(Teachers.class);
                        listdigitalMarketing.add(data);
                    }
                    digitalMarketing.setHasFixedSize(true);
                    digitalMarketing.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(listdigitalMarketing,getContext());
                    digitalMarketing.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initViews() {

        // All recycler Views
        androidDevelopment =view.findViewById(R.id.androidDevelopment);
        backendDevelopment =view. findViewById(R.id.backendDevelopment);
        frontendDevelopment =view. findViewById(R.id.frontendDevelopment);
        flutter =view. findViewById(R.id.flutter);
        reactnativeDevelopment =view. findViewById(R.id.reactnativeDevelopment);
        graphicDesign =view. findViewById(R.id.graphicDesign);
        digitalMarketing =view. findViewById(R.id.digitalMarketing);

        //No data layouts
        androiNodata =view. findViewById(R.id.androiNoData);
        backendNoData =view. findViewById(R.id.backendNoData);
        frontendNodata =view. findViewById(R.id.frontendNoData);
        flutterNodata =view. findViewById(R.id.flutterNoData);
        reactnativeNodata =view. findViewById(R.id.reactnativeNoData);
        graphicNodata =view. findViewById(R.id.graphicDesignNoData);
        digiMarkNodata =view. findViewById(R.id.digitalmarketingNoData);
    }
}