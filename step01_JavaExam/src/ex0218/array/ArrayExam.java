package ex0218.array;

class Array{
	
	
	
	
	
}

public class ArrayExam{
	
	//각int,double,char,boolean ,String type별로 총 5개씩 저장하는  배열을 생성하세요

	int arrayInt[] = new int[5];
	double arrayDouble[] = new double[5];
	char arrayChar[] = new char[5];
	boolean arrayBoolean[] = new boolean[5];
	String arrayString[] = new String[5];
	
	
	//메소드 : printArrayValue01	
	//위의 배열들에 자동으로 초기화 된값을 출력하세요

	public void printArrayValue01(){
		System.out.println("----");
		for(int i : arrayInt) {
			System.out.println(i);
		}

		for(double i : arrayDouble) {
			System.out.println(i);
		}
		for(char i : arrayChar) {
			System.out.println(i);
		}
		for(boolean i : arrayBoolean) {
			System.out.println(i);
		}
		for(String i : arrayString) {
			System.out.println(i);
		}
		
	}
	

	//메소드 : printArrayValue02	
	//위의 5개의 배열에서 각각 적당한 값으로 data를 할당하세요 .
	public void printArrayValue02(){
		System.out.println("-- Set Value --");
		
		for(int i=0;i<arrayInt.length;i++) {
			arrayInt[i]=i;
		}
		
		for(int i=0;i<arrayDouble.length;i++) {
			arrayDouble[i]=i;
		}
		
		for(int i=0;i<arrayChar.length;i++) {
			arrayChar[i]= (char)('A' + i) ;
		}
		
		for(int i=0;i<arrayBoolean.length;i++) {
			if(i%2==0)
				arrayBoolean[i]= true;
		}
		
		for(int i=0;i<arrayString.length;i++) {
			arrayString[i] = "String " +i ;
		}

		

		
	}
	//메소드 : printArrayValue03	
	//새롭게 할당된값을 출력하세요
	
	void printArrayValue03() {
		System.out.println("----");
		for(int i : arrayInt) {
			System.out.println(i);
		}

		for(double i : arrayDouble) {
			System.out.println(i);
		}
		for(char i : arrayChar) {
			System.out.println(i);
		}
		for(boolean i : arrayBoolean) {
			System.out.println(i);
		}
		for(String i : arrayString) {
			System.out.println(i);
		}
	}
	
	//메인메소드에서
	//ArrayExam의 메소드들을 순서대로 호출하세요.
	
	public static void main (String args[]) {
		ArrayExam a = new ArrayExam();
		a.printArrayValue01();
		a.printArrayValue02();
		a.printArrayValue03();
	}
	
	
}