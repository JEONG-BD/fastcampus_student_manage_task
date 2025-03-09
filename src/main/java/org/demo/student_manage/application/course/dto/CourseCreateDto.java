package org.demo.student_manage.application.course.dto;

import org.demo.student_manage.domain.DayOfWeek;
import org.demo.student_manage.domain.Student;

public class CourseCreateDto {

    private String studentName;
    private String courseName;
    private DayOfWeek dayOfWeek;

    private int fee;

    private Long courseTime;


    public CourseCreateDto(String studentName, String courseName, DayOfWeek dayOfWeek, int fee, Long courseTime) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.dayOfWeek = dayOfWeek;
        this.fee = fee;
        this.courseTime = courseTime;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Long getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Long courseTime) {
        this.courseTime = courseTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
