package org.demo.student_manage.controller;

import org.demo.student_manage.domain.Student;
import org.demo.student_manage.dto.request.StudentCreateDto;
import org.demo.student_manage.dto.response.StudentFindDto;
import org.demo.student_manage.service.StudentService;
import org.demo.student_manage.ui.StudentPrinter;

import java.util.Scanner;

public class StudentController {

    private final Scanner sc = new Scanner(System.in);
    private final StudentService studentService;
    private final StudentPrinter studentPrinter;

    public StudentController(StudentService studentService, StudentPrinter studentPrinter) {
        this.studentService = studentService;
        this.studentPrinter = studentPrinter;
    }

    public void saveStudent(){
        String name = inputStudentName();
        int age = inputStudentAge();
        String address = inputStudentAddress();
        StudentCreateDto studentCreateDto = new StudentCreateDto(name, age, address);
        studentService.saveStudent(studentCreateDto);
    }

    public void findStudent(){
        String name = inputStudentName();
        Student findStudent = studentService.findStudentByName(name);
        System.out.println(findStudent);
    }

    public void updateActivated() {
        String name = inputStudentName();
        studentService.updateActivate(name);
        studentPrinter.showUpdateActivated();
    }

    public void updateDeactivated() {
        String name = inputStudentName();
        studentService.updateDeactivate(name);
        studentPrinter.showUpdateDeActivated();
    }

    public String inputStudentName(){
        studentPrinter.enterStudentName();
        return sc.nextLine();
    }
    public int inputStudentAge(){
        while (true){
            studentPrinter.enterStudentAge();
            try {
                return Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e) {
                studentPrinter.showInvalidAgeMessage();
            }
        }
    }

    public String inputStudentAddress(){
        studentPrinter.enterStudentAddress();
        return sc.nextLine();
    }


}
