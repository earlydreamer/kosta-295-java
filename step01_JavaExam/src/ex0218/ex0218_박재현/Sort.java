package ex0218.ex0218_박재현;


class SortLogic {
	
	int[] arraySort = {5,4,1,3,2};
	int temp;
	
	void bubbleSort() {
		
		int length = arraySort.length;
		for (int i=length-1; i>0;i--) {
			for(int k : arraySort)
				System.out.print(k);			
			for (int j=0;j<i;j++){
				if(arraySort[j]>arraySort[i]) {
					temp=arraySort[i];
					arraySort[i]=arraySort[j];
					arraySort[j]=temp;
							
				}					
			}
			System.out.println();
		}
		
	}
	
	void quickSort() {
	
		
	}
	
	void selectionSort() {
		
	}
	
	void insertSort() {
		
	}
}

public class Sort {



	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortLogic sort = new SortLogic();
		sort.bubbleSort();
	}

}
