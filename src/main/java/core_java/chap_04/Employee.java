package core_java.chap_04;

public class Employee implements Cloneable {

	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public void raiseSalary(double amount) {
		this.salary += amount;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public boolean worksFor(Employee supervisor) {
		return true;
	}
	
	public Employee getSupervisor() {
		return null;
	}
	
	public final String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + "[name=" + name + ", salary=" + salary + "]";
	}
	
	@Override
	public Employee clone() throws CloneNotSupportedException {
		return (Employee) super.clone();
	}

}
