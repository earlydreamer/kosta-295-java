package ex0305.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputExam {

	FileInputOutputExam() {

		// Byte 단위로 파일 읽기
		// FileInputStream

		FileInputStream fileInputStream = null;
		FileOutputStream fileoutputStream = null;
		try {
			fileInputStream = new FileInputStream("f.txt");
			fileoutputStream = new FileOutputStream("src/ex0305/write.txt", true);

			
//			int i=0;
//			while(i != -1) {
//				i=fileInputStream.read();	
//				System.out.print(((char)i));
//			}


			int length = fileInputStream.available(); // 읽어들일수있는 바이트수를 리턴
			byte[] b = new byte[5];
			int i;
			i = fileInputStream.read(b);
			// byte B를 STring으로 변환
			String data = new String(b);

			System.out.println("i=" + i);

			fileoutputStream.write(65);
			
			fileoutputStream.write(97);
			fileoutputStream.write(32);
			fileoutputStream.write(100);
			fileoutputStream.write(13);
			fileoutputStream.write(10);
			fileoutputStream.write(70);
			
			String message = "ㅇㅇㅇ";
			
			fileoutputStream.write(message.getBytes()); // String -> Byte 변환
			fileoutputStream.flush();// 기록

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
					fileoutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		new FileInputOutputExam();
	}

}
