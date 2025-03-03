package report.lotto.models;

import java.util.TreeSet;

/**
 * 로또 번호의 Model -> View 전달을 위한 DTO <br>
 * 출력에 사용될 로또 번호 집합을 TreeSet 형식으로 들고 있다. <br>
 * 계층간 값 전달을 위해서만 사용하고 데이터 보관 용도로 사용되지 않는다. 
 * @author 박재현
 * 2025-03-02
 * 
 */

public class LottoDto {

	/*
	 * -------------- Member Variable --------------------
	 */
	
	private TreeSet<Integer> lottoNumber; //정렬이 필요하므로 TreeSet을 사용한다.
	
	
	/*
	 * --------------Constructor --------------------
	 */
	

	LottoDto(){
	}
	
	
	public LottoDto(TreeSet<Integer> lottonumber) {
		this.lottoNumber= lottonumber;
	}

	/*
	 * -------------- Getter-Setter --------------------
	 */



	public TreeSet<Integer> getLottoNumber() {
		return lottoNumber;
	}

	
	/**
	 * 전달받은 로또번호 TreeSet을 그대로 사용
	 * @param lottonumber (TreeSet) Integer형 Set
	 */
	public void setLottonumber(TreeSet<Integer> lottonumber) {
		this.lottoNumber = lottonumber;
	}


	/*
	 * -------------- toString Override --------------------
	 */

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LottoDto [lottonumber=");
		builder.append(lottoNumber);
		builder.append("]");
		return builder.toString();
	}
		
}
