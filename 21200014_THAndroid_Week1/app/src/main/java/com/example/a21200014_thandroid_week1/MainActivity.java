package com.example.a21200014_thandroid_week1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import android.content.pm.PackageManager;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a21200014_thandroid_week1.First_Activity.FirstActivity;
import com.example.a21200014_thandroid_week1.Second_Activity.SecondActivity;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText id;
    private EditText studentClass;
    private EditText phone;
    private EditText development;
    private RadioGroup gradeRadioGroup, majorRadioGroup;
    private Button submitBtn;
    private ImageButton cameraBtn;

    private static final int REQUEST_IMAGE_CAPTURE = 1888;
    private Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first);
        init();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void init() {
        this.name = findViewById(R.id.name);
        this.id = findViewById(R.id.id);
        this.studentClass = findViewById(R.id.studentClass);
        this.phone = findViewById(R.id.phone);
        this.development = findViewById(R.id.developmentPlan);

        this.gradeRadioGroup = findViewById(R.id.gradeRadioGroup);
        this.majorRadioGroup = findViewById(R.id.majorRadioGroup);

        this.submitBtn = findViewById(R.id.submitBtn);
        this.cameraBtn = findViewById(R.id.avatar);

        this.submitBtn.setOnClickListener(v -> submit());
        this.cameraBtn.setOnClickListener(v -> takePicture());
    }

    private String getMajor(RadioGroup group) {
        int checkedId = group.getCheckedRadioButtonId();

        if (checkedId == -1) {
            return "";
        }

        RadioButton checkedRadioButton = group.findViewById(checkedId);
        return checkedRadioButton.getContentDescription() != null ?
                checkedRadioButton.getContentDescription().toString() : "Unknown major";
    }

    private String getGrade(RadioGroup group) {
        int checkedId = group.getCheckedRadioButtonId();

        if (checkedId == -1) {
            return "";
        }

        RadioButton checkedRadioButton = group.findViewById(checkedId);
        return checkedRadioButton.getContentDescription() != null ?
                checkedRadioButton.getContentDescription().toString() : "Unknown grade";
    }

    private void submit() {
        String name = this.name.getText().toString();
        String id = this.id.getText().toString();
        String studentClass = this.studentClass.getText().toString();
        String phone = this.phone.getText().toString();
        String development = this.development.getText().toString();

        String major = getMajor(this.majorRadioGroup);
        String grade = getGrade(this.gradeRadioGroup);

        SecondActivity st = new SecondActivity(name, id, studentClass, phone, grade, major, development);
        switchIntent(st);
    }

    // Kiểm tra quyền truy cập camera
    private void takePicture() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, REQUEST_IMAGE_CAPTURE);
        } else {
            openCamera();
        }
    }

    // Mở camera để chụp ảnh
    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    // Xử lý kết quả từ yêu cầu cấp quyền camera
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_IMAGE_CAPTURE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openCamera();
        } else {
            Toast.makeText(this, "Permission denied to access camera", Toast.LENGTH_SHORT).show();
        }
    }

    // Xử lý kết quả sau khi chụp ảnh
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            cameraBtn.setImageBitmap(imageBitmap);
        }
    }

    private void switchIntent(SecondActivity st) {
        Intent intent = new Intent(this, FirstActivity.class);
        intent.putExtra("student", st);

        if (imageBitmap != null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            intent.putExtra("image", byteArray);
        }

        startActivity(intent);
    }
}
