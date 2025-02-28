package ex0227.generic01;

/**
 * Generic Type인 T
 * 아직 결정되지 않은 타입으로 선언하고 실제로 사용될 때 구체적인 타입으로 변환한다
 * @param <T>
 */
public class Box<T> {
	private T content;
		
	
	public T getContent() {
		return content;
	}



	public void T(T content) {
		this.content = content;
	}


	public void setContent(T content) {
		this.content = content;
	}

	Box(){
		
	}
	
	

}
