package com.ws03.dto;

import java.util.Comparator;

/**
 *  고객의 계좌정보 관리하는 객체<br>
 *  2025-02-22<br>
 *	작성자 박재현<br>
 * */
public class AccountDto implements Comparable<AccountDto>, Comparator<AccountDto> {

	/*
	 * ---------- Member ------------------------
	 */

	private int accountSeq;
	private String accountNumber;
	private int balance;
	private int userSeq;

	/*
	 * ---------- Constructor ------------------------
	 */

	
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

	/*
	 * ---------- Getter-Setter ------------------------
	 */

	
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

	/*
	 * ---------- Override Methods ------------------------
	 */

	@Override
	public int compareTo(AccountDto o) {
		// TODO Auto-generated method stub
		return this.getBalance()-o.getBalance();
	}

	@Override
	public int compare(AccountDto o1, AccountDto o2) {
		// TODO Auto-generated method stub
		return o1.getUserSeq()-o2.getUserSeq();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
//		builder.append("[계좌 개설 순서 = "); //출력 시 유저에게 노출되면 안되는 정보는 가린다
//		builder.append(accountSeq);
//		builder.append(", ");
		builder.append("계좌번호 = ");
		builder.append(accountNumber);
		builder.append(", ");
		builder.append("잔고 = ");
		builder.append(balance);
		builder.append(", ");
		builder.append("고객번호 =");
		builder.append(userSeq);
		builder.append("]");
		return builder.toString();
	}
	
   
  

  
}
