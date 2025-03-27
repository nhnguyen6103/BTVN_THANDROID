package com.example.nhom2_btvn_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private static final int TEACHER_RESULT = 33;
    private EditText editTextCorrection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTextCorrection = findViewById(R.id.inputReviewText);
        Button sendBackButton = findViewById(R.id.buttonSubmitReview);

        String studentText = getIntent().getStringExtra("studentText");
        editTextCorrection.setText(studentText);

        sendBackButton.setOnClickListener(v -> {
            String correctedText = editTextCorrection.getText().toString().trim();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("correctedText", correctedText);
            setResult(TEACHER_RESULT, resultIntent);
            finish();
        });
    }
}
