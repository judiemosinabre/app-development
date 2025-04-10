package com.example.l3_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Receiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_receiver);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Handle Data
        Bundle b = getIntent().getBundleExtra("photoBundle");
        byte [] photoByteArray = b.getByteArray("photo");

        // Convert into Bitmap
        Bitmap photo = BitmapFactory.decodeByteArray(photoByteArray, 0, photoByteArray.length); //WHAT, STARTING POINT, LAST POSITION

        //Present
        ImageView imgReceiver = findViewById(R.id.imgReceiver);
        imgReceiver.setImageBitmap(photo);

    }
}