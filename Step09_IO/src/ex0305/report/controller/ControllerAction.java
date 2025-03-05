package ex0305.report.controller;

import ex0305.report.model.Profile;

/**
 * 컨트롤러가 가지는 기능을 정의
 */
public interface ControllerAction {

	void menuLogic();
	int inputMenu();
	Profile newProfile();
	String inputName();
	double inputWeight();
	String inputPassword();
	Profile loadProfile();
	void exit();
	
}
