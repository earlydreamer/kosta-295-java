package ex0305.report.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import ex0305.report.exception.FileIoFailException;

public class FileStreamer implements FileStreamAction {
	// CRUD 역할이 더 크고 FileStream은 그 기능 중 일부	
	// FileStream과 DAO의 클래스를 분리하고 DAO 클래스에서 FileStream을 import해 사용하는 형태로 수정 (단일 책임의 원칙)
	// 기본 경로를 static final로 선언
	private static final String BASE_PATH = "src/ex0305/report/model/";
	private static final String BASE_FILE_NAME = "Profile.txt";
	private static String filePath;
	Profile profile = new Profile();
	
	ArrayList<Profile> profileList;
	
	//TODO : Exception 난잡하게 throw하고 있는 것 전부 정리하기... 내부에서 자르고 println으로 찍어서 소화하거나 한단계 추상화된 상위 Exception을 만들어서 상위 Exception을 던지자

	//순전히 View를 통한 예외 텍스트 출력을 태우기 위해 컨트롤러까지 보내고 있는데 이러면 중간에 거치는 모든 메소드에 주렁주렁 예외가 달린다 이게 가독성을 엄청 해치고 있다.
	//모델은 뷰를 몰라야 하는 게 맞지만 예외 텍스트 띄우겠다고 Exception을 컨트롤러까지 태우면 역으로 의존성이 발생해버린다.
	//나중에 DB로 교체하면 파일 관련 Exception을 사용하지 않게 되는데, DAO를 교체해도 덕지덕지 붙어서 수정이 발생한다. 
	//FileIoFailException을 추상화한 상위 Exception을 만들고 상위 Exception을 던지는 방식으로 수정하면 상위 Exception을 받게 되므로 나중에 DB로 교체할 때 유연해질 것 같다...
	

	//생성자 주입을 통한 초기화
	FileStreamer(){
		filePath = BASE_PATH+BASE_FILE_NAME;
		profileList = new ArrayList<Profile>();
	}

	//생성자 주입을 통한 초기화
	FileStreamer(String filename){
		filePath = BASE_PATH+filename;
		profileList = new ArrayList<Profile>();
	}

	//생성자 주입을 통한 초기화
	FileStreamer(String path, String filename){
		filePath = path+filename;
		profileList = new ArrayList<Profile>();
	}
	
	@Override
	public Profile getFromInputStream(String filename) throws IOException {

		filePath = BASE_PATH + filename + ".txt";

		// AutoClose를 이용한 구현
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
			StringBuilder content = new StringBuilder();
			int data = 0;
			while (data != -1) {
				data = bis.read();
				content.append((char) data);
			}

			// 텍스트를 구분자로 나누기
			String[] textArr = content.toString().split(",");

			// Profile 객체 생성
			profile.setName(filename);
			profile.setWeight(Double.parseDouble(textArr[0]));
			profile.setPassword(textArr[1]);

		} catch (IOException e) {
			throw e; //그대로 던짐
		}
		return profile;
	}

	@Override
	public void setOutputStream(Profile profile) throws IOException {
		filePath = BASE_PATH + profile.getName().toString()+".txt";
		//AutoClose를 이용한 구현
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
			String data = profile.getWeight() + "," + profile.getPassword();

			bos.write(data.getBytes(StandardCharsets.UTF_8)); // UTF-8 형식으로 Write
			bos.flush(); // 기록
		} catch (IOException e) {
			throw e; //그대로 던짐
		}
		System.out.println("저장에 성공했습니다.");//TODO : 이거 처리 View로 보내야 함... 컨트롤러에서 메소드 분리 한번 더 해야한다
	}

	public ArrayList<Profile> getFromSerializedFile() throws FileIoFailException {
		return getFromSerializedFile(BASE_PATH,BASE_FILE_NAME);
	}

	public ArrayList<Profile> getFromSerializedFile(String filename) throws FileIoFailException {
		return getFromSerializedFile(BASE_PATH,filename);
	}
	
	@Override
	public ArrayList<Profile> getFromSerializedFile(String path, String filename) throws FileIoFailException {
		if(path==null)
			path=BASE_PATH;
		filePath = path + filename;
		
		File file = new File(filePath); 
		if (file.exists()) {
//			System.out.println("파일로부터 데이터를 읽어옵니다.");
			try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)))) {
				profileList = ((ArrayList<Profile>) ois.readObject());
				return profileList;
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				throw new FileIoFailException("파일 처리 과정에서 오류가 발생했습니다.");
				
			}
		}else {
			System.out.println("해당 경로에 파일이 없습니다. 새 파일을 생성합니다.");
			profileList = new ArrayList<Profile>();
			saveSerializedFile(profileList);
			return profileList; //새 파일 생성하고 빈 리스트 객체 리턴
		}				
	}

	@Override
	public void saveSerializedFile(ArrayList<Profile> profileList) throws FileIoFailException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)))) {
			oos.writeObject(profileList);
		} catch (IOException e) {
			throw new FileIoFailException("파일 처리 과정에서 오류가 발생했습니다.");
		}
	}

}
