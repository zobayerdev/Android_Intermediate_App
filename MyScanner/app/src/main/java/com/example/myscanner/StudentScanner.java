package com.example.myscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class StudentScanner extends AppCompatActivity {

    private EditText edtValue,edtValue1,edtValue2,edtValue3,edtValue4,edtValue5,edtValue6;
    private ImageView qrImage,saveimg;
    private String inputValue,inputValue1,inputValue2,inputValue3,inputValue4,inputValue5,inputValue6;
    private final String savePath = Environment.getExternalStorageDirectory().getPath() + "/QRCode/";
    private Bitmap bitmap;
    private QRGEncoder qrgEncoder;
    private AppCompatActivity activity;
    OutputStream outputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_student_scanner);



        qrImage = findViewById(R.id.qr_image);

        // Edit Text Founding Process...
        edtValue = findViewById(R.id.edt_value);
        edtValue1 = findViewById(R.id.edt_value1);
        edtValue2 = findViewById(R.id.edt_value2);
        edtValue3 = findViewById(R.id.edt_value3);
        edtValue4 = findViewById(R.id.edt_value4);
        edtValue5 = findViewById(R.id.edt_value5);
        edtValue6 = findViewById(R.id.edt_value6);

        // ImageView Founding Process...
        saveimg = findViewById(R.id.save_barcode);

        activity = this;

        findViewById(R.id.generate_barcode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue = edtValue.getText().toString().trim();
                inputValue1 = edtValue1.getText().toString().trim();
                inputValue2 = edtValue2.getText().toString().trim();
                inputValue3 = edtValue3.getText().toString().trim();
                inputValue4 = edtValue4.getText().toString().trim();
                inputValue5 = edtValue5.getText().toString().trim();
                inputValue6 = edtValue6.getText().toString().trim();


                String finalValue = inputValue +"\n"+ inputValue1 +"\n"+ inputValue2 +"\n"+ inputValue3 +"\n"+ inputValue4 +"\n"+ inputValue5 +"\n"+ inputValue6;
                if (finalValue.length() > 0) {
                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                    Display display = manager.getDefaultDisplay();
                    Point point = new Point();
                    display.getSize(point);
                    int width = point.x;
                    int height = point.y;
                    int smallerDimension = Math.min(width, height);
                    smallerDimension = smallerDimension * 3 / 4;

                    qrgEncoder = new QRGEncoder(
                            finalValue, null,
                            QRGContents.Type.TEXT,
                            smallerDimension);
                    qrgEncoder.setColorBlack(Color.BLACK);
                    qrgEncoder.setColorWhite(Color.WHITE);
                    try {
                        bitmap = qrgEncoder.getBitmap();
                        qrImage.setImageBitmap(bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    edtValue.setError(getResources().getString(R.string.value_requires));
                    edtValue1.setError(getResources().getString(R.string.value_requires));
                    edtValue2.setError(getResources().getString(R.string.value_requires));
                    edtValue3.setError(getResources().getString(R.string.value_requires));
                    edtValue4.setError(getResources().getString(R.string.value_requires));
                    edtValue5.setError(getResources().getString(R.string.value_requires));
                    edtValue6.setError(getResources().getString(R.string.value_requires));

                }
            }
        });


        saveimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable drawable =  (BitmapDrawable) qrImage.getDrawable(); // type casting kortesi drawable er sathe Bitmap ke
                Bitmap bitmap = drawable.getBitmap(); //

                File filepath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM + "/Demo/");

                if (!filepath.exists())
                {
                    filepath.mkdir();
                    Toast.makeText(StudentScanner.this, "Directory is already Create", Toast.LENGTH_SHORT).show();
                }


                File file = new File(filepath, System.currentTimeMillis()+".png");


                try{
                    outputStream = new FileOutputStream(file);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream,8192);
                    bitmap.compress(Bitmap.CompressFormat.PNG,100,bufferedOutputStream);
                    bufferedOutputStream.flush(); // jokhn amra data ta use kore felsi; string take khali korte chaitesi..
                    bufferedOutputStream.close(); // bufferoutputStream take ami colse kore dissi nahole amar apps er sizwe bere jabe;
                    Toast.makeText(getApplicationContext(),"Image Saved To Gallary !!!", Toast.LENGTH_SHORT).show();
                }catch (IOException e) { // IO mane hocche input output exception
                    e.printStackTrace(); // run er moddhe jei error astese seigula dekhanor jonno.
                }

            }
        });


    }
}