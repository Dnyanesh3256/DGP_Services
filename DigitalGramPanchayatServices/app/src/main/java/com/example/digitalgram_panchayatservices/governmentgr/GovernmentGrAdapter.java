package com.example.digitalgram_panchayatservices.governmentgr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.digitalgram_panchayatservices.R;

import java.util.ArrayList;

public class GovernmentGrAdapter extends RecyclerView.Adapter<GovernmentGrAdapter.EbookViewHolder> {
    private final Context context;
    private final ArrayList<GovernmentGrData> list;

    public GovernmentGrAdapter(Context context, ArrayList<GovernmentGrData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.governmentgr_item_layout,parent,false);
        return new EbookViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull EbookViewHolder holder,  int position) {
        final GovernmentGrData currentItem = list.get(position);
        holder.EbookName.setText(list.get(position).getpdfTitle());
        holder.ebookDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(currentItem.getPdfUrl()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class EbookViewHolder extends RecyclerView.ViewHolder {
        final TextView EbookName;
        final ImageView ebookDownload;


        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);
            ebookDownload=itemView.findViewById(R.id.ebookDownload);
            EbookName=itemView.findViewById(R.id.EbookName1);
        }
    }
}