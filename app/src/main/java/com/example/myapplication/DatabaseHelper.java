package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME = "users";
    public static final String COL_ID = "id"; // Thêm cột ID
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";
    public static final String COL_TYPE = "type"; // Thêm cột type
    public static final String COL_DISPLAY_NAME = "name"; // Tên hiển thị

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng người dùng với cột username là UNIQUE
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_DISPLAY_NAME + " TEXT, " +
                COL_USERNAME + " TEXT UNIQUE, " + // Đảm bảo username là duy nhất
                COL_PASSWORD + " TEXT, " +
                COL_TYPE + " TEXT)");

        // Thêm người dùng mặc định admin
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_DISPLAY_NAME + ", " + COL_USERNAME + ", " + COL_PASSWORD + ", " + COL_TYPE + ") VALUES (?, ?, ?, ?)",
                new Object[]{"admin", "admin", "123456", "admin"});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COL_USERNAME + "=? AND " + COL_PASSWORD + "=?",
                new String[]{username, password}, null, null, null);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }
}