package com.example.users.simpsonsview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.users.simpsonsview.R;

public class SimpsonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpsons);

        getSupportActionBar().hide();
    }
}
