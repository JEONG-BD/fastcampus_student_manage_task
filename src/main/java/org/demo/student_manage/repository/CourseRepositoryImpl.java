package org.demo.student_manage.repository;

import org.demo.student_manage.application.course.interfaces.CourseCommandRepository;
import org.demo.student_manage.application.course.interfaces.CourseQueryRepository;
import org.demo.student_manage.domain.Course;
import org.demo.student_manage.domain.DayOfWeek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRepositoryImpl implements CourseCommandRepository{
    private Map<String, Course> courseMap = new HashMap<>();

    public void save(Course course){
        courseMap.put(course.getCourseName(), course);
    }

}
