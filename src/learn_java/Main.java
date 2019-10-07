package learn_java;

import java.awt.List;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public void printTest(Test t) {
		System.out.println("This is test 1");
		
	}
	
	public void printTest(Test2 t2) {
		System.out.println("This is test 2");
	}
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 2, 3, 4, 5};
		for (int i : num) {
			System.out.println(i);
		}
		
		int[] copies = Arrays.copyOf(num, num.length);
		copies[1] = 100;
		System.out.println(copies[1]);
		
		Test t1 = new Test(10, 20);
		Test t2 = new Test(1, 2);
		Test2 t3 = new Test2();

		System.out.println("z = " + t3.z);
		
//		plusOne(t1, t2);
//		System.out.println(t1.x);
//		System.out.println(t1.y);
//		System.out.println(t2.x);
//		System.out.println(t2.y);
		
		Test[] tests = {t1, t2};
		plusOne(tests);
		System.out.println(tests[0].x);
		System.out.println(tests[0].y);
		System.out.println(tests[1].x);
		System.out.println(tests[1].y);
		System.out.println(t1.Test(10000, 0));
		
		Main m = new Main();
		m.printTest(t1);
		m.printTest(t2);
		m.printTest((Test)t3);
	
		NumberFormat nf;
		
	}
	
	public static void plusOne(Test... tests) {
		for (Test test : tests) {
			test.x++;
			test.y++;
		}
		return;
	}
	

}
