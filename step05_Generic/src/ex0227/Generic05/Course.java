package ex0227.Generic05;
/**
 * 신청받는 코스
 */
public class Course {

	//모든사람을 허용하는
	public <T>void registerAll(Applicant<?> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
	
	
	//직장인만 받는
	public <T>void registerWorker(Applicant <? super Worker> applicant) { //Worker 의 부모까지...
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
	
	
	
	//학생만 받는
	public <T>void registerStudent(Applicant <?extends Student> applicant) {//Student의 자식만...
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
	
	
	
	
	
	
}
