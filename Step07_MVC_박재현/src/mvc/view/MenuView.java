package mvc.view;

import java.util.Scanner;

import mvc.controller.ElectronicsController;
import mvc.dto.Electronics;

/**
 * 사용자의 요청을 키보드로 입력받는 클래스
 */

//View가 Model을 직접 알지 않고 데이터를 저장하거나 관리하는 로직도 없어서 일단 MVC에 부합하지 않는 형태는 아닌것 같은데
//View를 뿌린 다음 응답에 대한 Listen을 하고 있는 건 컨트롤러니까 while 루프 로직은 컨트롤러에 있는게 예쁘지 않나...
//View가 로직을 어디까지 들고있어도 되는지 모르겠다... 클라이언트의 MVC와 개념의 혼동이 오는데

public class MenuView {
	Scanner sc = new Scanner(System.in);
	ElectronicsController controller = new ElectronicsController(); // 전역변수 초기화, 생성자 호출

	/**
	 * 전체 메뉴를 출력하는 메소드
	 */
	public void printMenu() {

		while (true) {
			System.out.println("----------------------------------------------------------------------------------------------------------");
			System.out.print  ("현재 정렬 상태 : " ); controller.sortState();
			System.out.println("----------------------------------------------------------------------------------------------------------");
			System.out.println("1. 전체검색  2. 모델번호검색  3.등록  4. 수정 5. 삭제  6.가격기준정렬 7. 모델번호정렬 8. 출력정렬변경 9. 종료");
			System.out.println("----------------------------------------------------------------------------------------------------------");
			System.out.print("메뉴선택 > ");

			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				controller.selectAll();
				break;
			case "2":
				this.inputSearch();
				break;
			case "3":
				this.inputInsert();
				break;
			case "4":
				this.inputUpdate();
				break;
			case "5":
				this.inputDelete();
				break;
			case "6":
				controller.selectSortByPrice();
				break;
			case "7":
				controller.selectSortByModelNo();
				break;
			case "8":
				controller.sortToggle();
				break;
			case "9":
				System.exit(0);
			default:
				System.out.println("메뉴를 다시 선택해주세요!!!!");

			}// switch문끝

		} // while문끝
	}// 메소드끝



	/**
	 * 등록할때 키보드 입력을 처리하는 메소드
	 * TODO : Input 받는 메소드 분리 ... 각 Input은 서로 다른 값을 수정하는 기능이고 이를 구분하는 것은 View가 아니라 비즈니스 모델의 역할이라고 생각됨
	 */
	public void inputInsert() {
		try {
		System.out.print("모델번호는? ");
		int modelNo = Integer.parseInt(sc.nextLine());

		System.out.print("모델이름은? ");
		String modelName = sc.nextLine();

		System.out.print("모델가격은? ");
		int modelPrice = Integer.parseInt(sc.nextLine());

		System.out.print("모델설명은? ");
		String modelDetail = sc.nextLine();

		controller.insert(new Electronics(modelNo, modelName, modelPrice, modelDetail));
		}catch (NumberFormatException e) //Exception 처리 안되어있어서 일단 NumberFormatException만... 
		{// 지금 구조에서는 검증에 다른 layer가 개입할 필요 없으므로 throws가 필요 없다. 이 Scanner는 View 내에서 호출된 것이며 Controller를 타지 않는다
//			System.out.println(e.getMessage()); //getMessage는 NumberFormatException의 기본 Message를 반환한다.
			System.out.println("잘못된 입력입니다."); //어떤 요청에 대한 응답이 아니라 이 View 내부 처리의 일부이므로... FailView를 쓰지 않고 직접 출력...
		}

	}

	/**
	 * 모델번호에 해당하는 전자제품 검색하기 위해서 모델번호 키보드입력 처리하는 메소드
	 */
	public void inputSearch() {
		System.out.print("찾을 전자제품 모델번호는? ");
		int modelNo = Integer.parseInt(sc.nextLine());
		controller.searchByModelNo(modelNo);

	}

	/**
	 * 모델번호에 해당하는 설명을 수정하기 위해 키보드 입력처리하는 메소드
	 */
	public void inputUpdate() {
		try {
		System.out.print("수정하려는 전자제품 모델번호는?? ");
		int modelNo = Integer.parseInt(sc.nextLine());

		System.out.print("변경하려는 모델설명은? ");
		String modelDetail = sc.nextLine();

		controller.update(new Electronics(modelNo, modelDetail));
		}catch(NumberFormatException e){ //inputInsert와 동일한 방식의 처리
//			System.out.println(e.getMessage());
			System.out.println("잘못된 입력입니다.");			
		}

	}

	/**
	 * 모델번호에 해당하는 전자제품 삭제 위해서 모델번호 키보드입력 처리하는 메소드
	 */
	public void inputDelete() {
		System.out.print("삭제 할 전자제품 모델번호는? ");
		try {
		int modelNo = Integer.parseInt(sc.nextLine());
		controller.deleteModelNo(modelNo);
		}catch(NumberFormatException e){ //inputInsert와 동일한 방식의 처리
//			System.out.println(e.getMessage());
			System.out.println("잘못된 입력입니다.");			
		}
	}
    
}