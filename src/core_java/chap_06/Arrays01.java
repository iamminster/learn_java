package core_java.chap_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import core_java.chap_06.Ex07_08.Pair;

public class Arrays01 {

	public Arrays01() {
	}

	public static <T> void minMax(List<T> elems, Comparator<? super T> comp, List<? super T> results) {
		T min = Collections.min(elems, comp);
		T max = Collections.max(elems, comp);
		results.add(min);
		results.add(max);
	}
	
	public static <E extends Comparable<E>> Pair<E> minMax(ArrayList<E> arr) {
		return new Pair<E>(Collections.min(arr), Collections.max(arr));
	}
	
	public static <E extends Comparable<E>> Pair<E> minMax(E[] arr) {
		if (arr == null) {
			throw new NullPointerException("arr must not null.");
		}
		Arrays.sort(arr);
		return new Pair<E>(arr[0], arr[arr.length - 1]);
	}
	
	public static <E extends Comparable<? super E>> E min(ArrayList<E> arr) {
		return Collections.min(arr);
	}
	
	public static <T extends Comparable<? super T>> T max(ArrayList<T> arr) {
		return Collections.max(arr);
	}
	
	public static <E extends Comparable<? super E>> E min(E[] arr) {
		if (arr == null) {
			throw new NullPointerException("arr must not null.");
		}
		Arrays.sort(arr);
		
		return arr[0];
	}
	
	public static <E extends Comparable<? super E>> E max(E[] arr) {
		if (arr == null) {
			throw new NullPointerException("arr must not null.");
		}
		Arrays.sort(arr);
		
		return arr[arr.length - 1];
	}
	
	public static <E extends Comparable<? super E>> Pair<E> firstLast(ArrayList<? extends E> a) {
		if (a == null) {
			throw new IllegalArgumentException("array must not null");
		}
		E first = a.get(0);
		E last = a.get(a.size() - 1);
		Pair<E> pair = new Pair<>(first, last);
		return pair;
	}
	
	public static <T> void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static <T> T[] swap(int i, int j, T... values) {
		T temp = values[i];
		values[i] = values[j];
		values[j] = temp;
		return values;
	}

	public static <T extends AutoCloseable> void closeAll(ArrayList<T> arr) throws Exception {
		for (T elem : arr) {
			elem.close();
		}
	}

	public static void closeAll(AutoCloseable[] arr) throws Exception {
		for (AutoCloseable elem : arr) {
			elem.close();
		}
	}

	public static void printNames(ArrayList<? extends Employee> staff) {
		for (int i = 0; i < staff.size(); ++i) {
			Employee e = staff.get(i);
			System.out.println(e.getName());
		}
		Employee newEmp = new Employee("Hoang", 1234);
		Manager newMng = new Manager("Hung", 5678);

//		staff.add(newEmp);

	}

	public static <T> void printNames(ArrayList<T> staff, Predicate<T> filter) {
		for (T elem : staff) {
			if (filter.test(elem)) {
				System.out.println(elem);
			}
		}
	}
	
	public static void printAll(ArrayList<Employee> staff, Predicate<? super Employee> filter) {
		for (Employee e : staff) {
			if (filter.test(e)) {
				System.out.println(e);
			}
		}
	}

}
