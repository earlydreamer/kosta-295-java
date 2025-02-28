package ex0218;

public class StaticEx {
	
	public static void main (String args[]) {
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();
		
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		
		System.out.println(t1.a);
		System.out.println(t2.a);
		System.out.println(t3.a);

		t2.a=100;
		
		System.out.println(t1.a);
		System.out.println(t2.a);
		System.out.println(t3.a);
		
		//---
		t2.b=50;
		System.out.println(t1.b);
		System.out.println(t2.b);
		System.out.println(t3.b);
		
		}
		
	}
	
	


class Test{
	
	int a;
	static int b;
	

}


