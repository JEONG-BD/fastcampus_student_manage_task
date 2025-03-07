package org.demo.student_manage.ui;

public class CoursePrinter {
    public void enterCourseName(){
        System.out.println("== 과외 과목을 입력하세요 ==");
    }

    public void enterCourseDay(){
        System.out.println("== 요일을 입력하세요==");
    }

    public void enterCourseFee(){
        System.out.println("== 과외 비용 입력하세요==");
    }

    public void enterCourseTime(){
        System.out.println("== 과외 시간을 입력하세요==");
    }

    public void showInvalidAgeMessage(){
        System.out.println("== 유효한 입력값이 아닙니다== ");
    }

    public void showUpdateFeeMessage() {
        System.out.println("==비용이 업데이트 되었습니다== ");

    }
}
