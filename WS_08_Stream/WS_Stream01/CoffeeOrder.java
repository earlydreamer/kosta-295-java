package ws08.ex01;

import java.util.List;
import java.util.stream.Collectors;

public class CoffeeOrder {

	public static void main(String[] args) {
		/**
		 * 1. ��ħ�� ���� ��� Ŀ�� �ֹ� ����� List�� coffes��� �̸����� ��´�.
			2. 1�� �ҽ��� ��Ʈ���� �����Ѵ�. 
			3. �� Ŀ�ǵ��� �⺻ ������ �ϸ� ���� �ֹ��� ������ ��ġ�Ѵ�.
			   �ֹ� ���� Ŀ�� ��� �߿��� ���ĺ� �� o�� �� ������ Ŀ�ǰ� ���� ���� ��
			��� �ֹ��̴�. 
			4. ���������� �ߺ��� ������ ���� Ŀ�ǵ��� ��Ƽ� ���� ����Ѵ�.

		 * */
		
		List<String> coffees=  List.of(
									"Cappuccino",
									"Americano",
									"Espresso",
									"Caramel Macchiato",
									"Focha",
									"Cappuccino",
									"Espresso",
									"Batte"				
								);
		
	
		
		coffees.stream().filter(s->s.getBytes(s).equals(o))

	}

}
