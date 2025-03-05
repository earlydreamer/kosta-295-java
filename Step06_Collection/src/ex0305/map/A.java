package ex0305.map;

//Map은 Inner로 선언되어있다...
//Inner클래스 예제

public class A {
	//Inner Class는 OuterClass이름$InnerClass이름 형식으로 저장
	int i=10;
	public void aa() {
		
	}

	class B{
		int i=5;
		public void bb(){
			System.out.println(i);
			System.out.println(this.i);
			System.out.println(A.this.i); //이름이 같을경우 Outer클래스 이름.this.변수명 을 이용해서 호출
	
		}
	}

}


