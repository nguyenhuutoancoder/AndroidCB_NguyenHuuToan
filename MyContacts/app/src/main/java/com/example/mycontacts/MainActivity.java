package com.example.mycontacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    ArrayList<MyContact> listContacts = new ArrayList<>();
    ContactAdapter contactAdapter;
    FloatingActionButton btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initData();
        lvContact = findViewById(R.id.lvContacts);
        //khoi tao contactAdapter
        contactAdapter = new ContactAdapter(MainActivity.this, R.layout.layout_item_contact, listContacts);
        lvContact.setAdapter(contactAdapter);
        //xu ly su kien cho nut floating button
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //goi InsContactActivity de them moi contact
                Intent intentIns = new Intent(MainActivity.this, InsContactActivity.class);
                insertContactResult.launch(intentIns);
            }
        });
    }
    ActivityResultLauncher<Intent> insertContactResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            //xu ly ket qua tra ve o day
            if(o.getResultCode()==RESULT_OK){
                Intent intent = o.getData();
                MyContact contact = (MyContact) intent.getExtras().getSerializable("contact");
                //add vao listcontact
                listContacts.add(contact);
                //refresh adapter
                contactAdapter.notifyDataSetChanged();
            }
        }
    });
    private void initData(){
        listContacts.add(new MyContact(R.drawable.img, "Mai", "0385436754"));
        listContacts.add(new MyContact(R.drawable.img, "Hoang", "0912060716"));
        listContacts.add(new MyContact(R.drawable.img, "Trinh", "0329678321"));
        listContacts.add(new MyContact(R.drawable.img, "Trong", "0999654390"));
        listContacts.add(new MyContact(R.drawable.img, "Hoa", "0874553277"));
    }

}