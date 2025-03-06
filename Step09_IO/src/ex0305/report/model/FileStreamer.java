package ex0305.report.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 파일 입출력을 담당하는 클래스 일종의 DAO 역할을 한다.
 * @author 박재현
 * 2025-03-06
 */

//TODO : 파일 입출력 부분 Serialize 방식으로 다시 작성
public class FileStreamer implements StreamAction {

	// 기본 경로를 static final로 선언
	private static final String BASE_PATH = "resource/";
	Profile profile = new Profile();
	
	@Override
	public Profile getFromInputStream(String filename) throws IOException {

		String filePath = BASE_PATH + filename + ".txt";

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
		String filePath = BASE_PATH + profile.getName().toString()+".txt";
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
}
