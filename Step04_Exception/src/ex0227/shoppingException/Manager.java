package ex0227.shoppingException;

/**
 * 나중에 Static으로 리팩토링...
 */
public class Manager {
	
	View view = new View();
	Visitor visitor[];
	private static int exceptionCount = 0;

	
//	public Visitor setVisitorAge(Visitor visitor, int age) {
//		visitor.setAge(age);
//		return visitor;
//	}
	
	public Visitor setRandomVisitorAge(Visitor visitor) {
		int age = (int)(Math.random()*55)+1;
		visitor.setAge(age);
		return visitor;
	}
	
	public void visit(Visitor visitor)throws VisitorAgeException {
		
		if(visitor.getAge()>18) {
			view.visitSuccess();
		}else 
			throw new VisitorAgeException(visitor.getAge() + "세는 출입 불가...");
	}
	
	
	Manager(){
		
	}
	
	Manager(int visitorCount){
		visitor = new Visitor[visitorCount];
		for(int i =0; i<visitor.length;i++) {
			visitor[i] = setRandomVisitorAge(new Visitor());
			try{
				visit(visitor[i]);
			}catch (VisitorAgeException e) {
				view.printExceptionMessage(e); 
				exceptionCount++;
			}
		}view.printExceptionCount(exceptionCount);
	}

	public static int getExceptionCount() {
		return exceptionCount;
	}

	
	
	
}
