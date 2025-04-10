package com.example.act2_generalizeduserregistrationmodulev2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Education extends AppCompatActivity {
    CheckBox elementaryBox, secondaryBox, collegeBox, gradStudiesBox;
    EditText elemSchool, elemCourse, secSchool, secCourse, vocSchool, vocCourse, colSchool, colCourse, gradSchool, gradCourse;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_education);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        elementaryBox = findViewById(R.id.q1Yes);
        secondaryBox = findViewById(R.id.secBox);
        collegeBox = findViewById(R.id.colBox);
        gradStudiesBox = findViewById(R.id.gradBox);

        elemSchool = findViewById(R.id.q1Details);
        elemCourse = findViewById(R.id.elemCourse);
        secSchool = findViewById(R.id.secSchool);
        secCourse = findViewById(R.id.q4aDetails);
        vocSchool = findViewById(R.id.q4bDetails);
        vocCourse = findViewById(R.id.q4cDetails);
        colSchool = findViewById(R.id.colSchool);
        colCourse = findViewById(R.id.q2Details);
        gradSchool = findViewById(R.id.gradSchool);
        gradCourse = findViewById(R.id.q3Details);

        button = findViewById(R.id.button);

        secondaryBox.setOnCheckedChangeListener((b, c) -> {
            elementaryBox.setChecked(c);
        });

        collegeBox.setOnCheckedChangeListener((b, c) -> {
            secondaryBox.setChecked(c);
            elementaryBox.setChecked(c);
        });

        gradStudiesBox.setOnCheckedChangeListener((b, c) -> {
            collegeBox.setChecked(c);
            secondaryBox.setChecked(c);
            elementaryBox.setChecked(c);
        });

        updateFields();

        View.OnClickListener updateClick = v -> updateFields();
        elementaryBox.setOnClickListener(updateClick);
        secondaryBox.setOnClickListener(updateClick);
        collegeBox.setOnClickListener(updateClick);
        gradStudiesBox.setOnClickListener(updateClick);

        button.setOnClickListener(v -> {
            if ((elementaryBox.isChecked() && (elemSchool.getText().toString().isEmpty() || elemCourse.getText().toString().isEmpty()))
                    || (secondaryBox.isChecked() && (secSchool.getText().toString().isEmpty() || secCourse.getText().toString().isEmpty()))
                    || (collegeBox.isChecked() && (colSchool.getText().toString().isEmpty() || colCourse.getText().toString().isEmpty()))
                    || (gradStudiesBox.isChecked() && (gradSchool.getText().toString().isEmpty() || gradCourse.getText().toString().isEmpty()))) {
                Toast.makeText(this, "Please complete the selected education fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, Criminal.class);
            Bundle extras = getIntent().getExtras();
            if (extras != null) intent.putExtras(extras);

            intent.putExtra("elemSchool", elemSchool.getText().toString());
            intent.putExtra("elemCourse", elemCourse.getText().toString());
            intent.putExtra("secSchool", secSchool.getText().toString());
            intent.putExtra("secCourse", secCourse.getText().toString());
            intent.putExtra("vocSchool", vocSchool.getText().toString());
            intent.putExtra("vocCourse", vocCourse.getText().toString());
            intent.putExtra("colSchool", colSchool.getText().toString());
            intent.putExtra("colCourse", colCourse.getText().toString());
            intent.putExtra("gradSchool", gradSchool.getText().toString());
            intent.putExtra("gradCourse", gradCourse.getText().toString());

            startActivity(intent);
        });
    }

    void updateFields() {
        elemSchool.setEnabled(elementaryBox.isChecked());
        elemCourse.setEnabled(elementaryBox.isChecked());
        secSchool.setEnabled(secondaryBox.isChecked());
        secCourse.setEnabled(secondaryBox.isChecked());
        colSchool.setEnabled(collegeBox.isChecked());
        colCourse.setEnabled(collegeBox.isChecked());
        gradSchool.setEnabled(gradStudiesBox.isChecked());
        gradCourse.setEnabled(gradStudiesBox.isChecked());

        // Vocational always enabled
        vocSchool.setEnabled(true);
        vocCourse.setEnabled(true);
    }
}