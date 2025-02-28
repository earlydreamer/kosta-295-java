package ex0214.ex0214_박재현;

public class Test02SwitchExpression {
	public static void main(String args[]) {
		/**
		 * 20250214
		 * 작성자 박재현
		 * 확인문제02
		 */
		
		String grade = "B";
		int score1 = switch (grade) {
		case "A" -> 100;
		case "B" -> {
			int result = 100 - 20;
			yield result;
		}
		default -> 60;
		};

	}
}
