package ex0310;

import java.util.function.Function;

class StringUtils {
	public int getLength(String str) {
		return str.length();
	}
}

public class InstanceMethodReference02 {

	public static void main(String[] args) {
		StringUtils utils = new StringUtils();

		// �������
		Function<String, Integer> beforeLength = new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return utils.getLength(t);
			}
		};

		// ���ٽ� ���
		Function<String, Integer> lambdaLength = s -> utils.getLength(s);

		// �޼ҵ� ���� ���
		Function<String, Integer> methodRefLength = utils::getLength;

		System.out.println(beforeLength.apply("Hello")); // 5
		System.out.println(lambdaLength.apply("Hello")); // 5
		System.out.println(methodRefLength.apply("Hello")); // 5
	}
}
