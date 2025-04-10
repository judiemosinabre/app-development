package com.example.calculatorat3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    TextView txtAnswer;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    CheckBox chkEnabled;

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

        // Initialize views
        edtNum1 = findViewById(R.id.edtNum2);
        edtNum2 = findViewById(R.id.edtNum1);
        txtAnswer = findViewById(R.id.txtAnswer);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        chkEnabled = findViewById(R.id.chkEnabled);

//        CheckBox chkEnabled = findViewById(R.id.chkEnabled);
        chkEnabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                btnAdd.setEnabled(isChecked);
                btnSubtract.setEnabled(isChecked);
                btnMultiply.setEnabled(isChecked);
                btnDivide.setEnabled(isChecked);
            }
        });
    }

    public void calculate(View view) {
        if (edtNum1.getText().toString().isEmpty() || edtNum2.getText().toString().isEmpty()) {
            txtAnswer.setText("Enter both numbers");
            return;
        }

        try {
            double num1 = Double.parseDouble(edtNum2.getText().toString());
            double num2 = Double.parseDouble(edtNum1.getText().toString());
            double result = 0.0;

            int id = view.getId(); // Get the ID of the clicked button
            if (id == R.id.btnAdd) {
                result = num1 + num2;
            } else if (id == R.id.btnSubtract) {
                result = num1 - num2;
            } else if (id == R.id.btnMultiply) {
                result = num1 * num2;
            } else if (id == R.id.btnDivide) {
                if (num2 == 0) {
                    txtAnswer.setText("Error: Divide by 0");
                    return;
                }
                result = num1 / num2;
            }

            txtAnswer.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            txtAnswer.setText("Invalid Input");
        }
    }


    public void funcGreen(View v) {
        RadioButton rbGreen = findViewById(R.id.rbGreen);
        if (rbGreen.isChecked()) {
            btnAdd.setBackgroundColor(getResources().getColor(R.color.green));
            btnSubtract.setBackgroundColor(getResources().getColor(R.color.green));
            btnMultiply.setBackgroundColor(getResources().getColor(R.color.green));
            btnDivide.setBackgroundColor(getResources().getColor(R.color.green));
        }
    }

    public void funcBlue(View v) {
        RadioButton rbBlue = findViewById(R.id.rbBlue);
        if (rbBlue.isChecked()) {
            btnAdd.setBackgroundColor(getResources().getColor(R.color.blue));
            btnSubtract.setBackgroundColor(getResources().getColor(R.color.blue));
            btnMultiply.setBackgroundColor(getResources().getColor(R.color.blue));
            btnDivide.setBackgroundColor(getResources().getColor(R.color.blue));
        }
    }

    public void funcRed(View v) {
        RadioButton rbRed = findViewById(R.id.rbRed);
        if (rbRed.isChecked()) {
            btnAdd.setBackgroundColor(getResources().getColor(R.color.red));
            btnSubtract.setBackgroundColor(getResources().getColor(R.color.red));
            btnMultiply.setBackgroundColor(getResources().getColor(R.color.red));
            btnDivide.setBackgroundColor(getResources().getColor(R.color.red));
        }
    }

    public void funcDark(View v) {
        RadioButton rbDark = findViewById(R.id.rbDark);
        if (rbDark.isChecked()) {
            btnAdd.setBackgroundColor(getResources().getColor(R.color.dark));
            btnSubtract.setBackgroundColor(getResources().getColor(R.color.dark));
            btnMultiply.setBackgroundColor(getResources().getColor(R.color.dark));
            btnDivide.setBackgroundColor(getResources().getColor(R.color.dark));
        }
    }


}