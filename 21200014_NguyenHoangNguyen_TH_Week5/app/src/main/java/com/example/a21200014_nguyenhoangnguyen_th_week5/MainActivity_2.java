package com.example.a21200014_nguyenhoangnguyen_th_week5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Android Grape","VERSION 1.0",R.drawable.a));
        items.add(new Item("Android Apple","VERSION 2.0",R.drawable.b));
        items.add(new Item("Android Orange","VERSION 3.0",R.drawable.c));
        items.add(new Item("Android Watermelon","VERSION 4.0",R.drawable.d));
        items.add(new Item("Android Banana","VERSION 5.0",R.drawable.e));
        items.add(new Item("Android Pipeapple","VERSION 6.0",R.drawable.f));
        items.add(new Item("Android Magosteen","VERSION 7.0",R.drawable.g));
        items.add(new Item("Android Grape","VERSION 1.0",R.drawable.a));
        items.add(new Item("Android Apple","VERSION 2.0",R.drawable.b));
        items.add(new Item("Android Orange","VERSION 3.0",R.drawable.c));
        items.add(new Item("Android Watermelon","VERSION 4.0",R.drawable.d));
        items.add(new Item("Android Banana","VERSION 5.0",R.drawable.e));
        items.add(new Item("Android Pipeapple","VERSION 6.0",R.drawable.f));
        items.add(new Item("Android Magosteen","VERSION 7.0",R.drawable.g));



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter_2(getApplicationContext(),items));

    }
}