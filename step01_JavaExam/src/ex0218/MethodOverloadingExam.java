
package ex0218;
//MethodOverloadingExam.java
class OverloadedMethod{
	private int i; //����ʵ� 0
       
	public void  setOverload(int i){
		this.i = i; //�μ��� ���޵� ���������� ���� ���������� ����
	}
	
	public int getOverload(){
		return i; // this.i
	}
	
	//setOverload�� Overloading�ϼ���. ���ϵ� �ϼ���.	
	
	public int setOverload(double i) {
		// cast double to int
		this.i=(int)i;
		return this.i;
	}
	
	//setOverload�� �� Overloading �ϼ���. �� �ٸ� ������ ���� �ϼ���.

	public String setOverload(String i) {
		// cast String i to int
		this.i = Integer.parseInt(i);
		return i;
	}
	
	//setOverload�� �� ��Overloading �ϼ���. ���� ���ؿ�

	public void setOverload(float i) {
		// cast float i to int
		this.i=(int)i;
	}

	
	//getOverload�� Overloading�ϼ���. ���ϵ� �ϼ���.
	public int getOverload(double i) {
		// cast double i to int
		return (int)i;
		
	}
	
	//getOverload�� �� Overloading �ϼ���. �� �ٸ� ������ ���� �ϼ���.
	public int getOverload(String i) {
		// cast String i to int
		return (int)Integer.parseInt(i);
		
	}
	
	
	//getOverload�� �� ��Overloading �ϼ���. ���� ���ؿ�
	public void getOverload(int i) {
		//do nothing
	}
		
	
	
	
}




class  MethodOverloadingExam{
       
  public static void main(String [] agr){
     //OverloadedMethod��ü���� ȣ�Ⱑ����  �޼ҵ���� �ѹ��� ȣ���ϼ���.
        
	}   


}

