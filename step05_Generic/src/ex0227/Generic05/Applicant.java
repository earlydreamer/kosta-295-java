package ex0227.Generic05;


/**
 * 신청 -> 누가 신청을 하는가...
 */
public class Applicant <T> {
	private T kind;

	
	//getter - setter
	
	public T getKind() {
		return kind;
	}

	public void setKind(T kind) {
		this.kind = kind;
	}
	
	/*
	 *  
	 * @param kind
	 */
	public Applicant(T kind){
		this.kind = kind; 
	}

	public Applicant() {
		// TODO Auto-generated constructor stub
	}
	

}
