package core_java.chap_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex01 {

	public Ex01() {
		// TODO Auto-generated constructor stub
	}

	public static Set<Integer> findPrimes(int n) {
		if (n < 2) {
			throw new IllegalArgumentException("n must be equals or greater than 2");
		}

		Set<Integer> primes = new HashSet<>(n);

		// 1. Add all numbers from 2 to n
		for (int i = 2; i <= n; ++i) {
			primes.add(i);
		}

		// 2. Set smallest number s = first elem
		// 3. While s*s <= n do
		for (int i = 2; i <= Math.sqrt((double) n); ++i) {
			if (primes.contains(i)) {
				// 3.1. Set incrementor i = s
				// 3.2. While s * i <= n do
				for (int j = i * i; j <= n; j += i) {
					// 3.2.1. Remove s * i
//				System.out.println(i * j);
					primes.remove(j);
					// 3.2.2. Increase i by 1
				}
			}

			// 3.3. Increase s by 1
		}
		return primes;
	}

	public static List<Integer> findPrimesBitSet(int n) {
		if (n < 2) {
			throw new IllegalArgumentException("n must equals or larger than 2");
		}
		BitSet primes = new BitSet(n);
		for (int i = 2; i <= n; ++i) {
			primes.set(i);
		}
		
		for (int i = 2; i <= Math.sqrt((double) n); ++i) {
			if (primes.get(i)) {
				for (int j = i * i; j <= n; j += i) {
					primes.clear(j);
				}
			}
		}
		List<Integer> result = new ArrayList<>(primes.cardinality());
		int index = primes.nextSetBit(0);
		while (index >= 0) {
			result.add(index);
			index = primes.nextSetBit(index + 1);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		List<String> strLs = new ArrayList<>();
		strLs.add("hello");
		strLs.add("my");
		strLs.add("name");
		strLs.add("is");
		strLs.add("Minh");
//		ListIterator<String> iter = strLs.listIterator();
//		while (iter.hasNext()) {
//			iter.set(iter.next().toUpperCase());
//		}
		
//		for (int i = 0; i < strLs.size(); ++i) {
//			strLs.set(i, strLs.get(i).toUpperCase());
//		}
		
		strLs.replaceAll(String::toUpperCase);
		
		for (String str : strLs) {
			System.out.println(str);
		}
		
	}

}
