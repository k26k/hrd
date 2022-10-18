package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ListView listBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listBox = findViewById(R.id.listBox);

        List<String> textList = new ArrayList<>();

        // ListView와 List를 연결할 어뎁터 필요
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, textList);

        listBox.setAdapter(adapter);

        for (int i=1; i<=30; i++){
            textList.add(i+"번 요소");
        }

        adapter.notifyDataSetChanged();
    }
}