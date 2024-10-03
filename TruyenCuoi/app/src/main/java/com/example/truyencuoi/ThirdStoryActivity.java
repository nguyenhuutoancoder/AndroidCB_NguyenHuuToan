package com.example.truyencuoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ThirdStoryActivity extends AppCompatActivity {
    TextView txtStoryName, txtItemName, tvContent;
    ImageButton btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third_story);
        initControl();
        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void initControl(){
        Intent intent2 = getIntent();
        String storyName = intent2.getStringExtra("story_name");
        String itemName = intent2.getStringExtra("item_name");

        txtStoryName = findViewById(R.id.txtName);
        txtItemName = findViewById((R.id.txtNameStory));

        txtStoryName.setText(storyName);
        txtItemName.setText(itemName);

        tvContent = findViewById(R.id.tvContent);

        switch (itemName) {
            case "Việc học":
                tvContent.setText(R.string.viec_hoc);
                break;
            case "Đã hai lần rồi":
                tvContent.setText(R.string.da_hai_lan_roi);
                break;
            case "Cũng như nhau":
                tvContent.setText(R.string.cung_nhu_nhau);
                break;
            case "Rất lạnh":
                tvContent.setText(R.string.rat_lanh);
                break;
            case "Im lặng là vàng":
                tvContent.setText(R.string.im_lang_la_vang);
                break;
            case "Bài học về tội nói dối":
                tvContent.setText(R.string.bai_hoc_ve_toi_noi_doi);
                break;
            case "Chưa chi đã đau":
                tvContent.setText(R.string.chua_chi_da_dau);
                break;
            case "1 xu và 1 phút":
                tvContent.setText(R.string.mot_xu_va_mot_phut);
                break;
            case "Sao còn chưa thả?":
                tvContent.setText(R.string.sao_con_chua_tha);
                break;
            case "Di tích hóa thạch":
                tvContent.setText(R.string.di_tich_hoa_thach);
                break;
            case "Nhầm lẫn tai hại":
                tvContent.setText(R.string.nham_lan_tai_hai);
                break;
            case "Cảnh giác":
                tvContent.setText(R.string.canh_giac);
                break;

            default:
                tvContent.setText(R.string.nd_ko_xac_dinh);
                break;
        }

    }

}