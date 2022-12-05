package com.example.myapp;

import android.provider.BaseColumns;

public class SpendContract {
    private SpendContract() {
    }

    public static class SpendEntry implements BaseColumns {
        public static final String TABLE_NAME = "spend";
        public static final String COLUMN_NAME = "spend_name";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME + " TEXT," +
                        COLUMN_AMOUNT + " INTEGER)";
        public static final String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
