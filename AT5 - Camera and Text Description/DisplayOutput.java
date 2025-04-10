package com.example.at4_camerawithtextdescription;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayOutput extends AppCompatActivity {

    TextView descriptionTxt;
    ImageView imgReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display_output);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        descriptionTxt = findViewById(R.id.descriptionTxt);
        imgReceiver = findViewById(R.id.imgReceiver);

        // Get data from intent
        String desc = getIntent().getStringExtra("descText");
        byte[] byteArray = getIntent().getByteArrayExtra("photo");

        if (desc != null) {
            descriptionTxt.setText(desc);
        }

        if (byteArray != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            imgReceiver.setImageBitmap(bitmap);
        }
    }



}