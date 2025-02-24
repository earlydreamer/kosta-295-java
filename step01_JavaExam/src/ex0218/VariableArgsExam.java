package ex0218;

public class VariableArgsExam {

//	public void test(int ... param1 ) {
		public void test(Object ... param1 ) {
		
		//System.out.println(param1[0]);
		
		for(int i =0; i<param1.length;i++) {
			System.out.print(param1[i]);
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VariableArgsExam v = new VariableArgsExam();
		
		v.test(1);
		v.test(2,3);
		v.test(3,4,5);
		
		
		
	}

}
