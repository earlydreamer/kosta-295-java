package ex0227.generic03;

public class Exam03Main {
	
	public static void main (String args[]) {
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
	
		car.run();
		home.room();
		
	
	}

}
