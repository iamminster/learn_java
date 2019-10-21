package core_java.chap_06;

public class Ex07_08 {

	public Ex07_08() {
	}
	
	public static class Pair<E extends Comparable<? super E>> {
		private E first;
		private E second;
		
		public Pair(E first, E second) {
			this.setFirst(first);
			this.setSecond(second);
		}

		public E getFirst() {
			return first;
		}

		public void setFirst(E first) {
			this.first = first;
		}

		public E getSecond() {
			return second;
		}

		public void setSecond(E second) {
			this.second = second;
		}
		
		public E max() {
			return first.compareTo(second) >= 0 ? first : second;
		}
		
		public E min() {
			return first.compareTo(second) <= 0 ? first : second;
		}
		
		@Override
		public String toString() {
			return first.toString() + ", " + second.toString();
		}
		
	}

}
