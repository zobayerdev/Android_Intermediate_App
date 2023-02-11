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
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class OfficeScanner extends AppCompatActivity {

    private EditText editValue1,editValue2,editValue3,editValue4,editValue5,editValue6,editValue7;
    private TextView text;
    private ImageView qrImage,saveimg;
    private String inputValue1,inputValue2,inputValue3,inputValue4,inputValue5,inputValue6,inputValue7;
    private final String savePath = Environment.getExternalStorageDirectory().getPath() + "/QRCode/";
    private Bitmap bitmap;
    private QRGEncoder qrgEncoder;
    private AppCompatActivity activity;
    OutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_office_scanner);


        qrImage = findViewById(R.id.qr_image);

        // Edit Text Founding Process...
        editValue1 = findViewById(R.id.edit_value1);
        editValue2 = findViewById(R.id.edit_value2);
        editValue3 = findViewById(R.id.edit_value3);
        editValue4 = findViewById(R.id.edit_value4);
        editValue5 = findViewById(R.id.edit_value5);
        editValue6 = findViewById(R.id.edit_value6);
        editValue7 = findViewById(R.id.edit_value7);


        // ImageView Founding Process...
        saveimg = findViewById(R.id.save_barcode);

        activity = this;

        findViewById(R.id.generate_barcode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue1 = editValue1.getText().toString().trim();
                inputValue2 = editValue2.getText().toString().trim();
                inputValue3 = editValue3.getText().toString().trim();
                inputValue4 = editValue4.getText().toString().trim();
                inputValue5 = editValue5.getText().toString().trim();
                inputValue6 = editValue6.getText().toString().trim();


                String finalValue = inputValue1 +"\n"+ inputValue2 +"\n"+ inputValue3 +"\n"+ inputValue4 +"\n"+ inputValue5 +"\n"+ inputValue6 +"\n"+ inputValue7;

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
                    editValue1.setError(getResources().getString(R.string.value_requires));
                    editValue2.setError(getResources().getString(R.string.value_requires));
                    editValue3.setError(getResources().getString(R.string.value_requires));
                    editValue4.setError(getResources().getString(R.string.value_requires));
                    editValue5.setError(getResources().getString(R.string.value_requires));
                    editValue6.setError(getResources().getString(R.string.value_requires));
                    editValue7.setError(getResources().getString(R.string.value_requires));
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
                    Toast.makeText(OfficeScanner.this, "Directory is already Create", Toast.LENGTH_SHORT).show();
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