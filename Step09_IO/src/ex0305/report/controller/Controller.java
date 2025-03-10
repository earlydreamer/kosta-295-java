package ex0305.report.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import ex0305.report.exception.FileIoFailException;
import ex0305.report.exception.ProfileNotFoundException;
import ex0305.report.model.ProfileDao;
import ex0305.report.model.Profile;
import ex0305.report.services.InputService;
import ex0305.report.services.ProfileService;
import ex0305.report.view.View;

/**
 * 컨트롤러 클래스
 * 
 * @author 박재현 2025-03-06
 */
//TODO : 추가된 메소드 Override해서 작성
//TODO : 추가된 기능 메뉴 로직에 추가
public class Controller implements ControllerAction {

	/*
	 * ------------------- Member -----------------------
	 */

	View view;
	ProfileDao dao;
	InputService input;
	ProfileService profile;


	/*
	 * ------------------- Constructor -----------------------
	 */

	public Controller() {
		init(); //테스트 용이성을 위해 생성자 안에 직접 초기화 로직을 넣는것보단 별도의 메소드로 분리하는 것이 낫다...
		menuLogic();
	}
	
	
	/*
	 * ------------------- Init Method -----------------------
	 */

	
	public void init() {
		try {
			view= new View();
			dao = new ProfileDao();
			input = new InputService();
			profile = new ProfileService(this.dao);
		} catch (FileIoFailException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * -------- Override Method -----------------------
	 */

	
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
				case 1 -> view.writeSuccessPrint(newProfile()); 
				case 2 -> view.profilePrint(loadProfile()); 
				case 3 -> isRunning = exit();
				default -> wrongInput();
				}
			} catch (IOException | FileIoFailException e) {
				// 저장과 불러오기 양쪽에서 오는 IOException에 대응
				System.out.println(e.getMessage());// 예외 발생 메뉴 로직 루프 가장 바깥쪽에서 예외를 잡고 다시 루프를 돌린다
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
	public Profile newProfile() throws FileIoFailException {
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
			returnProfile = dao.getFromInputStream(inputString);
		} catch (IOException e) {
			throw e; // 받은 예외를 그대로 다시 던진다
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


	@Override
	public Profile searchWeight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double updateWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Profile updateProfile() {
		// TODO Auto-generated method stub
		return null;
	}

}
