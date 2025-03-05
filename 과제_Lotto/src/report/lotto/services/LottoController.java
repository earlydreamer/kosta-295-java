package report.lotto.services;

import java.util.ArrayList;
import java.util.List;

import report.lotto.models.LottoDto;
import report.lotto.views.LottoView;

/**
 * 로또 컨트롤러 
 * @author 박재현
 * 2025-03-03<br>
 */

//TODO : 서비스 로직 분리
//TODO : 메소드 파일 기능별로 개별 클래스로 분리
public class LottoController implements LottoMenuControl{

	LottoView view = new LottoView();
	LottoNumberGenerator generator = new LottoNumberGenerator();
	
	boolean isDesc = true;//내림차순 여부

	public LottoController() {
		lottoMenu();
	}

	/**
	 * 메뉴 로직
	 */
	void lottoMenu() {
		boolean isRunning = true;
		int input = 0;
		while (isRunning) {
			view.printMenu();
			input = view.inputMenuPrint();
			switch (input) {
			case 1 -> view.oneLinePrint(oneLineGen(), isDesc);
			case 2 -> view.onePagePrint(onePageGen(), isDesc, 1);
			case 3 -> view.multiPagePrint(multiPageGen(), isDesc);
			case 4 -> isDesc = sortToggle(isDesc);
			case 9 -> isRunning = exit();
			}
		}
	}


	@Override
	public LottoDto oneLineGen() {
		return new LottoDto(generator.numberGenerate());
	}


	@Override
	public List<LottoDto> onePageGen() {
		final int LINE_PER_PAGE = 5;
		ArrayList<LottoDto> lottoPage = new ArrayList<LottoDto>();
		for (int i = 0; i < LINE_PER_PAGE; i++)
			lottoPage.add(new LottoDto(generator.numberGenerate()));
		return lottoPage;
	}


	@Override
	public List<List<LottoDto>> multiPageGen() {
		int page = view.inputPagePrint();
//		리스트의 리스트를 이용하는 방법 별로 예쁘지 않은것 같은데...
//		TODO : 이중 리스트 말고 좋은 방법 생각나면 리팩토링
		ArrayList<List<LottoDto>> lottoPages = new ArrayList<List<LottoDto>>();
		for (int i = 0; i < page; i++) {
			lottoPages.add(onePageGen());
		}
		return lottoPages;
	}
	

	@Override
	public boolean sortToggle(boolean isDesc) {
		view.toggleResultPrint(isDesc);
		return !isDesc;
	}
	

	@Override
	public boolean exit() {
		view.exitPrint();
		return false;
	}

}
