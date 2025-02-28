package ex0226.board;

public class TestMain {
	
	BoardService service; //FreeboardImpl QaBoardImpl UploadBoardImpl
	Board board; //FreeBoard QaBoard UploadBoard
		
	public static void main (String args[]){
	
		System.out.println ("------------------- Test ----------------- ");
		new TestMain(); 
		// main이 Static void니까... 객체생성 없이 Main에 바로 접근해서 생성자가 안불러졌을것

		
	}
	
	public TestMain(){		
		
		service = new FreeBoard();
		board = new FreeBoard(100,"ㅇㅇㅇ","ㅇㄱㅇ","ㅁㅁㅁㅁ");
		test(service,board);
		
		service = new QaBoard();
		board = new QaBoard(100,"ㅁㅁㅁ","ㅅㅅㅅ","ㅎㅎㅎㅎ",true);
		test(service,board);

		service = new UploadBoard();
		board = new UploadBoard(100,"ㅅㅅㅅ","ㅌㅌㅌ","ㄱㄱㄱㄱ","ㅇㅎㅇㄹ");
		test(service,board);
		
		
	}
	
	private void test(BoardService service, Board board) {
		// TODO Auto-generated method stub
		service.insert(board);
		service.update(board);
		
		service.selectByBoardNo(100);
		service.delete(100); //Delete가 오버라이딩 된 클래스에서만 동작한다
		
		BoardService.selectAll();//인터페이스의 Static 메소드 호출
		
	}

	public void Test(BoardService service) {
		//각 게시판의 기능을 호출해봅시다
		service.insert(board);
		service.update(board);
		
		service.selectByBoardNo(2);
		System.out.println("--------------------------------------------");



	}

}
