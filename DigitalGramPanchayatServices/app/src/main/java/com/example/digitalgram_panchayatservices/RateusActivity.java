package com.example.digitalgram_panchayatservices;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;


public class RateusActivity extends AppCompatActivity {

    RatingBar ratingBar;
    Button button;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rateus);
        ratingBar = findViewById(R.id.rating_bar);
        button = findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RateusActivity.this, "Rating Successfully Submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}