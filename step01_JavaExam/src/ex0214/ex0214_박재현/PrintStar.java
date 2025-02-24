package ex0214.ex0214_박재현;

public class PrintStar {
	
	public static void main (String args[])
	{
		/**
		 * 20250214
		 * 작성자 박재현
		 * 별찍기
		 */
		
		for(int i =1;i<6;i++) {
			for(int j=1;j<6;j++)
			{
				if(i>=j)
					System.out.print("★");
				else
					System.out.print("　");
			}
			System.out.println();
		}
		
		System.out.println("***********************************");

		for(int i=6;i>1;i--) {
			for(int j=1;j<6;j++)
			{
				if(i<=j)
					System.out.print(" ");
				else
					System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("***********************************");

		for(int i =6;i>1;i--) {
			for(int j=1;j<=6;j++)
			{
				if(i<=j)
					System.out.print("★");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
				
		System.out.println("***********************************");
		for(int i =1;i<6;i++) {
			for(int j=1;j<=6;j++)
			{
				if(i>=j)
					System.out.print(" ");
				else
					System.out.print("★");
			}
			System.out.println();
		}
		

		
	}



}
