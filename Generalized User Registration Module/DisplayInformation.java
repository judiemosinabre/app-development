package com.example.appdevact1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayInformation extends AppCompatActivity {

    private TextView personalTxt, educationTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display_information);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        personalTxt = findViewById(R.id.personaltxt);
        educationTxt = findViewById(R.id.educationtxt);

        Intent intent = getIntent();
        if (intent.hasExtra("personalInfo")) {
            personalTxt.setText(intent.getStringExtra("personalInfo"));
        }

        if (intent.hasExtra("educationInfo")) {
            educationTxt.setText(intent.getStringExtra("educationInfo"));
        }
    }
}