package com.example.hw2;

public class CourseEnrollment {
    String courseID;
    String grade;

    public CourseEnrollment(String courseID, String grade) {
        this.courseID = courseID;
        this.grade = grade;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


}
