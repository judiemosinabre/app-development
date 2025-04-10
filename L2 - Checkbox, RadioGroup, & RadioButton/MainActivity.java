package com.example.loginmodule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

//    Boolean chkStrElem = false;
//    Boolean chkStrSecondary = false;
//    Boolean chkStrTertiary = false;
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

        CheckBox chkAccept = findViewById(R.id.chkAccept);
        chkAccept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Button btnSubmit = findViewById(R.id.btnSubmit);
                if(isChecked) {
                    btnSubmit.setEnabled(true);
                }
                else {
                    btnSubmit.setEnabled(false);
                }
            }
        });
    }

    public void funcSubmit(View v) {
        CheckBox chkElem = findViewById(R.id.chkElem);
        CheckBox chkSecondary = findViewById(R.id.chkSecondary);
        CheckBox chkTertiary = findViewById(R.id.chkTertiary);

        String educ = "";
        if (chkElem.isChecked()) {
            educ += "Elementary ";
        }
        if (chkSecondary.isChecked()) {
            educ += "Secondary ";
        }
        if (chkTertiary.isChecked()) {
            educ += "Tertiary ";
        }

        Intent i = new Intent(this, Dashboard.class);
        i.putExtra("educ", educ);
        startActivity(i);
    }

    public void funcRed(View v) {
        RadioButton rbRed = findViewById(R.id.rbRed);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        if (rbRed.isChecked()) {
            btnSubmit.setBackgroundColor(getResources().getColor(R.color.red));
        }
    }

    public void funcGreen(View v) {
        RadioButton rbGreen = findViewById(R.id.rbGreen);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        if (rbGreen.isChecked()) {
            btnSubmit.setBackgroundColor(getResources().getColor(R.color.green));
        }
    }

//    public void funcChkElem(View v) {
//        CheckBox chkElem = findViewById(R.id.chkElem);
//        chkStrElem = chkElem.isChecked();
//    }
//
//    public void funcChkSecondary(View v) {
//        CheckBox chkSecondary = findViewById(R.id.chkSecondary);
//        chkStrSecondary = chkSecondary.isChecked();
//    }
//
//    public void funcChkTertiary(View v) {
//        CheckBox chkTertiary = findViewById(R.id.chkTertiary);
//        chkStrTertiary = chkTertiary.isChecked();
//    }
}