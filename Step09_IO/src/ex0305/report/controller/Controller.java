package ex0305.report.controller;

import ex0305.report.model.FileStreamer;
import ex0305.report.model.Profile;
import ex0305.report.services.InputService;
import ex0305.report.services.ProfileService;
import ex0305.report.view.View;

public class Controller implements ControllerAction{

	
	View view = new View();
	
	FileStreamer stream = new FileStreamer();
	InputService input = new InputService();
	ProfileService profile = new ProfileService();

	@Override
	public void menuLogic() {
		// TODO Auto-generated method stub
		boolean isRunning = true;
		int menuSelect =0;
		do {
			view.mainPrint();	
			
			menuSelect = inputMenu();
			switch(menuSelect) {
			case 1 -> System.out.println(newProfile());
			case 2 -> loadProfile();
			case 3 -> exit();
			
			}
			
		}while(isRunning);
		
	}
	
	@Override
	public int inputMenu() {
		// TODO Auto-generated method stub
		view.inputPrint();
		int returnInput = input.inputInt();
		
		return returnInput;
		
	}
	
	@Override
	public Profile newProfile() {
		// TODO Auto-generated method stub

		String name = inputName();
		double weight = inputWeight();
		String password = inputPassword();
		
		return profile.newProfile(name,weight,password);
		
	}

	@Override
	public String inputName() {
		view.nameInputPrint();
		String inputString = input.inputString();
		return inputString;
	}

	@Override
	public double inputWeight() {
		view.weightInputPrint();
		double inputDouble = input.inputDouble();
		return inputDouble;
	}

	@Override
	public String inputPassword() {
		view.passwordInputPrint();
		String inputString = input.inputString();
		return inputString;
	}

	@Override
	public Profile loadProfile() {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	public Controller(){
		menuLogic();
	}



	

}
