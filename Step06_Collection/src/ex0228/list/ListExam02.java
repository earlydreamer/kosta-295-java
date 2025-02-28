package ex0228.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 생성 방식으로 List를 활용하는 용례
 */
public class ListExam02 {
	List<Integer> list = new ArrayList<Integer>(5); // 상위 Interface형으로 선언하면 나중에 자료구조를 갈아끼울 때 용이하다
	public static void main (String args[]) {
		new ListExam02();	
	}
	
	public ListExam02() {
//		super(5);// Super를 사용할 수 없다
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(3);
		int size = list.size(); //List의 크기가 아닌 요소의 수가 나온다
		System.out.println(size);
		System.out.println("----");
		for (int i = 0; i < size; i++) {
			int v = list.get(i);// Auto-Unboxing
			System.out.println(v);
			
		}
		int ret = list.remove(1);//2번째 Index에 해당하는 값을 제거한다
		System.out.println(ret); //remove는 삭제된 값을 return한다.
		list.remove(new Integer(3)); //값이 3인 Integer형 객체를 제거한다
		System.out.println("----");
		for(int i:list) { //super는 올 수 없다. 
			System.out.println(i);
		}
		System.out.println("----");
		System.out.println(list); //this = this.toString(); / ArrayList가 toString을 Override하고 있기 때문에... 주소가 아니라 값이 나온다		

		Collections.sort(list); //list를 오름차순으로 정렬한다
		Collections.sort(list,Collections.reverseOrder());//Collections.reverseorder는 Comparer를 반환한다. 이에따라 내림차순으로 정렬한다.
		System.out.println(list); //정렬된 List 출력
		
		
	}
	
	
}
