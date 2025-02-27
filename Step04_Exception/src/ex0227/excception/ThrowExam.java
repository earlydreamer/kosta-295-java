package ex0227.excception;

import java.io.IOException;

/**
 * Throws 말고 Throw
 * 예외를 직접 던지는 예제
 */
public class ThrowExam {
	
	/**
	 * 매개변수로 음수를 받으면 예외처리를 하고 싶다...
	 */
	public void methodA(int i) throws IOException {
		System.out.println("Call Method A");
		if(i<0) {
//			IllegalArgumentException e = new IllegalArgumentException("음수는 넣을 수 없읍니다...");//인수가 적합하지 않을 경우의 예외...
//			throw e; //e 예외를 발생시킨다

//			throw new IllegalArgumentException("음수는 넣을 수 없읍니다..."); //직접 세팅한 메시지가 로그에 찍힌다

			throw new IOException ("뭐시기 뭐시기"); //IOException은 체크예외이기 때문에 반드시 예외처리를 해야 한다 (처리 전엔 컴파일이 안된다)
			
			
		}
		
		System.out.println("End of Method A");
		
	}
	
	public static void main (String args[]) throws IOException {
		System.out.println("--Main Start--");
		
		new ThrowExam().methodA(-1);
		
		System.out.println("---------------");
		
	}

}
