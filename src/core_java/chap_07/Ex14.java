package core_java.chap_07;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Ex14 {

	public Ex14() {
		// TODO Auto-generated constructor stub
	}
	
	public static Iterator<Integer> immutableListView(int n) {
		return new Iterator<Integer>() {
			private int current;
			@Override
			public boolean hasNext() {
				return current <= n;
			}

			@Override
			public Integer next() {
				if (this.current > n) {
					throw new NoSuchElementException("too far");
				}
				return current++;
			}
			
		};
	}

	public static void main(String[] args) {
		Iterator<Integer> iter = immutableListView(10);
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
