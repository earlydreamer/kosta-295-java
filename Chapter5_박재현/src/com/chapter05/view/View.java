
/*
 * 패키지명은 클래스명과 식별을 쉽게 하기 위해 기본적으로 모두 소문자로 시작한다. camelCase 여부는 구분하지 않으나 가능한 한 단어로 구성한다.
 */

package com.chapter05.view;
import java.util.Scanner;

import com.chapter05.controller.ScoreManager;
import com.chapter05.controller.ScoreManager.InitResult;
import com.chapter05.dto.StudentDto;


/**
 * View 클래스에서는 View 역할을 담당한다. <br>
 * View는 값을 직접 저장하지 않는다. 입력 혹은 전달받은 내용을 화면에 표시하고, 필요 시 Controller에게 전달 후 버린다. <br>
 * View에서 값을 변수에 저장하면 MVC 형태에 위배된다. <br>
 * 작성자 박재현
 * 2025-02-23
 */

public class View {
	
	
	
	private static View view = new View();	
	private View() {
		
	}
	
	/**
	 * 싱글턴 객체 리턴
	 * @return (view) view 싱글턴 객체
	 */
	public static View getInstance() {
		return view;
	}
	
	
	Scanner scanner = new Scanner(System.in);
	public static void printMenu() {
		System.out.println("-------------- 학생성적관리프로그램 ----------------");
		System.out.println("1. 학생수 2. 점수입력 3. 점수리스트 4. 분석 5. 종료");
		System.out.println("----------------------------------------------------");
	}
	
	/*
	 * 입력과 관련된 기능은 전부 Controller에서 수행
	 * View에서는 출력 기능만을 담당
	 * 기능을 갖는 Scanner는 전부 Controller로 보내고 View는 텍스트 출력 기능만 갖는다
	 */
	
	//변수명이 print어쩌구저쩌구로 너무 길다 싶으면 print 부분을 자르고 나중에 접근할때 명시적으로 view.inputCount() 식으로 접근해도 될 듯함
	public static void printInputCount() { 
		System.out.print("학생 수를 입력하세요 > ");
	}

	public static void printInputStdNumber() {
		System.out.print("학번을 입력하세요 > ");
	}
	
	public static void printInputName() {
		System.out.print("이름을 입력하세요 > ");
		
	}
	
	public static void printInputKor() {
		System.out.print("국어점수를 입력하세요 > ");
		
	}
	
	public static void printInputMat() {	
		System.out.print("수학점수를 입력하세요 > ");
	}
	
	public static void printInputEng() {
		System.out.print("영어점수를 입력하세요 > ");
		
	}
	
	public static void printScore() {
		System.out.print("점수 리스트를 출력합니다.");
	}
	
	public static void printPersonalScore(StudentDto student) {
		System.out.println("-------------------------");
		System.out.println(" 학생 이름	: "+student.getStudentName());
		System.out.println(" 국어 점수	: "+student.getKorScore());
		System.out.println(" 수학 점수	: "+student.getMatScore());
		System.out.println(" 영어 점수	: "+student.getEngScore());
		System.out.println(" 총점		: "+student.getTotalScore());
		System.out.println(" 평균		: "+student.getAvgScore());
		System.out.println(" 등급		: "+student.getGrade());
		System.out.println("-------------------------");
	}
	
	
	public static void printScoreAnalysis(String avgName, double avg, double totalAvg) {
		System.out.println("-------------------------");
		System.out.println("점수 분석 결과를 출력합니다.");
		System.out.println("-------------------------");
		System.out.println("최대 점수 학생 : " + avgName +" "+ avg +"점");
		System.out.println("전체 학생 평균 : " + totalAvg +"점");
		System.out.println("-------------------------");
	}
	
	public static void printExitMenu() {
		System.out.println("-------------------------");
		System.out.println("종료합니다.");
		System.out.println("-------------------------");
	}
	
	public static void printResult(ScoreManager.InitResult result) {
		if(result==InitResult.OUT_OF_BOUND) {
			System.out.println("-------------------------");
			System.out.println("배열의 길이를 벗어났습니다.");
			System.out.println("-------------------------");
			}
		
	}
}

