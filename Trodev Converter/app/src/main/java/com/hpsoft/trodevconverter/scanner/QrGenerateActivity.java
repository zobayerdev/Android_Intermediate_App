package com.hpsoft.trodevconverter.scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.hpsoft.trodevconverter.R;

public class QrGenerateActivity extends AppCompatActivity {

    public final static int QRCodeWidth = 500;
    Bitmap bitmap;

    private EditText text_one;
    private Button generate, download;
    private ImageView image;

    private String inputvalue1, inputvalue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_generate);
        getSupportActionBar().setTitle("Trodev QR Generator");


        //text = findViewById(R.id.text);
        text_one = findViewById(R.id.text_one);
        generate = findViewById(R.id.generate);
        download = findViewById(R.id.download);
        download.setVisibility(View.INVISIBLE);
        image = findViewById(R.id.image);



        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // inputvalue1 = text.getText().toString().trim();
                inputvalue2 = text_one.getText().toString().trim();

                String finalvaue = inputvalue2; // eikhane joto mon chay ami amar edittext ante pari;

                if(finalvaue.length() == 0){
                    Toast.makeText(QrGenerateActivity.this, "Enter some text...!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    try{
                        bitmap = textToImageEncode(finalvaue); // eikhane main process ta hocche jeikhane amro full kaj ta hocche.
                        image.setImageBitmap(bitmap);
                        download.setVisibility(View.VISIBLE);
                        download.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MediaStore.Images.Media.insertImage(getContentResolver(), bitmap,"Code_seanner",
                                        null);
                                Toast.makeText(QrGenerateActivity.this, "Saved to galary", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    catch (WriterException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    // QR Image eikhane sompurno korbe;
    private Bitmap textToImageEncode(String value) throws WriterException{
        BitMatrix bitMatrix;
        try{
            bitMatrix = new MultiFormatWriter().encode(value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE, QRCodeWidth,QRCodeWidth,null);

        }catch(IllegalArgumentException e)
        {
            return null;
        }

        int bitMatrixWidth = bitMatrix.getWidth();
        int bitMatrixHeight = bitMatrix.getHeight();
        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for(int y = 0; y<bitMatrixHeight; y++)
        {
            int offSet = y*bitMatrixWidth;
            for(int x = 0; x<bitMatrixWidth; x++){
                pixels[offSet +x] = bitMatrix.get(x,y)?
                        getResources().getColor(R.color.black):getResources().getColor(R.color.white);
            }
        }


        // QR Code er Design korchi eikhane ami;
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);
        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }
}