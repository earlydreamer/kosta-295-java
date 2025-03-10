package ex0305.report.controller.io;

/**
 * 입력과 관련된 기능을 정의한 인터페이스
 * @author 박재현
 * 2025-03-06
 */
public interface InputAction {
	
	/**
	 * String타입 입력을 받고 리턴하는 메소드
	 * @return (String) 입력값
	 */
	String inputString();
	/**
	 * Double 타입 입력을 받고 리턴하는 메소드
	 * @return (double) 입력값
	 */
	double inputDouble();
	/**
	 * Int 타입 입력을 받고 리턴하는 메소드
	 * @return (int) 입력값
	 */
	int inputInt();
	
}
