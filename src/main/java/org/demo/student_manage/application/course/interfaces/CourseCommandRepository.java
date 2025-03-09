package org.demo.student_manage.application.course.interfaces;

import org.demo.student_manage.domain.Course;
import org.demo.student_manage.domain.DayOfWeek;

import java.util.List;

public interface CourseCommandRepository {
    public void save(Course course);

}
