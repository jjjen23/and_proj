package com.example.myapp;

import android.provider.BaseColumns;

public class CalContract {
    private CalContract() {
    }
    //일정명과 해당날짜를 저장하는 테이블명과 구조 정의하는 부분

    public static class CalEntry implements BaseColumns {
        //테이블 명, 테이블 컬럼 명 정의
        public static final String TABLE_NAME = "cal";
        public static final String COLUMN_SCHEDULE = "schedule";
        public static final String COLUMN_DATE = "date";
        //테이블 생성
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_SCHEDULE + " TEXT," +
                        COLUMN_DATE + " DATE)";
        //테이블 삭제
        public static final String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
