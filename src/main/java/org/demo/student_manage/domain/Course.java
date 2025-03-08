package org.demo.student_manage.domain;

public class Course {

    private Student student;
    private String courseName;
    private DayOfWeek dayOfWeek;
    //private int fee;
    private CourseFee fee;
    private Long courseTime;

    public Course(Student student, String courseName, DayOfWeek dayOfWeek, int fee, Long courseTime) {
        this.student = student;
        this.courseName = courseName;
        this.dayOfWeek = dayOfWeek;
        this.fee = new CourseFee(fee);
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
        return this.fee.getFee();
    }

    public Long getCourseTime() {
        return courseTime;
    }

    public void changeFee(int fee){
        this.fee.changeFee(fee);
    }


    public String getStudentName(){
        return this.student.getName();
    }


    public boolean isSameDay(DayOfWeek dayOfWeek) {
        return this.dayOfWeek.equals(dayOfWeek);
    }

    @Override
    public String toString() {
        return "Course{" +
                "student=" + student +
                ", courseName='" + courseName + '\'' +
                ", dayOfWeek=" + dayOfWeek +
                ", fee=" + fee +
                ", courseTime=" + courseTime +
                '}';
    }
}
