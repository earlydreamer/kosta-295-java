package ex0305.file;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class fileExam {

	public fileExam() throws IOException{
		String path = JOptionPane.showInputDialog("파일경로");
		System.out.println("path="+path);
		
		File file = new File(path);
		if(file.exists()) {
			System.out.println(path+"파일이 있습니다.");
			if(file.isDirectory()) {
				System.out.println("폴더정보확인");
//				폴더안에 있는 모든 파일 / 폴더 정보 조회
//				file.list();// 폴더안에 있는 파일과 디렉토리 이름을 String으로
//				file.listFiles();//폴더안에 있는 파일과 폴더를 객체로

				String names[] = file.list();
				for(String name:names) {
					System.out.println(name);
				}
			}else {
				System.out.println(path+"파일에 대한 정보 확인");
				System.out.println("file.length() = " + file.length());
				System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
				System.out.println("file.getName() = " + file.getName());
				System.out.println("file.canRead() = " + file.canRead());
				System.out.println("file.canWrite() = " + file.canWrite());
				System.out.println("file.lastModified()() = " + file.lastModified());
			}
			
			
		}else {
			System.out.println(path+"파일이 없습니다. 파일을 만듭니다.");
			//파일 생성
			file.createNewFile();
			//폴더생성
			file.mkdir();
			
			
		}
	
		
	}
	
	public static void main (String args[]) throws IOException {
		new fileExam();
	}
	
}
