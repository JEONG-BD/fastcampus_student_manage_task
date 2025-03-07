package org.demo.student_manage.repository;

import org.demo.student_manage.domain.Course;

import java.util.HashMap;
import java.util.Map;

public class CourseRepository {
    private Map<String, Course> courseMap = new HashMap<>();

    public void save(Course course){
        courseMap.put(course.getCourseName(), course);
    }
}
