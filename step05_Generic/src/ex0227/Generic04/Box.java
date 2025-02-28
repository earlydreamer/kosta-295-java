package ex0227.Generic04;

public class Box<T> {
	private T Content;

	public T getContent() {
		return Content;
	}

	public void setContent(T content) {
		Content = content;
	}
	
	public <A,B,F> T test(A test, F test2) {
		
		return Content;
		
	}
	public <F> F test02() {
//		return "ㅇㅇ"; //Generic은 사용할 때 파라미터의 구체적인 타입을 결정한다 ( = 이 메소드가 사용될 때 결정되어야 한다)
		//리턴 타입이 Generic하지 않고 String으로 고정되므로 Generic의 성질에 위배된다.
		//return (F) "ㅇㅇ"; 
		//호출시점에 어떤 자료형이 올지는 모르지만 어쨌거나 Generic하게 들어오는 타입에 맞춰 캐스팅해주면 컴파일 에러는 안 난다. 
		//다만 런타임에 에러가 날 수 있다
		return null; //그러니까 이 메소드는 망한 예제다
	}
}
