package org.demo.student_manage.controller;

import org.demo.student_manage.domain.Course;
import org.demo.student_manage.domain.DayOfWeek;
import org.demo.student_manage.dto.request.CourseCreateDto;
import org.demo.student_manage.dto.response.CourseFindDto;
import org.demo.student_manage.service.CourseService;
import org.demo.student_manage.ui.CoursePrinter;
import org.demo.student_manage.ui.StudentPrinter;

import java.util.List;
import java.util.Scanner;

public class CourseController {

    private final Scanner sc = new Scanner(System.in);
    private final CourseService courseService;
    private final CoursePrinter coursePrinter;
    private final StudentPrinter studentPrinter;

    public CourseController(CourseService courseService,
                            CoursePrinter coursePrinter,
                            StudentPrinter studentPrinter) {
        this.courseService = courseService;
        this.coursePrinter = coursePrinter;
        this.studentPrinter = studentPrinter;
    }

    public void saveCourse(){
        String studentName = inputStudentName();
        String courseName = inputCourseName();
        int fee = inputCourseFee();
        DayOfWeek dayOfWeek = inputCourseDay();
        long courseTime = inputCourseTime();
        CourseCreateDto courseCreateDto = new CourseCreateDto(
                studentName,
                courseName,
                dayOfWeek,
                fee,
                courseTime);
        courseService.saveCourse(courseCreateDto);
    }


    public void updateFee() {
        String studentName = inputStudentName();
        int updateFee = inputCourseFee();
        courseService.updateCourseFee(studentName, updateFee);
        coursePrinter.showUpdateFeeMessage();
    }


    public void findCourseByDay() {
        DayOfWeek dayOfWeek = inputCourseDay();
        List<Course> coursesList = courseService.find(dayOfWeek);
        for (Course course : coursesList) {
            System.out.println(course);
        }
    }

    public void findCourseByDayV2() {
        DayOfWeek dayOfWeek = inputCourseDay();
        List<CourseFindDto> coursesList = courseService.findV2(dayOfWeek);
        coursePrinter.showCourseInfomation(coursesList);
    }

    public String inputCourseName(){
        coursePrinter.enterCourseName();
        return sc.nextLine();
    }

    public DayOfWeek inputCourseDay(){
        while(true){
            coursePrinter.enterCourseDay();
            try {
                return DayOfWeek.valueOf(sc.nextLine().toUpperCase());
            } catch (IllegalArgumentException ex){
                coursePrinter.showInvalidAgeMessage();
            }
        }
    }

    public int inputCourseFee(){
        while(true){
            coursePrinter.enterCourseFee();
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex){
            coursePrinter.showInvalidAgeMessage();
            }
        }
    }

    public long inputCourseTime(){
        while(true){
            coursePrinter.enterCourseTime();
            try {
                return Long.parseLong(sc.nextLine());
            } catch (NumberFormatException ex){
                coursePrinter.showInvalidAgeMessage();
            }
        }
    }

    public String inputStudentName(){
        studentPrinter.enterStudentName();
        return sc.nextLine();
    }


}
