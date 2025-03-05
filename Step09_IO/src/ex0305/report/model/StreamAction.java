package ex0305.report.model;


/**
 * 파일입출력을 위한 기능을 정의한 인터페이스. 일종의 DAO역할
 * @author 박재현
 * 2025-03-05
 */
public interface StreamAction {
	
	/**
	 * 파일을 불러와 DTO객체에 담아 리턴
	 * @return (Profile) 파일에서 읽어온 정보를 담은 DTO객체
	 */
	
	Profile getFromInputStream ();
	
	/**
	 * DTO객체를 받아 파일에 저장
	 * @param profile(Profile) 파일에 저장할 프로필 정보를 담은 DTO객체
	 */
	void setOutputStream(Profile profile);

	
	
}
