package ex0310;

import java.util.function.Function;

class Utils {
	public static int square(int x) {
		return x * x;
	}
}

public class MethodReferenceExam01 {
    public static void main(String[] args) { 
        //������� 
        Function<Integer, Integer>  beforeSquare =  new Function<Integer, Integer>() { 
     @Override 
     public Integer apply(Integer t) { 
       return Utils.square(t); 
           } 
    }; 
		
		//���� ���
		Function<Integer,Integer> lambdaSquare = (t) -> Utils.square(t);
		
		//Static �޼ҵ� ���� ���� : ���ٸ� ����ȭ
		//���� �ȿ����� �����ִ�
		Function<Integer,Integer> methodRefSquare = Utils::square; //�� �ڸ����� ������ apply�� �ְ�, ���ڰ� �� �ڸ��� �ִٴ� ����� ���������� ����
		
		System.out.println(beforeSquare.apply(5));
		System.out.println(lambdaSquare.apply(5));
		System.out.println(methodRefSquare.apply(5));
				
	}
}


