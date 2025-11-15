package com.example.digitalgram_panchayatservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digitalgram_panchayatservices.ui.home.HomeFragment;

public class SplashActivity extends AppCompatActivity {
    TextView tv_name,tv_title;
    ImageView iv_logo;

    Animation fadein,slide_in_left,slide_in_right;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(SplashActivity.this,R.color.white));

        tv_name = findViewById(R.id.tv_splash_name);
        tv_title = findViewById(R.id.tv_splash_title);
        iv_logo = findViewById(R.id.iv_splash_app_logo);

        fadein = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.fadein);
        slide_in_right = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.slide_in_left);
        slide_in_left = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.slide_in_right);


        tv_name.setAnimation(fadein);
        tv_title.setAnimation(slide_in_right);
        iv_logo.setAnimation(slide_in_left);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}