package com.example.truyencuoi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private  RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initData();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void initData() {
       List<MyStories> lsStories = new ArrayList<MyStories>();
        lsStories.add(new MyStories(R.drawable.img, "Công sở"));
        lsStories.add(new MyStories(R.drawable.img_1, "Cười 18"));
        lsStories.add(new MyStories(R.drawable.img_2, "Cực hài"));
        lsStories.add(new MyStories(R.drawable.img_3, "Dân gian"));
        lsStories.add(new MyStories(R.drawable.img_4, "Gia đình"));
        lsStories.add(new MyStories(R.drawable.img_5, "Giao thông"));
        lsStories.add(new MyStories(R.drawable.img_6, "Con trai"));
        lsStories.add(new MyStories(R.drawable.img_7, "Học sinh"));
        lsStories.add(new MyStories(R.drawable.img_8, "Cổ tích"));
        lsStories.add(new MyStories(R.drawable.img_9, "Con gái"));
        lsStories.add(new MyStories(R.drawable.img_10, "Động vật"));

        recyclerView = findViewById(R.id.recyclerView);
        AdapterStory myAdaper = new AdapterStory(lsStories);
        recyclerView.setAdapter(myAdaper);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        //Thiet lap su kien click
        myAdaper.setOnItemClickListener(new AdapterStory.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent myintent = new Intent(MainActivity.this, SecondStoryActivity.class);
                myintent.putExtra("story_name", lsStories.get(position).getName());
                startActivity(myintent);
            }
        });

    }

}