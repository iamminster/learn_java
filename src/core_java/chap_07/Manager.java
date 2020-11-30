package core_java.chap_07;

public class Manager extends Employee {

	
	public Manager(String name, double salary) {
		super(name, salary);
	}

	@Override
	public void print() {
		System.out.println("manager");
	}
}
