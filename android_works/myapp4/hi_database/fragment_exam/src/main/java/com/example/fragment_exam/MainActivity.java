package com.example.fragment_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        //버튼 이벤트
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                //fragment1 객체 생성
                Fragment1 fragment1 = new Fragment1();
                //fragment1, 2, 3, 4로 각각 변경
                transaction.replace(R.id.frame, fragment1);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                //fragment1 객체 생성
                Fragment2 fragment2 = new Fragment2();
                //fragment1, 2, 3, 4로 각각 변경
                transaction.replace(R.id.frame, fragment2);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                //fragment1 객체 생성
                Fragment3 fragment3 = new Fragment3();
                //fragment1, 2, 3, 4로 각각 변경
                transaction.replace(R.id.frame, fragment3);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                //fragment1 객체 생성
                Fragment4 fragment4 = new Fragment4();
                //fragment1, 2, 3, 4로 각각 변경
                transaction.replace(R.id.frame, fragment4);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}