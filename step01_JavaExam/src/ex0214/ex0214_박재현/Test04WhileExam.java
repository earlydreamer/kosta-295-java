package ex0214.ex0214_박재현;

public class Test04WhileExam {

	public static void main(String args[]) {
		/**
		 * 20250214
		 * 작성자 박재현
		 * 확인문제04
		 */

		int dice1 = 0;
		int dice2 = 0;
		int diceTotal = 0;
		while (true) {
			if (diceTotal == 5)
				break;
			dice1 = (int) (Math.random() * 6) + 1;
			dice2 = (int) (Math.random() * 6) + 1;
			diceTotal = dice1 + dice2;
			System.out.println("(" + dice1 + "," + dice2 + ")");
		}
	}
}
