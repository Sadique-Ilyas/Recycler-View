package com.example.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.icu.util.ICUUncheckedIOException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>
{
    private int []image;
    private Context context;
    public RecyclerAdapter(int []image, Context context)
    {
        this.image=image;
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view, context, image);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        int image_id = image[position];
        holder.Album.setImageResource(image_id);
        holder.Album_title.setText("Image: "+(position+1));
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView Album;
        TextView Album_title;
        Context context;
        int image[];
        public MyViewHolder(@NonNull View itemView, Context context, int image[]) {
            super(itemView);
            Album = itemView.findViewById(R.id.album);
            Album_title = itemView.findViewById(R.id.album_title);
            this.context = context;
            this.image = image;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context,Display_Image.class);
            intent.putExtra("image_id",image[getAdapterPosition()]);
            context.startActivity(intent);
        }
    }
}
