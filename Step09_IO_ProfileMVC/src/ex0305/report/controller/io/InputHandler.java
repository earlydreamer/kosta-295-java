package ex0305.report.controller.io;

import java.util.Scanner;

import ex0305.report.model.Profile;

/**
 * 입력과 관련된 로직을 정의한 클래스<br>
 * 잘 생각해보니 Service 레이어보단 컨트롤러의 하위 기능으로 구분해야 할 것 같다
 * Input 
 * @author 박재현
 * 2025-03-06
 */
public class InputHandler implements InputAction {

	Scanner sc = new Scanner(System.in);
	
	@Override
	public String inputString() {
		String returnString = sc.next();
		return returnString;
	}
	
	@Override
	public double inputDouble() {
		double returnDouble = sc.nextDouble();
		return returnDouble;
	}

	@Override
	public int inputInt() {
		int returnInt = sc.nextInt();
		return returnInt;
	}
	
	/*
	 * --------------------------------Constructor ----------------------------------
	 */
	
	public InputHandler(){
		
	}

}
