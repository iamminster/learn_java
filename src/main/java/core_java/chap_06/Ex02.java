package core_java.chap_06;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex02 {

	public Ex02() {
	}

	public static class StackEA<E> {

		// TODO: handle for multiple thread
		private E[] stack;
		private int pos;

		@SuppressWarnings("unchecked")
		public StackEA(Class<E> cl, int capacity) {
			if (capacity <= 0) {
				throw new IllegalArgumentException("size must be larger than 0.");
			}
			stack = (E[]) Array.newInstance(cl, capacity);
			pos = -1;

		}

		public void push(E item) {
			if (pos == stack.length - 1) {
				stack = Arrays.copyOf(stack, stack.length * 2);
			}
			stack[++pos] = item;
		}

		public E pop() {
			if (isEmpty()) {
				throw new IllegalStateException("stack is empty.");
			}
			return stack[pos--];
		}

		public boolean isEmpty() {
			return (pos == -1);
		}
	}

	public static class StackOA<E> {
		private Object[] stack;
		private int pos;
		
		
		public StackOA(int capacity) {
			if (capacity <= 0) {
				throw new IllegalArgumentException("size must be larger than 0.");
			}
			stack = new Object[capacity];
			pos = -1;
		}
		
		public void push(E item) {
			if (pos == stack.length -1) {
				stack = Arrays.copyOf(stack, stack.length * 2);
			}
			stack[++pos] = item;
		}
		
		
		@SuppressWarnings("unchecked")
		public E pop() {
			if (isEmpty()) {
				throw new IllegalStateException("stack is empty.");
			}
			return (E) stack[pos--];
		}
		
		public boolean isEmpty() {
			return pos == -1;
		}
	}
	
}
