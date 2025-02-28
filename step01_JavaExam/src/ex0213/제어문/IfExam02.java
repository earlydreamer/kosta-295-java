package ex0213.제어문;

public class IfExam02 {

		
	public static void main(String[] args) {
		
		int v;
		v=(int)(Math.random()*12)+1;
		String text;
		
		if(v==1) {
			text= "일요일";
		}else if(v==2) {
			text= "월요일";			
		}else if(v==3) {
			text= "화요일";
		}else if(v==4) {
			text= "수요일";
		}else if(v==5) {
			text= "목요일";
		}else if(v==6) {
			text= "금요일";
		}else {
			text= "토요일";
		}
		
		System.out.println(text);
		
			


	}

}
