package ex0221.FinalEx;

//
//class FinalClass{
//
//	
//	
//	FinalClass(){
//		
//	}
//	
//	FinalClass(int i){
//		
//	}
//	
//	
//}



public class FinalFieldExam {

	int i;
	final int j; //생성자를 이용한 초기화가 가능하다 = 객체 생성 시점에 값 설정이 된다
	static final int k;
	
	public static void main (String args[]) {
//		test();
		
	}
	static {
//		FinalFieldExam.k=30; //FinalFieldExam.k가 이미 할당
		k=30;
	}
	
	
	public void test() {
		System.out.println (i);
		System.out.println (i);
		System.out.println (i);
		
		i=5;
//		j=50;
//		k=500;	
	}
	
	FinalFieldExam(){
		j=5;
		//k=10; //
	}
	FinalFieldExam(int i){
		j=i;
	}
}
