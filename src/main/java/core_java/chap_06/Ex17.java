package core_java.chap_06;

public class Ex17 {

	public static class Employee implements Comparable<Employee> {

		private String name;
		private double salary;

		public Employee(String name, double salary) {
			this.setName(name);
			this.setSalary(salary);
		}

		@Override
		public int compareTo(Employee o) {
			return this.name.compareTo(o.name);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

	}
}
