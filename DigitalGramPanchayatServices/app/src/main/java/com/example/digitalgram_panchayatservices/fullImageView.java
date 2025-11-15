package com.example.digitalgram_panchayatservices;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class fullImageView extends AppCompatActivity {
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);
        String image=getIntent().getStringExtra("image");
        imageView=findViewById(R.id.imageView);
        Glide.with(this).load(image).into(imageView);
    }
}