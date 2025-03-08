package mvc.dao;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import mvc.dto.Electronics;
import mvc.exception.DuplicatedIdFoundException;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;
import mvc.exception.FileIoFailException;

/**
 * DTO를 받아 Serialize해서 파일에 기록하고 다시 파일로부터 읽어서 CRUD를 수행하는 역할을 수행
 */

public interface FileStreamDao {

	/**
	 * 파일명과 DTO객체 배열을 받아서 파일에 통째로 기록
	 * 
	 * @param filename    (String) 파일명
	 * @param electronics (ArrayList) Electronics DTO객체 리스트
	 */
	void saveAllElectronics(ArrayList<Electronics> electronics) throws FileIoFailException;

	/**
	 * 파일로부터 읽어와서 전체 DTO객체가 담긴 리스트를 리턴 / SELECT ALL과 사실상 같은 기능 수행
	 * 
	 * @param filename (String) 파일명
	 * @return (ArrayList) Electronics DTO객체 리스트
	 * @throws ClassNotFoundException
	 */
	ArrayList<Electronics> loadAllElectronics() throws FileIoFailException;

	/**
	 * 리소스 번들로부터 읽어와 초기화하는 기능
	 * 
	 * @param bundlePath (String) 번들 경로
	 * @throws FileIoFailException
	 */
	void loadFromResourceBundle(String bundlePath) throws FileIoFailException;

	/**
	 * 모델번호에 해당하는 정보가 있는지 찾고, 전달받은 객체(수정사항이 적용된 객체)를 적용한다. 적용할 객체를 생성하는 부분은 비즈니스
	 * 로직에서 수행한다.
	 * 
	 * @param electronics (Electronics) 적용할 객체
	 * @throws SearchNotFoundException
	 * @throws FileIoFailException
	 */
	public void updateElectronics(Electronics electronics) throws SearchNotFoundException, FileIoFailException;

	/**
	 * 모델번호에 해당하는 전자제품 검색. 만약 찾는 정보가 없으면 SearchNotFoundException 예외 발생.
	 * 
	 * @param modelNo
	 * @return (Electronics) 검색된 결과
	 * @throws SearchNotFoundException
	 */
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException;

	/**
	 * 전자제품을 등록한다. 모델Id의 중복을 확인 시, 예외를 날린다.
	 * 
	 * @param electronics
	 * @throws DuplicatedIdFoundException
	 * @throws FileIoFailException
	 * 
	 */
	public void insertElectronics(Electronics electronics)
			throws ElectronicsArrayBoundsException, DuplicatedIdFoundException, FileIoFailException;

	/**
	 * 지정된 Electronics 객체를 찾아서 삭제
	 * 
	 * @param electronics
	 * @throws SearchNotFoundException
	 * @throws FileIoFailException
	 */
	public void deleteElectronics(int modelNo) throws SearchNotFoundException, FileIoFailException;

	/**
	 * 경로를 체크해 파일이 있으면 지정된 파일로부터 초기값을 읽고, 없으면 ResourceBundle로부터 값을 읽어 초기값을 세팅하고 파일을
	 * 생성한다
	 * 
	 * @throws FileIoFailException
	 */
	void init() throws FileIoFailException;

}
