package com.example.precofipeapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.precofipeapp.database.model.UsuarioModel;

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "precofipe.db";
    private static final int DATABASE_VERSION = 1;

    public DBOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UsuarioModel.DROP_TABLE);
        db.execSQL(UsuarioModel.CREATE_TABLE);
    }
}
