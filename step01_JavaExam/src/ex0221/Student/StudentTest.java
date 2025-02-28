package ex0221.Student;

public class StudentTest {
	public static void main(String[] args) {
		System.out.println("***학생 관리 프로그램 시작합니다.******");
		StudentService service = new StudentService();//StudentService의 전역변수들이 초기화 
		service.init(); // 초기치데이터 세팅
		
		//전체학생정보 출력
		Student [] stArr = service.selectAll();
		StudentEndView.printSelectAll(stArr);
		
		//이름으로 검색하기
		System.out.println("--3. 이름으로 검색 -----");
	 	Student st = service.selectByName("희정");
		if(st ==null) {
			StudentEndView.printMessage("찾는 정보가 없습니다.");
		}else {
			StudentEndView.printSelectByName(st);
		}
	 	
	 	
		System.out.println("--이름이 없는경우----");
		st = service.selectByName("삼순이");
		if(st ==null) {
			StudentEndView.printMessage("찾는 정보가 없습니다.");
		}else {
			StudentEndView.printSelectByName(st);
		}
		
		
		
		//등록하기
		System.out.println("--1. 등록하기 -----");
		Student student = new Student("미미",25,"오리역");
//		student.setName("미미");
//		student.setAge(25);
//		student.setAddr("오리역");
		
		int result = service.insert(student);
		if(  result == 0) {
			 StudentEndView.printMessage("이름이 중복이므로 등록할수 없습니다.");
		}else if(result==-1) {
			StudentEndView.printMessage("더 이상 등록 할수 없는 상황입니다.(배열의 크기 벗어남)");
		}else {//성공
			StudentEndView.printMessage("등록되었습니다.");
		}
		
		
		
		//System.out.println("--2. 전체검색 -----");
		//service.selectAll();
		
		
		
		//수정하기 
		System.out.println("--4. 수정하기 -----");
		Student st2 =new Student();
		st2.setName("나영2");//조건
		st2.setAge(23);
		st2.setAddr("대전");
		
		if( service.update(st2) ){
			StudentEndView.printMessage("수정되었습니다.");
		}else {
			StudentEndView.printMessage("수정되지 않았습니다.");
		}
		
		System.out.println("---변경후 ---");
		 stArr = service.selectAll();
		StudentEndView.printSelectAll(stArr);

	}

}








