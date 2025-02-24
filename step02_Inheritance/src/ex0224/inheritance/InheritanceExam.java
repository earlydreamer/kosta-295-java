package ex0224.inheritance;


class Car{ //최상위 Class인 Object를 상속받고 있다
		public String carname;
		public int cost;
		
		protected void printAttributes(){
			System.out.println("carname="+this.carname+"\tcost="+cost);
		}
}

//Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성	
	//각 클래스에 인수를 받지않는 생성자 작성
	//각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당
	

class EfSonata extends Car{ //Efsonata는 Car를 상속받는다.
	int var = 100;
	
	
	
	EfSonata(){
		
		this.carname = "EfSonata"; //상속받은 부모의 public 변수에 값을 바로 넣을 수 있다
		this.cost = 0; //적당한값 
	}
	
	
}

class Excel extends Car{
	Excel(){
		carname = "Excel"; //this 생략 가능
		cost = 1; //적당한값
	}

}

class Carnival extends Car{
	String carname;
	Carnival(){
		this.carname = "Carnival";
		super.carname = "Car"; //
		this.carname = "carnival";

		cost = 2; //적당한값
	}
	
}



public class InheritanceExam{
	//메인메소드에서 

	public static void main (String args[]) {
		 Car car = new Car();
		 EfSonata efsonata = new EfSonata();
		 Excel excel = new Excel();
		 Carnival carnival = new Carnival();
		 
		 car.printAttributes(); //초기화안했으니까 Default 값이 나옴
		 efsonata.printAttributes(); 
		 excel.printAttributes();
		 carnival.printAttributes();

		 System.out.println(car);
		 System.out.println(efsonata);
		 System.out.println(excel);
		 System.out.println(carnival);
		 
		 
		 //Car, EfSonata, Excel, Carnival 네개의 객체를 생성
			// 각 클래스에서 Car calss에있는 printAttributes()메소드를 호출할수있다.
		 car.printAttributes(); // 
		 carnival.printAttributes(); //
	}
	
}

