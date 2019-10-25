package core_java.chap_07;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Ex07 {

	public Ex07() {
		// TODO Auto-generated constructor stub
	}

	public static Map<String, Integer> countWords(String fileName) throws IOException {
		String projDir = System.getProperty("user.dir");
		String separator = System.getProperty("file.separator");
		String content = new String(Files.readAllBytes(Paths.get(projDir + separator + fileName)),
				StandardCharsets.UTF_8);
		String[] words = content.split("\\s");
		Map<String, Integer> counts = new TreeMap<>();
		for (String word : words) {
//			counts.merge(word, 1, Integer::sum);
			counts.put(word, counts.getOrDefault(word, 0) + 1);
		}
		
		return counts;
	}

	public static void main(String[] args) throws IOException {
		Map<String, Integer> wordCounts = countWords("words.txt");
//		for (Entry<String, Integer> entry : wordCounts.entrySet()) {
//			System.out.println(entry.getKey() + ": " + entry.getValue());
//		}
		wordCounts.putIfAbsent("test", null);
//		wordCounts.putIfAbsent(null, 100);
		wordCounts.forEach((s, i) -> {
			System.out.println(s + ": " + i);
		});
		if (wordCounts.get("test") == null) {
			System.out.println("NULLL");
		}
	}

}
