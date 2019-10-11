package core_java.chap_04;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
	}
	
	public Object createInstance(String className, ClassLoader loader) throws ClassNotFoundException {
		Class<?> cl = Class.forName(className, true, loader);
		// do something
		return null;
	}

	public Object createInstance(String className) throws ClassNotFoundException {
		Thread currentThread = Thread.currentThread();
		ClassLoader currentCL = currentThread.getContextClassLoader();
		Class<?> cl = Class.forName(className, true, currentCL);
		// do something
		return null;
	}
}
