package com.ws03.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ws03.dto.AccountDto;
import com.ws03.dto.InstallAccountDto;
import com.ws03.dto.LoanAccountDto;
import com.ws03.dto.SavingAccountDto;
import com.ws03.dto.UserDto;
import com.ws03.exception.BalanceLackException;
import com.ws03.exception.UserAccountNotFoundException;
import com.ws03.view.InputView;

/**
 * 고객과 계좌에 관련된 서비스 <br>
 * (Business Logic 을 처리하는 객체)<br>
 * 
 * 2025-02-22 <br>
 * 작성자 박재현 <br>
 * 
 */

public class BankServiceImpl implements BankService {

	/** 개설 가능한 계좌 수 */
	final int ACCOUNT_SIZE = 10;
	/** 최대 고객 수 */
	final int USER_SIZE = 5;

	/** 현재 개설된 계좌의 개수 */
	int ACCOUNT_CURRENT_SIZE;
	/** 현재 고객 수 */
	int USER_CURRENT_SIZE;

//	AccountDto [] accountList;
//	UserDto [] userList;
	List<AccountDto> accountList;
	List<UserDto> userList;

	InputView view = InputView.getInstance(); //MVC에 위배되지만, 현재 Controller가 없는 형태의 코드이다. 임시로 View를 직접 호출하는 형태로 구현하고 리팩토링한다... 
	
	
	/**
	 * 테스트용 초기화 로직
	 */
	private void testInit(List<AccountDto> accountList, List<UserDto> userList) {
		// 생성할 수 있는 최대 사이즈에 맞춰 배열 생성
//		 userList = new UserDto[USER_SIZE]; //5
//		 accountList = new AccountDto [ACCOUNT_SIZE]; //10

		// 의존성 주입을 이용한 초기화
		this.accountList = accountList;
		this.userList = userList;

		// 각 배열방에 고객과 계좌를 생성한다.
		// 고객 4명
		userList.add(new UserDto(100, "장희정", "8253jang@daum.net", "010-8875-8253", false));
		userList.add(new UserDto(200, "이효리", "lee@daum.net", "010-2222-3333", false));
		userList.add(new UserDto(300, "송중기", "song@naver.com", "010-5554-2222", false));
		userList.add(new UserDto(400, "삼순이", "sam@daum.com", "010-2222-2222", false));

		// 계좌는 6개 정도
		accountList.add(new AccountDto(1, "1111-11111", 1000000, 100));
		accountList.add(new InstallAccountDto(2, "2222-22222", 250000, 100, 5, 50000));
		accountList.add(new SavingAccountDto(3, "3333-33333", 350000, 100, 500));

		accountList.add(new AccountDto(4, "4444-44444", 150000, 200));
		accountList.add(new LoanAccountDto(5, "5555-55555", 250000, 200, "테스트용담보"));

		accountList.add(new AccountDto(6, "6666-66666", 350000, 300));
	}

	/**
	 * Default 생성자 <br>
	 * 테스트에 용이하도록 테스트용 로직은 메소드로 분리해서 관리<br>
	 * 들어가는 메소드를 다른 메소드로 교체하면 다른 케이스를 바로 테스트할 수 있다
	 */
	public BankServiceImpl() {
		testInit(new ArrayList<AccountDto>(), new ArrayList<UserDto>()); // 테스트 코드를 생성자에 넣어 실행

	}// 생성자 끝

//	/**
//     * userSeq에 해당하는 계좌 목록을 가져오는 메소드
//     * @param userSeq (int) 계좌를 가져올 사용자의 고유번호 
//     * @return (AccountDto[]) 해당 고유번호의 고객이 가진 계좌 배열
//     */
//	public AccountDto[] getAccountList(int userSeq) {
////		문제의 요구사항이 특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성하는 것이므로 for문 내부 로직만 List를 이용하는 것으로 바꾸고 껍데기는 그대로 둔다.
//
//		int count=0;
//		AccountDto[] tempArr = new AccountDto[accountList.size()]; //임시배열 -> 전체 Account 개수를 넘지않음
//		for(AccountDto accountDto : accountList) {//전체 계좌 순회
//			if(accountDto.getUserSeq()==userSeq) {//userSeq 값이 같으면
//				tempArr[count] = accountDto;//임시저장용 배열에 추가
//				count++; //인덱스컨트롤용 임시변수 증가
//			}
//		}AccountDto[] returnArray = cutAccountArray(tempArr,count); //인덱스 크기에 맞춰서 배열 cut해 리턴	
//		return returnArray;
//	}
//	
//	/**
//	 * 리턴용 AccountArray 자르기
//	 * @param array (AccoutDto) 잘라낼 배열
//	 * @param length (int) 잘라낼 길이
//	 * @return (AccountDto) 길이에 맞춰 잘라낸 배열
//	 */
//	AccountDto[] cutAccountArray(AccountDto[] array, int length ) {
//		AccountDto[] dest = new AccountDto[length];
//		for(int i=0;i<length;i++) {
//			if(array[i]!=null)
//				dest[i] = array[i];
//			else
//				dest[i]=null; //대상 array보다 긴 length가 들어왔을 경우 null로 채운다... (임시예외처리)
//		}
//		return dest; //길이대로 자른 array를 리턴한다
//	}

	/**
	 * 특정 사용자의 고객 정보를 리턴하는 메소드
	 * 
	 * @param : (int) 고객의 고유번호
	 * @return : (UserDto) userSeq에 대응하는 계좌 객체 (없을 시 null)
	 **/

	@Override
	public UserDto getUserDetail(int userSeq) {

		for (UserDto userDto : userList) {
			if (userDto.getUserSeq() == userSeq)
				return userDto;
		}
		return null;
	}

	/**
	 * 계좌 리스트를 통째로 리턴
	 * 
	 * @return (UserDto) 계좌 리스트
	 */
	public ArrayList<AccountDto> getAccountList() {
		return (ArrayList<AccountDto>) this.accountList;
	}

	/**
	 * 잔고 순으로 정렬된 계좌 리스트를 통째로 리턴
	 * 
	 * @return (UserDto) 계좌 리스트
	 */
	public ArrayList<AccountDto> getAccountListSortByBalance() {
		return (ArrayList<AccountDto>) this.accountList;
	}

	/**
	 * userSeq 순으로 정렬된 계좌 리스트를 통째로 리턴
	 * 
	 * @return (UserDto) 계좌 리스트
	 */
	public ArrayList<AccountDto> getAccountListSortByUserSeq() {
		return (ArrayList<AccountDto>) this.accountList;
	}

	@Override
	public ArrayList<AccountDto> getAccountList(int userSeq) {
		ArrayList<AccountDto> returnList = new ArrayList<AccountDto>();
		for (AccountDto account : accountList) {
			if (account.getUserSeq() == userSeq) {
				returnList.add(account);
			}
		}
		return returnList;
	}

	@Override
	public int withdraw(int userSeq, int accountSeq, int withdrawAmount) throws UserAccountNotFoundException, BalanceLackException{	
				
		AccountDto account = getUserAccount(userSeq,accountSeq);
		if(account.getBalance()>withdrawAmount) {
			account.setBalance(account.getBalance()-withdrawAmount);
			return account.getBalance();
		}else throw new BalanceLackException("잔고가 부족합니다.");
		
	}

	
	@Override
	public AccountDto getUserAccount(int userSeq, int accountSeq) throws UserAccountNotFoundException {
		for(AccountDto account : accountList) {
			if(account.getUserSeq()==userSeq && account.getAccountSeq()==accountSeq)
				return account;
		}
		throw new UserAccountNotFoundException("사용자 또는 계좌를 찾을 수 없습니다");
	}

	
}