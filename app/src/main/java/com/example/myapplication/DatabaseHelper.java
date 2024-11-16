package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "users.db";

    public static final String TABLE_USERS = "users";
    public static final String COL_ID = "id"; // Thêm cột ID
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";
    public static final String COL_TYPE = "type"; // Thêm cột type
    public static final String COL_DISPLAY_NAME = "name";
    // Tên hiển thị
    private static final String TABLE_TASKS = "tasks";
    private static final String COL_TASK_ID = "taskID";
    private static final String COL_USER_ID = "userID";
    private static final String COL_TITLE = "title";
    private static final String COL_DESCRIPTION = "description";
    private static final String COL_LABEL = "label";
    private static final String COL_START_TIME = "startTime";
    private static final String COL_END_TIME = "endTime";
    private static final String COL_IS_RECURRING = "isRecurring";
    private static final String COL_RECURRENCE_INTERVAL = "recurrenceInterval";
    private static final String COL_STATUS = "status";

    private static final String TABLE_EVENTS = "events";
    private static final String COL_EVENT_ID = "eventID";
    private static final String COL_EVENT_TITLE = "eventTitle";
    private static final String COL_EVENT_DESCRIPTION = "eventDescription";
    private static final String COL_EVENT_LABEL = "eventLabel";
    private static final String COL_EVENT_START_TIME = "eventStartTime";
    private static final String COL_EVENT_REMINDER_TIME = "eventReminderTime";

    private static final String TABLE_NOTES = "notes";
    private static final String COL_NOTE_ID = "noteID";
    private static final String COL_NOTE_TITLE = "noteTitle";
    private static final String COL_NOTE_CONTENT = "noteContent";
    private static final String COL_NOTE_LABEL = "noteLabel";
    private static final String COL_NOTE_CREATED_TIME = "noteCreatedTime";
    private static final String COL_NOTE_EDITED_TIME = "noteEditedTime";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng người dùng với cột username là UNIQUE
        db.execSQL("CREATE TABLE " + TABLE_USERS + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_DISPLAY_NAME + " TEXT, " +
                COL_USERNAME + " TEXT UNIQUE, " + // Đảm bảo username là duy nhất
                COL_PASSWORD + " TEXT, " +
                COL_TYPE + " TEXT)");

        String CREATE_TASK_TABLE = "CREATE TABLE " + TABLE_TASKS + " (" +
                COL_TASK_ID + " INTEGER PRIMARY KEY, " +
                COL_USER_ID + " INTEGER, " +
                COL_TITLE + " TEXT, " +
                COL_DESCRIPTION + " TEXT, " +
                COL_LABEL + " TEXT, " +
                COL_START_TIME + " INTEGER, " +
                COL_END_TIME + " INTEGER, " +
                COL_IS_RECURRING + " INTEGER, " +
                COL_RECURRENCE_INTERVAL + " TEXT, " +
                COL_STATUS + " TEXT);";

        String CREATE_EVENT_TABLE = "CREATE TABLE " + TABLE_EVENTS + " (" +
                COL_EVENT_ID + " INTEGER PRIMARY KEY, " +
                COL_ID + " INTEGER, " +
                COL_EVENT_TITLE + " TEXT, " +
                COL_EVENT_DESCRIPTION + " TEXT, " +
                COL_EVENT_LABEL + " TEXT, " +
                COL_EVENT_START_TIME + " INTEGER, " +
                COL_EVENT_REMINDER_TIME + " INTEGER);";

        String CREATE_NOTE_TABLE = "CREATE TABLE " + TABLE_NOTES + " (" +
                COL_NOTE_ID + " INTEGER PRIMARY KEY, " +
                COL_ID + " INTEGER, " +
                COL_NOTE_TITLE + " TEXT, " +
                COL_NOTE_CONTENT + " TEXT, " +
                COL_NOTE_LABEL + " TEXT, " +
                COL_NOTE_CREATED_TIME + " INTEGER, " +
                COL_NOTE_EDITED_TIME + " INTEGER);";

        db.execSQL(CREATE_TASK_TABLE);
        db.execSQL(CREATE_EVENT_TABLE);
        db.execSQL(CREATE_NOTE_TABLE);
        // Thêm người dùng mặc định admin
        db.execSQL("INSERT INTO " + TABLE_USERS + " (" + COL_DISPLAY_NAME + ", " + COL_USERNAME + ", " + COL_PASSWORD + ", " + COL_TYPE + ") VALUES (?, ?, ?, ?)",
                new Object[]{"admin", "admin", "123456", "admin"});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(db);
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, null, COL_USERNAME + "=? AND " + COL_PASSWORD + "=?",
                new String[]{username, password}, null, null, null);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }
}