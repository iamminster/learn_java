package core_java.chap_07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex04 {

	public Ex04() {
	}

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		s.add("Minh");
		s.add("Dung");
		s.add("Hoang");
		s.add("Long");
		s.add("Chien");
		s.add("Thang");
		s.add("Binh");
		
		Iterator<String> i1 = s.iterator();
		Iterator<String> i2 = s.iterator();
		
		i2.next();
		i2.remove();
		
		while (i1.hasNext()) {
			System.out.println(i1.next());
		}
		
	}
}
