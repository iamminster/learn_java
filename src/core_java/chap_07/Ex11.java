package core_java.chap_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Ex11 {

	public Ex11() {
	}

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("Minh");
		words.add("Dung");
		words.add("Hoang");
		words.add("Long");
		words.add("Hien");
		words.add("Thuong");
		words.add("Hung");
		Collections.shuffle(words.subList(1, words.size() - 1));
		ListIterator<String> iter = words.listIterator();
		
		words.subList(1, words.size() - 1).clear();
		for (String w : words) {
			System.out.println(w);
		}
		
		while (iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
	}

}
