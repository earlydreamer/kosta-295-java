package ex0218.ex0218_박재현;
import java.util.Scanner;
/**
 * 20250218
 * 작성자 박재현<br>
 * 학생의 점수 정보를 저장하는 Class <br>
 * 데이터를 저장하는 역할을 수행 <br>
 * 값을 getter - setter를 통해 관리
 */

class Student{	
	private String name = null;
	private double korScore = 	0;
	private double matScore = 	0;
	private double engScore = 	0;
	private double totalScore = 0;
	private double avgScore = 	0;
	
	private String grade;
	
	/* ----
	 * Getter
	 ----- */
	
		
	public double getKorScore() {
		return korScore;
	}
	public double getMatScore() {
		return matScore;
	}
	public double getEngScore() {
		return engScore;
	}
	public double getAvgScore() {
		return avgScore;
	}
	public double getTotalScore() {
		return totalScore;
	}
	public String getName() {
		return name;
	}
	public String getGrade() {
		return grade;
	}
	
	
	/* -----
	 * Setter
	 ----- */
	
	/**
	 *
	 * @param param1 학생 이름
	 */
	protected void setName(String param1) {
		name = param1;
	}		
	
	/**
	 *
	 * @param param1 국어점수
	 */
	protected void setKorScore(double param1) {
		korScore = param1;
	}
	/**
	 *
	 * @param param1 수학점수
	 */
	protected void setMatScore(double param1) {
		matScore = param1;
	}	
	/**
	 *
	 * @param param1 영어점수
	 */
	protected void setEngScore(double param1) {
		engScore = param1;
	}	
	/**
	 * 계산은 외부의 계산로직에서 수행하고 값을 세팅하는 역할만 수행
	 * @param param1 총점
	 */	
	protected void setTotalScore(double param1) {
		totalScore = param1;
	}
	/**
	 * 계산은 외부의 계산로직에서 수행하고 값을 세팅하는 역할만 수행
	 * @param param1 평균점수
	 */
	protected void setAverageScore(double param1) {
		avgScore = param1;
	}
	
	/**
	 * 계산은 외부의 계산로직에서 수행하고 값을 세팅하는 역할만 수행
	 * @param param1 학점
	 */
	protected void setGrade(String param1) {
		grade = param1;
	}
	
}
/**
 *
 * @param param1 계산기 클래스
 */
class ScoreCalc{
	
	
	public Student setStudent(String param1, double param2, double param3, double param4){
		Student student = new Student();
		student.setName(param1);
		
		student.setKorScore(param2);
		student.setMatScore(param3);
		student.setEngScore(param4);
		
		//값은 계산기 클래스의 로직을 통해 계산
		student.setTotalScore(calcTotalScore(param2, param3, param4));
		student.setAverageScore(calcAverageScore(param2, param3, param4));
		student.setGrade(calcGrade(student.getAvgScore()));
		return student;
		
	}		
	/**
	 *
	 * @param params double 과목1, double 과목2, double 과목3 ... 과목 개수만큼
	 * @return
	 */
	public double calcTotalScore(double... params) {
		double returnParam = 0;
		for(double i : params)
			returnParam+=i;
		return returnParam;	
	}
	
	/**
	 *
	 * @param params double 과목1, double 과목2, double 과목3 ... 과목 개수만큼
	 * @return
	 */
	public double calcAverageScore(double... params) {
		double returnParam = 0;
		for(double i : params)
			returnParam+=i;
		return returnParam / params.length; // 과목 점수의 합을 과목 수(배열길이) 로 나눔
	}
	
	/**
	 * 평균 기준 10점 단위로 학점을 판정 / 100점을 넘는 경우, 음수 등은 스펙 밖의 데이터이므로 default 타고 F로 처리
	 * @param param1 double 평균점수
	 * @return
	 */
	public String calcGrade(double param1) {
		String grade = switch((int)param1/10) {
		case 10, 9 -> "A";
		case 8 -> "B";
		case 7 -> "C";
		case 6 -> "D";
		default -> "F";
		};
		return grade;
	}
	
}
/**
 * 화면 출력의 로직을 담당하는 Class
 */
class ViewLogic {
	Scanner sc = new Scanner(System.in);
	String input;
	public void printMenu() {
		System.out.println("--성적구하기--");
		System.out.println("1. 학생수 / 2. 점수입력 / 3. 점수리스트 / 4. 분석 / 5. 종료");
		System.out.println("--------------");
	}
	public void printScore(Student param1) {
		System.out.println("--- 성적 계산 결과 ---");
		System.out.println("이름 : " + param1.getName());
		System.out.println("---------------------");
		System.out.println("국어 : " + param1.getKorScore());
		System.out.println("수학 : " + param1.getMatScore());
		System.out.println("영어 : " + param1.getEngScore());
		System.out.println("---------------------");
		System.out.println("총점 : " + param1.getTotalScore());
		System.out.println("평균 : " + param1.getAvgScore());
		System.out.println("---------------------");
		System.out.println("등급 : " + param1.getGrade());
		System.out.println("---------------------");
	}
	
	
	
	void menuLogic(Student[] students1, ScoreCalc calc) {
		boolean isRunning = true;
		String name;
		double kor, mat, eng, total, avg;
		int inputNumber;
		Student[] students = null;
		
		/**
		 * 메뉴를 출력하는 로직 <br>
		 */
		while (isRunning) {
			if (!isRunning)
				break;
			printMenu();
			input = sc.nextLine();
			inputNumber = Integer.parseInt(input);
			if (inputNumber == 1) {
				System.out.println("학생 수를 입력하세요.");
				input = sc.nextLine();
				inputNumber = Integer.parseInt(input);
					students = new Student[inputNumber]; //입력값 사이즈의 배열 생성
					System.out.println(students.length);
			} else if (inputNumber == 2) {
				int length = students.length;
				System.out.println("학생별 성적을 입력합니다." + "학생 수 : "+length);
				if (length > 0) {
					for (int i = 0; i < length; i++) {
						System.out.println(i+1 + "번째 학생 성적");
						System.out.println("학생 이름 입력");
						input = sc.nextLine();
						name = input;
						System.out.println("국어성적 입력");
						input = sc.nextLine();
						kor = Double.parseDouble(input);
						System.out.println("수학성적 입력");
						input = sc.nextLine();
						mat = Double.parseDouble(input);
						System.out.println("영어성적 입력");
						input = sc.nextLine();
						eng = Double.parseDouble(input);
						System.out.println("학생 성적을 기록합니다.");
						students[i] = calc.setStudent(name, kor, mat, eng);
					}
				} else {
					System.out.println("학생 수가 1명 이상이어야 합니다");
				}
			} else if (inputNumber == 3) {
				// 점수 출력
				if(students.length>0) {
				for(int i=0;i<students.length;i++)
					printScore(students[i]);
				}
			} else if (inputNumber == 4) {
				// 가장 높은 총점, 가장 높은 평균 출력
				
				int length = students.length;
				double maxScore = 0;
				for(int i = 0;i<length;i++) {
					if(students[i].getTotalScore() >maxScore)
						maxScore=students[i].getTotalScore();				
				}
				System.out.println("최대 총점" + maxScore );

				maxScore = 0;
				for(int i = 0;i<length;i++) {
					if(students[i].getAvgScore() >maxScore)
						maxScore=students[i].getAvgScore();
				}
				System.out.println("최대 평균" + maxScore );
				
				
			} else if (inputNumber == 5) {
				isRunning = false;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}



public class ReportCard {	
	public static void main (String args[]) {
		Student[] students = null;
		ViewLogic viewlogic = new ViewLogic();
		ScoreCalc calc = new ScoreCalc();
		
		viewlogic.menuLogic(students, calc);
		
		
	}
}