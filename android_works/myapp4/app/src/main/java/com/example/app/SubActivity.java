package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.app.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity {

    ActivitySubBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubBinding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());

        Toast.makeText(this, "sub page", Toast.LENGTH_SHORT).show();

        binding.btnMoveToMain.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
            }
        });

//        binding.btnMoveToMain.setOnClickListener( view ->{
//            this.setContentView(R.layout.activity_main);
//        });
    }
}