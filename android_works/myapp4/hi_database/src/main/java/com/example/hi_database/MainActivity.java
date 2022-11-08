package com.example.hi_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.hi_database.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addBtn.setOnClickListener( view -> {

            String title = binding.addTitle.getText().toString();
            String content = binding.addContent.getText().toString();

            DbHelper helper = new DbHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            db.execSQL("INSERT INTO tb_memo(title, content) VALUES(?,?)", new String[]{title, content});
            db.close();

            Intent intent = new Intent(MainActivity.this, ReadActivity.class);
            this.startActivity(intent);
        });

        binding.cleanBtn.setOnClickListener(view -> {
            DbHelper helper = new DbHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            db.execSQL("DELETE FROM tb_memo");
            db.close();
        });

    }
}