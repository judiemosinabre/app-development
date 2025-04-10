package com.example.act2_generalizeduserregistrationmodulev2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Criminal extends AppCompatActivity {
    CheckBox[] yesBoxes, noBoxes;
    EditText[] detailFields;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_criminal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Example: 6 questions
        yesBoxes = new CheckBox[]{
                findViewById(R.id.q1Yes),
                findViewById(R.id.q2Yes),
                findViewById(R.id.q3Yes),
                findViewById(R.id.q4aYes),
                findViewById(R.id.q4bYes),
                findViewById(R.id.q4cYes)
        };

        noBoxes = new CheckBox[]{
                findViewById(R.id.q1No),
                findViewById(R.id.q2No),
                findViewById(R.id.q3No),
                findViewById(R.id.q4aNo),
                findViewById(R.id.q4bNo),
                findViewById(R.id.q4cNo)
        };

        detailFields = new EditText[]{
                findViewById(R.id.q1Details),
                findViewById(R.id.q2Details),
                findViewById(R.id.q3Details),
                findViewById(R.id.q4aDetails),
                findViewById(R.id.q4bDetails),
                findViewById(R.id.q4cDetails)
        };

        for (int i = 0; i < yesBoxes.length; i++) {
            int index = i;

            yesBoxes[i].setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    noBoxes[index].setChecked(false);
                    detailFields[index].setEnabled(true);
                } else {
                    detailFields[index].setEnabled(false);
                    detailFields[index].setText("");
                }
            });

            noBoxes[i].setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    yesBoxes[index].setChecked(false);
                    detailFields[index].setEnabled(false);
                    detailFields[index].setText("");
                }
            });
        }

        submitButton = findViewById(R.id.newButton);

        submitButton.setOnClickListener(v -> {
            for (int i = 0; i < yesBoxes.length; i++) {
                boolean yes = yesBoxes[i].isChecked();
                boolean no = noBoxes[i].isChecked();

                if (!yes && !no) {
                    Toast.makeText(this, "Please answer all questions", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (yes && detailFields[i].getText().toString().isEmpty()) {
                    Toast.makeText(this, "Please provide details for Question " + (i + 1), Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            // Proceed to ReportActivity
            Intent intent = new Intent(this, Report.class);
            intent.putExtras(getIntent().getExtras());

            for (int i = 0; i < yesBoxes.length; i++) {
                String answer = yesBoxes[i].isChecked() ? "Yes" : "No";
                intent.putExtra("q" + (i + 1), answer);
                intent.putExtra("d" + (i + 1), detailFields[i].getText().toString());
            }

            startActivity(intent);
        });
    }
}