package org.demo.student_manage.application.course;

import org.demo.student_manage.application.course.interfaces.CourseCommandRepository;
import org.demo.student_manage.application.course.interfaces.CourseQueryRepository;
import org.demo.student_manage.domain.Course;
import org.demo.student_manage.domain.CourseList;
import org.demo.student_manage.domain.DayOfWeek;
import org.demo.student_manage.domain.Student;
import org.demo.student_manage.application.course.dto.CourseCreateDto;
import org.demo.student_manage.application.course.dto.CourseFindDto;
import org.demo.student_manage.application.student.StudentService;

import java.util.List;

public class CourseService {

    private final CourseCommandRepository courseCommandRepository;
    private final CourseQueryRepository courseQueryRepository;
    private final StudentService studentService;
    public CourseService(CourseCommandRepository courseCommandRepository,
                         CourseQueryRepository courseQueryRepository,
                         StudentService studentService) {

        this.courseCommandRepository = courseCommandRepository;
        this.courseQueryRepository = courseQueryRepository;
        this.studentService = studentService;
    }

    public void saveCourse(CourseCreateDto courseCreateDto){
        Student findStudent = studentService.findStudentByName(courseCreateDto.getStudentName());

        Course course = new Course(findStudent,
                courseCreateDto.getCourseName(),
                courseCreateDto.getDayOfWeek(),
                courseCreateDto.getFee(),
                courseCreateDto.getCourseTime());

        courseCommandRepository.save(course);
    }

    public List<Course> find(DayOfWeek dayOfWeek){

        List<Course> courseList = courseQueryRepository.findCourseByDay(dayOfWeek);
        return courseList;
    }

    public List<CourseFindDto> findV2(DayOfWeek dayOfWeek){

        List<Course> courseList = courseQueryRepository.findCourseByDay(dayOfWeek);
        return courseList.stream().map(CourseFindDto::new).toList();
    }

    public void updateCourseFee(String studentName, int updateFee) {
        List<Course> courseList = courseQueryRepository.findCourseByStudentName(studentName);
        CourseList courseList1 = new CourseList(courseList);
        courseList1.changeAllCourseFee(updateFee);
    }
}
