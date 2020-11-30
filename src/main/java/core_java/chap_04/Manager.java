package core_java.chap_04;

public class Manager extends Employee {

	private double bonus;
	
	public Manager(String name, double salary) {
		super(name, salary);
		bonus = 0;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public double getSalary() {
		return super.getSalary() + bonus;
	}
	
	@Override
	public boolean worksFor(Employee supervisor) {
		return false;
	}
	
	@Override
	public Manager getSupervisor() {
		return null;
	}
	
	@Override
	public String toString() {
		return super.toString() + "[bonus=" + bonus + "]";
	}

}
