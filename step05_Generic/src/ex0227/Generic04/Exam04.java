package ex0227.Generic04;

import ex0227.generic03.Home;

public class Exam04 {

	public static void main (String args[]) {
		
		Exam04 a = new Exam04();
		Box<String> box1 = a.testMethod("ㅇ");
		Box<Integer> box2 = a.testMethod(123);
		Box<Double> box3 = a.testMethod(1.2);
		Box<Home> boxHome = a.testMethod(new Home());
		
	}
	
	public <T> Box<T> testMethod (T test) {
		
		Box<T> box = new Box<T>();
		box.setContent(test);
		
		return box;
	}
	
	
}
