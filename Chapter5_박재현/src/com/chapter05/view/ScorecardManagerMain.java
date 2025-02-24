
/*
 * 패키지명은 클래스명과 식별을 쉽게 하기 위해 기본적으로 모두 소문자로 시작한다. camelCase 여부는 구분하지 않으나 가능한 한 단어로 구성한다.
 */

package com.chapter05.view;
import com.chapter05.controller.ScoreManager;

/**
 * Main함수 호출용 클래스
 */
public class ScorecardManagerMain {

	public static void main (String args[]) {
		//View.getInstance(); 
		//명시적으로 초기화 안했는데 그러면 View 인스턴스는 어느 시점에 초기화되는거지 ...
		
		ScoreManager manager = new ScoreManager();
		manager.InputMenuLogic();
		
		
	}
	
}
