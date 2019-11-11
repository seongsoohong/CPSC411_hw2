package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class StudentSummary extends AppCompatActivity {
    ArrayList<Student> students;
    ListView studentSummaryListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        students = new ArrayList<>();

       students.add(new Student("Seong", "Hong", "0000"));
        students.add(new Student("Bob", "Lim", "1111"));
        students.add(new Student("Seong", "Hong", "0000"));
        students.add(new Student("Bob", "Lim", "1111"));
        students.add(new Student("Seong", "Hong", "0000"));
        students.add(new Student("Bob", "Lim", "1111"));
//
//        ListAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
//        ListView myView = (ListView)findViewById(R.id.studentSummaryListview);
//        myView.setAdapter(myAdapter);
        StudentSummaryListAdapter studentSummaryListAdapter = new StudentSummaryListAdapter(this, students);
        studentSummaryListView = (ListView)findViewById(R.id.studentSummaryListview);
        studentSummaryListView.setAdapter(studentSummaryListAdapter);



    }
}
