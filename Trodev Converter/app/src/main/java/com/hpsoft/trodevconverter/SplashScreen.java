package com.hpsoft.trodevconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    private Button btn;
    private ImageView splash_image;
    private TextView splash_text;
    private static int SPLASH_SCREEN = 4000;
    private Animation top_anim, bottom_anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

      //  btn = findViewById(R.id.btn);
        splash_image = findViewById(R.id.splash_image);
        splash_text = findViewById(R.id.splash_text);

        top_anim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_anim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        splash_image.setAnimation(top_anim);
        splash_text.setAnimation(bottom_anim);


        // splash screen sesh howar pore amader main activity te chole jabe

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this,DashBoard.class);
                startActivity(i);
                finish(); // eita dewar mane hocche je amader apps e open korle akbar e eikaj ta korbe pore ber holeo splash screen asbe na
                Toast.makeText(SplashScreen.this,"Welcome To Trodev Converter", Toast.LENGTH_SHORT).show();

            }
        },SPLASH_SCREEN);


/*        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreen.this,DashBoard.class);
                startActivity(intent);
            }
        });*/
    }
}