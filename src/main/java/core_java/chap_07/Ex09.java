package core_java.chap_07;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex09 {

	public Ex09() {
		// TODO Auto-generated constructor stub
	}

	public static Map<String, Integer> wordCounts(String fileName) throws IOException {
		String dir = System.getProperty("user.dir");
		String separator = System.getProperty("file.separator");
		String contents = new String(Files.readAllBytes(Paths.get(dir + separator + fileName)), StandardCharsets.UTF_8);

		List<String> words = new ArrayList<>(Arrays.asList(contents.split("\\s")));

		Map<String, Integer> result = new HashMap<>();

		for (String w : words) {
//			result.merge(w, 1, Integer::sum);
			if (result.containsKey(w)) {
				result.put(w, result.get(w) + 1);
			} else {
				result.putIfAbsent(w, 1);
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		Map<String, Integer> hmap = wordCounts("words.txt");

		hmap.forEach((k, v) -> {
			System.out.println(k + ": " + v);
		});
	}

}
