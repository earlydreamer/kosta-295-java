package ex0213.연산자;

class MathOperatorExam{
	public static void main(String []args){
		int i=5;
		int j=2;
		System.out.println("i+j="+i+j); // 52
		System.out.println("i-j="+(i-j)); //3
		System.out.println("i*j="+(i*j)); //10
		System.out.println("i/j="+(i/j)); //2
		System.out.println("i%j="+(i%j)); //1

		System.out.println("i="+i); //i=5
		
		int k=i++; //i=5
		System.out.println("k="+k);//k=5
		System.out.println("i="+i);//i=6
		//i=6
		int p=++i; //i=7 
		System.out.println("p="+p);//p=7
		System.out.println("i="+i);//i=7

		int x=19 + 4 * 3 / 2 - 10 * 2 + 4; // 19+ 6 -20 + 4 = 9 

		System.out.println("19+4*3/2-10*2+4="+x);//9
	}	
}