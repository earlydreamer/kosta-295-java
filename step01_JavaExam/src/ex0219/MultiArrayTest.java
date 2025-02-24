package ex0219;

public class MultiArrayTest {

	public void test() {
		int[][] array = new int[1][3];
		// int [][] arr = {{1,2},{2},{3}};
		int[][] arr = new int[3][];

		arr[0] = new int[5];
		arr[1] = new int[] { 1, 2, 3, 4 };
		arr[2] = new int[5];

//		System.out.println(array);
//		System.out.println(arr);
//		System.out.println(arr[0]);
//		System.out.println(arr[0][0]);
//		System.out.println(arr[0].length);
//		System.out.println(arr.length);

		for (int i = 0; i < arr.length; i++) {
			//System.out.println(arr[i]);
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MultiArrayTest test = new MultiArrayTest();
		test.test();

	}

}
