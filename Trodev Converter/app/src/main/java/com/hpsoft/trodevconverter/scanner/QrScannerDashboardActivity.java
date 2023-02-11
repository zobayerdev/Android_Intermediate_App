package com.hpsoft.trodevconverter.scanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hpsoft.trodevconverter.R;

public class QrScannerDashboardActivity extends AppCompatActivity {

    private Button generate_button, scan_button, gallery_button, barcode_button;
    private FloatingActionButton camera_permission_btn;

    public static final int CAMERA_PERMISSION_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scanner);
        getSupportActionBar().setTitle("Trodev Scanner");

        generate_button = findViewById(R.id.generate_btn);
        scan_button = findViewById(R.id.scan_btn);
        gallery_button = findViewById(R.id.gallery_scan_btn);
        barcode_button = findViewById(R.id.barcode_btn);
        camera_permission_btn =findViewById(R.id.permission_btn);


        camera_permission_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
            }
        });

        scan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QrScannerDashboardActivity.this, ScanQrCode.class);
                startActivity(intent);
                Toast.makeText(QrScannerDashboardActivity.this, "Scanning QR", Toast.LENGTH_SHORT).show();
            }
        });

        generate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QrScannerDashboardActivity.this, QrGenerateActivity.class);
                startActivity(intent);
                Toast.makeText(QrScannerDashboardActivity.this, "Generate QR", Toast.LENGTH_SHORT).show();
            }
        });

        gallery_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QrScannerDashboardActivity.this, ScanGalleryQrActivity.class);
                startActivity(intent);
                Toast.makeText(QrScannerDashboardActivity.this, "Scanning from Gallery", Toast.LENGTH_SHORT).show();
            }
        });

        barcode_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QrScannerDashboardActivity.this, ScannBarCodeActivity.class);
                startActivity(intent);
                Toast.makeText(QrScannerDashboardActivity.this, "Scanning Bar Code", Toast.LENGTH_SHORT).show();

            }
        });

    }

    // eivabe amra permission nibo je camera er
    public void checkPermission(String permission, int requestCode){
        if (ContextCompat.checkSelfPermission(QrScannerDashboardActivity.this,permission) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(QrScannerDashboardActivity.this, new String[]{permission},
                    requestCode);
        }
        else
        {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == CAMERA_PERMISSION_CODE){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}