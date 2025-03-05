package ex0305.report.view;

import ex0305.report.model.Profile;
public interface ViewAction {

	void mainPrint();
	void inputPrint();
	void nameInputPrint();
	void weightInputPrint();
	void passwordInputPrint();
	void profilePrint(Profile profile);
	
}
