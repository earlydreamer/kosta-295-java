package ex0306.thread;

public class ThreadExam {

	
	
	public static void main (String args[]) {
	
		System.out.println("메인 시작");
		
		//1-100 출력
		
		NumberThread th1 = new NumberThread("스레드1");
		NumberThread th2 = new NumberThread("스레드2");
		new NumberThread("ThreadNumber").start();
		Thread th3 = new Thread(new AlphaThread(),"스레드3");
		//a-z 출력		

		th1.start();
		th2.start();
		th3.start();
		
//		run()을 직접 실행하면 그냥 순차적으로 실행이 된다.
//		th1.run();
//		th2.run();
//		th3.run();

//		try {
//		
//			th1.join(); //th1 스레드가 일을 다 끝낼때까지 이 메소드를 실행한 스레드는 일시 정지한다.
//		
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		System.out.println(th1.sum);
		
		
		System.out.println("메인 종료");
	}
	
	
}

class AlphaThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub	
		Thread th = Thread.currentThread();
		
		for(char ch='A';ch<='Z';ch++) {	
			System.out.println(th.getName() +" "+ ch);
			int time = (int) (Math.random()*500);
//			try {
////				Thread.sleep(time);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			Thread.yield(); // 이 구문을 호출한 스레드를 일시정지한다.
		}
		System.out.println(th.getName()+" 종료");
	}
	
}

class NumberThread extends Thread {
	//스레드로 동작할 기능
	int sum=0;
	public void run(){
		//현재 동작하고 있는 스레드가 누구인지 가져오기
		System.out.println(super.getName()); //스레드의 이름 얻어오기
		for(int i=0;i<100;i++) {
			sum+=i;
			System.out.println(super.getName() +" "+ i);
			int time = (int) (Math.random()*500);
//			try {
//				
//				Thread.sleep(time);
//			} catch (InterruptedException e) {
//				 TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			Thread.yield(); // 이 구문을 호출한 스레드를 일시정지한다.
		}
		System.out.println(super.getName() + " 종료 " + sum);
	}
	
	
	NumberThread(String string){
		super(string); //스레드에 이름을 설정
	}
	
}

