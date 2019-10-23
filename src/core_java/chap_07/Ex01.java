package core_java.chap_07;

import java.util.HashSet;
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

	public static Set<Integer> findPrimesBitSet(int n) {
		
		return null;
	}
	
	public static void main(String[] args) {
		
		Set<Integer> sortedNums = new TreeSet<>();
		
		Set<Integer> primes = findPrimes(100);

		for (int i : primes) {
			System.out.println(i);
		}
	}

}
