package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotations.Banana;
import annotations.Book;
import annotations.Leader;
import annotations.Manager;
import annotations.Student;

public class TestCase2 {
	@Test
	//≤‚ ‘ ◊Èº˛…®√Ë
	public void test1() {
		String config="annotations.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Banana banana=ac.getBean("ba1",Banana.class);
		System.out.println(banana);
	}
	
	@Test
	//≤‚ ‘ …˙√¸÷‹∆⁄
	public void test2() {
		String config="annotations.xml";
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Banana banana=ac.getBean("ba1",Banana.class);
		ac.close();
	}
	
	@Test
	//≤‚ ‘ ◊˜”√”Ú
	public void test3() {
		String config="annotations.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Banana banana=ac.getBean("ba1",Banana.class);
		Banana banana2=ac.getBean("ba1",Banana.class);
		System.out.println(banana==banana2);
	}
	
	@Test
	//≤‚ ‘ —”≥Ÿº”‘ÿ
	public void test4() {
		String config="annotations.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
	}
	
	@Test
	//≤‚ ‘  @Autowired @Qualifier
	public void test5() {
		String config="annotations.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Manager mg=ac.getBean("mg",Manager.class);
		System.out.println(mg);
		
		Leader ld=ac.getBean("ld",Leader.class);
		System.out.println(ld);
	}
	
	@Test
	//≤‚ ‘ @Resource
	public void test6() {
		String config="annotations.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Student stu=ac.getBean("stu",Student.class);
		System.out.println(stu);
	}
	
	@Test
	//≤‚ ‘ @Value
	public void test7() {
		String config="annotations.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Book book=ac.getBean("book",Book.class);
		System.out.println(book);
	}
}
