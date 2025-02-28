package ex0221.Student;

/**
 * 각 요청의 결과를 모니터에 출력을 담당하는  클래스
 * */
public class StudentEndView {

	/**
	 * 전체검색 결과 출력
	 * */
	public static void printSelectAll(Student [] stArr){//stArr 는주소
		System.out.println("****학생 정보 (" + StudentService.count + ")명*******");
		
		//System.out.println("endview = " + stArr);
		
		for(int i=0; i< StudentService.count ; i++) {
			// 이름 :  나이 :    주소  출력해주세요.
			System.out.println( stArr[i].getName() +" | " + stArr[i].getAge()  +" | "+ stArr[i].getAddr());
		}
	}
	
	/**
	 * 조건 검색 결과 출력(이름에 해당하는 학생정보 출력)
	 * */
	public static void printSelectByName(Student student) {
		// 이름 :  나이 :    주소  출력해주세요.
		System.out.println(student.getName() +" | " + student.getAge() +" | " + student.getAddr());
	}
	
		
	/**
	 * 성공 or 실패 메시지 출력 (등록 or 수정)
	 * */
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
}






