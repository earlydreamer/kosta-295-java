package ex0214;

public class ForExam01 {
	/*
	 For문 예제	 
	 작성자_박재현
	 20250214
	 	 
	 */


	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*		
		//1. 1~ 100가지 한줄로 출력
		for (int i = 1; i <= 100; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println();

		//2. A ~Z 까지 한줄로 출력
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i + " ");
		}

		System.out.println();
		System.out.println();

		//3. 1~ 10 까지 합 구해서 출력
		int cnt = 0;
		for (int i = 1; i <= 10; i++) {
			cnt = cnt + i;
		}
		System.out.println(cnt);
		System.out.println();

		//4. 1 ~ 100 사이의 7의 배수만 출력
		for (int i = 1; i <= 100; i++) {
			if (i % 7 == 0) {
				System.out.println(i);
			}
		}

		System.out.println();
		
		//5. 100 ~ 1 사이의 5 의 배수만 출력
		for (int i = 100; i >= 1; i--) {
			if (i % 5 == 0) {
				System.out.println(i);
			}

		}

*/

		System.out.println();
		
		//1. 1 ~ 100가지 10행 10열로 출력 (for문 안에 for문이용) 
		for (int i = 0; i < 10; i++) {
			for (int j = 1; j <= 10; j++)
				System.out.print(((i * 10) + j) + "	");
			System.out.println();
		}
		
		System.out.println();
		//2. 1 ~ 100가지 10행 10열로 출력 (for문 안에 if문이용)
		for (int i = 1; i <= 100; i++) {
			System.out.print(((i)) + "	");
			if(i%10==0)
				System.out.println();
		}
		
		System.out.println();		

		//3. 구구단 출력 - for 문안에 for문 이용
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++)
				System.out.println (i + " * " + j + " = " + i*j);
			System.out.println();
		}
		
		
	
		
		
	}
}
