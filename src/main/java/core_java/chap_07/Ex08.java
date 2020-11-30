package core_java.chap_07;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ex08 {

	public Ex08() {
		// TODO Auto-generated constructor stub
	}

	public static void lineCounts(int lineNo, String lines, Map<String, Set<Integer>> counter) {
		List<String> words = new ArrayList<>(Arrays.asList(lines.split("\\s")));

		words.forEach(word -> {
			counter.compute(word, (String key, Set<Integer> oldValue) -> {
				Set<Integer> newValue;
				if (oldValue == null) {
					newValue = new HashSet<>();
				} else {
					newValue = oldValue;
				}
				newValue.add(lineNo);
				return newValue;
			});
		});
	}

	public static Map<String, Set<Integer>> count1(String fileName) throws IOException {
		String dir = System.getProperty("user.dir");
		String separator = System.getProperty("file.separator");
		String content = new String(Files.readAllBytes(Paths.get(dir + separator + fileName)), StandardCharsets.UTF_8);
		ArrayList<String> lines = new ArrayList<>(Arrays.asList(content.split("\\n")));
		
		Map<String, Set<Integer>> hmap = new HashMap<String, Set<Integer>>();
		
		for (int i = 0; i < lines.size(); ++i) {
			lineCounts(i, lines.get(i), hmap);
		}

		return hmap;
	}
	
	public static Map<String, Set<Integer>> count2(String fileName) throws IOException {
		String dir = System.getProperty("user.dir");
		String separator = System.getProperty("file.separator");
		String content = new String(Files.readAllBytes(Paths.get(dir + separator + fileName)), StandardCharsets.UTF_8);
		ArrayList<String> lines = new ArrayList<>(Arrays.asList(content.split("\\n")));
		
		for (String line : lines) {
			System.out.println("line: " + line);
		}
		
		Map<String, Set<Integer>> result = new HashMap<String, Set<Integer>>();
		
		int lineNo = 1;
		
		for (String line : lines) {
			List<String> words = new ArrayList<>(Arrays.asList(line.split("\\s")));
			words.forEach(word -> {
				System.out.println("word: " + word);
			});
			
			for (String word : words) {
				Set<Integer> mySet = new HashSet<>(Arrays.asList(lineNo));
				result.merge(word, mySet, (add, ret) -> {
					ret.addAll(add);
					return ret;
				});
			}
			++lineNo;
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException {

		Map<String, Set<Integer>> myMap = count2("words.txt");
		
		for (Entry<String, Set<Integer>> entry : myMap.entrySet()) {
			if (entry == null) continue;
			System.out.print(entry.getKey() + ": ");
			for (Integer line : entry.getValue()) {
				System.out.print(line + " ");
			}
			System.out.println();
		}
		
		HashMap<String, HashSet<Integer>> hmap = new HashMap<>();

		hmap.compute("Minh", (String k, HashSet<Integer> o) -> {
			return o;
		});
		test(hmap);
	}

	public static void test(Map<String, ? extends Set<Integer>> map) {
		System.out.println("test");
	}

}
