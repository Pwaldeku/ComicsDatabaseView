package com.example.users.simpsonsview.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.users.simpsonsview.R;

public class SimpsonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpsons);

        getSupportActionBar().hide();

        String character = getIntent().getExtras().getString("simpson_character");
        String quote = getIntent().getExtras().getString("simpson_quote");
        String image_url = getIntent().getExtras().getString("simpson_img");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        collapsingToolbarLayout.setTitleEnabled(true);


        //TextView tv_character = findViewById(R.id.as_simpson_character);
        TextView tv_quote = findViewById(R.id.as_simpson_quote);
        ImageView img = findViewById(R.id.as_thumbnail);

        //tv_character.setText(character);
        tv_quote.setText(quote);

        collapsingToolbarLayout.setTitle(character);

        RequestOptions requestOptions= new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        Glide.with(this).load(image_url).apply(requestOptions).into(img);


    }
}
