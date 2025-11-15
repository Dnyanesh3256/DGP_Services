package com.example.admindigitalgrampanchayatservices.faculty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admindigitalgrampanchayatservices.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFacultyActivity extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView wardNo1,wardNo2,wardNo3,other;
    private LinearLayout wardNo1NoData,wardNo2NoData,wardNo3NoData,otherNoData;
    private List<MemberData> list1,list2,list3,list4;
    private MemberAdapter adapter;

    private DatabaseReference reference,dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);



        fab = findViewById(R.id.fab);

        wardNo1 = findViewById(R.id.wardNo1);
        wardNo2 = findViewById(R.id.wardNo2);
        wardNo3 = findViewById(R.id.wardNo3);
        other = findViewById(R.id.other);

        wardNo1NoData = findViewById(R.id.wardNo1NoData);
        wardNo2NoData = findViewById(R.id.wardNo2NoData);
        wardNo3NoData = findViewById(R.id.wardNo3NoData);
        otherNoData = findViewById(R.id.otherNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("member");

        wardNo1();
        wardNo2();
        wardNo3();
        other();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFacultyActivity.this,AddMemberActivity.class));
            }
        });
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
                    wardNo1.setLayoutManager(new LinearLayoutManager(UpdateFacultyActivity.this));
                    adapter = new MemberAdapter(list1,UpdateFacultyActivity.this,"Ward No One");
                    wardNo1.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFacultyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    wardNo2.setLayoutManager(new LinearLayoutManager(UpdateFacultyActivity.this));
                    adapter = new MemberAdapter(list2,UpdateFacultyActivity.this,"Ward No Two");
                    wardNo2.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFacultyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    wardNo3.setLayoutManager(new LinearLayoutManager(UpdateFacultyActivity.this));
                    adapter = new MemberAdapter(list3,UpdateFacultyActivity.this,"Ward No Three");
                    wardNo3.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFacultyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    other.setLayoutManager(new LinearLayoutManager(UpdateFacultyActivity.this));
                    adapter = new MemberAdapter(list4,UpdateFacultyActivity.this,"Other");
                    other.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFacultyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}