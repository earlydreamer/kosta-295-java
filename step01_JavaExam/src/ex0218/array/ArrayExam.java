package ex0218.array;

class Array{
	
	
	
	
	
}

public class ArrayExam{
	
	//��int,double,char,boolean ,String type���� �� 5���� �����ϴ�  �迭�� �����ϼ���

	int arrayInt[] = new int[5];
	double arrayDouble[] = new double[5];
	char arrayChar[] = new char[5];
	boolean arrayBoolean[] = new boolean[5];
	String arrayString[] = new String[5];
	
	
	//�޼ҵ� : printArrayValue01	
	//���� �迭�鿡 �ڵ����� �ʱ�ȭ �Ȱ��� ����ϼ���

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
	

	//�޼ҵ� : printArrayValue02	
	//���� 5���� �迭���� ���� ������ ������ data�� �Ҵ��ϼ��� .
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
	//�޼ҵ� : printArrayValue03	
	//���Ӱ� �Ҵ�Ȱ��� ����ϼ���
	
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
	
	//���θ޼ҵ忡��
	//ArrayExam�� �޼ҵ���� ������� ȣ���ϼ���.
	
	public static void main (String args[]) {
		ArrayExam a = new ArrayExam();
		a.printArrayValue01();
		a.printArrayValue02();
		a.printArrayValue03();
	}
	
	
}