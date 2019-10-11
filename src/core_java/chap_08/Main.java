package core_java.chap_08;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Properties;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		Properties props = System.getProperties();
		String userDir = props.getProperty("user.dir");
		System.out.println(userDir);
		String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
//		List<String> words = Arrays.asList(contents.split("\\PL+"));

		// split return a String[] array
		Stream<String> words = Stream.of(contents.split("\\PL+"));
		
		Supplier<Stream<String>> supplier = () -> Stream.of("lady", "imagine", "lady", "words", "imagine", "November");
		
		Stream<String> song = supplier.get();
		
//		song.distinct().forEach(s -> System.out.println(s));

		Stream<String> sortedStr = supplier.get().sorted();
		
		Stream<String> sortedReverse = supplier.get().sorted(Comparator.comparing(String::length));
		
//		sortedStr.forEach(s -> System.out.println(s));
		
//		sortedReverse.forEach(s -> System.out.println(s));
		
		Object[] powers = Stream.iterate(1, p -> p * 2).peek(e -> System.out.println("peek: " + e)).limit(10).toArray();
		
//		Predicate<String> checkLength = w -> {
//			System.out.println(w);
//			return w.length() >= 4;
//		};
//		long count = 0;
//		count = words.filter(w -> {
//			System.out.println(w);
//			return w.length() < 4;
//		}).count();
//		for (String word : words) {
//			System.out.println(word);
//			if (word.length() >= 4) {
//				++count;
//			}
//		}

//		System.out.println(count);
//
//		Stream<String> echos = Stream.generate(() -> "echo");
//
//		Stream<Double> randoms = Stream.generate(Math::random);
//
//		BigInteger limit = new BigInteger("1");
//
//		Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
//
//		integers.filter(e -> limit.compareTo(e) > 0).forEach(e -> System.out.println(e));

//		words.forEach(w -> System.out.print(w));
	}

}
