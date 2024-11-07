package com.example.quorooms.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quorooms.MainActivity;
import com.example.quorooms.R;
import com.example.quorooms.ui.signup.SignUpActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText emailField, passwordField;
    private Button loginButton;
    private TextView signUpLink; // Add TextView for Sign Up

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Hide the toolbar (action bar)
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        emailField = findViewById(R.id.loginEmail);
        passwordField = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);
        signUpLink = findViewById(R.id.signUpLink); // Initialize Sign Up TextView



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                // Assuming you have a login check method
                if (isValidLogin(email, password)) {
                    // Save login status in SharedPreferences
                    SharedPreferences sharedPref = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();

                    // Redirect to MainActivity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid login", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Handle Sign Up Link Click
        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to SignUpActivity
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean isValidLogin(String email, String password) {
        // Perform your authentication check here (e.g., with a server or local validation)
        return true; // Replace with actual login check
    }
}
