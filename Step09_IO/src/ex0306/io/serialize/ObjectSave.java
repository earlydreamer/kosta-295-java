package ex0306.io.serialize;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class ObjectSave {

	static final String PATH = "src/ex0306/io/serialize/";
	
	ObjectSave(){
		//객체를 파일에 저장 - OBjectOutputStream 사용
		 
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(PATH+"test.txt")))){
			Student student = new Student("학생",22,"서울");
			Student student2 = new Student("학생",233,"부산");
			
			//직렬화를 안하면 저장이 안된다
			
//			oos.writeObject(student);			
//			oos.writeObject(student2);		
			
			List<Student> studentList = List.of(new Student("학생1",22,"분당"),new Student("학생2",32,"서울"),student,student2);
			//List는 이미 Serializable이 Implement되어 구현되어있다
			oos.writeObject(studentList);
			
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
		
	}
	
	public static void main(String args[]) {
	new ObjectSave();	
	}
	
	
}
