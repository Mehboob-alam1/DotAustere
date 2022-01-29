package com.mehboob.ndfrag.ui.ebooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mehboob.ndfrag.R;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {
    RecyclerView ebookRecycler;
    private DatabaseReference reference;
    private List<EbookModel> list;
    private EbookAdapter adapter;
    ShimmerFrameLayout shimmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        ebookRecycler = findViewById(R.id.ebookRecyclerView);
        reference = FirebaseDatabase.getInstance().getReference().child("pdf");
        shimmer = findViewById(R.id.shimmerContainer);
    
        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list = new ArrayList<>();
                for (DataSnapshot s : snapshot.getChildren()) {
                    EbookModel data = s.getValue(EbookModel.class);
                    list.add(data);
                }
                shimmer.stopShimmer();
                shimmer.setVisibility(View.INVISIBLE);
                adapter = new EbookAdapter(EbookActivity.this, list);
                ebookRecycler.setAdapter(adapter);
                ebookRecycler.setLayoutManager(new LinearLayoutManager(EbookActivity.this));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}