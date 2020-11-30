package core_java.chap_03;

public interface Sequence<T> {
	default boolean hasNext() {
		return true;
	}
	
	T next();
}
