package mvc.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ResourceBundle;

import mvc.dto.Electronics;
import mvc.exception.DuplicatedIdFoundException;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.FileIoFailException;
import mvc.exception.SearchNotFoundException;

/**
 * 파일 입출력 기능을 구현하는 구현체 클래스. 파일이 일종의 DB역할을, 파일 입출력 클래스가 일종의 DAO 역할을 수행한다. CRUD 관련
 * 기능을 이쪽에서 1차적으로 수행하고 리턴한다.
 */

public class StreamImpl implements FileStreamDao {
	// 구현체에 Impl을 붙이는 컨벤션이니까 네이밍 규칙 맞춰서 통일...

	private static StreamImpl instance; //Singleton 패턴으로 수정
	
	
	private static String FILE_NAME; 
	private static String PATH;
	// DB 역할이 되므로 DAO와 붙어있게 경로를 구성했다. 실제로 데이터가 최종적으로 저장되는 공간은 파일이다.
	// CRUD 로직을 DAO로 옮기고 비즈니스 로직에서는 DAO로 요청을 보내는 방식으로 리팩토링
	// 실제 DB로 옮길 때 DAO 부분만 새로 짜면 되도록 재사용성을 개선

	private static final int LIST_MAX_SIZE = 10;
	// 리스트의 MAX_SIZE는 DB의 물리적 사이즈에 해당하는 정보라고 판단되어 이쪽으로 옮김
	// 비즈니스 로직에서 유연하게 변경 가능해야 하는 의도로 작성된 설계라면 틀린 판단이지만...

	private ArrayList<Electronics> electronicsList;
	// 객체에 대한 정보를 받아서 넘겨주는 것은 DAO의 역할이므로 관리를 위한 리스트를 DAO가 들고 있다.
	// 각 기능 내부에서 선언하는 것보다 외부에 공용으로 선언하는 것이 재사용성이 높다

	/*
	 * -------------------------Constructor ----------------------------
	 */
	private StreamImpl() { //디폴트 생성자를 이용한 경로 세팅
		FILE_NAME = "electronics.txt"; 
		PATH = "src/mvc/dao/" + FILE_NAME;
		init();
	}

	private StreamImpl(String filename, String path) {
		//경로 텍스트를 의존성 주입을 통해 세팅하는 생성자
		FILE_NAME = filename;
		PATH = path + filename;
		init();
	}
	
	
	public static StreamImpl getInstance() {
		if(instance==null)
				instance = new StreamImpl();			
		return instance;
		
	}
	
	/*
	 * --------------------- Override Method----------------------------
	 */

	@Override
	public void saveAllElectronics(ArrayList<Electronics> electronicsList) throws FileIoFailException {
		// TODO Auto-generated method stub
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(PATH)))) {
			oos.writeObject(electronicsList);
		} catch (IOException e) {
			throw new FileIoFailException("파일 처리 과정에서 오류가 발생했습니다.");
		}

	}

	@Override
	public ArrayList<Electronics> loadAllElectronics() throws FileIoFailException {
		// TODO Auto-generated method stub
		ArrayList<Electronics> electronicsList = null;
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(PATH)))) {
			electronicsList = (ArrayList<Electronics>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new FileIoFailException("파일 처리 과정에서 오류가 발생했습니다.");

		}
		return electronicsList;
	}

	@Override
	public void init() {

		File file = new File(PATH);
		try {
			if (file.exists()) {
				System.out.println("초기화 중... 파일로부터 데이터를 읽어옵니다.");
				electronicsList = loadAllElectronics();
			} else {
				System.out.println("초기화 중... 파일이 없습니다. 번들로부터 기본값을 생성합니다.");
				loadFromResourceBundle("InitInfo");
			}
		} catch (FileIoFailException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void loadFromResourceBundle(String bundlePath) throws FileIoFailException {
		ResourceBundle rb = ResourceBundle.getBundle(bundlePath);// dbInfo.properties
		electronicsList = new ArrayList<Electronics>();
		for (String key : rb.keySet()) {
			String value = rb.getString(key);
			String data[] = value.split(",");
			// System.out.println(key +" = " + value);
			electronicsList.add(
					new Electronics(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), data[3]));
		}
		saveAllElectronics(electronicsList);
	}
	
	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
		for (Electronics e : electronicsList) {
			if (e.getModelNo() == modelNo) {
				return e; // 찾으면 찾은 객체를 그대로 리턴하고 루프 탈출
			}
		}
		throw new SearchNotFoundException(modelNo + "는 없는 모델번호로 검색할수 없습니다.");// 루프를 다 돌고 나왔는데 못 찾으면 예외 throw
	}

	@Override
	public void updateElectronics(Electronics electronics) throws SearchNotFoundException, FileIoFailException {
		int index = 0;
 		for (Electronics e : electronicsList) {
			if (e.getModelNo() == electronics.getModelNo()) {
				electronicsList.set(index, electronics);
				saveAllElectronics(electronicsList);
				return;
			}
			index++;
		}
		throw new SearchNotFoundException(electronics.getModelNo() + "는 없는 모델번호로 검색할수 없습니다.");
		// 루프를 다 돌고 나왔는데 못 찾으면 예외 throw
	}

	@Override
	public void insertElectronics(Electronics electronics)
			throws ElectronicsArrayBoundsException, DuplicatedIdFoundException, FileIoFailException {
		if (electronicsList.size() > LIST_MAX_SIZE)
			throw new ElectronicsArrayBoundsException("배열의 길이를 벗어나 더이상 등록 할수 없습니다.");
		else
			try {
				searchByModelNo(electronics.getModelNo());
				throw new DuplicatedIdFoundException("중복 ID가 발견되었습니다.");
				// 중복 발견 시 사용자 정의 Exception을 태워 반환
			} catch (SearchNotFoundException e) {
				// 중복 체크를 해서 id가 같은 값이 없을 경우 exception을 타고 데이터 추가
				electronicsList.add(electronics);
				saveAllElectronics(electronicsList);
				System.out.println(electronicsList);
			}
	}

	@Override
	public void deleteElectronics(int modelNo) throws SearchNotFoundException, FileIoFailException {
		// 모델번호가 일치하는 객체를 찾아서 삭제
		electronicsList.remove(searchByModelNo(modelNo));
		saveAllElectronics(electronicsList);
	}

}
