package org.demo.student_manage.ui;

public class StudentPrinter {


    public void enterStudentName(){
        System.out.println("== 학생 이름을 입력하세요 ==");
    }

    public void enterStudentAge(){
        System.out.println("== 학생 나이를 입력하세요 ==");
    }

    public void enterStudentAddress(){
        System.out.println("== 학생 주소를 입력하세요 ==");
    }

    public void showInvalidAgeMessage(){
        System.out.println("== 유효한 입력값이 아닙니다 == ");
    }

    public void showUpdateActivated(){
        System.out.println("== 학생이 활성화 상태로 변경되었습니다== ");
    }

    public void showUpdateDeActivated(){
        System.out.println("== 학생이 비활성화 상태로 변경되었습니다== ");
    }

}
