//TwoDmArrayExam.java
package ex0219.ex0219_박재현;
class TwoDmArray {
	// String을 저장하는 twoDmArray 배열선언
	String[][] twoDmArray = new String[10][];
	// 메소드 make2DmArray
	// twoDmArray 배열에 값을 할당
	void make2DmArray() {
		for (int i = 0; i < 10; i++) {
			
			twoDmArray[i] = new String[i+1];
			for (int j = 0; j <= i; j++) {
				twoDmArray[i][j] = (i+1)+"동"+ (j+1)+"호";
				
			}
		}
	}
	
	// 메소드 print2DmArray
	// twoDmArray 배열의 값을 주어진형식으로 출력
	void print2DmArray() {
		//System.out.println(length);
		int emptyPos = 0;
		for(int i=0;i<10;i++) {
			emptyPos = twoDmArray[i].length-1;
			for(int j=0;j<10;j++) {
				if(j<emptyPos)
					System.out.print("	");
				else
					System.out.print(twoDmArray[j][i] + "	");
			}
			System.out.println();
		}
	}
}


public class TwoDmArrayExam {
	// main메소드에서
	public static void main(String args[]) {
		// TwoDmArray객체생성
		TwoDmArray array = new TwoDmArray();
		// TwoDmArray객체의 make2DmArray메소드 호출
		array.make2DmArray();
		// TwoDmArray객체의 print2DmArray메소드 호출
		array.print2DmArray();
	}
}