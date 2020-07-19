package com.example.recycler_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Display_Image extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__image);
        imageView = findViewById(R.id.display_image);
        imageView.setImageResource(getIntent().getIntExtra("image_id",00));
    }
}
