package com.example.precofipeapp.database.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.precofipeapp.database.DBOpenHelper;

public class AbstractDAO {

    protected DBOpenHelper db_helper;
    protected SQLiteDatabase db;

    public final void Open(){
        db = db_helper.getWritableDatabase();
    }

    public final void Close() {
        db_helper.close();
    }
}
