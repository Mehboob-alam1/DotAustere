package com.mehboob.ndfrag.ui.notice;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.mehboob.ndfrag.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class NoticeFragment extends Fragment {

    DatabaseReference databaseReference;
    private RecyclerView recyclerView;
    private ArrayList<NoticeModel> list;
    private ProgressBar progressBar;
    private NoticeAdapter noticeAdapter;
    LinearLayoutManager mLinearLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice, container, false);
        recyclerView = view.findViewById(R.id.noticeRecyclerView);
        progressBar = view.findViewById(R.id.noticeProgress);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Notices");


        getNotice();
        // Inflate the layout for this fragment

        return view;

    }

    private void getNotice() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                if (snapshot.exists()) {

                    for (DataSnapshot s : snapshot.getChildren()) {
                        try {
                            NoticeModel data = s.getValue(NoticeModel.class);

                            list.add(0,data);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
//
                    mLinearLayoutManager = new LinearLayoutManager(getContext());
                    noticeAdapter = new NoticeAdapter(list, getContext());
                    noticeAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setAdapter(noticeAdapter);
                    recyclerView.setLayoutManager(mLinearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                } else {
                    Toast.makeText(getContext(), "No data Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}