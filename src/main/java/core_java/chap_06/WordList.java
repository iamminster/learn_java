package core_java.chap_06;

import java.util.ArrayList;

public class WordList extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7010330809297425309L;

	public boolean add(String s) {
		return super.add(s);
	}

	public String get(int i) {
		return super.get(i).toString();
	}

	public void test(int i1, int i2, int i3, int i4, int i5, double d6) {	
		this.add("null");
		double result = i1 + i2 + i3 + i4 + i5 + d6;

		System.out.println(result);
		return;
	}
}
