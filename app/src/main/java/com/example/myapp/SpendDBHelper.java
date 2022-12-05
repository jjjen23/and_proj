package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class SpendDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "database";
    public static final int DATABASE_VERSION = 1;

    public SpendDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SpendContract.SpendEntry.SQL_CREATE_TABLE); // 테이블 생성
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // 단순히 데이터를 삭제하고 다시 시작하는 정책이 적용될 경우
        sqLiteDatabase.execSQL(SpendContract.SpendEntry.SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }

    void insertRecord(String spend_name, int amount) {
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(SpendContract.SpendEntry.COLUMN_NAME, spend_name);
        values.put(SpendContract.SpendEntry.COLUMN_AMOUNT, amount);

        db.insert(SpendContract.SpendEntry.TABLE_NAME, null, values);
    }

    // 조회 방식(정렬 순서)는 상황에 맞추어 변경할 것
    public Cursor readRecordOrderByAge() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                BaseColumns._ID,
                SpendContract.SpendEntry.COLUMN_NAME,
                SpendContract.SpendEntry.COLUMN_AMOUNT
        };

        String sortOrder = SpendContract.SpendEntry.COLUMN_AMOUNT + " DESC";

        Cursor cursor = db.query(
                SpendContract.SpendEntry.TABLE_NAME,   // The table to query
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