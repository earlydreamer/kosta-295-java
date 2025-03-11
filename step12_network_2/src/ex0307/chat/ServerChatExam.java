package ex0307.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 클라이언트와 1 대 1 채팅을 위한 Server 
 * */
public class ServerChatExam {
	Socket sk ;
    public ServerChatExam() {
    	try(ServerSocket server = new ServerSocket(8888)){
    		System.out.println("클라이언트 접속 대기중~~");
    		
    		 sk = server.accept();
    		System.out.println(sk.getInetAddress() +"님과 채팅 시작합니다.!!!");
    		
    		//읽기 스레드
    		new ServerReciveThread().start();
    		
    		//쓰기 스레드 
    		new SendThread(sk, "SERVER").start();
    		
    		
    	}catch(Exception e) {
            System.out.println("Server의 생성자  예외부분.....");
    		e.printStackTrace();
    	}
    }
	public static void main(String[] args) {
		new ServerChatExam();

	}
	
	/**
	 * Inner클래스 
	 *  : 클라이언트가 보내온 내용을 읽어서 모니터에 출력 하는 스레드 
	 * */
	class ServerReciveThread extends Thread{
		@Override
		public void run() {
			try {
			 BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			  
			 while(true) {
				 String data = br.readLine();//클라이언트가 보내온 내용 읽기
				 if(data.equals("exit"))break;
				 
				 System.out.println(data);
			 }
			
			 System.out.println("서버 받는 스레드 종료합니다.");
			
			}catch (Exception e) {
				System.out.println("ServerReciveThread의  catch 입니다...");
				e.printStackTrace();
			}finally {
				System.out.println("프로그램 종료합니다.");
				System.exit(0);
			}
			
		}
	}
	

}//클래스 끝








