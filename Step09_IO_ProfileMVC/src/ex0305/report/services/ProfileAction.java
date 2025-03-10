package ex0305.report.services;

import java.util.ArrayList;

import ex0305.report.exception.FileIoFailException;
import ex0305.report.exception.ProfileNotFoundException;
import ex0305.report.exception.WrongPasswordException;
import ex0305.report.model.Profile;

/**
 * 프로필 DTO 관리와 관련된 Service의 기능을 정의한 인터페이스
 * 비즈니스로직에 맞게 DTO객체를 가공해서 다시 Controller로 던지는 역할을 한다.
 */

//TODO : DTO의 각 항목에 대한 검색, 수정, 삭제 기능에 대한 비즈니스 로직 추가
//TODO : CRUD를 만족하는 형태가 되도록 메소드명 수정 
public interface ProfileAction {

	/**
	 * Profile DTO를 생성해서 리턴
	 * @param name
	 * @param weight
	 * @param password
	 * @return (Profile) 생성된 프로필 DTO
	 * @throws FileIoFailException 
	 */
	
	Profile createProfile(String name, double weight, String password) throws FileIoFailException;
	
	/**
	 * 해당 몸무게를 가진 Profile을 모두 검색
	 * @param weight
	 * @return
	 */

	
	ArrayList<Profile> searchProfileByWeight(double weight);
	
	/**
	 * 특정 프로필의 내용을 전달받은 객체대로 변경하는 메소드
	 * @param profile
	 * @return
	 */
	Profile updeateProfile(Profile profile);
	
	/**
	 * 이름과 비밀번호를 입력받아 유효성 검사
	 * @param name
	 * @param password
	 * @return 
	 * @throws FileIoFailException 
	 * @throws ProfileNotFoundException 
	 * @throws WrongPasswordException 
	 */
	
	Profile checkPassword(String name, String password) throws FileIoFailException, ProfileNotFoundException, WrongPasswordException;
	
	/**
	 * 전체 프로필을 DAO에 요청 
	 * @return
	 * @throws FileIoFailException 
	 */
	ArrayList<Profile> selectAllProfile() throws FileIoFailException;
	
	/**
	 * 프로필 삭제 비즈니스 로직
	 * @param name
	 * @param password
	 * @return 
	 * @throws WrongPasswordException 
	 * @throws ProfileNotFoundException 
	 * @throws FileIoFailException 
	 */
	String deleteProfile(String name, String password) throws FileIoFailException, ProfileNotFoundException, WrongPasswordException;
	
	
}
