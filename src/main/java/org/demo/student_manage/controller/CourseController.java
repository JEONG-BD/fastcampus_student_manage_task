package org.demo.student_manage.controller;

import org.demo.student_manage.domain.DayOfWeek;
import org.demo.student_manage.dto.request.CourseCreateDto;
import org.demo.student_manage.service.CourseService;
import org.demo.student_manage.ui.CoursePrinter;
import org.demo.student_manage.ui.StudentPrinter;

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
            coursePrinter.enterCourseName();
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
