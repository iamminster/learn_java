package core_java.chap_07;

import java.util.List;
import java.util.RandomAccess;

public class Ex05 {

	public Ex05() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void swap(List<?> list, int i, int j) {
		if (list instanceof RandomAccess) {
			raSwap(list, i, j);
		}
		else {
			optimizedSwap(list, i, j);
		}
	}

	private static <T> void optimizedSwap(List<T> list, int i, int j) {
		
	}

	private static <T> void raSwap(List<T> list, int i, int j) {
		T temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

}
