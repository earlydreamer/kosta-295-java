package ex0226.board;

/**
 * 모든 게시판 유형들이 공통으로 사용하는 속성을 관리
 * (글번호, 제목, 작성자, 내용)
 * DTO / VO
 */
public abstract class Board implements BoardService{
	private int boardNo;
	private String subject;
	private String author;
	private String content;
	
	public Board() {
		
	}

	public Board(int boardNo, String subject, String author, String content) {
		super();
		this.boardNo = boardNo;
		this.subject = subject;
		this.author = author;
		this.content = content;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("boardNo=");
		builder.append(boardNo);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", author=");
		builder.append(author);
		builder.append(", content=");
		builder.append(content);
		builder.append(",");
		return builder.toString();
	}

	
	
}
