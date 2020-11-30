package core_java.chap_07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex06 {

	public static void test(Map<String, ? extends Set<Integer>> map) {
		System.out.println("nothing");
	}
	
	public static void test2(Set<Integer> set) {
		System.out.println("nothing");
	}
	
	public static void test3(List<? extends Employee> ls, MyPredicate<? super Employee> pred) {
		for (Employee e : ls) {
			if (pred.myTest(e)) {
				System.out.println(e.getName());
			}
		}
	}
	
	public static void test4(ArrayList<? extends Employee> empls) {
		for (Employee em : empls) {
			
		}
	}
	
	public static <T> void printAll(T[] elements, MyPredicate<? super T> pred) {
		for (T e : elements) {
			if (pred.myTest(e)) {
				System.out.println(e.toString());
			}
		}
	}
	
	public static void main(String[] args) {
		
		Employee[] nums = new Manager[5];
//		nums[0] = new Employee();
		
		ArrayList<Manager> bosses = new ArrayList<>();
		ArrayList<? extends Employee> emps = new ArrayList<Manager>();
		ArrayList<Employee> empls = new ArrayList<>();
		empls.add(new Employee("Minh", 1000d));
		empls.add(new Employee("Dung", 2000d));
		empls.add(new Employee("Hoang", 3000d));
		empls.add(new Employee("Phuong", 4000d));
		empls.add(new Employee("Hanh", 5000d));
		

		ArrayList<Manager> mngs = new ArrayList<>();
		mngs.add(new Manager("Minh", 1000d));
		mngs.add(new Manager("Dung", 2000d));
		mngs.add(new Manager("Hoang", 3000d));
		mngs.add(new Manager("Phuong", 4000d));
		mngs.add(new Manager("Hanh", 5000d));
		
		test3(mngs, e -> e.getSalary() > 3000);
//		emps.add(null);
//		emps.add(null);
//		emps.add(null);
//		System.out.println(emps.size());
//		
//		for (Employee emp : empls) {
//			emp.print();
//		}
//		
//		
//		HashMap<String, HashSet<Integer>> myMap = new HashMap<String, HashSet<Integer>>();
//		HashSet<Integer> mySet = new HashSet<>();
//		test(myMap);
//		test2(mySet);
	}

}
