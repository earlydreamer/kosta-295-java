package ex0306.io.serialize;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectLoadExam {
	
	static final String PATH = "src/ex0306/io/serialize/";
	
	ObjectLoadExam(){
		
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(PATH+"test.txt")))){
			
//			Student student = (Student)ois.readObject();
//			Student student2 = (Student)ois.readObject();
//			
//			System.out.println(student);
//			System.out.println(student2);
			
			List<Student> studentList = (List<Student>)ois.readObject();
			System.out.println(studentList);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main (String args[]) {
		new ObjectLoadExam();
	}
	
}
