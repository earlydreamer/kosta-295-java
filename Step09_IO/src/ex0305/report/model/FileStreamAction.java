package ex0305.report.model;

import java.io.IOException;
import java.util.ArrayList;

import ex0305.report.exception.FileIoFailException;

public interface FileStreamAction {

	/**
	 * 파일을 불러와 DTO객체에 담아 리턴
	 * @param filename (String) 파일명
	 * @return (Profile) 파일에서 읽어온 정보를 담은 DTO객체
	 */	
	Profile getFromInputStream(String filename) throws IOException;
	
	/**
	 * DTO객체를 받아 파일에 저장. 파일명은 dto객체의 name 필드에 있다.
	 * @param profile(Profile) 파일에 저장할 프로필 정보를 담은 DTO객체
	 */
	void setOutputStream(Profile profile) throws IOException;

	/**
	 * 직렬화된 파일을 읽어와 리스트 형태로 리턴
	 * @param path
	 * @return (ArrayList) 프로필 리스트
	 * @throws FileIoFailException 
	 */
	ArrayList<Profile> getFromSerializedFile(String path, String filename) throws FileIoFailException;

	/**
	 * 객체를 받아 직렬화된 상태로 파일에 저장
	 * @param profileList (ArrayList) 저장할 프로필 리스트
	 * @throws FileIoFailException 
	 */

	void saveSerializedFile(ArrayList<Profile> profileList) throws FileIoFailException;

	/**
	 * 프로필 객체를 입력받은 내용으로 수정
	 */
}
