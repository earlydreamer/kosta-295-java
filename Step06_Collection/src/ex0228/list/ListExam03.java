package ex0228.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 생성자를 이용해 사원 데이터 5명정도 추가
 * 저장된 모든 사원정보 출력
 * 사원번호에 해당하는 사원정보 리턴
 * 사원번호 기준 정렬
 * 주로를 인수로 전달받아 동일한 주소의 사원 검색
 * 나이 기준 정렬
 */

public class ListExam03 {

	List<EmpDto> list = new ArrayList<EmpDto>();
	
	public static void main (String args[]) {
		new ListExam03();
		
	}
	
	ListExam03(){
		
		list.add(new EmpDto(1,"ㅇㅇㅇ", 22, "오리역"));
		list.add(new EmpDto(2,"ㅇㅅㅇ", 42, "미금역"));
		list.add(new EmpDto(5,"ㅁㅇㅁ", 32, "서현역"));
		list.add(new EmpDto(3,"ㅇㅅㅁ", 12, "오리역"));
		list.add(new EmpDto(4,"ㅁㅁㅁ", 26, "미금역"));
		
		//System.out.println(list);
		
		EmpDto emp = this.selectByEmpNo(1);
		System.out.println(emp);
		List<EmpDto> foundList = this.selectByAddress("오리역1");

		if(foundList.isEmpty()) //결과 리스트가 비어있는 경우
			System.out.println("못찾음");
		else
			System.out.println(foundList);
		
		System.out.println("----------");
		System.out.println(sortByEmpNo()); //사원번호 기준 정렬된 리스트를 출력
		System.out.println("----------");
		System.out.println(sortByAge()); //나이 기준 정렬된 리스트를 출력
		
	}
	
	public List<EmpDto> selectAll(){
		return list;
	}
	
	public EmpDto selectByEmpNo(int findNumber) {
		for(EmpDto emp : list) {
			if(emp.getEmpNumber() == findNumber)
				return emp;
		}return null;
	}
	
	public List<EmpDto> selectByAddress(String findAddress){
		List<EmpDto> returnList = new ArrayList<EmpDto>(); //리턴할 ArrayList
		for(EmpDto dto : list) {
			if(dto.getAddress().equals(findAddress)) 
				//String의 비교는 equals() 사용... 
				//==연산자로 해도 결과가 나오기는 하는데 이건 저장된 텍스트에 따라 기대한 값이랑 다르게 동작할 수 있다...
				returnList.add(dto);
		}
		return returnList;
	}
	
	public List<EmpDto> sortByEmpNo() {
		
		//list 안의 모든 Element들은 반드시 Comparable 인터페이스를 구현해야 한다...
		List<EmpDto> arr = new ArrayList<EmpDto>(list); //복사한 임시 리스트를 생성한다... List(Collection) 형태의 생성자를 호출... list내의 요소를 복사...
		Collections.sort(arr);
		
		
		return arr;
	}

	public List<EmpDto> sortByAge() {
		List<EmpDto> returnList = new ArrayList<EmpDto>(list);
		
		//Collections.sort(returnList); //Comparable을 기준으로 한 정렬... 사원번호를 기준으로 정렬하게 된다
//		Collections.sort(returnList, new SortByAge()); 
//		Collections.sort(returnList, new Comparator<EmpDto>() { //익명클래스를 이용한 구현
//			@Override
//			public int compare(EmpDto o1, EmpDto o2) {
//				// TODO Auto-generated method stub
//				return o1.getAge()-o2.getAge();
//			}			
//		});
		
		Collections.sort(returnList,(a,b)->a.getAge()-b.getAge());//lambda를 이용한 구현		
		return returnList;
	}
	
	
//	class SortByAge implements Comparator<EmpDto> { //별도 메소드를 이용한 구현...
//		@Override
//		public int compare(EmpDto o1, EmpDto o2) {
//			// TODO Auto-generated method stub
////			return o1.getAge()-o2.getAge(); //오름차순 정렬
//			return o2.getAge()-o1.getAge(); //내림차순 정렬
//		}
//
//	}
}