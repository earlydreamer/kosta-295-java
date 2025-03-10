package ex0305.report.view;

import ex0305.report.exception.ProfileNotFoundException;
import ex0305.report.model.Profile;

/**
 * View의 기능을 정의한 Interface
 * @author 박재현
 * 2025-03-06
 * 최종수정 2025-03-11
 */
public interface ViewAction {

	void mainPrint();
	void inputPrint();
	void nameInputPrint();
	void weightInputPrint();
	void passwordInputPrint();
	void profilePrint(Profile profile) throws ProfileNotFoundException;
	void exitPrint();
	void exceptionMessagePrint(String message);
	void writeSuccessPrint();
	void wrongInputPrint();
	void wrongPasswordPrint();
	void checkPasswordPrint();
	void changeWeightPrint();
	void writeSuccessPrint(Profile profile);
	void updatePasswordPrint();
	void deleteSuccessPrint(String name);
	void updateSuccessPrint(Profile profile);
	void changeWeightPrint(Profile profile);
	void unlockSuccessPrint(Profile profile);
	void unlockMessagePrint();
	

}
