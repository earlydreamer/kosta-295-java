package ex0226.exam;

public class Audio extends Elec implements ElecFunction{
	protected int volumn; //오타가 있어도... 스펙에 넘어온대로 이름을 지어야 한다... 

	public Audio() {
		
	}
	
	public Audio(String string, int i, int j) {
		// TODO Auto-generated constructor stub
		super(string, i);
		this.volumn=j;
	}

	@Override
	public void start() {
//		 다른 메소드에서 String을 리턴하는 println을 사용할 수 있다... 이 포맷에 맞춰서 toString을 오버라이드하면 안 된다
//		System.out.println(this.code +super.getClass()+volumn+"으로 듣는다.");  //getClass -> Class의 이름을 가져올 수 있다
		System.out.println(this.code + "제품 Audio를 "+volumn+"으로 듣는다."); 
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("끈다");	
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		// 이 기능은 Audio에서 사용되지 않을 것으로 예상되는데 이러면 ElecFunctin이 덜 쪼개진 것이겠지...
		// 무의미한 Override	
	}

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}
 
}
