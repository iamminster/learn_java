package core_java.chap_03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;

public class Ex01 {

	public static double average(Measurable[] objects) {
		OptionalDouble result = Arrays.asList(objects).parallelStream().mapToDouble(o -> o.getMeasure()).max();
		return result.isPresent() ? result.getAsDouble() : 0d;
	}
	
	public static String largest(Measurable[] objects) {
		Optional<Ex01.Measurable> largest = Arrays.asList(objects).parallelStream().max(Comparator.comparingDouble(Ex01.Measurable::getMeasure));
		return (largest.isPresent() && largest.get() instanceof Ex01.Employee && ((Ex01.Employee)largest.get()).getName() != null) ? ((Ex01.Employee)largest.get()).getName() : "";
	}
	
	interface Measurable {
		double getMeasure();
	}

	public static class Employee implements Measurable {
		private double salary;
		private String name;

		public Employee(double salary) {
			this.salary = salary;
		}
		
		public Employee(double salary, String name) {
			this.salary = salary;
			this.name = name;
		}
		
		@Override
		public double getMeasure() {
			return salary;
		}
		
		public String getName() {
			return name;
		}
	}
}
