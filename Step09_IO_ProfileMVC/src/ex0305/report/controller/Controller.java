package ex0305.report.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;

import ex0305.report.controller.io.InputHandler;
import ex0305.report.exception.DuplicatedNameException;
import ex0305.report.exception.FileIoFailException;
import ex0305.report.exception.LockedAccountException;
import ex0305.report.exception.ProfileNotFoundException;
import ex0305.report.exception.WrongInputException;
import ex0305.report.exception.WrongPasswordException;
import ex0305.report.model.ProfileDao;
import ex0305.report.model.Profile;
import ex0305.report.services.ProfileService;
import ex0305.report.view.View;

/**
 * 컨트롤러 클래스
 * 
 * @author 박재현 
 * 2025-03-06
 * 최종수정 2025-03-11
 */
public class Controller implements ControllerAction {

	/*
	 * ------------------- Member -----------------------
	 */

	View view = null;
	InputHandler input = null;
	ProfileDao dao = null;
	ProfileService profile = null;

	/*
	 * ------------------- Constructor -----------------------
	 */

	public Controller() {
		init(); // 테스트 용이성을 위해 생성자 안에 직접 초기화 로직을 넣는것보단 별도의 메소드로 분리한뒤 생성자 내에서 호출하는 것이 낫다...
		menuLogic();
	}

	/*
	 * ------------------- Init Method -----------------------
	 */

	public void init() {
		try {
			this.view = new View();
			this.input = new InputHandler();
			this.dao = new ProfileDao();
			this.profile = new ProfileService(this.dao);
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
				case 2 -> view.profilePrint(searchProfileByName());
				case 3 -> view.changeWeightPrint(updateWeight());
				case 4 -> view.deleteSuccessPrint(deleteProfile());
				case 5 -> view.profilePrint(searchByWeight());
				case 6 -> view.updateSuccessPrint(updatePassword());
				case 7 -> view.unlockSuccessPrint(unlockAccount());
				case 9 -> isRunning = exit();
				case 99 -> view.profilePrint(selectAllProfile()); // 테스트용 임시 기능. 저장된 모든 이름과 체중을 출력한다.

				default -> wrongInput();
				}

			} catch (FileIoFailException e) {
				System.out.println(e.getMessage());
			} catch (ProfileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (WrongPasswordException e) {
				System.out.println(e.getMessage());
			} catch (DuplicatedNameException e) {
				System.out.println(e.getMessage());
			} catch (WrongInputException e) {
				System.out.println(e.getMessage());
			} catch (LockedAccountException e) {
				System.out.println(e.getMessage());
			}
		} while (isRunning);

	}

	@Override
	public int inputMenu() throws WrongInputException {
		try {
			view.inputPrint();
			return input.inputInt();
		} catch (Exception e) {
			throw new WrongInputException("잘못된 입력입니다.");
		}
	}

	@Override
	public Profile newProfile() throws FileIoFailException, DuplicatedNameException, WrongInputException {
		try {
			String name = inputName();
			double weight = inputWeight();
			String password = inputPassword();

			return profile.createProfile(name, weight, password);
		} catch (InputMismatchException | NumberFormatException | NullPointerException e) {
			throw new WrongInputException("잘못된 입력입니다.");

		}
	}

	@Override
	public String inputName() throws WrongInputException {
		try {
			view.nameInputPrint();
			String inputString = input.inputString();
			return inputString;
		} catch (Exception e) {
			throw new WrongInputException("잘못된 입력입니다.");
		}
	}

	@Override
	public double inputWeight() throws WrongInputException {
		try {
			view.weightInputPrint();
			double inputDouble = input.inputDouble();
			return inputDouble;
		} catch (Exception e) {
			throw new WrongInputException("잘못된 입력입니다.");
		}

	}

	@Override
	public String inputPassword() throws WrongInputException {
		try {
			view.passwordInputPrint();
			String inputString = input.inputString();
			return inputString;
		} catch (Exception e) {
			throw new WrongInputException("잘못된 입력입니다.");
		}
	}

	@Override
	public Profile searchProfileByName() throws FileIoFailException, ProfileNotFoundException, WrongPasswordException,
			WrongInputException, LockedAccountException {

		Profile returnProfile;
		returnProfile = checkPassword();

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
	public ArrayList<Profile> searchByWeight() throws ProfileNotFoundException {
		ArrayList<Profile> returnProfile;
		Double weight = input.inputDouble();
		returnProfile = profile.searchProfileByWeight(weight);
		return returnProfile;

	}

	@Override
	public Profile updateWeight() throws ProfileNotFoundException, FileIoFailException, WrongPasswordException,
			WrongInputException, LockedAccountException {
		Profile returnProfile = checkPassword();
		returnProfile.setWeight(inputWeight());
		return returnProfile;

	}

	@Override
	public Profile checkPassword() throws FileIoFailException, ProfileNotFoundException, WrongPasswordException,
			WrongInputException, LockedAccountException {
		view.checkPasswordPrint();
		String name = inputName();
		String password = inputPassword();
		return profile.checkPassword(name, password);// 서비스 레이어로 입력받은 id와 비밀번호를 보낸 뒤 맞으면 프로필 객체를 리턴받는다.
	}

	@Override
	public Profile updatePassword() throws FileIoFailException, ProfileNotFoundException, WrongPasswordException,
			WrongInputException, LockedAccountException {

		Profile updateProfile = checkPassword(); // 비밀번호가 안 맞으면 checkPassword에서 발생한 Exception을 타고 나간다

		if (updateProfile.isAccountLock())
			updateProfile.setAccountLock(false); // 비밀번호가 맞으면 계정 잠금을 풀고 비밀번호 변경을 진행한다

		view.updatePasswordPrint();
		updateProfile.setPassword(inputPassword());
		return profile.updateProfile(updateProfile); // 서비스 레이어로 업데이트 요청을 보내고 결과를 받아 리턴한다
	}

	@Override
	public ArrayList<Profile> selectAllProfile() throws FileIoFailException {
		return profile.selectAllProfile();
	}

	@Override
	public String deleteProfile() throws FileIoFailException, ProfileNotFoundException, WrongPasswordException,
			WrongInputException, LockedAccountException {

		Profile deleteProfile = checkPassword();
		return profile.deleteProfile(deleteProfile);
	}

	@Override
	public Profile unlockAccount() throws WrongInputException, ProfileNotFoundException, FileIoFailException {
		view.unlockMessagePrint();
		String name = inputName();
		String password = inputPassword();

		Profile returnProfile = profile.searchProfileByName(name);
		if (password.equals(returnProfile.getPassword())) {			
			returnProfile.setAccountLock(false);
			returnProfile.setWrongPasswordCount(0);
		}
		profile.updateProfile(returnProfile);
		return returnProfile;
	}

}
