package ex0228.lambda;
@FunctionalInterface
public interface TestInterfaceC {

	int testC(int i,int j);
//	void test(); // 하나를 더 선언하면 FunctionalInterface가 아니게 되므로 컴파일 에러가 난다
}
