package ex0228.set;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExamMain {

	Set<Member> set = new HashSet<>();
	
	public static void main(String args[]) {
	new MemberSetExamMain();	
	}

	MemberSetExamMain(){
		set.add(new Member("ㅇㅇ",23,"서울"));
		set.add(new Member("ㅇㅇ",21,"서울"));
		set.add(new Member("ㅇㅇ",21,"서울"));
		set.add(new Member("ㅇㅇ",24,"서울"));
		
		//set은 객체를 추가할 때 중복이면 추가하지 않는다.
		//내부적으로 hash() 메소드와 equals()메소드를 통해 비교한다.
		System.out.println("저장된 객체 수 " + set.size());
		
	}
}


