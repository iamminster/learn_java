package core_java.chap_08;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Ex02 {

	public Ex02() {
		// TODO Auto-generated constructor stub
	}

	public long countSequential(String fileName, int length) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(content.split("\\s"));

		long before = System.currentTimeMillis();
		long counter = words.stream().filter(w -> {
			return w.length() > length;
		}).count();
		long after = System.currentTimeMillis();
		System.out.println("sequence total words = " + counter);

		return after - before;
	}

	public long countParallel(String fileName, int length) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(content.split("\\s"));

		long before = System.currentTimeMillis();
		long counter = words.parallelStream().filter(w -> {
			return w.length() > length;
		}).count();
		long after = System.currentTimeMillis();
		System.out.println("para total words = " + counter);

		return after - before;
	}

	public static void main(String[] args) throws IOException {
		String fileName = "words.txt";
		List<Integer> length = Arrays.asList(0, 10, 20, 30, 40, 50);

//		for (Integer i : length) {
//			System.out.println(countSequential(fileName, 0));
//			System.out.println(countParallel(fileName, 0));
//		}
		Ex02 ex02_p = new Ex02();
		Ex02 ex02_s = new Ex02();
		System.out.println(ex02_s.countSequential(fileName, 1));
		System.out.println(ex02_s.countSequential(fileName, 1));
		System.out.println(ex02_p.countParallel(fileName, 1));
	}

}
