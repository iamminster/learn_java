package core_java.dummy;

import java.util.concurrent.*;

public class BlockQueue {

    public static int N_PROD = 4;
    public static int N_CON = Runtime.getRuntime().availableProcessors();
    static Integer poisonPill = Integer.MAX_VALUE;
    static int capacity = 10;

    public static void main(String[] args) {
        System.out.println(N_CON);
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(capacity);

        for (int i = 0; i < N_PROD; ++i) {
            new Thread(new NumbersProducer(queue, poisonPill)).start();
        }

        for (int j = 0; j < N_CON; ++j) {
            new Thread(new NumbersConsumer(queue, poisonPill)).start();
        }
    }
}


class NumbersProducer implements Runnable {

    public static final int COUNTER = 100;
    private Integer poisonPill;
    private BlockingQueue<Integer> queue;

    public NumbersProducer(BlockingQueue<Integer> queue, Integer poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            generateNumbers();

            System.out.println(Thread.currentThread().getName() + ": Finish producing numbers");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void generateNumbers() throws InterruptedException {
        for (int i = 0; i < COUNTER; ++i) {
            Integer num = ThreadLocalRandom.current().nextInt(10);
            queue.put(num);
        }
    }
}

class NumbersConsumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private Integer poisonPill;

    public NumbersConsumer(BlockingQueue<Integer> queue, Integer poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            try {
                Integer num = queue.poll(5, TimeUnit.SECONDS);
                if (num == null || num.equals(poisonPill)) {
                    System.out.println(Thread.currentThread().getName() + ": Finish consuming numbers");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + ": " + num);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}