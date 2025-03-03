package report.lotto.services;

import java.util.TreeSet;


/**
 * 로또 번호 생성기
 * @author 박재현
 * 2025-03-02
 */
public class LottoNumberGenerator implements NumberGenerate {

	public static final int LOTTO_NUMBER_PER_LINE = 6; //한줄에 들어가는 개수
	public static final int LOTTO_MAX_NUMBER = 45; //로또 번호의 최대값

	@Override
	public TreeSet<Integer> numberGenerate() {
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		
//		바뀔일은 없겠지만 로또 규칙이 바뀔 경우 변수의 값을 바꾸면 된다...
		while(lotto.size()<LOTTO_NUMBER_PER_LINE)
			lotto.add(this.randomInt(LOTTO_MAX_NUMBER)); 
		
		return lotto;
		
	}	
	
	
	/**
	 * 1부터 지정된 숫자까지 랜덤한 숫자 뽑아서 Int로 캐스팅해 돌려주는 메소드<br>
	 * @param max (int) 랜덤 돌릴 범위
	 * @return (int) 범위내 랜덤한 int 값
	 */

	//	바퀴를 두번 발명하는 거 같지만 java.util.random 안 배웠으니까...
	int randomInt(int max) {
		return (int)(Math.random()*max)+1;
	}
	
}
