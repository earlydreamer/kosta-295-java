package ex0224.override;
//MethodOverridingExam.java
//이 class는 수정하지 마세요.
class SuperClass{
 	protected int intNumber;
 	protected String memberString="Sting in SuperClass";
 	
	SuperClass(){
 		System.out.println("생성자 SuperClass()가 호출되었습니다.");
 	}
 	
	public void methodZero(){
 		System.out.println("SuperClass객체의 methodZero()메소드가 호출되었습니다.");		
		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
	}
 	
 	protected void methodOwn(){
 		System.out.println("SuperClass객체의 methodOwn()메소드가 호출되었습니다.");
		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 	}
 	
	int methodTwo(int i){
 		intNumber=i;
 		System.out.println("SuperClass객체의 methodTwo(int i)메소드가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 		return intNumber;
 	}
 	
	protected String methodThree(int i, String s){
 		intNumber=i;
 		memberString=s;
 		System.out.println("SuperClass객체의 methodThree(int i, String s)메소드가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 		return i+s;
 	}
 	
	public void methodFour(){
 		memberString="methodFour invokes methodOwn";
 		methodOwn();
 	}
}
//SubClass의 Error를 수정하고 Error의 이유를 주석으로 작성하세요.

/*overrriding의 기본조건
	리턴타입,메소드이름,인수 같아야한다
	modifier는 같거나 커야한다.
*/

class SubClass extends SuperClass{
	SubClass(){
		memberString = "SubClass의 생성자가 입력한 String";
 		System.out.println("생성자 SubClass()가 호출되었습니다.");
 	}
 	
	public void methodZero(){//부모보다 제한자가 작을수 없다(protected -> public)
	
		System.out.println("SubClass객체의 methodZero()메소드가 호출되었습니다.");
		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
	}
 	
	protected void methodOwn(){ //부모와 리턴타입이 같아야 한다. 제한자가 작을 수 없으므로 맞춰준다
		
		System.out.println("SubClass객체의 methodOwn()메소드가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 		//return intNumber; //제거
 	}
 	
	int methodTwo(int a){ //부모와 제한자를 맞춰줘야 한다 
 		int intNumber=a;//변수이름은 상관없다
 		System.out.println("SubClass객체의 methodTwo()메소드가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
		return this.intNumber; 
 	}
 	String methodThree(String s, int k){ //오버로딩임
		intNumber=k;
 		memberString=s;
 		System.out.println("SubClass객체의 methodThree()메소드가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 		return memberString;
 	}
	
	protected String methodThree( int k,String str){
 		intNumber=k;
 		memberString=str;
 		System.out.println("SubClass객체의 methodThree()메소드가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 		return memberString;
 	}
 	
	public void methodFour(){ //리턴타입 맞춰줌
	
		System.out.println("SubClass의 public double methodFour()가 호출되었습니다.");
 		memberString="methodFour invokes methodOwn";
 		methodOwn();
 	}
}

//이 class도 수정하지 마세요.
public class MethodOverridingExam{
	public static void main(String [] args){
		SuperClass sp = new SuperClass();
		System.out.println("**************************************");
		SubClass sb = new SubClass();		
		System.out.println("**************************************");
		
		
	}
}					
