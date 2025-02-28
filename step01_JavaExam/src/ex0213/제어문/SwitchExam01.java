package ex0213.제어문;

public class SwitchExam01 {
	public static void main (String args[]) {
		
		int v;
		v=(int)(Math.random()*12)+1;
		String text;
		
	
		switch(v){
		case 1:
			text= "일요일";
			break;
		case 2:
			text= "월요일";
			break;
		case 3:
			text= "화요일";
			break;
		case 4:
			text= "수요일";
			break;
		case 5:
			text= "목요일";
			break;
		case 6:
			text= "금요일";
			break;
		default:
			text= "토요일";
			break;
		}

		System.out.println(v);
		System.out.println(text);
	
		
	}

}
