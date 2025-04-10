package com.example.at4_camerawithtextdescription;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void openCamera(View v) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 22);
    }

    //onActivityResults
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Image Captured Display
        if (requestCode == 22 && data != null) {
            ImageView imgPicture = findViewById(R.id.imgPicture);
            photo = (Bitmap)data.getExtras().get("data");
            imgPicture.setImageBitmap(photo);
        }
        else {
            Toast.makeText(this, "No Photo Taken", Toast.LENGTH_SHORT).show();
        }
    }

    public void sendPhoto(View v) {
        if (photo != null ){
            //Convert Picture into Byte
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 100, stream); //max value is 100
            byte[] photoByteArray = stream.toByteArray();


            // Fetch DS - Preparation for Fetching
            Bundle bundle = new Bundle();
            bundle.putByteArray("photo", photoByteArray);

            //Fetch into New Activity
            Intent i = new Intent(this, ImageDescription.class);
            i.putExtra("photoBundle", bundle);
            startActivity(i);
        } else {
            Toast.makeText(this, "Take a photo first!", Toast.LENGTH_SHORT).show();
        }
    }
}