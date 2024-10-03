package com.example.mycontacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InsContactActivity extends AppCompatActivity {
    EditText etName, etPhone;
    Button btnSave, btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ins_contact);
        getViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tra ve doi tuong contact can them cho MainActivity
                Intent intentResult = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("contact", getContact());
                intentResult.putExtras(bundle);
                setResult(RESULT_OK, intentResult);
                //dong activity
                finish();
            }
        });
    }
    private void getViews(){
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        btnSave = findViewById(R.id.btnClose);
        btnClose = findViewById(R.id.btnClose);
    }

    private MyContact getContact(){
        return new MyContact(R.drawable.img,etName.getText().toString(),
                etPhone.getText().toString());

    }

}