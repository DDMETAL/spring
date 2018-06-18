package test;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.ExampleBean;
import basic.LazyBean;
import basic.ScopeBean;
import ioc.A;
import ioc.Restaurant;
import ioc2.Manager;
import value.SomeBean;
import value.ValueBean;

public class TestCase {
	@Test
	//测试生命周期
	public void test1() {
		String config="basic.xml";
		/*
		 * 因为ApplicationContext接口没有提供close方法，所以需要使用其子接口
		 * AbstractApplicationContext
		 */
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
		ExampleBean eb=ac.getBean("eb",ExampleBean.class);
		eb.service();
		ac.close();
	}
	
	@Test
	//测试作用域
	public void test2() {
		String config="basic.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		ScopeBean sb1=ac.getBean("sb",ScopeBean.class);
		ScopeBean sb2=ac.getBean("sb",ScopeBean.class);
		System.out.println(sb1==sb2);
	}
	
	@Test
	//测试延迟加载
	public void test3() {
		String config="basic.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
	}
	
	@Test
	//测试set方法注入
	public void test4() {
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		A a1=ac.getBean("a1",A.class);
		a1.service();
	}
	
	@Test
	//测试构造器注入
	public void test5() {
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Restaurant r1=ac.getBean("r1",Restaurant.class);
		System.out.println(r1);
	}
	
	@Test
	//测试自动装配
	public void test6() {
		String config="ioc2.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Manager mg=ac.getBean("mg",Manager.class);
		System.out.println(mg);
	}
	
	@Test
	//测试注入基本类型的值
	//测试使用list,set,map,props注入集合类型的值
	//测试以引入方式注入集合类型的值
	public void test7() {
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		ValueBean eb1=ac.getBean("eb2",ValueBean.class);
		System.out.println(eb1);
	}
	
	@Test
	//测试 读取.properties文件
	public void test8() {
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Properties props=ac.getBean("config",Properties.class);
		System.out.println(props);
	}
	
	@Test
	//测试 使用spring表达式访问其他bean的属性值
	public void test9() {
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		SomeBean sb1=ac.getBean("sb1",SomeBean.class);
		System.out.println(sb1);
	}
	
	@Test
	//测试 连接池
	public void test10() throws SQLException {
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		
		/*
		 * javax.sql.DataSource是一个接口，
		 * BasicDataSource实现了该接口
		 */
//		BasicDataSource ds=ac.getBean("ds",BasicDataSource.class);
		DataSource ds=ac.getBean("ds",DataSource.class);
		System.out.println(ds.getConnection());
	}
}
