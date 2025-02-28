package ex0226.exception;

public class ExceptionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("---main---");
		System.out.println("args = " + args);

		try {
			String param = args[0];
			System.out.println("args[0] " + param); //Array의 길이가 0일 경우 Exception
			int i= Integer.parseInt(param); //파라미터가 int가 아닐 경우 Exception
			System.out.println(i);
			
			int result = 100/i; //i가 0일 경우 Exception
			System.out.println(result);
		
		} catch (Exception e) {
			
//			System.out.println(e); // e.toString()
//			System.out.println(e.getMessage()); //message 부분만 -> Client에 보여줄때...
			e.printStackTrace();//로그에 Exception 내용을 찍고 계속 실행 -> Log를 백엔드단에서 기록할때
			
		}/*catch(ArrayIndexOutOfBoundsException e) { 
		//상위 Exception이 먼저 찍혔으므로 여기로는 진입하지 못한다
		//
			
		}*/finally {
			System.out.println("Exception과 관계없이");;
		}
		

		System.out.println("----------");

	}

}
