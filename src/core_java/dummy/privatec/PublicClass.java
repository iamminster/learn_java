package core_java.dummy.privatec;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PublicClass {
    PrivateClass pc;
    public PublicClass() {
        pc = new PrivateClass();
        pc.a = 10;
        pc.b = 100;

    }

    private static final PrivateClass[] VALS = {new PrivateClass(10), new PrivateClass(100), new PrivateClass(1000)};

    public static final PrivateClass[] vals() {
        return VALS.clone();
    }

    public static final List<PrivateClass> vals2() {
        return Collections.unmodifiableList(Arrays.asList(VALS));
    }

    public static void main(String[] args) {
        System.out.println(VALS[0].a);
        PrivateClass[] rs = vals();
        rs[0].a = 99;
        System.out.println(VALS[0].a);

    }

}
