package core_java.dummy;

public class Dummy {
    private int num = 0;
    private int num2 = 0;

    public  void increase() throws InterruptedException {
        System.out.println("before increase: " + num2);
        num2++;
//        Thread.sleep(5);
        System.out.println("after increase: " + num2);
    }


    public synchronized void increase2() throws InterruptedException {
        System.out.println("before increase 2: " + num);
        num += 2;
//        Thread.sleep(5);
        System.out.println("after increase 2: " + num);
    }


    public synchronized void increase3() throws InterruptedException {
        System.out.println("before increase 3: " + num);
        num += 3;
//        Thread.sleep(5);
        System.out.println("after increase 3: " + num);
    }

    public synchronized void decrease() throws InterruptedException {
        System.out.println("before decrease: " + num);
        num--;
        Thread.sleep(10000);
        System.out.println("after decrease: " + num);
    }


    public synchronized void decrease2() throws InterruptedException {
        System.out.println("before decrease 2: " + num);
        num -= 2;
//        Thread.sleep(20);
        System.out.println("after decrease 2: " + num);
    }


    public synchronized void decrease3() throws InterruptedException {
        System.out.println("before decrease 3: " + num);
        num -= 3;
//        Thread.sleep(25);
        System.out.println("after decrease 3: " + num);
    }
}
