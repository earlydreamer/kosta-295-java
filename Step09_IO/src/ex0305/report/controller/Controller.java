package ex0305.report.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import ex0305.report.exception.ProfileNotFoundException;
import ex0305.report.model.FileStreamer;
import ex0305.report.model.Profile;
import ex0305.report.services.InputService;
import ex0305.report.services.ProfileService;
import ex0305.report.view.View;

/**
 * 컨트롤러 클래스
 * @author 박재현
 * 2025-03-06
 */
public class Controller implements ControllerAction {

	View view = new View();

	FileStreamer stream = new FileStreamer();
	InputService input = new InputService();
	ProfileService profile = new ProfileService();

	@Override
	public void menuLogic() {
		// while loop를 돌면서 input을 대기하는 로직... 입력에 대한 응답의 주체가 Controller가 되도록
		boolean isRunning = true;
		int menuSelect = 0;
		do {
			try {
				view.mainPrint();
				menuSelect = inputMenu();
				switch (menuSelect) {
				case 1 -> stream.setOutputStream(newProfile());
				case 2 -> view.profilePrint(loadProfile());
				case 3 -> isRunning = exit();
				default -> wrongInput();
				}
			} catch (IOException e) {
				//저장과 불러오기 양쪽에서 오는 IOException에 대응
				System.out.println(e.getMessage());//예외 발생 메뉴 로직 루프 가장 바깥쪽에서 예외를 잡고 다시 루프를 돌린다
			}
		} while (isRunning);

	}

	@Override
	public int inputMenu() {
		// TODO : 예외처리
		view.inputPrint();
		int returnInput = input.inputInt();

		return returnInput;

	}

	@Override
	public Profile newProfile() {
		// TODO : 예외처리
		String name = inputName();
		double weight = inputWeight();
		String password = inputPassword();

		return profile.newProfile(name, weight, password);

	}

	@Override
	public String inputName() {
		// TODO : 예외처리
		view.nameInputPrint();
		String inputString = input.inputString();
		return inputString;
	}

	@Override
	public double inputWeight() {
		// TODO : 예외처리
		view.weightInputPrint();
		double inputDouble = input.inputDouble();
		return inputDouble;
	}

	@Override
	public String inputPassword() {
		// TODO : 예외처리
		view.passwordInputPrint();
		String inputString = input.inputString();
		return inputString;
	}

	@Override
	public Profile loadProfile() throws IOException {
		Profile returnProfile = null;
		String inputString = inputName();
		try {
			returnProfile = stream.getFromInputStream(inputString);
		} catch (IOException e) {
			throw e; //받은 예외를 그대로 다시 던진다
		}
		return returnProfile;

	}

	@Override
	public boolean exit() {
		view.exitPrint();
		return false; // 종료 뷰를 표시하고 false를 리턴해 isRunnig 플래그를 꺼준다.
	}

	@Override
	public void wrongInput() {
		view.wrongInputPrint();

	}

	/*
	 * --------------------------------Constructor	 ----------------------------------
	 */

	public Controller() {
		menuLogic();
	}

}
