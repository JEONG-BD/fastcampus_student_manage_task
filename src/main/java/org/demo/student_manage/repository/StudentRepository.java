package org.demo.student_manage.repository;

import org.demo.student_manage.domain.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {

    private final Map<String, Student> studentMap = new HashMap<>();

    public void save(Student student){
        studentMap.put(student.getName(), student);
    }


    public Student find(String name) {
    // TODO Exception
        return studentMap.get(name);

    }
}
