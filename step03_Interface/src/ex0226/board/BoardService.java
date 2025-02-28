package ex0226.board;

import java.util.List;

/**
 * 모든 게시판이 공통으로 사용할 기능
 */
public interface BoardService {
	
	/**
	 * 글 등록하기
	 * @return : (int) 0 = 실패 / 1 = 성공
	 */
	public int insert(Board boardDto);
	
	/**
	 * 글 수정하기
	 */
	public int update(Board boardDto);
	
	/**
	 * 검색하기
	 * @param (int) BoardNo 글번호
	 * @return (Board) 해당 글 번호의 게시물
	 */
	public Board selectByBoardNo(int BoardNo);

	
	/**
	 * Java 1.8 추가
	 * Interface 내부 메소드의 Static 또는 Default 제한자를 추가하면
	 * body가 있는 메소드를 만들 수 있다
	 * body가 있는 메소드는 구현 객체들이 재정의를 선택적으로 할 수 있다 (Default 역할을 해준다...)
	 * static -> 구현객체없이 바로 Interfacename.메소드명() 으로 호출 가능함
	 * Default -> 반드시 구현객체가 있어야 호출할 수 있다
	 */
	
	public default boolean delete(int boardNo) {
		//Override가 없을 경우 동작 없이 false를 리턴한다
		return false;
	}
	
	static List<Board> selectAll() {
		
		return null;
	}
	
	
}
