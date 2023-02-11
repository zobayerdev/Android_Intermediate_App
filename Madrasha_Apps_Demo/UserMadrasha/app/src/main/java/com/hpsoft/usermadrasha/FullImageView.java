package com.hpsoft.usermadrasha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FullImageView extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);

        String image = getIntent().getStringExtra("image");

        imageView = findViewById(R.id.imageView);


        Glide.with(this).load(image).into(imageView);



    }
}