package ex0305.report.services;

import ex0305.report.model.Profile;

public interface ProfileAction {

	Profile newProfile(String name, double weight, String password);
}
