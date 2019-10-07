package core_java.chap_03;

import java.util.Arrays;

public class Main {

	public static double average(IntSequence seq, int n) {
		double sum = 0;
		int count = 0;
		while (seq.hasNext() && count < n) {
			++count;
			sum += seq.next();
		}
		return count == 0 ? 0 : (sum / count);
	}

	public static void main(String[] args) {
//		core_java.chap_03.Ex03.IntSequence seq = core_java.chap_03.Ex03.IntSequence.constant(1);
//		while (seq.hasNext()) {
//			System.out.println(seq.next());
//		}
		String[] words = { "hello", "my", "name", "is", "Minh"};
		
		Arrays.sort(words, (first, second) -> first.length() - second.length());
		for (String word : words) {
			System.out.println(word);
		}
	}

}
