package com.example.my_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatebaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    /**
     * *
     * @ context 上下文
     * @ name    数据库名称
     * @ factory 游标工厂
     * @ version 版本号
     * @param context
     */
    public DatebaseHelper(@Nullable Context context) {
        super(context, com.example.my_app.Constants.DATABASE_NAME, null, com.example.my_app.Constants.VERSION_CODE);
    }


    //第一次创建数据库时被调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建时的回调
        Log.d(TAG,"创建数据库...");
        //sql : create table table_name(_id integer,name varchar,age integer,salary integer);
        String sql = "create table "+ com.example.my_app.Constants.TABLE_NAME+"(name varchar,time varchar,t_f boolean)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //升级数据库时的回调

    }
}
