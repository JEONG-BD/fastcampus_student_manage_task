package org.demo.student_manage.domain;

public class Course {

    private Student student;
    private String courseName;
    private DayOfWeek dayOfWeek;
    private int fee;
    private Long courseTime;

    public Course(Student student, String courseName, DayOfWeek dayOfWeek, int fee, Long courseTime) {
        this.student = student;
        this.courseName = courseName;
        this.dayOfWeek = dayOfWeek;
        this.fee = fee;
        this.courseTime = courseTime;
    }

    public Student getStudent() {
        return student;
    }

    public String getCourseName() {
        return courseName;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public int getFee() {
        return fee;
    }

    public Long getCourseTime() {
        return courseTime;
    }
}
