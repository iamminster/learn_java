package core_java.chap_06;

import java.util.ArrayList;
import java.util.function.Function;

public class Ex15 {
	public static <T, R> ArrayList<R> map(ArrayList<T> source, Function<T, R> func) {
		ArrayList<R> result = new ArrayList<>(source.size());
		for (T input : source) {
			result.add(func.apply(input));
		}
		return result;
	}
}
