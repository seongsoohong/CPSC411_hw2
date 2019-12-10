package com.example.hw2;

import android.provider.BaseColumns;

public class StudentList {


    private StudentList() {}
    public static final class StudentEntry  implements BaseColumns {
        public static final String TABLE_NAME = "studentList";
        public static final String COLUMN_FIRSTNAME = "firstName";
        public static final String COLUMN_LASTNAME = "lastName";
        public static final String COLUMN_CWID = "CWID";
    }
}
