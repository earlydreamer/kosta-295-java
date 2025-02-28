package ex0227.excception;

public class ThrowsExam {
	
	public void methodA(int i) {
		System.out.println("AA Called");
//		try {
		this.methodB(i); //
		
//		}catch(ArithmeticException e) {
//			System.out.println(e);
//		}
		
		System.out.println("AA End");
		
	}
	
	
	
	public void methodB(int i) throws ArithmeticException, NullPointerException{
		System.out.println("BB Called");
		
		try {
		int result = 100/i; //ArithmeticException 발생 가능성
		
		System.out.println("결과... " +result);} finally {				
		System.out.println("BB End");
		
		}// Finally는 혼자서 단독 사용할 수 없다 (Catch는 없어도 되지만 try는 있어야 한다)

	}
	
	
	public static void main (String args[]) {
	
		System.out.println("--- Main 시작 ---");
		ThrowsExam sample = new ThrowsExam();
		try{
//		sample.methodA(1);
		sample.methodA(0);
		}catch(ArithmeticException | NullPointerException e){
			System.out.println("Main에서 예외처리");
		}
		
		
		
		
		System.out.println("Main End");
		
		
	}
}
