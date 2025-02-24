package ex0214.ex0214_박재현;

public class Test05WhileExam {
	public static void main(String args[]) {
		/**
		 * 20250214
		 * 작성자 박재현
		 * 확인문제05
		 */

		int calc = 0;
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				calc = (4 * i) + (5 * j);
				if (calc == 60)
					System.out.println("(" + i + "," + j + ")");
			}
		}
	}
}
