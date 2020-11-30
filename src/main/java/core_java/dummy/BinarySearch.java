package core_java.dummy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (high + low) >>> 1;
            Comparable<? super T> midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }

        return -(low + 1);
    }

    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(5, 10, 15, 20, 25, 30);
        System.out.println(binarySearch(ls, 22));
        System.out.println(Collections.binarySearch(ls, 22));
    }

}
