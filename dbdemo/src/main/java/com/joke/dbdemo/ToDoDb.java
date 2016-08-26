package com.joke.dbdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by szlizb on 2016/7/29.
 */

public class ToDoDb extends SQLiteOpenHelper {
    //库名
    private static final String DATABASE_NAME = "todo_db";
    //版本
    private static final int DATABASE_VERSION=1;
    //表明
    private static final String TABLE_NAME = "todo_table";
    //ID
    private static final String FIELE_id = "_id";
    //文件
    private static final String FIELE_TEXT = "todo_text";

    public ToDoDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + FIELE_id
                + " INTEGER primary key autoincrement, " + " " + FIELE_TEXT
                + " text)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //修改
        String sql = "DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    //查询
    public Cursor select() {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        return cursor;
    }

    //插入
    public long insert(String text) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(FIELE_TEXT, text);
        long row = db.insert(TABLE_NAME, null, cv);
        return row;
    }

    //删除
    public void delete(int id) {
        SQLiteDatabase db=this.getWritableDatabase();
        String where = FIELE_id + "=?";
        String[] whereValue = {Integer.toString(id)};
        db.delete(TABLE_NAME, where, whereValue);
    }

    //更新
    public void update(int id, String text) {
        SQLiteDatabase db=this.getWritableDatabase();
        String where = FIELE_id + "=?";
        String[] whereValus = {Integer.toString(id)};
        ContentValues cv = new ContentValues();
        cv.put(FIELE_TEXT, text);
        db.update(TABLE_NAME, cv,where, whereValus);
    }
}
