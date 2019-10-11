package core_java.chap_06;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		Entry<String, Integer> entry = new Entry<>("Minh", 19);

		String[] friends = new String[] { "Minh", "Dung", "Hoang" };

		Arrays01.<String>swap(friends, 0, 1);

		System.out.println(Arrays.toString(friends));

		ArrayList<MyClosable2> myClsArr = new ArrayList<>();
		myClsArr.add(new MyClosable2("num1"));
		myClsArr.add(new MyClosable2("num2"));
		myClsArr.add(new MyClosable2("num3"));

//		Arrays01.closeAll(myClsArr);

		MyClosable2[] acArr = (MyClosable2[]) myClsArr.toArray(new MyClosable2[myClsArr.size()]);
		MyClosable[] mc1Arr = acArr;
		MyClosable mc2 = new MyClosable("num4-2");
//		mc1Arr[2] =  mc2;
//		Arrays01.closeAll(acArr);

		ArrayList<Employee> staff = new ArrayList<>();
		staff.add(new Employee("Minh", 1000));
		staff.add(new Employee("Dung", 2000));
		staff.add(new Employee("Huong", 3000));

//		Arrays01.<Employee>printNames(staff, e -> e.getSalary() > 1000);
		
		Predicate<Employee> salaryFilter = e -> e.getSalary() > 1000;
		

		Predicate<Object> nameFilter = e -> e.toString().contains("Minh");
		
		Arrays01.printAll(staff, salaryFilter);
		Arrays01.printAll(staff, nameFilter);

//		tentimes(new PrintHello());

	}

	public static void tentimes(Runnable r) {
		for (int i = 0; i < 10; ++i) {
			r.run();
		}
	}

}
