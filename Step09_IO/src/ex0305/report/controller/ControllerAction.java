package ex0305.report.controller;

import java.io.IOException;

import ex0305.report.exception.FileIoFailException;
import ex0305.report.model.Profile;

/**
 * 컨트롤러가 가지는 기능 인터페이스
 * @author 박재현
 * 2025-03-06
 */
public interface ControllerAction {

	/**
	 * 메인 루프 로직
	 */
	void menuLogic();
	/**
	 * 메뉴 View를 표시하고 메뉴 선택 Input을 받아 리턴하는 메소드
	 * @return (int) 입력값
	 */
	int inputMenu();
	
	/**
	 * 프로필 입력 메소드 3개를 호출한 뒤 해당 값으로 새 프로필을 생성하는 메소드
	 * @return (Profile) 생성된 프로필을 반환
	 * @throws FileIoFailException 
	 */
	Profile newProfile() throws FileIoFailException;
	
	/**
	 * 이름을 입력받아 리턴하는 메소드
	 * @return (String) 입력값
	 */
	String inputName();
	/**
	 * 체중을 입력받아 리턴하는 메소드
	 * @return (double) 입력값
	 */
	double inputWeight();
	/**
	 * 패스워드를 입력받아 리턴하는 메소드
	 * @return (String) 입력값
	 */
	String inputPassword();
	/**
	 * 프로필을 파일로부터 읽어와 프로필 DTO객체로 반환하는 메소드
	 * @return (Profile) 파일에서 읽어온 프로필
	 * @throws IOException
	 */
	Profile loadProfile() throws IOException;
	/**
	 * 종료 View를 호출하고 false를 반환하는 메소드
	 * @return false
	 */
	boolean exit();
	/**
	 * 잘못된 입력이 들어왔을 경우의 View를 표시하는 메소드
	 */
	void wrongInput();
	
	/**
	 * 입력한 사람의 몸무게를 검색해 리턴하는 메소드
	 * @return
	 */
	Profile searchWeight();
	
	/**
	 * 몸무게를 수정하는 메소드
	 * @return (double) 수정된 몸무게
	 */
	double updateWeight();
	
	
	/**
	 * 프로필을 수정하는 메소드
	 * @return (Profile) 프로필 DTO
	 */
	Profile updateProfile();
	
	
}
