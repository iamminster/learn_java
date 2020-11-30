package core_java.chap_06;

import java.util.ArrayList;

public class Ex03 {

	public Ex03() {
	}

	public static class Table<K, V> {
		private ArrayList<Entry<K, V>> elems;

		public Table() {
			elems = new ArrayList<>();
		}

		public V get(K key) {
			for (Entry<K, V> elem : elems) {
				if (elem.getKey().equals(key)) {
					return elem.getValue();
				}
			}
			return null;
		}

		public void put(K key, V value) {
			for (Entry<K, V> elem : elems) {
				if (elem.getKey().equals(key)) {
					elem.setValue(value);
					return;
				}
			}
			elems.add(new Entry<>(key, value));
		}

		public boolean remove(K key) {
			for (Entry<K, V> elem : elems) {
				if (elem.getKey().equals(key)) {
					return elems.remove(elem);
				}
			}
			return false;
		}
	}

}
