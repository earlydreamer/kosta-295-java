package ex0305.report.view;

import ex0305.report.model.Profile;
public interface ViewAction {

	void mainPrint();
	void inputPrint();
	void nameInPrint();
	void weightInPrint();
	void passInPrint();
	void profilePrint(Profile profile);
	
}
