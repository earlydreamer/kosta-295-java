package ex0226.board;



public class FreeBoard extends Board implements FreeBoardService {
	FreeBoard(){
		
	}
	
	public FreeBoard(int boardNo, String subject, String author, String content) {
		super(boardNo, subject, author, content);
		// TODO Auto-generated constructor stub
		
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
		
		return new FreeBoard(boardNo,"ㅇㅇㅇ","작성자","본문");
	}
	
}
