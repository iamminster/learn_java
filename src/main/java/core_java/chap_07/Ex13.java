package core_java.chap_07;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ex13 {

	public Ex13() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Cache<String, Integer> myCache = new Cache<>(15);
		int size = 20;
		for (int i = 0; i < size; ++i) {
			myCache.put("Minh" + i, i);
		}

	}

	public static class Cache<K, V> extends LinkedHashMap<K, V> {
		private int limitSize;
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Cache(int size) {
			super(size);
			this.limitSize = size;
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
			if (size() > limitSize)
				System.out.println("Reach limit. removing (" + eldest.getKey() + ", " + eldest.getValue() + ")");
			return size() > limitSize;
		}

	}

}
