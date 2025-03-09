package com.ws03.dto;

public class SavingAccountDto extends AccountDto {

	/*
	 * ---------- Member ------------------------
	 */

	
	private int transferFee;
	
	/*
	 * ---------- Constructor ------------------------
	 */
	
	SavingAccountDto(){
		super();
		
	}


	
	
	/*
	 * ---------- Getter-Setter ------------------------
	 */

	public SavingAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, int transferFee) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.transferFee=transferFee;
	}

	public int getTransferFee() {
		return transferFee;
	}


	public void setTransferFee(int transferFee) {
		this.transferFee = transferFee;
	}
	
	/*
	 * ---------- Override Methods ------------------------
	 */

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
		builder.append("고객번호 =");
		builder.append(super.getUserSeq());
		builder.append(", ");
		builder.append("이체수수료 =");
		builder.append(this.transferFee);
		builder.append("]");
		return builder.toString();

	}
	
}
