package com.example.app_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.app_intent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnWriteName.setOnClickListener( view -> {
            String name = binding.textName.getText().toString();

            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);

        });
    }
}