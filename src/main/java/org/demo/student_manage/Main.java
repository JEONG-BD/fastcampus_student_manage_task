package org.demo.student_manage;

import org.demo.student_manage.application.course.interfaces.CourseQueryRepository;
import org.demo.student_manage.controller.CourseController;
import org.demo.student_manage.controller.StudentController;
import org.demo.student_manage.application.course.interfaces.CourseCommandRepository;
import org.demo.student_manage.repository.CourseJdbcRepository;
import org.demo.student_manage.repository.CourseRepositoryImpl;
import org.demo.student_manage.repository.StudentRepository;
import org.demo.student_manage.application.course.CourseService;
import org.demo.student_manage.application.student.StudentService;
import org.demo.student_manage.ui.CoursePrinter;
import org.demo.student_manage.ui.StudentPrinter;
import org.demo.student_manage.ui.UserInputType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final StudentRepository studentRepository = new StudentRepository();
        final StudentPrinter studentPrinter = new StudentPrinter();
        final StudentService studentService = new StudentService(studentRepository);
        final StudentController studentController = new StudentController(studentService, studentPrinter);
        final CourseCommandRepository courseCommandRepository = new CourseRepositoryImpl();
        final CourseQueryRepository courseQueryRepository = new CourseJdbcRepository();
        final CoursePrinter coursePrinter = new CoursePrinter();
        final CourseService courseService = new CourseService(courseCommandRepository,courseQueryRepository,
                studentService);
        final CourseController courseController = new CourseController(courseService, coursePrinter, studentPrinter);

        Scanner sc = new Scanner(System.in);

        studentPrinter.showMenu();
        UserInputType userInputType = studentController.getUserInput();
        while (userInputType != UserInputType.EXIT) {
            switch (userInputType) {
                case NEW_STUDENT:
                    studentController.saveStudent();
                    break;
                case NEW_COURSE:
                    courseController.saveCourse();
                    break;
                case SHOW_COURSE_DAY_OF_WEEK:
                    courseController.findCourseByDayV2();
                    break;
                case ACTIVATE_STUDENT:
                    studentController.updateActivated();
                    break;
                case DEACTIVATE_STUDENT:
                    studentController.updateDeactivated();
                    break;
                case CHANGE_FEE:
                    courseController.updateFee();
                    break;
                default:
                    studentPrinter.showErrorMessage();
                    break;
            }
            studentPrinter.showMenu();
            userInputType = studentController.getUserInput();
        }
    }
}
