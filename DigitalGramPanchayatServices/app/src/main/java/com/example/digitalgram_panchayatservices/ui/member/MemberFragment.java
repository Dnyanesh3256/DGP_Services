package com.example.digitalgram_panchayatservices.ui.member;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.digitalgram_panchayatservices.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MemberFragment extends Fragment {

    private RecyclerView wardNo1,wardNo2,wardNo3,other;
    private LinearLayout wardNo1NoData,wardNo2NoData,wardNo3NoData,otherNoData;
    private List<MemberData> list1,list2,list3,list4;
    private MemberAdapter adapter;

    private DatabaseReference reference,dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_member, container, false);

        wardNo1 = view.findViewById(R.id.wardNo1);
        wardNo2 = view.findViewById(R.id.wardNo2);
        wardNo3 =view. findViewById(R.id.wardNo3);
        other = view.findViewById(R.id.other);

        wardNo1NoData =view. findViewById(R.id.wardNo1NoData);
        wardNo2NoData = view.findViewById(R.id.wardNo2NoData);
        wardNo3NoData = view.findViewById(R.id.wardNo3NoData);
        otherNoData = view.findViewById(R.id.otherNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("member");

        wardNo1();
        wardNo2();
        wardNo3();
        other();

        return view;
    }

    private void wardNo1() {
        dbRef = reference.child("Ward No One");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()) {
                    wardNo1NoData.setVisibility(View.VISIBLE);
                    wardNo1.setVisibility(View.GONE);
                } else {
                    wardNo1NoData.setVisibility(View.GONE);
                    wardNo1.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                        MemberData data = dataSnapshot.getValue(MemberData.class);
                        list1.add(data);
                    }
                    wardNo1.setHasFixedSize(true);
                    wardNo1.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new MemberAdapter(list1,getContext());
                    wardNo1.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void wardNo2() {
        dbRef = reference.child("Ward No Two");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()) {
                    wardNo2NoData.setVisibility(View.VISIBLE);
                    wardNo2.setVisibility(View.GONE);
                } else {
                    wardNo2NoData.setVisibility(View.GONE);
                    wardNo2.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                        MemberData data = dataSnapshot.getValue(MemberData.class);
                        list2.add(data);
                    }
                    wardNo2.setHasFixedSize(true);
                    wardNo2.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new MemberAdapter(list2,getContext());
                    wardNo2.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void wardNo3() {
        dbRef = reference.child("Ward No Three");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()) {
                    wardNo3NoData.setVisibility(View.VISIBLE);
                    wardNo3.setVisibility(View.GONE);
                } else {
                    wardNo3NoData.setVisibility(View.GONE);
                    wardNo3.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                        MemberData data = dataSnapshot.getValue(MemberData.class);
                        list3.add(data);
                    }
                    wardNo3.setHasFixedSize(true);
                    wardNo3.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new MemberAdapter(list3,getContext());
                    wardNo3.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void other() {
        dbRef = reference.child("Other");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()) {
                    otherNoData.setVisibility(View.VISIBLE);
                    other.setVisibility(View.GONE);
                } else {
                    otherNoData.setVisibility(View.GONE);
                    other.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                        MemberData data = dataSnapshot.getValue(MemberData.class);
                        list4.add(data);
                    }
                    other.setHasFixedSize(true);
                    other.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new MemberAdapter(list4,getContext());
                    other.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}