package core_java.dummy;

public class Deadlock {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bow(Friend bower) {
            System.out.println(Thread.currentThread().getId() + ": " + this.name + ": " + bower.getName() + " has bowed to me!");
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.println(Thread.currentThread().getId() + ": " + this.name + ": " + bower.getName() + " has bowed back to me!");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; ++i) {
            final Friend a = new Friend("Minh");
            final Friend b = new Friend("Dung");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    a.bow(b);
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    b.bow(a);
                }
            }).start();
        }
    }
}
