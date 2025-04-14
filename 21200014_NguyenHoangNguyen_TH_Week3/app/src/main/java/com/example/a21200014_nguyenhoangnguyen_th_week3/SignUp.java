package com.example.a21200014_nguyenhoangnguyen_th_week3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        EditText signup_username = findViewById(R.id.signup_username);
        EditText signup_password = findViewById(R.id.signup_password);
        MaterialButton signupbtn = findViewById(R.id.signupbtn);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameText = signup_username.getText().toString();
                String passwordText = signup_password.getText().toString();

                if (usernameText.isEmpty() || passwordText.isEmpty()) {
                    Toast.makeText(SignUp.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUp.this, "Sign up successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SignUp.this, SecondActivity.class);
                    intent.putExtra("username", usernameText);
                    intent.putExtra("password", passwordText);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
