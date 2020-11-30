package core_java.dummy;

import java.util.concurrent.locks.ReentrantLock;

public class LockFairUnFair {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);

        for (int i = 0; i < 5; ++i) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; ++j) {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + ": " + finalI);
                        lock.unlock();
                    }
                }
            }).start();
        }
    }
}
