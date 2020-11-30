package core_java.dummy;

public class IntegerCache {
    public static void main(String[] args) {
        Integer a = 1000, b = 1000;
        System.out.println(a == b);
        Integer c = 100, d = 100;
        System.out.println(c == d);
        Boolean t = true, r = true;
        System.out.println(t == r);
        Boolean q = new Boolean(true);
        Boolean w = new Boolean(true);
        System.out.println(q == w);
    }
}
