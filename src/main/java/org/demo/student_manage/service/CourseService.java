package org.demo.student_manage.service;

import org.demo.student_manage.domain.Course;
import org.demo.student_manage.domain.Student;
import org.demo.student_manage.dto.request.CourseCreateDto;
import org.demo.student_manage.dto.response.StudentFindDto;
import org.demo.student_manage.repository.CourseRepository;
import org.demo.student_manage.ui.CoursePrinter;

public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentService studentService;
    public CourseService(CourseRepository courseRepository,
                         StudentService studentService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }

    public void saveCourse(CourseCreateDto courseCreateDto){
        StudentFindDto findStudentDto = studentService.findStudentByName(courseCreateDto.getStudentName());
        Student findStudent  = new Student(findStudentDto.getName(),
                findStudentDto.getAge(), findStudentDto.getAddress());

        Course course = new Course(findStudent,
                courseCreateDto.getCourseName(),
                courseCreateDto.getDayOfWeek(),
                courseCreateDto.getFee(),
                courseCreateDto.getCourseTime());

        courseRepository.save(course);
    }
}
