package core_java.chap_04;

public class Student extends Person {
	private int id;

	public Student(String name, int id) {
		super(name);
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}

}
