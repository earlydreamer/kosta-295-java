package ex0305.report.services;

import ex0305.report.model.Profile;

public class ProfileService implements ProfileAction{

	@Override
	public Profile newProfile(String name,double weight,String password) {			
		Profile profile = new Profile(name,weight,password);
		return profile;
	}
	
	
}
