package com.example.tinhbankinhhinhtron;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tinhbankinhhinhtron.R;
public class MainActivity extends AppCompatActivity {
    EditText edtkq2;
    Button btnchuvi, btndientich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //ánh xa
        edtkq2= findViewById(R.id.editTextNumberDecimal3);
        btnchuvi = findViewById(R.id.button2);
        btndientich = findViewById(R.id.button3);
        Intent myintIntent = getIntent();
        int soa = myintIntent.getIntExtra("soa", 0);
        edtkq2.setText(soa+"");
        double chuvi = 2*3.14*soa;
        double dientich=3.14*soa*soa;

        btnchuvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myintIntent.putExtra("data",chuvi);
                setResult(33,myintIntent);
                finish();
            }
        });
        btndientich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myintIntent.putExtra("data",dientich);
                setResult(66,myintIntent);
                finish();
            }
        });



//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}