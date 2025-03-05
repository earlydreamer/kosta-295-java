package ex0305.report.services;

import java.util.Scanner;

import ex0305.report.model.Profile;

/**
 * 비즈니스로직
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

}
