package core_java.chap_04;

public class Main {

	public static void main(String[] args) {
		Manager boss = new Manager("Minh", 1000d);
		boss.setBonus(30d);
		Employee emp = boss;
		System.out.println(emp.getSalary());
		
		Manager[] bosses = new Manager[10];
		Employee[] emps = bosses;
		emps[1] = new Employee("Dung", 500d);
	}

}
