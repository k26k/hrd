package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class editEx extends AppCompatActivity {

    ImageView imgV;
    Button toastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ex);

        imgV = findViewById(R.id.imgV);
        toastButton = findViewById(R.id.toastButton);

        imgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(editEx.this, "이미지 클릭!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(editEx.this, "토스트 버튼 클릭!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}