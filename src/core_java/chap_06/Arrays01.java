package core_java.chap_06;

import java.util.ArrayList;

public class Arrays01 {

	public Arrays01() {
	}

	public static <T> void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static <T extends AutoCloseable> void closeAll(ArrayList<T> arr) throws Exception {
		for (T elem : arr) {
			elem.close();
		}
	}

	public static void closeAll(AutoCloseable[] arr) throws Exception {
		for (AutoCloseable elem : arr) {
			elem.close();
		}
	}

	public static void printNames(ArrayList<? extends Employee> staff) {
		for (int i = 0; i < staff.size(); ++i) {
			Employee e = staff.get(i);
			System.out.println(e.getName());
		}
		Employee newEmp = new Employee("Hoang", 1234);
		Manager newMng = new Manager("Hung", 5678);

//		staff.add(newEmp);

	}

	public static <T> void printNames(ArrayList<T> staff, Predicate<T> filter) {
		for (T elem : staff) {
			if (filter.test(elem)) {
				System.out.println(elem);
			}
		}
	}
	
	public static void printAll(ArrayList<Employee> staff, Predicate<? super Employee> filter) {
		for (Employee e : staff) {
			if (filter.test(e)) {
				System.out.println(e);
			}
		}
	}

}
