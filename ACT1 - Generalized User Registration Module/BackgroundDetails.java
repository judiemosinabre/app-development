package com.example.appdevact1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BackgroundDetails extends AppCompatActivity {

    private EditText elementary, secondary, vocational, college, graduateStudies;
    private EditText vocationalCourse, collegeCourse, graduateCourse;
    private Button submitBtn;

    private String personalInfo; // Store personal information received from MainActivity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_background_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI elements
        elementary = findViewById(R.id.sc_elemtxt);
        secondary = findViewById(R.id.sc_secondarytxt);
        vocational = findViewById(R.id.sc_vocationaltxt);
        college = findViewById(R.id.sc_collegetxt);
        graduateStudies = findViewById(R.id.sc_graduatetxt);
        vocationalCourse = findViewById(R.id.bdc_vocationaltxt);
        collegeCourse = findViewById(R.id.bdc_collegetxt);
        graduateCourse = findViewById(R.id.bdc_graduatetxt);
        submitBtn = findViewById(R.id.submitBtn);

        // Retrieve personal info from MainActivity
        Intent intent = getIntent();
        if (intent.hasExtra("personalInfo")) {
            personalInfo = intent.getStringExtra("personalInfo");
        }

        submitBtn.setOnClickListener(view -> {
            if ((!isEmpty(vocational) && isEmpty(vocationalCourse)) ||
                    (!isEmpty(college) && isEmpty(collegeCourse)) ||
                    (!isEmpty(graduateStudies) && isEmpty(graduateCourse))) {
                Toast.makeText(BackgroundDetails.this, "Please provide the course for each completed education level!", Toast.LENGTH_SHORT).show();
            } else {
                Intent displayIntent = new Intent(BackgroundDetails.this, DisplayInformation.class);
                displayIntent.putExtra("personalInfo", personalInfo);
                displayIntent.putExtra("educationInfo", getEducationalInfo());
                startActivity(displayIntent);
            }
        });
    }

    // Helper method to check if EditText is empty
    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    // Helper method to format educational information
    private String getEducationalInfo() {
        return "Elementary: " + elementary.getText().toString() +
                "\nSecondary: " + secondary.getText().toString() +
                (!isEmpty(vocational) ? "\nVocational: " + vocational.getText().toString() + " - " + vocationalCourse.getText().toString() : "") +
                (!isEmpty(college) ? "\nCollege: " + college.getText().toString() + " - " + collegeCourse.getText().toString() : "") +
                (!isEmpty(graduateStudies) ? "\nGraduate Studies: " + graduateStudies.getText().toString() + " - " + graduateCourse.getText().toString() : "");
    }
}