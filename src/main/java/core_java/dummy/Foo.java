package core_java.dummy;

import java.util.concurrent.BlockingQueue;

public class Foo {

    private volatile int anchor = 1;
    public static int FIRST = 1;
    public static int SECOND = 2;
    public static int THIRD = 3;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        while (anchor != FIRST) {
        }
        anchor = SECOND;
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (anchor != SECOND) {
        }
        anchor = THIRD;
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (anchor != THIRD) {
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}


