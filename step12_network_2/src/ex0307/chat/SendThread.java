package ex0307.chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 키보드입력을 받아서 상대측에게 데이터 전송
 * */
public class SendThread extends Thread {
	Socket sk;
	String name;
	public SendThread(Socket sk,String name) {
		super(name);
		this.sk= sk;
		this.name = name;
	}
    @Override
	public void run() {
      try {
    	  Scanner sc = new Scanner(System.in);//키보드입력 받을 준비
          PrintWriter pw = new PrintWriter(sk.getOutputStream() , true);//데이터를 전송할 준비
         
          while(true) {
             String inputData = sc.nextLine();
             if(inputData.equals("exit")) {
            	 pw.println(inputData);// exit단어를 전송
            	 break;
             }else {
            	 pw.println(name+" 보낸 내용 : " + inputData);
             }
          }
          
          System.out.println(name+"의 보내는 스레드가 종료합니다.!!!");
    	
      }catch (Exception e) {
    	 System.out.println(name+"의 SendThread 예외 발생했어요....");
		e.printStackTrace();
	   }finally {
		   System.out.println("모든 프로그램 종료합니다.~~");
		   System.exit(0);
	   }
	}
  
    
    
    
    
    
    
    
}
