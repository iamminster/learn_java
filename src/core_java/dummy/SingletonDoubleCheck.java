package core_java.dummy;

public class SingletonDoubleCheck {
    private volatile static SingletonDoubleCheck instance;

    private SingletonDoubleCheck() {
    }

    public static SingletonDoubleCheck getInstance() {
        SingletonDoubleCheck result = instance;
        if (result == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (instance == null)
                    result = instance = new SingletonDoubleCheck();
            }
        }
        return result;
    }
}
