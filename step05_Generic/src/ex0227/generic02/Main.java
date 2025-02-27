package ex0227.generic02;

public class Main {

	public static void main (String args[]) {
		Product <TV, String> p1 = new Product<TV,String>();
		
		p1.setKind(new TV());
		p1.setModel("MODEL1");
		
		System.out.println(p1.getModel());
		
		Product<Audio,Integer> p2 = new Product<Audio,Integer>();
		
		p2.setKind(new Audio());
		p2.setModel(100);
		
		System.out.println(p2.getModel());

		
		
	}
	
	
}
