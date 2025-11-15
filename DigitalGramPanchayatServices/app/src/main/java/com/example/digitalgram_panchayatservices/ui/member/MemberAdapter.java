package com.example.digitalgram_panchayatservices.ui.member;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.digitalgram_panchayatservices.R;

import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberViewAdapter>{
    private List<MemberData> list;
    private Context context;
    private String category;

    public MemberAdapter(List<MemberData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MemberViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout,parent,false);
        return new MemberViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewAdapter holder, int position) {
        MemberData item = list.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.post.setText(item.getPost());

        try {
            Glide.with(context).load(item.getImage()).placeholder(R.drawable.avatar_profile_male).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }


          }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MemberViewAdapter extends RecyclerView.ViewHolder {

        private TextView name,email,post;

        private ImageView imageView;

        public MemberViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.memberName);
            email = itemView.findViewById(R.id.memberEmail);
            post = itemView.findViewById(R.id.memberPost);
            imageView = itemView.findViewById(R.id.memberImage);

        }
    }
}
