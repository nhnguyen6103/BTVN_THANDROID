package com.example.tinhbankinhhinhtron;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstActivity extends AppCompatActivity {
    Button btnend;
    EditText edta, edtkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first);

        edta = findViewById(R.id.editTextNumberDecimal);
        edtkq = findViewById(R.id.editTextNumberDecimal2);
        btnend = findViewById(R.id.button);
        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent myinIntent = new Intent(FirstActivity.this, MainActivity.class);
                int a = Integer.parseInt(edta.getText().toString());
                myinIntent.putExtra("soa", a);
                startActivityForResult(myinIntent,99);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == 33) {
            double cv = data.getDoubleExtra("data", 0);
            edtkq.setText("Chu vi: " + cv + "cm");
        }
        if (requestCode == 99 && resultCode == 66) {
            double dt = data.getDoubleExtra("data", 0);
            edtkq.setText("Diện tích: " + dt + "cm2");
        }
    }
}
