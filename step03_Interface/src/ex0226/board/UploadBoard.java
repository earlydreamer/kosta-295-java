package ex0226.board;

public class UploadBoard extends Board implements UploadBoardServiceImpl{

	private String fileName;
	
	UploadBoard(){
		
	}

	public UploadBoard(int boardNo, String subject, String author, String content, String fileName) {
		super(boardNo, subject, author, content);
		this.fileName=fileName;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("UploadBoard [fileName=");
		builder.append(fileName);
		builder.append("]");
		return builder.toString();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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
		
		return new UploadBoard(boardNo,"ㅇㅇㅇ","작성자","본문",fileName);
	}
	

	
}
