package com.mehboob.ndfrag.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mehboob.ndfrag.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

  DatabaseReference reference;
  private GalleryAdapter adapter;

  RecyclerView eidUlFitr,eidUlAzha,ramazan;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view = inflater.inflate(R.layout.fragment_gallery, container, false);
     reference= FirebaseDatabase.getInstance().getReference().child("gallery");
     eidUlAzha=view.findViewById(R.id.image1Recycler);
     eidUlFitr=view.findViewById(R.id.image2Recycler);
     ramazan=view.findViewById(R.id.image3Recycler);

     getEidUlFitr();
     getEidUlAzha();
     getRamazan();

        return view;
    }

    private void getEidUlAzha() {
        reference.child("Eid ul Azha").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> list=new ArrayList<>();
                for (DataSnapshot s :snapshot.getChildren()){
                     String data=    s.getValue(String.class);
                      list.add(data);


                }
               adapter=new GalleryAdapter(getContext(),list);
                eidUlAzha.setLayoutManager(new GridLayoutManager(getContext(),3));
                eidUlAzha.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getRamazan() {
        reference.child("Ramazan").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> list=new ArrayList<>();
                for (DataSnapshot s :snapshot.getChildren()){
                    String data=    s.getValue(String.class);
                    list.add(data);


                }
                adapter=new GalleryAdapter(getContext(),list);
                ramazan.setLayoutManager(new GridLayoutManager(getContext(),3));
                ramazan.setAdapter(adapter);
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getEidUlFitr() {
        reference.child("Eid ul Fitr").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> list=new ArrayList<>();
                for (DataSnapshot s :snapshot.getChildren()){
                    String data=    s.getValue(String.class);
                    list.add(data);


                }
                adapter=new GalleryAdapter(getContext(),list);
                eidUlFitr.setLayoutManager(new GridLayoutManager(getContext(),3));
                eidUlFitr.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}