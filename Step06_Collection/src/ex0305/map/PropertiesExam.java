package ex0305.map;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class PropertiesExam {
	public static Properties property = new Properties();

	PropertiesExam() {

		property.setProperty("ㅁㅁㅁ", "ttt");
		property.setProperty("ㅇㅇㅇ", "222");
		property.setProperty("ㅁㅁㅁ", "444");
		property.setProperty("ㅅㅅㅅ", "@22");
		property.setProperty("ㅇㅇㅇ", "123");

		// 조회
		// 모든 key의 정보 가져오기

		Set<String> keys = property.stringPropertyNames();
		for (String key : keys) {
			String value = property.getProperty(key);
			System.out.println(value);
		}

		/**
		 * 외부 Properties 파일 로딩하는 방법 1_ IO를 이용 2) Resource를 이용하는 방법
		 */
		test();
		test2();
	}

	public void test() {
		property.clear();
		
		//외부 properties  로딩
		 try{
			//1. 파일의 위치의 기준 프로젝트가 기준!-경로설정할때 src기준...
//			 	InputStream inputStream = 
//			 			new FileInputStream("src/ex0305/map/dbInfo.properties");
//			    property.load(inputStream);
//    
//			 
//			    2. 클래스 위치한 패키지 내에서 파일 로딩할때 - / 생략(상대경로)
//			    InputStream inputStream =
//			     PropertiesExam.class.getResourceAsStream("a.properties");
//			     property.load(inputStream);
			
////				 3.클래스 위치한 패키지 내에서 파일 로딩할때 - / 생략(상대경로)
//				 InputStream inpupStream =this.getClass().getResourceAsStream("a.properties"); 
//				 property.load(inpupStream);
				  
			
//				 4.ClassLoader의 모든 경로에서 파일 읽음. 보통 resources 폴더의 파일 읽을때 사용.
//				 InputStream inpupStream = 
//				this.getClass().getClassLoader().getResourceAsStream("b.properties"); 
//				this.getClass().getClassLoader().getResourceAsStream("ex0305/map/a.properties"); 
//				 property.load(inpupStream);
				 
				 //5. ClassLoader의 Class내에 파일존재하는 경우
				/*InputStream inpupStream =
			this.getClass().getClassLoader().getResourceAsStream("ex0726/list/b.properties"); // 경로에 '/' 붙지않음. ClassLoader의 모든 경로에서 파일 읽음.
				 pro.load(inpupStream);*/
				 
				 Set<String> keys = property.stringPropertyNames();
					for (String key : keys) {
						String value = property.getProperty(key);
						System.out.println(value);
					}

				 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		
	}

	void test2() {
		/**
		 * Resourcebundle은 ~.properties 파일을 로딩하는 클래스
		 * 파일의 확장자를 생략한다
		 * 기준 경로는 classes 폴더로 정해져 있음
		 */
		
		System.out.println("----");
		ResourceBundle rb = ResourceBundle.getBundle("ex0305/map/a");
		for(String key:rb.keySet()){
			String value = rb.getString(key);
			System.out.println(value);
		}
		
	}
	
	public static void main(String args[]) {


		new PropertiesExam();
		
	}
}
