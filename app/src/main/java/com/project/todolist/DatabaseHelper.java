package com.project.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create="CREATE TABLE tasks (sno INTEGER PRIMARY KEY, task TEXT) ";
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = String.valueOf("DROP TABLE 0IF EXISTS ");
        db.execSQL(drop,new String[]{"tasks"});
        onCreate(db);

    }
    public void addTask(Tasks t){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("task",t.getTask());
        long k= db.insert("tasks",null,values);
        Log.d("mytag",Long.toString(k));
        db.close();
    }
//    public void showTask(int sno){
//        SQLiteDatabase db= this.getReadableDatabase();
//        Cursor cursor= db.query("tasks", new String[]{"task"},"sno=?",new String[]{"sno"},null,null,null);
//        if(cursor!=null&& cursor.moveToFirst()){
//            Log.d("mytag",cursor.getString(2));
//        }
//        else {
//            Log.d("mytag","Some error occured");
//        }
//    }
}
