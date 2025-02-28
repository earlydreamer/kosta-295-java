package ex0213.제어문;

public class IfExam01 {
	
	public static void main (String args[]) {
		
		//그 머시기냐 메인 메소드
		
		
		int v;
		v=(int)(Math.random()*100)+1;

		System.out.print(v+": ");
		if(v%2!=0) {
			System.out.println("홀수");
						
		}
		else {
			System.out.println("짝수");
		}
				
		
	}

}
