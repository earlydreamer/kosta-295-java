package ex0306.thread;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GuiThreadExam extends JFrame{
	
	JTextField text1 = new JTextField(5);
	JTextField text2= new JTextField(5);
	JButton btn = new JButton();
	
	GuiThreadExam(){               
//		super("시계");
		
		
		
		//Jframe 창(Container)에 컴포넌트 추가
		Container container = super.getContentPane();
		
		//Container의  레이아웃을 변경
		super.setLayout(new FlowLayout());
		
		//컨테이너에 컴포넌트 추가		
		
		container.add(text1);
		container.add(text2);
		container.add(btn);
		btn.setText("Button");
		
		
		
		//창의 크기
		super.setSize(640,480);
		//창의 표시
		super.setVisible(true);
		//창의 위치
		super.setLocationRelativeTo(null);//LocationRelativeTo 메소드 = 창크기, 화면크기를 구해서 정중앙에 놓기
		
		//x 눌렀을때 닫기
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//시계 스레드 시작
		ClockThread c = new ClockThread();
		c.start();
		
		
		//텍스트박스에 숫자 출력하는 스레드
		
		new Thread(()->{
			//스레드 기능
			for(int i=1;i<1000;i++) {
				//text1에 추가
				text1.setText(Integer.toString(i));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		//버튼을 클릭했을때 A-Z까지 text2 에 출력
		
		btn.addActionListener((event)->{
//			System.out.println("ㅇ");
			new Thread(()->{
				for(char ch = 'A'; ch <'Z'; ch++) {
					//text1에 추가
					text2.setText(ch+"");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		});
		
	}
	
	
	class ClockThread extends Thread {
		public void run() {
//			String timeString;
			while(true) {
				Calendar now = Calendar.getInstance(); //현재 날짜와 시간을 가져온다
				int year = now.get(Calendar.YEAR);
				int month = now.get(Calendar.MONTH);
				int date = now.get(Calendar.DATE);
				int hour = now.get(Calendar.HOUR);
				int minute = now.get(Calendar.MINUTE);
				int second = now.get(Calendar.SECOND);
				
				String timeString = year + "년 " + month + " 월" + date + "일" + hour + "시" + minute + "분" + second + "초";
				GuiThreadExam.this.setTitle(timeString);
				try {
				Thread.sleep(1000);//1초마다 정지
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main (String args[]) {
		new GuiThreadExam();

	}
	
}





