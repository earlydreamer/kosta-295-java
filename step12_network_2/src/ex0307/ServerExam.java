package ex0307;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {
    public ServerExam() {
    	try(ServerSocket server = new ServerSocket(8000)){
    		while(true) {
    	     System.out.println("클라이언트 접속 대기중 입니다~~~~~~^^");
    		 try(Socket socket = server.accept();){//클라이언트접속을 기다린다.
	    		 System.out.println(socket.getInetAddress() +"님 접속하셨습니다.");
	    		 
	    		 //접속한 클라이언트가 보내온 내용을 읽기
	    		 InputStream is = socket.getInputStream();
	    		 
	    		 //byte단위를 --> 문자단위로 변환
	    		 InputStreamReader isr = new InputStreamReader(is);
	    		 
	    		 //Reader를 성능을 위해서 Buffered 사용
	    		 BufferedReader br = new BufferedReader(isr);
	    		 String message = br.readLine();
	    		 System.out.println("클라이언트가 보내온 내용 = " + message);
	    		 
	    		 //접속한 클라이언트에게 데이터 전송 =쓰기 
	    		 OutputStream os = socket.getOutputStream();
	    		 //byte -> Writer -> buffered
	    		 PrintWriter pw = new PrintWriter(os, true);//
	    		 pw.println("자바세상에 오신걸 환영합니다.!!!!");
	    		 System.out.println();
    		 }
    		}
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
	   new ServerExam();
	}

}
