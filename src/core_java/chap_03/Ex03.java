package core_java.chap_03;

public class Ex03 {

	interface IntSequence {
		static IntSequence of(int... list) {
			return new IntSequence() {
				private int pos = 0;

				@Override
				public int next() {
					return hasNext() ? list[pos++] : 0;
				}

				@Override
				public boolean hasNext() {
					return pos < list.length;
				}
			};
		}

		static IntSequence constant(int i) {
			return () -> i;
		}
		
		default boolean hasNext() {
			return true;
		};

		int next();
	}

	public Ex03() {
		// TODO Auto-generated constructor stub
	}

}
