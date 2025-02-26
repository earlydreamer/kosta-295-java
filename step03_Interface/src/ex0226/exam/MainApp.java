package ex0226.exam;

public class MainApp {

	public static void main(String[] args) {
		// Tv 3대 , Audio 2대 저장하고 그 정보를 출력한다.

		ElecFunction elec[] = new ElecFunction[5]; //ElecFuntion을 implements 하고 있는 Class는 ElecFunction을 Type으로 사용할 수 있다

		elec[0] = new Tv("A01", 500000, 12);
		elec[1] = new Tv("A02", 2500, 20);
		elec[2] = new Tv("A03", 3000, 30);

		elec[3] = new Audio("A04", 8500, 200);
		elec[4] = new Audio("A05", 700, 100);

		for (ElecFunction e : elec) {
			 e.start();
			//System.out.println(e);
		}

	}
}
