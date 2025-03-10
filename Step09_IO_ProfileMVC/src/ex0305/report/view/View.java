package ex0305.report.view;
import java.util.ArrayList;

import ex0305.report.model.Profile;

/**
 * View 메소드
 * @author 박재현
 * 2025-03-06
 */

public class View implements ViewAction{

	@Override
	public void mainPrint() {
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println(" 1. 프로필 저장 | 2. 이름 검색 | 3. 체중 변경 | 4. 프로필 삭제 | 5. 체중으로 검색 | 6. 비밀번호 변경| 9. 종료 ");
		System.out.println("--------------------------------------------------------------------------------------------");
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

	public void profilePrint(ArrayList<Profile> profileList) {	
		for(Profile profile : profileList)
			System.out.println(profile); 		
	}

	
	@Override
	public void exitPrint() {
		System.out.println("종료합니다.");
		
	}
	
	
	@Override
	public void exceptionMessagePrint(String message) {
		System.out.println(message);
		
	}

	@Override
	public void wrongInputPrint() {
		System.out.println("잘못된 입력입니다.");
		
	}

	@Override
	public void writeSuccessPrint() {
		System.out.println("프로필 저장에 성공했습니다.");
	}

	@Override
	public void wrongPasswordPrint() {
		System.out.println("잘못된 패스워드를 입력하셨습니다.");
		
	}

	@Override
	public void checkPasswordPrint() {
		System.out.println("비밀번호를 확인합니다.");
		
	}

	@Override
	public void changeWeightPrint() {
		System.out.println("몸무게를 변경합니다.");		
	}

	@Override
	public void writeSuccessPrint(Profile profile) {
		System.out.println(profile.getName()+"님의 프로필 저장에 성공했습니다.");
	}

	@Override
	public void deleteSuccessPrint(String name) {
		System.out.println(name+"님의 프로필을 삭제했습니다.");
		
	}

	@Override
	public void updatePasswordPrint() {
		System.out.println("비밀번호를 변경합니다.");		
	}

	@Override
	public void updateSuccessPrint(Profile profile) {
		 System.out.println(profile.getName()+"님의 비밀번호 변경에 성공했습니다.");		
	}
	
	
	
	
	

}
