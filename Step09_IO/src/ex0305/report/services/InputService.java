package ex0305.report.services;

import java.util.Scanner;

import ex0305.report.model.Profile;

/**
 * 입력과 관련된 로직을 정의한 Service
 * @author 박재현
 * 2025-03-06
 */
public class InputService implements InputAction {

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
	
	public InputService(){
		
	}

}
