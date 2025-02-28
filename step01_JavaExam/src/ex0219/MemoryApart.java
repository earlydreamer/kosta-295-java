package ex0219;

class MultiArray {
//정수형 2차원 배열 8*9

	int array[][] = new int[8][9];

//메소드이름 :array99

	// for loop 를 사용하여
	// 배열에 곱한 (구구단)결과저장
	// 배열에 결과를 꺼내출력

	void gugu() {
	for(int i = 0;i<8;i++)
		for(int j = 0;j<9;j++) {
			array[i][j]=(i+2)*(j+1);
			System.out.println(array[i][j]);
		}
	
	for(int[] i : array)
		for(int j : i) {
			System.out.println(j);
 
		}
	}
	
	
}

public class MemoryApart{
//main메소드에서 
//MultiArray객체의 array99메소드호출
	public static void main(String args[]) {
		
		MultiArray array = new MultiArray();
		array.gugu();
		
		
	}
	
	
}
