package com.example.act2_generalizeduserregistrationmodulev2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText firstName, middleName, lastName, email, phone, height, weight, pagibig, philhealth, tin, gsis, emergencyName, emergencyContact, relationship;
    RadioGroup rgGender, rgCivilStatus;
    RadioButton male, female, lgbtq;
    Button button;

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

        firstName = findViewById(R.id.firstName);
        middleName = findViewById(R.id.middleName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        pagibig = findViewById(R.id.pagibig);
        philhealth = findViewById(R.id.philhealth);
        tin = findViewById(R.id.tin);
        gsis = findViewById(R.id.gsis);
        emergencyName = findViewById(R.id.emergencyName);
        emergencyContact = findViewById(R.id.emergencyContact);
        relationship = findViewById(R.id.relationship);

        rgGender = findViewById(R.id.rgGender);
        rgCivilStatus = findViewById(R.id.rgCivilStatus);

        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            if (firstName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty()
                    || email.getText().toString().isEmpty() || phone.getText().toString().isEmpty()
                    || height.getText().toString().isEmpty() || weight.getText().toString().isEmpty()
                    || emergencyName.getText().toString().isEmpty()
                    || emergencyContact.getText().toString().isEmpty() || relationship.getText().toString().isEmpty()
                    || rgGender.getCheckedRadioButtonId() == -1
                    || rgCivilStatus.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, Education.class);
            intent.putExtra("firstName", firstName.getText().toString());
            intent.putExtra("middleName", middleName.getText().toString());
            intent.putExtra("lastName", lastName.getText().toString());
            intent.putExtra("email", email.getText().toString());
            intent.putExtra("phone", phone.getText().toString());
            intent.putExtra("height", height.getText().toString());
            intent.putExtra("weight", weight.getText().toString());
            intent.putExtra("pagibig", pagibig.getText().toString());
            intent.putExtra("philhealth", philhealth.getText().toString());
            intent.putExtra("tin", tin.getText().toString());
            intent.putExtra("gsis", gsis.getText().toString());
            intent.putExtra("emergencyName", emergencyName.getText().toString());
            intent.putExtra("emergencyContact", emergencyContact.getText().toString());
            intent.putExtra("relationship", relationship.getText().toString());

            intent.putExtra("gender", ((RadioButton) findViewById(rgGender.getCheckedRadioButtonId())).getText().toString());
            intent.putExtra("civilStatus", ((RadioButton) findViewById(rgCivilStatus.getCheckedRadioButtonId())).getText().toString());

            startActivity(intent);
        });
    }
}