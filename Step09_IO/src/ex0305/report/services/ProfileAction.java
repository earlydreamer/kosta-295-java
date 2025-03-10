package ex0305.report.services;

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
	 */
	
	Profile newProfile(String name, double weight, String password);
	
	
	
}
