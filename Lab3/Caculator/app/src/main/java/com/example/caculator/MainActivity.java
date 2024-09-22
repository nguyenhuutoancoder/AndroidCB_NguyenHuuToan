package com.example.caculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnXoa,btnXoaAll,btnPhay,btnBang,btnCong,btnTru,btnNhan,btnChia;
    TextView editResult;
    private String number = null;
    double firstnumber = 0, lastNumber = 0;
    boolean operator = false;
    String status = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn0 = this.findViewById(R.id.btn0);
        btn1 = this.findViewById(R.id.btn1);
        btn2 = this.findViewById(R.id.btn2);
        btn3 = this.findViewById(R.id.btn3);
        btn4 = this.findViewById(R.id.btn4);
        btn5 = this.findViewById(R.id.btn5);
        btn6 = this.findViewById(R.id.btn6);
        btn7 = this.findViewById(R.id.btn7);
        btn8 = this.findViewById(R.id.btn8);
        btn9 = this.findViewById(R.id.btn9);


        btnXoa = this.findViewById(R.id.btnXoa);
        btnXoaAll = this.findViewById(R.id.btnXoaAll);
        btnPhay = this.findViewById(R.id.btnPhay);
        btnBang = this.findViewById(R.id.btnBang);

        btnCong = this.findViewById(R.id.btnCong);
        btnTru = this.findViewById(R.id.btnTru);
        btnNhan = this.findViewById(R.id.btnNhan);
        btnChia = this.findViewById(R.id.btnChia);

        editResult = this.findViewById(R.id.txtResult);

        btn0.setOnClickListener(view -> number_click("0"));
        btn1.setOnClickListener(view -> number_click("1"));
        btn2.setOnClickListener(view -> number_click("2"));
        btn3.setOnClickListener(view -> number_click("3"));
        btn4.setOnClickListener(view -> number_click("4"));
        btn5.setOnClickListener(view -> number_click("5"));
        btn6.setOnClickListener(view -> number_click("6"));
        btn7.setOnClickListener(view -> number_click("7"));
        btn8.setOnClickListener(view -> number_click("8"));
        btn9.setOnClickListener(view -> number_click("9"));
        btnPhay.setOnClickListener(view -> number_click("."));

        btnCong.setOnClickListener(view ->{
            if(operator){
                if(status == "tru"){
                    Sub();
                }
                else if(status == "nhan"){
                    Multi();
                }
                else if (status == "chia"){
                    Div();
                }
                else {
                    Add();
                }
            }
            operator = false;
            status = "cong";
            number = null;
                });
        btnTru.setOnClickListener(view ->{
            if(operator){
                if(status == "cong"){
                    Add();
                }
                else if(status == "nhan"){
                    Multi();
                }
                else if (status == "chia"){
                    Div();
                }
                else {
                    Sub();
                }
            }
            operator = false;
            status = "tru";
            number = null;
        });
        btnNhan.setOnClickListener(view ->{
            if(operator){
                if(status == "cong"){
                    Add();
                }
                else if(status == "tru"){
                    Sub();
                }
                else if (status == "chia"){
                    Div();
                }
                else {
                    Multi();
                }
            }
            operator = false;
            status = "nhan";
            number = null;
        });
        btnChia.setOnClickListener(view ->{
            if(operator){
                if(status == "cong"){
                    Add();
                }
                else if(status == "tru"){
                    Sub();
                }
                else if (status == "nhan"){
                    Multi();
                }
                else {
                    Div();
                }
            }
            operator = false;
            status = "chia";
            number = null;
        });
        btnBang.setOnClickListener(view -> {
            if (operator) {  // Kiểm tra nếu phép tính đang chờ thực hiện
                switch (status) {
                    case "cong":
                        Add();
                        break;
                    case "tru":
                        Sub();
                        break;
                    case "nhan":
                        Multi();
                        break;
                    case "chia":
                        Div();
                        break;
                }
                status = null;  // Reset trạng thái sau khi tính xong
                operator = false;  // Đặt lại cờ operator để chuẩn bị cho phép tính tiếp theo
                number = null;  // Reset số sau khi hiển thị kết quả
            }
        });
        btnXoaAll.setOnClickListener(view -> {
            firstnumber = 0;
            lastNumber = 0;
            number = null;
            editResult.setText("0");
        });

        btnXoa.setOnClickListener(view -> {
            if (number != null && number.length() > 0) {
                // Xóa ký tự cuối cùng của chuỗi
                number = number.substring(0, number.length() - 1);

                // Nếu chuỗi rỗng sau khi xóa, hiển thị số 0
                if (number.isEmpty()) {
                    editResult.setText("0");
                } else {
                    editResult.setText(number);
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void number_click(String view ){
         if(number == null){
              number = view;
         }
         else {
             number+= view;
         }
         editResult.setText(number);
         operator = true;
    }
    public void showResult(double result) {
        if (result == (int) result) {
            // Nếu là số nguyên, hiển thị không có phần thập phân
            editResult.setText(String.valueOf((int) result));
        } else {
            // Nếu là số thập phân, hiển thị với phần thập phân
            editResult.setText(String.valueOf(result));
        }
    }
    public void Add() {
        if (number != null) {  // Kiểm tra nếu có số được nhập
            if (firstnumber == 0) {
                firstnumber = Double.parseDouble(editResult.getText().toString());
            } else {
                lastNumber = Double.parseDouble(editResult.getText().toString());
                firstnumber += lastNumber;  // Thực hiện phép cộng
            }
            showResult( firstnumber);
        }
    }

    public void Sub() {
        if (number != null) {  // Kiểm tra nếu có số được nhập
            if (firstnumber == 0) {
                firstnumber = Double.parseDouble(editResult.getText().toString());
            } else {
                lastNumber = Double.parseDouble(editResult.getText().toString());
                firstnumber -= lastNumber;  // Thực hiện phép trừ
            }
            showResult( firstnumber);
        }
    }

    public void Multi() {
        if (number != null) {  // Kiểm tra nếu có số được nhập
            if (firstnumber == 0) {
                firstnumber = Double.parseDouble(editResult.getText().toString());
            } else {
                lastNumber = Double.parseDouble(editResult.getText().toString());
                firstnumber *= lastNumber;  // Thực hiện phép nhân
            }
            showResult( firstnumber);
        }
    }

    public void Div() {
        if (number != null) {  // Kiểm tra nếu có số được nhập
            lastNumber = Double.parseDouble(editResult.getText().toString());
            if (lastNumber != 0) {  // Kiểm tra chia cho 0
                if (firstnumber == 0) {
                    firstnumber = lastNumber;  // Gán giá trị ban đầu nếu là phép tính đầu tiên
                } else {
                    firstnumber /= lastNumber;  // Thực hiện phép chia
                }
                showResult( firstnumber);
            } else {
                editResult.setText("Error");  // Thông báo lỗi nếu chia cho 0
            }
        }
    }

}