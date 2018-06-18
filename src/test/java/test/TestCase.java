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
	//������������
	public void test1() {
		String config="basic.xml";
		/*
		 * ��ΪApplicationContext�ӿ�û���ṩclose������������Ҫʹ�����ӽӿ�
		 * AbstractApplicationContext
		 */
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
		ExampleBean eb=ac.getBean("eb",ExampleBean.class);
		eb.service();
		ac.close();
	}
	
	@Test
	//����������
	public void test2() {
		String config="basic.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		ScopeBean sb1=ac.getBean("sb",ScopeBean.class);
		ScopeBean sb2=ac.getBean("sb",ScopeBean.class);
		System.out.println(sb1==sb2);
	}
	
	@Test
	//�����ӳټ���
	public void test3() {
		String config="basic.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
	}
	
	@Test
	//����set����ע��
	public void test4() {
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		A a1=ac.getBean("a1",A.class);
		a1.service();
	}
	
	@Test
	//���Թ�����ע��
	public void test5() {
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Restaurant r1=ac.getBean("r1",Restaurant.class);
		System.out.println(r1);
	}
	
	@Test
	//�����Զ�װ��
	public void test6() {
		String config="ioc2.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Manager mg=ac.getBean("mg",Manager.class);
		System.out.println(mg);
	}
	
	@Test
	//����ע��������͵�ֵ
	//����ʹ��list,set,map,propsע�뼯�����͵�ֵ
	//���������뷽ʽע�뼯�����͵�ֵ
	public void test7() {
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		ValueBean eb1=ac.getBean("eb2",ValueBean.class);
		System.out.println(eb1);
	}
	
	@Test
	//���� ��ȡ.properties�ļ�
	public void test8() {
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Properties props=ac.getBean("config",Properties.class);
		System.out.println(props);
	}
	
	@Test
	//���� ʹ��spring���ʽ��������bean������ֵ
	public void test9() {
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		SomeBean sb1=ac.getBean("sb1",SomeBean.class);
		System.out.println(sb1);
	}
	
	@Test
	//���� ���ӳ�
	public void test10() throws SQLException {
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		
		/*
		 * javax.sql.DataSource��һ���ӿڣ�
		 * BasicDataSourceʵ���˸ýӿ�
		 */
//		BasicDataSource ds=ac.getBean("ds",BasicDataSource.class);
		DataSource ds=ac.getBean("ds",DataSource.class);
		System.out.println(ds.getConnection());
	}
}
