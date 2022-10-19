package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.app.databinding.ActivityViewBindingExBinding;

public class ViewBindingEx extends AppCompatActivity {

    ActivityViewBindingExBinding binding;

//    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_binding_ex);
        binding = ActivityViewBindingExBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        checkBox = findViewById(R.id.chkBox);
        
        binding.chkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    compoundButton.setText("더보기 체크");
                    binding.textBox.setMaxLines(1000);
                    Toast toast = Toast.makeText( compoundButton.getContext(), "더보기 체크 됨", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    compoundButton.setText("더보기 안체크");
                    binding.textBox.setMaxLines(3);
                    Toast toast = Toast.makeText(  compoundButton.getContext(), "더보기 체크 안됨", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        binding.imgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText( view.getContext(), "이미지 클릭", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}