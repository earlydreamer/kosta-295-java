package ex0305.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class BufferedFileCopy {

	public BufferedFileCopy() {

		String readFile = JOptionPane.showInputDialog("읽을파일명");
		String writeFile = JOptionPane.showInputDialog("저장할파일명");
		//AutoClose
		long start = System.nanoTime();
//		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(readFile));
//			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(writeFile))){
		try(FileInputStream fis = new FileInputStream(readFile);
				FileOutputStream fos = new FileOutputStream(writeFile)){
			
			
			//읽어서 저장하기
			while(true) {
			int i = fis.read();
//			int i = bis.read();
			if(i==-1)
				break;
			fos.write(i);
//			bos.write(i);
			}System.out.println("파일 복사 완료");
			
			long end = System.nanoTime();
			System.out.println(end-start);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main (String args[]) {
		
		new BufferedFileCopy();
		
	}
	
	
}
