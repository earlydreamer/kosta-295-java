package report.lotto.views;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import report.lotto.models.LottoDto;

/**
 * View 클래스
 * 
 * @Author 박재현
 * 2025-03-03
 */
public class LottoView {

	Scanner sc = new Scanner(System.in);

	/*
	 * ------------- Print ----------------------------------
	 */

	public void printMenu() {
		System.out.println("------------------------------- 로또 번호 생성기 ---------------------------");
		System.out.println("1. 한줄 뽑기 | 2. 한장 뽑기 | 3. 여러 장 뽑기 | 4. 정렬 변경 | 9. 종료");
		System.out.println("----------------------------------------------------------------------------");
	}

	/**
	 * 생성된 로또 한줄을 파라미터로 받아 출력하는 메소드<br>
	 * View는 원본 객체가 무엇인지 직접 알 수 없다. 파라미터를 통해 넘어온 DTO의 형태로만 인식한다.<br>
	 * View단에서의 동작이 다른 계층에 영향을 주지 않으므로 MVC 원칙에 위배되지 않는다.<br>
	 * @param lotto (LottoDto) 생성된 로또 번호 한줄 (Integer 여섯 자리)
	 */
	public void oneLinePrint(LottoDto lotto, boolean isDesc) {
		System.out.println("----------------------------------------------------------------------------");
		System.out.print("로또 번호 : ");
		if (isDesc)
			System.out.println(lotto.getLottoNumber().reversed()); // 로또번호 TreeSet을 받아서 뒤집는다.
		else
			System.out.println(lotto.getLottoNumber());
		System.out.println("----------------------------------------------------------------------------");
	}

	/**
	 * 로또 한 페이지를 출력하는 메소드 <br>
	 * 단순 화면 갱신 역할만 하고, 데이터를 가공하는 로직은 LottoService에서 돈다.
	 * @param lottoPage (List) LottoDto 5개로 구성된 List
	 * @param isDesc    (boolean) 내림차순 여부
	 * @param page      (int) 출력하는 페이지 번호
	 */
	public void onePagePrint(List<LottoDto> lottoPage, boolean isDesc, int page) {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Page " + page);
		System.out.println("----------------------------------------------------------------------------");
		for (LottoDto lotto : lottoPage) {
			oneLinePrint(lotto, isDesc);
		}
		System.out.println("----------------------------------------------------------------------------");
	}

	/**
	 * 여러 페이지가 들어있는 로또 리스트를 출력하는 메소드
	 * @param lottoPages (List) LottoDto 리스트를 감싼 리스트가 들어있는 이중 리스트
	 * @param isDesc     (boolean) 내림차순 여부
	 */
	public void multiPagePrint(List<List<LottoDto>> lottoPages, boolean isDesc) {
		int currentPage = 1; // for문 돌리는 것보다 외부 선언하고 enhanced For 돌리는게 가독성이 나은 거 같다
		for (List<LottoDto> lottoPage : lottoPages) {
			onePagePrint(lottoPage, isDesc, currentPage++);
		}
	}

	public void wrongInputPrint() {
		System.out.println("잘못된 입력입니다.");
	}

	public void exitPrint() {
		System.out.println("종료합니다.");
	}
	
	public void toggleResultPrint(boolean isDesc) {
		if(isDesc)
			System.out.println("오름차순 정렬로 변경했습니다.");
		else
			System.out.println("내림차순 정렬로 변경했습니다.");
	}
	
	/*
	 * ------------- Input ----------------------------------
	 */

	/**
	 * 선택할 메뉴를 입력받아 리턴하는 메소드 <br>
	 * 화면을 출력하고 Input을 받는 부분까지만 수행하고 메뉴 번호를 리턴한다. <br>
	 * 메뉴의 동작은 LottoService에서 돈다.
	 * @return (int) 선택한 메뉴 번호
	 */
	public int inputMenuPrint() {
		System.out.println("----------------------------------------------------------------------------");
		System.out.print("선택하세요 >");
		int input = 0;
		try {// 스캐너가 View 안에 있으므로 스캐너에 대한 예외처리도 뷰 안에서 한다... (밖에서는 이 스캐너를 모른다)
			input = sc.nextInt();
		} catch (InputMismatchException e) {
			wrongInputPrint();
			sc.nextLine(); // 버퍼 비우기
			return -1;
		}
		return input;
	}

	/**
	 * 뽑을 페이지수를 입력받아 리턴하는 메소드  <br>
	 * 화면을 출력하고 Input을 받는 부분까지만 수행하고 페이지수를 리턴한다. <br>
	 * 생성하는 로직은 LottoService에서 돈다. 
	 * @return (int) 로또의 페이지 수
	 */
	public int inputPagePrint() {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("몇 장 뽑으시겠습니까?");
		System.out.print("출력할 페이지 수 >");
		int input = 0;
		try {// 스캐너가 View 안에 있으므로 스캐너에 대한 예외처리도 뷰 안에서 한다... (밖에서는 이 스캐너를 모른다)
			input = sc.nextInt();
		} catch (InputMismatchException e) {
			wrongInputPrint();
			sc.nextLine(); // 버퍼 비우기
			return -1;
		}
		return input;
	}
}
