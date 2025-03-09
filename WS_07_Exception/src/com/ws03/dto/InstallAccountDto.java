package com.ws03.dto;

public class InstallAccountDto extends AccountDto {


	/*
	 * ---------- Members ------------------------
	 */

	
	private int period;
	private int amount;


	/*
	 * ---------- Constructor ------------------------
	 */

	InstallAccountDto(){
		
	}

	public InstallAccountDto(int accountSeq, String accountNumber, int balance, int userSeq,int period, int amount) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.period=period;
		this.amount=amount;
	}

	
	/*
	 * ---------- Getter-Setter ------------------------
	 */	



	public int getPeriod() {
		return period;
	}


	public void setPeriod(int period) {
		this.period = period;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}
	


	
	
	/*
	 * ---------- Override Methods ------------------------
	 */
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
//		builder.append("[");
		builder.append("[계좌 개설 순서 = "); 
		builder.append(super.getAccountSeq());
		builder.append(", ");
		builder.append("계좌번호 = ");
		builder.append(super.getAccountNumber());
		builder.append(", ");
		builder.append("잔고 = ");
		builder.append(super.getBalance());
		builder.append(", ");
		builder.append("고객번호 =");
		builder.append(super.getUserSeq());
		builder.append(", ");
		builder.append("기간 =");
		builder.append(period);
		builder.append("개월");
		builder.append(", ");
		builder.append("금액 =");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
	
}
