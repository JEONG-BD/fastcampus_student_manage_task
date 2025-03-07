package org.demo.student_manage.service;

import org.demo.student_manage.domain.Course;
import org.demo.student_manage.domain.DayOfWeek;
import org.demo.student_manage.domain.Student;
import org.demo.student_manage.dto.request.CourseCreateDto;
import org.demo.student_manage.dto.response.StudentFindDto;
import org.demo.student_manage.repository.CourseRepository;
import org.demo.student_manage.ui.CoursePrinter;

import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentService studentService;
    public CourseService(CourseRepository courseRepository,
                         StudentService studentService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }

    public void saveCourse(CourseCreateDto courseCreateDto){
        Student findStudent = studentService.findStudentByName(courseCreateDto.getStudentName());

        Course course = new Course(findStudent,
                courseCreateDto.getCourseName(),
                courseCreateDto.getDayOfWeek(),
                courseCreateDto.getFee(),
                courseCreateDto.getCourseTime());

        courseRepository.save(course);
    }

    public List<Course> find(DayOfWeek dayOfWeek){

        List<Course> courseList = courseRepository.findByDay(dayOfWeek);
        return courseList;
    }
}
