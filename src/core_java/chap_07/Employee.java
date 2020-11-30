package core_java.chap_07;

public class Employee {
	
	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public void print() {
		System.out.println("employee");
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
}
