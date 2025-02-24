package ex0214;

public class WhileExam01 {

	public static void main(String args[]) {

		// 1. 1~ 100가지 한줄로 출력
		int cnt = 1;
		while (true) {
			if (cnt > 100)
				break;
			System.out.print(cnt + " ");
			cnt++;
		}

		System.out.println();
		System.out.println();

		// 2. A ~Z 까지 한줄로 출력

		char ch = 'A';
		while (true) {
			if (ch > 'Z')
				break;
			System.out.print(ch + " ");
			ch++;
		}

		System.out.println();
		System.out.println();

		// 3. 1~ 10 까지 합 구해서 출력

		cnt = 0;
		int cnt2 = 0;
		while (true) {
			if (cnt >= 10)
				break;
			cnt++;
			cnt2 += cnt;
		}
		System.out.println(cnt2);
		System.out.println();

		// 4. 1 ~ 100 사이의 7의 배수만 출력

		cnt = 1;
		while (true) {
			if (cnt > 100)
				break;
			if (cnt % 7 == 0)
				System.out.println(cnt);

			cnt++;
		}

		System.out.println();
		System.out.println();

		// 5. 100 ~ 1 사이의 5 의 배수만 출력

		cnt = 100;
		while (true) {
			if (cnt == 0)
				break;
			if (cnt % 5 == 0)
				System.out.println(cnt);
			cnt--;

		}

		System.out.println();
		System.out.println();

		// 1. 1 ~ 100가지 10행 10열로 출력 (for문 안에 for문이용)

		int i = 0;
		int j = 1;
		while (true) {
			if (i >= 10)
				break;
			while (true) {
				if (j > 10)
					break;
				System.out.print((i * 10 + j) + "	");
				j++;
			}
			i++;
 			j = 1;
			System.out.println();
		}

		System.out.println();

		// 2. 1 ~ 100가지 10행 10열로 출력 (for문 안에 if문이용)

		cnt = 1;
		while (true) {
			if (cnt > 100)
				break;
			System.out.print(cnt + "	");

			if (cnt % 10 == 0)
				System.out.println();

			cnt++;

		}

		// 3. 구구단 출력 - for 문안에 for문이용

		cnt = 0;
		i = 2;
		j = 1;

		while (true) {
			if (i > 9)
				break;
			while (true) {
				if (j > 9) {
					System.out.println();
					break;
				}
				System.out.println(i + " * " + j + " = " + i * j);
				j++;
			}
			j = 1;
			i++;

		}

		// Do-While
		// 1. 1~ 100가지 한줄로 출력

		cnt = 1;

		do {
			if (cnt > 100)
				break;
			System.out.print(cnt + " ");
			cnt++;

		} while (true);

		System.out.println();
		System.out.println();

		// 2. A ~Z 까지 한줄로 출력

		ch = 'A';
		do {
			if (ch > 'Z')
				break;
			System.out.print(ch + " ");
			ch++;
		} while (true);

		System.out.println();
		System.out.println();

		// 3. 1~ 10 까지 합 구해서 출력

		cnt = 1;
		cnt2 = 0;
		do {
			if (cnt > 10)
				break;
			cnt2 += cnt;
			cnt++;
		} while (true);

		System.out.println(cnt2);
		System.out.println();

		// 4. 1 ~ 100 사이의 7의 배수만 출력

		cnt = 1;
		do {
			if (cnt > 100)
				break;

			if (cnt % 7 == 0)
				System.out.println(cnt);

			cnt++;

		} while (true);

		System.out.println();

		// 5. 100 ~ 1 사이의 5 의 배수만 출력

		cnt = 100;
		do {
			if (cnt <= 0)
				break;

			if (cnt % 5 == 0)
				System.out.println(cnt);
			cnt--;

		} while (true);

		System.out.println();

		// 1. 1 ~ 100가지 10행 10열로 출력 (for문 안에 for문이용)

		i = 0;
		j = 1;

		do {
			if (i > 9)
				break;

			do {
				if (j > 10)
					break;
				System.out.print(i*10 + j + " ");
				j++;
			} while (true);

			System.out.println();
			j = 1;
			i++;

		} while (true);

		System.out.println();

		// 2. 1 ~ 100가지 10행 10열로 출력 (for문 안에 if문이용)

		
		cnt=1;
		
		do {
			if(cnt>100)
				break;
		
			System.out.print(cnt + " ");
			if(cnt%10==0)
				System.out.println();
			
			cnt++;
		}while(true);

		
		System.out.println();
		
		// 3. 구구단 출력 - for 문안에 for문이용
		i = 1;
		j = 1;
		do {
			if (i > 9)
				break;
			do {

				if (j > 9) {
					System.out.println();
					break;
				}
				System.out.println(i + " * " + j + " = " + i * j);
				j++;

			} while (true);
			j = 1;
			i++;
		} while (true);

	}
}
