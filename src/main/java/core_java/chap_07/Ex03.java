package core_java.chap_07;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex03 {

	public Ex03() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> s1 = new HashSet<>();
		s1.add("sex");
		s1.add("drugs");
		s1.add("kill");
		s1.add("guns");

		Set<String> s2 = new TreeSet<>();
		s2.add("Minh");
		s2.add("Dung");
		s2.add("Hoang");
		s2.add("Quan");
		s2.add("Long");
		s2.add("sex");

		Set<String> result = difference(s1, s2);
		
		for (String rs : result) {
			System.out.println(rs);
		}
	}

	public static <T> Set<T> union(Set<T> s1, Set<T> s2) {
		Set<T> result = new HashSet<>(s1.size() + s2.size());
		result.addAll(s1);
		result.addAll(s2);

		return result;
	}

	public static <T> Set<T> intersection(Set<T> s1, Set<T> s2) {
		Set<T> result = new HashSet<>(s1.size() + s2.size());
		result.addAll(s1);
		result.retainAll(s2);

		return result;
	}

	public static <T> Set<T> difference(Set<T> s1, Set<T> s2) {
		Set<T> result = new HashSet<>(s1.size() + s2.size());
		result.addAll(s1);
		result.removeAll(s2);

		return result;
	}

}
