package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("mg")
public class Manager {
	@Autowired
	@Qualifier("cp")
	private Computer cp;
	
//	@Autowired
//	public void setCp(@Qualifier("cp")Computer cp) {
//		System.out.println("setCp()");
//		this.cp = cp;
//	}
	public Manager() {
		System.out.println("Manager()");
	}
	@Override
	public String toString() {
		return "Manager [cp=" + cp + "]";
	}
	
}

