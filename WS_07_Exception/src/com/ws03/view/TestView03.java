package com.ws03.view;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.View;

import com.ws03.exception.BalanceLackException;
import com.ws03.exception.UserAccountNotFoundException;
import com.ws03.dto.AccountDto;
import com.ws03.service.BankService;
import com.ws03.service.BankServiceImpl;

public class TestView03 {
	public static void main(String[] args) throws InputMismatchException {

		BankService bankService = new BankServiceImpl();

		
		/*System.out.println("1. 모든 계좌정보 조회 ------");
		print(bankService.getAccountList());
		
		System.out.println("2.잔액기준으로 정렬하기 -------------");
		print(bankService.getAccountListSortByBalance());
		
		
		System.out.println("3.UserSeq 기준으로 정렬하기 -------------");
		print(bankService.getAccountListSortByUserSeq());
		
		
		System.out.println("4. 모든 계좌정보 조회 ------");
		print(bankService.getAccountList());*/
		
		
		////////WS_ 추가된 문제///////////////////////////////////////
		try {
			int withdrawAmount = bankService.withdraw(100, 1, 10);
			System.out.println(withdrawAmount);			
			System.out.println(bankService.getUserAccount(111, 90));
			System.out.println("ddd");
			
		}catch( BalanceLackException | UserAccountNotFoundException e ) {
			System.out.println( e.getMessage());
		} 
		
		/*
		 *인풋받아서 넣는 기능 적용... 문제 다시 보니 문제 요구사항의 "입력받아" 가 이걸 의미하는 게 아닌 것 같지만 일단 만들었으니 남겨두는... 
		 */
		try {
			withdrawInput(bankService);
		} catch( BalanceLackException | UserAccountNotFoundException e ) {
			System.out.println( e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
		} 
		
	}

	
	/**
	 * 계좌목록 출력하기
	 * */
	public static void print(List<AccountDto> accountList) {
		for (AccountDto accountDto : accountList) {
			System.out.println(accountDto);
		}
		System.out.println();
	}

	
	/*
	 * 인풋받아서 넣는 기능 
	 * 컨트롤러 없는 구조로 MVC 스타일로 분리가 안된 상태이므로... 컨트롤러 만들지 않고 임시로 구현
	 * InputView가 싱글톤 Static 구현이어서 어디 두어도 일단 동작은 할 것으로 예상됨... 컨트롤러 분리할때 컨트롤러쪽으로 옮겨넣고 기능 책임 하나씩 분리
	 * 애초에 이거까지 의도한 과제가 아니었던거 같고 MVC 형태로 분리해서 컨트롤러 만들어 넣는 과제가 나중에 나올 것 같으니 여기까지만 
	 */

	public static void withdrawInput(BankService bankservice) throws InputMismatchException, BalanceLackException, UserAccountNotFoundException {
		Scanner sc = new Scanner(System.in);
		int userSeq = userSeqInput(sc);
		int accountNum = accountNumInput(sc);
		int withdrawAmount = withdrawAmountInput(sc);
		bankservice.withdraw(userSeq,accountNum,withdrawAmount);
	}
	
	public static int userSeqInput(Scanner sc) throws InputMismatchException{
		//나중에 리팩토링할때 분리
		InputView.getInstance();
		InputView.userSeqInputPrint();
		int userSeq=0;
		try{
			userSeq = sc.nextInt();
			return userSeq;
		}catch (InputMismatchException e) {
			sc.nextLine();//Buffer Clear
			throw e;
		}
	}

	public static int accountNumInput(Scanner sc) throws InputMismatchException{
		//나중에 리팩토링할때 분리
		InputView.getInstance();
		InputView.accountNumberInputPrint();
		int accountNum; 
		try{
			accountNum=sc.nextInt();
			return accountNum;
		}catch (InputMismatchException e) {
			sc.nextLine();//Buffer Clear
			throw e;
		}		
	}
	
	public static int withdrawAmountInput(Scanner sc) throws InputMismatchException {
		//나중에 리팩토링할때 분리
		InputView.getInstance();
		InputView.withdrawAmountInputPrint();
		int amount;
		try{
			amount = sc.nextInt();
			return amount;
		}catch(InputMismatchException e) {
			sc.nextLine();//Buffer Clear
			throw e;
		}		
	}	
}
