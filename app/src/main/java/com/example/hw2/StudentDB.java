package com.example.hw2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class StudentDB extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "studentList";
    public static final String COLUMN_FIRSTNAME = "firstName";
    public static final String COLUMN_LASTNAME = "lastName";
    public static final String COLUMN_CWID = "CWID";
    public static final int DATABASE_VERSION = 1;

    public StudentDB(@Nullable Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_STUDENTLIST_TABLE = "CREATE TABLE " +
                TABLE_NAME + " ( " +

                COLUMN_CWID + " TEXT, " +
                COLUMN_FIRSTNAME + " TEXT, " +
                COLUMN_LASTNAME + " TEXT " +
                ")";
        db.execSQL(SQL_CREATE_STUDENTLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public void addData (String student){
        Log.d("TAG", "addData adding djlf " + COLUMN_CWID + "to CWID");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CWID, "1234");
        cv.put(COLUMN_FIRSTNAME, "dbfirst");
        cv.put(COLUMN_LASTNAME, "dblast");
        Log.d("TAG", "addData adding djlf " + COLUMN_CWID + "to CWID");
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Log.d("TAG", "FUCK");
        } else{
                Log.d("TAG", "YES");
        }


    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME ;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}
