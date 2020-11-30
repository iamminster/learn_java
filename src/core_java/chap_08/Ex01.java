package core_java.chap_08;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex01 {

	public Ex01() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get("words.txt")), StandardCharsets.UTF_8);

		List<String> words = Arrays.asList(content.split("\\s"));
//		
//		words.add("hello");
//		words.add("my");
//		words.add("name");
//		words.add("is");
//		words.add("Minh");
//		words.add("nice");
		long count = words.stream().filter(w -> {
			return w.length() > 2;
		}).peek(w -> {
			System.out.println(w);
		}).limit(10).count();
		System.out.println(count);

		Stream<String> myStr = Stream.of("a", "b", "c", "d", "e", "f", "g");
		Stream<String> myArr = Arrays.stream(words.toArray(new String[15]), 0, words.size() - 1);
		
	}

}
