package org.demo.student_manage.domain;

public class Student {

    private final String name;
    private final int age ;
    private final String address ;

    private boolean activated;

    public Student(String name, int age, String address) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("이름은 필수입니다");
        }

        this.name = name;
        this.age = age;
        this.address = address;
        this.activated = true;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean isActivated() {
        return activated;
    }

    public void updateActivated(){
        if(!this.activated) {
            this.activated = true;
        }
    }

    public void updateDeactivated(){
        if(this.activated) {
            this.activated = false;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", activated=" + activated +
                '}';
    }
}
