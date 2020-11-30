package core_java.dummy;

import java.util.ArrayList;
import java.util.Objects;

public class Stack<E> {

    private E[] arr;
    private int size = 0;

    public Stack() {
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized E push(E elem) {
        if (size == 0) {
            arr = (E[]) new Object[1];
        } else if (arr.length == size) {
            arr = copy(arr, (E[]) new Object[arr.length * 2]);
        }
        arr[size] = elem;
        size += 1;

        return elem;
    }

    public synchronized E pop() {
        if (size == 0) {
            return null;
        }
        else {
            size -= 1;
            return arr[size];
        }
    }

    private E[] copy(E[] before, E[] after) {
        for (int i = 0; i < before.length; ++i) {
            after[i] = before[i];
        }
        return after;
    }
}
