package ex0226;

//이 소스를 컴파일이 되도록 수정/추가/주석처리 하세요.
interface InterfaceExam00{
	abstract void interfaceExam00();
}


interface InterfaceExam01 extends InterfaceExam00{
	final int i = 767;
	public int k = 999;//protected -> public / 인터페이스의 선언은 protected가 될 수 없다 (반드시 public static final이다) 
	
	void interfaceExam01(int i, int k);
}



interface InterfaceExam02{
	int j =747;
	public int privateInt = 8; //private int 불가능함 private int -> public int)
	public void interfaceExam02(int j); //private 선언 불가능함 private void -> public void 
	
}



class SuperClassExam{
	String superString = "Super";

	String superMethod(){
		System.out.println("SuperClassExam.SuperMethod()가 호출되었습니다.");
		return "returnString";
	}
}

class SubClassExam01 extends SuperClassExam implements InterfaceExam01{ //인터페이스를 implement로 수정하고 메소드를 오버라이드해 구현부 추가 

	@Override
	public void interfaceExam00() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interfaceExam01(int i, int k) {
		// TODO Auto-generated method stub
		
	}
	
} // extends로 두 개의 부모 호출 못함 다중상속 불가능 인터페이스를 extends -> implements 



 class SubClassExam02 extends SuperClassExam 
				implements InterfaceExam01, InterfaceExam02{

	@Override
	public void interfaceExam00() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interfaceExam02(int j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interfaceExam01(int i, int k) {
		// TODO Auto-generated method stub
		
	} //implement한 인터페이스의 구현부가 없음 override 추가
				

}


abstract class SubClassExam03 
			extends SuperClassExam implements InterfaceExam01, InterfaceExam02{ //implements SuperClassExam -> extends SuperClassExam
	
}//abstract 클래스이므로 구현부 추가 안해줘도 컴파일에러는 나지 않는다
			

class SubClassExam04 extends SubClassExam02{
	//여기에 필요한 것들을 추가하여 문제를 해결하세요..
	@Override
	public void interfaceExam00(){
		System.out.println(j);
	}
	@Override
	public void interfaceExam01(int i, int k){
		System.out.println(i + k);
	}
	@Override  
	public void interfaceExam02(int j){
		System.out.println(j);
	}

	SubClassExam04(){
		System.out.println("subClassExam04() 객체 생성");
		System.out.println(" i = "+i);
		System.out.println(" j = "+j);
	}
	
	SubClassExam04(String s1, String s2){
		System.out.println(s1+" 타입 "+"subClassExam04("+s2+") 객체 생성");
		
	}
	
	void printSuperString(){
//		InterfaceExam01 ie01 = new InterfaceExam01();//인터페이스는 new 객체로 선언할 수 있는 클래스가 아니다 implements 후 구현해주어야한다
		//Inner Class를 통해서 구현하려면 할 수는 있어 보이는데...	

		System.out.println(" superString = "+superString);
	}
}

//여기서부터는 하나도 고치지 마시고 그대로 쓰면 됩니다.
public class ImplememtsInterfaceExam{ 
	public static void main(String args[]){		
		SubClassExam02 sub02sub04 = new SubClassExam04("SubClassExam02", "sub02sub04"); //SubClass02를 상속받았고, 상속받은 부모클래스가 Implements한 인터페이스를 타입으로 쓸수있다
		SuperClassExam  superSub04 = new SubClassExam04("SuperClassExam", "superSub04");
		InterfaceExam01 ifc01Sub04 = new SubClassExam04("InterfaceExam01", "ifc01Sub04");
		SubClassExam04 sub04 = new SubClassExam04();
		sub04.interfaceExam00();
		sub04.interfaceExam01(1,7);
		sub04.superMethod();
	}
}

