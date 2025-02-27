package ex0227.shoppingException;

public class View {	
	
	/**
	 * 방문객 객체를 받아옴...
	 * @param visitor (Visitor) 방문객
	 */
	public void printAge(Visitor visitor) {
		System.out.println("방문객의 나이 : " +visitor.getAge());
	}
	
	public void visitSuccess() {
		System.out.println("방문하신 것을 환영합니다.");
	}
	
	public void printExceptionCount(int i) {
		System.out.println("예외횟수 : "+i);
	}
	
	public void printExceptionMessage(Exception e) {
		System.out.println(e.getMessage());
	}
	
	/**
	 * 쇼핑몰 View 생성자
	 */
	View(){
		System.out.println("쇼핑몰 Class의 View");
		
	}
	
	
	
	

}
