package com.example.bai2;

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

public class tinhtong extends AppCompatActivity {
    Button btnTinhtong, btnTrove, btnThoat;
     TextView edtResult;
     EditText edtA, edtB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tinhtong);
        initControl();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void initControl(){
        btnTinhtong = findViewById(R.id.btnTong);
        btnTrove = findViewById(R.id.btnReturn);
        btnThoat = findViewById(R.id.btnExit);
        edtResult = findViewById(R.id.txtResult);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);

        btnTinhtong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int A = Integer.parseInt(edtA.getText().toString());
               int B = Integer.parseInt(edtB.getText().toString());
               int result = A + B;
               edtResult.setText("Kết quả: " + result);
            }
        });
        btnTrove.setOnClickListener(new View.OnClickListener() {
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