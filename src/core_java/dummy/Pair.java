package core_java.dummy;

import java.lang.reflect.Array;

public class Pair<T> {
    private T first;
    private T second;

    private T arr[];

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(Class<T> clazz, int capacity) {
        @SuppressWarnings("unchecked")
        final T[] arrFi = (T[]) Array.newInstance(clazz, capacity);
        arr = arrFi;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
