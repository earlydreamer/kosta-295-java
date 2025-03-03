package report.lotto.services;

import java.util.List;
import report.lotto.models.*;

/**
 * 메뉴의 기능을 정의하는 Interface
 * @author 박재현
 * 2025-03-03
 */
public interface LottoMenuControl {
	/**
	 * 한줄짜리 로또를 생성 / 한줄당 번호는 6개<br>
	 * @return (LottoDto) 생성된 로또
	 */
	LottoDto oneLineGen();
	
	/**
	 * 한페이지짜리 로또를 생성 / 한페이지당 로또는 5줄
	 * @return (ArrayList) 생성된 로또의 List
	 */
	List<LottoDto> onePageGen();
	
	/**
	 * 몇 페이지를 뽑을지 입력받아 여러 페이지의 로또를 생성 
	 * @return lottoPages (ArrayList) 로또 번호 리스트를 담은 이중 리스트
	 */
	List<List<LottoDto>> multiPageGen();

	/**
	 * 오름차순 / 내림차순 정렬 상태를 반대로 토글
	 * @param isDesc (boolean) 내림차순 정렬 여부
	 * @return (boolean) isDesc의 반대
	 */
	boolean sortToggle(boolean isDesc);

	/**
	 * 종료 화면을 출력하고 false를 반환
	 * @return (boolean) false
	 */
	boolean exit();
	
}
