package ex0227.Generic05;

public class GenericWildcardMain {

	public static void main( String args[]) {
		Course course = new Course();
		
		course.registerAll(new Applicant<Person>(new Person()));
		
		course.registerAll(new Applicant<Worker>(new Worker()));
		course.registerAll(new Applicant<Student>(new Student()));
		course.registerAll(new Applicant<HighStudent>(new HighStudent()));
		course.registerAll(new Applicant<MidStudent>(new MidStudent()));
		
		System.out.println("----------------------------------------");
		
		course.registerWorker(new Applicant<Person>(new Person()));
		course.registerWorker(new Applicant<Worker>(new Worker()));
//		course.registerWorker(new Applicant<Student>(new Student));
//		course.registerWorker(new Applicant<HighStudent>(new HighStudent));
//		course.registerWorker(new Applicant<MidStudent>(new MidStudent));
		
		
		System.out.println("----------------------------------------");
		
//		course.registerStudent(new Applicant<Person>(new Person()));
//		course.registerStudent(new Applicant<Worker>(new Worker()));
		course.registerStudent(new Applicant<Student>(new Student()));
		course.registerStudent(new Applicant<HighStudent>(new HighStudent()));
		course.registerStudent(new Applicant<MidStudent>(new MidStudent()));
		
		
		
		
		
		
	}
	
	
	
	
}
