package com.ws03.dto;

public class LoanAccountDto extends AccountDto {

	/*
	 * ---------- Member ------------------------
	 */

	private String mortgage;

	/*
	 * ---------- Constructor ------------------------
	 */

	public LoanAccountDto() {
		super();
	}

	
	public LoanAccountDto(int accountSeq, String accountNumber, int balance, int userSeq,String mortgage) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.mortgage=mortgage;
	}

	/*
	 * ---------- Getter-Setter ------------------------
	 */


	public String getMortgage() {
		return mortgage;
	}

	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
//		builder.append("[계좌 개설 순서 = "); //출력 시 유저에게 노출되면 안되는 정보는 가린다
//		builder.append(accountSeq);
//		builder.append(", ");
		builder.append("계좌번호 = ");
		builder.append(super.getAccountNumber());
		builder.append(", ");
		builder.append("잔고 = ");
		builder.append(super.getBalance());
		builder.append(", ");
		builder.append("고객번호 = ");
		builder.append(super.getUserSeq());
		builder.append("담보 = ");
		builder.append(this.mortgage);
		builder.append("]");
		return builder.toString();

	}

}
