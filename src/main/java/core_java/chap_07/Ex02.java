package core_java.chap_07;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {

	public Ex02() {
		// TODO Auto-generated constructor stub
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
