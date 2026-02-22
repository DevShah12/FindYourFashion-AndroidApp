package com.example.findyourfashion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecoverPasswordActivity extends AppCompatActivity {

    EditText emailInput, securityAnswerInput, newPasswordInput;
    Button resetPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);

        emailInput = findViewById(R.id.recover_email);
        securityAnswerInput = findViewById(R.id.recover_security_answer);
        newPasswordInput = findViewById(R.id.recover_new_password);
        resetPasswordButton = findViewById(R.id.reset_password_button);

        resetPasswordButton.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);

            String storedEmail = prefs.getString("email", null);
            String storedAnswer = prefs.getString("security_answer", null);

            String inputEmail = emailInput.getText().toString().trim();
            String inputAnswer = securityAnswerInput.getText().toString().trim();
            String newPass = newPasswordInput.getText().toString().trim();

            if (TextUtils.isEmpty(inputEmail) || TextUtils.isEmpty(inputAnswer) || TextUtils.isEmpty(newPass)) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (inputEmail.equals(storedEmail) && inputAnswer.equalsIgnoreCase(storedAnswer)) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("password", newPass);
                editor.putString("temp_email", inputEmail);
                editor.putString("temp_password", newPass);
                editor.apply();

                Toast.makeText(this, "Password updated! You can now log in.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Incorrect email or answer.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
