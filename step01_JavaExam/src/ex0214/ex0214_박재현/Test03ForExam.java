package ex0214.ex0214_박재현;

public class Test03ForExam {
	/**
	 * 20250214
	 * 작성자 박재현
	 * 확인문제03
	 */
	
	public static void main (String args[]) {
		
		int count=0;
		for(int i=1;i<=100;i++) {
			if(i%3==0)
				count+=i;		
			
		}	
		System.out.println(count);
	}

}
