package core_java.chap_04;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

	public static void printObj(Object obj) {
		System.out.println(obj.toString() + obj.getClass().toString());
	}

	public static int eval(Operation op, int arg1, int arg2) {
		int result = 0;

		switch (op) {
		case ADD:
			result = arg1 + arg2;
			break;
		case SUBTRACT:
			result = arg1 - arg2;
			break;
		case DIVIDE:
			result = arg1 / arg2;
			break;
		case MULTIPLY:
			result = arg1 * arg2;
			break;
		default:
			break;

		}
		return result;
	}

	public static void inspect(String className) throws ClassNotFoundException {
		Class<?> cl = Class.forName(className);

		while (cl != null) {
			for (Method m : cl.getDeclaredMethods()) {
				System.out.println(Modifier.toString(m.getModifiers()) + " " + m.getReturnType().getCanonicalName()
						+ " " + m.getName() + Arrays.toString(m.getParameters()));
			}
			cl = cl.getSuperclass();
		}
	}
	
	public static void inspectField(Object obj) throws IllegalArgumentException, IllegalAccessException {
		for (Field f : obj.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			Object value = f.get(obj);
			System.out.println(f.getName() + ":" + value);
		}
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Employee emp = new Employee("Minh", 100);
		Field f = emp.getClass().getDeclaredField("salary");
		f.setAccessible(true);
		double value = f.getDouble(emp);
		f.setDouble(emp, value * 2);
		System.out.println(emp.getSalary());
		
//		try {
//			inspect(Employee.class.getName());
//		} catch (ClassNotFoundException ex) {
//
//		}
//		for (Modifier m : Modifier.values()) {
//			System.out.println(m.getMask());
//		}
		Operation add = Operation.ADD;
		System.out.println(eval(add, 10, 40));
//		
//		System.out.println(add.eval(10, 20));

//		Message offer = new Message("MInh", "Hello");
//		try {
//			inspectField(offer);
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Message cloneOffer = offer.clone();
//		
//		Size notMySize = Size.valueOf("SMALL");
//		System.out.println(Size.LARGE.compareTo(Size.MEDIUM));
//		
//		Size[] allVals = Size.values();
//		
//		for (Size s : allVals) {
//			System.out.println(s.ordinal());
//		}
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Integer.MAX_VALUE);

//		Item i1 = new Item("book", 10d);
//		Item i2 = new Item("book", 10d);
//		System.out.println(i1.equals(i2));
//		System.out.println(i2.equals(i1));
//		
//		DiscountedItem di1 = new DiscountedItem("CD", 10, 10);
//		DiscountedItem di2 = new DiscountedItem("CD", 10, 10);
//		System.out.println(di1.equals(di2));

//		String[] arr1 = { "a", "b", "c" };
//		String[] arr2 = { "a", "b", "c" };
//
//		System.out.println(null == null);
//
//		System.out.println(arr1.equals(arr2));
//		System.out.println(Objects.equals(arr1, arr2));
//
//		System.out.println(Arrays.deepEquals(arr1, arr2));
//		System.out.println(Objects.deepEquals(arr1, arr2));
//
//		Manager boss = new Manager("Minh", 1000d);
//		boss.setBonus(30d);
//		Employee emp = boss;
//		System.out.println("" + null);
//		
//		Manager[] bosses = new Manager[10];
//		Employee[] emps = bosses;
//		emps[1] = new Employee("Dung", 500d);

//		ArrayList<String> names = new ArrayList<String>(100) {
//			public void add(int index, String element) {
//				super.add(index, element);
//				System.out.printf("Adding %s at %d\n", element, index);
//			}
//		};

//		names.add(0, "Minh");
//		names.add(1, "Dung");
//		names.add(2, "Hoang");
//		
//
//		names.add(0, "xxx");
//		names.add(1, "zzz");

//		Worker wk = new ConcurrentWorker();
//		wk.work();
//		for (int i = 0; i < 10; ++i) {
//			System.out.println("Main thread");
//		}
//		int[] i =  new int[] { 1, 2, 3, 4, 5};
//		int y = 10;
//		String msg = "test" + y;
//		printObj(msg);
	}

}
