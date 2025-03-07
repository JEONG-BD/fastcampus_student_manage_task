package org.demo.student_manage.repository;

import org.demo.student_manage.domain.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StudentRepository {

    private final Map<String, Student> studentMap = new HashMap<>();

    public void save(Student student){
        studentMap.put(student.getName(), student);
    }

    public Optional<Student> find(String name) {
        return Optional.ofNullable(studentMap.get(name));

    }
}
