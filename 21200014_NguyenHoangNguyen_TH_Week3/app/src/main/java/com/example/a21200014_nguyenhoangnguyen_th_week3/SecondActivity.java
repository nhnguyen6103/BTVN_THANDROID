package com.example.a21200014_nguyenhoangnguyen_th_week3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;

public class SecondActivity extends AppCompatActivity {
    String registeredUsername = "21200014@email.com";
    String registeredPassword = "21200014";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        MaterialButton loginbtn2 = findViewById(R.id.loginbtn2);
        MaterialButton signupbtn2 = findViewById(R.id.signupbtn2);

        Intent intent = getIntent();
        if (intent != null) {
            String receivedUsername = intent.getStringExtra("username");
            String receivedPassword = intent.getStringExtra("password");

            if (receivedUsername != null && receivedPassword != null) {
                registeredUsername = receivedUsername;
                registeredPassword = receivedPassword;
            }
        }

        loginbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = username.getText().toString();
                String inputPassword = password.getText().toString();

                if (inputUsername.equals(registeredUsername) && inputPassword.equals(registeredPassword)) {
                    Toast.makeText(SecondActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    intent.putExtra("username", registeredUsername);
                    intent.putExtra("password", registeredPassword);
                    startActivity(intent);
                } else {
                    Toast.makeText(SecondActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signupbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}
