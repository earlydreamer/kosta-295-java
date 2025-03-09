package com.ws03.dto;

/**
 *	고객의 정보를 관리할 객체 <br>
 *	2025-02-22<br>
 *	작성자 박재현<br>
 *	
 * */
public class UserDto {

	/*
	 * ---------- Members ------------------------
	 */

	
	private int userSeq;
	private String name;
	private String email;
	private String phone;
	private boolean isSleep;
	

	/*
	 * ---------- Constructor ------------------------
	 */

	
	/**
	 * Default 생성자
	 */
	UserDto(){
		
	}
	
	
	/**
	 * 모든 초기화를 파라미터를 받아 수행하는 생성자
	 * @param userSeq (int) Key로 사용할 사용자 고유번호(Unique)
	 * @param name (String) 사용자 이름
	 * @param email (String) 사용자 email
	 * @param phone (String) 사용자 휴대폰 번호
	 * @param isSleep (boolean) 휴면계좌 여부
	 */	
	public UserDto(int userSeq, String name, String email, String phone, boolean isSleep){
		this.userSeq = userSeq;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.isSleep = isSleep;
	}
	
	/*
	 * ---------- Getter-Setter ------------------------
	 */	
	
	public int getUserSeq() {
		return this.userSeq;
	}
	public String getName() {
		return this.name;
	}
	public String getEmail() {
		return this.email;
	}
	public String getPhone() { 
		return this.phone;
	}
	public boolean isSleep() {
		return this.isSleep;
	}
	
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	
	public void setName(String name) {
		this.name = name;
	}
   
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setIsSleep(boolean isSleep) {
		this.isSleep = true;
	}



	/*
	 * ---------- Override Methods ------------------------
	 */

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[고객번호 = ");
		builder.append(userSeq);
		builder.append(", 이름 = ");
		builder.append(name);
		builder.append(", email = ");
		builder.append(email);
		builder.append(", 전화번호 = ");
		builder.append(phone);
		builder.append(", 휴면여부 = ");
		builder.append(isSleep);
		builder.append("]");
		return builder.toString();
	}


	
	
	
}

