package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgV;
    Button showBtn;
    Button hideBtn;
    Button changeBtn;
    boolean redCup = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgV = findViewById(R.id.imgV);
        showBtn = findViewById(R.id.showBtn);
        hideBtn = findViewById(R.id.hideBtn);
        changeBtn = findViewById(R.id.changeBtn);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgV.setVisibility(View.VISIBLE);
            }
        });

        hideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgV.setVisibility(View.INVISIBLE);
            }
        });

        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(redCup){
                    redCup = false;
                    imgV.setImageResource(R.drawable.cup_2);
                }else{
                    redCup = true;
                    imgV.setImageResource(R.drawable.cup_1);
                }
            }
        });
    }
}