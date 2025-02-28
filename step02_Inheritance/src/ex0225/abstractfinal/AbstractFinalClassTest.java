package ex0225.abstractfinal;

//Error 를 수정하고 이유를 주석으로 처리하세요.

final class FinalClassExam{  //상속 불가능
 final int i = -999999;  //갑 변경 불가능
}


abstract class AbstractClassExam{ //상속 가능 생성 불가
    abstract String abstractMethodExam(int i,String s);    
    final int finalMethodExam(int i, int j){ 
        return i+j;
    }
}


class Sample01 extends AbstractClassExam{
	String abstractMethodExam(int i,String s){
		System.out.println("return "+s+i);
		return s+i;
	}
	
//	int finalMethodExam(int i, int j){ //Final이므로 Override 불가능
//		return i*j;
//	}
	
}

//class Sample02 extends FinalClassExam{  } //Final 클래스는 상속불가능함


 
abstract class Sample03 extends AbstractClassExam{ //abstract를 포함하고 있음. abstract로 선언되어야 한다
	 String abstractMethodExam(int i,String s){ //중복 메소드가 있음
		return s+i;
	 }
	//abstract String abstractMethodExam(int i); //중복디자인은 일반구매  수량구매 ㄱ능
	 

	void sampleMethod03(){
		System.out.println("void sampleMethod03() 호출 됨");
	}
}

class AbstractFinalClassTest{
    public static void main(String args[]){
//		AbstractClassExam ace = new AbstractClassExam(); //AbastractClass 생성불가능하다
		FinalClassExam fce = new FinalClassExam();
		//fce.i=100000; //final 필드는 변경불가하다
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam(700,"_999");
	}
}
