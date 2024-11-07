package com.example.quorooms.ui.signup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quorooms.R;
import com.example.quorooms.ui.login.LoginActivity;

public class SignUpActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView profileImage;
    private EditText email, password, confirmPassword, age, address;
    private TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Hide the toolbar (action bar)
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Initialize Views
        profileImage = findViewById(R.id.profileImage);
        email = findViewById(R.id.signUpEmail);
        password = findViewById(R.id.signUpPassword);
        confirmPassword = findViewById(R.id.signUpConfirmPassword);
        age = findViewById(R.id.signUpAge);
        address = findViewById(R.id.signUpAddress);
        loginLink = findViewById(R.id.loginLink);

        // Set OnClickListener for profile image
        profileImage.setOnClickListener(v -> selectProfileImage());

        // Set OnClickListener for login link
        loginLink.setOnClickListener(v -> navigateToLogin());
    }

    // Method to handle profile image selection
    public void selectProfileImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    // Handle the result of the image selection
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            profileImage.setImageURI(data.getData());  // Set the selected image
        }
    }

    // Method to handle Sign Up button click (You can implement the sign-up functionality here)
    public void signUp(View view) {
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        String userConfirmPassword = confirmPassword.getText().toString();
        String userAge = age.getText().toString();
        String userAddress = address.getText().toString();

        if (userPassword.equals(userConfirmPassword)) {
            // You can add logic here for user registration (e.g., storing data in a database)
            // For now, show a success message
            Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();
        } else {
            // If passwords do not match, show an error message
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to navigate to the Login Activity
    private void navigateToLogin() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();  // Optional: If you don't want to return to this activity from LoginActivity
    }
}
