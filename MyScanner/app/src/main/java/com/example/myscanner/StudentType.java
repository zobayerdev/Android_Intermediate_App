package com.example.myscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.LineNumberReader;

public class StudentType extends AppCompatActivity {

    private ImageView stuschl,stuuniv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_student_type);

        stuschl = findViewById(R.id.stuschool);
        stuuniv = findViewById(R.id.stuversity);


        stuschl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentType.this,StudentScanner.class);
                startActivity(intent);
            }
        });

        stuuniv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentType.this,UniversityScanner.class);
                startActivity(intent);
            }
        });



    }
}