package com.example.use_permision2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.use_permision2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    ActivityMainBinding binding;

    String[] list = null;
    int checkedIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());
        list = getResources().getStringArray(R.array.dialog_array);

        binding.alertDialog.setOnClickListener( view -> {
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("알림")
                    .setMessage("정말 종료 하시겠습니까?")
                    .setPositiveButton("YES", (dialogInterface, i) -> {
                        finish();
                        Toast.makeText(this, "종료하였습니다.", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("NO", (dialogInterface, i) -> {
                        Toast.makeText(this, "취소하였습니다.", Toast.LENGTH_SHORT).show();
                    })
                    .create();

            alertDialog.show();
        });
        
        binding.listDialog.setOnClickListener( view -> {
            AlertDialog listDialog = new AlertDialog.Builder(this)
                    .setTitle("알림 벨소리")
                    .setSingleChoiceItems(list, 0, this::onClick)
                    .setPositiveButton("YES", this::onClick)
                    .setNegativeButton("NO", this::onClick)
                    .create();

            listDialog.show();
        });

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if(i == -2){
            Toast.makeText(this, "취소하였습니다.", Toast.LENGTH_SHORT).show();
        }else if(i == -1){
            Toast.makeText(this, list[checkedIndex] + "로 설정하였습니다.", Toast.LENGTH_SHORT).show();
        }else{
            checkedIndex = i;
            Toast.makeText(MainActivity.this, list[checkedIndex] + " 선택", Toast.LENGTH_SHORT).show();
        }
    }
}