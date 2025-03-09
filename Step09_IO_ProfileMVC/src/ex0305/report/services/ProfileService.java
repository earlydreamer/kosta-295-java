package ex0305.report.services;

import java.util.ArrayList;

import ex0305.report.exception.FileIoFailException;
import ex0305.report.model.Profile;
import ex0305.report.model.ProfileDao;

/**
 * 프로필 DTO 가공과 관련된 로직을 담당하는 클래스
 * @author 박재현
 * 2025-03-06
 */

//TODO : 추가된 메소드에 대해 Override해서 실제 비즈니스 로직의 동작 작성
public class ProfileService implements ProfileAction{

	private ProfileDao dao;
	
	@Override
	public Profile newProfile(String name, double weight,String password) throws FileIoFailException {			
		Profile newProfile = new Profile(name,weight,password);
		ArrayList<Profile> profileList = dao.selectAllProfile();
		
		int sameProfileCount =0;
		for(Profile profile : profileList) {
			if(profile.getName()==newProfile.getName()){//동명이인이 발견되면 동명이인 수만큼 카운트 증가
				sameProfileCount++;
			}
		}
		dao.insertProfile(newProfile); //DAO에 요청해서 기록
		if(sameProfileCount>0) {
			System.out.println("동명이인이 발견되었습니다.");//Exception으로 빼는게 낫겠는데 시간이 없다... 일단 이렇게 날로 예외처리
			newProfile.setName(newProfile.getName()+sameProfileCount); // 동명이인일 경우 이름에 번호를 붙여서 저장... 저장 후 반드시 노티를 해줘야 한다. 비즈니스 로직에 해당 부분 추가
		}
		return newProfile;//View에 전달하기 위해 기록한 프로필 객체를 컨트롤러로 반환... TODO : Exception을 이용하도록 리팩토링
	}
	
	
	public ArrayList<Profile> selectAllProfile() throws FileIoFailException{
		return dao.selectAllProfile();
		
	}
	
	/*
	 * --------------------------------Constructor ----------------------------------
	 */
	
	public ProfileService(ProfileDao dao){
		this.dao = dao;
	}
	
	
	
	
}
