package ex0224.inheritance;
class CarCenter{
	public void engineer(Car cd){
		System.out.print(cd.carname+" 수리완료!\t");
		System.out.println("청구비용"+cd.cost+" 원");
		
		//부모타입 변수로는 자식부분 접근 불가
		//System.out.println("cd.var = " + cd.var);
		//cannot be cast to class 에러 발생함
		
		//부모자식간에서는 부모가 더 크다고 판정한다.
		// 부모> 자식
		// 전달된 참조변수에 자식부분이 있으므로 접근이 가능하도록 하려면 downcast가 필요
		//타입 변수 = (자식형)변수;		
	
		if (cd instanceof EfSonata) {// instanceOf -> 왼쪽의 변수형이 오른쪽의 타입과 같거나 서브클래스일때 True를 반환
			EfSonata cd2 = (EfSonata) cd; 
			// 무조건 캐스팅이 가능한게 아니라 cd가 efSonata로 캐스팅이 가능할때만 캐스팅이 되어야 한다(instanceOf)를 사용해야함 


			System.out.println(cd2);
			System.out.println(cd2.var);
		}

	}
}

public class PolymorphismExam{
	public static void main(String[] args) {
		
		CarCenter cc=new CarCenter();
		EfSonata ef=new EfSonata();
		Carnival ca=new Carnival();
		Excel ex=new Excel();
		
		Car c= new Car();
		
		System.out.println("ef = "+ef);
		System.out.println("ef.var" );
	
		
		
		
		
		cc.engineer(c);//
		cc.engineer(ef);//
		cc.engineer(ca);//
		cc.engineer(ex);//
		
		
	
	}
}
