package com.example.admindigitalgrampanchayatservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.admindigitalgrampanchayatservices.faculty.UpdateFacultyActivity;
import com.example.admindigitalgrampanchayatservices.notice.DeleteNoticeActivity;
import com.example.admindigitalgrampanchayatservices.notice.UploadNoticeActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    CardView uploadNotice,addGalleryImage,addPDF,faculty,deleteNotice;

    TextView title;

    Animation bounce,fadein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        uploadNotice = findViewById(R.id.addNotice);
        addGalleryImage = findViewById(R.id.addGalleryImage);
        addPDF = findViewById(R.id.addPDF);
        faculty = findViewById(R.id.faculty);
        deleteNotice = findViewById(R.id.deleteNotice);

        title = findViewById(R.id.tv_home_title);
        bounce = AnimationUtils.loadAnimation(this,R.anim.bounce);
        fadein = AnimationUtils.loadAnimation(this,R.anim.fadein);

        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addPDF.setOnClickListener(this);
        faculty.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);

        title.setAnimation(bounce);

        uploadNotice.setAnimation(fadein);
        addGalleryImage.setAnimation(fadein);
        addPDF.setAnimation(fadein);
        faculty.setAnimation(fadein);
        deleteNotice.setAnimation(fadein);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.addNotice:
                intent = new Intent(HomeActivity.this, UploadNoticeActivity.class);
                startActivity(intent);
                break;

            case R.id.addGalleryImage:
                intent = new Intent(HomeActivity.this,UploadImageActivity.class);
                startActivity(intent);
                break;

            case R.id.addPDF:
                intent = new Intent(HomeActivity.this,UploadPDFActivity.class);
                startActivity(intent);
                break;

            case R.id.faculty:
                intent = new Intent(HomeActivity.this, UpdateFacultyActivity.class);
                startActivity(intent);
                break;

            case R.id.deleteNotice:
                intent = new Intent(HomeActivity.this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;
        }
    }
}