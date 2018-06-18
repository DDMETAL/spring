package ioc;

public class A {
	private Interface b;
	
	public void setB(Interface b) {
		System.out.println("setB()");
		this.b = b;
	}
	public A() {
		System.out.println("A()");
	}
	public void service() {
		System.out.println("A's service()");
		b.f1();
	}
}
