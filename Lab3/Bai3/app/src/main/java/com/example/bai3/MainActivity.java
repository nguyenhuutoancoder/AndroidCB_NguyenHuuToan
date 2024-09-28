package com.example.bai3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
   Button btntinhBMI;
   EditText editTen, editCCao, editCNang, editBMI, editCDoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tinhBMI();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void tinhBMI(){
        btntinhBMI = findViewById(R.id.btntinhBMI);
        editTen = findViewById(R.id.editTen);
        editCCao = findViewById(R.id.editCCao);
        editCNang = findViewById(R.id.editCNang);
        editBMI = findViewById(R.id.editBMI);
        editCDoan = findViewById(R.id.editCDoan);

        btntinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               
                try {
                    double H = Double.parseDouble(editCCao.getText().toString());
                    double W = Double.parseDouble(editCNang.getText().toString());
                    double BMI = W / Math.pow(H, 2);

                    String chuandoan = "";
                    if (BMI < 18) {
                        chuandoan = "Bạn gầy";
                    } else if (BMI <= 24.9) {
                        chuandoan = "Bạn bình thường";
                    } else if (BMI <= 29.9) {
                        chuandoan = "Bạn béo phì độ 1";
                    } else if (BMI <= 34.9) {
                        chuandoan = "Bạn béo phì độ 2";
                    } else {
                        chuandoan = "Bạn béo phì độ 3";
                    }

                    DecimalFormat dcf = new DecimalFormat("#.0");
                    editBMI.setText(dcf.format(BMI));
                    editCDoan.setText(chuandoan);
                } catch (NumberFormatException e) {

                    editBMI.setText("");
                    editCDoan.setText("Vui lòng nhập số hợp lệ");
                }
            }
        });
    }

}