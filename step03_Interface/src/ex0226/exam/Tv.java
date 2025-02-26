package ex0226.exam;

public class Tv extends Elec implements ElecFunction {

	protected int channel;
	
	public Tv() {
		
	}
	
	public Tv(String string, int i, int j) {
		// TODO Auto-generated constructor stub
		super(string, i);
		this.channel = j;
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println(this.code + "제품 TV를 "+channel+"을 본다.");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("끈다");
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("화면이 나오고 있다 ...");
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	
	
}
