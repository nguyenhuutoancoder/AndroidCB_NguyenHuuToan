package com.example.truyencuoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterStory extends RecyclerView.Adapter<AdapterStory.MyViewHolder> {
   List<MyStories> lsStories;
    private OnItemClickListener listener;
    // Interface để xử lý sự kiện click
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Phương thức để set listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public AdapterStory(List<MyStories> lsStories) {
        this.lsStories = lsStories;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent,
                false);
        return new MyViewHolder(view, listener);
    }

    @Override
    public int getItemCount() {
        return lsStories.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    MyStories story = lsStories.get(position);
    holder.imgStory.setImageResource(story.getImageId());
    holder.tvName.setText(story.getName());
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
       private ImageView imgStory;
       private TextView tvName;
        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imgStory = itemView.findViewById(R.id.imgTruyenCuoi);
            tvName = itemView.findViewById(R.id.tvName);
            // Gán sự kiện click cho itemView
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
