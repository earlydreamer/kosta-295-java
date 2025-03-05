package ex0305.report.view;

import ex0305.report.model.Profile;

public class View implements ViewAction{

	@Override
	public void mainPrint() {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("    1. 프로필 저장    |    2. 프로필 불러오기    |    3. 종료    ");
		System.out.println("-----------------------------------------------------------------");
	}

	@Override
	public void inputPrint() {
		System.out.println("메뉴를 선택하세요.");
	}

	@Override
	public void nameInputPrint() {
		System.out.print("이름 >");
		
	}

	@Override
	public void weightInputPrint() {
		System.out.print("몸무게 >");
		
	}

	@Override
	public void passwordInputPrint() {
		System.out.print("비밀번호 >");
		
	}

	@Override
	public void profilePrint(Profile profile) {
		System.out.println(profile); 
		
	}
	
	

}
