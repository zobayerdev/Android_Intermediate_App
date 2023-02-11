package com.example.myscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ScannerType extends AppCompatActivity {

    private ImageView stubtn,officebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_scanner_type);


        stubtn = findViewById(R.id.stuprofile);
        officebtn = findViewById(R.id.officeprofile);


        stubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScannerType.this,StudentType.class);
                startActivity(i);
            }
        });

        officebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScannerType.this,OfficeScanner.class);
                startActivity(i);
            }
        });




    }
}