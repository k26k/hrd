package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.app.databinding.ActivityMainBinding;
import com.example.app.databinding.ActivitySubBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnMoveToSub.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_sub);
            }
        });

    }
}