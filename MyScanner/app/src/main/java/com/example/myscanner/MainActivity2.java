package com.example.myscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private ImageView start,about;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);

        start = findViewById(R.id.startId);
        about = findViewById(R.id.aboutId);
        textView = findViewById(R.id.about);




        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this,User.class);
                startActivity(intent);
                Toast.makeText(MainActivity2.this,"Start Your Work", Toast.LENGTH_SHORT).show();

            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this,Aboutus.class);
                startActivity(intent);
                Toast.makeText(MainActivity2.this,"Welcome To About Us", Toast.LENGTH_SHORT).show();

            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this,Aboutus.class);
                startActivity(intent);
                Toast.makeText(MainActivity2.this,"Welcome To About Us", Toast.LENGTH_SHORT).show();

            }
        });

    }
}