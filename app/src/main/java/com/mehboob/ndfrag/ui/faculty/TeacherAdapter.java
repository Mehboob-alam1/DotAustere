package com.mehboob.ndfrag.ui.faculty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mehboob.ndfrag.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.MyViewHolder>{
    ArrayList<Teachers> modelArrayList;
    Context context;

    public TeacherAdapter(ArrayList<Teachers> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.teaher_item_sample,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         Teachers model=  modelArrayList.get(position);
         holder.txtName.setText(model.getName());
         holder.txtEmail.setText(model.getEmail());
         holder.txtPost.setText(model.getPost());
         try {
             Picasso.get().load(model.getImage()).placeholder(R.drawable.profile).into(holder.profileImage);
         }catch (Exception e){
             e.printStackTrace();
         }


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
   TextView txtName,txtEmail,txtPost;
   ImageView profileImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtEmail=itemView.findViewById(R.id.txt_teacherEmail);
            txtName=itemView.findViewById(R.id.txt_teacherName);
            txtPost=itemView.findViewById(R.id.txt_teacherPost);
            profileImage=itemView.findViewById(R.id.image_teacher_sample);


        }
    }
}
