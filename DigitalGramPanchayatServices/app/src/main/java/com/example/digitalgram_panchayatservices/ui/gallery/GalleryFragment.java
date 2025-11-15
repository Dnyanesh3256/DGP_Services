package com.example.digitalgram_panchayatservices.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.digitalgram_panchayatservices.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    RecyclerView GSRecycler, RCRecycler, othersRecycler;
    GalleryAdapter adapter;
    DatabaseReference reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        GSRecycler = view.findViewById(R.id.GSRecycler);
        RCRecycler = view.findViewById(R.id.RCRecycler);
        othersRecycler = view.findViewById(R.id.othersRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getGSImage();
        getOthersImage();
        getRCImage();

        return view;
    }

    private void getRCImage() {
        reference.child("Road Construction").addValueEventListener(new ValueEventListener() {

            final List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String data = null;
                    try {
                        data = (String) dataSnapshot.getValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                RCRecycler.setLayoutManager(new GridLayoutManager(getContext(), 5));
                RCRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getOthersImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {

            final List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String data = null;
                    try {
                        data = (String) dataSnapshot.getValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                othersRecycler.setLayoutManager(new GridLayoutManager(getContext(), 5));
                othersRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getGSImage() {
        reference.child("Gram Sabha").addValueEventListener(new ValueEventListener() {

            final List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String data = null;
                    try {
                        data = (String) dataSnapshot.getValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                GSRecycler.setLayoutManager(new GridLayoutManager(getContext(), 5));
                GSRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}