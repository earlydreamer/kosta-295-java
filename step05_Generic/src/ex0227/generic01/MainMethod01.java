package ex0227.generic01;

public class MainMethod01 {
	
	public static void main (String args[]) {
		
//		Box box = new Box();
//		box.setContent("ㅇㅅㅇㅇㅅㅇㅇㅅㅇㅇㅅㅇ");
//		
//		Object content = box.getContent();
//		if(content instanceof String s) {//Object 타입을 사용하면 타입캐스팅을 매번 해줘야 한다...
//			int index = s.indexOf("ㅅ");
//			System.out.println(index);
//		}
		
		Box<String> box1 = new Box<String>();
		box1.setContent("dddddd");
		String st1 = box1.getContent();
		
		System.out.println(st1);
		
		//Wrapper 클래스의 동작 (Java 1.5 버전부터 추가)
		Integer it = 1; //Auto-Boxing
		int i = it; //Auto-Unboxing
		
//		Box<int> box2; //Generic은 객체로만 선언가능
		Box<Integer> box2 = new Box<>(); //Wrapper 클래스를 통해 Generic 선언함 
		box2.setContent(123);// 내부적으로 Integer 객체지만...
		box2.getContent(); //Integer 타입으로 취급되지만...
		int box = box2.getContent(); //int형에 넣을 수 있다 (Auto-Unboxing)
		
		Box<Board> box3 = new Box<>(); //객체도 넣을수있다...
		box3.setContent(new Board());
		Board b = box3.getContent(); 
		
		
		
		
		
	}

}
