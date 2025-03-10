package ex0305.report.model;

import java.io.Serializable;

/**
 * 프로필 DTO
 * @author 박재현
 * 2025-03-06
 * 최종수정 2025-03-11
 */

public class Profile implements Serializable{

	private String name;  //동명이인이 있을 수 있으므로 조회를 위한 Key로 사용하기 부적합하다...
	private String phone; //연락처가 없을 수도 있다...  역시 key로 사용하기 부적합하다... Phone을 만들어뒀는데 결국 안 썼다

	
	//동명이인 처리를 어떻게 할지 고민이 되는데, 예시 스크린샷대로 구성하면 무슨 짓을 해도 동명이인 처리가 깔끕하게 안 된다
	//name과 phone을 묶어서 검사하면 좀 나아지지만 근본적 해결방법이 되진 않는다. 폰이 없는 사람이 있을 수 있고, 010-000-0000처럼 대충 적어서 넣는 사람이 있을 수도 있다. 
	//동명이인인 사람이 둘다 폰 번호를 적기 싫다고 번호에 010-000-0000을 적어냈다면? 이 사람이 만약 핸드폰 번호를 바꾼다면? 묶는 것도 답이 될 수가 없다...
	//비밀번호도 마찬가지다... 이름 같은 사람 두명이 동시에 귀찮다고 비밀번호를 1111로 넣었으면 두사람의 비밀번호가 같아져버리니까 이름-비밀번호 쌍도 답이 될 수 없다...
	//멍청한 방법이긴 하지만 동명이인 발생 시 가입순서대로 이름에 숫자를 붙여버리면 중복문제가 해결되긴 한다... 세련된 방식은 아니다. 시간 없으니 일단 가장 멍청한 방식으로 구현하자
	
	private double weight;
	private String password;
	
	private boolean isAccountLock; //비밀번호를 틀리면 계정이 잠겨야 한다...
	private int wrongPasswordCount; //비밀번호를 틀린 횟수는 계정에 기록된다
	
	
	/*
	 * --------------------------------Getter-Setter ----------------------------------
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone=phone;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAccountLock() {
		return isAccountLock;
	}

	public void setAccountLock(boolean isAccountLock) {
		this.isAccountLock = isAccountLock;
	}

	public int getWrongPasswordCount() {
		return wrongPasswordCount;
	}
	public void setWrongPasswordCount(int wrongPasswordCount) {
		this.wrongPasswordCount = wrongPasswordCount;
	}

	
	/*
	 * -------------------------------- Override toString ----------------------------------
	 */
	
	
	@Override
	public String toString() {// 몸무게 이외의 데이터는 toString을 통해 출력되지 않는다.
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append("님의 몸무게는 ");
		builder.append(Math.round(weight*10)/10.0); //소수점 1자리까지 표시한다.
		builder.append("kg입니다.");
		return builder.toString();
	}
	
	/*
	 * --------------------------------Constructor ----------------------------------
	 */
	
	public Profile(){
		super();
		this.isAccountLock = false;
		this.wrongPasswordCount=0;
	}
	
	public Profile(String name, double weight, String password) {
		this();
		this.name = name;
		this.weight = weight;
		this.password = password;
	}
	
	
}
