package com.example.myapp;

import android.provider.BaseColumns;

public class PeopleContract {
    private PeopleContract() {
    }

    public static class PeopleEntry implements BaseColumns {
        public static final String TABLE_NAME = "people";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_TEL = "tel";
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME + " TEXT," +
                        COLUMN_TEL + " TEXT)";
        public static final String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
