package ex0226.exam;

public class Elec {
	protected String code; // 상속해야하므로 protected로 선언한다...
	protected int cost;

//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Elec [code=");
//		builder.append(code);
//		builder.append(", cost=");
//		builder.append(cost);
//		builder.append("]");
//		return builder.toString();
//	} // toString 안 씀...

	Elec(){
		
	}
	public Elec(String string, int i) {

		this.code = string;
		this.cost = i;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	

}
