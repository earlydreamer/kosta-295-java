package ex0306.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class TestExam {

	final static String DEFAULT_PATH = "src/ex0306/io/";

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String input = "";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(DEFAULT_PATH + "test.txt", true))) {

			while (true) {	
				input = sc.nextLine();
				if(input.equals("exit"))
					break;
				bw.write(input);
				bw.newLine();
			}
//			bw.flush(); // 버퍼의 내용을 파일로 밀어낸다(flush한다). 
			//close() 시 flush를 호출하므로 autoclose 구문에서는 flush 호출이 없어도 정상적으로 쓰기가 이루어진다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
