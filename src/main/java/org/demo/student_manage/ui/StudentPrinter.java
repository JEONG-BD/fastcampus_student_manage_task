package org.demo.student_manage.ui;

public class StudentPrinter {



    public void showMenu() {
        System.out.println("1. 학생 추가");
        System.out.println("2. 수업 등록");
        System.out.println("3. 요일별 수업 조회");
        System.out.println("4. 학생 활성화");
        System.out.println("5. 학생 비활성화");
        System.out.println("6. 수강료 변경");
        System.out.println("0. 종료");
    }

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

    public void showInvalidInputMessage() {
        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
    }

    public void showErrorMessage() {
        System.out.println("해당하는 기능이 없습니다.");
    }



}
