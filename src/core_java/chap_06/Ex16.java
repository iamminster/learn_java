package core_java.chap_06;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ex16 {
	public static <T extends Comparable<? super T>> void sort(List<T> list) {
		Collections.sort(list);
	}
	
	public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) {
		return Collections.max(coll);
	}
}
