package ex0213.ex0213_박재현;

public class Slide3 {
	
	public static void main (String args[]) {
		String name;
		int kor;
		int eng;
		int mat;
		int tot;
		double avg;
		char grade;
		
		name = "이름";
		
		kor = 80;
		eng = 79;
		mat = 95;
		
		tot = kor+eng+mat;
		avg=tot/3;
		
		/*
		if(avg>=90)
			grade = 'A';
		else if (avg>=80)
			grade = 'B';
		else if (avg>=70)
			grade = 'C';
		else if (avg>=60)
			grade = 'D';
		else
			grade = 'F';
		*/			
		
		
		//Switch-Case 구현		
		int gradeRange = (int)avg/10;
		
		grade = switch(gradeRange) {
		
		case 10, 9 ->	'A';
		case 8 -> 		'B';
		case 7 ->		'C';
		case 6 ->		'D';
		default -> 		'F';
		};
		
		
		System.out.println("이름 : "+ name);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + mat);
		System.out.println("총점 : " + tot);
		System.out.println("평균 : " + avg);
		System.out.println("학점 : " + grade);
		
		
		 
	}

}
