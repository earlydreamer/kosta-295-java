
package ex0218;
//MethodOverloadingExam.java
class OverloadedMethod{
	private int i; //멤버필드 0
       
	public void  setOverload(int i){
		this.i = i; //인수로 전달된 지역변수의 값을 전역변수에 저장
	}
	
	public int getOverload(){
		return i; // this.i
	}
	
	//setOverload를 Overloading하세요. 리턴도 하세요.	
	
	public int setOverload(double i) {
		// cast double to int
		this.i=(int)i;
		return this.i;
	}
	
	//setOverload를 또 Overloading 하세요. 또 다른 놈으로 리턴 하세요.

	public String setOverload(String i) {
		// cast String i to int
		this.i = Integer.parseInt(i);
		return i;
	}
	
	//setOverload를 또 또Overloading 하세요. 리턴 안해요

	public void setOverload(float i) {
		// cast float i to int
		this.i=(int)i;
	}

	
	//getOverload를 Overloading하세요. 리턴도 하세요.
	public int getOverload(double i) {
		// cast double i to int
		return (int)i;
		
	}
	
	//getOverload를 또 Overloading 하세요. 또 다른 놈으로 리턴 하세요.
	public int getOverload(String i) {
		// cast String i to int
		return (int)Integer.parseInt(i);
		
	}
	
	
	//getOverload를 또 또Overloading 하세요. 리턴 안해요
	public void getOverload(int i) {
		//do nothing
	}
		
	
	
	
}




class  MethodOverloadingExam{
       
  public static void main(String [] agr){
     //OverloadedMethod객체에서 호출가능한  메소드들을 한번씩 호출하세요.
        
	}   


}

