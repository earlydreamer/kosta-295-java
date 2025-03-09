package com.ws03.view;
import com.ws03.dto.AccountDto;
import com.ws03.dto.UserDto;
import com.ws03.service.BankService;

/**
 * 2025-02-22 <br>
 * 작성자 박재현 <br>
 * 결과를 출력하는 테스트용 View <br>
 */
public class TestView {

	/**
	 * main 메소드
	 * @param args (String[] ) 실행 시 넘어오는 parmameter (구분자 공백)
	 */
	public static void main(String[] args) {
		System.out.println("***1. 고객seq에 해당하는 계좌정보 검색하기 *****");
		BankService service = new BankService();
		
		
		AccountDto[] accountList = service.getAccountList(100);
		
		if(accountList==null) {
			System.out.println("회원의 계좌정보가 없습니다. ");
		}else {
			System.out.println("회원계좌개수 : " + accountList.length);
			for(AccountDto dto : accountList) {
				System.out.println(dto.getAccountSeq() +" , " + dto.getAccountNumber()+" , " + dto.getUserSeq());
				
			}
		}
		
		System.out.println();
		System.out.println("***2. userSeq에 해당하는 고객의 정보 *************");
		UserDto userDto = service.getUserDetail(300);
		
		if(userDto!= null) {
		  System.out.print(userDto.getUserSeq() +" , " + userDto.getName()+" , " + userDto.getEmail()+" , ");
		  System.out.println(userDto.getPhone() +" , " + userDto.isSleep());
			
		}else {
			System.out.println("회원의 정보가 없습니다.");
		}

	}//메인끝

}// 클래스 끝





