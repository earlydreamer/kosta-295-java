package ex0305.report.view;


/**
 * 메인 메소드
 * @author 박재현
 * 2025-03-06
 */
import ex0305.report.controller.Controller;

public class Main {
	
	public static void main(String[] args) {
		new Controller(); //Controller의 생성자를 호출한다. 연관된 생성자들이 호출되며 차례대로 초기화된다.
	}

}
