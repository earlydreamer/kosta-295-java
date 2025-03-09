package com.ws03.view;

import java.util.Scanner;

public class InputView {

	private static InputView instance = new InputView();
	
	private InputView(){
	}
	
	public static InputView getInstance() {
		return instance;
	}
	
	public static void userSeqInputPrint() {
		System.out.print("고객번호를 입력하세요 >");
	}
	
	public static void accountNumberInputPrint() {
		System.out.print("계좌번호를 입력하세요 >");
	}
	
	public static void withdrawAmountInputPrint() {
		System.out.print("출금 금액을 입력하세요 >");
	}
	

	
}
