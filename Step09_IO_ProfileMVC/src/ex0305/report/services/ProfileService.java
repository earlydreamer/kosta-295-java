package ex0305.report.services;

import java.util.ArrayList;

import ex0305.report.exception.DuplicatedNameException;
import ex0305.report.exception.FileIoFailException;
import ex0305.report.exception.LockedAccountException;
import ex0305.report.exception.ProfileNotFoundException;
import ex0305.report.exception.WrongPasswordException;
import ex0305.report.model.Profile;
import ex0305.report.model.ProfileDao;

/**
 * 프로필 DTO 가공과 관련된 로직을 담당하는 클래스
 * 
 * @author 박재현 2025-03-06
 * 최종수정 2025-03-11
 */

public class ProfileService implements ProfileAction {

	private ProfileDao dao;


	/*
	 * --------------------------------Constructor ----------------------------------
	 */

	public ProfileService(ProfileDao dao) {
		this.dao = dao;
		testInit();
	}

	
	void testInit() {
		try {
			System.out.println("초기화 테스트 데이터를 입력합니다.");
			createProfile("이순신",65,"12345");
			createProfile("강감찬",55,"12345");
			createProfile("김유신",64,"12345");
			createProfile("유관순",53,"12345");
			createProfile("장영실",53,"12345");
			createProfile("문익점",65,"12345");
			createProfile("이순신",65,"12345");
			createProfile("이순신",65,"12345"); //중복처리 검사
			createProfile("이순신",65,"12345"); //예외처리되어 여기 실행 안되어야함
			createProfile("정몽주",63,"12345"); //예외처리되어 여기 실행 안되어야함
			createProfile("한석봉",58,"12345"); //예외처리되어 여기 실행 안되어야함
			
		} catch (FileIoFailException | DuplicatedNameException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * -------------------------------- Override Methods ----------------------------------
	 */	

	@Override
	public Profile createProfile(String name, double weight, String password)
			throws FileIoFailException, DuplicatedNameException {
		Profile newProfile = new Profile(name, weight, password);
		ArrayList<Profile> profileList = dao.selectAllProfile();

//		int sameProfileCount = 0; //동명이인이 발견되면 자동으로 번호를 붙이는 방식으로 해결하려고 했는데 이런 식으로 하면 안 된다. 번호가 붙으면 텍스트가 달라져 다른 이름이 되기 때문에...
		for (Profile profile : profileList) {
			if (profile.getName().equals(newProfile.getName())) {
//				sameProfileCount++;
				throw new DuplicatedNameException("동명이인이 발견되었습니다. 다른 이름을 입력해주세요. (닉네임 등)"); //일단 그냥 예외 Throw하고 새로 입력하도록 변경
			}
		}
		dao.insertProfile(newProfile); // DAO에 요청해서 기록

//		if (sameProfileCount > 0) { //유효하지 않은 로직 주석처리
//			newProfile.setName(newProfile.getName() + sameProfileCount); // 동명이인일 경우 이름에 번호를 붙여서 저장... 
//			throw new DuplicatedNameException("동명이인이 발견되었습니다. " + newProfile.getName() + "으로 저장됩니다.");
//		}
		return newProfile;// View에 전달하기 위해 기록한 프로필 객체를 컨트롤러로 반환...
	}

	public ArrayList<Profile> selectAllProfile() throws FileIoFailException {
		return dao.selectAllProfile();

	}

	@Override
	public ArrayList<Profile> searchProfileByWeight(double weight) throws ProfileNotFoundException {
		return dao.searchProfileByWeight(weight);
	}

	@Override
	public Profile updateProfile(Profile profile) throws ProfileNotFoundException, FileIoFailException {
		return dao.updateProfile(profile);
	}

	@Override
	public Profile checkPassword(String name, String password)
			throws FileIoFailException, ProfileNotFoundException, WrongPasswordException, LockedAccountException {
		final int MAX_WRONG_COUNT = 3;
		Profile profile = dao.searchProfileByName(name);
		int wrongPasswordCount = profile.getWrongPasswordCount();

		if (profile.getPassword().equals(password)) { // 비밀번호가 맞으면 해당 프로필을 리턴
			if (!profile.isAccountLock()) // 계정이 잠금 상태가 아니라면
				profile.setWrongPasswordCount(0); // 비밀번호가 맞으면 틀린 횟수 리셋
			return profile;
		}

		if (profile.isAccountLock()) // 계정이 잠금 상태이면 Exception 리턴
			throw new LockedAccountException("비밀번호 오류 횟수를 초과해 계정이 잠겼습니다. 비밀번호를 변경해주세요.");
		
		wrongPasswordCount++; // 비밀번호 틀린 횟수 증가
		profile.setWrongPasswordCount(wrongPasswordCount); // 비밀번호 틀린 횟수를 프로필 정보에 세팅

		if (wrongPasswordCount >= MAX_WRONG_COUNT) { // 비밀번호 틀린 횟수가 최대치를 넘으면 계정을 잠근다
			profile.setAccountLock(true);

		}
		dao.updateProfile(profile);// DAO에 해당 프로필 정보 갱신 요청
		throw new WrongPasswordException("비밀번호가 틀렸습니다! (" + wrongPasswordCount + "/" + MAX_WRONG_COUNT + ")");
	}

	@Override
	public String deleteProfile(Profile profile)
			throws FileIoFailException, ProfileNotFoundException, WrongPasswordException {
		return dao.DeleteProfile(profile);

	}

	@Override
	public Profile searchProfileByName(String name) throws ProfileNotFoundException {
		return dao.searchProfileByName(name); 
		//TODO : 잠긴 계정은 조회 안되게 하고 싶다고 여기서 Exception으로 잠긴 계정에 exception을 날려버리면 잠금해제 기능에서 searchProfileByName 기능을 호출할때 Exception에 걸려 값을 못받는다... 좋은 방법 없을까
	}

}
