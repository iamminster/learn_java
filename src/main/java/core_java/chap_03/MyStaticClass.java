package core_java.chap_03;

public final class MyStaticClass {

	public static int x;
	
	private MyStaticClass() {
		x = 10000;
	}
	
	
	public static int getX() {
		return x;
	}
	
	public static void setX(int x) {
		MyStaticClass.x = x; 
	}
	
	public static void main(String[] args) {
		System.out.println(MyStaticClass.getX());
		MyStaticClass.setX(100);
		System.out.println(MyStaticClass.getX());
		MyStaticClass msc = new MyStaticClass();
		System.out.println(msc.getX());
	}

}
