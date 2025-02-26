
/*
 * 패키지명은 클래스명과 식별을 쉽게 하기 위해 기본적으로 모두 소문자로 시작한다. camelCase 여부는 구분하지 않으나 가능한 한 단어로 구성한다.
 */

package com.chapter05.controller;
import java.util.Scanner;

import com.chapter05.dto.StudentDto;
import com.chapter05.dto.StudentDto.Grade;
import com.chapter05.view.View;


/**
 * 학생 성적 정보를 관리하기 위한 Controller<br>
 * 작성자 박재현
 * 2025-02-23
 */

public class ScoreManager {
	
	
	
	//View view = View.getInstance(); //View 객체는 Static 메소드만 들고 있으므로 싱글턴으로 만들어도 의미가 없다...
	//싱글턴으로 만들려면 이 ScoreManager 로직이 싱글턴화가 되어야했는데 이거 고치기엔 시간이 없었음
	
	private StudentDto[] students ;
	private int MAX_STUDENT = 10; //ScoreManager에서 다룰 수 있는 학생의 최대 숫자	
	private int STUDENT_COUNT = 1; //배열 인덱스 컨트롤을 위한 변수 
	
	Scanner scanner = new Scanner(System.in);
	
	public enum InitResult {
		SUCCESS,
		OUT_OF_BOUND
	};
	
	/**
	 * 신규 학생 객체를 생성하는 로직 <br>
	 * 총점과 평균은 별도의 calc 메소드를 통해 구한다 <br>
	 * 생성자 내부가 아닌 외부 로직을 통해 초기화한다. 
	 * @param studentNumber (int) 학번
	 * @param name (String) 학생 이름
	 * @param korScore (double) 국어 점수
	 * @param matScore(double) 수학 점수
	 * @param engScore(double) 영어 점수
	 * @return student (StudentDto) 생성한 학생
	 */
	public StudentDto newStudent(int studentNumber, String name, double korScore, double matScore, double engScore) {
		StudentDto student = new StudentDto();
		student.setStudentNumber(studentNumber);
		student.setStudentName(name);
		student.setKorScore(korScore);
		student.setMatScore(matScore);
		student.setEngScore(engScore);

		student.setTotalScore(calcTotalScore(korScore, matScore, engScore));
		student.setAvgScore(calcAverageScore(korScore,matScore,engScore)); // 과목수를 별도로 관리하고 있지 않으므로 명시적으로 과목 수와 파라미터가 보이는 형태 사용
		student.setGrade(calcGrade(student.getAvgScore()));
		
		return student;
		
	}
	
	/**
	 * 입력받은 학생 객체를 배열에 추가하는 로직
	 * 배열의 길이를 초과하지 않은 경우 세팅된 StudentDto 값을 배열에 추가 <br>
	 * 예외처리 및 UI단에서의 출력을 고려하여 Enum으로 정의한 상태를 반환하도록 한다
	 * @param student (StudentDto) student 학생 객체
	 * @return  (InitResult) 성공 시 Success<br>
	 * 			(InitResult) 최대 학생 수 초과 시 OUT_OF_BOUND
	 */
	public InitResult setNewStudent(StudentDto student) {
		if (STUDENT_COUNT < MAX_STUDENT) {
			students[STUDENT_COUNT++] = student;
			return InitResult.SUCCESS;
		} else			
			return InitResult.OUT_OF_BOUND;		
	}		
	
	/**
	 * 점수를 입력받아 총점을 구한 뒤 리턴하는 로직
	 * @param params (double) 점수1, 점수2, 점수3 ... 마지막 점수
	 * @return 총점
	 */
	public double calcTotalScore(double ... params) {
		double totalScore=0;
		for(double i : params) {
			totalScore+=i;
		}
		return totalScore;
	}
	
	/**
	 * 계산된 총점을 입력받은 과목 수로 나누어 리턴
	 * @param total (double) 총점
	 * @param divide (double) 과목 수
	 * @return 총점 / 과목 수
	 */
	public double calcAverageScore(double total, double divide) {
		return total/divide;
	}
	
	/**
	 * 총점을 구한 뒤 파라미터 수로 나누어 리턴 <br>
	 * 과목수가 별도로 관리되고 있지 않으므로 과목수와 관계없이 유연하게 적용가능한 형태를 의도 <br>
	 * @param params (double) 점수1, 점수2, 점수3 ... 마지막 점수
	 * @return 총점 / 과목 수
	 */
	public double calcAverageScore(double... params) {
		double totalScore=0;
		for(double i : params) {
			totalScore+=i;
		}
		return totalScore / params.length; //총점을 들어온 파라미터 수로 나눈다
	}
	

	/**
	 * 평균을 10으로 나누어 단위별로 등급 리턴<br>
	 * 100점 초과의 점수는 오입력된 잘못된 데이터로 판단하고 F를 리턴
	 * @param (double) 평균 점수
	 * @return (Grade) 판정된 등급
	 */
	public Grade calcGrade(double avgScore) {
		Grade grade = switch((int)avgScore/10) {
			case 10,9 	-> 	Grade.A;
			case 8 		-> 	Grade.B;
			case 7 		-> 	Grade.C;
			case 6 		-> 	Grade.D;
			default 	-> 	Grade.F;
		};	
		return grade;
	}
	
	
	/**
	 * 학생 객체를 배열로 가져오는 초기화 로직 <br>
	 * 예외처리 및 UI단에서의 출력을 고려하여 Enum으로 정의한 상태를 반환하도록 한다
	 * 
	 * @param students 미리 정의된 학생 정보 배열
	 * @return  (InitResult) 성공 시 SUCCESS <br>
	 *			(initResult) 최대 학생 수 초과 시 OUT_OF_BOUND
	 */
	private InitResult init(StudentDto[] students){
		if(students.length<MAX_STUDENT) {
			this.students = students;
			STUDENT_COUNT = students.length-1; //인덱스는 배열길이 -1까지
			return InitResult.SUCCESS;
		}
		else return InitResult.OUT_OF_BOUND;		
	}
	
	/**
	 * 학생 수를 받아서 배열 사이즈 초기화하는 로직<br>
	 * 배열을 전부 리셋하고 최대 학생 수를 지정된 숫자로 변경한다
	 * @param studentCount (int) 최대 학생수
	 */
	public void clearStudentArr(int studentCount) {
		this.students = new StudentDto[studentCount];
		STUDENT_COUNT = 0; //배열 인덱스를 0으로
		MAX_STUDENT=studentCount; //최대 학생수를 입력받은 숫자로
	}
	
	/*----
	 * 학생 추가 기능구현
	 ----*/
	
	/**
	 * 메뉴 화면 로직<br>
	 * View는 뿌려주기만 하고, 입력을 받고 결과를 반한하는 것은 컨트롤러에게 책임이 있다
	 * 컨트롤러 내부에서 루프를 돌고 UI출력과 인풋 로직은 View를 호출해서 처리한다.
	 */
	public void InputMenuLogic() {
		boolean isRunning = true;
		int input = 0;
		while (isRunning) {
			View.printMenu();
			input = scanner.nextInt();
			switch (input) {
			case 1: //배열 크기 변경
				int count = View.InputCount();
				clearStudentArr(count);
				break;

			case 2: //학생 입력
				makeStudent();
				break;

			case 3: //전체 학생 정보 출력
				for (int i = 0; i < STUDENT_COUNT; i++) {
					View.printPersonalScore(students[i]);
				}
				break;

			case 4: //최대 평균점수 및 전체 평균 출력
				calcMaxScore();
				break;

			case 5: //종료
				isRunning = false;
				View.printExitMenu();
				break;

			default:
				break;

			}
		}
	}
	
	/**
	 * View의 인풋UI를 호출해서 리턴값을 받아 학생 객체를 생성한다.
	 */
	private void makeStudent() { //클래스 내 로직에서 호출하므로 private로 선언해도 호출에 문제없다
		int stdNumber;
		String name;
		double kor, mat, eng;
		stdNumber = View.inputStdNumber();
		name = View.inputName();
		kor = View.inputKor();
		mat = View.inputMat();
		eng = View.inputEng();
		StudentDto student = newStudent(stdNumber, name, kor, mat, eng);
		View.printResult(setNewStudent(student));
	}
	
	/**
	 * 들고있는 students 배열 전체를 순회하며 가장 높은 평균점수와 전체평균을 산출한다.
	 */
	private void calcMaxScore() { //클래스 내 로직에서 호출하므로 private로 선언해도 호출에 문제없다
		double maxAvg = 0;
		double total = 0;
		String maxAvgName = null;

		for (int i = 0; i < STUDENT_COUNT; i++) { //학생 수만큼 루프를 돈다. 배열 전체를 순회하지 않으므로 enhanced for를 사용하지 않는다
			if (students[i].getAvgScore() > maxAvg) {
				maxAvg = students[i].getAvgScore();
				maxAvgName = students[i].getStudentName();
			}
			total += students[i].getAvgScore();
		}
		View.printScoreAnalysis(maxAvgName, maxAvg, total);
		
	}
	
	
	/**
	 * 디폴트 생성자
	 */
	public ScoreManager(){
		clearStudentArr(1); // 길이가 null이 되지 않도록 비어있는 사이즈 1짜리 배열 생성해 초기화
	}
	
	/**
	 * 생성자
	 * @param students (StudentDto) students 
	 */
	public ScoreManager(StudentDto[] students){
		init(students);
	}
	

	

}
