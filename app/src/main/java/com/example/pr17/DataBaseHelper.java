package com.example.pr17;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_Name = "groups.db";
    static final String TABLE_NAME = "groups";
    static final String COL_ID = "id_group";
    static final String COL_NAME = "group_name";
    static final String COL_COUNT = "group_count";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DB_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ( " + COL_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " TEXT, " +
                COL_COUNT + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addGroups(Group group){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, group.getName());
        cv.put(COL_COUNT, group.getCountStudent());
        db.insert(TABLE_NAME, null, cv);
    }

    public void deleteGroups(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COL_ID + "=" + id.toString(), null);
    }

    public void changeGroups(Group group){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, group.getName());
        cv.put(COL_COUNT, group.getCountStudent());
        db.update(TABLE_NAME, cv, COL_ID + "=" + group.getId(), null);
    }

    public ArrayList<Group> getGroups(){
        ArrayList<Group> groups = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if(result.moveToFirst()){
            while (result.moveToNext()){
                int id = result.getInt(0);
                String name = result.getString(1);
                int count = result.getInt(2);
                Group group = new Group(id, name, count);
                groups.add(group);
            }
        }
        result.close();
        return groups;
    }

}
