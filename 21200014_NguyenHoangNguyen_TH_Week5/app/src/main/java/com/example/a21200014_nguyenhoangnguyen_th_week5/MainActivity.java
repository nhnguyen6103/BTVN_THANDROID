package com.example.a21200014_nguyenhoangnguyen_th_week5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Grape","55 Calories",R.drawable.a));
        items.add(new Item("Apple","43 Calories",R.drawable.b));
        items.add(new Item("Orange","23 Calories",R.drawable.c));
        items.add(new Item("Watermelon","66 Calories",R.drawable.d));
        items.add(new Item("Banana","20 Calories",R.drawable.e));
        items.add(new Item("Pipeapple","65 Calories",R.drawable.f));
        items.add(new Item("Magosteen","13 Calories",R.drawable.g));
        items.add(new Item("Grape","55 Calories",R.drawable.a));
        items.add(new Item("Apple","43 Calories",R.drawable.b));
        items.add(new Item("Orange","23 Calories",R.drawable.c));
        items.add(new Item("Watermelon","66 Calories",R.drawable.d));
        items.add(new Item("Banana","20 Calories",R.drawable.e));
        items.add(new Item("Pipeapple","65 Calories",R.drawable.f));
        items.add(new Item("Magosteen","13 Calories",R.drawable.g));




        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));

    }
}