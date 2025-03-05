package ex0305.report.controller;

/**
 * 컨트롤러가 가지는 기능을 정의
 */
public interface ControllerAction {

	void newProfile();
	String inputName();
	double inputWeight();
	String inputPassword();
	void loadProfile();
	void exit();
	
}
