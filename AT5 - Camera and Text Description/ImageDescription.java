package com.example.at4_camerawithtextdescription;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.ByteArrayOutputStream;

public class ImageDescription extends AppCompatActivity {

    EditText descTxt;
    Button sendTextBtn;
    Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_description);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        descTxt = findViewById(R.id.descTxt);
        sendTextBtn = findViewById(R.id.sendTextBtn);

        // Get photo from intent
        Bundle b = getIntent().getBundleExtra("photoBundle");
        if (b != null) {
            byte[] photoByteArray = b.getByteArray("photo");
            if (photoByteArray != null) {
                photo = BitmapFactory.decodeByteArray(photoByteArray, 0, photoByteArray.length);
            }
        }

        sendTextBtn.setOnClickListener(v -> sendData());
    }

    public void sendData() {
        String desc = descTxt.getText().toString().trim();

        if (desc.isEmpty()) {
            Toast.makeText(this, "Please Type a Text!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(ImageDescription.this, DisplayOutput.class);
            intent.putExtra("descText", desc);

            // Convert bitmap to byte array to pass via intent
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            intent.putExtra("photo", byteArray);

            startActivity(intent);
        }
    }

}