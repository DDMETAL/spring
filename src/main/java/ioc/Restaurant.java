package ioc;

public class Restaurant {
	private Waiter waiter;
	
	public void setWaiter(Waiter waiter) {
		System.out.println("setWaiter()");
		this.waiter = waiter;
	}
	public Restaurant() {
		System.out.println("Restaurant()");
	}
	public Restaurant(Waiter waiter) {
		System.out.println("Restaurant(Waiter waiter)");
		this.waiter=waiter;
	}
	
	@Override
	public String toString() {
		return "Restaurant [waiter=" + waiter + "]";
	}
	
}
