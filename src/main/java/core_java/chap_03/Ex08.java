package core_java.chap_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ex08 {

	public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
		while (!isSorted(strings, comp)) {
			Collections.shuffle(strings);
		}
	}
	
	private static boolean isSorted(ArrayList<String> strings, Comparator<String> comp) {
		for (int i = 0; i < strings.size() - 1; ++i) {
			if (comp.compare(strings.get(i), strings.get(i + 1)) > 0) {
				return false;
			}
		}
		return true;
	}

	public Ex08() {
		// TODO Auto-generated constructor stub
	}

}
