package core_java.chap_08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ex05 {

	public Ex05() {
		// TODO Auto-generated constructor stub
	}
	
	public static Stream<Integer> codePoints(String s) {
		List<Integer> result = new ArrayList<>();
		int i = 0;
		
		while (i < s.length()) {
			result.add(s.codePointAt(i++));
		}
		
		return result.stream();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		codePoints("hello").forEach(i -> System.out.println(i));
	}

}
