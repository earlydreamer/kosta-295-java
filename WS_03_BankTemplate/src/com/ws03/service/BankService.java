package com.ws03.service;
import com.ws03.dto.AccountDto;
import com.ws03.dto.UserDto;

/**
 * 고객과 계좌에 관련된 서비스 <br>
 * (Business Logic 을 처리하는 객체)<br>
 * 
 * 2025-02-22 <br>
 * 작성자 박재현 <br>
 * 
 * */

public class BankService {
	
	/**개설 가능한 계좌 수*/
	final int ACCOUNT_SIZE = 10;
	/**최대 고객 수 */
	final int USER_SIZE = 5;
	
	/** 현재 개설된 계좌의 개수 */
	int ACCOUNT_CURRENT_SIZE; 
	/**현재 고객 수 */
	int USER_CURRENT_SIZE; 
	
	
	
	AccountDto [] accountList;
	UserDto [] userList;
	

	
	
	/**
	 * 테스트용 초기화 로직
	 */
	private void testInit() {
		//생성할 수 있는 최대 사이즈에 맞춰 배열 생성
		 userList = new UserDto[USER_SIZE]; //5
		 accountList = new AccountDto [ACCOUNT_SIZE]; //10
		
		// 각 배열방에 고객과 계좌를 생성한다.
		 //고객 4명
		 userList[USER_CURRENT_SIZE++] = new UserDto(100, "장희정", "8253jang@daum.net", "010-8875-8253", false);
		 userList[USER_CURRENT_SIZE++] = new UserDto(200, "이효리", "lee@daum.net", "010-2222-3333", false);
		 userList[USER_CURRENT_SIZE++] = new UserDto(300, "송중기", "song@naver.com", "010-5554-2222", false);
		 userList[USER_CURRENT_SIZE++] = new UserDto(400, "삼순이", "sam@daum.com", "010-2222-2222", false);
		
		 //계좌는 6개 정도
		 accountList[ACCOUNT_CURRENT_SIZE++] = new AccountDto(1, "1111-11111", 1000000, 100);
		 accountList[ACCOUNT_CURRENT_SIZE++] = new AccountDto(2, "2222-22222", 250000, 100);
		 accountList[ACCOUNT_CURRENT_SIZE++] = new AccountDto(3, "3333-33333", 350000, 100);
		
		 accountList[ACCOUNT_CURRENT_SIZE++] = new AccountDto(4, "4444-44444", 150000, 200);
		 accountList[ACCOUNT_CURRENT_SIZE++] = new AccountDto(5, "5555-55555", 250000, 200);
		
		 accountList[ACCOUNT_CURRENT_SIZE++] = new AccountDto(6, "6666-66666", 350000, 300);
	}
	
	/**
	 * Default 생성자 <br>
	 * 테스트에 용이하도록 테스트용 로직은 메소드로 분리해서 관리 <br>
	 * 외부에서 직접 접근은 불가하도록 private 선언
	 */
	
	public BankService() {
		testInit();
		
	}//생성자 끝
		
	
	/**
     * userSeq에 해당하는 계좌 목록을 가져오는 메소드
     * @param userSeq (int) 계좌를 가져올 사용자의 고유번호 
     * @return (AccountDto[]) 해당 고유번호의 고객이 가진 계좌 배열
     */
	public AccountDto[] getAccountList(int userSeq) {
		int count=0;
		AccountDto[] tempArr = new AccountDto[ACCOUNT_CURRENT_SIZE]; //임시배열 -> 전체 Account 개수를 넘지않음
		for(int i =0;i<ACCOUNT_CURRENT_SIZE;i++) {//전체 계좌 순회
			if(accountList[i].getUserSeq()==userSeq) {//userSeq 값이 같으면
				tempArr[count] = accountList[i];//임시저장용 배열에 추가
				count++; //인덱스컨트롤용 임시변수 증가
			}
		}AccountDto[] returnArray = cutAccountArray(tempArr,count); //인덱스 크기에 맞춰서 배열 cut해 리턴	
		return returnArray;
	}
	
	/**
	 * 리턴용 AccountArray 자르기
	 * @param array (AccoutDto) 잘라낼 배열
	 * @param length (int) 잘라낼 길이
	 * @return (AccountDto) 길이에 맞춰 잘라낸 배열
	 */
	AccountDto[] cutAccountArray(AccountDto[] array, int length ) {
		AccountDto[] dest = new AccountDto[length];
		for(int i=0;i<length;i++) {
			if(array[i]!=null)
				dest[i] = array[i];
			else
				dest[i]=null; //대상 array보다 긴 length가 들어왔을 경우 null로 채운다... (임시예외처리)
		}
		return dest; //길이대로 자른 array를 리턴한다
	}
	
	
	/**
	  * 특정 사용자의 고객 정보를 리턴하는 메소드
	  * @param : (int) 고객의 고유번호 
	  * @return : (UserDto) userSeq에 대응하는 계좌 객체 (없을 시 null)
	**/
	
	public UserDto getUserDetail(int userSeq) {
		
		for(int i=0;i<USER_CURRENT_SIZE;i++) {
			if(userList[i].getUserSeq()==userSeq)
				return userList[i];
		}
		return null;
	}
}