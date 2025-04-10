package com.example.act2_generalizeduserregistrationmodulev2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Report extends AppCompatActivity {
    TextView reportView;
    Button newButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_report);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        reportView = findViewById(R.id.reportView);
        newButton = findViewById(R.id.newButton);

        Intent intent = getIntent();
        StringBuilder builder = new StringBuilder();

        // --- Personal Background ---
        builder.append("🔹 PERSONAL BACKGROUND\n");
        builder.append("Name: ").append(intent.getStringExtra("firstName")).append(" ")
                .append(intent.getStringExtra("middleName")).append(" ")
                .append(intent.getStringExtra("lastName")).append("\n");
        builder.append("Email: ").append(intent.getStringExtra("email")).append("\n");
        builder.append("Gender: ").append(intent.getStringExtra("gender")).append("\n");
        builder.append("Phone: ").append(intent.getStringExtra("phone")).append("\n");
        builder.append("Height: ").append(intent.getStringExtra("height")).append(" m\n");
        builder.append("Weight: ").append(intent.getStringExtra("weight")).append(" kg\n");
        builder.append("Civil Status: ").append(intent.getStringExtra("civilStatus")).append("\n");
        builder.append("Pagibig No: ").append(intent.getStringExtra("pagibig")).append("\n");
        builder.append("Philhealth No: ").append(intent.getStringExtra("philhealth")).append("\n");
        builder.append("TIN No: ").append(intent.getStringExtra("tin")).append("\n");
        builder.append("GSIS No: ").append(intent.getStringExtra("gsis")).append("\n");
        builder.append("Emergency Contact: ").append(intent.getStringExtra("emergencyName")).append(" (")
                .append(intent.getStringExtra("relationship")).append(")\n");
        builder.append("Contact Number: ").append(intent.getStringExtra("emergencyContact")).append("\n\n");

        builder.append("🎓 EDUCATIONAL BACKGROUND\n");
        String elemSchool = intent.getStringExtra("elemSchool");
        String elemCourse = intent.getStringExtra("elemCourse");
        if (elemSchool != null && !elemSchool.isEmpty()) {
            builder.append("Elementary: ").append(elemSchool)
                    .append(" - ").append(elemCourse).append("\n");
        }

        String secSchool = intent.getStringExtra("secSchool");
        String secCourse = intent.getStringExtra("secCourse");
        if (secSchool != null && !secSchool.isEmpty()) {
            builder.append("Secondary: ").append(secSchool)
                    .append(" - ").append(secCourse).append("\n");
        }

        String vocSchool = intent.getStringExtra("vocSchool");
        String vocCourse = intent.getStringExtra("vocCourse");
        if (vocSchool != null && !vocSchool.isEmpty()) {
            builder.append("Vocational: ").append(vocSchool)
                    .append(" - ").append(vocCourse).append("\n");
        }

        String colSchool = intent.getStringExtra("colSchool");
        String colCourse = intent.getStringExtra("colCourse");
        if (colSchool != null && !colSchool.isEmpty()) {
            builder.append("College: ").append(colSchool)
                    .append(" - ").append(colCourse).append("\n");
        }

        String gradSchool = intent.getStringExtra("gradSchool");
        String gradCourse = intent.getStringExtra("gradCourse");
        if (gradSchool != null && !gradSchool.isEmpty()) {
            builder.append("Graduate Studies: ").append(gradSchool)
                    .append(" - ").append(gradCourse).append("\n");
        }

        builder.append("\n");

        // --- Criminal Background ---
        builder.append("🛡️ CRIMINAL BACKGROUND\n");
        for (int i = 1; i <= 6; i++) {
            String answer = intent.getStringExtra("q" + i);
            String detail = intent.getStringExtra("d" + i);
            builder.append("Q").append(i).append(": ").append(answer);
            if (answer != null && answer.equals("Yes")) {
                builder.append(" - ").append(detail);
            }
            builder.append("\n");
        }

        reportView.setText(builder.toString());

        newButton.setOnClickListener(v -> {
            Intent back = new Intent(this, MainActivity.class);
            back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(back);
            finish(); // Clear stack
        });
    }
}