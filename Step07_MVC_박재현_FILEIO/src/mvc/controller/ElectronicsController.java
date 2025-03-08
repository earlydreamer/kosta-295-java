package mvc.controller;

import mvc.dto.Electronics;

import mvc.exception.DuplicatedIdFoundException;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.FileIoFailException;
import mvc.exception.SearchNotFoundException;
import mvc.exception.WrongInputException;

import mvc.service.ElectronicsService;
import mvc.service.ElectronicsServiceImpl;

import mvc.view.FailView;
import mvc.view.MenuView;
import mvc.view.SuccessView;

/**
 * View와 Model 사이에서 중간 역할 : 사용자의 요청을 받아서 그에 해당하는 서비스를 호출하고 호출한 결과를 받아서 결과값에 따라
 * 결과 뷰를 호출해준다.
 */

public class ElectronicsController {
	private ElectronicsService service = ElectronicsServiceImpl.getInstance();
	private static ElectronicsController instance = null;
	private MenuView menuView = new MenuView();
	
	
	/*
	 * -------------------------Constructor ----------------------------
	 */

	private ElectronicsController(){
		
	}
	
	public static ElectronicsController getInstance() {
		if(instance == null)
			instance = new ElectronicsController();
		return instance;
		
	}
	
	/*
	 * ------------------------- Menu Loop ----------------------------
	 */

	
	/**
	 * 메뉴 로직
	 */
	void menu() {
		//View -> Controller로 옮기고 Lambda 스타일의 switch-case문으로 변경
		//컨트롤러 내에서 루프를 돌면서 입력을 대기
		//입력을 받는 기능과 출력을 하는 기능, 입력받은 내용으로 정해진 메소드를 호출하는 기능을 각각 메소드 분리
		boolean isRunning = true;
		while (isRunning) {
			menuView.printSortState(service.getSortState());
			menuView.printMenu();
			try {
				selectService(menuView.menuInput());
			} catch (WrongInputException e) {
				FailView.errorMessage(e.getMessage());
			} catch (FileIoFailException e) {
				FailView.errorMessage(e.getMessage());
			} //TODO : 종료 시 루프 빠져나오는 기능 Exception 기반으로 변경
		}
	}

	
	void selectService(String selectedMenu) throws FileIoFailException, WrongInputException {
		switch (selectedMenu) {
		case "1" -> this.selectAll();
		case "2" -> searchByModelNo(menuView.inputSearch());
		case "3" -> this.insert(menuView.inputInsert());
		case "4" ->	this.update(menuView.inputUpdate());
		case "5" -> this.deleteModelNo(menuView.inputDelete());
		case "6" ->	this.selectSortByPrice();
		case "7" -> this.selectSortByModelNo();
		case "8" -> this.sortToggle();
		case "9" ->	System.exit(0);
		default  -> System.out.println("메뉴를 다시 선택해주세요!!!!");
		}
	}
	
	/*
	 * ------------------ Call Service Layer ----------------------------
	 * 입력받은 기능은 모두 Service 레이어의 구현체를 호출해 수행된다
	 * ------------------------------------------------------------------
	 */

	
	/**
	 * 전체검색 기능을 호출
	 */
	public void selectAll() {
		try {
			SuccessView.printAll(service.selectAll());
		} catch (FileIoFailException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 모델명으로 정렬 기능을 호출
	 */
	public void selectSortByModelNo() {
		try {
			SuccessView.printAll(service.selectSortByModelNo());
		} catch (FileIoFailException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 전자제품 등록 기능을 호출
	 * @param electronics
	 */
	public void insert(Electronics electronics) {
		try {
			service.insert(electronics);
		} catch (ElectronicsArrayBoundsException | DuplicatedIdFoundException | FileIoFailException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 모델명으로 전자제품 검색 기능을 호출
	 * 
	 * @param modelNo
	 * @throws FileIoFailException 
	 */
	public void searchByModelNo(int modelNo) throws FileIoFailException {
		try {
			SuccessView.printSearchByModelNo(service.searchByModelNo(modelNo));
		} catch (SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 모델번호에 해당하는 전자제품 수정 기능을 호출
	 * 
	 * @param electronics
	 * @throws FileIoFailException 
	 */
	public void update(Electronics electronics) throws FileIoFailException {
		try {
			service.update(electronics);
		} catch (SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 모델번호에 해당하는 전자제품 삭제 기능 호출
	 * 
	 * @param electronics
	 */
	public void deleteModelNo(int modelNo) {
		try {
			service.delete(modelNo);
		} catch (SearchNotFoundException | FileIoFailException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 가격을 기준으로 정렬하기 기능 호출 (가격이 같으면 modelNo를 기준으로 정렬)
	 * @return
	 */
	public void selectSortByPrice() {
		try {
			SuccessView.printAll(service.selectSortByPrice());
		} catch (FileIoFailException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 출력에 사용되는 정렬기준을 변경
	 */
	public void sortToggle() {
		SuccessView.printToggleMessage(service.sortToggle());
	}

}
