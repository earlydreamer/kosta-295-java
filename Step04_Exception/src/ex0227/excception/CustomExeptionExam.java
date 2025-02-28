package ex0227.excception;



class TestException extends Exception{
	
	public TestException(String message){
		super(message);
	}

	public TestException() {
		// TODO Auto-generated constructor stub
	}
}


/**
 * 사용자 지정된 Exception을 만드는 예제
 */
public class CustomExeptionExam {
	public static void main(String args[]) {
		new TestException("test");
		
	}
}
