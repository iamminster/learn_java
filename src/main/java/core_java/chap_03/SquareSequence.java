package core_java.chap_03;

public class SquareSequence implements IntSequence {

	private int i;
	
	public SquareSequence() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public int next() {
		i++;
		return i * i;
	}

}
