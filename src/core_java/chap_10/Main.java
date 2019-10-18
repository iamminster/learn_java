package core_java.chap_10;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

	private static volatile int count = 0;

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Executor executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; ++i) {
			int taskId = i;
			Runnable task = () -> {
				for (int j = 0; j < 1000; ++j) {
					++count;
					System.out.println(taskId + ": " + count);
				}
				

			};
			executor.execute(task);
		}
	}

}
