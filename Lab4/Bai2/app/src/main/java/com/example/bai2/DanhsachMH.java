package com.example.bai2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DanhsachMH extends AppCompatActivity {
    ListView lv;
     Button btnTve, btnThoat;
     final String dsmh[] = {"Công nghệ Phần mềm", "Web", "Di động", "Giao diện", "Mạng máy tính", "Hệ điều hành"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danhsach_mh);
       initControl();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void initControl(){
        btnTve = findViewById(R.id.btnTroVe);
        btnThoat = findViewById(R.id.btnThoat);
        lv = findViewById(R.id.lv);
        ArrayAdapter adap = new ArrayAdapter(DanhsachMH.this, android.R.layout.simple_list_item_1,dsmh);
        lv.setAdapter(adap);
        btnTve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}