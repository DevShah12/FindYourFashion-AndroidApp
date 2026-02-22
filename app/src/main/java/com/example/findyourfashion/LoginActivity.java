package com.example.findyourfashion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;
    Button loginButton, signupButton;
    TextView forgotPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signupButton);
        forgotPasswordText = findViewById(R.id.forgotPasswordText);

        // Autofill email & password
        SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String prefillEmail = prefs.getString("temp_email", "");
        String prefillPassword = prefs.getString("temp_password", "");

        usernameEditText.setText(prefillEmail);
        passwordEditText.setText(prefillPassword);

        loginButton.setOnClickListener(v -> loginUser());
        signupButton.setOnClickListener(v -> {
            startActivity(new Intent(this, SignUpActivity.class));
            finish();
        });

        forgotPasswordText.setOnClickListener(v -> {
            startActivity(new Intent(this, RecoverPasswordActivity.class));
            finish();
        });
    }

    private void loginUser() {
        SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String savedEmail = prefs.getString("email", null);
        String savedPass = prefs.getString("password", null);

        String inputEmail = usernameEditText.getText().toString().trim();
        String inputPass = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(inputEmail) || TextUtils.isEmpty(inputPass)) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (savedEmail != null && savedPass != null &&
                savedEmail.equals(inputEmail) && savedPass.equals(inputPass)) {

            prefs.edit().putBoolean("loggedIn", true).apply(); // Save login flag
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, HomeActivity.class));
            finish();

        } else {
            Toast.makeText(this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
        }
    }
}
