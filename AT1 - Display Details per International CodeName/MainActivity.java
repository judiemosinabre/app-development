package com.example.appdevlesson1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public void submit(View v) {
        // v.setEnabled(false);
        String description;
        EditText txtInput = findViewById(R.id.txtInput);
        String name = txtInput.getText().toString();

        TextView txtOutput = findViewById(R.id.txtOutput);
        txtOutput.setText("Hello Mr/Ms. " + name);

        if (name.equalsIgnoreCase("cupcake")) {
            txtOutput.setText("Release Date: April 27, 2009\n" +
                    "Version Number: 1.5\n" +
                    "Description: Introduced the first on-screen keyboard, home screen widgets, and video recording support. This was the first version to use a dessert-themed codename.");
        }
        else if (name.equalsIgnoreCase("donut")) {
            txtOutput.setText("Release Date: September 15, 2009\n" +
                    "Version Number: 1.6\n" +
                    "Description: Improved support for different screen sizes, introduced a faster search experience, and added support for CDMA networks.");
        }
        else if (name.equalsIgnoreCase("eclair")) {
            txtOutput.setText("Release Date: October 26, 2009\n" +
                    "Version Number: 2.0–2.1\n" +
                    "Description: Brought major UI improvements, support for live wallpapers, Google Maps navigation, and multiple account sign-ins.");
        }
        else if (name.equalsIgnoreCase("froyo")) {
            txtOutput.setText("Release Date: May 20, 2010\n" +
                    "Version Number: 2.2\n" +
                    "Description: Introduced performance optimizations, support for Adobe Flash, Wi-Fi hotspot functionality, and the first implementation of the Android Market auto-update feature.");
        }
        else if (name.equalsIgnoreCase("gingerbread")) {
            txtOutput.setText("Release Date: December 6, 2010\n" +
                    "Version Number: 2.3\n" +
                    "Description: Improved UI responsiveness, introduced support for NFC (near-field communication), and optimized power management for better battery life.");
        }
        else if (name.equalsIgnoreCase("honeycomb")) {
            txtOutput.setText("Release Date: February 22, 2011\n" +
                    "Version Number: 3.0–3.2\n" +
                    "Description: Designed specifically for tablets, featuring a new holographic UI, improved multitasking, and support for dual-core processors.");
        }
        else if (name.equalsIgnoreCase("ice cream sandwich")) {
            txtOutput.setText("Release Date: October 18, 2011\n" +
                    "Version Number: 4.0\n" +
                    "Description: Unified the phone and tablet UI, introduced the 'Holo' design language, Face Unlock, and better app management.");
        }
        else if (name.equalsIgnoreCase("jellybean")) {
            txtOutput.setText("Release Date: July 9, 2012\n" +
                    "Version Number: 4.1–4.3\n" +
                    "Description: Brought 'Project Butter' for smoother UI performance, Google Now, expandable notifications, and improved voice search.");
        }
        else if (name.equalsIgnoreCase("kitkat")) {
            txtOutput.setText("Release Date: October 31, 2013\n" +
                    "Version Number: 4.4\n" +
                    "Description: Improved memory management, introduced immersive mode for full-screen apps, and optimized the OS for lower-end devices.");
        }
        else {
            txtOutput.setText("Type a valid International CodeName");
        }

        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

    }

    public void send(View v) {
        EditText txtInput = findViewById(R.id.txtInput);
        String name = txtInput.getText().toString();

        Intent i = new Intent(this, Receiver.class);
        i.putExtra("output", name);
        startActivity(i);
    }
}