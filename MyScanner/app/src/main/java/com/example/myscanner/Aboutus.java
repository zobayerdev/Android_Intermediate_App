package com.example.myscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Aboutus extends AppCompatActivity {

    private ImageView dev,capy,ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_aboutus);


        dev = findViewById(R.id.devId);
        capy = findViewById(R.id.copyId);
        ref = findViewById(R.id.refId);



        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =  new Intent(Aboutus.this,Developer.class);
                startActivity(intent);
                Toast.makeText(Aboutus.this,"Welcome", Toast.LENGTH_SHORT).show();
            }
        });

        capy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =  new Intent(Aboutus.this,Copyright.class);
                startActivity(intent);
                Toast.makeText(Aboutus.this,"Thanks for watching", Toast.LENGTH_SHORT).show();

            }
        });

        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =  new Intent(Aboutus.this,Refference.class);
                startActivity(intent);
                Toast.makeText(Aboutus.this,"Thanks for watching", Toast.LENGTH_SHORT).show();

            }
        });
    }
}