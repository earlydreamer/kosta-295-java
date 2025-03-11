\package ex0307.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientChatExam {
    public ClientChatExam() {
    	try {
    		Socket sk = new Socket("127.0.0.1", 8888);
    		
    		System.out.println("서버와 대화 시작합니다~~");
    		
    		//보내고
    		new SendThread(sk, "CLIENT").start();
    		
    		//받기
    		new Thread(()->{
    			try {
    			 BufferedReader br = 
    					 new BufferedReader(new InputStreamReader(sk.getInputStream()));
    			  while(true) {
    			    String data = br.readLine();
    			    if(data.equals("exit"))break;
    			    
    			    System.out.println(data);
    			
    			  }
    			  
    			  System.out.println("Client의 받는 스레드 종료합니다.");
    			}catch(Exception e) {
    				System.out.println("Client의 Thread영역 끝....");
    				e.printStackTrace();
    			}
    		}).start();
    		
    		
    	}catch(Exception e) {
    		System.out.println("Client의 생성자 끝....");
    		e.printStackTrace();
    	}
    }
	public static void main(String[] args) {
       new ClientChatExam();		

	}

}
