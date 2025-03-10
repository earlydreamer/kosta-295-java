package ex0305.report.controller;

import java.util.ArrayList;

import ex0305.report.exception.DuplicatedNameException;
import ex0305.report.exception.FileIoFailException;
import ex0305.report.exception.LockedAccountException;
import ex0305.report.exception.ProfileNotFoundException;
import ex0305.report.exception.WrongInputException;
import ex0305.report.exception.WrongPasswordException;
import ex0305.report.model.Profile;

/**
 * 컨트롤러가 가지는 기능 인터페이스
 * @author 박재현
 * 2025-03-06
 * 최종수정 2025-03-11
 */
public interface ControllerAction {

	/**
	 * 메인 루프 로직
	 */
	void menuLogic();
	/**
	 * 메뉴 View를 표시하고 메뉴 선택 Input을 받아 리턴하는 메소드
	 * @return (int) 입력값
	 * @throws WrongInputException 
	 */
	int inputMenu() throws WrongInputException;
	
	/**
	 * 프로필 입력 메소드 3개를 호출한 뒤 해당 값으로 새 프로필을 생성하는 메소드
	 * @return (Profile) 생성된 프로필을 반환
	 * @throws FileIoFailException 
	 * @throws DuplicatedNameException 
	 * @throws WrongInputException 
	 */
	Profile newProfile() throws FileIoFailException, DuplicatedNameException, WrongInputException;
	
	/**
	 * 이름을 입력받아 리턴하는 메소드
	 * @return (String) 입력값
	 * @throws WrongInputException 
	 */
	String inputName() throws WrongInputException;
	/**
	 * 체중을 입력받아 리턴하는 메소드
	 * @return (double) 입력값
	 * @throws WrongInputException 
	 */
	double inputWeight() throws WrongInputException;
	/**
	 * 패스워드를 입력받아 리턴하는 메소드
	 * @return (String) 입력값
	 * @throws WrongInputException 
	 */
	String inputPassword() throws WrongInputException;
	/**
	 * 프로필을 파일로부터 읽어와 프로필 DTO객체로 반환하는 메소드
	 * @return (Profile) 파일에서 읽어온 프로필
	 * @throws ProfileNotFoundException 
	 * @throws FileIoFailException 
	 * @throws WrongPasswordException 
	 * @throws WrongInputException 
	 * @throws LockedAccountException 
	 */
	Profile searchProfileByName() throws ProfileNotFoundException, FileIoFailException, WrongPasswordException, WrongInputException, LockedAccountException;
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
	 * @throws ProfileNotFoundException 
	 */
	ArrayList<Profile> searchByWeight() throws ProfileNotFoundException;
	
	/**
	 * 몸무게를 수정하는 메소드
	 * @return (double) 프로필 객체
	 * @throws ProfileNotFoundException 
	 * @throws WrongPasswordException 
	 * @throws FileIoFailException 
	 * @throws WrongInputException 
	 * @throws LockedAccountException 
	 */
	Profile updateWeight() throws ProfileNotFoundException, FileIoFailException, WrongPasswordException, WrongInputException, LockedAccountException;
	
	/**
	 * 프로필을 수정하는 메소드
	 * @return (Profile) 프로필 DTO
	 * @throws WrongPasswordException 
	 * @throws ProfileNotFoundException 
	 * @throws FileIoFailException 
	 * @throws WrongInputException 
	 * @throws LockedAccountException 
	 */
	Profile updatePassword() throws FileIoFailException, ProfileNotFoundException, WrongPasswordException, WrongInputException, LockedAccountException;

	/**
	 * 전체 프로필을 리턴하는 메소드
	 * @return
	 * @throws FileIoFailException 
	 */
	ArrayList<Profile> selectAllProfile() throws FileIoFailException;
	
	/**
	 * 프로필을 삭제하는 메소드
	 * @return
	 * @throws WrongPasswordException 
	 * @throws ProfileNotFoundException 
	 * @throws FileIoFailException 
	 * @throws WrongInputException 
	 * @throws LockedAccountException 
	 */
	String deleteProfile() throws FileIoFailException, ProfileNotFoundException, WrongPasswordException, WrongInputException, LockedAccountException;
	
	/**
	 * 이름과 비밀번호를 입력받아 일치하면 해당 객체를 리턴하는 메소드   
	 * @return
	 * @throws FileIoFailException
	 * @throws ProfileNotFoundException
	 * @throws WrongPasswordException
	 * @throws WrongInputException
	 * @throws LockedAccountException 
	 */
	Profile checkPassword()	throws FileIoFailException, ProfileNotFoundException, WrongPasswordException, WrongInputException, LockedAccountException;	
	
	/**
	 * 잠김 계정을 잠금 해제하는 메소드
	 * @return
	 * @throws WrongInputException
	 * @throws ProfileNotFoundException
	 * @throws FileIoFailException
	 * @throws LockedAccountException
	 */
	Profile unlockAccount() throws WrongInputException, ProfileNotFoundException, FileIoFailException, LockedAccountException;
	
}
