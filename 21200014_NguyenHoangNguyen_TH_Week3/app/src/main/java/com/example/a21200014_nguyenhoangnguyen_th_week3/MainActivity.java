package com.example.a21200014_nguyenhoangnguyen_th_week3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    String registeredUsername = "21200014@email.com";
    String registeredPassword = "21200014";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.edtPassword);
        MaterialButton loginbtn = findViewById(R.id.loginbtn);

        Intent intent = getIntent();
        if (intent != null) {
            String receivedUsername = intent.getStringExtra("username");
            String receivedPassword = intent.getStringExtra("password");

            if (receivedUsername != null && receivedPassword != null) {
                registeredUsername = receivedUsername;
                registeredPassword = receivedPassword;
            }
        }

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals(registeredUsername) &&
                        password.getText().toString().equals(registeredPassword)) {

                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
