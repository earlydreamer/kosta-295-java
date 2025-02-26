package ex0224.override;
class ObjectExam{
	String returnText;
	@Override
	public String toString() {//Object형에 선언되어있는 toString을  Override
		if(returnText!=null)
			return returnText;//null이 아니면 return 
		else
			return super.toString();//null이면 super의 toString()을 호출
	}
	
	public ObjectExam(){   }
	public ObjectExam(String str){returnText=str;   }
}
public class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="장희정"; 
			String s02="Java";
			String s03=new String("월요일");
			ObjectExam oe1=new ObjectExam();
			ObjectExam oe2=new ObjectExam("안녕");
			System.out.println(c);//

			//println은 Object타입을 받아서 toString을 돌려서 출력하는 방식으로 동작함.
			//모든 객체의 부모인 Object 타입안에 toString이 정의되어있기 때문에 Object 타입의 toString이 동작한다.
			//String 타입은 저장된 String을 리턴하도록 오버라이딩 되어있기 때문에 지정된 텍스트가 출력된다.
			
			System.out.println(s01);//System.out.println(s01.toString()); 과 같다
			System.out.println(s02);//String객체는 이미 String타입이므로 변환되지 않는다. String이 toString()에서 자기자신의 텍스트를 리턴하도록 오버라이딩되어있기 때문에
			System.out.println(s03);//
			System.out.println(oe1);//생성자에서 String을 넣어주지 않으므로 returnText는 null이다 -> toString 오버라이드에 의해 super의 toString()이 호출된다
			System.out.println(oe2);//전달된 텍스트가 출력된다.
			
	}
}
