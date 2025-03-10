package ex0305.report.model;

import java.io.IOException;
import java.util.ArrayList;

import ex0305.report.exception.FileIoFailException;
import ex0305.report.exception.ProfileNotFoundException;

/**
 * 파일 입출력을 담당하는 클래스 일종의 DAO 역할을 한다.
 * 
 * @author 박재현 2025-03-06
 * 최종수정 2025-03-11
 */

public class ProfileDao implements ProfileDaoAction {
	// CRUD 역할이 더 크고 FileStream은 그 기능 중 일부
	// FileStream과 DAO의 클래스를 분리하고 DAO 클래스에서 FileStream을 import해 사용하는 형태로 수정 (단일 책임의 원칙)

	private FileStreamer streamer;
	private ArrayList<Profile> profileList;

	public ProfileDao() throws FileIoFailException {
//		init();
		testInit();
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

	void testInit() throws FileIoFailException {
		init();

	}
	
	@Override
	public Profile updateProfile(Profile newProfile) throws ProfileNotFoundException, FileIoFailException {
		int index = 0;
		for (Profile profile : profileList) {
			if (profile.getName() == newProfile.getName()) {
				profileList.set(index, newProfile);
				streamer.saveSerializedFile(profileList);
				return profile;
			}
			index++;
		} // 루프를 다 돌고도 찾지 못하면 예외 throw
		throw new ProfileNotFoundException(newProfile.getName() + "님의 프로필을 발견하지 못했습니다.");

	}

	@Override
	public Profile searchProfileByName(String name) throws ProfileNotFoundException {
		for (Profile profile : profileList) {
			if (profile.getName().equals(name)) {
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
		//기존에 파일스트림을 직접 호출하던 구조를 한단계 래핑 (파일에서 DB로 바꿀경우 호출부는 그대로 두고 메소드 내부 구현만 교체하면 된다)
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
		if (returnList.isEmpty())
			throw new ProfileNotFoundException("몸무게가 일치하는 회원이 없습니다.");
		else
			return returnList;
	}

	@Override
	public String DeleteProfile(Profile deleteProfile) throws FileIoFailException, ProfileNotFoundException {
		// TODO Auto-generated method stub
		int index = 0;
		for (Profile profile : profileList) {
			if (profile.getName().equals(deleteProfile.getName())) {
				profileList.remove(index);
				streamer.saveSerializedFile(profileList);
				return profile.getName();
			}
			index++;
		}
		throw new ProfileNotFoundException(deleteProfile.getName() + "님의 프로필을 발견하지 못했습니다.");
	}

}
