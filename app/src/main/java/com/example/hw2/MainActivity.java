package com.example.hw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> students;
    ListView studentSummaryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

//        Intent startIntent = new Intent(getApplicationContext(), StudentSummary.class );
//        startActivity(startIntent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_setting) {
            Intent startIntent = new Intent(getApplicationContext(), AddActivity.class );
            startActivityForResult(startIntent, 1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (1) : {
                if (resultCode == Activity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    Student newStudent = data.getParcelableExtra("newStudent");
                    students.add(newStudent);
                    StudentSummaryListAdapter studentSummaryListAdapter = new StudentSummaryListAdapter(this, students);
                    studentSummaryListView = (ListView)findViewById(R.id.studentSummaryListview);
                    studentSummaryListView.setAdapter(studentSummaryListAdapter);
                }
                break;
            }
    }
    }
}
