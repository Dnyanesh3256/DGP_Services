package com.example.admindigitalgrampanchayatservices;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class SplashActivity extends AppCompatActivity {

    TextView tv_name,tv_title;
    ImageView iv_logo;

    Animation fadein,slide_in_left,slide_in_right;
    Handler h1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));

        tv_name = findViewById(R.id.tv_splash_name);
        tv_title = findViewById(R.id.tv_splash_title);
        iv_logo = findViewById(R.id.iv_splash_app_logo);

        fadein = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.fadein);
        slide_in_right = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.slide_in_left);
        slide_in_left = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.slide_in_right);


        tv_name.setAnimation(fadein);
        tv_title.setAnimation(slide_in_right);
        iv_logo.setAnimation(slide_in_left);

        h1 = new Handler();
        h1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,HomeActivity.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}