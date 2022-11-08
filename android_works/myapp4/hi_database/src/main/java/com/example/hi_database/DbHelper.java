package com.example.hi_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;

    public DbHelper(@Nullable Context context) {
        super(context, "memodb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String memoSQL = "CREATE TABLE tb_memo(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title, " +
                "content)";
        db.execSQL(memoSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == DATABASE_VERSION){
            db.execSQL("DROP TABLE tb_memo");
            this.onCreate(db);
        }
    }
}
