package ex0305.report.view;
import ex0305.report.model.Profile;

/**
 * View 메소드
 * @author 박재현
 * 2025-03-06
 */
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
	
	
	

}
