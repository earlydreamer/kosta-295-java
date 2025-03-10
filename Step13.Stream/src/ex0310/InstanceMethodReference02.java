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

		// 기존방식
		Function<String, Integer> beforeLength = new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return utils.getLength(t);
			}
		};

		// 람다식 방식
		Function<String, Integer> lambdaLength = s -> utils.getLength(s);

		// 메소드 참조 방식
		Function<String, Integer> methodRefLength = utils::getLength;

		System.out.println(beforeLength.apply("Hello")); // 5
		System.out.println(lambdaLength.apply("Hello")); // 5
		System.out.println(methodRefLength.apply("Hello")); // 5
	}
}
