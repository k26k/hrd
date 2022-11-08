package com.example.hi_database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.hi_database.databinding.ActivityReadBinding;

public class ReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityReadBinding binding = ActivityReadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DbHelper helper = new DbHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT title, content FROM tb_memo ORDER BY id DESC LIMIT 1", null);
        while (cursor.moveToNext()) {
            //cursor.moveToNext();
            binding.readTitle.setText(cursor.getString(0));
            binding.readContent.setText(cursor.getString(1));
        }
        db.close();
    }
}