package ex0214.ex0214_박재현;
import java.util.*;

public class Test07WhileScanner {
	public static void main(String args[]) {
		/**
		 * 20250214
		 * 작성자 박재현
		 * 확인문제07
		 */

		boolean running = true;
		Scanner sc = new Scanner(System.in);
		int input = 0;
		int currentMoney = 0;

		while (running) {
			System.out.println("------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 입금 | 4.종료");
			System.out.println("------------------------------------");
			System.out.print("선택>");
			input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.print("예금액 : ");
				System.out.println(currentMoney);
				break;
			
			case 2:
				System.out.print("출금액> ");
				input = sc.nextInt();
				if (currentMoney >= input && input>0) {
					currentMoney-=input;
					System.out.println(input + "원 출금합니다. 잔고 :" + currentMoney);
					System.out.println();
				} else if (currentMoney < input)
					System.out.println("잔고가 부족합니다.");

				else
					System.out.println("잘못된 입력입니다");

				break;

			case 3:
				System.out.print("입금액> ");
				input = sc.nextInt();
				if (input > 0) {
					currentMoney += input;
					System.out.println(input + "원 입금합니다. 잔고 :" + currentMoney);
					System.out.println();
				} else
					System.out.println("잘못된 입력입니다");

				break;

			case 4:
				running = false;
				break;

			default:
				System.out.println("잘못된 입력입니다");
				break;
			}
		}

		System.out.println("프로그램 종료");

	}

}
