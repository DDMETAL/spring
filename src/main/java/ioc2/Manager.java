package ioc2;

public class Manager {
	private Computer cp;
	
	public void setCp(Computer cp) {
		System.out.println("steCp()");
		this.cp = cp;
	}

	public Manager() {
		System.out.println("Manager()");
	}

	@Override
	public String toString() {
		return "Manager [cp=" + cp + "]";
	}
	
}
