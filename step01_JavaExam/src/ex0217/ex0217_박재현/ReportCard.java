package ex0217.ex0217_박재현;
import java.util.Scanner;

	
class ScoreManager{
	/**
	 * 20250217		
	 * 작성자 박재현
	 * 성적 정보를 관리하기 위한 Class
	 */
	
	
	private double korScore = 	0;
	private double matScore = 	0;
	private double engScore = 	0;
	private double totalScore = 0;
	private double avgScore = 	0;
	
	private int subjectCount = 3;
	
	private String name = null;
	private String grade;
	
	
	/**
	 * param1 : 이름
	 * private 값을 외부에서 직접 수정할 수 없으므로, setter 역할을 하는 메소드를 통해 이름을 수정한다.
	 */
	private void setName(String param1) {

		name = param1;
	}

	/**
	 * SetScore 메소드 : 
	 * private 값을 외부에서 직접 수정할 수 없으므로 setScore 메소드를 통해 간접적으로 수정한다. 
	 * 3개의 과목 점수를 한꺼번에 입력한다. setter 역할을 한다.2
	 * @param param1 : 국어 
	 * @param param2 : 수학 
	 * @param param3 : 영어
	 */
	private void setScore(double param1, double param2, double param3) {		

		
		korScore = param1;
		matScore = param2;
		engScore = param3;				
		
	}
		
	
	private double setTotal(double param1, double param2, double param3) {
		/**
		 * 총점을 계산하는 역할
		 * 파라미터로 넘어온 값을 계산해 리턴한다.
		 * param1 : 국어 / param2 : 수학 / param3 : 영어
		 */

		return param1 + param2 + param3;
	}
	
	
	
	private double setAverage(double param1, double param2) {
		/**
		 * 평균을 계산하는 역할
		 * 파라미터로 넘어온 값을 계산해 리턴한다.
		 * param1 : 총점 / param2 : 과목 수
		 */
	
		return param1 / param2;
	}
	
	
	
	private String setGrade(double param1) {
		
		/**
		 * 등급을 계산해서 리턴한다.
		 * param1 : 평균
		 */
		
		String result = switch((int)param1/10) {
		case 10, 9 -> "A";
		case 8 -> "B";
		case 7 -> "C";
		case 6 -> "D";
		default -> "F";
		};
		
		return result;
		
	}
	

	/**
	 * SetReportCard 클래스
	 * 파라미터를 받아서 private 변수의 값을 set하는 private 메소드로 전달한다.
	 * @param param1 이름 
	 * @param param2 국어 
	 * @param param3 수학 
	 * @param param4 영어
	 * 
	 */
	public void setReportCard(String param1, double param2, double param3, double param4) {
		
		setName(param1);
		setScore(param2, param3, param4);

		totalScore = setTotal(korScore, matScore, engScore);
		avgScore = setAverage(totalScore , subjectCount);
		grade = setGrade(avgScore);

	}
	
	/**
	 * private 변수에 있는 값을 콘솔에 출력
	 */		
	public void printScore()
	{

		System.out.println("--- 성적 계산 결과 ---");
		System.out.println("이름 : " + name);
		System.out.println("---------------------");
		System.out.println("국어 : " + korScore);
		System.out.println("수학 : " + matScore);
		System.out.println("영어 : " + engScore);
		System.out.println("---------------------");
		System.out.println("총점 : " + totalScore);
		System.out.println("평균 : " + avgScore);
		System.out.println("---------------------");
		System.out.println("등급 : " + grade);
		System.out.println("---------------------");
	}
	
//외부에서 필요시 값에 접근하기 위한 getter
	
//	public double getKorScore() {
//		return korScore;
//	}
//	public double getMatScore() {
//		return matScore;
//	}
//	public double getEngScore() {
//		return engScore;
//	}
//	public double getAvgScore() {
//		return avgScore;
//	}
//	public double getTotalScore() {
//		return totalScore;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	
//	public String getGrade() {
//		return grade;
//	}
//	
//	
//	}
	
}


/**
 * 20250217		
 * 작성자 박재현
 * 성적 프로그램 실행을 위한 Class
 */
public class ReportCard {
	

	
	
	public static void main (String args[]) {

		ScoreManager manager = new ScoreManager();
		
		boolean isRunning = true;

		Scanner sc = new Scanner(System.in);
		
		String name;
		String lineinput;
		
		int selector;
		double korInput, matInput, engInput;		
		
		while(isRunning) {
			
			if(!isRunning)
				break;
			
			System.out.println("--성적구하기--");
			System.out.println("1. 성적표구하기 / 2. 종료");
			System.out.println("--------------");
			
			selector = sc.nextInt();	
			lineinput = sc.nextLine();
			
			if(selector == 1){
				System.out.print ("이름 >");
				name = sc.next();	
				System.out.print ("국어 >");
				korInput = sc.nextDouble();
				System.out.print ("수학 >");
				matInput = sc.nextDouble();
				System.out.print ("영어 >");
				engInput = sc.nextDouble();
				
				manager.setReportCard(name, korInput, matInput, engInput);
				manager.printScore();
				
			}
				
			else if(selector==2)
				isRunning = false;

			else
				System.out.println("잘못된 입력입니다.");

			System.out.println ("계속하려면 입력하세요 . . .");
			lineinput = sc.nextLine();
			lineinput = sc.nextLine();
			
		}
		
	}
	
}