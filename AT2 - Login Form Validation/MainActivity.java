package com.example.loginformvalidation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText usernameInput;
    TextInputEditText passwordInput;

    String username = "John Doe";
    String password = "password";

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

        usernameInput = findViewById(R.id.usernameTxt);
        passwordInput = findViewById(R.id.passwordTxt);


    }

    public void loginValidation(View v) {
        String inputUsername = usernameInput.getText().toString();
        String inputPassword = passwordInput.getText().toString();

        // Check if not empty
        if (!usernameInput.getText().isEmpty() && !passwordInput.getText().isEmpty()) {
            // Check if username exists
            if (inputUsername.equals(username)) {
                // Check if username and password matched the stored data || If password is correct
                if (inputPassword.equals(password)) {
                    Intent i = new Intent(this, Receiver.class);
                    i.putExtra("usernameData", username);
                    startActivity(i);
                }
                else {
                    Toast.makeText(this, "Incorrect Username or Password.", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(this, "Username does not exist.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please fill the required fields.", Toast.LENGTH_SHORT).show();
        }
    }
}