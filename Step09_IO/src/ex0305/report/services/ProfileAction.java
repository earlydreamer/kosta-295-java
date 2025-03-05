package ex0305.report.services;

import ex0305.report.model.Profile;

/**
 * 프로필 DTO 관리와 관련된 Service의 기능을 정의한 인터페이스
 */
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
