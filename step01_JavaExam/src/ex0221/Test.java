package ex0221;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strArr = new String[5];
		strArr[0]="a";
		strArr[1]=null;
		strArr[2]=null;
		strArr[3]="b";
		strArr[4]="c";

		
		int length=strArr.length;
		int eoa = length;
		int nullPos = 0;
		for(int i = nullPos;i<length-1;i++) {
			if(strArr[i]==null) {
				nullPos=i;
				strArr[i]=strArr[i+1];
				if(i!=length)
					strArr[i+1]=null;
			}
		}		
		System.out.println("---");
		for(int i=0;i<length;i++) {
			System.out.println(strArr[i]);
		}

	}
}
