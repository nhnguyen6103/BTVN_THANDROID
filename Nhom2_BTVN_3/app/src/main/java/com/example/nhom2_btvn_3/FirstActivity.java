package com.example.nhom2_btvn_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    private EditText userInputField;
    private TextView teacherFeedbackText;
    private static final int REVIEW_REQUEST = 99;
    private static final int TEACHER_RESULT = 33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first);

        userInputField = findViewById(R.id.userInputField);
        teacherFeedbackText = findViewById(R.id.teacherFeedbackText);
        Button reviewButton = findViewById(R.id.reviewButton);

        reviewButton.setOnClickListener(v -> {
            String input = userInputField.getText().toString();
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("studentText", input);
            startActivityForResult(intent, REVIEW_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REVIEW_REQUEST && resultCode == TEACHER_RESULT && data != null) {
            String corrected = data.getStringExtra("correctedText");
            teacherFeedbackText.setText(corrected);
            teacherFeedbackText.setVisibility(View.VISIBLE);
            findViewById(R.id.teacherFeedbackTitle).setVisibility(View.VISIBLE);
        }
    }
}
