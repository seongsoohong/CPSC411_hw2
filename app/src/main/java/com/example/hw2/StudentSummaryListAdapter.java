package com.example.hw2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class StudentSummaryListAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    ArrayList<Student> students;
    String firstName;
    String lastName;

    public StudentSummaryListAdapter(Context c, ArrayList<Student> students) {
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.students = students;


    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.listview_student_summary, null);
        TextView firstNameTextView = (TextView)v.findViewById(R.id.firstNameTextView);
        TextView lastNameTextView = (TextView)v.findViewById(R.id.lastNameTextView);
        String firstName = students.get(position).getFirstName();
        String lastName = students.get(position).getLastName();
       firstNameTextView.setText(firstName);
       lastNameTextView.setText(lastName);

        return v;
    }
}
