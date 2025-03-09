package mvc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import mvc.dto.Electronics;
import mvc.exception.DuplicatedIdFoundException;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.FileIoFailException;
import mvc.exception.SearchNotFoundException;
import mvc.dao.FileStreamDao;
import mvc.dao.FileStreamDaoImpl;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

public class ElectronicsServiceImpl implements ElectronicsService {

	private static ElectronicsService instance = new ElectronicsServiceImpl();
	private FileStreamDao dao;

	private boolean isDesc = false;
	// 정렬 출력에 사용될 오름차순-내림차순 여부.
	// 서비스가 돌고 있는 중에 서비스 내에서만 임시로 사용되는 상태이므로 서비스 내에 static 선언...

	/**
	 * 외부에서 객체 생성안됨.
	 */
	private ElectronicsServiceImpl() {
		dao = FileStreamDaoImpl.getInstance();	
	}
	
	/**
	 * 생성자를 통한 의존성 주입 (외부에서 dao를 세팅할 수 있도록)
	 * @param dao
	 */

	private ElectronicsServiceImpl(FileStreamDao dao) {
		this.dao = dao;
	}

	public static ElectronicsService getInstance() {
		return instance;
	}

	/*
	 * -----------------------------------------------------------------------------
	 */

	@Override
	public void insert(Electronics electronics) throws ElectronicsArrayBoundsException, DuplicatedIdFoundException, FileIoFailException {
		dao.insertElectronics(electronics);
	}

	@Override
	public List<Electronics> selectAll() throws FileIoFailException {
		ArrayList<Electronics> list = dao.loadAllElectronics();
		return list;// 현재 리스트를 그대로 반환
	}

	@Override
	public List<Electronics> selectSortByModelNo() throws FileIoFailException {
		ArrayList<Electronics> returnList = dao.loadAllElectronics();
		Collections.sort(returnList, (o1, o2) -> o1.getModelNo() - o2.getModelNo()); // 모델번호 기준으로 오름차순 정렬
		if (isDesc) // 내림차순일 경우 리스트를 뒤집어서 리턴
			Collections.reverse(returnList);
		return returnList;

	}

	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException, FileIoFailException {
		Electronics electronics = dao.searchByModelNo(modelNo);
		return electronics;
	}

	@Override
	public void update(Electronics newElec) throws SearchNotFoundException, FileIoFailException {
		//전달받은 객체를 기반으로 새로운 객체를 생성해 dao에 업데이트 요청
		
		Electronics oldElec = searchByModelNo(newElec.getModelNo());
		Electronics returnElec = new Electronics(newElec.getModelNo(),oldElec.getModelName(),oldElec.getModelPrice(),newElec.getModelDetail());
		
		dao.updateElectronics(returnElec);
	}

	@Override
	public void delete(int modelNo) throws SearchNotFoundException, FileIoFailException {
		dao.deleteElectronics(modelNo);
	}

	@Override
	public List<Electronics> selectSortByPrice() throws FileIoFailException {
		// 다중조건정렬 thenComparing 안배웠으니까 바디를 만들어서 구현하자
		List<Electronics> returnList = new ArrayList<Electronics>(dao.loadAllElectronics());
		Collections.sort(returnList, (o1, o2) -> { // lambda 이용한 구현
			// 이중정렬이라 최종결과를 그냥 뒤집으면 결과가 이상해질수 있다 처음부터 각각 오름차순 내림차순 설정에 따라 돌도록 만들자...
			if (o1.getModelPrice() == o2.getModelPrice())
				if (isDesc)
					return o2.getModelNo() - o1.getModelNo();// 내림차순 설정되어있을때 가격이 같으면 ModelNo순으로 내림차순 정렬
				else
					return o1.getModelNo() - o2.getModelNo();// 가격이 같으면 ModelNo순으로 오름차순 정렬
			else if (isDesc)
				return o2.getModelPrice() - o1.getModelPrice();// 내림차순 설정되어 있을때 가격순으로 내림차순 정렬
			else
				return o1.getModelPrice() - o2.getModelPrice();// 기본적으로 가격순으로 오름차순 정렬
		});
		return returnList;
	}

	@Override
	public boolean sortToggle() {
		this.isDesc = !isDesc;
		return isDesc;
	}

	@Override
	public boolean getSortState() {
		return this.isDesc;
	}

} // 클래스 끝