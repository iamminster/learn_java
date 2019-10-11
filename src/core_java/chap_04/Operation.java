package core_java.chap_04;

public enum Operation {
	ADD {
		@Override
		public int eval(int arg1, int arg2) {
			return arg1 + arg2;
		}
	},
	SUBTRACT {
		@Override
		public int eval(int arg1, int arg2) {
			return arg1 - arg2;
		}
	},
	MULTIPLY {
		@Override
		public int eval(int arg1, int arg2) {
			return arg1 * arg2;
		}
	},
	DIVIDE {
		@Override
		public int eval(int arg1, int arg2) {
			return arg1 / arg2;
		}
	};

	public abstract int eval(int arg1, int arg2);
}
