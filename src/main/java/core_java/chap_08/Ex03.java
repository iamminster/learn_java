package core_java.chap_08;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ex03 {

	public Ex03() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] values = {1, 4, 9, 16};
		Stream<Integer> intStr = Arrays.stream(values).boxed();
	}

}
