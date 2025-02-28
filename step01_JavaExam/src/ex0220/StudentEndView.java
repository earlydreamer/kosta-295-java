package ex0220;

/**
 * 각 요청의 결과를 모니터에 출력하는 클래스
 */
public class StudentEndView {
	
	/**
	 * 단일대상 출력
	 */
	public static void printSingleResult(Student s){
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getAddr());
	}
	
	/**
	 * 전체출력
	 */
	public static void printAll(Student[] s) {
		for(Student s2 : s) {
			if(s2!=null)
				printSingleResult(s2);
			else
				break;
		}
	}
	
	/**
	 * 성공 / 실패 메시지
	 */
	public static void printResult(boolean resultIsTrue) {
		if(resultIsTrue)
			System.out.println ("성공");
		else
			System.out.println("실패");
	}
	
	
	/**
	 * 
	 */
	
	
	
}
