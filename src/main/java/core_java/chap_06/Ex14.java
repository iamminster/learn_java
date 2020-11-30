package core_java.chap_06;

import java.util.ArrayList;

public class Ex14 {

	public static <T extends AutoCloseable> void closeAll(ArrayList<T> elements) throws Exception {
		Exception ex = null;

		for (T elem : elements) {
			try {
				elem.close();
			} catch (Exception e) {
				ex = new Exception(e.getMessage(), ex);
			}
		}
		if (ex != null) {
			throw ex;
		}
	}
}
