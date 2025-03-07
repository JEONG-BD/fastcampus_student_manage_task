package org.demo.student_manage.service;

import org.demo.student_manage.domain.Student;
import org.demo.student_manage.dto.request.StudentCreateDto;
import org.demo.student_manage.dto.response.StudentFindDto;
import org.demo.student_manage.repository.StudentRepository;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(StudentCreateDto student){
        studentRepository.save(new Student(student.getName(),
                student.getAge(),
                student.getAddress()));
    }

    public StudentFindDto findStudentByName(String name) {
        Student findStudent = studentRepository.find(name).orElseThrow(() -> new IllegalArgumentException());
        StudentFindDto studentFindDto = new StudentFindDto(findStudent.getName(), findStudent.getAge(), findStudent.getAddress());
        return studentFindDto;
    }

    public void updateActivate(String name) {
        Student findStudent = studentRepository.find(name).orElseThrow(() -> new IllegalArgumentException());
        findStudent.updateActivated();
    }

    public void updateDeactivate(String name) {
        Student findStudent = studentRepository.find(name).orElseThrow(() -> new IllegalArgumentException());
        findStudent.updateDeactivated();
        System.out.println("findStudent = " + findStudent);
    }
}
