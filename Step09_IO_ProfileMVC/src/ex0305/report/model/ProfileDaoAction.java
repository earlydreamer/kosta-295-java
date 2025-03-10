package ex0305.report.model;

import java.util.ArrayList;
import ex0305.report.exception.FileIoFailException;
import ex0305.report.exception.ProfileNotFoundException;

/**
 * 파일입출력을 위한 기능을 정의한 인터페이스. 일종의 DAO역할
 * CRUD 기능까지 수행하도록 인터페이스에 정의
 * @author 박재현
 * 2025-03-05
 * 최종수정 2025-03-11
 */
public interface ProfileDaoAction {
	
	/**
	 * Key값(이름)이 일치하는 프로필을 찾아 전달받은 프로필로 대체
	 * @param profile
	 * @return 
	 * @throws ProfileNotFoundException
	 * @throws FileIoFailException 
	 */
	Profile updateProfile(Profile profile) throws ProfileNotFoundException, FileIoFailException;
	
	/**
	 * 이름으로 프로필을 검색
	 * @throws ProfileNotFoundException 
	 */
	Profile searchProfileByName(String name) throws ProfileNotFoundException;
	
	/**
	 * 체중으로 프로필을 검색
	 * @param weight
	 * @return (ArrayList) 체중이 일치하는 프로필을 리턴
	 * @throws ProfileNotFoundException 
	 */
	ArrayList<Profile> searchProfileByWeight(double weight) throws ProfileNotFoundException;
	
	
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
	
	/**
	 * 입력받은 프로필 정보와 일치하는 프로필을 삭제
	 * @param Profile
	 * @return
	 * @throws FileIoFailException 
	 * @throws ProfileNotFoundException 
	 */
	String DeleteProfile(Profile Profile) throws FileIoFailException, ProfileNotFoundException;
	
	
}
