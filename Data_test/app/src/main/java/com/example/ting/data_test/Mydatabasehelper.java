package com.example.ting.data_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Ting on 2016/4/10.
 */
public class Mydatabasehelper extends SQLiteOpenHelper{

    public static final String create = "create table book ("
            +"id integer primary key autoincrement,"
            +"author text, "
            +"price real,"
            +"page integer,"
            +"name text)";
    Context mcontext;
    public Mydatabasehelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create);
        Toast.makeText(mcontext,"the database is ready",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
    }
}
