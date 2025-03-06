package ex0306.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterExam {

	BufferedReaderWriterExam() {
		// 문자단위 파일 읽기 -> 보조스트림 Buffered 추가
		// Autoclose를 이용한 처리
		try (BufferedReader br = new BufferedReader(new FileReader("src/ex0306/file/test.txt"));
//				BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0306/file/dest.txt"))) {
				BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0306/file/dest.txt",true))) { //두번째 파라미터에 true를 넣으면 이어쓰기가 된다

//			while(true) {
//				int i = br.read();
//				if(i==-1) break;
//				System.out.println(i);
//			}

			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				System.out.println(line);
			}
			
			System.out.println("---------------------------------");
			
			bw.write(65);
			bw.write("ㅇㅇㅇ");
			bw.newLine();
			bw.write("ddddd");
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		new BufferedReaderWriterExam();
	}
}
