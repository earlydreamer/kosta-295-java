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

import ex0305.report.exception.EmptyFileException;
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
	
	FileStreamer(){
		filePath = BASE_PATH+BASE_FILE_NAME;
		profileList = new ArrayList<Profile>();
	}
	
	FileStreamer(String filename){
		filePath = BASE_PATH+filename;
		profileList = new ArrayList<Profile>();
	}
	
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
			System.out.println("초기화 중... 파일로부터 데이터를 읽어옵니다.");
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
