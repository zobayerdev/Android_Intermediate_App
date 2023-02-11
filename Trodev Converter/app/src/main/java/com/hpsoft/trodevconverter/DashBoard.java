package com.hpsoft.trodevconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hpsoft.trodevconverter.ocr.ImageToText;
import com.hpsoft.trodevconverter.scanner.QrScannerDashboardActivity;

public class DashBoard extends AppCompatActivity {

    private CardView converter_button;
    private CardView scanner_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        converter_button = findViewById(R.id.convert_bttn);
        scanner_button = findViewById(R.id.scanner_bttn);



        converter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent converter = new Intent(DashBoard.this, ImageToText.class);
                startActivity(converter);
                Toast.makeText(DashBoard.this, "Create your OCR", Toast.LENGTH_SHORT).show();
            }
        });


        scanner_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent converter = new Intent(DashBoard.this, QrScannerDashboardActivity.class);
                startActivity(converter);
                Toast.makeText(DashBoard.this, "Create your Own QR", Toast.LENGTH_SHORT).show();
            }
        });

    }
}