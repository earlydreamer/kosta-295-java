package ex0228.set;

import java.util.HashSet;
import java.util.Iterator;

public class SetExam extends HashSet<String> { // 상속을 이용한 hashSet 구현...
	public SetExam() {

	}

	public SetExam(String[] args) {
		for (String s : args) {
			System.out.print(s + " ");
			boolean res = super.add(s);
			System.out.println(res);
		}
		System.out.println(this.size());
		System.out.println(this);

		System.out.println("-------------");

		// -----------------------------------------
		// 요소를 하나씩 추출
		// 값을 꺼내려면 Iterator를 사용해야 한다

		Iterator<String> iterator1 = super.iterator();
		while (iterator1.hasNext()) { // Iterator 내에 요소가 있을 동안 반복한다
			String element = iterator1.next();//요소를 꺼내고 다음으로 넘어간다...
			System.out.println(element);
		}

//		Iterator를 이용한 순회와 같은동작
		System.out.println("-------------");
		
		
		for(String s : this) {
			System.out.println(s);
		}
		
		boolean deleteRes = super.remove("2"); //remove는 제거 후 성공과 실패를 boolean으로 반환한다.
		System.out.print("제거 : "+deleteRes); 
		
	}

	//값은 괜찮은데, 객체는 어떻게 비교하지??? -> 객체는 주소로 저장되기 때문에 단순비교로 중복체크가 안될거같은데??? 무슨기준으로 체크하지? <- 생각
	//
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SetExam(args);
	}
	
}
