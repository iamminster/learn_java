package core_java.chap_06;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.IntFunction;

public class Ex18 {

	public static <T> T[] repeat(int n, T obj, IntFunction<T[]> func) {
		T[] result = func.apply(n);

		for (int i = 0; i < result.length; ++i)
			result[i] = obj;
		return result;
	}

	public static <T> T[] repeat2(int n, T obj, Function<Integer, T[]> func) {
		T[] result = func.apply(n);

		for (int i = 0; i < result.length; ++i)
			result[i] = obj;
		return result;
	}

	public static <T> T[] repeat3(int n, T obj, Class<T> cl) {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) Array.newInstance(cl, n);

		for (int i = 0; i < result.length; ++i)
			result[i] = obj;
		return result;
	}

	public static <T> T[] repeat4(int n, T obj, T[] arr) {
		T[] result;
		if (arr.length >= n) {
			result = arr;
		} else {
			@SuppressWarnings("unchecked")
			T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), n);
			result = newArr;
		}

		for (int i = 0; i < result.length; ++i)
			result[i] = obj;
		return result;
	}

	public static <T> ArrayList<T> repeat5(int n, T obj) {
		ArrayList<T> result = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			result.add(obj);
		}
		return result;
	}

	@SafeVarargs
	public static <T> ArrayList<T> asList(T... args) {
		ArrayList<T> result = new ArrayList<>();
		for (T arg : args) {
			result.add(arg);
		}
		return result;
	}

	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		Entry<String, Integer>[] entries = (Entry<String, Integer>[]) new Entry<?, ?>[100];
		Entry<String, Integer> entry = new Entry<>("hello", 10);
		entries[0] = entry;

		String[] greets = repeat(10, "Hello", String[]::new);
		for (String greet : greets) {
			System.out.println(greet);
		}
		String[] greets3 = repeat3(10, "goodbye", String.class);
		for (String greet : greets3) {
			System.out.println(greet);
		}
	}
}
