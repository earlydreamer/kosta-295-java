package ex0306.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SystemInExam {

	SystemInExam()throws Exception{
		InputStream is = System.in; // System.in은 byte 단위로 키보드 입력을 읽는다. 3byte인 유니코드 문자를 그대로 받지 못한다. 한글자씩만 받는다.
//		int i = is.read();
//		System.out.println((char)i);
//		
		//byte단위 처리를 -> 문자단위 처리로 변환 -> Buffered를 이용하면 한줄읽기
		// InputStream -> Reader -> Buffered 순서로 연결된다. 보조스트림은 보조스트림을 담을 수 있다. (스트림 체인)
		
		//Byte단위 -> 문자단위 처리 변환
		InputStreamReader isr = new InputStreamReader(is); //InputStreamReader에 InputStream을 넣어준다
//		int i = isr.read();
//		System.out.println((char)i);
		
		// Reader를 Buffered 이용
		BufferedReader br = new BufferedReader(isr);
		String data = br.readLine(); //한줄을 통으로 가져올 수 있다
		System.out.println(data);
		
		
		
		
		
		
	}
	
	public static void main (String args[]) throws Exception {
		new SystemInExam();
	}
}
