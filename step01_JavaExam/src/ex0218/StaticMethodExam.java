package ex0218;

public class StaticMethodExam {

	int a=5;
	static int b=10;

	//non-static 영역 안에서 static, non-static 모두 접근 가능
	public void aa() {
		System.out.println(a);
		System.out.println(this.a);
		System.out.println(b);
		System.out.println(this.b);
		System.out.println(StaticMethodExam.b);
		
		bb();
		this.bb();
		
		dd();
		this.dd();
		StaticMethodExam.dd();
		 
	}
	public void bb() {
		System.out.println(a);
		System.out.println(this.a);
		System.out.println(b);
		System.out.println(this.b);
		System.out.println(StaticMethodExam.b);
		
		bb();
		this.bb();
		
		dd();
		this.dd();
		StaticMethodExam.dd();
		
		
	}
	
	//static 메소드안에서 non-static 접근 불가 / this 사용 불가능
	public static void cc() {
//		System.out.println(a);
//		System.out.println(this.a);
		System.out.println(b);
//		System.out.println(this.b);
		System.out.println(StaticMethodExam.b);

//		bb();
//		this.bb();
		
		dd();
//		this.dd();
		StaticMethodExam.dd();

		
		
	}
	
	public static void dd() {
//		System.out.println(a);
//		System.out.println(this.a);
//		System.out.println(b);
//		System.out.println(this.b);
		System.out.println(StaticMethodExam.b);
		
//		bb();
//		this.bb();
		
		dd();
//		this.dd();
		StaticMethodExam.dd();

		
	}
	
	//Static-Initialize
	//main보다 먼저 실행되는
	static {
		//시작 전 환경 세팅 등
		//db연동 등... 
		//클래스 내부에 작성하지만 메소드, 생성자 안에는 작성 불가능함
	System.out.println("Static init");	
		
		
	}
	
	
	public static void main(String[] args) {
	
		System.out.println("Main Start");
		//main에서는 멤버 필드에 접근이 안된다
		//a = 1; 
		//this.aa();
		//aa();
		//static에는 접근이 된다
		//b=1;
		//static으로 선언된 메소드는 호출이 가능하다
		//cc();
		
	
		
		
	}

}
