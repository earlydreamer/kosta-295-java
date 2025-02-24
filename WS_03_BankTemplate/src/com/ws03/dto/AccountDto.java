package com.ws03.dto;

/**
 *  고객의 계좌정보 관리하는 객체<br>
 *  2025-02-22<br>
 *	작성자 박재현<br>
 * */
public class AccountDto {

	private int accountSeq;
	private String accountNumber;
	private int balance;
	private int userSeq;
	
	
	AccountDto(){
		
	}
	
	/**
	 * 모든 초기화를 파라미터를 받아 수행하는 생성자
	 * @param accountSeq (int) Key로 사용할 계좌의 고유번호(Unique) 
	 * @param accountNumber (String) 계좌번호
	 * @param balance (int) 잔액
	 * @param userSeq (int) 계좌를 소유한 고객 고유번호 (Foreign)
	 */
	
	public AccountDto(int accountSeq, String accountNumber, int balance, int userSeq){
		this.accountSeq = accountSeq;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.userSeq = userSeq;
		
	}

	public void setAccountSeq(int accountSeq) {
		this.accountSeq = accountSeq;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
		
	}
	public void setuserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	
	public int getAccountSeq() {
		return this.accountSeq;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public int getUserSeq() {
		return this.userSeq;
	}
	
   
  

  
}
