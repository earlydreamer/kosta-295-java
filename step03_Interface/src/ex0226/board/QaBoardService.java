package ex0226.board;

public interface QaBoardService extends BoardService{

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
	
	default boolean delete(int boardNo) {
		System.out.println("삭제...");
		return true;
	}
		

}

