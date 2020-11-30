package core_java.chap_06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Ex01 {

	public Ex01() {
		// TODO Auto-generated constructor stub
	}

	public static class Stack<E> {
		private List<E> stack = new ArrayList<E>();
		private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

		public E push(E elem) {
			try {
				lock.writeLock().lock();
				stack.add(elem);
				return elem;
			} finally {
				lock.writeLock().unlock();
			}
		}

		public E pop() {
			try {
				lock.writeLock().lock();
				if (!stack.isEmpty())
					return stack.remove(stack.size() - 1);
			} finally {
				lock.writeLock().unlock();
			}
			return null;
		}

		public boolean isEmpty() {
			return stack.isEmpty();
		}

		public int size() {
			return stack.size();
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			for (E elem : stack) {
				builder.append(elem + " ");
			}
			return builder.toString();
		}
	}

}
