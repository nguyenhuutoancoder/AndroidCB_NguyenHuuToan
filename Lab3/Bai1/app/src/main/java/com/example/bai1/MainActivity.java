package com.example.bai1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
      EditText editA, editB;
      TextView txtkq;
      Button btnTong, btnHieu, btnTich, btnThuong,btnUCLN,btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initControl();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void initControl(){
        editA = findViewById(R.id.editA);
        editB = findViewById(R.id.editB);
        txtkq = findViewById(R.id.txtkq);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        btnTich = findViewById(R.id.btnTich);
        btnThuong = findViewById(R.id.btnThuong);
        btnUCLN = findViewById(R.id.btnUCLN);
        btnThoat = findViewById(R.id.btnThoat);

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editA.getText()+ "");
                int b = Integer.parseInt(editB.getText()+ "");
                int result = a + b;
                txtkq.setText(String.valueOf(result));
            }
        });
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editA.getText()+ "");
                int b = Integer.parseInt(editB.getText()+ "");
                int result = a - b;
                txtkq.setText(String.valueOf(result));
            }
        });
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editA.getText()+ "");
                int b = Integer.parseInt(editB.getText()+ "");
                int result = a * b;
                txtkq.setText(String.valueOf(result));
            }
        });
        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editA.getText()+ "");
                int b = Integer.parseInt(editB.getText()+ "");
                int result = a / b;
                txtkq.setText(String.valueOf(result));
            }
        });
        btnUCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editA.getText()+ "");
                int b = Integer.parseInt(editB.getText()+ "");
                while (b != 0) {
                    int temp = b;
                    b = a % b;
                    a = temp;
                }
                txtkq.setText(String.valueOf(a));
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}