package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleLuncher extends AppCompatActivity {

    TextView textBox;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_luncher);

        textBox = findViewById(R.id.textBox);
        toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String text = "";
                if (b){
                    text = "켜졌지롱";
                    textBox.setText("켜졌지롱");
                    textBox.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if(!b){
                    text = "꺼졌지롱";
                    textBox.setText("꺼졌지롱");
                    textBox.setTextColor(Color.parseColor("#000000"));
                }
                Toast toast = Toast.makeText(ToggleLuncher.this, text, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}