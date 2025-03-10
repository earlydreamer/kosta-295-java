package ex0305.report.services;

import java.util.ArrayList;

import ex0305.report.exception.DuplicatedNameException;
import ex0305.report.exception.FileIoFailException;
import ex0305.report.exception.LockedAccountException;
import ex0305.report.exception.ProfileNotFoundException;
import ex0305.report.exception.WrongPasswordException;
import ex0305.report.model.Profile;

/**
 * 프로필 DTO 관리와 관련된 Service의 기능을 정의한 인터페이스
 * 비즈니스로직에 맞게 DTO객체를 가공해서 다시 Controller로 던지는 역할을 한다.
 * @author 박재현
 * 최종수정 2025-03-11
 */
public interface ProfileAction {

	/**
	 * Profile DTO를 생성해서 리턴
	 * @param name
	 * @param weight
	 * @param password
	 * @return (Profile) 생성된 프로필 DTO
	 * @throws FileIoFailException 
	 * @throws DuplicatedNameException 
	 */
	
	Profile createProfile(String name, double weight, String password) throws FileIoFailException, DuplicatedNameException;
	
	/**
	 * 해당 몸무게를 가진 Profile을 모두 검색
	 * DAO를 통해 검색되는 프로필을 리턴
	 * @param weight
	 * @return
	 * @throws ProfileNotFoundException 
	 */
	
	
	ArrayList<Profile> searchProfileByWeight(double weight) throws ProfileNotFoundException;

	
	/**
	 * 해당 이름을 가진 프로필을 검색 <Br>
	 * DAO를 통해 검색되는 프로필을 리턴
	 * @param name
	 * @return
	 * @throws ProfileNotFoundException 
	 * @throws LockedAccountException 
	 */
	Profile searchProfileByName(String name) throws ProfileNotFoundException, LockedAccountException;

	
	/**
	 * 특정 프로필의 내용을 전달받은 객체대로 변경하는 메소드
	 * @param profile
	 * @return
	 * @throws ProfileNotFoundException 
	 * @throws FileIoFailException 
	 */
	Profile updateProfile(Profile profile) throws ProfileNotFoundException, FileIoFailException;
	
	/**
	 * 이름과 비밀번호를 입력받아 유효성 검사
	 * @param name
	 * @param password
	 * @return 
	 * @throws FileIoFailException 
	 * @throws ProfileNotFoundException 
	 * @throws WrongPasswordException 
	 * @throws LockedAccountException 
	 */
	
	Profile checkPassword(String name, String password) throws FileIoFailException, ProfileNotFoundException, WrongPasswordException, LockedAccountException;
	
	/**
	 * 전체 프로필을 DAO에 요청 
	 * @return
	 * @throws FileIoFailException 
	 */
	ArrayList<Profile> selectAllProfile() throws FileIoFailException;
	
	/**
	 * 프로필 삭제 비즈니스 로직
	 * @param profile
	 * @return 
	 * @throws WrongPasswordException 
	 * @throws ProfileNotFoundException 
	 * @throws FileIoFailException 
	 */

	String deleteProfile(Profile profile) throws FileIoFailException, ProfileNotFoundException, WrongPasswordException;
	
	
	
}
