package core_java.chap_06;

import java.util.ArrayList;

public class Ex06 {

	public Ex06() {
		// TODO Auto-generated constructor stub
	}
	
	public static <E> void append(ArrayList<E> destination, ArrayList<E> source) {
		destination.addAll(source);
	}
	
	public static <E> void append2(ArrayList<? super E> destination, ArrayList<? extends E> source) {
		destination.addAll(source);
	}

}
