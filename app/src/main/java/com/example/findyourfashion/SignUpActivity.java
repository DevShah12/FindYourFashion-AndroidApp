package com.example.findyourfashion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText, addressEditText, securityQEditText, securityAEditText;
    Button createAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        emailEditText = findViewById(R.id.signup_email);
        passwordEditText = findViewById(R.id.signup_password);
        addressEditText = findViewById(R.id.signup_address);
        securityQEditText = findViewById(R.id.signup_security_question);
        securityAEditText = findViewById(R.id.signup_security_answer);
        createAccountBtn = findViewById(R.id.create_account_button);

        createAccountBtn.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String address = addressEditText.getText().toString().trim();
            String securityQ = securityQEditText.getText().toString().trim();
            String securityA = securityAEditText.getText().toString().trim();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)
                    || TextUtils.isEmpty(address) || TextUtils.isEmpty(securityQ) || TextUtils.isEmpty(securityA)) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("email", email);
            editor.putString("password", password);
            editor.putString("address", address);
            editor.putString("security_question", securityQ);
            editor.putString("security_answer", securityA);

            editor.putString("temp_email", email);
            editor.putString("temp_password", password);

            editor.apply();

            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
