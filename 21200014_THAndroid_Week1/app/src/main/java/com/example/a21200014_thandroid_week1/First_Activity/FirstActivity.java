package com.example.a21200014_thandroid_week1.First_Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a21200014_thandroid_week1.MainActivity;
import com.example.a21200014_thandroid_week1.R;
import com.example.a21200014_thandroid_week1.Second_Activity.SecondActivity;

import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.content.pm.PackageManager;

public class FirstActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST_CODE = 100;

    TextView name, id, studentClass, phone, grade, major, future;
    Button backBtn, callBtn, smsBtn;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activty_second);

        init();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.info), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bấm vào ImageView để mở camera
        imageView.setOnClickListener(v -> openCamera());
    }

    private void init() {
        this.name = findViewById(R.id.name);
        this.id = findViewById(R.id.id);
        this.studentClass = findViewById(R.id.studentClass);
        this.phone = findViewById(R.id.phone);
        this.grade = findViewById(R.id.grade);
        this.major = findViewById(R.id.major);
        this.future = findViewById(R.id.future);

        this.backBtn = findViewById(R.id.backBtn);
        this.callBtn = findViewById(R.id.callBtn);
        this.smsBtn = findViewById(R.id.smsBtn);

        this.imageView = findViewById(R.id.avatar);

        SecondActivity student = getIntent().getSerializableExtra("student", SecondActivity.class);

        this.backBtn.setOnClickListener(v -> switchIntent());
        this.callBtn.setOnClickListener(v -> call());
        this.smsBtn.setOnClickListener(v -> sms());

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        if (byteArray != null) {
            Bitmap imageBitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            this.imageView.setImageBitmap(imageBitmap);
        }

        this.setInfo(student);
    }

    private void setInfo(SecondActivity student) {
        if (student == null) {
            return;
        }
        this.name.setText(student.getName());
        this.id.setText(student.getId());
        this.studentClass.setText(student.getStudentClass());
        this.phone.setText(student.getPhone());
        this.grade.setText(student.getGrade());
        this.major.setText(student.getMajor());
        this.future.setText(student.getDevelopmentPlan());
    }

    private void switchIntent() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void call() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + this.phone.getText().toString()));
        startActivity(intent);
    }

    private void sms() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + this.phone.getText().toString()));
        startActivity(intent);
    }

    private void openCamera() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
        } else {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
            } else {
                Toast.makeText(this, "Không tìm thấy ứng dụng Camera!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        } else {
            Toast.makeText(this, "Chụp ảnh không thành công!", Toast.LENGTH_SHORT).show();
        }
    }
}
