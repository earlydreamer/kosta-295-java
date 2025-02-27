package ex0227.excception;

import java.io.IOException;

public class FileWriterExample {
	public static void main(String args[]) {
		try(FileWriter fw = new FileWriter("File.txt")){
			fw.write("JAVA");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
