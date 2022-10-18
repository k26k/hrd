package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class VisibleActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgV;
    Button toggleButtonOn;
    Button toggleButtonOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visible);

        imgV = findViewById(R.id.imgV);
        toggleButtonOn = findViewById(R.id.toggleButtonOn);
        toggleButtonOff = findViewById(R.id.toggleButtonOff);

        toggleButtonOn.setOnClickListener( this );
        toggleButtonOff.setOnClickListener( this );
    }

    @Override
    public void onClick(View view) {
        if(view == toggleButtonOn){
            toggleButtonOn.setVisibility(View.GONE);
            toggleButtonOff.setVisibility(View.VISIBLE);
            imgV.setImageResource(R.drawable.cup_2);
        }
        if(view == toggleButtonOff){
            toggleButtonOff.setVisibility(View.GONE);
            toggleButtonOn.setVisibility(View.VISIBLE);
            imgV.setImageResource(R.drawable.cup_1);
        }
    }
}