package com.example.hw2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Student implements Parcelable {
    String firstName;
    String lastName;
    String CWID;
    ArrayList<CourseEnrollment> enrolledCourses;

    public Student(String firstName, String lastName, String CWID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CWID = CWID;
        //this.enrolledCourses = enrolledCourses;

    }


    protected Student(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        CWID = in.readString();
        enrolledCourses = in.readArrayList(CourseEnrollment.class.getClassLoader());
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCWID() {
        return CWID;
    }

    public void setCWID(String CWID) {
        this.CWID = CWID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(CWID);
        dest.writeList(enrolledCourses);
    }
}
