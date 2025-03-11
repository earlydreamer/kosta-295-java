package ex0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExam {
    public ClientExam() {
    	try(Socket sk = new Socket("192.168.0.40", 8000)){
    		//접속된 서버에게 데이터 전송=저장
    		PrintWriter pw = new PrintWriter( sk.getOutputStream() , true);
    		pw.println("서버에 접속하고 싶어요~~");//전송
    		
    		//서버가 보내온 데이터 받기
    		BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
    		String data = br.readLine();
    		System.out.println("서버가 보내온 내용 = " + data);
    		
    		System.out.println("클라이언트 종료합니다~~~");
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
		new ClientExam();

	}

}
