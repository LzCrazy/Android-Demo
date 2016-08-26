package com.joke.sqlitdemo.serviver;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by szlizb on 2016/7/21.
 */


public class DBContext {
    private DBHelper dbHelper;
    public DBContext(Context context){
        dbHelper=new DBHelper(context,"note.db",null,1);
    }
    //向表中插入数据
    public void insert(ContentValues values){
        //1,获取SQlite数据库
        SQLiteDatabase sdb=dbHelper.getWritableDatabase();
        //2.执行插入操作
        sdb.insert("note",null,values);
        //3.关闭资源
        sdb.close();
    }


    public Cursor rawQuery(){
     SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="select _id,content,noteDate from note";
        return sdb.rawQuery(sql,null);
    }
    public Cursor rawFilterQuery(String queryText){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="select _id,content,noteDate from note where content like ?";
        return sdb.rawQuery(sql,new String[]{"%"+queryText+"%"});
    }
    public void delete(int id){
        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        sqLiteDatabase.delete("note", "_id=?", new String[]{String.valueOf(id)});
        Log.i("tag", "delete ok");
        sqLiteDatabase.close();
    }

    class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql="create table note(" +
                    "_id integer primary key autoincrement," +
                    "content varchar(200) not null," +
                    "noteDate datetime not null)";
            db.execSQL(sql);
            Log.i("TAG","table create ok");
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}


