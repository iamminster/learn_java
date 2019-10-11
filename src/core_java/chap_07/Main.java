package core_java.chap_07;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	public static void increaseCount(Map<String, Integer> counts, String word) {
		counts.merge(word, 1, Integer::sum);
	}

	public static void main(String[] args) {

		Map<String, Integer> counts = new HashMap<>();
		counts.put("Alice", 1);
		counts.put("Bob", 2);
		counts.put("Alice", 5);
		
		System.out.println(counts.get("Alice"));
		System.out.println(counts.get("Minh"));
		increaseCount(counts, "Minh");
		increaseCount(counts, "Minh");
		increaseCount(counts, "Minh");
		increaseCount(counts, "Minh");
		increaseCount(counts, "Minh");
		increaseCount(counts, "Bob");
		
		int count = counts.getOrDefault("Minh", -1);
		System.out.println(count);
		System.out.println(counts.getOrDefault("Bob", -1));
		
//		List<String> friends = new LinkedList<>();
//		ListIterator<String> iter = friends.listIterator();
//		iter.add("Fred");
//		iter.add("James");
//		iter.previous();
//		iter.set("abc");
//		iter.add("Minh");
//		
//		System.out.println(friends.toString());
		
	}

}
