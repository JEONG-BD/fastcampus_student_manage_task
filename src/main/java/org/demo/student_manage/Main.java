package org.demo.student_manage;

import org.demo.student_manage.controller.CourseController;
import org.demo.student_manage.controller.StudentController;
import org.demo.student_manage.repository.CourseRepository;
import org.demo.student_manage.repository.StudentRepository;
import org.demo.student_manage.service.CourseService;
import org.demo.student_manage.service.StudentService;
import org.demo.student_manage.ui.CoursePrinter;
import org.demo.student_manage.ui.StudentPrinter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    /*
    * 1. 학생 추가
    * 2. 수업 등록
    * 3. 요일별 수업 조회
    * 4. 학생 활성화
    * 5. 학생 비활성화
    * 6. 수강료 변경
    * 0. 종료
    * */

        final StudentRepository studentRepository = new StudentRepository();
        final StudentPrinter studentPrinter = new StudentPrinter();
        final StudentService studentService = new StudentService(studentRepository);
        final StudentController studentController = new StudentController(studentService, studentPrinter);
        final CourseRepository courseRepository = new CourseRepository();
        final CoursePrinter coursePrinter = new CoursePrinter();
        final CourseService courseService = new CourseService(courseRepository,
                studentService);
        final CourseController courseController = new CourseController(courseService, coursePrinter, studentPrinter);

        Scanner sc = new Scanner(System.in);
        System.out.println("1. 학생 추가");
        System.out.println("2. 수업 등록");
        System.out.println("3. 요일별 수업 조회");
        System.out.println("4. 학생 활성화");
        System.out.println("5. 학생 비활성화");
        System.out.println("6. 수강료 변경");
        System.out.println("0. 종료");

        while (true){
            int menuNum = sc.nextInt();
            System.out.println("menuNum = " + menuNum);

            switch (menuNum){
                case 1:
                    System.out.println("학생 추가");
                    studentController.saveStudent();
                    break;
                case 2:
                    System.out.println("수업 등록");
                    courseController.saveCourse();
                    break;
                case 0:
                    System.out.println("종료");
                    break;
            }
        }

    }
}
