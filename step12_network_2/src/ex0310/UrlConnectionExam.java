package ex0310;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlConnectionExam {

	public static void main (String Args[]) {
		try {
			URL url = new URL("https://naver.com");
			InputStream is = url.openStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			
			//파일에 저장
			BufferedWriter bw = new BufferedWriter (new FileWriter("serc/ex0310/daum.html"));
			
			while(true) {
				String data = br.readLine();
				if(data==null)break;
				
				
				bw.newLine();
				bw.flush();				
			}
			
		
		
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} 
	}
	
}
