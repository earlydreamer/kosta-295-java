package ex0228.list;

import java.util.ArrayList;

/**
 * 상속의 형태로 List를 사용하는 용례
 */
//public class ListExam01 extends LinkedList<Integer>{ // Interface이기 때문에 같은 Interface를 구현하는 바꿔도 호환성이 있다
public class ListExam01 extends ArrayList<Integer> {
	public static void main(String args[]) {
		new ListExam01();

	}

	public ListExam01() {
		super(5);// Auto-Boxing
		super.add(1);
		this.add(2);
		add(3);
		int size = super.size(); //List의 크기가 아닌 요소의 수가 나온다
		System.out.println(size);
		System.out.println("----");
		for (int i = 0; i < size; i++) {
			int v = super.get(i);// Auto-Unboxing
			System.out.println(v);
			
		}
		int ret = this.remove(1);//2번째 Index에 해당하는 값을 제거한다
		System.out.println(ret); //remove는 삭제된 값을 return한다.
		this.remove(new Integer(3)); //값이 3인 Integer형 객체를 제거한다
		System.out.println("----");
		for(int i:this) { //super는 올 수 없다. 
			System.out.println(i);
		}
		System.out.println("----");
		System.out.println(this); //this = this.toString(); / ArrayList가 toString을 Override하고 있기 때문에... 주소가 아니라 값이 나온다		
		
	}
}
