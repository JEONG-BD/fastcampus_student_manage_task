package org.demo.student_manage.repository;

import org.demo.student_manage.application.course.interfaces.CourseCommandRepository;
import org.demo.student_manage.application.course.interfaces.CourseQueryRepository;
import org.demo.student_manage.domain.Course;
import org.demo.student_manage.domain.DayOfWeek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseJdbcRepository implements CourseQueryRepository {

    private Map<String, Course> courseMap = new HashMap<>();

    public List<Course> findCourseByDay(DayOfWeek dayOfWeek){
        List<Course> courseList = new ArrayList<>();

        for (Course course : courseMap.values()) {
            if ((course.getDayOfWeek() == dayOfWeek) && (course.getStudent().getActivated() == true)) {
                courseList.add(course);
            }
        }
        return courseList;
    }

    public List<Course> findCourseByStudentName(String studentName) {
        List<Course> courseList = new ArrayList<>();
        for (Course course : courseMap.values()) {
            if(course.getStudent().getName().equals(studentName)){
                courseList.add(course);
            }
        }
        return courseList;
    }
}
