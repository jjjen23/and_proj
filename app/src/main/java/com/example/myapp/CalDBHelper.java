package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class CalDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "database";
    public static final int DATABASE_VERSION = 1;

    public CalDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CalContract.CalEntry.SQL_CREATE_TABLE); // 테이블 생성
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // 단순히 데이터를 삭제하고 다시 시작하는 정책이 적용될 경우
        sqLiteDatabase.execSQL(CalContract.CalEntry.SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }

    //date int 맞나..? --> 질문
    //입력된 값을 함수 인자로 전달하면 해당 데이터베이스 테이블에 저장하는 함수.
    void insertRecord(String schedule, int date) {
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(CalContract.CalEntry.COLUMN_SCHEDULE, schedule);
        values.put(CalContract.CalEntry.COLUMN_DATE, date);

        db.insert(CalContract.CalEntry.TABLE_NAME, null, values);
    }

    // 조회 방식(정렬 순서)는 상황에 맞추어 변경할 것
    public Cursor readRecordOrderByAge() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                BaseColumns._ID,
                CalContract.CalEntry.COLUMN_SCHEDULE,
                CalContract.CalEntry.COLUMN_DATE
        };

        String sortOrder = CalContract.CalEntry.COLUMN_DATE + " DESC";

        Cursor cursor = db.query(
                CalContract.CalEntry.TABLE_NAME,   // The table to query
                projection,   // The array of columns to return (pass null to get all)
                null,   // where 문에 필요한 column
                null,   // where 문에 필요한 value
                null,   // group by를 적용할 column
                null,   // having 절
                sortOrder   // 정렬 방식
        );

        return cursor;
    }
}