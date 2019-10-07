package core_java.chap_03;

import java.math.BigInteger;

public class Ex06 {

	public class SquareSequence implements Sequence<BigInteger> {
		private Integer value = 1;
		
		@Override
		public BigInteger next() {
			BigInteger v = BigInteger.valueOf(value.intValue());
			value++;
			return v.multiply(v);
		}
		
	}
	
	public Ex06() {
		// TODO Auto-generated constructor stub
	}

}
