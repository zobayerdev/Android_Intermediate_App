package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity
{
    TextInputLayout name, quan, price;
    FloatingActionButton fb;
    Button sbmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        name = (TextInputLayout) findViewById(R.id.nametext);
        quan = (TextInputLayout) findViewById(R.id.quan);
        price = (TextInputLayout) findViewById(R.id.price);
        fb = (FloatingActionButton) findViewById(R.id.fbtn);
        sbmt = (Button) findViewById(R.id.sbmt_add);


            sbmt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    processinsert(name.getEditText().getText().toString(),quan.getEditText().getText().toString(),price.getEditText().getText().toString());
                }
            });


            fb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(),fetchdata.class));
                }
            });


    }

    private void processinsert(String n, String q, String p)
    {
       String res=new dbmanager(this).addrecord(n,q,p);
       name.getEditText().setText("");
       quan.getEditText().setText("");
       price.getEditText().setText("");
       Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }


}