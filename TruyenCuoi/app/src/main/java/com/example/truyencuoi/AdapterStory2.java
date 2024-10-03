package com.example.truyencuoi;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterStory2 extends ArrayAdapter<MyStoriesDetail> {
    Context context;
    int idlayout;
    ArrayList<MyStoriesDetail> storiesDetail;
    public AdapterStory2(@NonNull Context context, int resource, ArrayList<MyStoriesDetail> mylist) {
        super(context, resource, mylist);
        this.context = context;
        this.idlayout = resource;
        this.storiesDetail = mylist;
    }

    @Nullable
    @Override
    public MyStoriesDetail getItem(int position) {
        return storiesDetail.get(position);
    }

    @Override
    public int getCount() {
        return storiesDetail.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View currentView = convertView;
       if(currentView == null){
           currentView = LayoutInflater.from(context).inflate(idlayout, parent, false);
       }
       MyStoriesDetail storiesDetail = getItem(position);
        ImageView imgdetail = currentView.findViewById(R.id.imgFun);
        TextView tvdetail = currentView.findViewById(R.id.tvdetail);

        tvdetail.setText(storiesDetail.getNamedetail());
        assert storiesDetail!=null;
        imgdetail.setImageResource(storiesDetail.getImageId());
        return currentView;
    }
}
