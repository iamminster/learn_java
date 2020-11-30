package core_java.chap_06;

public class MyClosable implements AutoCloseable {
	private String name;
	
	public MyClosable(String name) {
		this.name = name;
	}

	@Override
	public void close() throws Exception {
		System.out.println("close " + name);
	}

}
