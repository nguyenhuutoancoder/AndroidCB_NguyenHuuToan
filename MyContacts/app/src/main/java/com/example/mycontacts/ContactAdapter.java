package com.example.mycontacts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<MyContact> {
    Context context;
    int layout;
    ArrayList<MyContact> myListContacts;
    public ContactAdapter(@NonNull Context context, int resource, ArrayList<MyContact> lsContacts) {
        super(context, resource, lsContacts);
        this.context = context;
        this.layout = resource;
        this.myListContacts = lsContacts;
    }
    //Viet lai cac phuong thuc cua arrayadapter: getView, getItem ...

    @Nullable
    @Override
    public MyContact getItem(int position) {
        return myListContacts.get(position);
    }

    @Override
    public int getCount() {
        return myListContacts.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView = convertView;
        if(currentView == null){
            //load layout item len de hien thi du lieu
            currentView = LayoutInflater.from(context).inflate(layout,parent,false);
        }
        //lay ra doi tuong mycontact tai vi tri position
        MyContact contact = getItem(position);
        ImageView imgContact = currentView.findViewById(R.id.imgContact);
        TextView tvName = currentView.findViewById(R.id.tvName);
        TextView tvPhone = currentView.findViewById(R.id.tvPhone);
        ImageButton btnCall = currentView.findViewById(R.id.btnCall);
        ImageButton btnSendSms = currentView.findViewById(R.id.btnSendSMS);
        //data bind
        tvName.setText(contact.getName());
        tvPhone.setText(contact.getPhone());
        //xu ly su kien cho cac button: btnCall, btnSendSms,...
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL);
                intentCall.setData(Uri.parse("tel: "+contact.getPhone()));
                context.startActivity(intentCall);
            }
        });

        btnSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Uri smsUri = Uri.parse("smsto: "+ contact.getPhone());
                Intent intentSms = new Intent(Intent.ACTION_SENDTO,smsUri);
                intentSms.putExtra("sms_body", "input sms message");
                context.startActivity(intentSms);
            }
        });
        //data bind imageview
       assert contact!= null;
        imgContact.setImageResource(contact.getImageId());
        return currentView;
    }
}
