package org.demo.student_manage.repository;

import org.demo.student_manage.domain.Course;
import org.demo.student_manage.domain.DayOfWeek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRepository {
    private Map<String, Course> courseMap = new HashMap<>();

    public void save(Course course){
        courseMap.put(course.getCourseName(), course);
    }
    
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
