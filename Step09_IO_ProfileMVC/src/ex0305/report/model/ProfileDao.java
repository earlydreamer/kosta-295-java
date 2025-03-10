package ex0305.report.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import ex0305.report.exception.FileIoFailException;
import ex0305.report.exception.ProfileNotFoundException;

/**
 * 파일 입출력을 담당하는 클래스 일종의 DAO 역할을 한다.
 * 
 * @author 박재현 2025-03-06
 */

//TODO : 파일 입출력 부분 Serialize 방식으로 다시 작성
public class ProfileDao implements ProfileDaoAction {
	// CRUD 역할이 더 크고 FileStream은 그 기능 중 일부
	// FileStream과 DAO의 클래스를 분리하고 DAO 클래스에서 FileStream을 import해 사용하는 형태로 수정 (단일 책임의
	// 원칙)

	private FileStreamer streamer;
	private ArrayList<Profile> profileList;

	public ProfileDao() throws FileIoFailException {
		init();
	}

	/**
	 * 기본 초기화로직
	 * 
	 * @throws FileIoFailException
	 */
	void init() throws FileIoFailException {
		streamer = new FileStreamer();
		try {
			profileList = streamer.getFromSerializedFile();
		} catch (FileIoFailException e) {
			throw e;
		}
	}

	@Override
	public void updateProfile(Profile profile) {
		// TODO Auto-generated method stub

	}

	@Override
	public Profile searchProfileByName(String name) throws ProfileNotFoundException {
		for (Profile profile : profileList) {
//			System.out.println(profile.getName());
			if (profile.getName().equals(name)) {
				System.out.println(profile.getName());
				return profile;
			}
		}
		throw new ProfileNotFoundException(name + "님의 프로필을 발견하지 못했습니다.");

	}

	@Override
	public void insertProfile(Profile profile) throws FileIoFailException {
		profileList.add(profile);
		streamer.saveSerializedFile(profileList);

	}

	@Override
	public ArrayList<Profile> selectAllProfile() throws FileIoFailException {
		streamer.getFromSerializedFile();
		return profileList;
	}

	public Profile getFromInputStream(String inputString) throws IOException {
		return streamer.getFromInputStream(inputString);
	}

	@Override
	public ArrayList<Profile> searchProfileByWeight(double weight) throws ProfileNotFoundException {
		ArrayList<Profile> returnList = new ArrayList<Profile>();
		for (Profile profile : profileList) {
			if (profile.getWeight() == weight)
				returnList.add(profile); // 찾은 프로필을 리스트에 추가
		}

		if (returnList == null)
			throw new ProfileNotFoundException("몸무게가 일치하는 회원이 없습니다.");
		else
			return returnList;

	}

}
