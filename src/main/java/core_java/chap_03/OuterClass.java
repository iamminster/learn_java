package core_java.chap_03;

public class OuterClass {

	public OuterClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static class StaticNestedClass {
		
	}
	
	public class InnerClass {
		
	}
	
	public InnerClass getInnerClass() {
		return new InnerClass();
	}
	
//	public static InnerClass getInnerClassStatically() {
//		return new InnerClass();
//	}
}

class OtherClass {
	private OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();
	
	private OuterClass outerClass = new OuterClass();
	private OuterClass.InnerClass innerClass = outerClass.getInnerClass();
	private OuterClass.InnerClass innerClass2 =  outerClass.new InnerClass();
	
}
