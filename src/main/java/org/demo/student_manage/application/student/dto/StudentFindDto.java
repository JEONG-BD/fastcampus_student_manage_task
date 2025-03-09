package org.demo.student_manage.application.student.dto;

public class StudentFindDto {
    private String name;
    private int age;
    private String address;
    private Boolean activated;

    public StudentFindDto(String name, int age, String address, boolean activated) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.activated = activated;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "StudentFindDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", activated=" + activated +
                '}';
    }
}
