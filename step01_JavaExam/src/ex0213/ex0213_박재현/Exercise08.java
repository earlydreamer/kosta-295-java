package ex0213.ex0213_박재현;

public class Exercise08 {
	
	public static void main (String args[]) {
		double x = 5.0;
		double y = 0.0;
		
		double z= x%y;
		
		if(Double.isNaN(z)){//Double 클래스의 isNaN 메소드를 이용한 검사 
		//if(y==0){ // 나누는 값을 직접 검사하므로 결과는 같으나 하드코딩이 됩니다
			System.out.println("0.0으로 나눌 수 없습니다");			
		}else {
			double result = z+10;
			System.out.println("결과 : " + result);
			
			
			
		}
	}
	
	

}
