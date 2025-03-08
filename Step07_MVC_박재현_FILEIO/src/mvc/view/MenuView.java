package mvc.view;

import java.util.Scanner;

import mvc.dto.Electronics;
import mvc.exception.WrongInputException;

/**
 * 사용자의 요청을 키보드로 입력받는 클래스
 */


public class MenuView {
	Scanner sc = new Scanner(System.in);


	/**
	 * 전체 메뉴를 출력하는 메소드
	 */
	public void printMenu() {
			System.out.println(
					"----------------------------------------------------------------------------------------------------------");
			System.out.println("1. 전체검색  2. 모델번호검색  3.등록  4. 수정 5. 삭제  6.가격기준정렬 7. 모델번호정렬 8. 출력정렬변경 9. 종료");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------");

	}// 메소드끝
	
	/**
	 * 오름차순 / 내림차순 여부를 출력하는 메소드
	 * @param isDesc 내림차순 여부
	 */
	public void printSortState(boolean isDesc) {
		System.out.println(
				"----------------------------------------------------------------------------------------------------------");
		System.out.print("현재 정렬 상태 : ");
		if(isDesc)
    		System.out.println("내림차순");
    	else
    		System.out.println("오름차순");
    }

	
	
	/**
	 * 등록할때 키보드 입력을 처리하는 메소드 TODO : Input 받는 메소드 분리 ... 각 Input은 서로 다른 값을 수정하는 기능이고
	 * 이를 구분하는 것은 View가 아니라 비즈니스 모델의 역할이라고 생각됨
	 * 
	 * @throws WrongInputException
	 */
	public Electronics inputInsert() throws WrongInputException {
		try {
			System.out.print("모델번호는? ");
			int modelNo = Integer.parseInt(sc.nextLine());

			System.out.print("모델이름은? ");
			String modelName = sc.nextLine();

			System.out.print("모델가격은? ");
			int modelPrice = Integer.parseInt(sc.nextLine());

			System.out.print("모델설명은? ");
			String modelDetail = sc.nextLine();

			return new Electronics(modelNo, modelName, modelPrice, modelDetail);
			
		} catch (NumberFormatException e) 
		{
			sc.nextLine(); // Buffer 비우기
			throw new WrongInputException("잘못된 입력이 들어왔습니다.");
		}

	}

	public String menuInput() {
		System.out.print("메뉴선택 > ");
		String menu = sc.nextLine();
		return menu;
	}

	/**
	 * 모델번호에 해당하는 전자제품 검색하기 위해서 모델번호 키보드입력 처리하는 메소드
	 * @throws WrongInputException 
	 */
	public int inputSearch() throws WrongInputException {
		System.out.print("찾을 전자제품 모델번호는? ");
		int modelNo = 0;
		try{
			modelNo = Integer.parseInt(sc.nextLine());
			return modelNo;
		}catch (NumberFormatException e){
			throw new WrongInputException("잘못된 입력이 들어왔습니다.");
		}
	}

	/**
	 * 모델번호에 해당하는 설명을 수정하기 위해 키보드 입력처리하는 메소드
	 * 
	 * @throws WrongInputException
	 */
	public Electronics inputUpdate() throws WrongInputException {
		try {
			System.out.print("수정하려는 전자제품 모델번호는?? ");
			int modelNo = Integer.parseInt(sc.nextLine());

			System.out.print("변경하려는 모델설명은? ");
			String modelDetail = sc.nextLine();

			return new Electronics(modelNo, modelDetail);
		} catch (NumberFormatException e) {
			sc.nextLine(); // Buffer 비우기
			throw new WrongInputException("잘못된 입력이 들어왔습니다.");
		}

	}

	/**
	 * 모델번호에 해당하는 전자제품 삭제 위해서 모델번호 키보드입력 처리하는 메소드
	 * 
	 * @throws WrongInputException
	 */
	public int inputDelete() throws WrongInputException {
		System.out.print("삭제 할 전자제품 모델번호는? ");
		try {
			int modelNo = Integer.parseInt(sc.nextLine());
			return modelNo;
		} catch (NumberFormatException e) {
			sc.nextLine(); // Buffer 비우기
			throw new WrongInputException("잘못된 입력이 들어왔습니다.");
		}
	}

}