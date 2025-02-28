package ex0226.board;

/**
 * QA에 관련된 속성을 관리하는 객체
 * 답변여부에 해당하는 멤버필드 추가
 */
public class QaBoard extends Board implements QaBoardService {

	private boolean hasReply;	
	
	QaBoard(){
		
	}

	public QaBoard(int boardNo, String subject, String author, String content, boolean hasReply) {
		super(boardNo, subject, author, content);
		this.hasReply = hasReply; 

	}

	public boolean isHasReply() {
		return hasReply;
	}

	public void setHasReply(boolean hasReply) {
		this.hasReply = hasReply;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("hasReply=");
		builder.append(hasReply);
		return builder.toString();
	}

	
	
	public int update(Board board) {
		System.out.println("Update");
		return 0;
		
	}
	
	public int insert(Board board) {
		System.out.println("Insert");
		return 0;
		
	}
	
	public Board selectByBoardNo(int boardNo) {
		
		return new QaBoard(boardNo,"ㅇㅇㅇ","작성자","본문", hasReply);
	}
	

}
