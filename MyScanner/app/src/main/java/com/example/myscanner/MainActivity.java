package com.example.myscanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidmads.library.qrgenearator.QRGSaver;

public class MainActivity extends AppCompatActivity {


    private Animation  top_anim, bottom_anim;
    private ImageView image;
    private TextView text;
    private static int SPLASH_SCREEN = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        top_anim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_anim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image = findViewById(R.id.scannerId);
        text = findViewById(R.id.textId);


        image.setAnimation(top_anim);
        text.setAnimation(bottom_anim);



        // splash screen sesh howar pore amader main activity te chole jabe

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent i = new Intent(MainActivity.this,MainActivity2.class);
               startActivity(i);
               finish(); // eita dewar mane hocche je amader apps e open korle akbar e eikaj ta korbe pore ber holeo splash screen asbe na
               Toast.makeText(MainActivity.this,"Welcome To My Scanner", Toast.LENGTH_SHORT).show();

           }
       },SPLASH_SCREEN);

    }
}