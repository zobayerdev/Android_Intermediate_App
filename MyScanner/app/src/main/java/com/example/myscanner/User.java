package com.example.myscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class User extends AppCompatActivity {

    private ImageView qrstrt,qrcrt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user);


        qrstrt = findViewById(R.id.startscanId);
        qrcrt = findViewById(R.id.createqrId);



        qrstrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User.this,Scanner.class);
                startActivity(intent);
            }
        });

        qrcrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User.this, ScannerType.class);
                startActivity(intent);
            }
        });

    }
}