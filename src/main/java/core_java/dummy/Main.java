package core_java.dummy;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

public class Main {

    public static final int STEPS = 100;

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(2/4);
        System.out.println(2%4);
//        Dummy dm = new Dummy();
//        Runnable decrease = () -> {
//            for (int i = 0; i < STEPS; ++i) {
//                try {
//                    dm.decrease();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        Runnable increase = () -> {
//            for (int i = 0; i < STEPS; ++i) {
//                try {
//                    dm.increase();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        Runnable decrease2 = () -> {
//            for (int i = 0; i < STEPS; ++i) {
//                try {
//                    dm.decrease2();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        Runnable increase2 = () -> {
//            for (int i = 0; i < STEPS; ++i) {
//                try {
//                    dm.increase2();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        Runnable decrease3 = () -> {
//            for (int i = 0; i < STEPS; ++i) {
//                try {
//                    dm.decrease3();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        Runnable increase3 = () -> {
//            for (int i = 0; i < STEPS; ++i) {
//                try {
//                    dm.increase3();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        var t1 = new Thread(decrease);
//        var t2 = new Thread(increase);
//        var t3 = new Thread(decrease2);
//        var t4 = new Thread(increase2);
//        var t5 = new Thread(decrease3);
//        var t6 = new Thread(increase3);
////        var t7 = new Thread(decrease);
////        var t8 = new Thread(increase);
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
//        t7.start();
//        t8.start();
//        Stack<Integer> stack = new Stack<Integer>();
//        System.out.println(stack.isEmpty());
//        stack.push(10);
//        stack.push(20);
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//
//        int[] a = {1, 2, 3, 4, 5};
//        System.arraycopy(a, 1, a, 0, 1);
//        for (int i : a)
//            System.out.println(i);

//        Integer i;
//        String[] words = {"hello", "I", "am", "Minh"};
//        Pair<String> minmax = ArrayArg.minmax(words);
//        System.out.println(minmax.getFirst());
//        System.out.println(minmax.getSecond());
//
//        double midlde = ArrayArg.getMiddle(3.14f, 1729f, 0f);
//        System.out.println(midlde);
//        System.out.println(ArrayArg.getMiddle("Minh", "Nguyen", "Ngoc"));
//        System.out.println(ArrayArg.getMiddle(3.14, 1729, "Morning", null, "Hello"));
//
//        Pair<String>[] pairs = new Pair[]{null, null};
////        System.out.println(ArrayArg.min(new Pair<String>[] {null, null}));
//
//        var interval = new DateInterval();
//        Pair<LocalDate> pair = interval;
//        pair.setSecond(LocalDate.now().minusDays(-2));
//
//        System.out.println(pair.getSecond());
//
//        Object a = new Object();
//        System.out.println(a);
//        ArrayList<String> arr;
//        final Class<String> stringClass = String.class;
//
//        Pair<Integer> aa = new Pair<Integer>();
//        Pair<String> bb = new Pair<String>();
//        System.out.println(aa.getClass());
//        System.out.println(aa.getClass() == bb.getClass());
//
////        var table = (Pair<String>[]) new Object[10];
////        Object[] objarr = table;
////        objarr[0] = new Pair<Integer>(1, 2);
////        System.out.println(table[0].getFirst());
//
//        Pair<String> pp = ArrayArg.makePair(String::new);
//        System.out.println(pp.getFirst());
//
//        Pair<DateInterval> ppp = ArrayArg.makePair(DateInterval.class);
//        System.out.println(ppp.getFirst().getFirst().toString());
    }
}

class ArrayArg {

    public static <T> Pair<T> makePair(Supplier<T> constr) {
        return new Pair<>(constr.get(), constr.get());
    }

    public static <T> Pair<T> makePair(Class<T> cls) {
        try {
            return new Pair<>(cls.getConstructor().newInstance(), cls.getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @SafeVarargs
    public static <T> void addAll(Collection<T> collection, T... ts) {
        for (T t : ts) collection.add(t);
    }

    public static Pair<String> minmax(String[] words) {
        if (words == null || words.length == 0)
            return null;
        String min = words[0];
        String max = words[0];

        for (int i = 1; i < words.length; ++i) {
            if (min.compareTo(words[i]) > 0) min = words[i];
            if (max.compareTo(words[i]) < 0) max = words[i];
        }
        return new Pair<>(min, max);
    }

    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length == 0)
            return null;
        T smallest = a[0];

        for (int i = 1; i < a.length; ++i) {
            if (smallest.compareTo(a[i]) > 0)
                smallest = a[i];
        }
        return smallest;
    }
}
