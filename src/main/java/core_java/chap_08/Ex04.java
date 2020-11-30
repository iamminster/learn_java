package core_java.chap_08;

import java.util.stream.Stream;

public class Ex04 {

	public Ex04() {
		// TODO Auto-generated constructor stub
	}
	
	public static Stream<Double> infiniteStream(long seed, long a, long c, long m) {
		return Stream.iterate((double)seed, p -> p * 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		infiniteStream(1, 0, 0, 0).limit(100).forEach(l -> System.out.println(l));
	}

}
