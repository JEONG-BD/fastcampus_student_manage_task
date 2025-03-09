package org.demo.student_manage.application.course.dto;

import org.demo.student_manage.domain.Course;
import org.demo.student_manage.domain.DayOfWeek;

public class CourseFindDto {
    private final String courseName;
    private final int fee;
    private final DayOfWeek dayOfWeek;
    private final String studentName;
    private final Long courseTime;

    public CourseFindDto(String courseName, int fee, String dayOfWeek, String studentName, Long courseTime) {
        this.courseName = courseName;
        this.fee = fee;
        this.dayOfWeek = DayOfWeek.valueOf(dayOfWeek);
        this.studentName = studentName;
        this.courseTime = courseTime;
    }

    public CourseFindDto(Course course) {
        this.courseName = course.getCourseName();
        this.fee = course.getFee();
        this.dayOfWeek = course.getDayOfWeek();
        this.studentName = course.getStudentName();
        this.courseTime = course.getCourseTime();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getFee() {
        return fee;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public String getStudentName() {
        return studentName;
    }

    public Long getCourseTime() {
        return courseTime;
    }
}
