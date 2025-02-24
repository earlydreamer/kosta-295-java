package ex0219;

public class ArgsExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int length=args.length;
		int tot=0;
//		for(int i=0;i<length;i++)
//			tot+=Integer.parseInt(args[i]);
		
		for(String s : args) {
			tot+= Integer.parseInt(s);
		}

		
		System.out.println(tot);
		
		

		
		
	}

	/**
	 * 컴파일 후 실행 -> java 파일명 args 
	 * 
	 */
	
}
