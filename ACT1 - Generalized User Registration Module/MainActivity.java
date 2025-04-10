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

public class MainActivity extends AppCompatActivity {

    private EditText firstName, middleName, lastName, email, phone, height, weight;
    private EditText pagibig, philhealth, tin, gsis;
    private EditText emergencyName, emergencyContact, emergencyRelation;
    private Button nextBtn;

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

        // Initializing input fields
        firstName = findViewById(R.id.firsttxt);
        middleName = findViewById(R.id.middletxt);
        lastName = findViewById(R.id.lasttxt);
        email = findViewById(R.id.emailtxt);
        phone = findViewById(R.id.phonetxt);
        height = findViewById(R.id.heighttxt);
        weight = findViewById(R.id.weighttxt);
        pagibig = findViewById(R.id.pagibigtxt);
        philhealth = findViewById(R.id.philhealthtxt);
        tin = findViewById(R.id.tintxt);
        gsis = findViewById(R.id.gsistxt);
        emergencyName = findViewById(R.id.emnametxt);
        emergencyContact = findViewById(R.id.emcontacttxt);
        emergencyRelation = findViewById(R.id.emrelationshiptxt);
        nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(view -> {
            // Validate required fields
            if (isEmpty(firstName) || isEmpty(lastName) || isEmpty(email) || isEmpty(phone) ||
                    isEmpty(height) || isEmpty(weight) || isEmpty(emergencyName) ||
                    isEmpty(emergencyContact) || isEmpty(emergencyRelation)) {

                Toast.makeText(MainActivity.this, "Please fill in all required fields!", Toast.LENGTH_SHORT).show();
            } else {
                // Pass data to next activity
                Intent intent = new Intent(MainActivity.this, BackgroundDetails.class);
                intent.putExtra("personalInfo", getPersonalInfo());
                startActivity(intent);
            }
        });
    }

    // Helper method to check if EditText is empty
    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    // Helper method to format personal information
    private String getPersonalInfo() {
        return "Name: " + firstName.getText().toString() + " " + middleName.getText().toString() + " " + lastName.getText().toString() +
                "\nEmail: " + email.getText().toString() +
                "\nPhone: " + phone.getText().toString() +
                "\nHeight: " + height.getText().toString() + "m" +
                "\nWeight: " + weight.getText().toString() + "kg" +
                "\nEmergency Contact: " + emergencyName.getText().toString() +
                "\nContact: " + emergencyContact.getText().toString() +
                "\nRelationship: " + emergencyRelation.getText().toString();
    }
}