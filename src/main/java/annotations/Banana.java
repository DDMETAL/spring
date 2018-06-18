package annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ba1")
@Scope("singleton")
@Lazy(true)
public class Banana {
	
	public Banana() {
		System.out.println("Banana()");
	}
	@PostConstruct
	public void init() {
		System.out.println("init()");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("destroy()");
	}
}
