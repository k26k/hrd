package com.example.app_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.app_intent.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity {

    ActivitySubBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubBinding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");

        binding.textName.setText(name);

    }
}