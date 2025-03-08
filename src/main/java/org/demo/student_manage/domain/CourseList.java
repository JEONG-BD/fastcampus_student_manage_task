package org.demo.student_manage.domain;

import java.util.List;

public class CourseList {
    private final List<Course> courseList;

    public CourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void changeAllCourseFee(int fee){
        for (Course course : courseList) {
            if (course.isSameDay(DayOfWeek.SUNDAY) || course.isSameDay(DayOfWeek.SATURDAY)) {
                course.changeFee((int) (fee * 1.5));
                System.out.println("course.getFee() = " + course.getFee());
            }else {
                course.changeFee(fee);

            }
        }
    }
}
