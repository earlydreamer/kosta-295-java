package ex0305.report.model;

import java.io.IOException;
import java.util.ArrayList;

import ex0305.report.exception.FileIoFailException;
import ex0305.report.exception.ProfileNotFoundException;

/**
 * 파일입출력을 위한 기능을 정의한 인터페이스. 일종의 DAO역할
 * CRUD 기능까지 수행하도록 인터페이스에 정의
 * @author 박재현
 * 2025-03-05
 */
public interface ProfileDaoAction {
	
	void updateProfile(Profile profile);
	
	/**
	 * 이름으로 프로필을 검색
	 * @throws ProfileNotFoundException 
	 */
	Profile searchProfileByName(String name) throws ProfileNotFoundException;
	
	/**
	 * 새 프로필 추가
	 * @throws FileIoFailException 
	 */
	void insertProfile(Profile profile) throws FileIoFailException;
	
	/**
	 * 직렬화된 파일로부터 읽어와 모든 프로필 리스트를 리턴<br>
	 * getFromSerializedFile과 사실상 같은 기능이지만 목적이 다르므로 한번 래핑함
	 * 
	 * @return
	 * @throws FileIoFailException 
	 */
	ArrayList<Profile>selectAllProfile() throws FileIoFailException;
	
	
}
