package com.example.my_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/*
这个类用于操作数据库的增删改查
 */
public class Dao {

    private static final String TAG = "Dao";
    private final DatebaseHelper mHelper;

    public Dao(Context context){

        //创建数据库
        mHelper = new DatebaseHelper(context);
    }

    public  void insert(Line line){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        String sql = "insert into "+Constants.TABLE_NAME+"(name,time,t_f) values(?,?,?)";
        db.execSQL(sql,new Object[]{line.getNum(),line.getTime(),line.isT_f()});
        db.close();
    }

    public  int delete(String name){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        //String sql = "delete from "+Constants.TABLE_NAME+" where name:"+name;
        //db.execSQL(sql);
        //db.close();
        int d=db.delete(Constants.TABLE_NAME,"name = ?",new String[]{name});
        return d;
    }

    public  int updatet(String name){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("t_f", true);
        int d=db.update(Constants.TABLE_NAME,values,"name = ?",new String[]{name});
        return d;
    }

    public  int updatef(String name){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("t_f", false);
        int d=db.update(Constants.TABLE_NAME,values,"name = ?",new String[]{name});
        return d;
    }

    public List<Line> query(){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        String sql = "select *from "+Constants.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql,null);
        List<Line> q= new ArrayList<>();

        while(cursor.moveToNext()){
            int index1 = cursor.getColumnIndex("name");
            String name = cursor.getString(index1);
            int index2 = cursor.getColumnIndex("time");
            String time = cursor.getString(index2);
            int index3 = cursor.getColumnIndex("t_f");
            Boolean t_f = cursor.getInt(index3)>0;
            Line line = new Line(name,time,t_f);
            q.add(line);
        }
        cursor.close();
        db.close();
        return q;
    }
}
