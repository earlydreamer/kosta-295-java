package mvc.controller;

import mvc.dto.Electronics;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;
import mvc.service.ElectronicsService;
import mvc.service.ElectronicsServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;

/**
 * View와 Model 사이에서 중간 역할 : 사용자의 요청을 받아서 그에 해당하는 서비스를 호출하고 호출한 결과를 받아서 결과값에 따라
 * 결과 뷰를 호출해준다.
 */

public class ElectronicsController {
	private ElectronicsService service = ElectronicsServiceImpl.getInstance();

	/**
	 * 전체검색
	 */
	public void selectAll() {
		SuccessView.printAll(service.selectAll());
	}

	
	public void selectSortByModelNo() {
		SuccessView.printAll(service.selectSortByModelNo());
	}
	
	
	/**
	 * 전자제품 등록
	 */

	public void insert(Electronics electronics) {
		try {
			service.insert(electronics);
		} catch (ElectronicsArrayBoundsException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 모델번호에 해당하는 전자제품 검색
	 * 
	 * @param modelNo
	 */
	public void searchByModelNo(int modelNo) {
		try {
			SuccessView.printSearchByModelNo(service.searchByModelNo(modelNo));
		} catch (SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 * 모델번호에 해당하는 전자제품 수정하기
	 * @param electronics
	 */
	public void update(Electronics electronics) {
		try {
			service.update(electronics);
		} catch (SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 모델번호에 해당하는 전자제품 삭제하기
	 * @param electronics
	 */
	public void deleteModelNo(int modelNo) {
		try {
			service.delete(modelNo);
		} catch (SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 가격을 기준으로 정렬하기 만약, 가격이 같으면 modelNo를 기준으로 정렬한다.
	 * @return
	 */
	public void selectSortByPrice() {
		SuccessView.printAll(service.selectSortByPrice());
	}
	
	/**
	 * 출력에 사용되는 정렬기준을 변경한다. 
	 */
	public void sortToggle() {
		SuccessView.printToggleMessage(service.sortToggle());
	}
	
	/**
	 * 현재의 정렬상태를 반환한다.
	 */
	public void sortState() {
		SuccessView.printSortState(service.sortStateReturn());
	}
}
