package ex0214;

public class BreakContinueExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * for(int i=1;i<=3;i++) { for(int j=1;j<=5;j++) {
		 * 
		 * System.out.print(j); } System.out.println(""); }
		 * System.out.println("--end--");
		 */

		//구구단 출력 /5단Stop
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if(i==5)
					break;
				System.out.println (i + " * " + j + " = " + i*j);
			}
			System.out.println();
		}
		
		
		  
	}

	
	
}
