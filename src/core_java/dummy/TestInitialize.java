package core_java.dummy;

import java.util.*;

import static java.util.Comparator.comparingInt;

public class TestInitialize {
    private static class FieldHolder {
        static final Integer field = computeFieldValue();
        private static Integer computeFieldValue() {
            System.out.println("computeFieldValue");
            return new Random().nextInt(100);
        }
    }
    private static Integer getField() {
        System.out.println("getField");
        return FieldHolder.field;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 5, 4, 7};
        List<Integer> numsLs = new ArrayList<>(Arrays.asList(nums));
//        Collections.sort(numsLs, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        Collections.sort(numsLs, (x, y) -> {
//            return x.compareTo(y);
//        });
        Collections.sort(numsLs,comparingInt(Integer::intValue));
        System.out.println(numsLs);
//        System.out.println("Start!");
//        System.out.println(new Random().nextBoolean());
//        System.out.println(getField());
//        System.out.println("End!");
//        while (true) {
//            System.out.println(1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}

class Test<T> {
    private T[] elements;
    private static int capacity = 10;
    public Test() {
        elements = (T[]) new Object[capacity];
    }
}



