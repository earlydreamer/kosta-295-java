package ex0305.report.services;

import ex0305.report.model.Profile;

/**
 * 프로필 DTO 가공과 관련된 로직을 담당하는 클래스
 * @author 박재현
 * 2025-03-06
 */
public class ProfileService implements ProfileAction{
	
	@Override
	public Profile newProfile(String name,double weight,String password) {			
		Profile profile = new Profile(name,weight,password);
		return profile;
	}
	
	
	/*
	 * --------------------------------Constructor ----------------------------------
	 */
	
	public ProfileService(){
		
	}
	
	
}
