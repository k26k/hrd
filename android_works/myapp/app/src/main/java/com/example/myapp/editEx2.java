package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class editEx2 extends AppCompatActivity {

    TextView textOutBox;
    EditText textInputBox;
    Button textBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ex2);

        textOutBox = findViewById(R.id.textOutBox);
        textInputBox = findViewById(R.id.textInputBox);
        textBtn = findViewById(R.id.textBtn);

        textBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "당신은 " + textInputBox.getText().toString() + "입니다.";
                textOutBox.setText( text );
            }
        });

    }
}