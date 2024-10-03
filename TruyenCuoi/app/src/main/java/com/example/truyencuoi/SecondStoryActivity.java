package com.example.truyencuoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SecondStoryActivity extends AppCompatActivity {
    TextView txtName;
    ImageButton btnReturn;
    ListView lv;
    ArrayList<MyStoriesDetail> myStoriesDetails = new ArrayList<>();
    AdapterStory2 myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_story);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initControl();
        initData();
        lv = findViewById(R.id.lvdetail);
        myadapter = new AdapterStory2(SecondStoryActivity.this, R.layout.layout_item_2, myStoriesDetails);
        lv.setAdapter(myadapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MyStoriesDetail storyDetail = (MyStoriesDetail) lv.getItemAtPosition(i);
                // Lấy tên của mục đã được nhấn
                String itemName = storyDetail.getNamedetail();

                // Lấy story_name từ Intent hiện tại
                String storyName = getIntent().getStringExtra("story_name");
                Intent intent2 = new Intent(SecondStoryActivity.this, ThirdStoryActivity.class);
                // Truyền cả story_name và itemName sang ThirdActivity
                intent2.putExtra("story_name", storyName);
                intent2.putExtra("item_name", itemName);
                startActivity(intent2);
            }
        });
        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void initControl(){
        Intent myintent = getIntent();
        String storyName = myintent.getStringExtra("story_name");
        txtName = findViewById(R.id.txtName);
        txtName.setText(storyName);
    }
    public void initData(){
        myStoriesDetails.add(new MyStoriesDetail(R.drawable.baseline_tag_faces_24, "Việc học"));
        myStoriesDetails.add(new MyStoriesDetail(R.drawable.baseline_tag_faces_24, "Đã hai lần rồi"));
        myStoriesDetails.add(new MyStoriesDetail(R.drawable.baseline_tag_faces_24, "Cũng như nhau"));
        myStoriesDetails.add(new MyStoriesDetail(R.drawable.baseline_tag_faces_24, "Rất lạnh"));
        myStoriesDetails.add(new MyStoriesDetail(R.drawable.baseline_tag_faces_24, "Im lặng là vàng"));
        myStoriesDetails.add(new MyStoriesDetail(R.drawable.baseline_tag_faces_24, "Bài học về tội nói dối"));
        myStoriesDetails.add(new MyStoriesDetail(R.drawable.baseline_tag_faces_24, "Chưa chi đã đau"));
        myStoriesDetails.add(new MyStoriesDetail(R.drawable.baseline_tag_faces_24, "1 xu và 1 phút"));
        myStoriesDetails.add(new MyStoriesDetail(R.drawable.baseline_tag_faces_24, "Sao còn chưa thả?"));
        myStoriesDetails.add(new MyStoriesDetail(R.drawable.baseline_tag_faces_24, "Di tích hóa thạch"));
        myStoriesDetails.add(new MyStoriesDetail(R.drawable.baseline_tag_faces_24, "Nhầm lẫn tai hại"));
        myStoriesDetails.add(new MyStoriesDetail(R.drawable.baseline_tag_faces_24, "Cảnh giác"));
    }


}