package ex0220;

import java.util.Scanner;

/**
 * 학생의 정보를 관리 하는 서비스(등록, 수정, 검색,....)
 * */
public class StudentService {
	
	Student[] student;
	private int count = 0;//배열내 데이터 개수만큼 저장하는것으로 카운트
	/**
	 * 초기치데이터 3명 정도 세팅하기 
	 * */
	void initStudent() {
		
		//학생을 3명정도 배얼에 저장
		for(int i=0;i<3;i++) {
			student[i] = new Student();
		}		
	}
	
	/**
	 *  Student객체를 생성해서 리턴해주는 메소드 작성
	 * */

	private Student setStudent(String param1, int param2, String param3) {
		Student student = new Student();
		student.setName(param1);
		student.setAge(param2);
		student.setAddr(param3);
		return student;		
	}
		

	 /**
	   학생의 정보 등록하기 
	    : 배열의 경계를 벗어나면 더이상 추가할수 없습니다. 메시지출력.
	      추가가 성공하면 "등록되었습니다" 메시지를 출력
	  **/
	void addStudent() {
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		String addr;
		System.out.println("학생 정보 입력");
		if(count>student.length) {
			System.out.println("더이상추가할수없습니다.");
		}else {
			Student newStudent = new Student();
			name = sc.nextLine();
			age = sc.nextInt();
			addr = sc.nextLine();
			newStudent = setStudent(name, age, addr);
			
		}
		
	}
	 
	 
	
	/**
	 * 전체 학생의 정보 조회하기
	 * */
	void printAllStudentInfo() {
		for(Student s : student) {
			System.out.println(s.getName());
			System.out.println(s.getAge());
			System.out.println(s.getAddr());
			System.out.println("----------");
		}
	}
	 
	
	/**
	 * 이름에 해당하는 학생의 정보 검색하기
	 *  : 이름에 해당하는 학생이 있으면 학생의 이름, 나이, 주소를출력하고
	 *     없으면 "찾는정보가 없습니다." 출력한다.
	 * */
	Student searchStudentByName(String param1) {
		for(Student s : student) {
			if(s.getName() ==param1) {
				return s;
			}
		}
		return null;
	}
	
	void searchAndPrintStudent(String s) {
		Student student = searchStudentByName(s);
		if(student==null) //학생 정보가 없을 경우 
			System.out.println("찾는 정보가 없습니다");
		else {
			System.out.println(student.getName());
			System.out.println(student.getAge());
			System.out.println(student.getAddr());			
			System.out.println("----------");
		}
	}
	
	/**
	 * 이름에 해당하는 학생의 나이와 주소 변경하기 
	 *  : 이름에 해당하는 학생이 있는지 찾아서 없으면 "수정할수 없습니다." 출력
	 *   있으면  setAge() , setAddr() 이용해서 전달된 인수의 값으로 변경하고
	 *   "수정되었습니다" 출력
	 *   @param : Student
	 *   @return : void
	 * */
	void update() {
		
	}

	
	 

}

